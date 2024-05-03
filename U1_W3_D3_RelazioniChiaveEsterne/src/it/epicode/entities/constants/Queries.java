package it.epicode.entities.constants;

public class Queries {
	public static class Provinces {
		public static final String ALL = "PROVINCES_ALL";
		public static final String BY_ACRONYM = "PROVINCE_BY_ACRONYM";
		public static final String COUNT = "PROVINCES_COUNT";
		public static final String BY_SAMPLE = "PROVINCES_COUNT_BY_SAMPLE";
	}

	public static class Cities {
		public static final String ALL = "CITIES_ALL";
		public static final String BY_PROVINCE = "CITIES_BY_PROV";
		public static final String BY_ID = "CITY_BY_ID";
		public static final String COUNT_BY_PROVINCE = "CITIES_COUNT_BY_PROVINCE";
		public static final String COUNT = "CITIES_COUNT";
	}
}
