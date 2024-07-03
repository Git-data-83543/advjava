package com.sunbeam.service;

import java.util.List;

import com.sunbeam.dto.TagsDTO;

public interface TagService {
   TagsDTO addTags(TagsDTO tag);
   List<TagsDTO> allTags();
}
