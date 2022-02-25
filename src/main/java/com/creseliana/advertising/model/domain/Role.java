package com.creseliana.advertising.model.domain;

import com.creseliana.advertising.model.domain.type.RoleType;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Valeria Sterzhanova
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends AbstractEntity implements GrantedAuthority {

    private static final long serialVersionUID = -1242588863645448774L;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, unique = true)
    private RoleType type;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return type == role.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String getAuthority() {
        return this.type.toString();
    }
}
