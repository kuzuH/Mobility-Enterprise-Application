package tum.seba.mobilityservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tum.seba.mobilityservices.entity.ServicePoint;
import tum.seba.mobilityservices.exception.EntityNotFoundException;
import tum.seba.mobilityservices.repository.ServicePointRepository;

@Service
public class ServicePointService {

	@Autowired
	ServicePointRepository servicePointRepository;
	
	public ServicePoint save(ServicePoint newServicePoint) {
		return servicePointRepository.save(newServicePoint);
	}
	
	public Iterable<ServicePoint> findAll() {
		return servicePointRepository.findAll();
	}
	
	public ServicePoint findById(int servicePointId) {
		return servicePointRepository.findById(servicePointId).orElseThrow(() -> new EntityNotFoundException("ServicePoint with ID '" + servicePointId + "' does not exist!"));
	}
	
	public void deleteById(int servicePointId) {
		
		try {
			servicePointRepository.deleteById(servicePointId);
		}
		catch (Exception e) {
			System.err.println("Unable to delete ServicePoint with ID: " + servicePointId);
		}
		
	}
}
