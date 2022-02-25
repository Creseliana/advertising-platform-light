package com.creseliana.advertising.facade;

import com.creseliana.advertising.model.dto.comment.CommentRequest;
import com.creseliana.advertising.model.dto.comment.CommentResponse;
import java.util.List;

/**
 * @author Valeria Sterzhanova
 */
public interface CommentFacade {

    CommentResponse create(Long adId, CommentRequest commentRequest);

    void deleteById(Long id);

    List<CommentResponse> getAll(Long adId);
}
