package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entities.Aluno;

public class AlunoDAO {

	private String sql;
	
	
	public void inserir(String nome, int idade) {
		try(Connection connect = ConnectDB.getConnection()){
			sql = "INSERT INTO aluno(nome, idade) VALUES (?, ?)";
			
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setString(1, nome);
			stm.setInt(2, idade);
			
			stm.executeUpdate();
			System.out.println("Aluno(a) inserido(a)!\n");
		}catch(Exception e) {
			System.err.println("Erro na conexão!");
			e.printStackTrace();
		}
	}
	
	public void listarAlunos() {
		try(Connection connect = ConnectDB.getConnection()){
			sql = "SELECT * FROM listaralunos";
			PreparedStatement stm = connect.prepareStatement(sql);
			ResultSet result = stm.executeQuery();
			
			System.out.println("Alunos:");
			while(result.next()) {
				Aluno aluno = new Aluno(result.getInt("id"), result.getString("nome"), result.getInt("idade"), result.getDouble("nota1"), result.getDouble("nota2"),result.getDouble("nota3"));
				System.out.println("id: " + aluno.getId());
				System.out.println("Nome: " + aluno.getNome());
				System.out.println("Idade: " + aluno.getIdade());
				if(result.getDouble("nota1") > 0) {
					System.out.println("Nota1: " + aluno.getNota1());
				}
				if(result.getDouble("nota2") > 0) {
					System.out.println("Nota2: " + aluno.getNota2());
				}
				if(result.getDouble("nota3") > 0) {
					System.out.println("Nota3: " + aluno.getNota3());
				}
				if(aluno.getNotaFinal() > 0) {
					System.out.println("Media final: " + String.format("%.2f", aluno.getNotaFinal()));
				}
				
				System.out.println();
			}
		}catch(Exception e) {
			System.err.println("Erro na conexão!");
			e.printStackTrace();
		}
	}
	
	private List<Aluno> todosAlunos(){
		try(Connection connect = ConnectDB.getConnection()){
			sql = "SELECT * FROM listaralunos";
			PreparedStatement stm = connect.prepareStatement(sql);
			ResultSet result = stm.executeQuery();
			
			List<Aluno> alunos = new ArrayList<>();
			
			while(result.next()) {
				alunos.add(new Aluno(result.getInt("id"), result.getString("nome"), result.getInt("idade"), result.getDouble("nota1"), result.getDouble("nota2"),result.getDouble("nota3")));
			}
			
			return alunos;
		}catch(Exception e) {
			System.err.println("Erro na conexão!");
			e.printStackTrace();
		}
		
		return null;
	}
	public void inserirNota1(double nota, int id){
		
		boolean achou = false;
		for(Aluno al : todosAlunos()) {
			if(al.getId() == id) {
				achou = true;
			}
		}
		
		if(!achou) {
			System.out.println("id invalido!\n");
			return;
		}
		
		try(Connection connect = ConnectDB.getConnection()){
			sql = "UPDATE aluno SET nota1 = ? WHERE id = ?";
			
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setDouble(1, nota);
			stm.setInt(2, id);
			
			stm.executeUpdate();
			System.out.println("Nota inserida!\n");
		}catch(Exception e) {
			System.err.println("Erro na conexão!");
		}
	}
	
	public void inserirNota2(double nota, int id){
		
		boolean achou = false;
		for(Aluno al : todosAlunos()) {
			if(al.getId() == id) {
				achou = true;
			}
		}
		
		if(!achou) {
			System.out.println("id invalido!\n");
			return;
		}
		
		try(Connection connect = ConnectDB.getConnection()){
			sql = "UPDATE aluno SET nota2 = ? WHERE id = ?";
			
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setDouble(1, nota);
			stm.setInt(2, id);
			
			stm.executeUpdate();
			System.out.println("Nota inserida!\n");
		}catch(Exception e) {
			System.err.println("Erro na conexão!");
		}
	}
	
	public void inserirNota3(double nota, int id){
		
		boolean achou = false;
		for(Aluno al : todosAlunos()) {
			if(al.getId() == id) {
				achou = true;
			}
		}
		
		if(!achou) {
			System.out.println("id invalido!\n");
			return;
		}
		
		try(Connection connect = ConnectDB.getConnection()){
			sql = "UPDATE aluno SET nota3 = ? WHERE id = ?";
			
			PreparedStatement stm = connect.prepareStatement(sql);
			stm.setDouble(1, nota);
			stm.setInt(2, id);
			
			stm.executeUpdate();
			System.out.println("Nota inserida!\n");
		}catch(Exception e) {
			System.err.println("Erro na conexão!");
		}
	}
	
	public void removerAluno(int id) {
		try(Connection connect = ConnectDB.getConnection()){
			sql = "DELETE FROM aluno WHERE id = ?";
			PreparedStatement stm = connect.prepareStatement(sql);
			
			stm.setInt(1, id);
			
			stm.executeUpdate();
			System.out.println("Aluno removido!\n");
		}catch(Exception e) {
			System.err.println("Erro na conexão!");
		}
	}
	
	public void maiorNota() {
		try(Connection connection = ConnectDB.getConnection()){
			List<Aluno> alunos = new LinkedList<>();
			Aluno maiorNota = null;
			
			sql = "SELECT * FROM listaralunos";
			PreparedStatement stm = connection.prepareStatement(sql);
			
			ResultSet result = stm.executeQuery();
			
			while(result.next()){
				alunos.add(new Aluno(result.getInt("id"), result.getString("nome"), result.getInt("idade"), result.getDouble("nota1"), result.getDouble("nota2"),result.getDouble("nota3")));
			}
			
			double maior = 0;
			
			for(Aluno al : alunos) {
				if(al.getNotaFinal() > maior) {
					maiorNota = al;
					maior = al.getNotaFinal();
				}
			}
			
			System.out.println("Aluno com maior nota:\n\n" 
								+ maiorNota);
			System.out.println();
			
		}catch(Exception e) {
			System.out.println("Erro na conexão!");
		}
	}
}
