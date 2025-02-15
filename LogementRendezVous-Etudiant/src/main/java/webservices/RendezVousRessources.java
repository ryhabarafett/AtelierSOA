package webservices;

import entities.RendezVous;
import metiers.RendezVousBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rendezvous")
public class RendezVousRessources {
    RendezVousBusiness rendezVousBusiness = new RendezVousBusiness();

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response
                .status(200)
                .entity(rendezVousBusiness.getRendezVousList())
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRendezVousById(@PathParam("id") int id) {
        RendezVous rendezVous = rendezVousBusiness.getRendezVousById(id);
        if (rendezVous != null) {
            return Response.status(200).entity(rendezVous).build();
        }
        return Response.status(404).entity("Rendez-vous non trouvé").build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addRendezVous(RendezVous rendezVous) {
        if (rendezVousBusiness.addRendezVous(rendezVous)) {
            return Response.status(201).entity("Rendez-vous ajouté avec succès").build();
        }
        return Response.status(500).entity("Échec de l'ajout du rendez-vous").build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateRendezVous(RendezVous rendezVous) {
        if (rendezVousBusiness.updateRendezVous(rendezVous)) {
            return Response.status(200).entity("Rendez-vous mis à jour avec succès").build();
        }
        return Response.status(500).entity("Échec de la mise à jour du rendez-vous").build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteRendezVous(@PathParam("id") int id) {
        if (rendezVousBusiness.deleteRendezVous(id)) {
            return Response.status(200).entity("Rendez-vous supprimé avec succès").build();
        }
        return Response.status(500).entity("Échec de la suppression du rendez-vous").build();
    }

    @GET
    @Path("/byLogement/{reference}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRendezVousByLogement(@PathParam("reference") int reference) {
        return Response
                .status(200)
                .entity(rendezVousBusiness.getRendezVousByLogement(reference))
                .build();
    }
}