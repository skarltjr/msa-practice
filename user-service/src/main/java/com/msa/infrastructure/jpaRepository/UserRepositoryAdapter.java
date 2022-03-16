package com.msa.infrastructure.jpaRepository;

import com.msa.domain.UserRepository;
import com.msa.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {
    private final JpaUserRepository jpaUserRepository;
    // ioc 어떠한 orm, db등을 사용할지 책임 위임
    @Override
    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public void delete(User user) {
        jpaUserRepository.delete(user);
    }

    @Override
    public User findByIdAndUsername(Long id, String userName) {
        return jpaUserRepository.findByIdAndUsername(id, userName);
    }
}
