package resource;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Tarefa;
import service.TarefaService;

@Path("tarefa")
public class TarefaResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listar")
	public Response getTarefas() {
		TarefaService service = new TarefaService();
		List<Tarefa> lista = service.listarTarefas();
		
		Response response = Response.ok().entity(lista).build();
		
		return response;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("tarefas/{id}")
	public Response getTarefaPorId(@PathParam("id") Integer id) {
		TarefaService service = new TarefaService();
		Tarefa tarefa = service.buscarTarefaPorId(id);
		
		Response response =  null;
		
		if(tarefa != null) {
			response = Response.status(Response.Status.OK).entity(tarefa).build();
		} else {
			response = Response.status(Response.Status.NOT_FOUND).entity("A busca não retornou resultados válidos").build();
		}
		
		return response;
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("tarefas/{id}")
	public Response setDeletarTarefa(@PathParam("id") Integer id) {
		TarefaService service = new TarefaService();
		boolean retorno = service.excluirTarefa(id);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.OK).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a exclusão").build();
		}
		
		return response;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setPostTarefa(Tarefa tarefa) {
		TarefaService service = new TarefaService();
		boolean retorno = service.incluirTarefa(tarefa);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.CREATED).entity(tarefa).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a inclusão").build();
		}
		
		return response;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setPutTarefa(Tarefa tarefa) {
		TarefaService service = new TarefaService();
		boolean retorno = service.alterarTarefa(tarefa);
		
		Response response = null;
		
		if(retorno) {
			response = Response.status(Response.Status.OK).entity(tarefa).build();
		} else {
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Não foi possível realizar a alteração").build();
		}
		
		return response;
	}	
}
