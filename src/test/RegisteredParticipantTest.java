package test;

import model.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegisteredParticipantTest {

	RegisteredParticipant registeredParticipantTest;

	public void setUpEscenario1() {
		registeredParticipantTest = new RegisteredParticipant("Maria", "Rodriguez", "33", "maria.com", "Femenino",
				"Colombia", "2000");
		registeredParticipantTest.setBefore(new RegisteredParticipant("Andrea", "Nuñez", "1010", "andrea.com",
				"Femenino", "Colombia", "2000/12/19"));
		registeredParticipantTest.setNext(new RegisteredParticipant("Samuel", "Nuñez", "1313", "andrea.com",
				"Masculino", "Colombia", "2000/12/19"));
	}

	public void setUpEscenario2() {
		registeredParticipantTest = new RegisteredParticipant("Maria", "Rodriguez", "33", "maria.com", "Femenino",
				"Colombia", "2000");
	}

	@Test
	public void toSearchForARegisteredParticipantTest() {
		setUpEscenario1();
		RegisteredParticipant actual = registeredParticipantTest.toSearchForARegisteredParticipant("33");
		String expected = "Maria";
		assertEquals(expected, actual.getName());
	}

	@Test
	public void toInsertBeforeAParticipantTest() {
		setUpEscenario2();
		registeredParticipantTest.toInsertBeforeAParticipant(new RegisteredParticipant("Andrea", "Nuñez", "1010",
				"andrea.com", "Femenino", "Colombia", "2000/12/19"));
		String actual = registeredParticipantTest.getBefore().getName();
		String expected = "Andrea";
		assertEquals(expected, actual);
	}

}
