package com.initshift.timetrack.repository;

import java.util.List;
import com.initshift.timetrack.domain.TimeEntry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface TimeEntryRepository extends CrudRepository<TimeEntry, Long> {

    List<TimeEntry> findByTask(String task);
}
