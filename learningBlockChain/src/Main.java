import Hash.SHA256Helper;

public class Main {
    public static void main(String[] args) {
        System.out.println(SHA256Helper.hash("Hello World"));

        //Double Hashing -> what BlockChain is using under the hood
        System.out.println(SHA256Helper.hash(SHA256Helper.hash("Hello World")));

    }
}