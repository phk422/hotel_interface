package com.school.hotel.mapper;


import com.school.hotel.pojo.RoomType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomTypeMapper {

    /**
     * 获取房间类型
     * @param startPage
     * @param pageSize
     * @param name
     * @param status
     * @return
     */
    List<RoomType> getRoomTypes(@Param("startPage") Integer startPage,
                                @Param("pageSize") Integer pageSize,
                                @Param("name") String name,
                                @Param("status") Integer status);

    /**
     * 获取总记录数
     * @return
     */
    Integer getTotalCount(
            @Param("name") String name,
            @Param("status") Integer status);

    /**
     * 修改房型
     * @param roomType
     * @return
     */
    int updateRoomType(RoomType roomType);
}
