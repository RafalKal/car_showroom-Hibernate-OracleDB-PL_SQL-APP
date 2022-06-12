package com.example.KomisSamochodowy_RP_Cars.service;

import com.example.KomisSamochodowy_RP_Cars.HibernateUtil.SingletonConnection;
import com.example.KomisSamochodowy_RP_Cars.model.Leasing;
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
//        Query query = session.createSQLQuery("CALL TRANSAKCJA_KUPNA_UPD(:ID\n" +
//                                ",KLIENT_ID\n" +
//                                ",EGZEMPLARZ_ID\n" +
//                                ",DATA_ZAKUPU\n" +
//                                ",DLUGOSC_GWARANCJI\n")
//                .addEntity(Transakcja_kupna.class)
//                .setParameter("ID", transakcja_kupna.getId())
//                .setParameter("DATA_ZAKUPU", transakcja_kupna.getData_zakupu())
//                .setParameter("DLUGOSC_GWARANCJI", transakcja_kupna.getDlugosc_gwarancji())
//                .setParameter("EGZEMPLARZ_ID", transakcja_kupna.getEgzemplarz().getId())
//                .setParameter("KLIENT_ID", transakcja_kupna.getKlient().getId());
//        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void removeTransakcja_kupna(Transakcja_kupna transakcja_kupna){
        session.beginTransaction();
        Query query = session.createSQLQuery("CALL TRANSAKCJA_KUPNA_DEL(:id)")
                .addEntity(Transakcja_kupna.class)
                .setParameter("id", transakcja_kupna.getId());
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void updateTransakcja_kupna(Transakcja_kupna transakcja_kupna) {
        session.beginTransaction();
        Query query = session.createSQLQuery("CALL TRANSAKCJA_KUPNA_UPD(:ID" +
                        ",:KLIENT_ID" +
                        ",:EGZEMPLARZ_ID" +
                        ",:DATA_ZAKUPU" +
                        ",:DLUGOSC_GWARANCJI)")
                .addEntity(Transakcja_kupna.class)
                .setParameter("ID", transakcja_kupna.getId())
                .setParameter("KLIENT_ID", transakcja_kupna.getKlient().getId())
                .setParameter("EGZEMPLARZ_ID", transakcja_kupna.getEgzemplarz().getId())
                .setParameter("DATA_ZAKUPU", transakcja_kupna.getData_zakupu())
                .setParameter("DLUGOSC_GWARANCJI", transakcja_kupna.getDlugosc_gwarancji());
                query.executeUpdate();
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