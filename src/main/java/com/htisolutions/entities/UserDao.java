package com.htisolutions.entities;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

}
