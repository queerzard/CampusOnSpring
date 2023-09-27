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
        return getFileFromResource("/assets/images/blankprofile.png");
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

}
