package it.epicode.devicesmanagement.presentationlayer.controllers.api;

import java.io.IOException;

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
import it.epicode.devicesmanagement.businesslayer.services.ImageStorageService;
import it.epicode.devicesmanagement.businesslayer.services.ImageStorageService.ImageTransform;
import it.epicode.devicesmanagement.presentationlayer.models.EmployeeRequestModel;
import it.epicode.devicesmanagement.utils.Utils;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/employees")
@Slf4j
public class EmployeesController extends ApiBaseController {

	@Autowired
	private EmployeeService employees;

	@Autowired
	private ImageStorageService imageStorage;

	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestPart(name = "employee") @Validated EmployeeRequestModel model,
			@RequestPart(name = "picture", required = false) MultipartFile imagePic, BindingResult validation) {
		try {
			String picId = null;
			if (imagePic != null) {
				picId = imageStorage.store(imagePic.getBytes(), Utils.purify(imagePic.getOriginalFilename()));
			}

			var e = employees.save(EmployeeDto.builder().withEmail(model.email()).withFirstName(model.firstName())
					.withImagePicture(picId).withLastName(model.lastName()).withUsername(model.username()).build());
			return new ResponseEntity<EmployeeDto>(e, HttpStatus.OK);
		} catch (IOException ex) {
			log.error("Exception storing image", ex);
			throw new RuntimeException(ex);
		}
	}
}
