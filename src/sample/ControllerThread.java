package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerThread {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button result;

    @FXML
    private TextField lengthHairpin;

    @FXML
    private TextField diameter;

    @FXML
    private TextField step;

    @FXML
    private TextField lengthThread;

    @FXML
    private Button switchingThread;

    @FXML
    void initialize() {
        //switching to thread
        switchingThread.setOnAction(event -> {
            switchingThread.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
//вывод результата
        });
        result.setOnAction(event -> {

            double lengthHairpin1 = Double.parseDouble(lengthHairpin.getText().replace(",", ".").trim());

            double diameter1 = Double.parseDouble(diameter.getText().replace(",", ".").trim());

            double step1 = Double.parseDouble(step.getText().replace(",", ".").trim());

            double x = result(lengthHairpin1, diameter1, step1);

            lengthThread.setText(String.valueOf(x));


        });


    }

    //метод подсчета
    private double result(double lengthHairpin, double diameter, double step) {
        double hairpin = (lengthHairpin - 0.5 * diameter - 2 * step);
        return hairpin;
    }

}
