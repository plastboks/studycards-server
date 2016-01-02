package net.plastboks.studycards;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Resource_Test
{

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception
    {
        server = App.startServer();

        Client c = ClientBuilder.newClient();
        target = c.target(App.BASE_URI);
    }

    @After
    public void tearDown() throws Exception
    {
        server.stop();
    }

    @Test
    public void testGetIt()
    {
    }
}
