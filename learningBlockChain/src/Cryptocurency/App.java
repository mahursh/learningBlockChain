package Cryptocurency;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.KeyPair;
import java.security.Security;

public class App {
    public static void main(String[] args) {

        // we use bouncy castle as the cryptography related provider
        Security.addProvider(new BouncyCastleProvider());

        KeyPair keys = CryptographyHelper.ellipticCurveCrypto();

        System.out.println(keys.getPublic().toString());
        System.out.println(keys.getPrivate().toString());
    }
}
