package com.example.KomisSamochodowy_RP_Cars.controller;

import com.example.KomisSamochodowy_RP_Cars.model.Klient;
import com.example.KomisSamochodowy_RP_Cars.service.KlientService;
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

public class UpdateKlientForm {
    public static void displayUpdateKlientForm(Klient klient){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Wypelnij dane w celu dokonania zmian w kliencie: ");
        window.setMinWidth(500);

        Label label1 = new Label("Imie: np.: \"Rafał\"");
        RestrictiveTextField textField1 = new RestrictiveTextField("size_15");
        textField1.setMaxLength(15);
        Label label2 = new Label("Nazwisko: np.: \"Kolasa\"");
        RestrictiveTextField textField2 = new RestrictiveTextField("size_20");
        textField2.setMaxLength(20);
        Label label3 = new Label("Data urodzenia: np.: \"2000-10-10\"");
        RestrictiveTextField textField3 = new RestrictiveTextField("[DATE]");
        Label label4 = new Label("PESEL: np.: \"00302307395\"");
        RestrictiveTextField textField4 = new RestrictiveTextField("size_11");
        textField4.setMaxLength(11);
        Label label5 = new Label("Numer dowodu: np.: \"CHF350\"");
        RestrictiveTextField textField5 = new RestrictiveTextField("size_6");
        textField5.setMaxLength(6);
        Label label6 = new Label("Kod pocztowy: np.: \"35-317\"");
        RestrictiveTextField textField6 = new RestrictiveTextField("size_6");
        textField6.setMaxLength(6);
        Label label7 = new Label("Miejscowosc: np.: \"Rzeszow\"");
        RestrictiveTextField textField7 = new RestrictiveTextField("size_25");
        textField7.setMaxLength(25);
        Label label8 = new Label("Ulica: np.: \"Krakowska\"");
        RestrictiveTextField textField8 = new RestrictiveTextField("size_25");
        textField8.setMaxLength(25);
        Label label9 = new Label("Numer domu: np.: \"15\"");
        RestrictiveTextField textField9 = new RestrictiveTextField("[NUMER DOMU]");
        Label label10 = new Label("Email: np.: \"sample_email@gmail.com\"");
        RestrictiveTextField textField10 = new RestrictiveTextField("size_25");
        textField10.setMaxLength(25);
        Label label11 = new Label("Telefon: np.: \"123123123\"");
        RestrictiveTextField textField11 = new RestrictiveTextField("size_9");
        textField11.setMaxLength(9);

        Button submitButton = new Button("Zmień");

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                KlientService klientService = new KlientService();
                String imie = null;
                String nazwisko = null;
                LocalDate data_urodzenia = null;
                String pesel = null;
                String numer_dowodu = null;
                String kod_pocztowy = null;
                String miejscowosc = null;
                String ulica = null;
                int numer_domu = 0;
                String email = null;
                String telefon = null;

                try {
                    imie = textField1.getText();
                    nazwisko = textField2.getText();
                    data_urodzenia = LocalDate.parse(textField3.getText());
                    pesel = textField4.getText();
                    numer_dowodu = textField5.getText();
                    kod_pocztowy = textField6.getText();
                    miejscowosc = textField7.getText();
                    ulica = textField8.getText();
                    numer_domu = Integer.parseInt(textField9.getText());
                    email = textField10.getText();
                    telefon = textField11.getText();

                    klient.setImie(imie);
                    klient.setNazwisko(nazwisko);
                    klient.setData_urodzenia(data_urodzenia);
                    klient. setPesel(pesel);
                    klient.setTelefon(telefon);
                    klient.setEmail(email);
                    klient.setNumer_domu(numer_domu);
                    klient.setUlica(ulica);
                    klient.setMiejscowosc(miejscowosc);
                    klient.setKod_pocztowy(kod_pocztowy);
                    klient.setNumer_dowodu(numer_dowodu);

                    if(     Validator.validateDate(textField3.getText())
                            & Validator.validateFirstName(textField1.getText())
                            & Validator.validateLastName(textField2.getText())
                            & Validator.validatePesel(textField4.getText())
                            & Validator.validateEmail(textField10.getText())
                            & Validator.validateNumerTelefonu(textField11.getText()))
                    {
                        klientService.updateKlient(klient);
                        window.close();
                    }
                    else BadInput.wyswietl("Błąd danych wejściowych (RegEx", "Zmień dane na wzór podanych...");
                }catch (DataException | DateTimeParseException exception){
                    BadInput.wyswietl("Błąd danych wejściowych (Exception)", "Zmień dane na wzór podanych...");
                }
            }
        });

        Button buttonInAlert = new Button("Anuluj");
        buttonInAlert.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, textField1, label2, textField2, label3, textField3, label4, textField4, label5, textField5, label6, textField6, label7, textField7, label8, textField8, label9, textField9, label10, textField10, label11, textField11, submitButton, buttonInAlert);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
