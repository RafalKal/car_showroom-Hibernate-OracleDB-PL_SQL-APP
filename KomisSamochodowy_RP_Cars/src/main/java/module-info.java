module com.example.KomisSamochodowy_RP_Cars {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires static lombok;
    requires java.naming;
    requires java.sql;
    requires javax.persistence;

    opens com.example.KomisSamochodowy_RP_Cars to javafx.fxml, org.hibernate.orm.core;
    opens com.example.KomisSamochodowy_RP_Cars.model to javafx.fxml, org.hibernate.orm.core;
    opens com.example.KomisSamochodowy_RP_Cars.controller to javafx.fxml, org.hibernate.orm.core;

    exports com.example.KomisSamochodowy_RP_Cars;
    exports com.example.KomisSamochodowy_RP_Cars.model;
    exports com.example.KomisSamochodowy_RP_Cars.controller;
    exports com.example.KomisSamochodowy_RP_Cars.HibernateUtil;
    opens com.example.KomisSamochodowy_RP_Cars.HibernateUtil to javafx.fxml, org.hibernate.orm.core;


}