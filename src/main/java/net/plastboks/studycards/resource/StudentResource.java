package net.plastboks.studycards.resource;

import net.plastboks.studycards.model.type.Student;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("myresource")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource
{

    @GET
    public Student ping() {
        return new Student("ping", "ping");
    }
}

