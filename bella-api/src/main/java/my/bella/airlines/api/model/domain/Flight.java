package my.bella.airlines.api.model.domain;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class Flight {

    private final long id;
    private final Date dateOfDeparture;
    private final Date dateOfArrival;
    private final long departureAirport_id;
    private final long arrivalAirport_id;
    private final long planeId;

    public Flight(long id, Date dateOfDeparture, Date dateOfArrival, long departureAirport_id, long arrivalAirport_id, long planeId) {
        this.id = id;
        this.dateOfDeparture = dateOfDeparture;
        this.dateOfArrival = dateOfArrival;
        this.departureAirport_id = departureAirport_id;
        this.arrivalAirport_id = arrivalAirport_id;
        this.planeId = planeId;
    }

    public long getId() {
        return id;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public Date getDateOfArrival() {
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

    
    
}
