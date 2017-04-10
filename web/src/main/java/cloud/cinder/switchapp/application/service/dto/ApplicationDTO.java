package cloud.cinder.switchapp.application.service.dto;


import cloud.cinder.switchapp.application.domain.Application;

import java.io.Serializable;

/**
 * A DTO for the Application entity.
 */
public class ApplicationDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    public Application toApplication() {
        return new Application()
            .setDescription(description)
            .setName(name)
            .setId(id);
    }

    public Long getId() {
        return id;
    }

    public ApplicationDTO setId(Long id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public ApplicationDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ApplicationDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationDTO that = (ApplicationDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return description != null ? description.equals(that.description) : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ApplicationDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            '}';
    }

    public ApplicationDTO fill(final Application application) {
        this.setDescription(application.getDescription())
            .setId(application.getId())
            .setName(application.getName());
        return this;
    }
}
