package com.example.travel.models;

public class ItineraryRequest {
    private String destination;
    private String tripDuration;
    private String travelStyle;
    private String CustomPrompt;


    public void setCustomPrompt(String customPrompt) {
        CustomPrompt = customPrompt;
    }

    public String getCustomPrompt(){
        return CustomPrompt;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTripDuration() {
        return tripDuration;
    }

    public void setTripDuration(String tripDuration) {
        this.tripDuration = tripDuration;
    }

    public String getTravelStyle() {
        return travelStyle;
    }

    public void setTravelStyle(String travelStyle) {
        this.travelStyle = travelStyle;
    }

}
