package MerkleTree;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptographyHelper {

    // 64 character long hexadecimal string (256 bits)
    public static String hash(String data){

        // we use SHA256 usually in blockchains and bitcoin

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));

            // we want to end up with hexadecimal values not bytes
            StringBuilder hexString = new StringBuilder();

            for(int i = 0; i < hash.length; i++){
                String hexadecimal = Integer.toHexString(0xff & hash[i]);
                if(hexadecimal.length() == 1) hexString.append('0');
                hexString.append(hexadecimal);
            }
            return hexString.toString();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
