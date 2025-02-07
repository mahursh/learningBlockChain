package Cryptocurency;

import BlockChain.BlockChain;
import Hash.SHA256Helper;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Transaction {

    // id of the transaction is a hash
    private String transactionId;

    // we use public keys to reference the sender or receiver
    private PublicKey sender;
    private PublicKey receiver;

    // the amount of coins that sender gives to receiver
    private double amount;

    // make sure the transaction is signed to prevent anyone else from spending the coins.
    private byte[] signature;

    // every transaction has inputs and outputs
    public List<TransactionInput> inputs;
    public List<TransactionOutput> outputs;

    public Transaction(PublicKey sender, PublicKey receiver, double amount, List<TransactionInput> inputs){
        this.inputs = new ArrayList<TransactionInput>(inputs);
        this.outputs = new ArrayList<TransactionOutput>();
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        calculateHash();
    }

    public boolean verifyTransaction() {

        if(!verifySignature()) {
            System.out.println("Invalid transaction because of invalid signature...");
            return false;
        }

        //let's gather unspent transactions (we have to consider the inputs)
        for(TransactionInput transactionInput : inputs) {
            transactionInput.setUTXO( BlockChain.UTXOs.get(transactionInput.getTransactionOutputId()));
        }

        //transactions have 2 part: send an amount to the receiver + send the (balance-amount) back to the sender
        outputs.add(new TransactionOutput( transactionId,this.receiver, amount)); //send value to recipient
        outputs.add(new TransactionOutput( transactionId,this.sender, getInputSum() - amount)); //send the left over 'change' back to sender

        //the outputs will be inputs for other transactions (so put them in the blockchain's UTXOs)
        for(TransactionOutput transactionOutput : outputs) {
            BlockChain.UTXOs.put(transactionOutput.getId() , transactionOutput);
        }

        //remove transaction inputs from blockchain's UTXOs list because they've been spent
        for(TransactionInput transactionInput : inputs) {
            if(transactionInput.getUTXO() != null)
                BlockChain.UTXOs.remove(transactionInput.getUTXO().getId());
        }

        return true;
    }


    public double getInputSum(){
        double sum = 0;
        for(TransactionInput transactionInput : inputs){
            if(transactionInput.getUTXO() != null)
                sum += transactionInput.getUTXO().getAmount();

        }
        return sum;
    }

    public void generateSignature(PrivateKey privateKey){
        String data = sender.toString() + receiver.toString() + Double.toString(amount);
        this.signature = CryptographyHelper.sign(privateKey, data);
    }

    public boolean verifySignature(){
        String data = sender.toString() + receiver.toString() + Double.toString(amount);
        return CryptographyHelper.verify(sender, data, signature);
    }

    public void calculateHash(){
        String hashData = sender.toString() + receiver.toString() + Double.toString(amount);
        this.transactionId = SHA256Helper.hash(hashData);
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Transaction setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public PublicKey getSender() {
        return sender;
    }

    public Transaction setSender(PublicKey sender) {
        this.sender = sender;
        return this;
    }

    public PublicKey getReceiver() {
        return receiver;
    }

    public Transaction setReceiver(PublicKey receiver) {
        this.receiver = receiver;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Transaction setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public byte[] getSignature() {
        return signature;
    }

    public Transaction setSignature(byte[] signature) {
        this.signature = signature;
        return this;
    }

    public List<TransactionInput> getInputs() {
        return inputs;
    }

    public Transaction setInputs(List<TransactionInput> inputs) {
        this.inputs = inputs;
        return this;
    }

    public List<TransactionOutput> getOutputs() {
        return outputs;
    }

    public Transaction setOutputs(List<TransactionOutput> outputs) {
        this.outputs = outputs;
        return this;
    }
}
