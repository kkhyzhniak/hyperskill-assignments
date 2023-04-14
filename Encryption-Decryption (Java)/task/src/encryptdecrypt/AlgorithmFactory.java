package encryptdecrypt;

public class AlgorithmFactory
{
    public static Algorithm createAlgorithm(String type, int offset, String data) {
        return switch (type) {
            case "shift" -> new ShiftEncryptionAlgorithm(offset, data);
            case "unicode" -> new UnicodeEncryptionAlgorithm(offset, data);
            default -> null;
        };
    }
}
