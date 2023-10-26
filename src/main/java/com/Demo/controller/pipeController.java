package com.Demo.controller;

import com.Demo.Test02.PipelineFilter.Main03;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pipe")
public class pipeController {
    @Resource
    Main03 main03;
    @SneakyThrows
    @GetMapping("/{file}")
    public String userPipe(@PathVariable("file") String fileName){
        main03.main03(fileName);
        System.out.println("pipe运行了");
        return "成功运行";
    }

    @GetMapping("/picture")
    public String getPicture(){
        return "https://img-blog.csdnimg.cn/20201209233949962.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg1MzA5Nw==,size_16,color_FFFFFF,t_70#pic_center";
    }
}
