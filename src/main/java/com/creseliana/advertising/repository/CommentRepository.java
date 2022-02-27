package com.creseliana.advertising.repository;

import com.creseliana.advertising.model.domain.Comment;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author Valeria Sterzhanova
 */
@Repository
public interface CommentRepository extends EntityRepository<Comment> {

    List<Comment> findAllByAdId(Long adId);
}
