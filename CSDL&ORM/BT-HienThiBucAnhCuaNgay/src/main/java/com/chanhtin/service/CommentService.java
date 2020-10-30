package com.chanhtin.service;

import com.chanhtin.dao.ICommentDao;
import com.chanhtin.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentService implements BaseService<Comment> {

    @Autowired
    private ICommentDao commentDAO;

    @Override
    public List<Comment> findAll() {
        return commentDAO.findAll();
    }

    @Override
    public Comment findByID(Long id) {
        return commentDAO.findByID(id);
    }

    @Override
    public Comment add(Comment object) {
        return commentDAO.add(object);
    }

    @Override
    public Comment save(Comment object) {
        return commentDAO.save(object);
    }

    @Override
    public void remote(Long id) {
        commentDAO.remote(id);
    }
}
