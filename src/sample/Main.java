package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.*;

public class Main extends Application {

    Stage _primaryStage;
    Scene startScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
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

        Button returnButton = new Button("Return");

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
