package com.htisolutions.entities;

import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;

@Transactional
public interface GameDao extends CrudRepository<Game, Long> {


}
