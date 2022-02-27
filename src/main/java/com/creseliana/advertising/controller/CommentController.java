package com.creseliana.advertising.controller;

import com.creseliana.advertising.facade.CommentFacade;
import com.creseliana.advertising.model.dto.comment.CommentRequest;
import com.creseliana.advertising.model.dto.comment.CommentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Valeria Sterzhanova
 */
@RestController
@RequestMapping(path = "advertisements", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "comments", description = "Управление комментариями")
public class CommentController {

    private final CommentFacade commentFacade;

    @PostMapping("{id}/comments")
    @Operation(operationId = "create-comment", summary = "Создание комментария")
    public CommentResponse create(@PathVariable Long id,
        @Valid @RequestBody CommentRequest comment) {
        return commentFacade.create(id, comment);
    }

    @DeleteMapping("comments/{id}")
    @Operation(operationId = "delete-comment", summary = "Удаление комментария")
    public void delete(@PathVariable Long id) {
        commentFacade.deleteById(id);
    }

    @GetMapping("{id}/comments")
    @Operation(operationId = "get-all-comments-for-ad",
        summary = "Получение всх комментариев объявления")
    public List<CommentResponse> getAll(@PathVariable Long id) {
        return commentFacade.getAll(id);
    }
}
