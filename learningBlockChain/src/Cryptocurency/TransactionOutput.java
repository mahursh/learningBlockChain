package Cryptocurency;

import Hash.SHA256Helper;

import java.security.PublicKey;

public class TransactionOutput {

    // identifier of the transaction output
    private String id;

    // transaction id of the parent (so the transaction it was created in)
    private String parentTransactionId;

    //the new owner of the coin
    private PublicKey receiver;

    // amount of coins
    private double amount;

    public TransactionOutput(String parentTransactionId, PublicKey receiver, double amount) {
        this.parentTransactionId = parentTransactionId;
        this.receiver = receiver;
        this.amount = amount;
        generateId();
    }

    private void generateId() {
        this.id = SHA256Helper.hash(receiver.toString() + Double.toString(amount) + parentTransactionId);
    }

    public boolean isMine(PublicKey publicKey){
//        return publicKey.equals(receiver);
        return publicKey == receiver;
    }

    public String getId() {
        return id;
    }

    public String getParentTransactionId() {
        return parentTransactionId;
    }

    public TransactionOutput setParentTransactionId(String parentTransactionId) {
        this.parentTransactionId = parentTransactionId;
        return this;
    }

    public PublicKey getReceiver() {
        return receiver;
    }

    public TransactionOutput setReceiver(PublicKey receiver) {
        this.receiver = receiver;
        return this;
    }

    public double getAmount() {
        return amount;
    }
    public TransactionOutput setAmount(double amount) {
        this.amount = amount;
        return this;
    }
}
