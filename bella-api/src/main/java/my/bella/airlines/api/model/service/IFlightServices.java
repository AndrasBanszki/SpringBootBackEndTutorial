package my.bella.airlines.api.model.service;

import java.util.List;
import my.bella.airlines.api.model.domain.Flight;
import my.bella.airlines.api.model.domain.Plane;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
public interface IFlightServices {

    /* 1. Get passanger number for a specified flight.
        key(s): 
		- flight id
	response should have:
		- number of passanger
     */
    public long getNumberOfPassangers(long flightId);

    /* 2. Get all flight for a passanger.
	key(s): 
		- passanger id
	response should have:
		- list of the following objects (flight id, date_of_departure, date_of_arrival, departure_airport_id, arrival_airport_id)
     */
    public List<Flight> getAllFlight(long passangerId);

    /* 3. Get data of a plane for a specified flight.
	key(s):
		- flight id
	response should have:
		- max_speed, number_of_staff, number_of_passanger, max_cargo_weight, plane_weight
     */
    public Plane getPlaneData(long flightId);

}
