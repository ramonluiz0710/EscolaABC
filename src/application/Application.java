package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Aluno;

public class Application {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String nome = null;
		int idade = 0;
		double notaFinal = 0;
		int opcao = 0;
		double maiorNota = 0;
		Aluno alunoMaiorNota = null;
		boolean erro = false;
		var alunos = new ArrayList<Aluno>();
		
		while(opcao != 4) {
			System.out.println("Selecione uma opçao:");
			System.out.println("1 - Cadastrar novo aluno:");
			System.out.println("2 - Listar todos os alunos cadastrados:");
			System.out.println("3 - Exibir aluno com maior nota:");
			System.out.println();
			System.out.print("Digite aqui: ");
			
			try {
				opcao = sc.nextInt();
				
			}catch(InputMismatchException e) {
				sc.nextLine();
			}
			
			System.out.println();
			
			switch(opcao) {
			case 1:
				sc.nextLine();
				System.out.print("Digite o nome do aluno: ");
				nome = sc.nextLine();
				System.out.println();
				
				do {
					try {
						System.out.print("Digite a idade do aluno: ");
						idade = sc.nextInt();
						System.out.println();
						sc.nextLine();
						
						if(idade <= 0) {
							System.out.println("Idade invalida!");
							System.out.println();
							erro = true;
						}else {
							erro = false;
						}
						
					}catch(InputMismatchException e){
						sc.next();
						System.out.println("Isso não é uma idade!");
						System.out.println();
						erro = true;
					}
				}while(erro);
				
				do {
					try {
						System.out.println("Digite a nota final do aluno: ");
						notaFinal = sc.nextDouble();
						System.out.println();
						sc.nextLine();
						
						if(notaFinal < 0 || notaFinal > 10) {
							System.out.println("Digite uma nota valida!");
							System.out.println();
							erro = true;
						}else {
							erro = false;
						}
					}catch(InputMismatchException e) {
						sc.next();
						System.out.println("Isso não é uma nota valida!");
						System.out.println();
						erro = true;
					}
					
				}while(erro);
				
				alunos.add(new Aluno(nome, idade, notaFinal));
				break;
			case 2:
				for(Aluno i : alunos) {
					System.out.println(i);
					System.out.println();
				}
				break;
			case 3:
				for(Aluno i : alunos) {
					if(i.getNotaFinal() > maiorNota) {
						maiorNota = i.getNotaFinal();
						alunoMaiorNota = i;
					}
				}
				
				System.out.println("Aluno com maior nota: ");
				System.out.println(alunoMaiorNota);
				System.out.println();
				break;
			case 4:
				System.out.println("Saindo...");
				System.out.println();
				break;
			default:
				System.out.println("Opção invalida! Digite novamente!");
				System.out.println();
				break;
			}
		}

	}

}
