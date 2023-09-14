package service;

import java.util.List;

import dao.TarefaDAO;
import model.Tarefa;

public class TarefaService {
	TarefaDAO dao = new TarefaDAO();
	
	public Tarefa buscarTarefaPorId(Integer id) {
		return dao.buscarPorId(id);
	}
	
	public List<Tarefa> listarTarefas() {
		return dao.listar();
	}
	
	public boolean incluirTarefa(Tarefa tarefa) {
		return dao.incluir(tarefa);
	}
	
	public boolean alterarTarefa(Tarefa tarefa) {
		return dao.alterar(tarefa);
	}
	
	public boolean excluirTarefa(Integer id) {
		return dao.excluir(id);
	}
}
