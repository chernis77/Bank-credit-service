package com.example.creditbankcheckclient.controller;

import com.example.creditbankcheckclient.dto.CheckResponseDTO;
import com.example.creditbankcheckclient.dto.RequestFormDTO;
import com.example.creditbankcheckclient.dto.TransferPassportNumDTO;
import com.example.creditbankcheckclient.entity.CheckBidEntity;
import com.example.creditbankcheckclient.repository.CheckBidRepository;
import com.example.creditbankcheckclient.resttemplate.IsInBlackListResttemplate;
import com.example.creditbankcheckclient.service.CheckClientService;
import com.example.creditbankcheckclient.service.TakeBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

@RestController
@RequestMapping("/check")
public class CheckController {
    @Autowired
    private CheckClientService checkClientService;

    @Autowired
    private CheckBidRepository checkBidRepository;

    @Autowired
    private TakeBidService takeBidService;

    /**
     *  Получает с credit-bank-first-client форму заявки RequestFormDTO.
     *
     *
     */
    @PostMapping("/clientresponse")
    public CheckResponseDTO checkClientResponse(@RequestBody RequestFormDTO requestFormDTO) {

        CheckResponseDTO checkResponseDTO = checkClientService.checkFormClient(requestFormDTO);
        return checkResponseDTO;

    }

    /**
     *  Получает от клиента номер заявки, существующей в checkbid_table.
     *  В случае, если в checkbid_table в поле bank_confirm установлено значение true,
     *  устанавливает true в поле client_confirm и отправляет TransferBidToApproveDTO на credit-bank-approved-client.
     *  Возвращает сообщение о заключении кредитного договора.
     */

    @PostMapping("/contractmessage")
    public String confirmBidAndCreateContract(@RequestParam String bidNumber) {

        return takeBidService.takeBidForContract(bidNumber);

    }
}


//   /check/checkrequest                /check/blacklist          /check/monthpay

//  /check/clientresponse               /check/contractmessage/{bidNumber}