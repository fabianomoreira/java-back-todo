package resource;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
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
}
