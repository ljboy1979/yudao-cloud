package cn.iocoder.yudao.module.demo.controller.admin;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.stream.function.StreamBridge;

import javax.annotation.Resource;

import java.util.function.Consumer;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Api(tags = "管理后台 - Test")
@RestController
@RequestMapping("/demo/test")
@Validated
@Slf4j
public class DemoTestController {

    @GetMapping("/get")
    @ApiOperation("获取 test 信息")
    @PreAuthorize("@ss.hasPermission('demo:test:get')")
    public CommonResult<String> get() {
        return success("true");
    }

    @Resource
    private StreamBridge streamBridge;

    /**
     * 采用StreamBridge的发送方式
     *
     * @param message 　短消息
     * @link https://docs.spring.io/spring-cloud-stream/docs/3.1.0/reference/html/spring-cloud-stream.html#_binding_and_binding_names
     */
    //本地测试：localhost:58082/admin-api/demo/test/sendMsg?message=hello
    @PostMapping("/sendMsg")
    @ApiOperation("发送信息")
    @PreAuthorize("@ss.hasPermission('demo:test:sendMsg')")
    public void msgProducer(@RequestParam String message) {
        streamBridge.send("msgProducer-out-0", message);
    }

    //接收信息，此处只是为了简单展示，应写到service里
    @Bean
    public Consumer<String> msgConsumer() {
        return message -> {
            log.info("接收的普通消息为：{}", message);
        };
    }

    /**
     *框架也引入了总线Cloud bus技术，各个应用简单配置后，可通过总线获得消息
     *  bus:
     *       enabled: true # 是否开启，默认为 true
     *       id: ${spring.application.name}:${server.port} # 编号，Spring Cloud Alibaba 建议使用“应用:端口”的格式
     *       destination: springCloudBus # 目标消息队列，默认为 springCloudBus
     */

}
