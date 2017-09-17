package my.bella.airlines.api.model.domain;

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

    public Plane(long id, int maxSpeed, int numberOfStaff, int numberOfPassanger, int maxCargoWeight, int planeWeight) {
        this.id = id;
        this.maxSpeed = maxSpeed;
        this.numberOfStaff = numberOfStaff;
        this.numberOfPassanger = numberOfPassanger;
        this.maxCargoWeight = maxCargoWeight;
        this.planeWeight = planeWeight;
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
    
    

}
