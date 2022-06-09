package com.example.KomisSamochodowy_RP_Cars.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Klient_Tabelka")
@Table(name="KLIENT_TABELKA")
public class Klient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name="imie", length = 15)
    private String imie;

    @Column(name="nazwisko", length = 20)
    private String nazwisko;

    @Column(name="data_urodzenia")
    private LocalDate data_urodzenia;

    @Column(name="pesel", length = 11)
    private String pesel;

    @Column(name="numer_dowodu", length = 6)
    private String numer_dowodu;

    @Column(name="email")
    private String email;

    @Column(name="telefon", length = 9)
    private String telefon;

    @Column(name="miejscowosc", length = 25)
    private String miejscowosc;

    @Column(name="kod_pocztowy", length = 6)
    private String kod_pocztowy;

    @Column(name="ulica", length = 25)
    private String ulica;

    @Column(name="numer_domu")
    private int numer_domu;

    @Column(name="firma")
    private String firma;

    @Column(name="nip")
    private String nip;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Transakcja_kupna> transakcje_kupna;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Leasing> leasingi;

    public Klient(String imie, String nazwisko,
                  String pesel, String email,
                  String numer_dowodu, String telefon,
                  LocalDate data_urodzenia, String miejscowosc,
                  String kod_pocztowy, String ulica,
                  int numer_domu, String firma, String nip) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.email = email;
        this.numer_dowodu = numer_dowodu;
        this.telefon = telefon;
        this.data_urodzenia = data_urodzenia;
        this.miejscowosc = miejscowosc;
        this.kod_pocztowy = kod_pocztowy;
        this.ulica = ulica;
        this.numer_domu = numer_domu;
        this.firma = firma;
        this.nip = nip;
    }
}