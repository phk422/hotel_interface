package com.school.hotel.service.impl;

import com.school.hotel.mapper.RoomMapper;
import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.Room;
import com.school.hotel.service.CommonService;
import com.school.hotel.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/4
 **/
@Slf4j
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper mapper;
    @Autowired
    private CommonService commonService;
    @Override
    public Object getRooms(PageBean pageBean, Long roomTypeId, Long floorId, Long status, String sn) {
        if (sn != null && sn.length() < 1) sn = null;
        if (pageBean == null) {
            return mapper.getRooms(null, null, roomTypeId, floorId, status, sn);
        }
        // 查询总记录数
        Integer totalCount = getTotalCount(roomTypeId, floorId, status, sn);
        // 获取当前页码
        Integer currentPage = pageBean.getCurrentPage();
        log.info("当前页码：" + currentPage);
        // 获取当前pageSize
        Integer pageSize = pageBean.getPageSize();
        Integer totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        Integer startPage = (currentPage - 1) * pageSize;
        List<Room> rooms = mapper.getRooms(startPage, pageSize, roomTypeId, floorId, status, sn);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        pageBean.setList(rooms);
        return pageBean;
    }

    @Override
    public int updateRoom(Room room) {
        return mapper.updateRoom(room);
    }

    @Override
    public int deleteRoom(Room room) {
        try {
            int i = mapper.deleteRoomById(room.getId());
            String res = commonService.deleteImgByPath(room.getPhoto());
            log.info(res);
            return i;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (DataAccessException e) {
            return -1;
        }
    }

    @Override
    public int addRoom(Room room) throws FileNotFoundException {
        try {
            int i = mapper.addRoom(room);
            return i;
        } catch (DataAccessException e) {
            // 删除头像
            commonService.deleteImgByPath(room.getPhoto());
            throw new RuntimeException("添加房间异常，");
        }
    }

    private Integer getTotalCount(Long roomTypeId, Long floorId, Long status, String sn) {
        return mapper.getTotalCount(roomTypeId, floorId, status, sn);
    }

}
