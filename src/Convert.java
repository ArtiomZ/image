public class Convert {
    public char sort(int color) {
        char[] symbol = {'#', '$', '@', '%', '*', '+', '-', '`'};
        int i = color / 32;
        return symbol[i];
    }
}
