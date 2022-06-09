package com.example.KomisSamochodowy_RP_Cars.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Model_Tabelka")
@Table(name="MODEL_TABELKA")
public class Model implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "marka")
    private String marka;

    @Column(name = "nazwa_modelu")
    private String nazwa_modelu;

    @Column(name = "typ_nadwozia")
    private String typ_nadwozia;

    public Model(String name, String nazwa_modelu,
                 String typ_nadwozia) {
        this.marka = name;
        this.nazwa_modelu = nazwa_modelu;
        this.typ_nadwozia = typ_nadwozia;
    }
}