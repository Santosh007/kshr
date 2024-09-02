package com.catchup.app;

import java.util.List;


import com.catchup.carrier.Buddy;
import com.catchup.handler.BuddyFinder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/buddies")
public class CatchupAPI{
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getAllBuddies(){
		BuddyFinder finder = new BuddyFinder();
		List<Buddy> buddies = finder.getAllBuddies();
		GenericEntity<List<Buddy>> buddiesEntity = new GenericEntity<List<Buddy>>(buddies){};
		return Response.ok(buddiesEntity).build();
	}

}
