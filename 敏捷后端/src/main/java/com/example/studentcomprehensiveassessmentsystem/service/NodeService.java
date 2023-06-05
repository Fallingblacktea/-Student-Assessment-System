package com.example.studentcomprehensiveassessmentsystem.service;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginReqVO;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.LoginReqDO;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.LoginMapper;
import com.example.studentcomprehensiveassessmentsystem.mapper.Interface.NodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeService {
    @Autowired
    private NodeMapper nodeMapper;

    public int[] idService(String username){
        return nodeMapper.findNodesID(username);
    }
    public List<String> nameService(String username){
        return nodeMapper.findNodesName(username);
    }
}
