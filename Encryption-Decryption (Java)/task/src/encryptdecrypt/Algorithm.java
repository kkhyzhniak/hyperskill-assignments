package encryptdecrypt;

public abstract class Algorithm {

    int offset;
    String data;

    public Algorithm(int offset, String data) {
        this.offset = offset;
        this.data = data;
    }

    abstract String encrypt();
    abstract String decrypt();



}
