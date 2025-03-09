package com.hspedu.springcloud.service;

import com.hspedu.springcloud.entity.Member;

/**
 * Author:Black Sunshine
 * Date:2025/3/8 14:51
 */
public interface MemberService {
    Member queryMemberById(Long id);
    int save(Member member);
}
