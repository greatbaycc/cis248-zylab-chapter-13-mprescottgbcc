package mathquiz;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MathQuizSimple extends Application {
    private static MathQuestion question;
    private TextField answerField;
    private Label resultLabel;

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

        Label answerLabel = new Label("Answer");
        Label questionLabel = new Label(question.getQuestion());

        answerField = new TextField();
        answerField.setEditable(true);
        answerField.setPrefColumnCount(10);

        Button answerButton = new Button("Check Answer");
        answerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int answer = question.getCorrectAnswer();
                try {
                    int userInput = Integer.parseInt(answerField.getText());
                    if (userInput == answer) {
                        resultLabel.setText(answer + " is correct!");
                    } else {
                        resultLabel.setText("Sorry! It's " + answer);
                    }
                } catch (NumberFormatException e) {
                    resultLabel.setText("Invalid! Try again");
                    answerField.setText("");
                }
            }
        });

        Button newQuestionButton = new Button("New Question");
        newQuestionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                question = getRandomQuestion();
                questionLabel.setText(question.getQuestion());
                answerField.setText("");
            }
        });

        gridPane.add(questionLabel, 0, 0);      //column 0, row 0
        gridPane.add(answerLabel, 0, 1);        //column 0, row 1
        gridPane.add(answerField, 1, 1);        //column 1, row 1
        gridPane.add(answerButton, 0, 2);       //column 0, row 2
        gridPane.add(newQuestionButton, 1, 2);  //column 1, row 2
        gridPane.add(resultLabel, 0, 3);        //column 0, row 3
        appStage.setScene(scene);
        appStage.setTitle("Math Quiz");
        appStage.show();
    }
}
