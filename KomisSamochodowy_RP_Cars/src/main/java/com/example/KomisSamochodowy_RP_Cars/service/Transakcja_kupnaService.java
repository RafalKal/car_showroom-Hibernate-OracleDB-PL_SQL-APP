package com.example.KomisSamochodowy_RP_Cars.service;

import com.example.KomisSamochodowy_RP_Cars.HibernateUtil.SingletonConnection;
import com.example.KomisSamochodowy_RP_Cars.model.Egzemplarz;
import com.example.KomisSamochodowy_RP_Cars.model.Klient;
import com.example.KomisSamochodowy_RP_Cars.model.Transakcja_kupna;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Transakcja_kupnaService {
    public static final SessionFactory sessionFactory = SingletonConnection.getSessionFactory();
    public static final Session session = sessionFactory.openSession();

    public void saveTransakcja_kupna(Transakcja_kupna transakcja_kupna){
        session.beginTransaction();
        session.save(transakcja_kupna);
        session.getTransaction().commit();
    }

    public void removeTransakcja_kupna(Transakcja_kupna transakcja_kupna){
        session.beginTransaction();
        session.remove(transakcja_kupna);
        session.getTransaction().commit();
    }

    public void updateTransakcja_kupna(Transakcja_kupna transakcja_kupna) {
        session.beginTransaction();
        session.update(transakcja_kupna);
        session.getTransaction().commit();
    }

    public List<Transakcja_kupna> getTransakcja_kupnaTable(){
        session.beginTransaction();

        Query query = session.createQuery("from Transakcja_kupna_Tabelka");

        session.getTransaction().commit();

        return query.list();
    }
    public Transakcja_kupna getTransakcja_kupnaById(int id) {
        session.beginTransaction();
        Transakcja_kupna transakcja_kupna = (Transakcja_kupna) session.get(Transakcja_kupna.class, id);
        session.getTransaction().commit();
        return transakcja_kupna;
    }
}