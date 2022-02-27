package com.creseliana.advertising.service.impl;

import com.creseliana.advertising.model.domain.Comment;
import com.creseliana.advertising.repository.AdvertisementRepository;
import com.creseliana.advertising.repository.CommentRepository;
import com.creseliana.advertising.service.CommentService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Valeria Sterzhanova
 */
@Service
@Transactional
public class CommentServiceImpl extends
    AbstractService<Comment, CommentRepository> implements CommentService {

    private final AdvertisementRepository advertisementRepository;

    public CommentServiceImpl(CommentRepository repository,
        AdvertisementRepository advertisementRepository) {
        super(repository);
        this.advertisementRepository = advertisementRepository;
    }

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }

    @Override
    public Comment save(Long adId, Comment comment) {
        comment.setAd(advertisementRepository.getById(adId));
        return repository.save(comment);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Comment> findAllByAdvertisementId(Long adId) {
        return repository.findAllByAdId(adId);
    }
}
