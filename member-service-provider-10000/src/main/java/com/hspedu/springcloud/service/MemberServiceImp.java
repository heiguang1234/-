package com.hspedu.springcloud.service;

import com.hspedu.springcloud.dao.MemberDao;
import com.hspedu.springcloud.entity.Member;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author:Black Sunshine
 * Date:2025/3/8 14:51
 */
@Service
public class MemberServiceImp implements MemberService{
    @Resource
    private MemberDao memberDao;

    public Member queryMemberById(Long id) {
        return memberDao.queryMemberById(id);
    }

    public int save(Member member) {
        return memberDao.save(member);
    }
}
