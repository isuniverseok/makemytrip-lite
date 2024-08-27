package com.example.travel;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.json.Json;
import jakarta.json.JsonObject;

@ApplicationScoped
public class GPTService {

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/completions";
    private static final String API_KEY = "api-key";

    public String generateItinerary(String prompt) {
        Client client = ClientBuilder.newClient();

        JsonObject requestBody = Json.createObjectBuilder()
                .add("model", "text-davinci-003")
                .add("prompt", prompt)
                .add("max_tokens", 500)
                .add("temperature", 0.7)
                .build();

        Response response = client.target(OPENAI_API_URL)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + API_KEY)
                .post(Entity.json(requestBody));

        if (response.getStatus() == 200) {
            JsonObject jsonResponse = response.readEntity(JsonObject.class);
            return jsonResponse.getJsonArray("choices")
                    .getJsonObject(0)
                    .getString("text");
        } else {
            throw new RuntimeException("Failed to generate itinerary: " + response.getStatus());
        }
    }
}
