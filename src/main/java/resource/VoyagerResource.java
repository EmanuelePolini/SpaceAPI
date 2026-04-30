package resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.VoyagerData;
import service.VoyagerService;

//questa è la classe dove JAX-RS gestisce tutto ciò che parte da /voyager
@Path("/voyager")
public class VoyagerResource {
	//richiesta lettura
	@GET
	//sottopath
	@Path("/status")
	@Produces(MediaType.APPLICATION_JSON)
	public VoyagerData getStatus() {
		VoyagerService service = new VoyagerService();
		//ritorna un oggetto e JAX-RS lo trasforma in JSON
		return service.getVoyagerData();
	}
	
}
