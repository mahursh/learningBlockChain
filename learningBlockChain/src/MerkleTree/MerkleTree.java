package MerkleTree;

import java.util.ArrayList;
import java.util.List;

public class MerkleTree {

    // we store the transactions in this list
    private List<String> transactions;

    public MerkleTree(List<String> transactions) {
            this.transactions = transactions;
    }

    // concatenate two strings and hash with SHA256
    private String mergeHash(String hash1, String hash2){
        String mergeHash = hash1 + hash2;
        return CryptographyHelper.hash(mergeHash);

    }

    // it is a recursive function that keeps merging the
    // neighboring hashes (index i and i+1)
    private List<String> construct(List<String> transactions) {

        // base case for recursive method calls
        if(transactions.size() == 1) return transactions;

        // it contains fewer and fewer items in every iteration
        List<String> updatedList = new ArrayList<>();

        // merging the neighbors items
        for(int i = 0; i < transactions.size()-1; i+=2)
            updatedList.add(mergeHash(transactions.get(i), transactions.get(i+1)));

        // if the number of transactions is odd : the last item is hashed with itself
        if(transactions.size()%2 == 1)
            updatedList.add(mergeHash(transactions.get(transactions.size()-1),
                    transactions.get(transactions.size()-1)));

        // recursive method call (tail recursion)
        return construct(updatedList);
    }
}
