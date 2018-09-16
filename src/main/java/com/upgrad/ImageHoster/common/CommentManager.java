package com.upgrad.ImageHoster.common;

import com.upgrad.ImageHoster.model.Comment;
import org.hibernate.Session;

@SuppressWarnings("unchecked")
public class CommentManager extends SessionManager {

    // Method to save a comment to the DB
    public void saveCommentToDB(final Comment comment) {

        Session session = openSession();
        session.save(comment);
        commitSession(session);
    }
}
