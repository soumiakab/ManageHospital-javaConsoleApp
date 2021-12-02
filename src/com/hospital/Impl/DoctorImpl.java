package com.hospital.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hospital.enumerations.SpecialtyEnum;
import com.hospital.models.Doctor;
import com.hospital.models.Hospital;
import com.hospital.models.Operation;

public class DoctorImpl {

	public static List<Doctor> getDoctorWithSpeciality(SpecialtyEnum sp) {
		List<Doctor> doctorsSp=new ArrayList<Doctor>();
			for(Doctor doctor:Hospital.getDoctors()) {
				if(doctor.getDoctorSpecialty().equals(sp)) {
					doctorsSp.add(doctor);
				}
			}
		return doctorsSp;
	}
	
	
}
