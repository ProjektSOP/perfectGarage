package objects;

/**
 * @author mrothe
 * 
 * Eine Auftragsmappe enthält eine ArrayList aus Arbeitsteilaufträgen, welcher zu diesem Auftrag gehören
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
