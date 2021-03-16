package com.school.hotel.service;

import com.school.hotel.pojo.PageBean;

public interface VoService {
    Object getCheckinVo(PageBean pageBean, String name, String mobile, String idCard,
                        Long roomId, Long roomTypeId, Integer status);
}
