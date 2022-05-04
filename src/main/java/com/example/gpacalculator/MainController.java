package com.example.gpacalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

public class MainController {
    public MainController(){}
    @FXML
    private Pane mainPane;
    private ChoiceBox[] choiceBoxes;
    private ChoiceBox[] choiceBoxes1;
    ObservableList<String> choiceBoxItems = FXCollections.observableArrayList("A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "Fx", "F");
    ObservableList<String> choiceBoxItems1 = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6");
    @FXML
    private ChoiceBox<String> choiceBox1;
    @FXML
    private ChoiceBox<String> choiceBox2;
    @FXML
    private ChoiceBox<String> choiceBox3;
    @FXML
    private ChoiceBox<String> choiceBox4;
    @FXML
    private ChoiceBox<String> choiceBox5;
    @FXML
    private ChoiceBox<String> choiceBox6;
    @FXML
    private ChoiceBox<String> choiceBox7;

    @FXML
    private ChoiceBox<String> choiceBox11;
    @FXML
    private ChoiceBox<String> choiceBox21;
    @FXML
    private ChoiceBox<String> choiceBox31;
    @FXML
    private ChoiceBox<String> choiceBox41;
    @FXML
    private ChoiceBox<String> choiceBox51;
    @FXML
    private ChoiceBox<String> choiceBox61;
    @FXML
    private ChoiceBox<String> choiceBox71;

    @FXML
    private FlowPane flowPane;
    @FXML
    private TextField mainTitle;


    @FXML
    public void initialize(){
        mainTitle.setStyle("-fx-text-fill:  #ffd700; -fx-background-color:  #000000");

        final int sizeOfBoxes = 7;
        flowPane.setAlignment(Pos.CENTER);
        choiceBoxes = new ChoiceBox[sizeOfBoxes];
        choiceBoxes[0] = choiceBox1;
        choiceBoxes[1] = choiceBox2;
        choiceBoxes[2] = choiceBox3;
        choiceBoxes[3] = choiceBox4;
        choiceBoxes[4] = choiceBox5;
        choiceBoxes[5] = choiceBox6;
        choiceBoxes[6] = choiceBox7;

        for(int i = 0; i < sizeOfBoxes; ++i){
            choiceBoxes[i].setItems(choiceBoxItems);
        }

        choiceBoxes1 = new ChoiceBox[sizeOfBoxes];
        choiceBoxes1[0] = choiceBox11;
        choiceBoxes1[1] = choiceBox21;
        choiceBoxes1[2] = choiceBox31;
        choiceBoxes1[3] = choiceBox41;
        choiceBoxes1[4] = choiceBox51;
        choiceBoxes1[5] = choiceBox61;
        choiceBoxes1[6] = choiceBox71;
        for(int i = 0; i < sizeOfBoxes; ++i){
            choiceBoxes1[i].setValue("3");
            choiceBoxes1[i].setItems(choiceBoxItems1);
        }

    }

    public void onConsiderButtonCompleted() throws IOException {
        flowPane.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("getGPA-view.fxml"));
        FlowPane pane = new FlowPane();
        Scene scene = new Scene(pane, 450, 300);
        TextField gpaScore = new TextField("GPA көрсеткіші:  " + new DecimalFormat("#0.00").format(gpa()));
        gpaScore.setEditable(false);
        gpaScore.setStyle("-fx-background-color: #ffd700; -fx-font-family: Monospaced; -fx-font-size: 20");
        gpaScore.setPrefWidth(350);
        pane.getChildren().setAll(gpaScore);
        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: #000000");
        Stage stage = new Stage();
        stage.setTitle("GPA көрсеткіші");
        stage.setScene(scene);
        stage.show();
        stage.getScene().getWindow().setOnCloseRequest(windowEvent ->{
            FXMLLoader fxmlLoader1 = new FXMLLoader(GPACalculatorApplication.class.getResource("hello-view.fxml"));
            Scene scene1;
            try {
                scene1 = new Scene(fxmlLoader1.load(), 600, 400);
                Stage stage1 = new Stage();
                stage1.setTitle("Salem, bauirim!!!");
                stage1.setScene(scene1);
                stage1.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    public void onClearButtonCompleted(){
        for(int i = 0; i < choiceBoxes1.length; ++i){
            choiceBoxes[i].setValue(null);
            choiceBoxes1[i].setValue("3");
        }
    }


    private double gpa(){
        double sank = 1,gpa;
        String ball;
        int cre,sam=0;
        float sum=0;
        for(int i = 0; i < choiceBoxes1.length; ++i){
            if(choiceBoxes[i].getValue() == null)
                continue;
            cre = Integer.parseInt(choiceBoxes1[i].getValue().toString());
            sam+=cre;
            ball = (String) choiceBoxes[i].getValue();
            if(Objects.equals(ball, "A")) sank = cre * 4.00;
            if(Objects.equals(ball, "A-")) sank = cre * 3.67;
            if(Objects.equals(ball, "B+")) sank = cre * 3.33;
            if(Objects.equals(ball, "B")) sank = cre * 3.00;
            if(Objects.equals(ball, "B-")) sank = cre * 2.67;
            if(Objects.equals(ball, "C+")) sank = cre * 2.33;
            if(Objects.equals(ball, "C")) sank = cre * 2.00;
            if(Objects.equals(ball, "C-")) sank = cre * 1.67;
            if(Objects.equals(ball, "D+")) sank = cre * 1.33;
            if(Objects.equals(ball, "D")) sank = cre * 1.00;
            if(Objects.equals(ball, "Fx")) sank = cre * 0.50;
            if(Objects.equals(ball, "F")) sank = 0;
            sum+=sank;
        }
        if(sam == 0)
            gpa = 0;
        else
            gpa = sum/sam;
        return gpa;
    }
}