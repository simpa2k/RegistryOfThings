package registry;

import valuables.*;
import compare.*;
import mvc.*;

import java.util.ArrayList;
import java.util.Collections;

public class RegistryModel extends Model {

	private ArrayList<Valuable> valuables = new ArrayList<>();

	public RegistryModel() {

		valuables.add(new Jewellry("Ring", 3, true));
		valuables.add(new Stock("Alfa Laval", 120, 169.1));
		valuables.add(new Apparatus("TV", 3000.0, 3));

	}

	public void add(Valuable valuable) {

		if(valuable == null) {
			
			throw new IllegalArgumentException();

		} else {

			valuables.add(valuable);

		}

	}

	public String getValuables() {

		String valuableList = "";

		for(Valuable valuable : valuables) {

			valuableList += valuable + "\n";

		}

		return valuableList;

	}

	public void setSharePricesToZero() {

		for(Valuable valuable : valuables) {

			if(valuable instanceof Stock) {

				((Stock)valuable).setSharePrice(0.0);

			}

		}

		updateView();

	}

	public void sortValuablesByName() {

		Collections.sort(valuables, new NameComparator());

		updateView();

	}

	public void sortValuablesByValue() {

		Collections.sort(valuables, new ValueComparator());

		updateView();

	}

}