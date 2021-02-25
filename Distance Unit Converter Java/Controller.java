package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    @FXML
    public TextField input;
    @FXML
    public TextField output;
    @FXML
    public TextField need;
    @FXML
    public TextField become;
    @FXML
    public MenuItem inputMenu1;
    @FXML
    public MenuItem inputMenu2;
    @FXML
    public MenuItem outputMenu1;
    @FXML
    public MenuItem outputMenu2;
    @FXML
    public MenuItem inputMenu3;
    @FXML
    public MenuItem outputMenu3;
    @FXML
    public MenuItem inputMenu4;
    @FXML
    public MenuItem outputMenu4;
    @FXML
    public MenuItem inputMenu5;
    @FXML
    public MenuItem outputMenu5;
    @FXML
    public MenuItem inputMenu6;
    @FXML
    public MenuItem outputMenu6;
    @FXML
    public MenuItem inputMenu7;
    @FXML
    public MenuItem outputMenu7;

    @FXML
    public void writeIn1() {
        need.clear();
        need.appendText(inputMenu1.getText());
    }
    @FXML
    public void writeIn2() {
        need.clear();
        need.appendText(inputMenu2.getText());
    }
    @FXML
    public void writeIn3() {
        need.clear();
        need.appendText(inputMenu3.getText());
    }
    @FXML
    public void writeIn4() {
        need.clear();
        need.appendText(inputMenu4.getText());
    }
    @FXML
    public void writeIn5(ActionEvent actionEvent) {
        need.clear();
        need.appendText(inputMenu5.getText());
    }
    @FXML
    public void writeIn6(ActionEvent actionEvent) {
        need.clear();
        need.appendText(inputMenu6.getText());
    }
    @FXML
    public void writeIn7(ActionEvent actionEvent) {
        need.clear();
        need.appendText(inputMenu7.getText());
    }

    @FXML
    public void writeOut1() {
        become.clear();
        become.appendText(outputMenu1.getText());
    }
    @FXML
    public void writeOut2() {
        become.clear();
        become.appendText(outputMenu2.getText());
    }
    @FXML
    public void writeOut3() {
        become.clear();
        become.appendText(outputMenu3.getText());
    }
    @FXML
    public void writeOut4() {
        become.clear();
        become.appendText(outputMenu4.getText());
    }
    @FXML
    public void writeOut5(ActionEvent actionEvent) {
        become.clear();
        become.appendText(outputMenu5.getText());
    }
    @FXML
    public void writeOut6(ActionEvent actionEvent) {
        become.clear();
        become.appendText(outputMenu6.getText());
    }
    @FXML
    public void writeOut7(ActionEvent actionEvent) {
        become.clear();
        become.appendText(outputMenu7.getText());
    }


    @FXML
    public void btnOneClickAction(ActionEvent actionEvent) {
        output.clear();
        try {
            output.setText(String.format("%.3f", calculate(need.getText(), become.getText())));
        } catch (NumberFormatException e) {
            input.clear();
            output.setText("<- Enter a number");
        }
        input.requestFocus();
    }

    @FXML
    public void clearChat(ActionEvent actionEvent) {
        output.clear();
        input.clear();
    }

    /**
     * The method analyzes the input and calculates the output length units,
     * the names of which are entered as parameters
     * @param inputCalc String
     * @param outputCalc String
     * @return double
     * @throws NumberFormatException
     */
    public double calculate(String inputCalc, String outputCalc) throws NumberFormatException {
        double enter = 0;
        enter = Double.parseDouble(input.getText());

        HashMap<String, Double> values = new HashMap<>();

        if (inputCalc.equals("centimeters")){
            values.put("kilometers", 1e-5);
            values.put("yards", 0.0109361);
            values.put("miles", 6.213693181818e-6);
            values.put("feet", 0.032808299999999041008);
            values.put("meters", 0.01);
            values.put("inches", 0.39369980905511814395);
        }
        if (inputCalc.equals("meters")){
            values.put("kilometers", 0.001);
            values.put("yards", 1.0936132983377078);
            values.put("miles", 0.000621371);
            values.put("feet", 3.2808300000000083507);
            values.put("centimeters", 100.0);
            values.put("inches", 39.36998090551180951);
        }
        if (inputCalc.equals("kilometers")){
            values.put("meters", 1000.0);
            values.put("yards", 1093.61);
            values.put("miles", 0.62136931818182);
            values.put("feet", 3280.8300000000085674);
            values.put("centimeters", 100000.0);
            values.put("inches", 39369.980905511809397);
        }
        if (inputCalc.equals("miles")){
            values.put("meters", 1609.3391462185006731);
            values.put("kilometers", 1.6093391462185007157);
            values.put("yards", 1759.994691840005089);
            values.put("feet", 5279.9840755200139029);
            values.put("centimeters", 160934.0);
            values.put("inches", 63359.8425504);
        }
        if (inputCalc.equals("yards")){
            values.put("meters", 0.9143972421696024977);
            values.put("kilometers", 0.00091439724216960246647);
            values.put("miles", 0.00056818010454545611176);
            values.put("feet", 2.9999909520000080931);
            values.put("centimeters", 91.4397727716);
            values.put("inches", 35.99991054);
        }
        if (inputCalc.equals("feet")){
            values.put("meters", 0.30479908072320083257);
            values.put("kilometers", 0.00030479908072320082216);
            values.put("miles", 0.00018939336818181868585);
            values.put("yards", 0.33333232800000089924);
            values.put("centimeters", 30.4799242572);
            values.put("inches", 11.99997018);
        }
        if (inputCalc.equals("inches")){
            values.put("meters", 0.025399936881);
            values.put("kilometers", 2.5399936881e-5);
            values.put("miles", 1.57827890625e-5);
            values.put("yards", 0.02777770875);
            values.put("centimeters", 2.5399936881);
            values.put("feet", 0.08333312625);
        }

        if (inputCalc.equals(outputCalc))
            return enter;

        for (Map.Entry<String, Double> digit : values.entrySet()) {
            if (outputCalc.equals(digit.getKey()))
                return enter * digit.getValue();
        }
        return 0;
    }



}


