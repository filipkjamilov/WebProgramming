package com.example.emt.service;

import com.example.emt.models.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> findAll();
    Transaction save(Transaction transaction);
    void deleteAll();

}
