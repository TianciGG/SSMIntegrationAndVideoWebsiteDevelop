package chauncy.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import chauncy.entity.VideoInfo;
import chauncy.service.VideoInfoService;
import chauncy.service.VideoTypeServive;

@Controller
@RequestMapping("/VideoInfoController")
public class VideoInfoController {
	
	private static Logger logger = Logger.getLogger(VideoInfoController.class);

	
	@Autowired
	private VideoInfoService videoInfoService;
	@Autowired
	private VideoTypeServive videoTypeServive;
	
	private static final String INDEXVIDEO="indexVideo";
	private static final String VIDEODETAIL="videoDetail";
	private static final String ADDVIDEO="addVideo";
	
	
	/**   
	 * @methodDesc: 功能描述(查询所有视频)  
	 * @author: ChauncyWang
	 * @param: @param httpServletRequest
	 * @param: @param httpServletResponse
	 * @param: @return   
	 * @createTime: 2019年4月29日 下午3:47:28   
	 * @returnType: String  
	 */  
	@RequestMapping("/indexVideo")
	public String indexVideo(HttpServletRequest httpServletRequest,Integer pageIndex){
		//页数，一定要在dao方法之前使用，第一个参数：页数，不是limit默认起始值0，默认为1，代表limit的0，第二个参数：参数。分页公式：(页数-1)*长度。
		if(pageIndex == null){
			pageIndex=1;
		}
		Page page = PageHelper.startPage(pageIndex, 2);
		httpServletRequest.setAttribute("listVideo", videoInfoService.getVideoInfos(null));
		//获取分页总数
		httpServletRequest.setAttribute("pages", page.getPages());
		return INDEXVIDEO;
	}
	
	/**   
	 * @methodDesc: 功能描述(展示视频详情信息)  
	 * @author: ChauncyWang
	 * @param: @param request
	 * @param: @param id
	 * @param: @return   
	 * @createTime: 2019年5月8日 下午4:40:40   
	 * @returnType: String  
	 */  
	@RequestMapping("/getVideo")
	public String getVideo(HttpServletRequest request,Integer id){
		VideoInfo videoInfo = videoInfoService.getVideoInfo(id);
		request.setAttribute("videoInfo", videoInfo);
		return VIDEODETAIL;
	}
	
	@RequestMapping("/jumpToAddVideoPage")
	public String jumpToAddVideoPage(HttpServletRequest request){
		request.setAttribute("listVideoType",videoTypeServive.getVideoTypes(null));
		return ADDVIDEO;
	}
	
	@RequestMapping("/addVideo")
	public String addVideo(@RequestParam(value="file",required=false)MultipartFile file,VideoInfo videoInfo,HttpServletRequest request){
		//file.getOriginalFilename();//文件的原生名称
		String imageName=System.currentTimeMillis()+".png";//时间戳只是在单个JVM保证不重复，但是在分布式JVM会重复
		//项目环境地质
		String path=request.getSession().getServletContext().getRealPath("/static/imgs");
		File targetFile = new File(path,imageName);
		if(!targetFile.exists()){
			targetFile.mkdirs();//创建文件夹
			
		}
		try {
			//保存图片
			file.transferTo(targetFile);
		} catch (Exception e) {
			//打印日志一定要用e进行打印，不要用e.getMessage()，因为有时可能为空
			logger.error("saveImagesError--------->"+e);
			request.setAttribute("result", "上传图片失败！");
			return ADDVIDEO;
		}
		videoInfo.setVideoUrl(imageName);
		try {
			//videoInfo.toString()中videoInfo可以允许为空，不抛异常，直接打印空
			logger.info("###videoInfoService start... addVideo()###videoInfo:"+videoInfo.toString());
			int addVideoResult = videoInfoService.addVideo(videoInfo);
			//日志打印中={}表示对应一个参数，多个参数为：={},{}...逗号隔开
			logger.info("###videoInfoService end... addVideo()###addVideoResult={}"+addVideoResult);
			if(addVideoResult<=0){
				request.setAttribute("result", "保存数据错误！");
				return ADDVIDEO;
			}
			return "redirect:/indexVideo";
		} catch (Exception e) {
			//打印日志一定要用e进行打印，不要用e.getMessage()，因为有时可能为空
			logger.error("videoInfoServiceAddVideoError--------->"+e);
			request.setAttribute("result", "保存数据错误！");
			return ADDVIDEO;
		}
	}
}
