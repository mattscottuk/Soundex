package org.example;


public class SoundexEncoder {

    private static final char[] SOUNDEX_TABLE = {
        '0', // A
        '1', // B
        '2', // C
        '3', // D
        '0', // E
        '1', // F
        '2', // G
        '0', // H
        '0', // I
        '2', // J
        '2', // K
        '4', // L
        '5', // M
        '5', // N
        '0', // O
        '1', // P
        '2', // Q
        '6', // R
        '2', // S
        '3', // T
        '0', // U
        '1', // V
        '0', // W
        '2', // X
        '0', // Y
        '2'  // Z
    };

    public String nameToSoundex(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Input name must not be null or empty.");
        }

        final int len = name.length();

        char[] letters = new char[len];
        int letterCount = 0;
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            if (c >= 'a' && c <= 'z') {
                letters[letterCount++] = (char) (c - 32); 
            } else if (c >= 'A' && c <= 'Z') {
                letters[letterCount++] = c;
            }
        }

        if (letterCount == 0) {
            throw new IllegalArgumentException("Input name must contain at least one letter.");
        }

        char[] result = {'0', '0', '0', '0'}; 
        result[0] = letters[0];               

        int resultIndex = 1;

        char prevCode = codeOf(letters[0]);

        for (int i = 1; i < letterCount && resultIndex < 4; i++) {
            char c    = letters[i];
            char code = codeOf(c);

            if (code == '0') {

                if (c != 'H' && c != 'W') {
                    prevCode = '0'; 
                }

            } else {

                if (code != prevCode) {
                    result[resultIndex++] = code;
                }
                prevCode = code;
            }
        }

        return new String(result);
    }

    private static char codeOf(char upperCaseLetter) {
        return SOUNDEX_TABLE[upperCaseLetter - 'A'];
    }

}
