package org.open918.lib.domain;

/**
 * Created by Joel Haasnoot on 25/05/15.
 */
public class GenericTicketDetails {

    private String ticketTitle;

    private String validity;

    private String passengerName;

    private String outwardDeparture;
    private String outwardArrival;

    private String returnDeparture;
    private String returnArrival;

    private String travelClass;

    private String routeDetails;

    private String price;

    public boolean hasMinimalData() {
        return ticketTitle != null || validity != null || passengerName != null || price != null;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getRouteDetails() {
        return routeDetails;
    }

    public void setRouteDetails(String routeDetails) {
        this.routeDetails = routeDetails;
    }

    public String getOutwardDeparture() {
        return outwardDeparture;
    }

    public void setOutwardDeparture(String outwardDeparture) {
        this.outwardDeparture = outwardDeparture;
    }

    public String getOutwardArrival() {
        return outwardArrival;
    }

    public void setOutwardArrival(String outwardArrival) {
        this.outwardArrival = outwardArrival;
    }

    public String getReturnDeparture() {
        return returnDeparture;
    }

    public void setReturnDeparture(String returnDeparture) {
        this.returnDeparture = returnDeparture;
    }

    public String getReturnArrival() {
        return returnArrival;
    }

    public void setReturnArrival(String returnArrival) {
        this.returnArrival = returnArrival;
    }

    public String getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(String travelClass) {
        this.travelClass = travelClass;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
