package com.Demo.controller;


import com.Demo.Test02.eventSystem.eventService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/event")
public class eventController {
    @Resource
    eventService eventService;
    @GetMapping("/{file}")
    public String useEvent(@PathVariable("file") String fileName){
        eventService.main01(fileName);
        System.out.println("event运行了");
        return "成功运行";
    }

    @GetMapping("/picture")
    public String getPicture(){
        return "https://img-blog.csdnimg.cn/20201209233936983.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,size_16,color_FFFFFF,t_70#pic_center";
    }
}
