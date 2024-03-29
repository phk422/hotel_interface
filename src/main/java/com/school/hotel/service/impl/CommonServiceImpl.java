package com.school.hotel.service.impl;

import com.school.hotel.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/4
 **/
@Service
@Slf4j
public class CommonServiceImpl implements CommonService {
    @Override
    public String upload(MultipartFile file) throws IOException {
        // 判断文件是否为空，空则返回失败页面
        if (file.isEmpty()) {
            log.info("文件上传失败");
            return "文件上传失败！";
        }

        String pathOne = ResourceUtils.getURL("classpath:").getPath() + "static/img";
//        String pathOne = CommonServiceImpl.class.getClassLoader().getResource("static/img").getPath();
        log.info(pathOne);
        String path = pathOne.replace('/', '\\').substring(1, pathOne.length());
        //用于查看路径是否正确
        log.info(path);
        // 获取源文件名称
        String fname = file.getOriginalFilename();
        // 截取文件后缀
        String beforeStr = fname.substring(0, fname.indexOf("."));
        String lastStr = fname.substring(beforeStr.length(), fname.length());
        // 随机获取不重复的名称
        String fileName = UUID.randomUUID().toString().substring(0, 16) + lastStr;
        // 创建文件实例
        File filePath = new File(path, fileName);
        // 如果文件目录不存在，创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        // 写入文件
        file.transferTo(filePath);
        log.info("上传成功，文件名称为：" + fileName );
        // 返回文件名称
        return "/img/" + fileName;
    }

    @Override
    public String deleteImgByPath(String imgPath) throws FileNotFoundException {
        String pathOne = ResourceUtils.getURL("classpath:").getPath() + "static";
        String filePath = pathOne + imgPath;
        File file = new File(filePath);
        log.info("删除文件路径：" + filePath);
        if (file.exists()) {
            file.delete();
            return "文件删除成功！";
        } else  {
            log.debug(filePath + "不存在");
            return "文件不存在！";
        }
    }
}
