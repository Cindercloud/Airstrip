package cloud.cinder.switchapp.application.service;

import cloud.cinder.switchapp.application.domain.Application;
import cloud.cinder.switchapp.application.repository.ApplicationRepository;
import cloud.cinder.switchapp.application.service.dto.ApplicationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Application.
 */
@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    private final Logger log = LoggerFactory.getLogger(ApplicationServiceImpl.class);

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    /**
     * Save a application.
     *
     * @param applicationDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ApplicationDTO save(ApplicationDTO applicationDTO) {
        log.debug("Request to save Application : {}", applicationDTO);
        final Application application = applicationRepository.save(applicationDTO.toApplication());
        return toDto(application);
    }

    private static ApplicationDTO toDto(final Application application) {
        return new ApplicationDTO()
            .setDescription(application.getDescription())
            .setName(application.getName())
            .setId(application.getId());
    }

    /**
     * Get all the applications.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<ApplicationDTO> findAll() {
        log.debug("Request to get all Applications");
        List<ApplicationDTO> result = applicationRepository.findAll().stream()
            .map(ApplicationServiceImpl::toDto)
            .collect(Collectors.toCollection(LinkedList::new));

        return result;
    }

    /**
     * Get one application by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Application> findOne(Long id) {
        log.debug("Request to get Application : {}", id);
        Application application = applicationRepository.findOne(id);
        return Optional.ofNullable(application);
    }

    /**
     * Delete the  application by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Application : {}", id);
        applicationRepository.delete(id);
    }
}
