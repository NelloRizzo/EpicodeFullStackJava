package it.epicode.devicesmanagement.presentationlayer.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import it.epicode.devicesmanagement.businesslayer.dto.EmployeeDto;
import it.epicode.devicesmanagement.businesslayer.services.EmployeeService;
import it.epicode.devicesmanagement.presentationlayer.models.EmployeeRequestModel;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController extends ApiBaseController {

	@Autowired
	private EmployeeService employees;

	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestPart(name = "employee") @Validated EmployeeRequestModel model,
			@RequestPart(name = "picture", required = false) MultipartFile imagePic, BindingResult validation) {
			if (validation.hasErrors()) {
				throw new RuntimeException();
			}
			var e = employees.save(EmployeeDto.builder().withEmail(model.email()).withFirstName(model.firstName())
					.withFile(imagePic).withLastName(model.lastName()).withUsername(model.username()).build());
			return new ResponseEntity<EmployeeDto>(e, HttpStatus.OK);
	}
}
