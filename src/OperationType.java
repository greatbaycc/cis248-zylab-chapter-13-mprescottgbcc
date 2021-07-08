import java.util.Random;

public enum OperationType {
    ADD, SUBTRACT, MULTIPLY, EXPONENT, DIVIDE, MODULO;

    private static final Random RANDOM = new Random(5);

    public static OperationType getRandom() {
        OperationType[] values = OperationType.values();
        int length = values.length;
        return values[RANDOM.nextInt(length)];
    }

    public char getSymbol() {
        switch (this) {
            case ADD:
                return '+';
            case SUBTRACT:
                return '-';
            case MULTIPLY:
                return '*';
            case EXPONENT:
                return '^';
            case DIVIDE:
                return '/';
            case MODULO:
                return '%';
            default:
                throw new IllegalArgumentException();
        }
    }
}
