package com.company.MP09.UF1.A3.TV;


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
