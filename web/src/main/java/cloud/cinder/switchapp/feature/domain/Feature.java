package cloud.cinder.switchapp.feature.domain;


import cloud.cinder.switchapp.application.domain.Application;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Feature.
 */
@Entity
@Table(name = "feature")
public class Feature implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    public Long getId() {
        return id;
    }

    public Feature setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Feature name(String name) {
        this.name = name;
        return this;
    }

    public Feature setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Feature description(String description) {
        this.description = description;
        return this;
    }

    public Feature setDescription(String description) {
        this.description = description;
        return this;
    }

    public Boolean isActive() {
        return active;
    }

    public Feature active(Boolean active) {
        this.active = active;
        return this;
    }

    public Feature setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Application getApplication() {
        return application;
    }

    public Feature application(Application application) {
        this.application = application;
        return this;
    }

    public Feature setApplication(Application application) {
        this.application = application;
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
        Feature feature = (Feature) o;
        if (feature.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, feature.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Feature{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", description='" + description + "'" +
            ", active='" + active + "'" +
            '}';
    }
}
