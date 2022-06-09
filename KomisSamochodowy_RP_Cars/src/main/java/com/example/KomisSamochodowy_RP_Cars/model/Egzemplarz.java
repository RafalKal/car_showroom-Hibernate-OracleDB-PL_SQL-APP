package com.example.KomisSamochodowy_RP_Cars.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Egzemplarz_Tabelka")
@Table(name="EGZEMPLARZ_TABELKA")
public class Egzemplarz implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(name="rok_produkcji")
    private int rok_produkcji;

    @Column(name="pojemnosc_silnika")
    private int pojemnosc_silnika;

    @Column(name="przebieg")
    private int przebieg;

    @Column(name="rodzaj_paliwa", length = 15)
    private String rodzaj_paliwa;

    @Column(name="kolor", length = 15)
    private String kolor;

    @Column(name="vin", length = 17)
    private String vin;

    @Column(name="dostepnosc")
    private boolean dostepnosc;

    @Column(name="cena")
    private int cena;

//    @OneToMany(mappedBy = "egzemplarz")
//    private List<Leasing> leasingi;
//
//    @OneToMany(mappedBy = "egzemplarz")
//    private List<Transakcja_kupna> transakcje_kupna;

    public Egzemplarz(Model model, int rok_produkcji,
                      int pojemnosc_silnika, int przebieg,
                      String rodzaj_paliwa, String kolor,
                      String vin, boolean dostepnosc, int cena) {
        this.model = model;
        this.rok_produkcji = rok_produkcji;
        this.pojemnosc_silnika = pojemnosc_silnika;
        this.przebieg = przebieg;
        this.rodzaj_paliwa = rodzaj_paliwa;
        this.kolor = kolor;
        this.vin = vin;
        this.dostepnosc = dostepnosc;
        this.cena = cena;
    }

    public Egzemplarz() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(int rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public int getPojemnosc_silnika() {
        return pojemnosc_silnika;
    }

    public void setPojemnosc_silnika(int pojemnosc_silnika) {
        this.pojemnosc_silnika = pojemnosc_silnika;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public String getRodzaj_paliwa() {
        return rodzaj_paliwa;
    }

    public void setRodzaj_paliwa(String rodzaj_paliwa) {
        this.rodzaj_paliwa = rodzaj_paliwa;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public boolean isDostepnosc() {
        return dostepnosc;
    }

    public void setDostepnosc(boolean dostepnosc) {
        this.dostepnosc = dostepnosc;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}