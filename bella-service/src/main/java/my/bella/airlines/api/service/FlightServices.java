package my.bella.airlines.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.bella.airlines.api.model.domain.Flight;
import my.bella.airlines.api.model.domain.Plane;
import my.bella.airlines.api.model.service.IFlightServices;
import my.bella.airlines.jdbc.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
@Service
public class FlightServices implements IFlightServices {

    private static final Logger LOG = Logger.getLogger(FlightServices.class.getName());

    @Autowired
    private FlightRepository flightRepo;

    @Override
    public long getNumberOfPassangers(long flightId) {

        long passangersNo = 0;
        LOG.log(Level.INFO, "Called get Number Of Passangers service with flightId: {0}.", flightId);

        try {
            passangersNo = this.flightRepo.getPassangersNumber(flightId);
        } catch (Exception ex) {
            LOG.log(Level.WARNING, "Exception happened during getNumberOfPassangers Ex: {0}", ex.getMessage());
        }
        LOG.log(Level.INFO, "Result of get Number Of Passangers: {0}", passangersNo);

        return passangersNo;
    }

    @Override
    public List<Flight> getAllFlight(long passangerId) {

        List<Flight> flights = new ArrayList<>();
        LOG.log(Level.INFO, "Called get All Flights for Passanger service with passangerId: {0}.", passangerId);

        try {
            flights = this.flightRepo.getAllFlightForPassanger(passangerId);
        } catch (Exception ex) {
            LOG.log(Level.WARNING, "Exception happaned during getAllFlight Ex: {0}", ex.getMessage());
        }
        LOG.log(Level.INFO, "Result of get All flights: {0}", flights);

        return flights;
    }

    @Override
    public Plane getPlaneData(long flightId) {

        Plane plane = null;
        LOG.log(Level.INFO, "Called get Plane Data of Flight with flightId: {0}.", flightId);

        try {
            plane = this.flightRepo.getPlaneData(flightId);
        } catch (Exception ex) {
            LOG.log(Level.WARNING, "Exception happaned during getPlaneData() : {0}", ex);
        }
        LOG.log(Level.INFO, "Result of get Plane Data: {0}", plane);

        return plane;
    }

}
