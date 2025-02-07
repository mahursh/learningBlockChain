package Cryptocurency;

import java.security.*;
import java.security.spec.ECGenParameterSpec;

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

    // generate public key and private key.
    // private key: 256 bits long random integer
    // public key: point on the elliptic curve
    //(x,y) - both of these values are 256 bits long
    public static KeyPair ellipticCurveCrypto(){
        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA", "BC");
            ECGenParameterSpec params = new ECGenParameterSpec("prime256v1");
            keyPairGenerator.initialize(params);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
