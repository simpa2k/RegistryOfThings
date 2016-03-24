package observer;

public interface Observer {

	void registerWithSubject(Observer observer);

	void update();

}