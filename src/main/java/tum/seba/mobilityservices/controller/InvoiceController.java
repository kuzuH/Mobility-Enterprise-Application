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

import tum.seba.mobilityservices.entity.Invoice;
import tum.seba.mobilityservices.service.InvoiceService;
import tum.seba.mobilityservices.service.RequestValidationService;

@RestController
@RequestMapping("/api")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private RequestValidationService requestValidationService;

	@GetMapping("/invoices")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<Iterable<Invoice>>(invoiceService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/invoices/{id}")
	public ResponseEntity<?> findOne(@PathVariable int id) {
		return new ResponseEntity<Invoice>(invoiceService.findById(id), HttpStatus.OK);
	}

	@PostMapping("/invoices")
	public ResponseEntity<?> newInvoice(@Valid @RequestBody Invoice newInvoice, BindingResult result) {
		Map<String, String> errorMap = requestValidationService.handleValidationErrors(result);
		if (errorMap != null) return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Invoice>(invoiceService.save(newInvoice), HttpStatus.CREATED);
	}

	@PutMapping("/invoices/{id}")
	public ResponseEntity<?> replaceInvoice(@PathVariable int id, @Valid @RequestBody Invoice newInvoice, BindingResult result) {
		Map<String, String> errorMap = requestValidationService.handleValidationErrors(result);
		if (errorMap != null) return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		newInvoice.setId(id);
		invoiceService.save(newInvoice);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/invoices/{id}")
	public ResponseEntity<?> deleteInvoice(@PathVariable int id) {
		invoiceService.deleteById(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
