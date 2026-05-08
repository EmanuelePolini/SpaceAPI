package resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.ApodData;
import service.ApodService;

@Path("/apod")
public class ApodResource {
	@GET
	@Path("/data")
	@Produces(MediaType.APPLICATION_JSON)
	public ApodData getData() {
		ApodService apod = new ApodService();
		
		return apod.getApodData();
	}
}
