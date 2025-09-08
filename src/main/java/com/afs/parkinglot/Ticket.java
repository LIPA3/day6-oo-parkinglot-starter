// Ticket.java
package com.afs.parkinglot;

public class Ticket {
    private final Car car;
    private final Integer position;
    private final ParkingLot parkingLot;

    public Ticket(Car car, Integer position, ParkingLot parkingLot) {
        this.car = car;
        this.position = position;
        this.parkingLot = parkingLot;
    }

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Ticket)) return false;
        Ticket ticket = (Ticket) obj;
        return position == ticket.position && parkingLot.equals(ticket.parkingLot);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(position, parkingLot);
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
