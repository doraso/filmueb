package pl.javastart.filmueb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository <UserRole, Long> {
    UserRole findByUsername(String username);
}
