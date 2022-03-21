package com.msa.infrastructure;

import com.msa.domain.UserRepository;
import com.msa.domain.exception.UserNotFoundException;
import com.msa.domain.model.User;
import com.msa.infrastructure.jpaRepository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.util.Optional;

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

    @Override
    public User findById(Long id) {
        Optional<User> user = jpaUserRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException(HttpStatus.NOT_FOUND.value(),id + "에 해당하는 유저가 없습니다.");
        } else {
            return user.get();
        }
    }
}
