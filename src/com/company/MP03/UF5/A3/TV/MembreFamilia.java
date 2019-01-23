package com.company.MP03.UF5.A3.TV;

public class MembreFamilia extends Thread {
	Comandament com;
	static int canal;

	public MembreFamilia(Comandament c, String nom) {
		super(nom);
		com = c;
		canal = 0;
	}

	@Override
	public void run() {
		for(;;) {
			//Agafa el comandament
			com.Agafa();
			int canal2 = (int)((Math.random()*10)+1); // Tria el canal
			System.out.println(getName() + " està mirant el canal " + canal2 + new String((canal==canal2)?" ":" (ha canviat de canal)"));
			canal = canal2;
			//Mira la tele
			try {
				Thread.sleep((long) (Math.random()*800)+200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Deixa el comandament
			com.Deixa();
			//Descansa de tanta tele
			try {
				System.out.println(getName() + " ja no miro la tele");
				Thread.sleep((long) (Math.random()*1000)+500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
