package com.example.KomisSamochodowy_RP_Cars.controller;

import com.example.KomisSamochodowy_RP_Cars.model.Egzemplarz;
import com.example.KomisSamochodowy_RP_Cars.service.EgzemplarzService;
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

import java.time.format.DateTimeParseException;

public class UpdateEgzemplarzForm {
    public static void displayUpdateEgzemplarzForm(Egzemplarz egzemplarz){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Wypelnij dane w celu dokonania zmian w modelu: ");
        window.setMinWidth(500);

        Label label1 = new Label("Marka, np.: \"Nissan\"");
        RestrictiveTextField textField1 = new RestrictiveTextField("size15");
        textField1.setMaxLength(15);
        Label label2 = new Label("Model, np.: \"Micra\"");
        RestrictiveTextField textField2 = new RestrictiveTextField("size15");
        textField2.setMaxLength(15);
        Label label3 = new Label("Rok produkcji, np.: \"2000\"");
        RestrictiveTextField textField3 = new RestrictiveTextField("size4");
        textField3.setMaxLength(4);
        Label label4 = new Label("Pojemność silnika, np.: \"1400\"");
        RestrictiveTextField textField4 = new RestrictiveTextField("size5");
        textField4.setMaxLength(5);
        Label label5 = new Label("Typ nadwozia, np.: \"Hatchback\"");
        RestrictiveTextField textField5 = new RestrictiveTextField("size15");
        textField5.setMaxLength(15);
        Label label6 = new Label("Rodzaj paliwa, np.: \"Benzyna\"");
        RestrictiveTextField textField6 = new RestrictiveTextField("size15");
        textField6.setMaxLength(15);
        Label label7 = new Label("Kolor, np.: \"Niebieski\"");
        RestrictiveTextField textField7 = new RestrictiveTextField("size15");
        textField7.setMaxLength(15);
        Label label8 = new Label("VIN, np.: \"1A2S3D4F5G6H7J8K9\"");
        RestrictiveTextField textField8 = new RestrictiveTextField("size17");
        textField8.setMaxLength(17);
        Label label9 = new Label("Dostępność, np.: \"true\"");
        RestrictiveTextField textField9 = new RestrictiveTextField("size5");
        textField9.setMaxLength(5);
        Label label10 = new Label("Cena, np.: \"6000\"");
        RestrictiveTextField textField10 = new RestrictiveTextField("size6");
        textField10.setMaxLength(6);
        Label label11 = new Label("Cena za miesiąc, np.: \"500\"");
        RestrictiveTextField textField11 = new RestrictiveTextField("size5");
        textField11.setMaxLength(4);

        Button submitButton = new Button("Zmień");

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                String marka = null;
                String model = null;
                int rok_produkcji = 0;
                int pojemnosc = 0;
                String typ_nadwozia = null;
                String rodzaj_paliwa = null;
                String kolor = null;
                String vin = null;
                boolean dostepnosc;
                int cena = 0;
                int cena_miesiac = 0;

                EgzemplarzService egzemplarzService = new EgzemplarzService();

                try {
                    marka = textField1.getText();
                    model = textField2.getText();
                    rok_produkcji = Integer.parseInt(textField3.getText());
                    pojemnosc = Integer.parseInt(textField4.getText());
                    typ_nadwozia = textField5.getText();
                    rodzaj_paliwa = textField6.getText();
                    kolor = textField7.getText();
                    vin = textField8.getText();
                    dostepnosc = Boolean.parseBoolean(textField9.getText());
                    cena = Integer.parseInt(textField10.getText());
                    cena_miesiac = Integer.parseInt(textField11.getText());

                    //egzemplarz.setModel(model);
                    //egzemplarz.setMarka(marka);
                    //egzemplarz.setCena_miesiac(cena_miesiac);
                    egzemplarz.setKolor(kolor);
                    egzemplarz.setVin(vin);
                    egzemplarz.setDostepnosc(dostepnosc);
                    egzemplarz.setCena(cena);
                    egzemplarz.setRok_produkcji(rok_produkcji);
                    egzemplarz.setRodzaj_paliwa(rodzaj_paliwa);
                    //egzemplarz.setTyp_nadwozia(typ_nadwozia);
                    egzemplarz.setPojemnosc_silnika(pojemnosc);

                    if(     Validator.validateRokProdukcji(textField3.getText())
                            & Validator.validateVIN(textField8.getText())
                            & Validator.validateDostepnosc(textField9.getText()))
                    {
                        egzemplarzService.updateEgzemplarz(egzemplarz);
                        window.close();
                    }
                    else BadInput.wyswietl("Błąd danych wejściowych (RegEx)", "Zmień dane na wzór podanych...");

                }catch (DataException | DateTimeParseException | NumberFormatException exception){
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