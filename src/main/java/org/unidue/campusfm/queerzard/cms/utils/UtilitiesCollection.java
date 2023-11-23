
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.utils;

import lombok.SneakyThrows;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public class UtilitiesCollection {

    public static final Logger LOGGER = LoggerFactory.getLogger(UtilitiesCollection.class);

    /**
     * Converts a given byte array to its Base64 representation.
     *
     * @param bytes the byte array to convert
     * @return the Base64 representation of the given byte array
     */
    public static String toBase64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    /**
     * Reads the contents of a file into a byte array.
     *
     * @param file The file to read.
     * @return The byte array containing the contents of the file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    @SneakyThrows
    public static byte[] getFileBytes(File file) {
        return Files.readAllBytes(file.toPath());
    }

    /**
     * Returns the default avatar file.
     *
     * @return The default avatar file.
     */
    public static File getDefaultAvatarFile() {
        return getFileFromResource("avatardefault.png");
    }

    /**
     * Returns the file from the specified resource path.
     *
     * @param path The path of the resource file.
     * @return The file from the resource path.
     */
    public static File getFileFromResource(String path){
        return new File(UtilitiesCollection.class.getClassLoader().getResource(path).getFile());
    }

    /**
     * Escapes the given SQL string by replacing single quotes with two single quotes.
     *
     * @param string The SQL string to escape.
     * @return The escaped SQL string.
     */
    public static String escapeSQL(String string) {
        return string.replace("'", "''");
    }

    /**
     * It takes a hash type and a string, and returns the hash of the string
     *
     * @param hashType  The type of hash you want to use.
     * @param inputHash The string you want to hash.
     * @return A string of the hash
     */
    public static String hash(String hashType, String inputHash) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance(hashType);
        messageDigest.update(inputHash.getBytes());

        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (byte byt : digest)
            stringBuffer.append(String.format("%02x", byt & 0xff));
        return stringBuffer.toString();
    }

    @SneakyThrows public static String md5(String input){return hash("MD5", input);}
    @SneakyThrows public static String sha1(String input){return hash("SHA-1", input);}
    @SneakyThrows public static String sha256(String input){return hash("SHA-256", input);}
    @SneakyThrows public static String sha384(String input){return hash("SHA-384", input);}
    @SneakyThrows public static String sha512(String input){return hash("SHA-512", input);}


    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    public static String getYear(long milliseconds){
        return String.valueOf(Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).getYear());
    }

    public static String getMonth(long milliseconds){
        String m = String.valueOf(Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).getMonth());
        return m.substring(0, 1).toUpperCase() + m.substring(1).toLowerCase();
    }

    public static String getDay(long milliseconds){
        return String.valueOf(Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).getDayOfMonth());
    }

    public static String getHour(long milliseconds){
        return String.valueOf(LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds), ZoneId.systemDefault()).getHour());
    }

    public static String getMinute(long milliseconds){
        return String.valueOf(LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds), ZoneId.systemDefault()).getMinute());

    }

    public static String getSecond(long milliseconds){
        return String.valueOf(LocalDateTime.ofInstant(Instant.ofEpochMilli(milliseconds), ZoneId.systemDefault()).getSecond());
    }

    public static String cutSubstring(String s, int maxChars){
        return (s.length() > maxChars ? s.substring(0, maxChars) : s);
    }

    public static String generateSecretKey(){
        SecureRandom secureRandom = new SecureRandom();
        byte[] keyBytes = new byte[64]; // You can adjust the key size as needed

        secureRandom.nextBytes(keyBytes);

        StringBuilder keyBuilder = new StringBuilder();
        for (byte b : keyBytes)
            keyBuilder.append(String.format("%02x", b));

        return keyBuilder.toString();
    }


}
