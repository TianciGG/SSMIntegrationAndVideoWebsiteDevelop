package chauncy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chauncy.dao.VideoInfoMapper;
import chauncy.entity.VideoInfo;
import chauncy.service.VideoInfoService;

@Service
public class VideoInfoServiceImpl implements VideoInfoService {
	
	@Autowired
	private VideoInfoMapper videoInfoMapper;
	
	@Override
	public List<VideoInfo> getVideoInfos(VideoInfo videoInfo){
		return videoInfoMapper.selectAll(videoInfo);
	}
}
