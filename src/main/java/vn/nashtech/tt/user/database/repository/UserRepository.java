package vn.nashtech.tt.user.database.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.nashtech.tt.user.database.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
