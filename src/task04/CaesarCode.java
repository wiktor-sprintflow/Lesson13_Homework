package task04;

class CaesarCode {
    static final private char[] alphabet = {'A', 'Ą', 'B', 'C', 'Ć', 'D', 'E', 'Ę', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'Ł', 'M',
            'N', 'Ń', 'O', 'Ó', 'P', 'R', 'S', 'Ś', 'T', 'Q', 'U', 'W', 'Y', 'Z', 'Ź', 'Ż'};

    static String encodeText(String originalText, int code) {
        String text = originalText.toUpperCase();
        code = code % alphabet.length;
        String encodedText = "";
        for (int i = 0; i < text.length(); i++) {
            int position = isLetter(text.charAt(i));
            if (position >= 0) {
                try {
                    encodedText += alphabet[position + code];
                } catch (ArrayIndexOutOfBoundsException e) {
                    encodedText += alphabet[position + code - alphabet.length];
                }
            } else {
                encodedText += text.charAt(i);
            }
        }
        return encodedText;
    }

    static String decodeText(String encodedText, int code) {
        code = code % alphabet.length;
        String decodedText = "";
        for (int i = 0; i < encodedText.length(); i++) {
            int position = isLetter(encodedText.charAt(i));
            if (position >= 0) {
                try {
                    decodedText += alphabet[position - code];
                } catch (ArrayIndexOutOfBoundsException e) {
                    decodedText += alphabet[position - code + alphabet.length];
                }
            } else {
                decodedText += encodedText.charAt(i);
            }
        }
        return decodedText;
    }

    private static int isLetter(char character) {
        for (int i = 0; i < alphabet.length; i++) {
            if (character == alphabet[i]) {
                return i;
            }
        }
        return -1;
    }
}