package people;

public enum PersonType {
	PATIENT {
		@Override
		int type() {
			return 0;
		}
	}, DONOR {
		@Override
		int type() {
			return 1;
		}
	};
	
	abstract int type();
}
