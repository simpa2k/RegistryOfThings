package mvc;

public abstract class Model {

	private View view;

	public void registerView(View view) {

		this.view = view;

	}

	public void updateView() {
	
		view.update();

	}

}