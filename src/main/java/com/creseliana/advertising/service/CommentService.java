package com.creseliana.advertising.service;

import com.creseliana.advertising.model.domain.Comment;
import java.util.List;

/**
 * @author Valeria Sterzhanova
 */
public interface CommentService extends EntityService<Comment> {

    Comment save(Long adId, Comment comment);

    void deleteById(Long id);

    List<Comment> findAllByAdvertisementId(Long adId);
}
