package my.bella.airlines.springboot;

import java.util.List;
import my.bella.airlines.api.model.domain.Flight;
import my.bella.airlines.api.service.FlightServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
@RestController
public class FlightController {

    @Autowired
    private FlightServices flightServices;

    @RequestMapping(path = "/flight/passangersno", method = RequestMethod.POST, produces = "application/json")
    public long getNumberOfPassangers(@RequestParam("flightId") long flightId) {
        return this.flightServices.getNumberOfPassangers(flightId);
    }
    @RequestMapping(path = "/flight/flightsofpass", method = RequestMethod.POST, produces = "application/json")
    public List<Flight> getAllFlightsforPassanger(@RequestParam("passangerId") long passangerId){
        return this.flightServices.getAllFlight(passangerId);
    }
    
}
