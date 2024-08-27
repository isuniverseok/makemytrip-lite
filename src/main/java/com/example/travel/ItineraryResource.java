package com.example.travel;

import com.example.travel.models.ItineraryRequest;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/itinerary")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItineraryResource {

    @Inject
    GPTService chatGPTService;

    @POST
    @Path("/generate")
    public Response generateItinerary(ItineraryRequest request) {
        String prompt = "Generate a " + request.getTripDuration() + " " + request.getTravelStyle()
                + " travel itinerary for " + request.getDestination() + "+" + request.getCustomPrompt() + ".";
        String itinerary = chatGPTService.generateItinerary(prompt);
        return Response.ok(itinerary).build();
    }
}
