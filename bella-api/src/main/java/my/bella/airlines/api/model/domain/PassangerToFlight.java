package my.bella.airlines.api.model.domain;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class PassangerToFlight {

    private final long id;
    private final long flightId;
    private final long passangerId;

    public PassangerToFlight(long id, long flightId, long passangerId) {
        this.id = id;
        this.flightId = flightId;
        this.passangerId = passangerId;
    }

    public long getId() {
        return id;
    }

    public long getFlightId() {
        return flightId;
    }

    public long getPassangerId() {
        return passangerId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + (int) (this.flightId ^ (this.flightId >>> 32));
        hash = 71 * hash + (int) (this.passangerId ^ (this.passangerId >>> 32));
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
        final PassangerToFlight other = (PassangerToFlight) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.flightId != other.flightId) {
            return false;
        }
        if (this.passangerId != other.passangerId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PassangerToFlight{" + "id=" + id + ", flightId=" + flightId + ", passangerId=" + passangerId + '}';
    }

}
