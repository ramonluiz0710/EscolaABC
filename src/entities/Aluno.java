package entities;

import java.util.InputMismatchException;
import java.util.Scanner;

import database.AlunoDAO;

public class Aluno {
	private int id;
	private String nome;
	private int idade;
	private double nota1;
	private double nota2;
	private double nota3;
	AlunoDAO dao = new AlunoDAO();
	Scanner sc = new Scanner(System.in);
	
	
	public Aluno() {

	}
	
	public Aluno(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
		this.id = 0;
		this.nota1 = 0;
		this.nota1 = 0;
		this.nota2 = 0;
		this.nota3 = 0;
	}
	
	public Aluno(String nome, int idade, double nota1, double nota2, double nota3) {
		this.nome = nome;
		this.idade = idade;
		this.id = 0;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}
	
	public Aluno(int id, String nome, int idade, double nota1, double nota2, double nota3) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void SetNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public double getNota1() {
		return nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public double getNota3() {
		return nota3;
	}
	
	public double getNotaFinal() {
		return (nota1 + nota2 + nota3)/3;
	}
	
	public void registraAluno() {
		
		boolean erro;
		
		
		System.out.print("Digite o nome do aluno: ");
		this.nome = sc.nextLine();
		System.out.println();
		
		do {
			try {
				System.out.print("Digite a idade do aluno: ");
				this.idade = sc.nextInt();
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
				sc.nextLine();
				System.out.println("Isso não é uma idade!");
				System.out.println();
				erro = true;
			}
		}while(erro);
		dao.inserir(nome, idade);
	}
	
	public void listarAlunos() {
		dao.listarAlunos();
	}
	
	public void mudarNota1() {
		
		System.out.print("Digite o id do aluno: ");
		this.id = sc.nextInt();
		
		System.out.print("Digite a nota do aluno: ");
		this.nota1 = sc.nextDouble();
		sc.nextLine();
		
		dao.inserirNota1(nota1, id);
	}
	
	public void mudarNota2() {
		
		System.out.print("Digite o id do aluno: ");
		this.id = sc.nextInt();
		
		System.out.print("Digite a nota do aluno: ");
		this.nota2 = sc.nextDouble();
		sc.nextLine();
		
		dao.inserirNota2(nota2, id);
	}
	
	public void mudarNota3() {
		
		System.out.print("Digite o id do aluno: ");
		this.id = sc.nextInt();
		
		System.out.print("Digite a nota do aluno: ");
		this.nota3 = sc.nextDouble();
		sc.nextLine();
		
		dao.inserirNota3(nota3, id);
	}
	
	public void removerAluno() {
		
		System.out.print("Digite o id do aluno: ");
		this.id = sc.nextInt();
		sc.nextLine();
		dao.removerAluno(id);
		
	}
	
	public void maiorNota() {
		dao.maiorNota();
	}

	public String toString() {
		return "Nome: " + this.nome 
				+ "\nIdade: " + this.idade
				+ "\nNota 1: " + this.nota1
				+ "\nNota 2: " + this.nota2
				+ "\nNota 3: " + this.nota3
				+ "\nNota Final: " + String.format("%.2f", getNotaFinal());
	}
	

}
