package com.creseliana.advertising.facade.impl;

import com.creseliana.advertising.facade.CommentFacade;
import com.creseliana.advertising.model.domain.Comment;
import com.creseliana.advertising.model.dto.comment.CommentRequest;
import com.creseliana.advertising.model.dto.comment.CommentResponse;
import com.creseliana.advertising.service.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author Valeria Sterzhanova
 */
@Component
@RequiredArgsConstructor
public class CommentFacadeImpl extends AbstractFacade implements CommentFacade {

    private final CommentService commentService;
    private final ModelMapper modelMapper;

    @Override
    public CommentResponse create(Long adId, CommentRequest commentRequest) {
        Comment comment = modelMapper.map(commentRequest, Comment.class);
        return modelMapper.map(commentService.save(adId, comment), CommentResponse.class);
    }

    @Override
    public void deleteById(Long id) {
        commentService.deleteById(id);
    }

    @Override
    public List<CommentResponse> getAll(Long adId) {
        return mapEntityList(modelMapper, commentService.findAllByAdvertisementId(adId),
            CommentResponse.class);
    }
}
