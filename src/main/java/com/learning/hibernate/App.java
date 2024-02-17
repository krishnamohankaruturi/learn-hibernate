package com.learning.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Song.class);

        //Create Session factory
        SessionFactory sessionFactory = config.buildSessionFactory();

        // intilisize the session obj
        Session session= sessionFactory.openSession();
        Song song = new Song();
        song.setId(1);
        song.setSongName("Memories");
        song.setArtist("i dont know");
        session.beginTransaction();
        session.save(song);
        session.getTransaction().commit();
        System.out.println("Song saved");
        session.close();
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        session.save(new Song(2,"backwards","impala"));


    }

}
