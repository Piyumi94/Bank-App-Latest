package com.userfront.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.userfront.domain.Appointment;

/**
 * repository class for Appointment domain objects All method names are
 * compliant with Spring Data naming conventions so this interface can easily be
 * extended for Spring
 * 
 * @author Piyumi
 *
 */
public interface AppointmentDao extends CrudRepository<Appointment, Long> {

	List<Appointment> findAll();
}
