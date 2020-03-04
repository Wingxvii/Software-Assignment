package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.*;
import java.io.File;
public class Main extends Application {

    Stage _primaryStage;
    Scene startScene;
    String path;

    @Override
    public void start(Stage primaryStage) throws Exception{
        path = "file:\\\\" + System.getProperty("user.dir");

        _primaryStage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Assignment 1");

        GridPane startPane = new GridPane();

        Button q1button = new Button("Question 1");

        q1button.setOnAction(value ->  {
            System.out.println("Problem 1");
            _primaryStage.setScene(Question1Setup(root));
            _primaryStage.show();
        });

        Button q2button = new Button("Question 2");

        q2button.setOnAction(value ->  {
            System.out.println("Problem 2");
            _primaryStage.setScene(Question2Setup(root));
            _primaryStage.show();
        });

        Button q3button = new Button("Question 3");

        q3button.setOnAction(value ->  {
                System.out.println("Problem 3");
                _primaryStage.setScene(Question3Setup(root));
                _primaryStage.show();
        });

        Button q4button = new Button("Question 4");

        q4button.setOnAction(value ->  {
            System.out.println("Problem 4");
            _primaryStage.setScene(Question4Setup(root));
            _primaryStage.show();
        });

        startPane.add(q1button,0,0);
        startPane.add(q2button,1,0);
        startPane.add(q3button,2,0);
        startPane.add(q4button,3,0);

        startScene = new Scene(startPane);
        primaryStage.setScene(startScene);
        primaryStage.show();
    }

    public Scene Question1Setup(Parent root){
        GridPane problemPane = new GridPane();

        for(int counter = 0; counter < 3; counter++) {

            System.out.println(path);

            int rand = (int)(Math.random() * 53);
            ImageView newImage = new ImageView(path + "src\\" + Integer.toString(counter-1) + ".png");
            problemPane.add(newImage, counter, 1);
        }

        Button returnButton = new Button("Return");

        returnButton.setOnAction(value ->  {
                _primaryStage.setScene(startScene);
                _primaryStage.show();
        });
        problemPane.add(returnButton,0,0);

        Scene problemScene = new Scene(problemPane);
        return problemScene;
    }

    public Scene Question2Setup(Parent root){
        GridPane problemPane = new GridPane();

        Label investmentLabel = new Label("Investment Amount: ");
        Label yearsLabel = new Label("Years: ");
        Label annualIntrestLabel= new Label("Annual Intrest Rate: ");
        Label futureLabel = new Label("Future Value: ");

        TextField investmentField = new TextField();
        TextField yearsField = new TextField();
        TextField annualIntrestField = new TextField();
        Label futureField = new Label("");

        Button calculate = new Button ("Calculate");
        calculate.setOnAction(value ->  {
            double result = 0.0;
            result = Double.parseDouble(investmentField.getText()) * (Double.parseDouble(yearsField.getText()) - Double.parseDouble(annualIntrestField.getText()));
            futureField.setText(Double.toString(result));
        });

        Button returnButton = new Button("Return");

        problemPane.add(investmentLabel,0,1);
        problemPane.add(yearsLabel,0,2);
        problemPane.add(annualIntrestLabel,0,3);
        problemPane.add(futureLabel,0,4);

        problemPane.add(investmentField,1,1);
        problemPane.add(yearsField,1,2);
        problemPane.add(annualIntrestField,1,3);
        problemPane.add(futureField,1,4);

        problemPane.add(calculate,1,5);

        returnButton.setOnAction(value ->  {
            _primaryStage.setScene(startScene);
            _primaryStage.show();
        });
        problemPane.add(returnButton,0,0);

        Scene problemScene = new Scene(problemPane);
        return problemScene;
    }
    public Scene Question3Setup(Parent root){
        GridPane problemPane = new GridPane();



        Button returnButton = new Button("Return");

        returnButton.setOnAction(value ->  {
            _primaryStage.setScene(startScene);
            _primaryStage.show();
        });
        problemPane.add(returnButton,0,0);

        Scene problemScene = new Scene(problemPane);
        return problemScene;
    }
    public Scene Question4Setup(Parent root){
        GridPane problemPane = new GridPane();

        Button returnButton = new Button("Return");

        returnButton.setOnAction(value ->  {
            _primaryStage.setScene(startScene);
            _primaryStage.show();
        });
        problemPane.add(returnButton,0,0);

        Scene problemScene = new Scene(problemPane);
        return problemScene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
