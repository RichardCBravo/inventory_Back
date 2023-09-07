package com.nexos.inventory.persistence.crud;

import com.nexos.inventory.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Integer> {

}
