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
            LOG.log(Level.INFO, "Exception happened during authentication Ex: {0}", ex.getMessage());
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
            LOG.log(Level.INFO, "Exception happaned during authentication Ex: {0}", ex.getMessage());
        }
        LOG.log(Level.INFO, "Result of get All flights: {0}", flights);

        return flights;
    }

    @Override
    public Plane getPlaneDate(long flightId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
