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

import tum.seba.mobilityservices.entity.Rental;
import tum.seba.mobilityservices.service.RentalService;
import tum.seba.mobilityservices.service.RequestValidationService;

@RestController
@RequestMapping("/api")
public class RentalController {

	@Autowired
	private RentalService rentalService;

	@Autowired
	private RequestValidationService requestValidationService;

	@GetMapping("/rentals")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<Iterable<Rental>>(rentalService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/rentals/{id}")
	public ResponseEntity<?> findOne(@PathVariable int id) {
		return new ResponseEntity<Rental>(rentalService.findById(id), HttpStatus.OK);
	}

	@PostMapping("/rentals")
	public ResponseEntity<?> newRental(@Valid @RequestBody Rental newRental, BindingResult result) {
		Map<String, String> errorMap = requestValidationService.handleValidationErrors(result);
		if (errorMap != null) return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Rental>(rentalService.save(newRental), HttpStatus.CREATED);
	}

	@PutMapping("/rentals/{id}")
	public ResponseEntity<?> replaceRental(@PathVariable int id, @Valid @RequestBody Rental newRental, BindingResult result) {
		Map<String, String> errorMap = requestValidationService.handleValidationErrors(result);
		if (errorMap != null) return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		newRental.setId(id);
		rentalService.save(newRental);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/rentals/{id}")
	public ResponseEntity<?> deleteRental(@PathVariable int id) {
		rentalService.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping("/rentals/completed")
	public ResponseEntity<?> completedRentals() {
		return new ResponseEntity<Iterable<Rental>>(rentalService.findCompletedRentals(), HttpStatus.OK);
	}

}
