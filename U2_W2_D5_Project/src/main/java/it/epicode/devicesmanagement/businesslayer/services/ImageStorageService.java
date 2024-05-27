package it.epicode.devicesmanagement.businesslayer.services;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface ImageStorageService {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder(setterPrefix = "with")
	public static class ImageTransform {
		private Integer width;
		private Integer height;
	}

	String store(byte[] imageBytes, String name);

	String imageUrl(String name, ImageTransform transform);
}
