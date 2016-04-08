package mvc;

import valuables.*;
import compare.*;

import java.util.*;

public class RegistryModel {

	private ArrayList<Valuable> valuables = new ArrayList<>();

	protected void add(Valuable valuable) {

		valuables.add(valuable);

	}

	protected String getValuables(Comparator<Valuable> comparator) {
		
		Collections.sort(valuables, comparator);

		String valuableList = "";

		for(Valuable valuable : valuables) {

			valuableList += valuable + "\n";

		}

		return valuableList;

	}

	protected void setSharePricesToZero() {

		for(Valuable valuable : valuables) {

			if(valuable instanceof Stock) {

				((Stock)valuable).setSharePrice(0.0);

			}

		}

	}

}