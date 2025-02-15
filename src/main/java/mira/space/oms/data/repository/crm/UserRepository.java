package mira.space.oms.data.repository.crm;

import mira.space.oms.data.model.crm.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
