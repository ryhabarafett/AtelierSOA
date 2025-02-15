package webservices;



import metiers.LogementBusiness;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/logement")
public class LogementRessources {
    LogementBusiness help = new LogementBusiness();
    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*") // Permet tous les domaines
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS") // Permet certaines méthodes HTTP
                .header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization") // Permet certains en-têtes
                .encoding("UTF-8")
                .entity(help.getLogements())
                .build();
    }}