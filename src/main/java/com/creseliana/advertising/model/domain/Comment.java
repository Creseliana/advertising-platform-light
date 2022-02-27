package com.creseliana.advertising.model.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author Valeria Sterzhanova
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "comments")
public class Comment extends AbstractEntity {

    private static final long serialVersionUID = 3827620970223854141L;

    @ManyToOne
    @JoinColumn(name = "ad_id", nullable = false)
    private Advertisement ad;

    @CreatedBy
    @Column(name = "created_by", nullable = false)
    private String author;

    @CreatedDate
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comment comment = (Comment) o;
        return ad.equals(comment.ad)
            && author.equals(comment.author)
            && creationDate.equals(comment.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ad, author, creationDate);
    }
}
