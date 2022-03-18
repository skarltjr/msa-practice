package com.msa.domain;

import com.msa.domain.model.User;

public interface UserRepository {

    User save(User user);

    void delete(User user);

    User findByIdAndUsername(Long id, String userName);

    User findById(Long id);
}
