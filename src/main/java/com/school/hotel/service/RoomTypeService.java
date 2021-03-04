package com.school.hotel.service;

import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.RoomType;

public interface RoomTypeService {

    Object getRoomTypes(PageBean pageBean, String name, Integer status);

    int updateRoomType(RoomType roomType);

    int deleteRoomType(RoomType roomType);

    int addRoomType(RoomType roomType);
}
