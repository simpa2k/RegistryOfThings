package compare;

import java.util.Comparator;
import valuables.Valuable;

public class ValueComparator implements Comparator<Valuable> {

	@Override
	public int compare(Valuable valuable1, Valuable valuable2) {

		return (int) (valuable2.calculateValueWithTax() - valuable1.calculateValueWithTax()); 

	}

}