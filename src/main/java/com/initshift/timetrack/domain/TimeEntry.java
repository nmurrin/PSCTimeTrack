package com.initshift.timetrack.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDate;

@Entity
public class TimeEntry {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String task;
    private String description;
    /*private LocalDateTime start;
    private LocalDateTime end;*/
    private LocalDate date;
    private float hours;
    

    public TimeEntry() {}

    public TimeEntry(String task, String description, LocalDate date, float hours) {
        this.task = task;
        this.description = description;
        this.date = date;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return String.format(
                "TimeEntry[id=%d, Task='%s', Description='%s', Date='%s', Hours='%s']",
                id, task, description, date, hours);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public float getHours() {
		return hours;
	}

	public void setHours(float hours) {
		this.hours = hours;
	}
	
	

}
