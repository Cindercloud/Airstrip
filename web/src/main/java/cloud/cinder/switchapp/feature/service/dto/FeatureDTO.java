package cloud.cinder.switchapp.feature.service.dto;


import cloud.cinder.switchapp.feature.domain.Feature;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Feature entity.
 */
public class FeatureDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    private Boolean active;

    private Long applicationId;

    public Feature toFeature() {
        return new Feature()
            .setId(id)
            .setActive(active)
            .setDescription(description)
            .setName(name);
    }

    public Long getId() {
        return id;
    }

    public FeatureDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FeatureDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public FeatureDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public FeatureDTO setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public FeatureDTO setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FeatureDTO featureDTO = (FeatureDTO) o;

        if (!Objects.equals(id, featureDTO.id)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "FeatureDTO{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", description='" + description + "'" +
            ", active='" + active + "'" +
            '}';
    }

    public FeatureDTO fill(Feature feature) {
        return this.setName(feature.getName())
            .setApplicationId(feature.getApplication().getId())
            .setId(feature.getId())
            .setDescription(feature.getDescription())
            .setActive(feature.isActive());
    }
}
