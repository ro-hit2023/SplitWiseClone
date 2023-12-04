package com.rohit.splitwiseclone.Controller;

import com.rohit.splitwiseclone.Controller.dto.SettleUpResponseDTO;
import com.rohit.splitwiseclone.Controller.dto.TransactionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettleUpController {

    @GetMapping ("/hello")//Get call to localhost:9090/hello
    public ResponseEntity helloworld(){
        TransactionDTO transactionDTO1 = new TransactionDTO("Rohit", "Versha", 1000);
        TransactionDTO transactionDTO2 = new TransactionDTO("Vivak", "Tillu", 6000);
        List<TransactionDTO> transactions = List.of(transactionDTO1, transactionDTO2);
        SettleUpResponseDTO settleUpResponseDTO = new SettleUpResponseDTO(transactions);
        return ResponseEntity.ok(settleUpResponseDTO);
    }

}
