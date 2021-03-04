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
}
