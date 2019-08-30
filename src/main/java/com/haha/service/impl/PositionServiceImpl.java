package com.haha.service.impl;

import com.alibaba.fastjson.JSON;
import com.haha.mapper.PositionMapper;
import com.haha.pojo.Position;
import com.haha.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("Position")
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;
    @Override
    public String SelectAll() {
        List<Position> list = positionMapper.selectAll();
        return JSON.toJSONString(list);
    }
}
