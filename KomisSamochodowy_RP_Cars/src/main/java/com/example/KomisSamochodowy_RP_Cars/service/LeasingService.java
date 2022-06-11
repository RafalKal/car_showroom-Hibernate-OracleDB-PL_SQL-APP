package com.example.KomisSamochodowy_RP_Cars.service;

import com.example.KomisSamochodowy_RP_Cars.HibernateUtil.SingletonConnection;
import com.example.KomisSamochodowy_RP_Cars.model.Leasing;
import javafx.collections.FXCollections;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class LeasingService {
    public static final SessionFactory sessionFactory = SingletonConnection.getSessionFactory();
    public static final Session session = sessionFactory.openSession();

    public void saveLeasing(Leasing leasing){
//        session.beginTransaction();
//        session.save(leasing);
//        session.getTransaction().commit();

        session.beginTransaction();
        Query query = session.createSQLQuery("CALL LEASING_DEL(:id)")
                .addEntity(Leasing.class)
                .setParameter("id", leasing.getId());
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void removeLeasing(Leasing leasing){
        session.beginTransaction();
        Query query = session.createSQLQuery("CALL LEASING_DEL(:id)")
                .addEntity(Leasing.class)
                .setParameter("id", leasing.getId());
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void updateLeasing(Leasing leasing) {
        session.beginTransaction();
        session.update(leasing);
        session.getTransaction().commit();
    }

    public List<Leasing> getLeasingTable(){
        session.beginTransaction();

        Query query = session.createQuery("from Leasing_Tabelka");

        session.getTransaction().commit();

        return query.list();
    }

    public Leasing getLeasingById(int id) {
        session.beginTransaction();
        Leasing leasing = (Leasing) session.get(Leasing.class, id);
        session.getTransaction().commit();
        return leasing;
    }
}