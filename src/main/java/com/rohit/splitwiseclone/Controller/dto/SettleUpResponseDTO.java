package com.rohit.splitwiseclone.Controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data // this will automatically add Getter, Setter, NoArgsConstructor (will not add AllArgConstructor)
@AllArgsConstructor
public class SettleUpResponseDTO {
     private  List<TransactionDTO> TransactionList;
}
