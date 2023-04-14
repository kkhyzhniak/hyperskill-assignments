package encryptdecrypt;

public class ShiftEncryptionAlgorithm extends Algorithm {

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public ShiftEncryptionAlgorithm(int offset, String data) {
        super(offset, data);
    }

    @Override
    String encrypt() {
        StringBuilder encryptedMessage = new StringBuilder();
        for (char symbol : data.toCharArray()) {
            if (Character.isLetter(symbol)) {
                if (Character.isLowerCase(symbol)) {
                    char encryptedSymbol =
                            ALPHABET.
                                    charAt((ALPHABET.indexOf(symbol) + offset) % 26);
                    encryptedMessage.append(encryptedSymbol);
                } else {
                    char encryptedSymbol = ALPHABET.
                            charAt((ALPHABET.indexOf(Character.toLowerCase(symbol)) + offset) % 26);
                    encryptedSymbol = Character.toUpperCase(encryptedSymbol);
                    encryptedMessage.append(encryptedSymbol);
                }
            } else {
                encryptedMessage.append(symbol);
            }
        }
        return encryptedMessage.toString();
    }

    @Override
    String decrypt() {
        StringBuilder decryptedMessage = new StringBuilder();
        for (char symbol : data.toCharArray()) {
            if (Character.isLetter(symbol)) {
                if (Character.isLowerCase(symbol)) {
                    int revertedIndex =
                            Math.floorMod(ALPHABET.indexOf(Character.toLowerCase(symbol)) - offset,
                                    26);
                    char decryptedSymbol = ALPHABET.charAt(revertedIndex);
                    decryptedMessage.append(decryptedSymbol);
                } else {
                    int revertedIndex =
                            Math.floorMod(ALPHABET.indexOf(Character.toLowerCase(symbol)) - offset,
                            26);
                    char decryptedSymbol = ALPHABET.charAt(revertedIndex);
                    decryptedSymbol = Character.toUpperCase(decryptedSymbol);
                    decryptedMessage.append(decryptedSymbol);
                }
            } else {
                decryptedMessage.append(symbol);
            }
        }
        return decryptedMessage.toString();
    }
}
