package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import database.AlunoDAO;
import entities.Aluno;

public class Application {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		Aluno aluno = new Aluno();
		
		
		while(opcao != 8) {
			System.out.println("Selecione uma opçao:");
			System.out.println("1 - Cadastrar novo aluno:");
			System.out.println("2 - Listar todos os alunos cadastrados:");
			System.out.println("3 - Inserir/mudar primeira nota:");
			System.out.println("4 - Inserir/mudar segunda nota:");
			System.out.println("5 - Inserir/mudar terceira nota:");
			System.out.println("6 - Remover aluno: ");
			System.out.println("7 - Aluno com maior nota:");
			System.out.println("8 - Sair ");
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
				aluno.registraAluno();
				
				break;
			case 2:
				aluno.listarAlunos();
				break;
			case 3:
				aluno.mudarNota1();
				break;
			case 4:
				aluno.mudarNota2();
				break;
			case 5:
				aluno.mudarNota3();
				break;
			case 6:
				aluno.removerAluno();
				break;
			case 7:
				aluno.maiorNota();
				break;
			case 8:
				System.out.println("Saindo...");
				System.out.println();
				break;
			default:
				System.out.println("Opção invalida! Digite novamente!");
				System.out.println();
				break;
			}
		}
		
		System.out.println("Obrigado por usar nosso sistema!");

	}

}
