package compare;

import java.util.Comparator;
import valuables.Valuable;

public class NameComparator implements Comparator<Valuable> {

	@Override
	public int compare(Valuable valuable1, Valuable valuable2) {

		return valuable1.getName().compareTo(valuable2.getName());

	}

}