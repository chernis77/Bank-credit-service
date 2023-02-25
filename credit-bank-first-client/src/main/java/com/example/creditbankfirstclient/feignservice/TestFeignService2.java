package com.example.creditbankfirstclient.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ApprovedClientResponse", url = "http://localhost:8098")
public interface TestFeignService2 {

    @GetMapping("/testapproved/testappmessage" )
    String testMessage(@RequestParam String name);


}
