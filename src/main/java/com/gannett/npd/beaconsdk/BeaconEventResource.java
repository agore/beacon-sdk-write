package com.gannett.npd.beaconsdk;

import com.gannett.npd.beaconsdk.model.BeaconEvent;
import com.gannett.npd.beaconsdk.model.BeaconEventDao;
import com.gannett.npd.beaconsdk.model.BeaconEvents;
import com.gannett.npd.beaconsdk.model.Result;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

import static java.net.URI.create;

@Path("beacon")
public class BeaconEventResource {
//    @GET
//    @Path("/counts")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Result getVisits() {
//        BeaconEventDao dao = new BeaconEventDao();
//        return dao.getCounts();
//    }

    /*
    @POST
    @Path("/event")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response setBeaconEvent(InputStream is) {
        try {
            BeaconEvent event = new ObjectMapper().readValue(is, BeaconEvent.class);
            long id = new BeaconEventDao().setBeaconEvent(event);
            return Response.created(create("/id/" + id)).build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.serverError().build();
    }
    */

    @POST
    @Path("/events")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response setBeaconEvents(InputStream is) {
        try {
            BeaconEvents events = new ObjectMapper().readValue(is, BeaconEvents.class);
            long id = new BeaconEventDao().setBeaconEvents(events.getBeaconEventList());
            return Response.created(create("/id/" + id)).build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Response.serverError().build();
    }

}
