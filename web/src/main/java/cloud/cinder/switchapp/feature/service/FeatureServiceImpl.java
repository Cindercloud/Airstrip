package cloud.cinder.switchapp.feature.service;

import cloud.cinder.switchapp.application.domain.Application;
import cloud.cinder.switchapp.feature.domain.Feature;
import cloud.cinder.switchapp.feature.repository.FeatureRepository;
import cloud.cinder.switchapp.feature.service.dto.FeatureDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {

    private final Logger log = LoggerFactory.getLogger(FeatureServiceImpl.class);

    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    /**
     * Save a feature.
     *
     * @param featureDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public FeatureDTO save(FeatureDTO featureDTO) {
        log.debug("Request to save Feature : {}", featureDTO);
        Feature feature = featureDTO.toFeature()
            .setApplication(new Application()
                .setId(featureDTO.getApplicationId()));
        feature = featureRepository.save(feature);
        return toDto(feature);
    }

    private static FeatureDTO toDto(final Feature feature) {
        return new FeatureDTO()
            .setId(feature.getId())
            .setActive(feature.isActive())
            .setApplicationId(feature.getApplication().getId())
            .setDescription(feature.getDescription())
            .setName(feature.getName());
    }

    /**
     * Get all the features.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<FeatureDTO> findAll() {
        log.debug("Request to get all Features");
        return featureRepository.findAll().stream()
            .map(FeatureServiceImpl::toDto)
            .collect(Collectors.toList());
    }

    /**
     * Get one feature by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Feature> findOne(Long id) {
        log.debug("Request to get Feature : {}", id);
        return featureRepository.findOne(id);
    }

    /**
     * Delete the  feature by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Feature : {}", id);
        featureRepository.delete(id);
    }
}
