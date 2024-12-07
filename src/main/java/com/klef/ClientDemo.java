package com.klef;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
      
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Insert Records
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

     
            Car car = new Car();
            car.setName("Tesla Model S");
            car.setType("Electric");
            car.setMaxSpeed(250);
            car.setColor("Red");
            car.setNumberOfDoors(4);
            session.persist(car);

            transaction.commit();
            System.out.println("Records inserted successfully!");
        }

        sessionFactory.close();
    }
}
