package register;

import valuables.*;
import java.util.ArrayList;

public class RegisterModel {

	private ArrayList<Valuable> valuables = new ArrayList<>();

	public RegisterModel() {

		valuables.add(new Jewellry("Ring", 3, true));
		valuables.add(new Stock("Alfa Laval", 120, 169.1));
		valuables.add(new Apparatus("TV", 3000.0, 3));

	}

	public void update(Valuable valuable) {

		valuables.add(valuable);

	}

	public ArrayList<Valuable> getValuables() {

		return valuables;

	}

}