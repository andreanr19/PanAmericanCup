package model;

import java.io.*;

public class PanAmericanCup {

	public final static String separator = File.separator;
	public final static String rooth = "C:" + separator + "Users" + separator + "Usuario" + separator + "Desktop"
			+ separator + "CURSO DE JAVA" + separator + "panAmericanCup" + separator + "src" + separator;
	public final static String roothInfo = rooth + "data" + separator + "pp1.csv";

	private RegisteredParticipant firstRP;
	private PossibleParticipant firstPP;

	public PanAmericanCup() {
		toChargeData(roothInfo);
	}

	public RegisteredParticipant getFirstRP() {
		return firstRP;
	}

	public void setFirstRP(RegisteredParticipant firstRP) {
		this.firstRP = firstRP;
	}

	public PossibleParticipant getFirstPP() {
		return firstPP;
	}

	public void setFirstPP(PossibleParticipant firstPP) {
		this.firstPP = firstPP;
	}

	public String toChargeData(String rooth) {
		String msj = "";
		try {
			FileReader archive = new FileReader(rooth);
			BufferedReader reader = new BufferedReader(archive);
			String info = reader.readLine();
			while (info != null) {
				String[] data = info.split(",");
				PossibleParticipant theNew = new PossibleParticipant(data[1], data[2], data[0],data[3], data[4],
						data[5], data[6]);
				if (theNew != null) {
					toAddAPossibleParticipant(theNew);
					info = reader.readLine();
				}
			}
			msj = "Information has been charged";

			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msj;
	}

	public void toAddAPossibleParticipant(PossibleParticipant theNew) {
		if (firstPP == null) {
			firstPP = theNew;
		} else {
			firstPP.toInsertANewPossibleParticipant(theNew);
		}
	}

	public RegisteredParticipant toSearchForRP(String id) {
		return firstRP == null ? null : firstRP.toSearchForARegisteredParticipant(id);
	}

	public void toAddARegisteredParticipantInOrder(RegisteredParticipant theNew) {
		if (firstRP == null) {
			firstRP = theNew;

		} else if (firstRP.getId().compareToIgnoreCase(theNew.getId()) > 0) {
			firstRP.toInsertBeforeAParticipant(theNew);
			firstRP = theNew;
		} else {
			RegisteredParticipant swip1 = null;
			RegisteredParticipant swip2 = firstRP;
			while (swip2 != null && swip2.getId().compareTo(theNew.getId()) < 0) {
				swip1 = swip2;
				swip2 = swip2.getNext();
			}
			if (swip1 != null) {
				swip1.toInsertAfterAParticipant(theNew);
			}
		}
	}

	public boolean repeatedId(String id) {
		boolean repeated = false;
		RegisteredParticipant swip1 = firstRP;
		while (swip1 != null) {
			if (swip1.getId().equals(id)) {
				repeated = true;
			} else {
				swip1 = swip1.getNext();
			}
		}
		return repeated;
	}

	public int amountPP() {
		int amountPp = firstPP.weightOfTheTree();
		return amountPp;
	}

	public PossibleParticipant toSearchForAPossibleParticipant(String id) {
		return firstPP == null ? null : firstPP.toSearchById(id);
	}

	public String toAddARegisteredParticipant() {
		String msj = "The participants choosed by the moment are:\n";
		int c = 0, r = 0;
		boolean stop = false;

		while (c != (int) amountPP() / 2) {
			r = (int) (Math.random() * amountPP() + 1);
			String valueOfRandom = String.valueOf(r);
			PossibleParticipant swip1 = toSearchForAPossibleParticipant(valueOfRandom);
			if (swip1 != null) {
				RegisteredParticipant theNew = new RegisteredParticipant(swip1.getName(), swip1.getLastName(),
						swip1.getId(), swip1.getEmail(), swip1.getGender(), swip1.getCountry(), swip1.getBirthdate());
				toAddARegisteredParticipantInOrder(theNew);
				msj += theNew.getName() + " " + theNew.getLastName() + " with the id: " + theNew.getId();
			}
			c++;
		}
		return msj;
	}

	public String showTheInfoOfPP(String id) {
		String msj = "";
		long now = System.currentTimeMillis();
		PossibleParticipant p = toSearchForAPossibleParticipant(id);
		long after = System.currentTimeMillis();
		long timeTotal = after - now;
		msj = "The time used for the search of the participant with the id: " + id + " was " + timeTotal + "\n";
		if (p != null) {
			msj += "The participant " + p.getName() + " was found";
		} else {
			msj += " There's no participant with the id " + id;
		}
		return msj;

	}
	public String showTheInfoOfPP2(String id) throws NonExistentParticipant {
		String msj = "";
		long now = System.currentTimeMillis();
		PossibleParticipant p = toSearchForAPossibleParticipant(id);
		long after = System.currentTimeMillis();
		long timeTotal = after - now;
		msj = "The time used for the search of the participant with the id: " + id + " was " + timeTotal + "\n";
		if (p != null) {
			msj += "The participant " + p.getName() + " was found and has the following information\n"
					+"Name: " + p.getName()+"\n"+
					"LastName: "+ p.getLastName()+"\n"
					+"Id: "+ p.getId()+"\n"+
					"Email: "+ p.getEmail()+"\n"+
					"Gender: " + p.getGender()+"\n"+
					"Country: "+p.getCountry()+"\n"+
					"BirthDate: " + p.getBirthdate();
		} else {
			throw new NonExistentParticipant(" There's no participant with the id " + id);
		}
		return msj;

	}

	public String showTheInfoOfRP(String id) throws NonExistentRegisteredException {
		String msj = "";
		long now = System.currentTimeMillis();
		RegisteredParticipant p = toSearchForRP(id);
		long after = System.currentTimeMillis();
		long timeTotal = after - now;
		msj = "the time wasted searching was " + timeTotal + " ";
		if (p != null) {
			msj += "searching the registered participant " + p.getName();
		} else {

			throw new NonExistentRegisteredException("There's no participant with the id " +id);
		}
		return msj;
	}
}
