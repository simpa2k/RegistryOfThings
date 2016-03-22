package valuables;

public class Stock extends Valuable {

	private int amount;
	private double sharePrice;

	public Stock(String name, int amount, double sharePrice) {

		super(name);
		this.amount = amount;
		this.sharePrice = sharePrice;

	}

	@Override
	protected double calculateValue() {

		return amount * sharePrice;

	}

	@Override
	public String toString() {

		return String.format("%s: %s Värde: %s Antal: %s Kurs: %s",
							 this.getClass().getSimpleName(),
							 name,
							 calculateValueWithTax(),
							 amount,
							 sharePrice);

	}

}