package BlockChain;

public class Miner {

    // every miner gets 6.25 BTC after the mining.
    private double reward;

    public void mine(Block block, BlockChain blockChain) {

        // it takes some time to find the valid hash
        // this is not energy efficient
        // this is PoW (Proof of work)
        while (!isGoldenHash(block)) {
            block.incrementNonce();
            block.generateHash();
        }
        System.out.println(block + "has been mined ...");
        System.out.println("Hash is : " + block.getHash());

        blockChain.addBlock(block);
        reward += Constants.MINER_REWARD;
    }

    private boolean isGoldenHash(Block block) {
        String leadingZeros = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');
        return block.getHash().substring(0, Constants.DIFFICULTY).equals(leadingZeros);
    }


    public double getReward() {
        return this.reward;
    }
}
