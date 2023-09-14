import java.sql.Connection;
import java.util.List;

import dao.Dao;
import dao.TarefaDAO;
import model.Tarefa;

public class App {

	public static void main(String[] args) {
		TarefaDAO dao = new TarefaDAO();
		
		System.out.println(dao.buscarPorId(3));
		
		/*
		System.out.println(Dao.getStatusConexao());
		Connection conexao = Dao.getConexao();
		System.out.println(Dao.getStatusConexao());
		
		TarefaDAO dao = new TarefaDAO();
		
		List<Tarefa> lista = dao.listar();
		
		if(!lista.isEmpty()) {
			lista.forEach(tarefa -> System.out.println(tarefa));
		} else {
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricao("Estudar para prova");
			tarefa.setStatus(false);
			
			if(dao.incluir(tarefa)) {
				System.out.println("Tarefa incluida com sucesso");
			} else {
				System.out.println("Não foi possível incluir");
			}
		}
		
		//dao.excluir(2);
		
		
		Tarefa tarefa = new Tarefa();
		tarefa.setId(1);
		tarefa.setDescricao("Buscar encomenda");
		tarefa.setStatus(true);
		
		dao.alterar(tarefa);
		*/
	}

}
