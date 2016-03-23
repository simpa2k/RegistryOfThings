package register;

import valuables.*;
import java.util.ArrayList;
import java.util.Collections;

public class RegisterModel {

	private ArrayList<Valuable> valuables = new ArrayList<>();

	public RegisterModel() {

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

	public ArrayList<Valuable> getValuables() {

		return valuables;

	}

	public void sortValuablesByName() {

		Collections.sort(valuables, 
						(Valuable valuable1, Valuable valuable2)->
						valuable1.getName().compareTo(valuable2.getName()));

	}

}