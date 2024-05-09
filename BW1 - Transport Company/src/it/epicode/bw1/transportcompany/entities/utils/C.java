package it.epicode.bw1.transportcompany.entities.utils;

public class C {
	public static class Names {
		public static final String DISCRIMINATOR_COLUMN = "type_id";
	}

	public static class T {
		public static class Bus {
			public static final String DISCRIMINATOR_VALUE = "5";
		}

		public static class Mantenance {
			public static class Queries {
				public static final String SELECT_ALL = "MANTENANCE_ALL";
				public static final String SELECT_IN_MANTENANCE = "MAINTENANCE_TRUE";
				public static final String SELECT_IN_SERVICE = "MAINTENANCE_FALSE";
				public static final String SELECT_MANTENANCE_VEHICLE = "MANTENANCE_BY_VEHICLE";
			}
		}

		public static class Reseller {
			public static class Queries {
				public static final String SELECT_ALL = "RESELLERS_ALL";
			}
		}

		public static class Subscription {
			public static class Queries {
				public static final String SELECT_ALL = "SUBSCRIPTIONS_ALL";
			}

			public static final String DISCRIMINATOR_VALUE = "1";
		}

		public static class Ticket {
			public static final String DISCRIMINATOR_VALUE = "0";
		}

		public static class Tram {
			public static final String DISCRIMINATOR_VALUE = "4";
		}

		public static class TravelDocument {
			public static class Queries {
				public static final String DOCUMENTS_BY_PERIOD = "DOCUMENTS_BY_PERIOD";
				public static final String DOCUMENTS_BY_PERIOD_AND_RESELLER = "DOCUMENTS_BY_PERIOD_AND_RESELLER";
				public static final String SELECT_ALL = "DOCUMENTS_ALL";
			}
		}

		public static class User {
			public static class Queries {
				public static final String SELECT_ALL = "USERS_ALL";
			}
		}

		public static class Vehicle {
			public static class Queries {
				public static final String SELECT_ALL = "VEHICLES_ALL";
			}
		}

		public static class VendingMachine {
			public static final String DISCRIMINATOR_VALUE = "3";
		}

		public static class Vendor {
			public static final String DISCRIMINATOR_VALUE = "2";
		}
	}
}
