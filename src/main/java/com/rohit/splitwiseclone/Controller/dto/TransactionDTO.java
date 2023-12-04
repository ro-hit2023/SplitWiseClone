package com.rohit.splitwiseclone.Controller.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor //This will provide excess to all attributes inside the Transacrion method inside other Packeg or calss
public class TransactionDTO {
    private String fromUserName;
    private String toUserName;
    private double amount;
}
