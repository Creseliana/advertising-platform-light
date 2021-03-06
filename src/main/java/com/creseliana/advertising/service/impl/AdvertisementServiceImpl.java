package com.creseliana.advertising.service.impl;

import com.creseliana.advertising.exception.AccessDeniedException;
import com.creseliana.advertising.model.domain.Advertisement;
import com.creseliana.advertising.repository.AdvertisementRepository;
import com.creseliana.advertising.service.AdvertisementService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Valeria Sterzhanova
 */
@Service
@Transactional
public class AdvertisementServiceImpl extends
    AbstractService<Advertisement, AdvertisementRepository> implements AdvertisementService {

    private static final String MSG_ADVERTISEMENT_EDIT_FORBIDDEN =
        "Advertisement can be edited only by author";

    public AdvertisementServiceImpl(AdvertisementRepository repository) {
        super(repository);
    }

    @Override
    protected Class<Advertisement> getEntityClass() {
        return Advertisement.class;
    }

    @Override
    public Advertisement save(Advertisement entity) {
        entity.setDeleted(false);
        entity.setClosed(false);
        return this.findById(super.save(entity).getId());
    }

    @Override
    public Advertisement update(Advertisement ad, String username) {
        Advertisement editAd = this.findById(ad.getId());
        if (!editAd.getAuthor().equals(username)) {
            throw new AccessDeniedException(MSG_ADVERTISEMENT_EDIT_FORBIDDEN);
        }
        editAd.setCategory(ad.getCategory());
        editAd.setTitle(ad.getTitle());
        editAd.setDescription(ad.getDescription());
        editAd.setPrice(ad.getPrice());
        editAd.setCurrency(ad.getCurrency());
        return repository.save(editAd);
    }

    @Override
    public List<Advertisement> findAllActive() {
        return repository.findAllByClosedIsFalseAndDeletedIsFalse();
    }

    @Override
    public List<Advertisement> findAllActiveByCategoryName(String name) {
        return repository.findAllByClosedIsFalseAndDeletedIsFalseAndCategoryName(name);
    }

    @Override
    public List<Advertisement> findAllByUsername(String username, boolean closed) {
        return repository.findAllByAuthorAndClosedAndDeletedIsFalse(username, closed);
    }

    @Override
    public Advertisement closeById(Long id) {
        Advertisement advertisement = repository.getById(id);
        advertisement.setClosed(true);
        return repository.save(advertisement);
    }

    @Override
    public Advertisement deleteById(Long id) {
        Advertisement advertisement = repository.getById(id);
        advertisement.setDeleted(true);
        return repository.save(advertisement);
    }
}
