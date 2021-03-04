package com.school.hotel.mapper;

import com.school.hotel.pojo.Room;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public interface RoomMapper {

    /**
     * 获取房间
     * @param startPage
     * @param pageSize
     * @param roomTypeId
     * @param floorId
     * @param status
     * @return
     */
    List<Room> getRooms(@Param("startPage") Integer startPage,
                        @Param("pageSize") Integer pageSize,
                        @Param("roomTypeId") Long roomTypeId,
                        @Param("floorId") Long floorId,
                        @Param("status") Long status,
                        @Param("sn") String sn);

    /**
     * 获取房间总数
     * @param roomTypeId
     * @param floorId
     * @param status
     * @return
     */
    Integer getTotalCount(@Param("roomTypeId") Long roomTypeId,
                          @Param("floorId") Long floorId,
                          @Param("status") Long status,
                          @Param("sn") String sn);

    /**
     * 修改room
     * @param room
     * @return
     */
    int updateRoom(Room room);

    /**
     * 根据id删除房间
     * @param id
     * @return
     * @throws DataAccessException
     */
    int deleteRoomById(Long id) throws DataAccessException;

    /**
     * 添加房间
     * @param room
     * @return
     */
    int addRoom(Room room);
}
