package BlockChain;

public class App {
    public static void main(String[] args){

        BlockChain blockChain = new BlockChain();
        Miner miner = new Miner();

        // we can create the blocks one by one
        Block block0 = new Block(0, Constants.GENESIS_PREV_HASH,"");
        miner.mine(block0, blockChain);

        Block block1 = new Block(1,
                blockChain.getBlockChain().get(blockChain.getSize()-1).getHash(),
                "transaction1");
        miner.mine(block1, blockChain);

        Block block2 = new Block(2,
                blockChain.getBlockChain().get(blockChain.getSize()-1).getHash(),
                "transaction2");
        miner.mine(block2, blockChain);

        System.out.println("\n" + "BLOCKCHAIN :\n" + blockChain);
        System.out.println("Miner Reward : " + miner.getReward());

        // a single block is mined after every 10 minutes
    }
}
