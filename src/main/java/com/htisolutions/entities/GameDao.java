package com.htisolutions.entities;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface GameDao extends CrudRepository<Game, Long> {

}
