public abstract class MathQuestion implements MathQuestionable {
    private final int x;
    private final int y;

    MathQuestion() {
        this(
            RANDOM.nextInt(MAX_LARGE) + 1,
            RANDOM.nextInt(MAX_SMALL) + 1
        );
    }

    MathQuestion(int px, int py) {
        x = px;
        y = py;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getQuestion(OperationType op) {
        return "What is " + x + ' ' + op.getSymbol() + ' ' + y + '?';
    }
}


class AdditionQuestion extends MathQuestion {
    public AdditionQuestion() {
        super();
    }

    public AdditionQuestion(int px, int py) {
        super(px, py);
    }

    public String getQuestion() {
        return super.getQuestion(OperationType.ADD);
    }

    public int getCorrectAnswer() {
        return getX() + getY();
    }
}


class DivisionQuestion extends MathQuestion {
    private static int _x = RANDOM.nextInt(MAX_LARGE) + 1;
    private static int _y = RANDOM.nextInt(_x) + 1;

    public DivisionQuestion() {
        super(_x, _y);
        _x = RANDOM.nextInt(MAX_LARGE) + 1;
        _y = RANDOM.nextInt(_x) + 1;
    }

    public DivisionQuestion(int px, int py) {
        super(px, py);
    }

    public String getQuestion() {
        return super.getQuestion(OperationType.DIVIDE);
    }

    public int getCorrectAnswer() {
        return getX() / getY();
    }
}


class ExponentQuestion extends MathQuestion {
    private static int _x = RANDOM.nextInt(MAX_BASE) + 1;
    private static int _y = RANDOM.nextInt(MAX_EXPONENT);

    public ExponentQuestion() {
        super(_x, _y);
        _x = RANDOM.nextInt(MAX_BASE) + 1;
        _y = RANDOM.nextInt(MAX_EXPONENT);
    }

    public ExponentQuestion(int px, int py) {
        super(px, py);
    }

    public String getQuestion() {
        return super.getQuestion(OperationType.EXPONENT);
    }

    public int getCorrectAnswer() {
        return (int) Math.pow(getX(), getY());
    }
}


class ModuloQuestion extends MathQuestion {
    private static int _x = RANDOM.nextInt(MAX_LARGE) + 1;
    private static int _y = RANDOM.nextInt(_x) + 1;

    public ModuloQuestion() {
        super(_x, _y);
        _x = RANDOM.nextInt(MAX_LARGE) + 1;
        _y = RANDOM.nextInt(_x) + 1;
    }

    public ModuloQuestion(int px, int py) {
        super(px, py);
    }

    public String getQuestion() {
        return super.getQuestion(OperationType.MODULO);
    }

    public int getCorrectAnswer() {
        return getX() % getY();
    }
}


class MultiplicationQuestion extends MathQuestion {
    private static int _x = RANDOM.nextInt(MAX_MULTIPLE) + 1;
    private static int _y = RANDOM.nextInt(MAX_MULTIPLE) + 1;

    public MultiplicationQuestion() {
        super(_x, _y);
        _x = RANDOM.nextInt(MAX_MULTIPLE) + 1;
        _y = RANDOM.nextInt(MAX_MULTIPLE) + 1;
    }

    public MultiplicationQuestion(int px, int py) {
        super(px, py);
    }

    public String getQuestion() {
        return super.getQuestion(OperationType.MULTIPLY);
    }

    public int getCorrectAnswer() {
        return getX() * getY();
    }
}


class SubtractionQuestion extends MathQuestion {
    private static int _x = RANDOM.nextInt(MAX_SMALL) + MAX_SMALL + 1;
    private static int _y = RANDOM.nextInt(MAX_SMALL) + 1;

    public SubtractionQuestion() {
        super(_x, _y);
        _x = RANDOM.nextInt(MAX_SMALL) + MAX_SMALL + 1;
        _y = RANDOM.nextInt(MAX_SMALL) + 1;
    }

    public SubtractionQuestion(int px, int py) {
        super(px, py);
    }

    public String getQuestion() {
        return super.getQuestion(OperationType.SUBTRACT);
    }

    public int getCorrectAnswer() {
        return getX() - getY();
    }
}
