package my.bella.airlines.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import my.bella.airlines.api.model.domain.Flight;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public class FlightRowMapper implements RowMapper<Flight> {

    @Override
    public Flight mapRow(ResultSet rs, int i) throws SQLException {

        Flight f = new Flight(  rs.getLong("id"),
                                rs.getDate("date_of_departure").toLocalDate(),
                                rs.getDate("date_of_arrival").toLocalDate(),
                                rs.getLong("departure_airport_id"),
                                rs.getLong("arrival_airport_id"),
                                rs.getLong("plane_id"));
        return f;
    }

}
