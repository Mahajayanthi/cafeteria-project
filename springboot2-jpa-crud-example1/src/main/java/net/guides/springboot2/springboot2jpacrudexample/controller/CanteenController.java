package net.guides.springboot2.springboot2jpacrudexample.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Canteen;
import net.guides.springboot2.springboot2jpacrudexample.repository.CanteenRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CanteenController<place> {
	@Autowired
	private CanteenRepository canteenRepository;

	/*
	 * @ModelAttribute("place") public List<place> populateDepartments() {
	 * ArrayList<place> departments = new ArrayList<place>(); departments.add(new
	 * place(-1, "Select place")); departments.add(new place(1, "Tidel PARK"));
	 * departments.add(new place(2, "Ramanujam IT Park")); departments.add(new
	 * place(3, "Ticel Park")); return departments; }
	 */
	@GetMapping("/canteens")
	public List<Canteen> getAllEmployees() {
		return canteenRepository.findAll();
	}

	@GetMapping("/canteens/{id}")
	public ResponseEntity<Canteen> getCanteenById(@PathVariable(value = "id") int id)
			throws ResourceNotFoundException {
		Canteen canteen = canteenRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("canteen not found for this id :: " + id));
		return ResponseEntity.ok().body(canteen);
	}

	@PostMapping("/canteens")
	public Canteen createCanteen(@Valid @RequestBody Canteen canteen) {
		return canteenRepository.save(canteen);
	}

	@PutMapping("/canteens/{id}")
	public ResponseEntity<Canteen> updateCanteen(@PathVariable(value = "id") int id,
			@Valid @RequestBody Canteen canteenDetails) throws ResourceNotFoundException {
		Canteen canteen = canteenRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Canteen not found for this canteenNo:: " + id));
        canteen.setPlace(canteenDetails.getPlace());
		canteen.setCompanyName(canteenDetails.getCompanyName());
		canteen.setPhoneNo(canteenDetails.getPhoneNo());
		canteen.setEmailId(canteenDetails.getEmailId());
		canteen.setDate(canteenDetails.getDate());
		canteen.setShopName(canteenDetails.getShopName());
		final Canteen updatedCanteen = canteenRepository.save(canteen);
		return ResponseEntity.ok(updatedCanteen);
	}

	@DeleteMapping("/canteens/{id}")
	public Map<String, Boolean> deleteCanteen(@PathVariable(value = "id") int id)
			throws ResourceNotFoundException {
		Canteen canteen = canteenRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("canteen not found for this id :: " + id));

		canteenRepository.delete(canteen);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
