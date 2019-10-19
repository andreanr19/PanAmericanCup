package model;

public class RegisteredParticipant {

	
	private String name;
	private String lastName;
	private String id;
	private String email;
	private String gender;
	private String country;
	private String birthdate;
	int size;
	
	private RegisteredParticipant before;
	private RegisteredParticipant next;
	
	public RegisteredParticipant( String name, String lastName,String id,String email, String gender, String country,
			String birthdate) {
		this.id=id;
		this.name=name;
		this.lastName=lastName;
		this.email=email;
		this.gender=gender;
		this.country=country;
		this.birthdate=birthdate;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public RegisteredParticipant getBefore() {
		return before;
	}

	public void setBefore(RegisteredParticipant before) {
		this.before = before;
	}

	public RegisteredParticipant getNext() {
		return next;
	}

	public void setNext(RegisteredParticipant next) {
		this.next = next;
	}
	
	public RegisteredParticipant toSearchForARegisteredParticipant(String id) {
		if(this.id.compareToIgnoreCase(id)==0) {
			return this;
		}else if(this.id.compareToIgnoreCase(id)>0) {
			return (before==null)? null : before.toSearchForARegisteredParticipant(id);
		}else {
			return (next== null)? null: next.toSearchForARegisteredParticipant(id);
		}
	}
	
	public void toInsertBeforeAParticipant(RegisteredParticipant theNew) {
		if(before!=null) 
			before.next= theNew;
			
		theNew.before=before;
		theNew.next=this;
		before=theNew;
	}
	public void toInsertAfterAParticipant(RegisteredParticipant theNew) {
		theNew.next=next;
		if(next!=null) {
			next.next=theNew;
			theNew.before=this;
			next=theNew;
		}
	}
}
