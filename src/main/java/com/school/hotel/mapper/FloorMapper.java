package com.school.hotel.mapper;

import com.school.hotel.pojo.Floor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FloorMapper {
    /**
     * 添加楼层
     * @param floor
     * @return
     */
    int addFloor(Floor floor);

    /**
     * 根据id删除楼层
     * @param id
     * @return
     */
    int deleteFloorById(@Param("id") Long id);

    /**
     * 修改楼层信息
     * @param floor
     * @return
     */
    int updateFloor(Floor floor);

    /**
     * 获取所有楼层信息
     * @return
     */
    List<Floor> getFloors(@Param("name") String name);
}
