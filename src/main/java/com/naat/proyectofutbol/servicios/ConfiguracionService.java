package com.naat.proyectofutbol.servicios;

public class ConfiguracionService {
    private static final char[] ALPHANUMERIC_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public String nextCode(String currentCode) {
        if (currentCode == null || currentCode.length() != 4) {
            throw new IllegalArgumentException("The code must be exactly 4 characters long.");
        }

        char[] chars = currentCode.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '9') {
                chars[i] = 'A';
                break;
            } else if (chars[i] == 'Z') {
                chars[i] = '0';
                continue;
            } else {
                chars[i] = ALPHANUMERIC_CHARS[new String(ALPHANUMERIC_CHARS).indexOf(chars[i]) + 1];
                break;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        ConfiguracionService service = new ConfiguracionService();
        String code = "0001";

        // Test the code increment
        for (int i = 0; i < 1200; i++) { // Adjust the loop count as needed for testing
            System.out.println(code);
            code = service.nextCode(code);
        }
    }
}
