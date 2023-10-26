package com.Demo.controller;

import com.Demo.Test02.MainProgramSubroutine.MainProgramSubroutine;
import jdk.jfr.internal.tool.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jws.Oneway;

@RestController
@RequestMapping
public class mainProgramController {
    @Resource
    MainProgramSubroutine mainProgramSubroutine;
    @GetMapping("/main/{file}")
    public String mainProgram(@PathVariable("file") String fileName){
        mainProgramSubroutine.main01(fileName);
        System.out.println("main运行了");
        return "成功运行";
    }

    @GetMapping("/picture")
    public String getPicture(){
        return "https://img-blog.csdnimg.cn/20201209233858758.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,size_16,color_FFFFFF,t_70#pic_center";
    }
}
