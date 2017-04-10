package cloud.cinder.switchapp.application.repository;

import cloud.cinder.switchapp.application.domain.Application;

import org.springframework.data.jpa.repository.*;

public interface ApplicationRepository extends JpaRepository<Application,Long> {

}
