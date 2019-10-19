package test;

import model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PossibleParticipantTest {

	PossibleParticipant possibleParticipantTest;

	public void setUpEscenario1() {
		possibleParticipantTest = new PossibleParticipant("Maria", "Rodriguez", "33", "maria.com", "Femenino",
				"Colombia", "2000");
		possibleParticipantTest.setLeftSon(
				new PossibleParticipant("Andrea", "Nuñez", "1010", "andrea.com", "Femenino", "Colombia", "2000/12/19"));
		possibleParticipantTest.setRightSon(new PossibleParticipant("Samuel", "Nuñez", "1313", "andrea.com",
				"Masculino", "Colombia", "2000/12/19"));
	}

	public void setUpEscenario2() {
		possibleParticipantTest = new PossibleParticipant("Maria", "Rodriguez", "33", "maria.com", "Femenino",
				"Colombia", "2000");
	}

	@Test
	public void toSearchByIdTest() {
		setUpEscenario1();
		PossibleParticipant searched = possibleParticipantTest.toSearchById("1010");
		String expected = "Andrea";
		assertEquals(expected, searched.getName());
	}

	@Test
	public void weightOfTheTreeTest() {
		setUpEscenario1();
		int expected = 2;
		int actual = possibleParticipantTest.weightOfTheTree();
		assertEquals(expected, actual);
	}

	@Test
	public void toInsertANewPossibleParticipantTest() {
		setUpEscenario2();
		possibleParticipantTest.toInsertANewPossibleParticipant(
				new PossibleParticipant("Andrea", "Nuñez", "1010", "andrea.com", "Femenino", "Colombia", "2000/12/19"));
		String expected= "Andrea";
		String actual= possibleParticipantTest.getLeftSon().getName();
		assertEquals(expected, actual);
	}

}
