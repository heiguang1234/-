package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
// import org.springframework.cloud.client.ServiceInstance;
// import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 韩顺平
 * @version 1.0
 */
@RestController
@Slf4j
public class MemberConsumerController {

    //定义member_service_provider_url 这是一个基础url地址
    //使用shift+ctrl+u 进行字母大小写的切换
    /**
     * 老师说明:
     * 1. MEMBER-SERVICE-PROVIDER 就是服务提供方[集群], 注册到Eureka Server 的名称
     * 2. 也就是服务提供方[集群]对外暴露的名称为 MEMBER-SERVICE-PROVIDER
     * 3. MEMBER-SERVICE-PROVIDER 目前有 两个 Availability Zones member-service-provider:10000
     *    还有一个 member-service-provider:10002
     *    需要增加一个注解@LoadBalanced 赋予 RestTemplate 负载均衡的能力,也就是会根据你的负载均衡算法
     *    来选择某个服务去访问, 默认是轮询算法, 当然我们也可以自己配置负载均衡算法
     */
    public static final String MEMBER_SERVICE_PROVIDER_URL =
            "http://localhost:10000"; //后面这里地方会修改成提供服务模块的注册别名
    //装配RestTemplate bean/对象
    @Resource
    private RestTemplate restTemplate;

    //装配DiscoveryClient
    // @Resource
    // private DiscoveryClient discoveryClient;
    //
    //
    // @GetMapping("/member/consumer/discovery")
    // public Object discovery() {
    //
    //     List<String> services = discoveryClient.getServices();
    //     //遍历services
    //     for (String service : services) {
    //         log.info("服务名={}",service);
    //         List<ServiceInstance> instances = discoveryClient.getInstances(service);
    //         for (ServiceInstance instance : instances) {
    //             log.info("id={},host={},port={},uri={}",
    //                     instance.getServiceId(),instance.getHost(),instance.getPort(),instance.getUri());
    //
    //         }
    //     }
    //     return discoveryClient;
    // }

    //方法/接口 添加member对象到数据库/表
    //老师说明: 这还有一个坑, 老师一会就解决.
    @PostMapping("/member/consumer/save")
    public Result<Member> save(Member member) {
        log.info("service-consumer member={}", member);
        //老师说明
        //请的完整的url :MEMBER_SERVICE_PROVIDER_URL + "/member/save" => http://localhost:10000/member/save
        //member : 就是通过restTemplate 发出的post请求携带数据(对象)
        //Result.class: 返回对象类型
        //这里通过restTemplate 调用服务提供模块的接口, 就是一个远程调用 RPC

        return restTemplate.postForObject(MEMBER_SERVICE_PROVIDER_URL
                + "/member/save", member, Result.class);
    }

    //方法/接口 , 根据id 调用服务接口,返回member对象信息
    @GetMapping("/member/consumer/get/{id}")
    public Result<Member> getMemberById(@PathVariable("id") Long id) {

        return restTemplate.getForObject(
                MEMBER_SERVICE_PROVIDER_URL + "/member/get/" + id, Result.class);
    }

}
