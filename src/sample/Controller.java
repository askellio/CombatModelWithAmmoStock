package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;

import static java.lang.Math.*;

public class Controller {

    @FXML
    private Button btn;

    @FXML
    private TextField editRedCount, editRedSpeed, editRedEffect, editRedStock;

    @FXML
    private TextField editBlueCount, editBlueSpeed, editBlueEffect, editBlueStock;

    @FXML
    private LineChart<Number, Number> chart;

    @FXML
    public void onClick() {
/*
        StringBuffer str = new StringBuffer(editRedCount.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните все поля");

            alert.showAndWait();
            return;
        }
        int redCount = Integer.valueOf(str.toString());

        str = new StringBuffer(editRedSpeed.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните все поля");

            alert.showAndWait();
            return;
        }
        int redSpeed = Integer.valueOf(str.toString());

        str = new StringBuffer(editRedEffect.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните все поля");

            alert.showAndWait();
            return;
        }
        double redEffect = Double.valueOf(str.toString());

        str = new StringBuffer(editRedStock.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните все поля");

            alert.showAndWait();
            return;
        }
        int redStock = Integer.valueOf(str.toString());

        str = new StringBuffer(editBlueCount.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните все поля");

            alert.showAndWait();
            return;
        }
        int blueCount = Integer.valueOf(str.toString());

        str = new StringBuffer(editBlueSpeed.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните все поля");

            alert.showAndWait();
            return;
        }
        int blueSpeed = Integer.valueOf(str.toString());

        str = new StringBuffer(editBlueEffect.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните все поля");

            alert.showAndWait();
            return;
        }
        double blueEffect = Double.valueOf(str.toString());

        str = new StringBuffer(editBlueStock.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните все поля");

            alert.showAndWait();
            return;
        }
        int blueStock = Integer.valueOf(str.toString());

*/
        NumberAxis xAxis = (NumberAxis) chart.getXAxis();
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);

        NumberAxis yAxis = (NumberAxis) chart.getYAxis();
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(1);
        yAxis.setTickUnit(0.1);

        double t=0;
        double step = 0.05;

        chart.getData().clear();
        //chart.getStylesheets().add("chat-series-line.css");

        XYChart.Series redSeries = new XYChart.Series();
        redSeries.setName("Красные");

        XYChart.Series blueSeries = new XYChart.Series();
        blueSeries.setName("Синие");

        double redMyu, blueMyu;

        double redCount = 1000;
        double blueCount = 500;

        double redSpeed = 3;
        double blueSpeed = 5;

        double redEffect = 0.3;
        double blueEffect = 0.9;

        double redStock = 1000;
        double blueStock = 50000;


        double redTempStock = redStock;
        double blueTempStock = blueStock;

        double redTempEffect = redEffect;
        double blueTempEffect = blueEffect;
        do {

            if (redTempStock == 0)
                redTempEffect = 0;

            if ((redTempStock / redSpeed) < 1)
                redTempEffect *= (redTempStock / redSpeed);

            double redM = redCount * cosh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * t);
            if (redTempEffect > 0)
                redM -= blueCount * sqrt (blueSpeed*blueTempEffect / (redSpeed*redTempEffect))
                    * sinh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * t);

            redMyu = redM / redCount;
            redSeries.getData().add(new XYChart.Data(t, redMyu));


            if (blueTempStock == 0)
                blueTempEffect = 0;

            if ((blueTempStock / blueSpeed) < 1)
                blueTempEffect *= (blueTempStock / blueSpeed);

            double blueM = blueCount * cosh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * t);
            if (blueTempEffect > 0)
                blueM -= redCount * sqrt (redSpeed*redTempEffect / (blueSpeed*blueTempEffect))
                    * sinh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * t);

            blueMyu = blueM / blueCount;
            blueSeries.getData().add(new XYChart.Data(t, blueMyu));

            redTempStock -= (redM*redTempEffect);
            blueTempStock -= (blueM*blueTempEffect);
            t+=step;
        } while ((redMyu > 0.1) && (blueMyu > 0.1) && ((blueTempStock != 0) || (redTempStock != 0)));

        xAxis.setUpperBound(t);
        xAxis.setTickUnit(t/10);

        chart.getData().addAll(redSeries, blueSeries);

        ObservableList<XYChart.Data> redDatalist = ((XYChart.Series) chart.getData().get(0)).getData();
        ObservableList<XYChart.Data> blueDatalist = ((XYChart.Series) chart.getData().get(1)).getData();

        redTempStock = redStock;
        blueTempStock = blueStock;

        redTempEffect = redEffect;
        blueTempEffect = blueEffect;

        for (int i=0; i< redDatalist.size(); i++) {
            XYChart.Data redData = redDatalist.get(i);
            Node redNode = redData.getNode();

            XYChart.Data blueData = blueDatalist.get(i);
            Node blueNode = blueData.getNode();

            if (redTempStock == 0)
                redTempEffect = 0;

            if ((redTempStock / redSpeed) < 1)
                redTempEffect *= (redTempStock / redSpeed);

            double redM = redCount * cosh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * i*step);
            if (redTempEffect > 0)
                redM -= blueCount * sqrt (blueSpeed*blueTempEffect / (redSpeed*redTempEffect))
                        * sinh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * i*step);


            if (blueTempStock == 0)
                blueTempEffect = 0;

            if ((blueTempStock / blueSpeed) < 1)
                blueTempEffect *= (blueTempStock / blueSpeed);

            double blueM = blueCount * cosh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * i*step);
            if (blueTempEffect > 0)
                blueM -= redCount * sqrt (redSpeed*redTempEffect / (blueSpeed*blueTempEffect))
                        * sinh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * i*step);

            Tooltip redTooltip = new Tooltip("Время: "+redData.getXValue().toString()+'\n'
                    +"Доля: "+redData.getYValue().toString()+'\n'
                    +"Боеприпасы: "+ceil(redTempStock)+'\n'
                    +"Численность: "+ceil(redM));
            Tooltip.install(redNode, redTooltip);

            Tooltip blueTooltip = new Tooltip("Время: "+blueData.getXValue().toString()+'\n'
                    +"Доля: "+blueData.getYValue().toString()+'\n'
                    +"Боеприпасы: "+ceil(blueTempStock)+'\n'
                    +"Численность: "+ceil(blueM));
            Tooltip.install(blueNode, blueTooltip);

            redTempStock -= (redM*redTempEffect);
            blueTempStock -= (blueM*blueTempEffect);
        }

    }
}