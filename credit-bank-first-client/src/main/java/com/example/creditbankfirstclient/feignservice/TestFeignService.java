package com.example.creditbankfirstclient.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="CheckClientResponse", url="http://localhost:8097")
public interface TestFeignService {

    @GetMapping("/testclient/testmessage")
    String testMessage(@RequestParam String name);

}
