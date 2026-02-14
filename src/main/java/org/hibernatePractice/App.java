package org.hibernatePractice;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernatePractice.entity.Product;

import java.util.List;


public class App {

    private static SessionFactory sessionFactory;


    public static void main(String[] args) throws Exception {

        // Create SessionFactory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        sessionFactory = cfg.buildSessionFactory();

        Product prod = new Product();
        prod.setName("Zerobonics Speaker");
        prod.setCategory("Electronics");
        prod.setDesc("Upto 8 hours playback");
        prod.setPrice(788.00);
        prod.setQuantity(5);
        prod.setSku("Spk90-" + System.currentTimeMillis());
        prod.setActive(true);
        createProduct(prod);
        System.out.println(readProduct(prod.getId()));
        updateProduct(prod.getId(), 899.00);
        deleteProduct(prod.getId());
        sessionFactory.close();

    }
    public static void createProduct(Product p){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        System.out.println("Product created");
        session.close();
    }
    public static Product readProduct(long id){
        Session session = sessionFactory.openSession();
        Product p = (Product) session.find(Product.class,id);
        session.close();
        return  p;
    }
    public static void updateProduct(long id,double newPrice){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Product p = session.find(Product.class,id);
        if(p==null) {
            System.out.println("Product with id " + id + " does not exist");
            tx.rollback();
            session.close();
            return;
        }
        p.setPrice(newPrice);
        tx.commit();
        session.close();
        System.out.println("Price Updated Successfully");
    }
    public  static  void deleteProduct(long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Product p = (Product) session.find(Product.class, id);
        if (p != null) {
            session.remove(p);
            tx.commit();
        } else {
            tx.rollback();
        }
        session.close();
    }

}

