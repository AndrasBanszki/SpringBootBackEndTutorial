package my.bella.airlines.api.model.pojos;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class PassangerToFlight {

    private final long id;
    private final long flightId;
    private final long passangerId;

    private PassangerToFlight(Builder b) {
        this.id = b.id;
        this.flightId = b.flightId;
        this.passangerId = b.passangerId;
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

    public static class Builder {

        //initialize with the id!
        private final long id;
        //dont forget to set these also!
        private long flightId = 0;
        private long passangerId = 0;

        public Builder(long id) {
            this.id = id;
        }

        public Builder flightId(long flightId) {
            this.flightId = flightId;
            return this;
        }

        public Builder passangerId(long passangerId) {
            this.passangerId = passangerId;
            return this;
        }

        public PassangerToFlight build() {
            return new PassangerToFlight(this);
        }
    }
}
