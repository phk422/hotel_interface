package com.school.hotel.service.impl;

import com.school.hotel.mapper.VoMapper;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.vo.CheckinVo;
import com.school.hotel.service.VoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/16
 **/
@Slf4j
@Service
public class VoServiceImpl implements VoService {
    @Autowired
    private VoMapper mapper;
    @Override
    public Object getCheckinVo(PageBean pageBean, String name, String mobile, String idCard, Long roomId, Long roomTypeId, Integer status) {
        if (pageBean == null) return mapper.getCheckinVo();
        // 查询总记录数
        Integer totalCount = getTotalCount(name, mobile,idCard, roomId, roomTypeId, status);
        // 获取当前页码
        Integer currentPage = pageBean.getCurrentPage();
        log.info("当前页码：" + currentPage);
        // 获取当前pageSize
        Integer pageSize = pageBean.getPageSize();
        Integer totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        Integer startPage = (currentPage - 1) * pageSize;
        List<CheckinVo> voList = mapper.getCheckinVo(startPage, pageSize, name, mobile, idCard, roomId, roomTypeId, status);
        pageBean.setTotalPage(totalPage);
        pageBean.setTotalCount(totalCount);
        pageBean.setList(voList);
        return pageBean;
    }

    private Integer getTotalCount(String name, String mobile, String idCard, Long roomId, Long roomTypeId, Integer status) {
        return mapper.getTotalCount(name, mobile, idCard, roomId, roomTypeId, status);
    }
}
