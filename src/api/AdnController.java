package api;

import javax.ws.rs.Consumes; 
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status; 

@Path("/mutant") 
@Produces(MediaType.APPLICATION_JSON) 
@Consumes(MediaType.APPLICATION_JSON) 
public class AdnController {
	
	private AdnService adnService;
	
	public AdnController()
	{
		this.adnService = new AdnService();
	}
	
	@GET  
    public Response sayHello() { 	
        return Response.ok("Hello World desde el API REST",MediaType.APPLICATION_JSON).build();   
    } 
	
	@POST
	@Consumes("application/json")
	public Response mutant(AdnRequest dna)
	{
		Boolean isMutant = this.adnService.isMutant(dna.dna);
		
		if(isMutant)
			return Response.status(Status.OK).build();
		
		return Response.status(Status.FORBIDDEN).build();
	}
	
}
