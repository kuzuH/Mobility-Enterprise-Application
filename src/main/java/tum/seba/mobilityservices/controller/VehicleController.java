package tum.seba.mobilityservices.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tum.seba.mobilityservices.entity.ServicePoint;
import tum.seba.mobilityservices.entity.Vehicle;
import tum.seba.mobilityservices.service.RequestValidationService;
import tum.seba.mobilityservices.service.VehicleService;

@RestController
@RequestMapping("/api")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private RequestValidationService requestValidationService;

	@GetMapping("/vehicles")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<Iterable<Vehicle>>(vehicleService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/vehicles/{id}")
	public ResponseEntity<?> findOne(@PathVariable int id) {
		return new ResponseEntity<Vehicle>(vehicleService.findById(id), HttpStatus.OK);
	}

	@PostMapping("/vehicles")
	public ResponseEntity<?> newVehicle(@Valid @RequestBody Vehicle newVehicle, BindingResult result) {
		Map<String, String> errorMap = requestValidationService.handleValidationErrors(result);
		if (errorMap != null) return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Vehicle>(vehicleService.save(newVehicle), HttpStatus.CREATED);
	}

	@PutMapping("/vehicles/{id}")
	public ResponseEntity<?> replaceVehicle(@PathVariable int id, @Valid @RequestBody Vehicle newVehicle, BindingResult result) {
		Map<String, String> errorMap = requestValidationService.handleValidationErrors(result);
		if (errorMap != null) return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		newVehicle.setId(id);
		vehicleService.save(newVehicle);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/vehicles/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable int id) {
		vehicleService.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PostMapping("/vehicles/servicepoint")
	public ResponseEntity<?> vehiclesByServicePoint(@Valid @RequestBody ServicePoint servicePoint, BindingResult result) {
		Map<String, String> errorMap = requestValidationService.handleValidationErrors(result);
		if (errorMap != null) return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Iterable<Vehicle>>(vehicleService.findVehiclesByServicePoint(servicePoint), HttpStatus.OK);
	}

}
