package com.geekbrains.hibernate.crud;

import com.geekbrains.hibernate.PrepareDataApp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDao {
    private static SessionFactory factory;

    public static void main(String[] args) {

    }

    public void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("crud/hibernate.cfg.xml")
                .buildSessionFactory();

    }

    public Product findById(Long id) {
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("There is no product with this ID!!!");
    }

    private void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    private Product saveOrUpdate(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            session.saveOrUpdate(product);

            session.getTransaction().commit();

            return product;
        }
    }

    private List<Product> findAll() {
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery("FROM Product").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    private static void shutdown() {
        factory.close();
    }

}
