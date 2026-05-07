package resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.ISSLocation;
import service.ISSService;

@Path("/iss")
public class ISSResource {
	@GET
	@Path("/location")
	@Produces(MediaType.APPLICATION_JSON)
	public ISSLocation getLocation() {
		ISSService service = new ISSService();
		
		return service.getISSLocation();
	}
}
