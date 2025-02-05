package Cryptocurency;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class CryptographyHelper {

    // ECC to sign the given transaction (message)
    // elliptic curve digital signature algorithm (ECDSA)
    public static byte[] sign(PrivateKey privateKey, String input){
        Signature signature;
        byte[] output = new byte[0];
        try{
            // we use bouncy castle for ECC
            signature = Signature.getInstance("ECDSA", "BC");
            signature.initSign(privateKey);
            signature.update(input.getBytes());
            output = signature.sign();

        }catch (Exception e){

        }
        return output;

    }

    // checks whether the given transaction belongs to the sender based on the signature
    public static boolean verify(PublicKey publickey, String data, byte[] signature){
        try{

            Signature ecdsaSignature = Signature.getInstance("ECDSA", "BC");
            ecdsaSignature.initVerify(publickey);
            ecdsaSignature.update(data.getBytes());
            return ecdsaSignature.verify(signature);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
