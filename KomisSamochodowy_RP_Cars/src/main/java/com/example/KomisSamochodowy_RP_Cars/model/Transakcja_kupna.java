package com.example.KomisSamochodowy_RP_Cars.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity(name = "Transakcja_kupna_Tabelka")
@Table(name="TRANSAKCJA_KUPNA_TABELKA")
public class Transakcja_kupna implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "egzemplarz_id")
    private Egzemplarz egzemplarz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "klient_id")
    private Klient klient;

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

    public Transakcja_kupna() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Egzemplarz getEgzemplarz() {
        return egzemplarz;
    }

    public void setEgzemplarz(Egzemplarz egzemplarz) {
        this.egzemplarz = egzemplarz;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

    public LocalDate getData_zakupu() {
        return data_zakupu;
    }

    public void setData_zakupu(LocalDate data_zakupu) {
        this.data_zakupu = data_zakupu;
    }

    public int getDlugosc_gwarancji() {
        return dlugosc_gwarancji;
    }

    public void setDlugosc_gwarancji(int dlugosc_gwarancji) {
        this.dlugosc_gwarancji = dlugosc_gwarancji;
    }
}