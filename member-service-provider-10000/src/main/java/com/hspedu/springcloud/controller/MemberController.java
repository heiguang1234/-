package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.entity.Result;
import com.hspedu.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Author:Black Sunshine
 * Date:2025/3/8 14:53
 */
@RestController
@Slf4j
public class MemberController {
    @Resource
    private MemberService memberService;

    @PostMapping(value = "/member/save")
    public Result save(Member member, HttpServletRequest request) {
        System.out.println("Received request from: " + request.getRemoteAddr());
        System.out.println("Request body: " + member);
        int result = memberService.save(member);
        log.info("reset= " + result);
        if (result > 0) { // 成功
            return Result.success("添加用户成功", result);
        } else {
            return Result.error("401", "添加用户失败");
        }
    }

    @GetMapping(value = "/member/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id) {
        Member member = memberService.queryMemberById(id);
        log.info("查询结果= " + member);
        if (member != null) {
            return Result.success("查询成功", member);
        } else {
            return Result.error("402", "ID= " + id + " 不存在");
        }
    }
}

