/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.passmgr;

/**
 *
 * @author HP
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
 
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
public class sec {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
 
    public static void encrypt(String key, String inputString, File EncryptedFile)
            throws CryptoException {
        doCrypto(Cipher.ENCRYPT_MODE, key, inputString, EncryptedFile);
    }
 
    public static String decrypt(String key, File EncryptedFile)
            throws CryptoException {
        return doCrypto(Cipher.DECRYPT_MODE, key, EncryptedFile);
    }
 
    private static void doCrypto(int cipherMode, String key, String inputString,
            File outputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
            
             //
            // FileInputStream inputStream = new FileInputStream(inputFile);
            // byte[] inputBytes = new byte[(int) inputFile.length()];
            // inputStream.read(inputBytes);
             //
            byte[] outputBytes = cipher.doFinal(inputString.getBytes());
             
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);
             
            // inputStream.close();
            outputStream.close();
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
    private static String doCrypto(int cipherMode, String key, File EncryptedFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);
            
             //
            FileInputStream inputStream = new FileInputStream(EncryptedFile);
            byte[] inputBytes = new byte[(int) EncryptedFile.length()];
            inputStream.read(inputBytes);
             //
            byte[] outputBytes = cipher.doFinal(inputBytes);
             
            // FileOutputStream outputStream = new FileOutputStream(outputFile);
            // outputStream.write(outputBytes);
            String outputString = new String(outputBytes);
            inputStream.close();
            // outputStream.close();
            return outputString;
             
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
}
class CryptoException extends Exception {
 
    public CryptoException() {
    }
 
    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
