package controller;

import java.util.concurrent.Semaphore;

import javafx.util.converter.PercentageStringConverter;

public class TheadRestaurante extends Thread {
	private int idPrato;
	private Semaphore semaforo;
	private String nome;

	public TheadRestaurante(int idPrato, Semaphore semaforo) {
		this.idPrato = idPrato;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		preparaPrato();
		// -------inicio de sessao critica
		try {
			semaforo.acquire();
			saidaPrato();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void saidaPrato() {
		System.out.println("Prato Pronto " + nome);
		int tempo = 500;
	}

	private void preparaPrato() {
		int tempPrato = 0;
		int tempTotal = 0;
		int progresso = 0;
		if (idPrato % 2 == 0) {
			tempPrato = (int) ((Math.random() * 601) + 600);
			tempTotal = 0;
			progresso = 100;
			int tempo = 100;
			nome = "lasanha a Bolonhesa";
			System.out.println("A lasanha a Bolonhesa deu inicio: ");
			while (tempTotal < tempPrato) {
				tempTotal += progresso;
				int percProg = 0;
				percProg = (int)tempPrato/100;
				try {
					sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Percentual de praparo %" + percProg*10);
			}
		} else {
			tempPrato = (int) ((Math.random() * 501) + 300);
			tempTotal = 0;
			progresso = 100;
			int tempo = 100;
			nome = "Sopa de Cebola";
			System.out.println("A Sopa de Cebola deu inicio: ");
			while (tempTotal < tempPrato) {
				tempTotal += progresso;
				int percProg = 0;
				percProg = (int)tempPrato/100;
				try {
					sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Percentual de praparo %" + percProg*10);
			}
		}

	}
}
