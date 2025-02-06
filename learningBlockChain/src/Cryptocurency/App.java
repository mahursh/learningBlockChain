package Cryptocurency;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

public class App {
    public static void main(String[] args) {

        // we use bouncy castle as the cryptography related provider
        Security.addProvider(new BouncyCastleProvider());
    }
}
