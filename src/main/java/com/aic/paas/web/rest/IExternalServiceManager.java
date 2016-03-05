package com.aic.paas.web.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/external/manage")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IExternalServiceManager {

	@Path("/add")
	@POST
	public String add(String param);

	@Path("/modify")
	@POST
	public String modify(String param);

	@Path("/delete")
	@POST
	public String delete(String param);

	@Path("/query")
	@POST
	public String query(String param);
}
