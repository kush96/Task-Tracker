package com.controller;
import com.dto.request.ProjectRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @RequestMapping(value = "/project",method = RequestMethod.POST)
    public String getPlatform(@RequestBody ProjectRequestDto requestDto){
        return null;
    }
}
