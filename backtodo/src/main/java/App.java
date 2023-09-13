import java.sql.Connection;
import java.util.List;

import dao.Dao;
import dao.TarefaDAO;
import model.Tarefa;

public class App {

	public static void main(String[] args) {
		System.out.println(Dao.getStatusConexao());
		Connection conexao = Dao.getConexao();
		System.out.println(Dao.getStatusConexao());
		
		TarefaDAO dao = new TarefaDAO();
		List<Tarefa> lista = dao.listar();
		
		lista.forEach(tarefa -> System.out.println(tarefa.getDescricao()));
		
		if(lista.isEmpty()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setDescricao("Estudar para prova");
			tarefa.setStatus(false);
			
			if(dao.incluir(tarefa)) {
				System.out.println("Tarefa incluida com sucesso");
			} else {
				System.out.println("Não foi possível incluir");
			}
		}
	}

}
