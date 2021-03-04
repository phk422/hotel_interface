package com.school.hotel.mapper;

import com.school.hotel.pojo.Room;
import org.apache.ibatis.annotations.Param;

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
}
