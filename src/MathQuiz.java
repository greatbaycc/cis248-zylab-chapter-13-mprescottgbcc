import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MathQuiz extends Application {
    private static MathQuestion question;
    private static boolean isChecking = true;
    private static int questionCount = 1;
    private static int score = 0;
    private final int NUM_QUESTIONS = 5;
    private TextField answerField;
    private Label questionLabel;
    private Label resultLabel;
    private Label finalResultLabel;
    private Button answerButton;

    /**
     * Generates a random MathQuestion object of the valid operation
     * types.
     *
     * @return MathQuestion
     */
    private static MathQuestion getRandomQuestion() {
        OperationType op = OperationType.getRandom();
        switch (op) {
            case ADD:
                return new AdditionQuestion();
            case SUBTRACT:
                return new SubtractionQuestion();
            case MULTIPLY:
                return new MultiplicationQuestion();
            case EXPONENT:
                return new ExponentQuestion();
            case DIVIDE:
                return new DivisionQuestion();
            case MODULO:
                return new ModuloQuestion();
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        launch(args); // Launch application
    }

    @Override
    public void start(Stage appStage) {
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        question = getRandomQuestion();
        resultLabel = new Label();
        questionLabel = new Label(question.getQuestion());

        Label answerLabel = new Label("Answer");

        answerField = new TextField();
        answerField.setEditable(true);
        answerField.setPrefColumnCount(10);

        answerButton = new Button("Check Answer");
        answerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isChecking) {
                    int answer = question.getCorrectAnswer();
                    int userInput = Integer.parseInt(answerField.getText());
                    if (userInput == answer) {
                        resultLabel.setText(answer + " is correct!");
                        score++;
                    } else {
                        resultLabel.setText("Sorry! It's " + answer);
                    }
                    answerButton.setText("Next question");
                    isChecking = false;
                } else {
                    if (questionCount < NUM_QUESTIONS) {
                        questionCount++;
                        question = getRandomQuestion();
                        questionLabel.setText(question.getQuestion());
                        resultLabel.setText("");
                        answerButton.setText("Check Answer");
                        isChecking = true;
                    } else {
                        questionLabel.setText("QUIZ OVER!");
                        resultLabel.setText("Your score is " + score);
                        answerButton.setVisible(false);
                        answerLabel.setVisible(false);
                        answerField.setVisible(false);
                    }
                    answerField.setText("");
                }
            }
        });

        gridPane.add(questionLabel, 0, 0);
        gridPane.add(answerLabel, 0, 1);
        gridPane.add(answerField, 1, 1);
        gridPane.add(answerButton, 0, 2);
        gridPane.add(resultLabel, 0, 3);
        appStage.setScene(scene);
        appStage.setTitle("Math Quiz");
        appStage.show();
    }
}
