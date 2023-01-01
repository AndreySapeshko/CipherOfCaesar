package org.example;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class CipherOfCaesar {
    private static boolean decryptFinished = false;
    private static int currentKey = 0;
    public static String encryptText(String inputText, String fieldKey) {
        if (inputText == null){
            return "";
        }
        int key = parseKey(fieldKey);
        char[] chars = inputText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] > 1039 && chars[i] < 1104) || (chars[i] > 31 && chars[i] < 64)) {
                int shift;
                int numChar = chars[i];
                if (numChar < 1040) {
                    shift = 32;
                } else if (numChar < 1072) {
                    shift = 1040;
                } else {
                    shift = 1072;
                }

                numChar = (numChar - shift + key) % 32 + shift;
                chars[i] = (char) numChar;
            }
        }
        return new String(chars);
    }

    public static String decryptText(String inputText, String fieldKey) {
        if (inputText == null){
            return "";
        }
        int key = parseKey(fieldKey);
        char[] chars = inputText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] > 1039 && chars[i] < 1104) || (chars[i] > 31 && chars[i] < 64)) {
                int shift;
                int numChar = chars[i];
                if (numChar < 1040) {
                    shift = 32;
                } else if (numChar < 1072) {
                    shift = 1040;
                } else {
                    shift = 1072;
                }

                numChar = (numChar - shift - key + 32) % 32;
                chars[i] = (char) (numChar + shift);
            }
        }
        return new String(chars);
    }

    public static String decryptWithoutKey(String inputText) {
        String decryptedText;
        do {
            currentKey++;
            decryptedText = decryptText(inputText, "" + currentKey);
            decryptFinished = detectDecrypt(decryptedText);
            if (currentKey > 31) {
                decryptFinished = true;
            }
        } while (!decryptFinished);
        return decryptedText;
    }

    public static boolean detectDecrypt(String decryptedText) {
        char[] chars = decryptedText.toCharArray();
        Character[] characters = new Character[decryptedText.length()];
        for (int i = 0; i < chars.length; i++) {
            characters[i] = (Character) chars[i];
        }
        ArrayList<Character> listChars = new ArrayList<>(Arrays.asList(characters));
        if (listChars.contains(' ') && (listChars.contains(',') || listChars.contains('.') || listChars.contains('!')
                || listChars.contains(';') || listChars.contains(':') || listChars.contains('?'))) {
            for (int i = 0; i < listChars.size(); i++) {
                if (i < listChars.size() - 1) {
                    if (listChars.get(i) == ',' || listChars.get(i) == '.' || listChars.get(i) == '!'
                            || listChars.get(i) == ';' || listChars.get(i) == ':' || listChars.get(i) == '?') {
                        if (listChars.get(i + 1) == ' ') {
                            return true;
                        }
                    }
                }
            }
        } else if (listChars.contains(' ')) {
            return true;
        }
        return false;
    }

    static int parseKey(String strKey) {
        int key;
        try {
            key = Integer.parseInt(strKey);
        } catch (Exception e) {
            key = 0;
        }
        return key % 32;
    }

    public static void decryptTextFinished() {
        currentKey = 0;
        decryptFinished = false;
    }
}
