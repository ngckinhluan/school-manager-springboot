package com.naul2k.schoolmanager.utils;

import java.security.SecureRandom;

public class GeneratePassword {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_+=<>?";

    private static final String ALL_CHARS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARS;

    private static final int PASSWORD_LENGTH = 10;

    private static final SecureRandom random = new SecureRandom();

    public static String generateRandomPassword() {
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int index = random.nextInt(ALL_CHARS.length());
            password.append(ALL_CHARS.charAt(index));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        // Generate a random password and print it
        String password = generateRandomPassword();
        System.out.println(password);
    }
}
