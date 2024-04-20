package com.vitavault.vitavault.repository;

import com.vitavault.vitavault.domain.User;
import com.vitavault.vitavault.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
}
