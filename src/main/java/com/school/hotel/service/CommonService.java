package com.school.hotel.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CommonService {
    /**
     * 文件上传
     * @param file
     * @return
     */
    String upload(MultipartFile file) throws IOException;

    /**
     * 删除图片
     * @param imgName
     * @return
     */
    String deleteImgByPath(String imgName) throws FileNotFoundException;
}
