package chauncy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chauncy.dao.VideoTypeMapper;
import chauncy.entity.VideoType;
import chauncy.service.VideoTypeServive;

@Service
public class VideoTypeServiceImpl implements VideoTypeServive {
	
	@Autowired
	private VideoTypeMapper videoTypeMapper;

	@Override
	public List<VideoType> getVideoTypes(VideoType videoType) {
		return videoTypeMapper.selectList(videoType);
	}

}
