package view;

import java.util.concurrent.Semaphore;

import controller.TheadRestaurante;

public class Restaurante {

	public static void main(String[] args) {
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idPrato = 0 ; idPrato< 5 ; idPrato ++) {
			Thread tprato = new TheadRestaurante (idPrato, semaforo);
			tprato.start();
			}
	}

}
