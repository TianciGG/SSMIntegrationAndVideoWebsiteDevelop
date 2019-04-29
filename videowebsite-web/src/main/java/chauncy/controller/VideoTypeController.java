package chauncy.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import chauncy.entity.VideoType;
import chauncy.service.VideoTypeServive;

@Controller
@RequestMapping("/VideoTypeController")
public class VideoTypeController {
	private static Logger logger = Logger.getLogger(VideoTypeController.class);
	
	private static final String TEST="test";
	
	@Autowired
	private VideoTypeServive videoTypeService;
	
	@RequestMapping("/hello")
	public String hello(){
		return TEST;
	}
	
	/**   
	 * @methodDesc: 功能描述(提供一个返回json格式的查询所有VideoType)  
	 * @author: ChauncyWang
	 * @param: @return   
	 * @createTime: 2019年4月28日 下午2:57:11   
	 * @returnType: List<VideoType>  
	 */  
	@RequestMapping("/getVideoTypeList")
	@ResponseBody
	public List<VideoType> getVideoTypeList(){
		List<VideoType> videoTypes = videoTypeService.getVideoTypes(null);
		for (VideoType videoType : videoTypes) {
			//System.out.println(videoType.toString());
			//生产不建议使用info级别的日志打印，因为日志冗余不太好。
			logger.info(videoType.toString());
		}
		return videoTypes;
	}
}
