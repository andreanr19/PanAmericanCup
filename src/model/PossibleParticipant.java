package model;

public class PossibleParticipant implements Comparable {

	private String name;
	private String lastName;
	private String id;
	private String email;
	private String gender;
	private String country;
	private String birthdate;

	private PossibleParticipant leftSon;
	private PossibleParticipant rightSon;

	public PossibleParticipant(String name, String lastName, String id, String email, String gender, String country,
			String birthdate) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public PossibleParticipant getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(PossibleParticipant leftSon) {
		this.leftSon = leftSon;
	}

	public PossibleParticipant getRightSon() {
		return rightSon;
	}

	public void setRightSon(PossibleParticipant rightSon) {
		rightSon = rightSon;
	}

	public int compareTo(Object participant) {
		PossibleParticipant p = (PossibleParticipant) participant;

		return this.id.compareTo(p.getId());
	}

	public int weightOfTheTree() {
		int pp1 = (leftSon == null) ? 0 : leftSon.weightOfTheTree();
		int pp2 = (rightSon == null) ? 0 : rightSon.weightOfTheTree();
		return 1 + pp1 + pp2;
	}

	public PossibleParticipant toSearchById(String id) {
		if (this.id.compareToIgnoreCase(id) == 0)
			return this;
		else if (this.id.compareToIgnoreCase(id) < 0)
			return (rightSon == null) ? null : rightSon.toSearchById(id);
		else
			return (leftSon == null) ? null : leftSon.toSearchById(id);
	}

	public void toInsertANewPossibleParticipant(PossibleParticipant theNew) {
		if (compareTo(theNew) > 0) {
			if (leftSon == null) {
				leftSon = theNew;
			} else {
				leftSon.toInsertANewPossibleParticipant(theNew);
			}
		} else {
			if (rightSon == null) {
				rightSon = theNew;
			} else {
				rightSon.toInsertANewPossibleParticipant(theNew);
			}
		}
	}

}
