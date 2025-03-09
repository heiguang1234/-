package com.hspedu.springcloud;

import com.hspedu.springcloud.dao.MemberDao;
import com.hspedu.springcloud.entity.Member;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * Author:Black Sunshine
 * Date:2025/3/8 15:00
 */
@SpringBootTest()
@Slf4j
public class MemberApplicationTest {
    @Resource
    private MemberDao memberDao;
    //这里的Test注解
    @Test
    public void queryMemberById(){
        Member member = memberDao.queryMemberById(1L);
        log.info("member={}",member);

    }
    @Test
    public void save(){
        Member member = new Member(null, "牛魔王", "123", "12000000000", "nmw@sohu.com", 0);
        int save = memberDao.save(member);
        log.info("rows={}",save);

    }
}
