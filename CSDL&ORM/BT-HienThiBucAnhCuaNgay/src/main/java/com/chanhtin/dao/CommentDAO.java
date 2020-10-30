package com.chanhtin.dao;

import com.chanhtin.model.Comment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;


public class CommentDAO implements ICommentDao {
    private static SessionFactory sessionFactory;
    private static EntityManager em;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            em = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> findAll() {
        try {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = formatter.format(date);
            System.out.println(strDate);

            TypedQuery<Comment> query = em.createQuery("select c from Comment AS c where DATE_FORMAT(c.time_post,'%Y-%M-%d')= DATE_FORMAT(:date,'%Y-%M-%d') ", Comment.class);
            query.setParameter("date", date);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Comment findByID(Long id) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where  c.id=:id", Comment.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Comment save(Comment object) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Comment origin = findByID(object.getId());
            origin.setAuthor(object.getAuthor());
            origin.setFeedback(object.getFeedback());
            origin.setLikes(object.getLikes());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Comment add(Comment object) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void remote(Long id) {
        Comment object = findByID(id);
        if(object != null){
            em.remove(object);
        }
    }
}
