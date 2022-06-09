package com.example.KomisSamochodowy_RP_Cars.service;

import com.example.KomisSamochodowy_RP_Cars.HibernateUtil.SingletonConnection;
import com.example.KomisSamochodowy_RP_Cars.model.Klient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class KlientService {
    public static final SessionFactory sessionFactory = SingletonConnection.getSessionFactory();
    public static final Session session = sessionFactory.openSession();

    public void saveKlient(Klient klient){
        session.beginTransaction();
        session.save(klient);
        session.getTransaction().commit();
    }

    public void removeKlient(Klient klient){
        session.beginTransaction();
        session.remove(klient);
        session.getTransaction().commit();
    }

    public void updateKlient(Klient klient)
    {
        session.beginTransaction();
        session.update(klient);
        session.getTransaction().commit();
    }

    public List<Klient> getKlientTable(){
        session.beginTransaction();

        Query query = session.createQuery("from Klient_Tabelka");

        session.getTransaction().commit();

        return query.list();
    }

    public Klient getKlientById(int id) {
        session.beginTransaction();
        Klient klient = (Klient) session.get(Klient.class, id);
        session.getTransaction().commit();
        return klient;
    }
}
