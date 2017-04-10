package cloud.cinder.switchapp.usermanagement.repository;

import cloud.cinder.switchapp.infrastructure.repository.JpaRepository;
import cloud.cinder.switchapp.usermanagement.domain.GithubUser;

public interface GithubUserRepository extends JpaRepository<GithubUser, Long> {
}
