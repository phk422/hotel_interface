package com.school.hotel.service.impl;

import com.school.hotel.mapper.RoomTypeMapper;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.RoomType;
import com.school.hotel.service.RoomTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/3
 **/
@Service
@Slf4j
public class RoomTypeServiceImpl implements RoomTypeService {
    @Autowired
    private RoomTypeMapper mapper;
    @Override
    public PageBean<RoomType> getRoomTypes(PageBean pageBean, String name, Integer status) {
        if (status == -1) status = null;
        name = name.replace("\"", "");
        // 查询总记录数
        Integer totalCount = getTotalCount(name, status);
        // 获取当前页码
        Integer currentPage = pageBean.getCurrentPage();
        log.info("当前页码：" + currentPage);
        // 获取当前pageSize
        Integer pageSize = pageBean.getPageSize();
        Integer totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        Integer startPage = (currentPage - 1) * pageSize;
        List<RoomType> roomTypes = mapper.getRoomTypes(startPage, pageSize, name, status);
        pageBean.setTotalPage(totalPage);
        pageBean.setTotalCount(totalCount);
        pageBean.setList(roomTypes);
        return pageBean;
    }

    @Override
    public int updateRoomType(RoomType roomType) {
        return mapper.updateRoomType(roomType);
    }

    private Integer getTotalCount(String name, Integer status) {
        return mapper.getTotalCount(name, status);
    }
}
