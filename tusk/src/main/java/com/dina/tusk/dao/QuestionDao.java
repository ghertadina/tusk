package com.dina.tusk.dao;

import com.dina.tusk.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class QuestionDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void saveQuestion(Question q){
        Session session = sessionFactory.getCurrentSession();
        session.save(q);
    }

    @Transactional
    public List<Question> getQuestions(){
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createQuery("from Question");
        List<Question> l = (List<Question>)q.list();
        return l;
    }
}
