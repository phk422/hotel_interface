package com.school.hotel.service.impl;

import com.school.hotel.mapper.RoomTypeMapper;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.RoomType;
import com.school.hotel.service.CommonService;
import com.school.hotel.service.RoomTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
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
    @Autowired
    private CommonService commonService;
    @Override
    public Object getRoomTypes(PageBean pageBean, String name, Integer status) {
        if (status == -1 && name == null && pageBean == null) {
            return mapper.getRoomTypes(null, null, null, null);
        }
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

    @Override
    public int deleteRoomType(RoomType roomType) {
        try {
            String res = commonService.deleteImgByPath(roomType.getPhoto());
            log.info(res);
            return mapper.deleteRoomTypeById(roomType.getId());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int addRoomType(RoomType roomType) {
        roomType.setAvilableNum(roomType.getLiveNum());
        roomType.setBookNum(0);
        roomType.setLivedNum(0);
        return mapper.addRoomType(roomType);
    }

    private Integer getTotalCount(String name, Integer status) {
        return mapper.getTotalCount(name, status);
    }
}
