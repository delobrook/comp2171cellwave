package CellwavejaUI;

public class Subject {
	public  Observer obs;
	public  void notifyObserversofSuccessfuladdition(int n) {
			obs.update(n);
	}
	public  void notifyObserverOfErrorsInAddingProduct(int n) {
		obs.update(n);
	}
	public void attachObserver(Observer o) {
		obs= o;
	}

}
