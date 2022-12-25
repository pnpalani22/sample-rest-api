package com.cch.providers;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.cch.dto.Sim;
import com.cch.dto.Subscriber;

@Provider
@Consumes(MediaType.APPLICATION_XML)
public class JAXBContextResolver implements ContextResolver<JAXBContext> {
	private JAXBContext jaxbContext;

	public JAXBContextResolver() throws JAXBException {
		System.out.println("JAXBContextResolver()");
		jaxbContext = JAXBContext.newInstance(Subscriber.class, Sim.class);
	}

	@Override
	public JAXBContext getContext(Class<?> classType) {
		if (classType.isAssignableFrom(Subscriber.class)
				|| classType.isAssignableFrom(Sim.class)) {
			return jaxbContext;
		}
		return null;
	}

}
