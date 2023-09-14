package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Tarefa;

public class TarefaDAO {
	
	public boolean incluir(Tarefa tarefa) {
		boolean resultado = true;
		
		Connection cnx = Dao.getConexao();
		
		String SQL = "INSERT INTO tarefas(descricao, status) VALUES(?, ?)";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setString(1, tarefa.getDescricao());
			ps.setBoolean(2, tarefa.getStatus());
			
			int i = ps.executeUpdate();
			
			resultado = i > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	public boolean excluir(Integer id) {
		boolean resultado = true;
		
		Connection cnx = Dao.getConexao();
		
		String SQL = "DELETE FROM tarefas WHERE id = ?";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			
			resultado = i > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
		
	}	
	
	public boolean alterar(Tarefa tarefa) {
		boolean resultado = true;
		
		Connection cnx = Dao.getConexao();
		
		String SQL = "UPDATE tarefas SET descricao = ?, status = ? WHERE id = ?";
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setString(1, tarefa.getDescricao());
			ps.setBoolean(2, tarefa.getStatus());
			ps.setInt(3, tarefa.getId());
			
			int i = ps.executeUpdate();
			
			resultado = i > 0 ? true : false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;	
	}	
	
	@SuppressWarnings("finally")
	public List<Tarefa> listar() {
		List<Tarefa> listaDeTarefas = new ArrayList<Tarefa>();
		Tarefa tarefa;
		
		String SQL = "SELECT * FROM tarefas";
		
		Connection cnx = Dao.getConexao();
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				tarefa = new Tarefa();
				
				tarefa.setId(rs.getInt("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setStatus(rs.getBoolean("status"));
				
				listaDeTarefas.add(tarefa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return listaDeTarefas;
		}
	}
	
	@SuppressWarnings("finally")
	public Tarefa buscarPorId(Integer id) {
		Tarefa tarefa = null;
		
		String SQL = "SELECT * FROM tarefas WHERE id = ?";
		
		Connection cnx = Dao.getConexao();
		
		PreparedStatement ps;
		
		try {
			ps = cnx.prepareStatement(SQL);
			
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				tarefa = new Tarefa();
				
				tarefa.setId(rs.getInt("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setStatus(rs.getBoolean("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.setFecharConexao();
			return tarefa;
		}
	}
}
