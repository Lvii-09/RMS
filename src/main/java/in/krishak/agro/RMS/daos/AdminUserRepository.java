package in.krishak.agro.RMS.daos;

import in.krishak.agro.RMS.models.AdminUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    Optional<AdminUser> findByPhoneNumber(String phoneNumber);

}
