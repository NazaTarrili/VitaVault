package com.sigis.sigis.repository;

import com.sigis.sigis.domain.User;
import com.sigis.sigis.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
}
