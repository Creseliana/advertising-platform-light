package com.creseliana.advertising.model.domain;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Valeria Sterzhanova
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "currencies")
public class Currency extends AbstractEntity {

    private static final long serialVersionUID = 1116402684019267446L;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "quantum", nullable = false)
    private BigDecimal quantum;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Currency currency = (Currency) o;
        return code.equals(currency.code) && quantum.equals(currency.quantum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, quantum);
    }
}
