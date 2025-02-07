package BlockChain;

import Cryptocurency.TransactionOutput;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BlockChain {

    // immutable ledger
    // we are not able to remove blocks
    public static List<Block> blockChain;
    public static Map<String, TransactionOutput> UTXOs;

    public BlockChain() {
        BlockChain.UTXOs = new HashMap<String,TransactionOutput>();
        blockChain = new LinkedList<>();
    }

    public void addBlock(Block block) {
        BlockChain.blockChain.add(block);
    }

    public List<Block> getBlockChain() {
        return BlockChain.blockChain;
    }

    public int getSize(){
        return BlockChain.blockChain.size();
    }

    @Override
    public String toString() {

        String blockChain = "";

        for(Block block : BlockChain.blockChain)
            blockChain += block.toString()+"\n";

        return blockChain;
    }
}
