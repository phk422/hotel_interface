package com.school.hotel.service;

import com.school.hotel.pojo.PageBean;
import com.school.hotel.pojo.Room;
import org.springframework.dao.DataAccessException;

import java.io.FileNotFoundException;


public interface RoomService {

    Object getRooms(PageBean pageBean, Long roomTypeId, Long floorId, Long status, String sn);

    int updateRoom(Room room);

    int deleteRoom(Room room);

    int addRoom(Room room) throws DataAccessException, FileNotFoundException;
}
