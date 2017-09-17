package my.bella.airlines.jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import my.bella.airlines.api.model.domain.Flight;
import my.bella.airlines.api.model.domain.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
@Repository
public class FlightRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParamJdbcTemplate;

    public long getPassangersNumber(long flightId) {

        long passangersNo;
        String query = "SELECT count(*) FROM bella_airline.passanger_to_flight WHERE flight_id = :flightId;";

        Map namedParameters = new HashMap();
        namedParameters.put("flightId", flightId);

        passangersNo = namedParamJdbcTemplate.queryForObject(query, namedParameters, long.class);

        return passangersNo;
    }

    public List<Flight> getAllFlightForPassanger(long passangerId) {

        List<Flight> flights;
        String query = "SELECT 	flights.id AS id, \n"
                     + "		flights.date_of_departure AS date_of_departure,\n"
                     + "        flights.date_of_arrival AS date_of_arrival,\n"
                     + "        flights.departure_airport_id AS departure_airport_id,\n"
                     + "        flights.arrival_airport_id AS arrival_airport_id,\n"
                     + "        flights.plane_id AS plane_id\n"
                     + "FROM bella_airline.flights, bella_airline.passanger_to_flight\n"
                     + "WHERE flights.id = passanger_to_flight.flight_id \n"
                     + "AND passanger_to_flight.passanger_id = :passangerId;";

        Map namedParameters = new HashMap();
        namedParameters.put("passangerId", passangerId);

        flights = namedParamJdbcTemplate.query(query, namedParameters, new FlightRowMapper());

        return flights;
    }

    public Plane getPlaneData(long flightId) {

        Plane plane;
        String query = "SELECT p.id AS id,\n"
                     + "        p.max_speed AS max_speed,\n"
                     + "        p.number_of_staff AS number_of_staff,\n"
                     + "        p.number_of_passanger AS number_of_passanger,\n"
                     + "        p.max_cargo_weight AS max_cargo_weight,\n"
                     + "        p.plane_weight AS plane_weight\n"
                     + "FROM bella_airline.flights f, bella_airline.planes p \n"
                     + "WHERE f.plane_id = p.id\n"
                     + "AND f.id = :flightId;";
        
        Map namedParameters = new HashMap();
        namedParameters.put("flightId", flightId);
        
        RowMapper<Plane> planeRowMapper = (rs, rowNum) -> { 
            Plane p = new Plane(rs.getLong("id"),
                                rs.getInt("max_speed"),
                                rs.getInt("number_of_staff"),
                                rs.getInt("number_of_passanger"),
                                rs.getInt("max_cargo_weight"),
                                rs.getInt("plane_weight"));
            return p;
        };

        plane = namedParamJdbcTemplate.queryForObject(query, namedParameters, planeRowMapper);

        return plane;
    }

}
