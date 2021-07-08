//Replace this class code with your solution to the Chapter 12 zyLab

public abstract class MathQuestion implements MathQuestionable {
    // TODO: Declare private member integer constants x and y

    // TODO: Define a default (no parameters) constructor that assigns
    // x to RANDOM.nextInt(MAX_LARGE) + 1
    // y to RANDOM.nextInt(MAX_SMALL) + 1

    // TODO: Define a parameterized constructor that accepts two integer values
    // The first parameter must be assigned to x
    // The second parameter must be assigned to y

    // TODO: Define public accessor methods getX() and getY()


    public String getQuestion(OperationType op) {
        return "What is " + x + ' ' + op.getSymbol() + ' ' + y + '?';
    }

}

class AdditionQuestion extends MathQuestion {
    // A video walk-through will be provided for how to write the code for this class
}

class DivisionQuestion extends MathQuestion {
    private static final int _x = RANDOM.nextInt(MAX_LARGE) + 1;
    private static final int _y = RANDOM.nextInt(_x) + 1;

    // TODO: Define default constructor to call parent class constructor and passing _x and _y as arguments
    // You will also need to reassign new random values to both _x and _y as shown in the initial assignment statements

    // TODO: Define a parameterized constructor that accepts two integers and passes these in a call to the parent constructor

    // TODO: Define getQuestion that returns a String and makes a call to the parent getQuestion method.
    // You will need to pass OperationType.DIVIDE as the argument

    // TODO: Define getCorrectAnswer that returns an integer result of x / y (this is not as simple as it looks!)

}

class ExponentQuestion extends MathQuestion {
    private static final int _x = RANDOM.nextInt(MAX_BASE) + 1;
    private static final int _y = RANDOM.nextInt(MAX_EXPONENT);

    // TODO: Define default constructor to call parent class constructor and passing _x and _y as arguments
    // You will also need to reassign new random values to both _x and _y as shown in the initial assignment statements

    // TODO: Define a parameterized constructor that accepts two integers and passes these in a call to the parent constructor

    // TODO: Define getQuestion that returns a String and makes a call to the parent getQuestion method.
    // You will need to pass OperationType.EXPONENT as the argument

    // TODO: Define getCorrectAnswer that returns an integer result of Math.pow(x, y) (this is not as simple as it looks!)

}

class ModuloQuestion extends MathQuestion {
    private static final int _x = RANDOM.nextInt(MAX_LARGE) + 1;
    private static final int _y = RANDOM.nextInt(_x) + 1;

    // TODO: Define default constructor to call parent class constructor and passing _x and _y as arguments
    // You will also need to reassign new random values to both _x and _y as shown in the initial assignment statements

    // TODO: Define a parameterized constructor that accepts two integers and passes these in a call to the parent constructor

    // TODO: Define getQuestion that returns a String and makes a call to the parent getQuestion method.
    // You will need to pass OperationType.MODULO as the argument

    // TODO: Define getCorrectAnswer that returns an integer result of x % y (this is not as simple as it looks!)
}

class MultiplicationQuestion extends MathQuestion {
    private static final int _x = RANDOM.nextInt(MAX_MULTIPLE) + 1;
    private static final int _y = RANDOM.nextInt(MAX_MULTIPLE) + 1;

    // TODO: Define default constructor to call parent class constructor and passing _x and _y as arguments
    // You will also need to reassign new random values to both _x and _y as shown in the initial assignment statements

    // TODO: Define a parameterized constructor that accepts two integers and passes these in a call to the parent constructor

    // TODO: Define getQuestion that returns a String and makes a call to the parent getQuestion method.
    // You will need to pass OperationType.MULTIPLY as the argument

    // TODO: Define getCorrectAnswer that returns an integer result of x * y (this is not as simple as it looks!)

}

class SubtractionQuestion extends MathQuestion {
    private static final int _x = RANDOM.nextInt(MAX_SMALL) + MAX_SMALL + 1;
    private static final int _y = RANDOM.nextInt(MAX_SMALL) + 1;

    // TODO: Define default constructor to call parent class constructor and passing _x and _y as arguments
    // You will also need to reassign new random values to both _x and _y as shown in the initial assignment statements

    // TODO: Define a parameterized constructor that accepts two integers and passes these in a call to the parent constructor

    // TODO: Define getQuestion that returns a String and makes a call to the parent getQuestion method.
    // You will need to pass OperationType.SUBTRACT as the argument

    // TODO: Define getCorrectAnswer that returns an integer result of x - y (this is not as simple as it looks!)

}

