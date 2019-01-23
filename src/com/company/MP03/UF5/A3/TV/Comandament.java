package com.company.MP03.UF5.A3.TV;


public class Comandament {
	private boolean lliure;
		
	public Comandament() {
		lliure = true;
	}
	
	public synchronized void Agafa() {
		try {
			while(!lliure) wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lliure = false;
		notifyAll();
	}

	public synchronized void Deixa() {
		lliure = true;
		notifyAll();
	}
}
