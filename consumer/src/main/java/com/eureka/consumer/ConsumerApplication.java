package com.eureka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@EnableEurekaClient
@SpringBootApplication
public class ConsumerApplication {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 实例化RestTemplate
     * @return RestTemplate
     */
    @LoadBalanced
    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }

    /**
     * Rest服务端使用RestTemplate发起http请求,然后得到数据返回给前端----gotoUser是为了区分getUser怕小伙伴晕头
     * @param id
     * @return
     */
    @GetMapping(value = "/gotoUser")
    @ResponseBody
    public Map<String,Object> getUser(@RequestParam Integer id){
        Map<String, Object> data = restTemplate.getForObject("http://service-provider/getUserInfo", Map.class);
        return data;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
