package com.service.impl;

import com.dao.ProjectDao;
import com.dto.request.ProjectRequestDto;
import com.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;


    @Override
    public String createProject(ProjectRequestDto requestDto) {
        // validate input
//        validate
        return null;
    }
    private void validate(ProjectRequestDto requestDto){

    }
}
