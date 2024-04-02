package com.example.qianhua.rateLimiter;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

public class RSAKeyPairGenerator {
    private static PublicKey publicKey;
    private static PrivateKey privateKey;

    public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        publicKey = pair.getPublic();
        privateKey = pair.getPrivate();
    }

    public String getPublicKey() {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

    public String getPrivateKey() {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public static void main(String[] args) throws Exception {
        RSAKeyPairGenerator keyPairGenerator = new RSAKeyPairGenerator();
        System.out.println("Public Key: " + keyPairGenerator.getPublicKey());
        System.out.println("Private Key: " + keyPairGenerator.getPrivateKey());


        String key = "这是";
        byte[] bytes = key.getBytes();
        Cipher rsa = Cipher.getInstance("RSA");
        rsa.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] bytes1 = rsa.doFinal(bytes);

        rsa.init(Cipher.ENCRYPT_MODE,privateKey);
        byte[] bytes2 = rsa.doFinal(bytes1);
        System.out.println(new String(bytes2));
    }

}
