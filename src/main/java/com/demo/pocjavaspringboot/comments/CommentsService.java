package com.demo.pocjavaspringboot.comments;

import org.springframework.stereotype.Service;

@Service
public class CommentsService {
    private final CommentsRepository commentsRepository;
    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }
}
