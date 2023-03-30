package com.example.creditbankfirstclient.servise;

import com.example.creditbankfirstclient.dto.CheckResponseDTO;
import com.example.creditbankfirstclient.dto.RequestFormDTO;

public interface RestTemplateServise {

    CheckResponseDTO getResttemplateCheckResponce(RequestFormDTO requestFormDTO);


}
