package com.bahiana;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculoSemaforo {
	
	public static void calculo(int distancia, int velPerm, int acelMed) {
		
		//Arredonda decimais para .00
		DecimalFormat formatador = new DecimalFormat("0.00");
		
		//Converter a velocidade da via de KM/h para M/s e arredonda no formato 0.00
		double velPermMs = (velPerm / 3.6);
		velPermMs = Double.parseDouble(formatador.format(velPermMs));
		
		//Descobre o tempo que o veiculo leva para atingir a velocidade da via e arredonda no formato 0.00
		double tempoVelVia = (velPermMs / acelMed);
		tempoVelVia = Double.parseDouble(formatador.format(tempoVelVia));
		
		//Descobre quantos metros o carro se desloca até atingir a velocidade da via e arredonda para inteiro
		double deslocamentoD = (acelMed * Math.pow(tempoVelVia, 2) / 2);
		int deslocamento = (int) deslocamentoD;
		
		
		//Verifica se a distancia do proximo semáforo é menor do que a distancia que o veiculo leva para atingir a velocidade da via
		//esta regra foi adicionada para evitar uma situação na qual o semáforo nunca fecharia pois o veiculo chegaria quase instantaneamente ao mesmo
		//ou que fossem colocados semáforos praticamente colados uns aos outros
		if (distancia < deslocamento) {
			System.out.println("A distancia do proximo semáforo não pode ser menor do que a distancia que o carro percorrerá para atingir a velocidade da via!");
		} else if (distancia == deslocamento) {
			System.out.println("O próximo semáforo deverá abrir em: " + (tempoVelVia - 5) + " segundos.");
			
		} else {
			int metrosFaltantes = distancia - deslocamento;
			double segundosFaltantes = metrosFaltantes / velPermMs;
			double tempoTotal = tempoVelVia + segundosFaltantes;
			tempoTotal = Double.parseDouble(formatador.format(tempoTotal));
			System.out.println("O próximo semáforo deverá abrir em: " + (tempoTotal - 5) + " segundos.");
		}
		
		
		
		
		
	}
	

	
	public static void rodarDesafio() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bem vindo ao Programa para sincronia de semáforos:");
		System.out.println("O Semáforo abrirá 5 segundos antes do veículo o alcançar");
		System.out.println("Para saber o tempo de abertura do próximo semáforo a partir do semáforo anterior por favor digite:");
		System.out.println("A distancia em Metros até o próximo semáforo:");
		int distancia = sc.nextInt();
		System.out.println("Agora informe em KM/h a velocidade permitida da via:");
		int velPerm = sc.nextInt();
		System.out.println("Por ultimo informe em 'Metros por segundo' a aceleração média dos veículos:");
		int acelMed = sc.nextInt();
		calculo(distancia, velPerm, acelMed);
		
		
		
		
		
	}

}
