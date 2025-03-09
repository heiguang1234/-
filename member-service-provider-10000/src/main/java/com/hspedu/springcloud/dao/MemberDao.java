package com.hspedu.springcloud.dao;

import com.hspedu.springcloud.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Author:Black Sunshine
 * Date:2025/3/8 14:48
 */

@Mapper
public interface MemberDao {

     //定义方法
     //根据id返回member数据
     public Member queryMemberById(Long id);
     //添加member
     public int save(Member member);
}
