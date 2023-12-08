package com.rohit.splitwiseclone.services;

import com.rohit.splitwiseclone.Controller.dto.TransactionDTO;

import java.util.List;

public interface GroupService {//settleUp is a part of Group so we have made settleUp() method in GroupService this will return with list of transactions
     List<TransactionDTO> settleUp();

}
