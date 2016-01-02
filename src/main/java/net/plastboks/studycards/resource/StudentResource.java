package net.plastboks.studycards.resource;

import net.plastboks.studycards.model.type.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("student")
public class StudentResource
{

    @PersistenceContext(unitName = "UserService",
            type = PersistenceContextType.TRANSACTION)
    EntityManager entityManager;

    @GET @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student ping(@PathParam("name") String name)
    {
        return new Student("ping", "ping");
    }
}

