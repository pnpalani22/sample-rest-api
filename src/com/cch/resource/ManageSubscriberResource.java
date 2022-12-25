package com.cch.resource;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cch.dto.Sim;
import com.cch.dto.Subscriber;

@Path("/subscriber")
public class ManageSubscriberResource {
	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/new")
	public Sim newSubscriber(Subscriber subscriber) {
		Sim sim = new Sim();

		sim.setSimNo(UUID.randomUUID().toString());
		sim.setSubscriberNo(subscriber.getFirstName() + "-1");
		sim.setMobileNo("9837947494");
		sim.setName(subscriber.getFirstName() + " " + subscriber.getLastName());
		sim.setBalance(30f);

		return sim;
	}
}
