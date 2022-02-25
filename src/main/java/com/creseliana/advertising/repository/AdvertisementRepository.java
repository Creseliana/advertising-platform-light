package com.creseliana.advertising.repository;

import com.creseliana.advertising.model.domain.Advertisement;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author Valeria Sterzhanova
 */
@Repository
public interface AdvertisementRepository extends EntityRepository<Advertisement> {

    List<Advertisement> findAllByClosedIsFalseAndDeletedIsFalse();

    List<Advertisement> findAllByClosedIsFalseAndDeletedIsFalseAndCategoryName(String name);

    List<Advertisement> findAllByAuthorAndClosedAndDeletedIsFalse(String username, boolean closed);
}
