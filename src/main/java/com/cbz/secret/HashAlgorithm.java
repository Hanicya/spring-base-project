package com.cbz.secret;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: HuangYiCheng
 * @Date: 2024/8/23
 */
public class HashAlgorithm {
    public static void main(String[] args) {
        try {
            String input = "Hello, World!";
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashBytes = md.digest(input.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            System.out.println("SHA-512 Hash: " + sb.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
