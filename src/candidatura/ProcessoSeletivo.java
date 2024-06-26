package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		String [] candidatosSelecionados = selecaoCandidatos();
		System.out.println();
		System.out.println();
        imprimirSelecionados(candidatosSelecionados);
        System.out.println();
        System.out.println();
        entrandoEmContato(candidatosSelecionados);
	}
	
	static String[] selecaoCandidatos() {
		String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE" };

		int candidatosSelecionados = 0;
		int candidatosAtual = 0;
		double salarioBase = 2000.0;
		String[] candidatosSelecionadosArray = new String[5];

		System.out.println("CANDIDATOS NO PROCESSO:");
		
		while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
			String canditado = candidatos[candidatosAtual];
			double salarioPretendido = valorPretendido();

			System.out.println("O candidato " + canditado + " solicitou esse valor pretendido: R$ " + String.format("%.2f", salarioPretendido));
			if (salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + canditado + " foi selecionado para a vaga");
				candidatosSelecionadosArray[candidatosSelecionados] = canditado;
				candidatosSelecionados++;
			}
			candidatosAtual++;
		}
		return candidatosSelecionadosArray;
	}
	
	static void imprimirSelecionados(String [] candidatosSelecionados) {
		System.out.println("CANDIDATOS SELECIONADOS:");
		
		for (int candidatoAtual = 0; candidatoAtual < candidatosSelecionados.length; candidatoAtual++) {
			if (candidatosSelecionados[candidatoAtual] != null) {
				System.out.println("O candidato de número " + (candidatoAtual+1) + " é " + candidatosSelecionados[candidatoAtual]);
			}
		}
	}
	
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}

	static void entrandoEmContato(String[] candidatosSelecionados) {
		System.out.println("STATUS LIGAÇÃO:");
		for (String candidato : candidatosSelecionados) {
			int tentativasRealizadas = 1;
			boolean continuarTentando = true;
			boolean atendeu = false;
			do {
				atendeu = atender();
				continuarTentando = !atendeu;
				if (continuarTentando) {
					tentativasRealizadas++;
				}

			} while (continuarTentando && tentativasRealizadas < 3);

			if (atendeu) {
				System.out.println(candidato + ": Conseguimos contato na " + tentativasRealizadas + " tentativa.");
			} else {
				System.out.println(candidato + ": Não conseguimos contato. Foram realizadas " + tentativasRealizadas + " tentativas.");
			}
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}

	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if (salarioBase > salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO");
		} else if (salarioBase == salarioPretendido) {
			System.out.println("LIGAR PARA O CANDIDATO COM CONTRAPROPOSTA");
		} else {
			System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
		}
	}
	
}
