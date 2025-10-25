package entities;

public class Aluno {
	private String nome;
	private int idade;
	private double notaFinal;
	
	
	public Aluno() {

	}
	
	public Aluno(String nome, int idade, double notaFinal) {
		this.nome = nome;
		this.idade = idade;
		this.notaFinal = notaFinal;
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
	
	public double getNotaFinal() {
		return this.notaFinal;
	}
	
	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}
	
	public String toString() {
		return "Nome: " + this.nome 
				+ "\nIdade: " + this.idade
				+ "\nNota Final: " + this.notaFinal;
	}
	

}
