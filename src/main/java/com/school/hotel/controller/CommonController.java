package com.school.hotel.controller;

import com.school.hotel.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
    /**
     * 头像上传接口
     * @param file
     * @param req
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file, HttpServletRequest req)
            throws IllegalStateException, IOException {
        // 判断文件是否为空，空则返回失败页面
        if (file.isEmpty()) {
            log.info("文件上传失败");
            return Result.success("文件上传失败！");
        }
        String pathOne = ResourceUtils.getURL("classpath:").getPath()+"static/img";
        String path = pathOne.replace('/', '\\').substring(1,pathOne.length());
        //用于查看路径是否正确
        log.info(path);
        // 获取源文件名称
        String fname = file.getOriginalFilename();
        // 截取文件后缀
        String beforeStr = fname.substring(0,fname.indexOf("."));
        String lastStr = fname.substring(beforeStr.length(),fname.length());
        // 随机获取不重复的名称
        String fileName = UUID.randomUUID().toString().substring(0, 16) + lastStr;
        // 创建文件实例
        File filePath = new File(path, fileName);
        // 如果文件目录不存在，创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
//            System.out.println("创建目录" + filePath);
        }
        // 写入文件
        file.transferTo(filePath);
        log.info("上传成功！");
        return Result.success("/img/" + fileName); // 文件名返回给前端
    }
}
