package valuables;

public class Stock extends Valuable {

	private int amount;
	private double sharePrice;

	public Stock(String name, int amount, double sharePrice) {

		super(name);
		this.amount = amount;
		this.sharePrice = sharePrice;

	}

	public void setSharePrice(double sharePrice) {

		this.sharePrice = sharePrice;

	}

	@Override
	protected double calculateValue() {

		return amount * sharePrice;

	}

	protected String getProperties() {

		return String.format("Antal: %s Kurs: %s",
							 amount,
							 sharePrice);

	}

}