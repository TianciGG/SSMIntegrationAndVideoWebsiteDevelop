package chauncy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import chauncy.service.VideoInfoService;

@Controller
@RequestMapping("/VideoInfoController")
public class VideoInfoController {
	
	@Autowired
	private VideoInfoService videoInfoService;
	
	private static final String INDEXVIDEO="indexVideo";
	
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
	public String indexVideo(HttpServletRequest httpServletRequest){
		//页数，一定要在dao方法之前使用，第一个参数：不是limit默认起始值0，默认为1，代表limit的0
		Page page = PageHelper.startPage(1, 2);
		httpServletRequest.setAttribute("listVideo", videoInfoService.getVideoInfos(null));
		return INDEXVIDEO;
	}
	
}
