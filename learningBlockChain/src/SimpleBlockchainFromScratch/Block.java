package SimpleBlockchainFromScratch;

import Hash.SHA256Helper;

import java.util.Date;

public class Block {
    private int id;
    private int nonce;
    private long timestamp;
    private String hash;
    private String previousHash;
    private String transaction;

    public Block(int id, String previousHash, String transaction){
        this.id = id;
        this.previousHash = previousHash;
        this.transaction = transaction;
        this.timestamp = new Date().getTime();
        SHA256Helper.hash()
    }

    public String getHash(){
        return this.hash;
    }

    public Block setHash(String hash){
        this.hash = hash;
        return this;
    }

    public String getPreviousHash(){
        return this.previousHash;
    }

    public Block setPreviousHash(String previousHash){
        this.previousHash = previousHash;
        return this;
    }

    public void incrementNonce(){
        this.nonce++;
    }

}
