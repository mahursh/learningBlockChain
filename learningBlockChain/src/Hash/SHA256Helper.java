package Hash;

import java.security.MessageDigest;

public class SHA256Helper {

    public static String hash(String data){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
