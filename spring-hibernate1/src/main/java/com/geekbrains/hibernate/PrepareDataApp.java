package com.geekbrains.hibernate;


import com.geekbrains.hibernate.crud.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrepareDataApp {
    public static void main(String[] args) {
        forcePrepareData();
    }

    public static void forcePrepareData() {
        SessionFactory factory = new Configuration()
                .configure("crud/hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;

    }

}
