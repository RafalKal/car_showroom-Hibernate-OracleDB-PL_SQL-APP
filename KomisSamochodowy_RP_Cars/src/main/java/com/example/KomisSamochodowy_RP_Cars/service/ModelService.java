package com.example.KomisSamochodowy_RP_Cars.service;

import com.example.KomisSamochodowy_RP_Cars.HibernateUtil.SingletonConnection;
import com.example.KomisSamochodowy_RP_Cars.model.Model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import javax.persistence.metamodel.EntityType;
import java.util.List;
import java.util.Set;

public class ModelService {

    public static final SessionFactory sessionFactory = SingletonConnection.getSessionFactory();
    public static final Session session = sessionFactory.openSession();

    public void saveModel(Model model) {
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
    }

    public void removeModel(Model model) {
        session.beginTransaction();
        session.remove(model);
        session.getTransaction().commit();
    }

    //    public void removeModelById(long id)
//    {
//        Session session;
//        Model model;
//
//        session = sessionFactory.getCurrentSession();
//        model = (Model)session.load(Model.class,id);
//        session.delete(model);
//
//        session.flush() ;
//    }

    public void updateModel(Model model) {
        session.beginTransaction();
        session.update(model);
        session.getTransaction().commit();
    }

    public List<Model> getModelTable() {
        session.beginTransaction();

        Query query = session.createQuery("from Model_Tabelka");

        session.getTransaction().commit();

        return query.list();
    }

    public Model getModelById(int id) {
        session.beginTransaction();
        Model model = (Model) session.get(Model.class, id);
        session.getTransaction().commit();
        return model;
    }
//    public void removeModelByPROCEDURE(Model model) {
//        session.beginTransaction();
//        session.remove(model);
//        session.getTransaction().commit();
//    }
}