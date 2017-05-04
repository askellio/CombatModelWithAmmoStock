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

        //проверка ввода всех параметров
        // ввод букв вместо цифр не проверяется
        // эффективность должна изменяться от 0 до 1
        // остальные значения в целых
        // добавлена проверка на буквы
        // и проверка эффективности на промежуток 0..1

        StringBuffer str = new StringBuffer(editRedCount.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните поле \"Количество\"");

            alert.showAndWait();
            return;
        }
        int redCount;
        try {
            redCount = Integer.valueOf(str.toString());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Количество должно быть целым числом");

            alert.showAndWait();
            return;
        }

        str = new StringBuffer(editRedSpeed.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните поле \"Скорострельность\"");

            alert.showAndWait();
            return;
        }
        int redSpeed;
        try {
            redSpeed = Integer.valueOf(str.toString());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Скорострельность должна быть целым числом");

            alert.showAndWait();
            return;
        }

        str = new StringBuffer(editRedEffect.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните поле \"Вероятность попадания\"");

            alert.showAndWait();
            return;
        }
        double redEffect;
        try {
            redEffect = Double.valueOf(str.toString());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Вероятность попадания должна быть числом в [0..1]");

            alert.showAndWait();
            return;
        }

        if ((redEffect < 0) || (redEffect > 1)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Вероятность попадания должна числом быть в [0..1]");

            alert.showAndWait();
            return;
        }

        str = new StringBuffer(editRedStock.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните поле \"Запасы боеприпасов\"");

            alert.showAndWait();
            return;
        }
        int redStock;
        try {
            redStock = Integer.valueOf(str.toString());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Запасы боеприпасов должны быть целым числом");

            alert.showAndWait();
            return;
        }

        str = new StringBuffer(editBlueCount.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните поле \"Количество\"");

            alert.showAndWait();
            return;
        }
        int blueCount;
        try {
            blueCount = Integer.valueOf(str.toString());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Количество должно быть целым числом");

            alert.showAndWait();
            return;
        }

        str = new StringBuffer(editBlueSpeed.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните поле \"Скорострельность\"");

            alert.showAndWait();
            return;
        }
        int blueSpeed;
        try {
            blueSpeed = Integer.valueOf(str.toString());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Скорострельность должна быть целым числом");

            alert.showAndWait();
            return;
        }

        str = new StringBuffer(editBlueEffect.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните поле \"Вероятность попадания\"");

            alert.showAndWait();
            return;
        }
        double blueEffect;
        try {
            blueEffect = Double.valueOf(str.toString());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Вероятность попадания должна числом быть в [0..1]");

            alert.showAndWait();
            return;
        }

        if ((blueEffect < 0) || (blueEffect > 1)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Вероятность попадания должна числом быть в [0..1]");

            alert.showAndWait();
            return;
        }

        str = new StringBuffer(editBlueStock.getCharacters());
        if (str.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Заполните поле \"Запасы боеприпасов\"");

            alert.showAndWait();
            return;
        }
        int blueStock;
        try {
            blueStock = Integer.valueOf(str.toString());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Запасы боеприпасов должны быть целым числом");

            alert.showAndWait();
            return;
        }


        // настройка координат для графика
        NumberAxis xAxis = (NumberAxis) chart.getXAxis();
        xAxis.setAutoRanging(false);
        xAxis.setLowerBound(0);

        NumberAxis yAxis = (NumberAxis) chart.getYAxis();
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(1);
        yAxis.setTickUnit(0.1);

        // время изменяется от 0 до 1
        double t=0;
        double step = 0.05;

        chart.getData().clear();
        //chart.getStylesheets().add("chat-series-line.css");

        XYChart.Series redSeries = new XYChart.Series();
        redSeries.setName("Красные");

        XYChart.Series blueSeries = new XYChart.Series();
        blueSeries.setName("Синие");

        double redMyu, blueMyu;

        //сам просчет графиков
        double redTempStock = redStock;
        double blueTempStock = blueStock;

        double redTempEffect = redEffect;
        double blueTempEffect = blueEffect;

        double redM = redCount;
        double blueM = blueCount;
        do {

            if (redTempStock <= 0) {
                redTempEffect = 0;
                redTempStock = 0;
            }

            if ((redTempStock != 0) && ((redTempStock / redSpeed) < 1))
                redTempEffect *= (redTempStock / redSpeed);

            // вот само уравнение для подсчета численности войск в данный момент времени

            //если у синих закончились боеприпасы, то численность красных не меняется
            if (blueTempStock != 0) {
                if (redTempStock != 0)
                    redM = redCount * cosh(sqrt(redSpeed * redTempEffect * blueSpeed * blueTempEffect) * t)
                            - blueCount * sqrt(blueSpeed * blueTempEffect / (redSpeed * redTempEffect))
                            * sinh(sqrt(redSpeed * redTempEffect * blueSpeed * blueTempEffect) * t);
                else
                    redM -= blueM * blueTempEffect * blueSpeed; //эта ветка выполняется когда у красных закончились боеприпасы
            }
            if (redM < 0)
                redM = 0;

            //считаю долю оставшихся войск
            redMyu = redM / redCount;
            redSeries.getData().add(new XYChart.Data(t, redMyu));

            // те же расчеты только для другого войска
            if (blueTempStock <= 0) {
                blueTempEffect = 0;
                blueTempStock = 0;
            }

            if ((blueTempStock != 0) && ((blueTempStock / blueSpeed) < 1))
                blueTempEffect *= (blueTempStock / blueSpeed);

            if (redTempStock != 0) {
                if (blueTempStock != 0)
                    blueM = blueCount * cosh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * t)
                            - redCount * sqrt (redSpeed*redTempEffect / (blueSpeed*blueTempEffect))
                            * sinh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * t);
                else
                    blueM -= redM*redTempEffect*redTempStock;
            }
            if (blueM < 0)
                blueM = 0;

            blueMyu = blueM / blueCount;
            blueSeries.getData().add(new XYChart.Data(t, blueMyu));

            // уменьшаю количество оставшихся боеприпасов
            redTempStock -= (redM*redSpeed);
            blueTempStock -= (blueM*redSpeed);
            t+=step;

            //условия для окончания войны
            // доля войск одной из сторон меньше 0.1 (это обусловлено используемым уравнением)
            // или закончились боеприпасы у обеих сторон

            // уравнение вычисления численности показывает мат. ожидание численности
            // и при долях войск близких к 0 дает неверные результаты
            // это указано было в той теории, что ты мне скидывала

        } while ((redMyu > 0.1) && (blueMyu > 0.1) && ((blueTempStock != 0) || (redTempStock != 0)));

        xAxis.setUpperBound(t);
        xAxis.setTickUnit(t/10);

        // установить посчитанные точки в отображение графика
        chart.getData().addAll(redSeries, blueSeries);

        ObservableList<XYChart.Data> redDatalist = ((XYChart.Series) chart.getData().get(0)).getData();
        ObservableList<XYChart.Data> blueDatalist = ((XYChart.Series) chart.getData().get(1)).getData();

        redTempStock = redStock;
        blueTempStock = blueStock;

        redTempEffect = redEffect;
        blueTempEffect = blueEffect;

        redM = redCount;
        blueM = blueCount;

        //точки графика еще раз считаются заново для того, чтобы в узлах графика выводились сообщения
        for (int i=0; i< redDatalist.size(); i++) {
            XYChart.Data redData = redDatalist.get(i);
            Node redNode = redData.getNode();

            XYChart.Data blueData = blueDatalist.get(i);
            Node blueNode = blueData.getNode();

            if (redTempStock <= 0) {
                redTempEffect = 0;
                redTempStock = 0;
            }

            if ((redTempStock != 0) && ((redTempStock / redSpeed) < 1))
                redTempEffect *= (redTempStock / redSpeed);

            if (blueTempStock != 0) {
                if (redTempStock != 0)
                    redM = redCount * cosh(sqrt(redSpeed * redTempEffect * blueSpeed * blueTempEffect) * i*step)
                            - blueCount * sqrt(blueSpeed * blueTempEffect / (redSpeed * redTempEffect))
                            * sinh(sqrt(redSpeed * redTempEffect * blueSpeed * blueTempEffect) * i*step);
                else
                    redM -= blueM * blueTempEffect * blueSpeed;
            }
            if (redM < 0)
                redM = 0;

            if (blueTempStock <= 0) {
                blueTempEffect = 0;
                blueTempStock = 0;
            }

            if ((blueTempStock != 0) && ((blueTempStock / blueSpeed) < 1))
                blueTempEffect *= (blueTempStock / blueSpeed);

            if (redTempStock != 0) {
                if (blueTempStock != 0)
                    blueM = blueCount * cosh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * i*step)
                            - redCount * sqrt (redSpeed*redTempEffect / (blueSpeed*blueTempEffect))
                            * sinh (sqrt (redSpeed*redTempEffect*blueSpeed*blueTempEffect) * i*step);
                else
                    blueM -= redM*redTempEffect*redTempStock;
            }
            if (blueM < 0)
                blueM = 0;

            Tooltip redTooltip = new Tooltip("Красные:"+'\n'
                    +"Время: "+ rint(((double) redData.getXValue()) * 100) / 100+'\n'
                    +"Доля: "+ rint (((double) redData.getYValue()) * 100) / 100+'\n'
                    +"Боеприпасы: "+floor(redTempStock)+'\n'
                    +"Численность: "+floor(redM));
            Tooltip.install(redNode, redTooltip);

            Tooltip blueTooltip = new Tooltip("Синие:"+'\n'
                    +"Время: "+ rint(((double) blueData.getXValue()) * 100) / 100+'\n'
                    +"Доля: "+ rint (((double) blueData.getYValue()) * 100) / 100+'\n'
                    +"Боеприпасы: "+floor(blueTempStock)+'\n'
                    +"Численность: "+floor(blueM));
            Tooltip.install(blueNode, blueTooltip);

            redTempStock -= (redM*redSpeed);
            blueTempStock -= (blueM*redSpeed);
        }

    }
}