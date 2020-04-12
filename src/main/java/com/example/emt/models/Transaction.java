package com.example.emt.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {

    @Id
    private String transactionId;
    private String transactionStatus;
    private String transactionChargeId;
    private String transactionBalanceId;

    public Transaction(String transactionId, String transactionStatus, String transactionChargeId, String transactionBalanceId) {
        this.transactionId = transactionId;
        this.transactionStatus = transactionStatus;
        this.transactionChargeId = transactionChargeId;
        this.transactionBalanceId = transactionBalanceId;
    }
    public Transaction(){}
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionChargeId() {
        return transactionChargeId;
    }

    public void setTransactionChargeId(String transactionChargeId) {
        this.transactionChargeId = transactionChargeId;
    }

    public String getTransactionBalanceId() {
        return transactionBalanceId;
    }

    public void setTransactionBalanceId(String transactionBalanceId) {
        this.transactionBalanceId = transactionBalanceId;
    }
}
