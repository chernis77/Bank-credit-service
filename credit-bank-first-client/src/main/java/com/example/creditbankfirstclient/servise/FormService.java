package com.example.creditbankfirstclient.servise;

import com.example.creditbankfirstclient.dto.FillFormDTO;
import com.example.creditbankfirstclient.dto.RequestFormDTO;
import com.example.creditbankfirstclient.dto.ResponseDTO;

public interface FormService {

    ResponseDTO validateField(FillFormDTO form);

    RequestFormDTO fillInRequestFormDTO(FillFormDTO form);

}
