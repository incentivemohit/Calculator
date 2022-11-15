package com.example.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalculatorController {


    @FXML
    private Label disOperator;
    @FXML
    private Label display;
    private Double firstValue;
    private Double secondValue;
    private String operator="";
    static boolean start=false;

    @FXML
    void handleCancelEntryButton(){
        if (start==true){
            display.setText("");
        }

    }
    @FXML
    void handleResetButton(){
        if(start==true){
            display.setText("0");
            disOperator.setText("");
        }

    }

    @FXML
    void handleBackSpaceButton(){
        if(start==true){
            char[] charArray= display.getText().toCharArray();
            if(charArray.length==0){
                return;
            }
            char[] newArray=new char[charArray.length-1];

            for(int i=0;i<charArray.length-1;i++){
                newArray[i]=charArray[i];
            }

            String str=String.valueOf(newArray);
            display.setText(str);
        }

    }

    @FXML
    void handleEvaluationButton(Double firstValue,Double secondValue,String operator) {

        switch (operator){
            case "+":  display.setText(String.valueOf(firstValue+secondValue));break;

            case "−":display.setText(String.valueOf(firstValue-secondValue));break;

            case "÷":
                if(secondValue==0){
                    return;
                }
                display.setText(String.valueOf(firstValue/secondValue));break;

            case "×":display.setText(String.valueOf(firstValue*secondValue));break;
            case "%":display.setText(String.valueOf((firstValue*100)/secondValue));break;

            default:return;

        }
    }

    @FXML
    void handleNumberButton(ActionEvent event) {

        if(start==true){
            if(display.getText().equals("0")){
                display.setText("");
            }
            String value=((Button)event.getSource()).getText();
            display.setText(display.getText()+value);
        }

    }

    @FXML
    void handleOperatorButton(ActionEvent event) {
        if(start==true){
            String value=((Button)event.getSource()).getText();

            if(!value.equals("=")){
                if(!operator.equals(""))
                    return;
                operator=value;
                firstValue=Double.parseDouble(display.getText());
                disOperator.setText(operator);
                display.setText("");
            }else{

                if(operator.equals(""))
                    return;

                secondValue=Double.parseDouble(display.getText());
                handleEvaluationButton(firstValue,secondValue,operator);
                disOperator.setText("");
                operator="";

            }
        }



    }

    @FXML
    void handleStartButton() {

        if(display.getText().equals("")){
            start=true;
            display.setText("0");
        }else {
            start=false;
            display.setText("");
        }

    }

    @FXML
    void handleSquareButton() {
        if(start==true){
            Long x=Long.parseLong(display.getText());
            display.setText(String.valueOf(x*x));
        }

    }

    @FXML
    void handleSquareRootButton() {
        if(start==true){
            Double x=Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.sqrt(x)));
        }

    }
    @FXML
    void handleOneByXButton() {
        if(start==true) {
            Double x = Double.parseDouble(display.getText());
            display.setText(String.valueOf(1 / x));
        }
    }




}
