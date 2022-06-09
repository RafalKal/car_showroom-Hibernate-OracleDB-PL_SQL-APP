package com.example.KomisSamochodowy_RP_Cars.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Transakcja_kupna_Tabelka")
@Table(name="TRANSAKCJA_KUPNA_TABELKA")
public class Transakcja_kupna implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klient_id")
    private Klient klient;

    @ManyToOne
    @JoinColumn(name = "egzemplarz_id")
    private Egzemplarz egzemplarz;

    @Column(name="data_zakupu")
    private LocalDate data_zakupu;

    @Column(name="dlugosc_gwarancji")
    private int dlugosc_gwarancji;

    public Transakcja_kupna(Klient klient,
                            Egzemplarz egzemplarz,
                            LocalDate data_zakupu,
                            int dlugosc_gwarancji) {
        this.klient = klient;
        this.egzemplarz = egzemplarz;
        this.data_zakupu = data_zakupu;
        this.dlugosc_gwarancji = dlugosc_gwarancji;
    }
}