package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import model.*;

public class PanAmericanCupTest {
	public PanAmericanCup panAmericanCupTest;

	public void setUpEscenario1() {
		panAmericanCupTest = new PanAmericanCup();
		panAmericanCupTest.setFirstPP(new PossibleParticipant("Samuel", "Nuñez", "1313", "andrea.com", "Masculino",
				"Colombia", "2000/12/19"));
	}

	@Test
	public void toAddAPossibleParticipantTest() {
		setUpEscenario1();
		PossibleParticipant theNew = new PossibleParticipant("Andrea", "Nuñez", "1010", "andrea.com", "Femenino",
				"Colombia", "2000/12/19");
		panAmericanCupTest.toAddAPossibleParticipant(theNew);
		String actual = panAmericanCupTest.getFirstPP().getLeftSon().getName();
		String expected = "Andrea";
		assertEquals(expected, actual);
	}

	@Test
	public void repeatedIdTest() {
		setUpEscenario1();
		panAmericanCupTest.getFirstPP().setLeftSon(
				new PossibleParticipant("Andrea", "Nuñez", "1313", "andrea.com", "Femenino", "Colombia", "2000/12/19"));
		boolean repeated= panAmericanCupTest.repeatedId("1010");
		boolean expected=false;
		assertEquals(repeated, expected);
	}

}
