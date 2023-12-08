package com.rohit.splitwiseclone.Controller;

import com.rohit.splitwiseclone.Controller.dto.SettleUpResponseDTO;
import com.rohit.splitwiseclone.Controller.dto.TransactionDTO;
import com.rohit.splitwiseclone.services.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettleUpController {

    @Autowired
    private InitService initService;
    @GetMapping ("/init")
    public ResponseEntity initialise(){
        initService.initialise();
        return ResponseEntity.ok("Done");
    }
    @GetMapping("/settleUp")
    public ResponseEntity settleUp(){
        List<TransactionDTO> transactionDTOS = groupService.settleUp();
        return ResponseEntity.ok(transactionDTOS);
    }
}
