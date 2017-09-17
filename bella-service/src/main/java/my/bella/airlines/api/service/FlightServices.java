package my.bella.airlines.api.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.bella.airlines.api.model.domain.Flight;
import my.bella.airlines.api.model.domain.Plane;
import my.bella.airlines.api.model.service.IFlightServices;
import my.bella.airlines.jdbc.GetPassangerQuery;
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
    private GetPassangerQuery getPassangerQuery;

    @Override
    public long getNumberOfPassangers(long flightId) {
        long passangersNo = 0;
        LOG.log(Level.INFO, "Called get Number Of Passangers service with flightId: {0}.", flightId);
        try {
            passangersNo = this.getPassangerQuery.getPassangersNumber(flightId);
        } catch (Exception ex) {
            LOG.log(Level.INFO, "Exception happened during authentication Ex: {0}", ex.getMessage());
        }
        LOG.log(Level.INFO, "Result of get Number Of Passangers: {0}", passangersNo);
        return passangersNo;
    }

    @Override
    public List<Flight> getAllFlight(long passangerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Plane getPlaneDate(long flightId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
