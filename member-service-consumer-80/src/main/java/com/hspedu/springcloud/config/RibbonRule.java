package com.hspedu.springcloud.config;

// import com.netflix.loadbalancer.IRule;
// import com.netflix.loadbalancer.RandomRule;
// import com.netflix.loadbalancer.RoundRobinRule;
// import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 韩顺平
 * @version 1.0
 * RibbonRule: 配置自己的负载均衡算法
 */
@Configuration
public class RibbonRule {

    // //配置注入自己的负载均衡算法
    // @Bean
    // public IRule myRibbonRule() {
    //     //这里老师返回的是RandomRule,当然小伙伴也可以自己指定
    //     return new RandomRule();
    // }
}
