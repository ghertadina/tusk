package com.dina.tusk.dao;

import com.dina.tusk.entity.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class FeedbackDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addFeedback(Feedback fb){
        System.out.println("in addFeedback" + fb);

        Session session = sessionFactory.getCurrentSession();
        session.save(fb);
    }

    @Transactional
    public List<Feedback> getFeedbacks(){
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from Feedback");
        List<Feedback> l = (List<Feedback>)q.list();
       return l;
    }
}
