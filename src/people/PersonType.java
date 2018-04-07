package people;

public enum PersonType {
	PATIENT {
		@Override
		String type() {
			return "Patient";
		}
	}, DONOR {
		@Override
		String type() {
			return "Donor";
		}
	};
	
	abstract String type();
}
