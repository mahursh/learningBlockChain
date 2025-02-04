package MerkleTree;

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

    }
}
