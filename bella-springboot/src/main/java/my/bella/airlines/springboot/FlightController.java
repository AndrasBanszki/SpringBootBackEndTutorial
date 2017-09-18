package my.bella.airlines.springboot;

import java.util.List;
import my.bella.airlines.api.model.pojos.Flight;
import my.bella.airlines.api.model.pojos.Plane;
import my.bella.airlines.api.service.FlightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
@RestController
public class FlightController {

    @Autowired
    private FlightServices flightServices;
    
    @GetMapping(path = "/flight/{flightId}/passangersnumber", produces = "application/json")
    public long getNumberOfPassangers(@PathVariable long flightId) {

        return this.flightServices.getNumberOfPassangers(flightId);
    }
    
    @GetMapping(path = "/flight/{flightId}/planedata",  produces = "application/json")
    public Plane getPlaneData(@PathVariable long flightId) {

        return this.flightServices.getPlaneData(flightId);
    }
    
    @GetMapping(path = "/passanger/{passangerId}/allflights", produces = "application/json")
    public List<Flight> getAllFlightsforPassanger(@PathVariable long passangerId) {

        return this.flightServices.getAllFlight(passangerId);
    }

}
