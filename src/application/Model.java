package application;

import java.util.ArrayList;
import java.util.List;

public class Model {
	private int nombre1;
	private int nombre2;
	private int resultat;
	private List<Observer> observers;
	
	public Model(int nombre1, int nombre2) {
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.observers = new ArrayList<>();
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
		notifierObservers();
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public void notifierObservers() {
		for(Observer observer : observers) {
			observer.notifier();
		}
	}
	
	public void calculer(int nombre1, int nombre2) {
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		setResultat(nombre1 + nombre2);
	}
}
