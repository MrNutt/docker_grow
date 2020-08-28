package com.yevhen_l.event.service.impl.repository;

import com.yevhen_l.event.service.Event;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EventRepository extends CrudRepository<Event, Long>{
}
