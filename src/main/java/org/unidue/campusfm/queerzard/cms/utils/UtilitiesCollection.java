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

    public static String toBase64(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    @SneakyThrows
    public static byte[] getFileBytes(File file) {
        return Files.readAllBytes(file.toPath());
    }

    public static File getDefaultAvatarFile() {
        return getFileFromResource("avatardefault.png");
    }

    public static File getFileFromResource(String path){
        return new File(UtilitiesCollection.class.getClassLoader().getResource(path).getFile());
    }

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
