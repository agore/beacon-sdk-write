package com.gannett.npd.beaconsdk.model;

import java.sql.*;
import java.util.List;

public class BeaconEventDao {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beacon", "aditya", "");
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public long setBeaconEvents(List<BeaconEvent> events) {
        Connection con = getConnection();
        if (con == null) return 0;

        try (PreparedStatement ps = con.prepareStatement(
                "insert into beacon.event (`b_id_1`, `b_id_2`, `b_id_3`, `event`, `ts`, `d_id`) values (?, ?, ?, ?, ?, ?)")) {
            for (BeaconEvent be: events) {
                ps.setString(1, be.getBeaconId1());
                ps.setInt(2, be.getBeaconId2());
                ps.setInt(3, be.getBeaconId3());
                ps.setString(4, be.getEvent());
                Timestamp t = new Timestamp(be.getTs().getTime());

                ps.setTimestamp(5, t);
                ps.setString(6, be.getDeviceId());
                System.out.println(ps);
                ps.addBatch();
            }

            ps.executeBatch();
            long count = -1;
            try (ResultSet rs1 = ps.getGeneratedKeys()) {
                if (rs1.last()) {
                    count = rs1.getLong(1);
                }
            } catch (SQLException sqle) {
                //
            }
            return count;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1; //shouldn't get here.
    }

    public long setBeaconEvent(BeaconEvent beaconEvent) {
        Connection con = getConnection();
        if (con == null) return 0;

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into beacon.event (`b_id_1`, `b_id_2`, `b_id_3`, `event`, `ts`, `d_id`) values (?, ?, ?, ?, ?, ?)");
            ps.setString(1, beaconEvent.getBeaconId1());
            ps.setInt(2, beaconEvent.getBeaconId2());
            ps.setInt(3, beaconEvent.getBeaconId3());
            ps.setString(4, beaconEvent.getEvent());
            Date d = new Date(beaconEvent.getTs().getTime());
            ps.setDate(5, d);
            ps.setString(6, beaconEvent.getDeviceId());

            long count = 0;
            ResultSet rs1 = ps.getGeneratedKeys();
            if (rs1.last()) {
                count = rs1.getLong(1);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (ps != null) ps.close();}catch(Exception e) {}
            try { if (con != null) con.close();}catch(Exception e) {}
        }

        return 0;
    }
}
