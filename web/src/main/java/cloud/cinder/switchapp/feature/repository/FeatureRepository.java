package cloud.cinder.switchapp.feature.repository;

import cloud.cinder.switchapp.feature.domain.Feature;
import cloud.cinder.switchapp.infrastructure.repository.JpaRepository;


/**
 * Spring Data JPA repository for the Feature entity.
 */
@SuppressWarnings("unused")
public interface FeatureRepository extends JpaRepository<Feature,Long> {

}
