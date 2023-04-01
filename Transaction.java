package test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction implements Serializable
{

    private String tran_id;
    private LocalDate date;
    private LocalTime time;
    private Double balance;

    public String getTran_id() {
        return tran_id;
    }

    public void setTran_id(String tran_id) {
        this.tran_id = tran_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return
                "tran_id=" + tran_id +
                ", date=" + date +
                ", time=" + time +
                ", balance=" + balance ;
    }
}
