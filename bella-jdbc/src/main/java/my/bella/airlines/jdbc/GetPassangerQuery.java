package my.bella.airlines.jdbc;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
@Repository
public class GetPassangerQuery {

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

}
