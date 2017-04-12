/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebank_services;

/**
 *
 * @author AbdulGhani
 */
public class Account {

    private String acType;
    private long acNo;
    private String sortCode;
    private double balance;
    private long card;

    public Account(String _type, long _no, String _sortCode, double _bal, long _card) {
        this.acType = _type;
        this.acNo = _no;
        this.sortCode = _sortCode;
        this.balance = _bal;
        this.card = _card;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }

    public long getAcNo() {
        return acNo;
    }

    public void setAcNo(long acNo) {
        this.acNo = acNo;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getCard() {
        return card;
    }

    public void setCard(long card) {
        this.card = card;
    }
}
