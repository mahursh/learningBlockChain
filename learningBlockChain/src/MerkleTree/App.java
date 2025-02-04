package MerkleTree;

import java.util.ArrayList;
import java.util.List;

public class App {

    /*
    * Why to use merkle tree?
    *   ----> because we can represent all the transactions within a
    *               block by a single hash
    *   ----> this single hash is in the header of the block in the blockchain
    *               (so it is a memory efficient solution)
    *   ----> this is the merkle root: we recursively keep hashing the leaf nodes
    *               in the tree-like structure
    *
    *   THE ROOT VERIFY THAT ALL THE TRANSACTIONS ARE VALID IN THE BLOCK !!!
    */


    public static void main(String[] args) {

        List<String> transactions = new ArrayList<>();

        // if we even change the order or value of any transactions, the merkelRoot (hash) will be changed
        transactions.add("aa");
        transactions.add("bb");
        transactions.add("dd");

        MerkleTree tree = new MerkleTree(transactions);
        System.out.println(tree.getMerkleRoot());

    }
}
