package chauncy.service;

import java.util.List;

import chauncy.entity.VideoType;

public interface VideoTypeServive {
	
	/**   
	 * @methodDesc: 功能描述(查询所有的视频类型)  
	 * @author: ChauncyWang
	 * @param: @return   
	 * @createTime: 2019年4月28日 下午1:47:19   
	 * @returnType: List<VideoType>  
	 */  
	public List<VideoType> getVideoTypes(VideoType videoType);
}
