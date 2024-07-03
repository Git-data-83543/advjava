package com.sunbeam.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.dao.TagDao;
import com.sunbeam.dto.TagsDTO;
import com.sunbeam.entities.Tag;

@Service
@Transactional
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public TagsDTO addTags(TagsDTO tag) {
	//	tagDao.save(mapper.map(tag, Tag.class));
		return mapper.map(tagDao.save(mapper.map(tag, Tag.class)), TagsDTO.class);
	}

	@Override
	public List<TagsDTO> allTags() {
		return tagDao.findAll().stream().map(tag -> mapper.map(tag, TagsDTO.class)).collect(Collectors.toList());
	}

}
