package com.gannett.npd.beaconsdk.model;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

public class BeaconEvents {
    List<BeaconEvent> beaconEventList;

    public List<BeaconEvent> getBeaconEventList() {
        return beaconEventList;
    }

    @JsonProperty("events")
    public void setBeaconEventList(List<BeaconEvent> beaconEventList) {
        this.beaconEventList = beaconEventList;
    }
}
