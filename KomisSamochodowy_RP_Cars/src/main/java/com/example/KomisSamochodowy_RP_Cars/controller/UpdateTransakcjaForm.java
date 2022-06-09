package com.example.KomisSamochodowy_RP_Cars.controller;

import com.example.KomisSamochodowy_RP_Cars.model.Transakcja_kupna;
import com.example.KomisSamochodowy_RP_Cars.service.Transakcja_kupnaService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.exception.DataException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class UpdateTransakcjaForm {
    public static void displayUpdateTransakcjaForm(Transakcja_kupna transakcja_kupna){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Wypelnij dane w celu dokonania zmian w transakcji: ");
        window.setMinWidth(500);

        Label label1 = new Label("ID Klienta, np.: \"5\"");
        RestrictiveTextField textField1 = new RestrictiveTextField("[id]");
        Label label2 = new Label("ID Egzemplarza, np.: \"5\"");
        RestrictiveTextField textField2 = new RestrictiveTextField("[id]");
        Label label3 = new Label("Data zakupu, np.: \"2000-10-10\"");
        RestrictiveTextField textField3 = new RestrictiveTextField("size10");
        textField3.setMaxLength(12);
        Label label4 = new Label("Długość gwarancji, np.: \"24\"");
        RestrictiveTextField textField4 = new RestrictiveTextField("size2");
        textField4.setMaxLength(2);
        Label label5 = new Label("Cena, np.: \"9000\"");
        RestrictiveTextField textField5 = new RestrictiveTextField("size5");
        textField5.setMaxLength(5);

        Button submitButton = new Button("Zmień");

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                Long id_klient = null;
                Long id_egzemplarz = null;
                LocalDate data_zakupu = null;
                int dlugosc_gwarancji = 0;
                int cena = 0;

                Transakcja_kupnaService transakcja_kupnaService = new Transakcja_kupnaService();

                try {
                    id_klient = Long.parseLong(textField1.getText());
                    id_egzemplarz = Long.parseLong(textField2.getText());
                    data_zakupu = LocalDate.parse(textField3.getText());
                    dlugosc_gwarancji = Integer.parseInt(textField4.getText());
                    cena = Integer.parseInt(textField5.getText());

                    //transakcja_kupna.setKlient_id(id_klient);
                    //transakcja_kupna.setEgzemplarz_id(id_egzemplarz);
                    transakcja_kupna.setData_zakupu(data_zakupu);
                    transakcja_kupna.setDlugosc_gwarancji(dlugosc_gwarancji);
                    //transakcja_kupna.setCena(cena);

                    transakcja_kupnaService.updateTransakcja_kupna(transakcja_kupna);

                    window.close();
                }catch (DataException | DateTimeParseException | NumberFormatException exception){
                    BadInput.wyswietl("Błąd danych wejściowych", "Zmień dane na wzór podanych...");
                }
            }
        });

        Button buttonInAlert = new Button("Anuluj");
        buttonInAlert.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, textField1,
                label2, textField2,
                label3, textField3,
                label4, textField4,
                label5, textField5,
                submitButton, buttonInAlert);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}