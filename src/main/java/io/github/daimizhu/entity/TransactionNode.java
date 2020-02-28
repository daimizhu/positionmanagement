package io.github.daimizhu.entity;

import io.github.daimizhu.enums.Action;
import io.github.daimizhu.enums.Side;

public class TransactionNode {
    private int transactionID;
    private int tradeID;
    private int version;
    private String securityCode;
    private Action action;
    private Side side;
    private int quantity;

    public TransactionNode next;

    public TransactionNode(int transactionID, int tradeID, int version, String securityCode, Action action, Side side, int quantity) {
        this.transactionID = transactionID;
        this.tradeID = tradeID;
        this.version = version;
        this.securityCode = securityCode;
        this.action = action;
        this.side = side;
        this.quantity = quantity;
    }



    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getTradeID() {
        return tradeID;
    }

    public void setTradeID(int tradeID) {
        this.tradeID = tradeID;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getQuantity() {
        if(this.side == Side.SELL){
            return  -quantity;
        }
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}
