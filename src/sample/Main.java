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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.geometry.Point2D;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.FileChooser;

public class Main extends Application {

    Stage _primaryStage;
    Scene startScene;

    //problem 3 data
    Circle bigCircle = new Circle(120,120,100, Color.WHITE);
    Circle smallCircle1 = new Circle(120,20,10,Color.RED);
    Circle smallCircle2 = new Circle(20,120,10,Color.RED);
    Circle smallCircle3 = new Circle(120,220,10,Color.RED);

    Text text1 = new Text();
    Text text2 = new Text();
    Text text3 = new Text();

    Line line1 = new Line();
    Line line2 = new Line();
    Line line3 = new Line();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //setup
        _primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Assignment 1");

        //create main menu buttons
        GridPane startPane = new GridPane();

        //button for q1
        Button q1button = new Button("Question 1");
        q1button.setOnAction(value ->  {
            System.out.println("Problem 1");
            _primaryStage.setScene(Question1Setup(root));
            _primaryStage.show();
        });

        //button for q2
        Button q2button = new Button("Question 2");
        q2button.setOnAction(value ->  {
            System.out.println("Problem 2");
            _primaryStage.setScene(Question2Setup(root));
            _primaryStage.show();
        });

        //button for q3
        Button q3button = new Button("Question 3");
        q3button.setOnAction(value ->  {
                System.out.println("Problem 3");
                _primaryStage.setScene(Question3Setup(root));
                _primaryStage.show();
        });

        //button for q4
        Button q4button = new Button("Question 4");
        q4button.setOnAction(value ->  {
            System.out.println("Problem 4");
            _primaryStage.setScene(Question4Setup(root));
            _primaryStage.show();
        });

        //add buttons
        startPane.add(q1button,0,0);
        startPane.add(q2button,1,0);
        startPane.add(q3button,2,0);
        startPane.add(q4button,3,0);

        //setup stage
        startScene = new Scene(startPane);
        primaryStage.setScene(startScene);
        primaryStage.show();
    }


    //code for question 1
    public Scene Question1Setup(Parent root){
        GridPane problemPane = new GridPane();

        //3 random cards
        for(int counter = 0; counter < 3; counter++) {
            int rand = (int)(Math.random() * 53);
            ImageView newImage = new ImageView("./images/" + rand + ".png");
            problemPane.add(newImage, counter, 1);
        }

        //setup return button
        Button returnButton = new Button("Return");
        returnButton.setOnAction(value ->  {
                _primaryStage.setScene(startScene);
                _primaryStage.show();
        });
        problemPane.add(returnButton,0,0);

        //return
        Scene problemScene = new Scene(problemPane);
        return problemScene;
    }
    //code for question 2
    public Scene Question2Setup(Parent root){
        GridPane problemPane = new GridPane();

        //init labels
        Label investmentLabel = new Label("Investment Amount: ");
        Label yearsLabel = new Label("Years: ");
        Label annualIntrestLabel= new Label("Annual Intrest Rate: ");
        Label futureLabel = new Label("Future Value: ");

        //init text fields
        TextField investmentField = new TextField();
        TextField yearsField = new TextField();
        TextField annualIntrestField = new TextField();
        Label futureField = new Label("");

        //calculate
        Button calculate = new Button ("Calculate");
        calculate.setOnAction(value ->  {
            double result = 0.0;
            result = Double.parseDouble(investmentField.getText()) * Math.pow(Double.parseDouble(annualIntrestField.getText()),Double.parseDouble(yearsField.getText()));
            futureField.setText(Double.toString(result));
        });

        //add nodes to pane
        problemPane.add(investmentLabel,0,1);
        problemPane.add(yearsLabel,0,2);
        problemPane.add(annualIntrestLabel,0,3);
        problemPane.add(futureLabel,0,4);

        problemPane.add(investmentField,1,1);
        problemPane.add(yearsField,1,2);
        problemPane.add(annualIntrestField,1,3);
        problemPane.add(futureField,1,4);

        problemPane.add(calculate,1,5);

        //setup return button
        Button returnButton = new Button("Return");
        returnButton.setOnAction(value ->  {
            _primaryStage.setScene(startScene);
            _primaryStage.show();
        });
        problemPane.add(returnButton,0,0);

        //return
        Scene problemScene = new Scene(problemPane);
        return problemScene;
    }
    //code for question 3
    public Scene Question3Setup(Parent root){
        GridPane outterProblemPane = new GridPane();
        Pane problemPane = new Pane();

        //setup shapes
        bigCircle.setStroke(Color.BLACK);
        updateAngle();
        updateLines();
        problemPane.getChildren().addAll(bigCircle, smallCircle1, smallCircle2, smallCircle3, line1, line2, line3, text1, text2, text3);

        //setup mouse drag events
        smallCircle1.setOnMouseDragged(e -> {
            //calculate point on circle
            double vX = e.getX() - 120;
            double vY = e.getY() - 120;
            double magV = Math.sqrt(vX*vX + vY*vY);
            double aX = 120 + vX / magV * 100;
            double aY = 120 + vY / magV * 100;

            //move small circle
            smallCircle1.setCenterX(aX);
            smallCircle1.setCenterY(aY);

            //update
            updateAngle();
            updateLines();
        });

        smallCircle2.setOnMouseDragged(e -> {
            double vX = e.getX() - 120;
            double vY = e.getY() - 120;
            double magV = Math.sqrt(vX*vX + vY*vY);
            double aX = 120 + vX / magV * 100;
            double aY = 120 + vY / magV * 100;

            smallCircle2.setCenterX(aX);
            smallCircle2.setCenterY(aY);
            updateAngle();
            updateLines();
        });

        smallCircle3.setOnMouseDragged(e -> {
            double vX = e.getX() - 120;
            double vY = e.getY() - 120;
            double magV = Math.sqrt(vX*vX + vY*vY);
            double aX = 120 + vX / magV * 100;
            double aY = 120 + vY / magV * 100;

            smallCircle3.setCenterX(aX);
            smallCircle3.setCenterY(aY);
            updateAngle();
            updateLines();
        });

        //add to pane
        outterProblemPane.add(problemPane, 0,1);

        //setup buttons
        Button returnButton = new Button("Return");
        returnButton.setOnAction(value ->  {
            _primaryStage.setScene(startScene);
            _primaryStage.show();
        });
        outterProblemPane.add(returnButton,0,0);

        //return
        Scene problemScene = new Scene(outterProblemPane, 300, 250);
        return problemScene;
    }
    //code for question 4
    public Scene Question4Setup(Parent root ){
        GridPane problemPane = new GridPane();
        FileChooser fileChooser = new FileChooser();

        //setup graph
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("All Letters");
        xAxis.setLabel("Letters");
        yAxis.setLabel("Value");

        //init chart
        int[] chars = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        updateGraph(chars, bc);

        //setup file selection
        Button fileChooserButton = new Button("Select Text File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //file selection
        fileChooserButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(_primaryStage);
            //read from file
            try {
                BufferedReader br = new BufferedReader(new FileReader(selectedFile.toString()));
                String st;
                int[] allchars = new int[26];

                //parse through all lines
                while ((st = br.readLine()) != null){

                    char[] dataChar = st.toCharArray();

                    for(char letter : dataChar){
                        if((int)letter >= 65 && (int)letter <=90){
                            allchars[((int)letter) - 65]++;
                        }
                        if((int)letter >= 97 && (int)letter <=122){
                            allchars[((int)letter) - 97]++;
                        }
                    }
                }

                //call update
                updateGraph(allchars, bc);

            }
            //error handling
            catch(FileNotFoundException ex){
                System.out.println("Error");
            }catch (IOException ex){
                System.out.println("Error");
            }
        });

        //add to pane
        problemPane.add(fileChooserButton,0,2);
        problemPane.add(bc,0,1);

        //setup button
        Button returnButton = new Button("Return");
        returnButton.setOnAction(value ->  {
            _primaryStage.setScene(startScene);
            _primaryStage.show();
        });
        problemPane.add(returnButton,0,0);

        //return
        Scene problemScene = new Scene(problemPane);
        return problemScene;
    }

    //update function for angles in q3
    void updateAngle() {

        double a = new Point2D(smallCircle3.getCenterX(), smallCircle3.getCenterY()).distance(smallCircle2.getCenterX(), smallCircle2.getCenterY());
        double b = new Point2D(smallCircle3.getCenterX(), smallCircle3.getCenterY()).distance(smallCircle1.getCenterX(), smallCircle1.getCenterY());
        double c = new Point2D(smallCircle2.getCenterX(), smallCircle2.getCenterY()).distance(smallCircle1.getCenterX(), smallCircle1.getCenterY());

        text1.setX(smallCircle1.getCenterX());
        text1.setY(smallCircle1.getCenterY() - 10);
        text1.setText(String.format("%.2f", Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)))));

        text2.setX(smallCircle2.getCenterX());
        text2.setY(smallCircle2.getCenterY() - 10);
        text2.setText(String.format("%.2f", Math.toDegrees(Math.acos((b * b - a * a - c * c) / (-2 * a * c)))));

        text3.setX(smallCircle3.getCenterX());
        text3.setY(smallCircle3.getCenterY() - 10);
        text3.setText(String.format("%.2f", Math.toDegrees(Math.acos((c * c - b * b - a * a) / (-2 * a * b)))));

    }

    //update function for lines in q3
    void updateLines(){
        line1.setStartX(smallCircle1.getCenterX());
        line1.setEndX(smallCircle2.getCenterX());
        line1.setStartY(smallCircle1.getCenterY());
        line1.setEndY(smallCircle2.getCenterY());
        line2.setStartX(smallCircle1.getCenterX());
        line2.setEndX(smallCircle3.getCenterX());
        line2.setStartY(smallCircle1.getCenterY());
        line2.setEndY(smallCircle3.getCenterY());
        line3.setStartX(smallCircle2.getCenterX());
        line3.setEndX(smallCircle3.getCenterX());
        line3.setStartY(smallCircle2.getCenterY());
        line3.setEndY(smallCircle3.getCenterY());
    }

    //update function for q4
    void updateGraph(int[] letters, BarChart<String,Number> bc){
        XYChart.Series series1 = new XYChart.Series();

        series1.getData().add(new XYChart.Data("A", letters[0]));
        series1.getData().add(new XYChart.Data("B", letters[1]));
        series1.getData().add(new XYChart.Data("C", letters[2]));
        series1.getData().add(new XYChart.Data("D", letters[3]));
        series1.getData().add(new XYChart.Data("E", letters[4]));
        series1.getData().add(new XYChart.Data("F", letters[5]));
        series1.getData().add(new XYChart.Data("G", letters[6]));
        series1.getData().add(new XYChart.Data("H", letters[7]));
        series1.getData().add(new XYChart.Data("I", letters[8]));
        series1.getData().add(new XYChart.Data("J", letters[9]));
        series1.getData().add(new XYChart.Data("K", letters[10]));
        series1.getData().add(new XYChart.Data("L", letters[11]));
        series1.getData().add(new XYChart.Data("M", letters[12]));
        series1.getData().add(new XYChart.Data("N", letters[13]));
        series1.getData().add(new XYChart.Data("O", letters[14]));
        series1.getData().add(new XYChart.Data("P", letters[15]));
        series1.getData().add(new XYChart.Data("Q", letters[16]));
        series1.getData().add(new XYChart.Data("R", letters[17]));
        series1.getData().add(new XYChart.Data("S", letters[18]));
        series1.getData().add(new XYChart.Data("T", letters[19]));
        series1.getData().add(new XYChart.Data("U", letters[20]));
        series1.getData().add(new XYChart.Data("V", letters[21]));
        series1.getData().add(new XYChart.Data("W", letters[22]));
        series1.getData().add(new XYChart.Data("X", letters[23]));
        series1.getData().add(new XYChart.Data("Y", letters[24]));
        series1.getData().add(new XYChart.Data("Z", letters[25]));

        bc.getData().clear();
        bc.getData().addAll(series1);
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }


}
