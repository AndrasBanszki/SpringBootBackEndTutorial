package my.bella.airlines.api.model.domain;

import java.time.LocalDate;
import java.sql.Date;

import java.util.Objects;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class Flight {

    private final long id;
    private final LocalDate dateOfDeparture;
    private final LocalDate dateOfArrival;
    private final long departureAirport_id;
    private final long arrivalAirport_id;
    private final long planeId;

    private Flight(Builder b) {
        this.id = b.id;
        this.dateOfDeparture = b.dateOfDeparture;
        this.dateOfArrival = b.dateOfArrival;
        this.departureAirport_id = b.departureAirport_id;
        this.arrivalAirport_id = b.arrivalAirport_id;
        this.planeId = b.planeId;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public long getDepartureAirport_id() {
        return departureAirport_id;
    }

    public long getArrivalAirport_id() {
        return arrivalAirport_id;
    }

    public long getPlaneId() {
        return planeId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.dateOfDeparture);
        hash = 53 * hash + Objects.hashCode(this.dateOfArrival);
        hash = 53 * hash + (int) (this.departureAirport_id ^ (this.departureAirport_id >>> 32));
        hash = 53 * hash + (int) (this.arrivalAirport_id ^ (this.arrivalAirport_id >>> 32));
        hash = 53 * hash + (int) (this.planeId ^ (this.planeId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flight other = (Flight) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.departureAirport_id != other.departureAirport_id) {
            return false;
        }
        if (this.arrivalAirport_id != other.arrivalAirport_id) {
            return false;
        }
        if (this.planeId != other.planeId) {
            return false;
        }
        if (!Objects.equals(this.dateOfDeparture, other.dateOfDeparture)) {
            return false;
        }
        if (!Objects.equals(this.dateOfArrival, other.dateOfArrival)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", dateOfDeparture=" + dateOfDeparture + ", dateOfArrival=" + dateOfArrival + ", departureAirport_id=" + departureAirport_id + ", arrivalAirport_id=" + arrivalAirport_id + ", planeId=" + planeId + '}';
    }

    public static class Builder {

        private final long id;

        private LocalDate dateOfDeparture = LocalDate.now();
        private LocalDate dateOfArrival = LocalDate.now();
        private long departureAirport_id = 0l;
        private long arrivalAirport_id = 0;
        private long planeId = 0;

        public Builder(long id) {
            this.id = id;
        }

        public Builder departureDate(LocalDate departureDate) {
            this.dateOfDeparture = departureDate;
            return this;
        }
        public Builder departureDate(Date departureDate) {
            this.dateOfDeparture = departureDate.toLocalDate();
            return this;
        }

        public Builder arrivalDate(LocalDate arrivalDate) {
            this.dateOfArrival = arrivalDate;
            return this;
        }
        public Builder arrivalDate(Date arrivalDate) {
            this.dateOfArrival = arrivalDate.toLocalDate();
            return this;
        }
        
        public Builder departureAirport(long departureAirport){
            this.departureAirport_id = departureAirport;
            return this;
        }
        
        public Builder arrivalAirport(long arrivalAirport){
            this.arrivalAirport_id = arrivalAirport;
            return this;
        }
        public Builder planeId(long planeId){
            this.planeId = planeId;
            return this;
        }
        public Flight build(){
            return new Flight(this);
        }
    }

}
