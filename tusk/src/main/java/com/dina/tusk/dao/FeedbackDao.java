package com.dina.tusk.dao;

import com.dina.tusk.entity.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
}
