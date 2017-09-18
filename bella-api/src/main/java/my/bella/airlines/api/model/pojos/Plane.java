package my.bella.airlines.api.model.pojos;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class Plane {

    private final long id;
    private final int maxSpeed;
    private final int numberOfStaff;
    private final int numberOfPassanger;
    private final int maxCargoWeight;
    private final int planeWeight;

    private Plane(Builder b) {
        this.id = b.id;
        this.maxSpeed = b.maxSpeed;
        this.numberOfStaff = b.numberOfStaff;
        this.numberOfPassanger = b.numberOfPassanger;
        this.maxCargoWeight = b.maxCargoWeight;
        this.planeWeight = b.planeWeight;
    }

    public long getId() {
        return id;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public int getNumberOfPassanger() {
        return numberOfPassanger;
    }

    public int getMaxCargoWeight() {
        return maxCargoWeight;
    }

    public int getPlaneWeight() {
        return planeWeight;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + this.maxSpeed;
        hash = 59 * hash + this.numberOfStaff;
        hash = 59 * hash + this.numberOfPassanger;
        hash = 59 * hash + this.maxCargoWeight;
        hash = 59 * hash + this.planeWeight;
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
        final Plane other = (Plane) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.maxSpeed != other.maxSpeed) {
            return false;
        }
        if (this.numberOfStaff != other.numberOfStaff) {
            return false;
        }
        if (this.numberOfPassanger != other.numberOfPassanger) {
            return false;
        }
        if (this.maxCargoWeight != other.maxCargoWeight) {
            return false;
        }
        if (this.planeWeight != other.planeWeight) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plane{" + "id=" + id + ", maxSpeed=" + maxSpeed + ", numberOfStaff=" + numberOfStaff + ", numberOfPassanger=" + numberOfPassanger + ", maxCargoWeight=" + maxCargoWeight + ", planeWeight=" + planeWeight + '}';
    }

    public static class Builder {

        // initialize builder with the id!
        private final long id;
        // dont forget to set these also!
        private int maxSpeed;
        private int numberOfStaff;
        private int numberOfPassanger;
        private int maxCargoWeight;
        private int planeWeight;

        public Builder(long id) {
            this.id = id;
        }

        public Builder maxSpeed(int n) {
            this.maxSpeed = n;
            return this;
        }

        public Builder numberOfStaff(int n) {
            this.numberOfStaff = n;
            return this;
        }

        public Builder numberOfPassanger(int n) {
            this.numberOfPassanger = n;
            return this;
        }

        public Builder maxCargoWeight(int n) {
            this.maxCargoWeight = n;
            return this;

        }

        public Builder planeWeight(int n) {
            this.planeWeight = n;
            return this;
        }

        public Plane build() {
            return new Plane(this);
        }

    }
}
