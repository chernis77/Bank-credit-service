package com.example.creditbankfirstclient.feignservice;

import com.example.creditbankfirstclient.dto.RequestFormDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="CheckSequrityForm", url="http://localhost:8097")
public interface FormFeignService {

    @RequestMapping("/check/checkrequest" )
    String requestTest(@RequestBody RequestFormDTO requestFormDTO);


}
