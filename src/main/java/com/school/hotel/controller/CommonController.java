package com.school.hotel.controller;

import com.school.hotel.pojo.Result;
import com.school.hotel.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/2
 **/
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {
    @Autowired
    private CommonService service;
    /**
     * 头像上传接口
     *
     * @param file
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file)
            throws IllegalStateException, IOException {
        String filePath = service.upload(file);
        return Result.success(filePath); // 文件名返回给前端
    }
}
