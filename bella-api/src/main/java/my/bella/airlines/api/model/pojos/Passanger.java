package my.bella.airlines.api.model.pojos;

import java.util.Objects;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class Passanger {

    private final long id;
    private final String firstName;
    private final String lastName;

    private Passanger(Builder b) {
        this.id = b.id;
        this.firstName = b.firstName;
        this.lastName = b.lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 13 * hash + Objects.hashCode(this.firstName);
        hash = 13 * hash + Objects.hashCode(this.lastName);
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
        final Passanger other = (Passanger) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Passanger{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    public class Builder {

        //initialize with the id!
        private final long id;
        //dont forget to set these also!
        private String firstName;
        private String lastName;

        public Builder(long id) {
            this.id = id;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Passanger build() {
            return new Passanger(this);
        }
    }
}
