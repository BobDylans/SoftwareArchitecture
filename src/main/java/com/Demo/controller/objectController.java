package com.Demo.controller;

import com.Demo.Test02.PipelineFilter.Main03;
import com.Demo.Test02.objectOriented.Main02;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/object")
public class objectController {

    @Resource
    Main02 main02;
    @SneakyThrows
    @GetMapping("/{file}")
    public String userObject(@PathVariable("file") String fileName){
        main02.main02(fileName);
        System.out.println("object运行了");
        return "成功运行";
    }


    @GetMapping("/picture")
    public String getPicture(){
        return "https://img-blog.csdnimg.cn/20201209233922504.png#pic_center";
    }
}
