package com.creseliana.advertising.model.domain;

import java.math.BigDecimal;
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
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "advertisements")
public class Advertisement extends AbstractEntity {

    private static final long serialVersionUID = -8392222812527472514L;

    @CreatedBy
    @Column(name = "created_by", nullable = false)
    private String author;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @CreatedDate
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "closed", nullable = false)
    private Boolean closed;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Advertisement that = (Advertisement) o;
        return author.equals(that.author)
            && category.equals(that.category)
            && title.equals(that.title)
            && creationDate.equals(that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, category, title, creationDate);
    }
}
