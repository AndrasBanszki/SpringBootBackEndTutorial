package my.bella.airlines.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import my.bella.airlines.api.model.pojos.Flight;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class FlightRowMapper implements RowMapper<Flight> {

    @Override
    public Flight mapRow(ResultSet rs, int i) throws SQLException {

        Flight f = new Flight.Builder(rs.getLong("id"))
                .departureDate(rs.getDate("date_of_departure"))
                .arrivalDate(rs.getDate("date_of_departure"))
                .departureAirport(rs.getLong("departure_airport_id"))
                .departureAirport(rs.getLong("departure_airport_id"))
                .planeId(rs.getLong("plane_id"))
                .build();
        return f;
    }

}
