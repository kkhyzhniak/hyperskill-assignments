package encryptdecrypt;

public class UnicodeEncryptionAlgorithm extends Algorithm {

    public UnicodeEncryptionAlgorithm(int offset, String data) {
      super(offset, data);
    }

    @Override
    public String encrypt() {
        char[] charMessage = data.toCharArray();
        StringBuilder encryptedMessage = new StringBuilder();
        for (char symbol : charMessage) {
            char encryptedSymbol = (char) (symbol + offset);
            encryptedMessage.append(encryptedSymbol);
        }
        return encryptedMessage.toString();
    }

    @Override
    public String decrypt() {
        char[] charMessage = data.toCharArray();
        StringBuilder decryptedMessage = new StringBuilder();
        for (char symbol : charMessage) {
            char encryptedSymbol = (char) (symbol - offset);
            decryptedMessage.append(encryptedSymbol);
        }
        return decryptedMessage.toString();
    }
}
