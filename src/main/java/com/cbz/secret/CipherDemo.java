package com.cbz.secret;



import lombok.Data;

import java.security.*;
import java.util.Base64;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/15
 * @use：非对称加密，Java随机生成公私钥对
 * @Algorithm： RSA
 */
@Data
public class CipherDemo {

    public static final String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIo0NsD+AU6uRElWIAQ3kRHHg46xryOkW0q56OynN+59EmzM0xQ/j0U5fHTxQuN6DMuTGPDVLSnOppFHJZdjcIkCAwEAAQ==";
    public static final String secretKey = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAijQ2wP4BTq5ESVYgBDeREceDjrGvI6RbSrno7Kc37n0SbMzTFD+PRTl8dPFC43oMy5MY8NUtKc6mkUcll2NwiQIDAQABAkANF2UYYvc8vMU7LS1bOOhFBuEvYyVz+t2q9nFZ+X0S2iGSWzpscTSzlWWaC1vkeXdgtp13PQf25ZAQ6XrydMABAiEA7G8fdXrXxviovG/dLXu/KnwwlSevPNpzVzOzx+ERAWECIQCVpBPENfTuXp+L606PeVLOwZym1+P+APF0tO8/h304KQIgV5q5AlOY/g2GoAOm5UJzy68mZS3GHXsnv4jVtVrsbSECIAbe1q1+kLVVENw6vIun1V560zdx2Bz0bCGgoQ94qA4pAiB5eHaKyx+RHvVpESKP67EhTV+cc/X7K1eaYgPIliDyZA==";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 生成RSA密钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 获取私钥
        PrivateKey privateKey = keyPair.getPrivate();
        // 获取公钥
        PublicKey aPublic = keyPair.getPublic();
        // 序列化私钥为Base64字符串
        String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        String publicKeyBase64 = Base64.getEncoder().encodeToString(aPublic.getEncoded());
        System.out.println("私钥(Base64编码): " + privateKeyBase64);
        System.out.println("公钥(Base64编码): " + publicKeyBase64);
    }



}
