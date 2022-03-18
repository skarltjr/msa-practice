package com.msa.domain.query;

import com.msa.domain.UserRepository;
import com.msa.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserQueryProcessor {
    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
