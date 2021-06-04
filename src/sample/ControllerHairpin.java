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

public class ControllerHairpin {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button result;

    @FXML
    private TextField thread;

    @FXML
    private TextField stepThread;

    @FXML
    private TextField profileP;

    @FXML
    private Button bolt;

    @FXML
    private TextField depthX;


    @FXML
    void initialize() {
        //switching to a hairpin
        bolt.setOnAction(event -> {
            bolt.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/app.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();


        });
        result.setOnAction(event -> {
            double thread1 = Double.parseDouble(thread.getText().replace(",", ".").trim());

            double stepThread1 = Double.parseDouble(stepThread.getText().replace(",", ".").trim());

            double x = x(thread1, stepThread1);
            double p = p(stepThread1);

            depthX.setText(String.valueOf(x));
            profileP.setText(String.valueOf(p));
        });

    }

    private double p(double stepThread) {
        double p = (0.62 * stepThread) * 1000;
        return p;
    }

    private double x(double thread, double stepThread) {
        double x = (0.62 * stepThread * 2);
        double res = thread - x;
        return res;
    }


}

