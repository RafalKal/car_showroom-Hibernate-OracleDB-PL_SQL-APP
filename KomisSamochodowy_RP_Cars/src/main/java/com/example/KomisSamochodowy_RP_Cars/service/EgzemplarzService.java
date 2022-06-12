package com.example.KomisSamochodowy_RP_Cars.service;

import com.example.KomisSamochodowy_RP_Cars.HibernateUtil.SingletonConnection;
import com.example.KomisSamochodowy_RP_Cars.model.Egzemplarz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class EgzemplarzService {

    public static final SessionFactory sessionFactory = SingletonConnection.getSessionFactory();
    public static final Session session = sessionFactory.openSession();

    public void saveEgzemplarz(Egzemplarz egzemplarz){
        session.beginTransaction();
        session.save(egzemplarz);
        session.getTransaction().commit();
    }

    public void removeEgzemplarz(Egzemplarz egzemplarz){
        session.beginTransaction();
        Query query = session.createSQLQuery("CALL EGZEMPLARZ_DEL(:id)")
                .addEntity(Egzemplarz.class)
                .setParameter("id", egzemplarz.getId());
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void updateEgzemplarz(Egzemplarz egzemplarz)
    {
        session.beginTransaction();
        session.update(egzemplarz);
        session.getTransaction().commit();
    }

    public List<Egzemplarz> getEgzemplarzTable(){

        session.beginTransaction();

        Query query = session.createQuery("from Egzemplarz_Tabelka");

        session.getTransaction().commit();

        return query.list();
    }

    public Egzemplarz getEgzemplarzById(int id) {
        session.beginTransaction();
        Egzemplarz egzemplarz = (Egzemplarz) session.get(Egzemplarz.class, id);

        session.getTransaction().commit();

        return egzemplarz;
    }
}