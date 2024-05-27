package it.epicode.devicesmanagement.businesslayer.services.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import it.epicode.devicesmanagement.businesslayer.services.ImageStorageService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CloudinaryImageStorageService implements ImageStorageService {

	public static final String CLOUDINARY_URL = System.getenv("CLOUDINARY_URL");

	private final Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);

	public CloudinaryImageStorageService() {
		cloudinary.config.secure = true;
	}

	@Override
	public String store(byte[] imageBytes, String name) {
		var params = ObjectUtils.asMap("public_id", name);
		try {
			log.info("Uploading image on Cloudinary");
			var info = cloudinary.uploader().upload(imageBytes, params);
			log.info("Image uploaded on Cloudinary");
			return info.get("url").toString();
		} catch (IOException e) {
			log.error("Exception uploading image to Cloudinary", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public String imageUrl(String name, ImageTransform transform) {
		var url = cloudinary.url().generate(name);
		log.info("{}", url);
		return url;
	}
}
