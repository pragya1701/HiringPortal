package http;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/hello")
public class WebService {

	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  public String sayHtmlHello() {
	    return "Hello from jersey";
	  }
}


