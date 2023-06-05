package com.example.studentcomprehensiveassessmentsystem.mapper.Interface;

import com.example.studentcomprehensiveassessmentsystem.controller.VO.LoginReqVO;
import com.example.studentcomprehensiveassessmentsystem.mapper.DO.LoginReqDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NodeMapper {
    @Select("SELECT node.id FROM user "+
            "JOIN role_user ON user.id = role_user.user_id "+
            "JOIN role_node ON role_user.role_id = role_node.role_id "+
            "JOIN node ON role_node.node_id = node.id "+
            "WHERE user.username = #{username} "
            )
    int[] findNodesID(String username);

    @Select("SELECT node.name FROM user "+
            "JOIN role_user ON user.id = role_user.user_id "+
            "JOIN role_node ON role_user.role_id = role_node.role_id "+
            "JOIN node ON role_node.node_id = node.id "+
            "WHERE user.username = #{username} "
    )
    List<String> findNodesName(String username);

}