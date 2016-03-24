package compare;

import java.util.Comparator;
import valuables.Valuable;

public class ValueComparator implements Comparator<Valuable> {

	public int compare(Valuable valuable1, Valuable valuable2) {

		if(valuable1.calculateValueWithTax() > valuable2.calculateValueWithTax()) {

			return -1;

		} else if(valuable1.calculateValueWithTax() == valuable2.calculateValueWithTax()) {

			return 0;

		} else {

			return 1;

		}

	}

}