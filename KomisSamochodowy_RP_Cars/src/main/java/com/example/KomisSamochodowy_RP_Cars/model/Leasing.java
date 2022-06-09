package com.example.KomisSamochodowy_RP_Cars.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Leasing_Tabelka")
@Table(name="LEASING_TABELKA")
public class Leasing implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "egzemplarz_id")
    private Egzemplarz egzemplarz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klient_id")
    private Klient klient;

    @Column(name="data_początek")
    private LocalDate data_początek;

    @Column(name="data_koniec")
    private LocalDate data_koniec;

    @Column(name="oplata_miesieczna")
    private double oplata_miesieczna;

    public Leasing(Egzemplarz egzemplarz, Klient klient,
                   LocalDate data_początek, LocalDate data_koniec,
                   double oplata_miesieczna) {
        this.egzemplarz = egzemplarz;
        this.klient = klient;
        this.data_początek = data_początek;
        this.data_koniec = data_koniec;
        this.oplata_miesieczna = oplata_miesieczna;
    }
}