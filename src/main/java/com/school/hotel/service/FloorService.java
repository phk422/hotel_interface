package com.school.hotel.service;

import com.school.hotel.pojo.Floor;

import java.util.List;

public interface FloorService {
    int addFloor(Floor floor);
    /**
     * 获取所有楼层信息
     * @return
     */
    List<Floor> getFloors(String name);

    /**
     * 修改楼层信息
     * @param floor
     * @return
     */
    int updateFloor(Floor floor);

    /**
     * 根据id删除楼层
     * @param id
     * @return
     */
    int deleteFloorById(Long id);
}
