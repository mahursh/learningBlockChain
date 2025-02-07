package Cryptocurency;

public class TransactionInput {

    // every input has an output. this id is the transactionId of the TransactionOutput
    private String transactionOutputId;

    // this is the unspent transaction output
    private TransactionOutput UTXO;

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }
    public String getTransactionOutputId() {
        return transactionOutputId;
    }
    public TransactionInput setTransactionOutputId(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
        return this;
    }

    public TransactionOutput getUTXO() {
        return UTXO;
    }
    public TransactionInput setUTXO(TransactionOutput UTXO) {
        this.UTXO = UTXO;
        return this;
    }

}
