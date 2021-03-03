package com.school.hotel.service.impl;

import com.school.hotel.mapper.FloorMapper;
import com.school.hotel.pojo.Floor;
import com.school.hotel.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Autor Peng hk
 * @Date 2021/3/3
 **/
@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private FloorMapper mapper;
    @Override
    public int addFloor(Floor floor) {
        return mapper.addFloor(floor);
    }

    @Override
    public List<Floor> getFloors(String name) {
        return mapper.getFloors(name);
    }

    @Override
    public int updateFloor(Floor floor) {
        return mapper.updateFloor(floor);
    }

    @Override
    public int deleteFloorById(Long id) {
        return mapper.deleteFloorById(id);
    }
}
