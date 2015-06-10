package objects;

/**
 * @author mrothe
 * 
 * Eine Auftragsmappe enth�lt eine ArrayList aus Arbeitsteilauftr�gen, welcher zu diesem Auftrag geh�ren
 * 
 */

import java.util.ArrayList;

public class Auftragsmappe {

	ArrayList<Arbeitsteilauftrag> auftragsmappe = new ArrayList<Arbeitsteilauftrag>();

	public void add(Arbeitsteilauftrag tempteilauftrag) {

		auftragsmappe.add(tempteilauftrag);

	}

	public ArrayList<Arbeitsteilauftrag> getAuftragsmappe() {
		return auftragsmappe;
	}

}
