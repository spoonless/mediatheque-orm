package com.cgi.poei.mediatheque;

public enum Section {
	
	TOUT_PUBLIC(0), JEUNESSE(0), ADULTE(14);
	
	private final int ageMinimum;
	
	private Section(int ageMinimum) {
		this.ageMinimum = ageMinimum;
	}
	
	public int getAgeMinimum() {
		return ageMinimum;
	}
	
	public boolean isAssezAge(Usager usager) {
		if (this == ADULTE) {
			Integer age = usager.getAge();
			return age != null && age >= ageMinimum;
		}
		return true;
	}

	@Override
	public String toString() {
		switch (this) {
		case TOUT_PUBLIC:
			return "Tout public";
		case JEUNESSE:
			return "Jeunesse";
		case ADULTE:
			return "Adulte";
		}
		return null;
	}

}
