package com.school.hotel.service;

import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.Room;


public interface RoomService {

    Object getRooms(PageBean pageBean, Long roomTypeId, Long floorId, Long status, String sn);

    int updateRoom(Room room);

    int deleteRoom(Room room);
}
