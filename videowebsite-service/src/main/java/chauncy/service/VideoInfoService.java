package chauncy.service;

import java.util.List;

import chauncy.entity.VideoInfo;

public interface VideoInfoService {
	
	public List<VideoInfo> getVideoInfos(VideoInfo videoInfo);
	
	public VideoInfo getVideoInfo(int id);
	
	public int addVideo(VideoInfo videoInfo);
}
