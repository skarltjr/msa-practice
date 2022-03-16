package com.msa.infrastructure.jpaRepository;


import com.msa.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<User,Long> {
    User findByIdAndUsername(Long id, String userName);
}
