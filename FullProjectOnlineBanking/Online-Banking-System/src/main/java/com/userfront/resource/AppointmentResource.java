package com.userfront.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userfront.domain.Appointment;
import com.userfront.service.AppointmentService;

/**
 * Appointment Resource contoller
 * 
 * @author Piyumi
 *
 */
@RestController
@RequestMapping("/api/appointment")
@PreAuthorize("hasRole('ADMIN')")
public class AppointmentResource {

	@Autowired
	private AppointmentService appointmentService;

	/**
	 * get all appointmentList
	 * 
	 * @return appointmentList object
	 */
	@RequestMapping("/all")
	public List<Appointment> findAppointmentList() {
		List<Appointment> appointmentList = appointmentService.findAll();

		return appointmentList;
	}

	/**
	 * confirm a appointment
	 * 
	 * @param id
	 */
	@RequestMapping("/{id}/confirm")
	public void confirmAppointment(@PathVariable("id") Long id) {
		appointmentService.confirmAppointment(id);
	}
}
