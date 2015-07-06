package com.gannett.npd.beaconsdk.model;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@JsonIgnoreProperties(ignoreUnknown =  true)
public class BeaconEvent {
    private String deviceId;
    private String beaconId1;
    private int beaconId2;
    private int beaconId3;
    private float range;
    private Date ts;
    private String event;

    @JsonCreator
    public BeaconEvent(@JsonProperty("b_id_1") String beaconId1, @JsonProperty("b_id_2") int beaconId2,
                       @JsonProperty("b_id_3") int beaconId3, @JsonProperty("event") String event,
                       @JsonProperty("ts") String timestamp, @JsonProperty("id") String deviceId) {
        this.beaconId1 = beaconId1;
        this.beaconId2 = beaconId2;
        this.beaconId3 = beaconId3;
        this.event = event;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC")); //always store in UTC

        try {
            this.ts = sdf.parse(timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.deviceId = deviceId;
    }

    public String getBeaconId1() {
        return beaconId1;
    }

//    @JsonProperty("b_id_1")
//    public void setBeaconId1(String beaconId1) {
//        this.beaconId1 = beaconId1;
//    }

    public int getBeaconId2() {
        return beaconId2;
    }

//    @JsonProperty("b_id_2")
//    public void setBeaconId2(int beaconId2) {
//        this.beaconId2 = beaconId2;
//    }

    public int getBeaconId3() {
        return beaconId3;
    }

//    @JsonProperty("b_id_3")
//    public void setBeaconId3(int beaconId3) {
//        this.beaconId3 = beaconId3;
//    }

    public String getDeviceId() {
        return deviceId;
    }

//    @JsonProperty("id")
//    public void setDeviceId(String deviceId) {
//        this.deviceId = deviceId;
//    }

    public Date getTs() {
        return ts;
    }

//    @JsonProperty("ts")
//    public void setTs(Date ts) {
//        this.ts = ts;
//    }

    public String getEvent() {
        return event;
    }

//    @JsonProperty("event")
//    public void setEvent(String event) {
//        this.event = event;
//    }

    @Override
    public String toString() {
        return beaconId1 + ":" + beaconId2 + ":" + beaconId3 + ":" + event + ":" + ts + ":[" + deviceId + "]";
    }
}
