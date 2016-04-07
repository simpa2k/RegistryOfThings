package mvc;

import valuables.*;
import compare.*;

import java.util.*;

public class RegistryModel {

	private ArrayList<Valuable> valuables = new ArrayList<>();

	public RegistryModel() {

		valuables.add(new Jewellry("Ring", 3, true));
		valuables.add(new Stock("Alfa Laval", 120, 169.1));
		valuables.add(new Stock("Ericsson", 100, 1300.0));
		valuables.add(new Apparatus("TV", 3000.0, 3));

	}

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