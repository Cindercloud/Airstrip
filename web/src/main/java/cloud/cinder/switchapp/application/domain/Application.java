package cloud.cinder.switchapp.application.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Application.
 */
@Entity
@Table(name = "application")
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Long getId() {
        return id;
    }

    public Application setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Application name(String name) {
        this.name = name;
        return this;
    }

    public Application setName(String name) {
        this.name = name;
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
        Application application = (Application) o;
        if (application.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, application.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Application{" +
            "id=" + id +
            ", name='" + name + "'" +
            '}';
    }

    public String getDescription() {
        return description;
    }

    public Application setDescription(String description) {
        this.description = description;
        return this;
    }
}
