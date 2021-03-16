package com.school.hotel.mapper;

import com.school.hotel.pojo.vo.CheckinVo;

import java.util.List;

/**
 * 界面视图对象
 */
public interface VoMapper {
    List<CheckinVo> getCheckinVo(Integer startPage, Integer pageSize,
                                 String name, String mobile, String idCard,
                                 Long roomId, Long roomTypeId, Integer status);

    Integer getTotalCount(String name, String mobile, String idCard, Long roomId, Long roomTypeId, Integer status);

    List<CheckinVo> getCheckinVo();
}
