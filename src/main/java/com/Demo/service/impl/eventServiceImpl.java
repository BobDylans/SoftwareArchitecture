package com.Demo.service.impl;

import com.Demo.Test02.eventSystem.Main01;
import com.Demo.Test02.eventSystem.eventService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class eventServiceImpl {
    @Resource
    eventService eventService;


    public void useEvent(String fileName){
        eventService.main01(fileName);
    }
}
