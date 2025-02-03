package Hash;

import java.security.MessageDigest;

public class SHA256Helper {

    public static String hash(String data){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));

            // we want to end up with hexadecimal values not bytes
            StringBuffer hexadecimalString = new StringBuffer();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
