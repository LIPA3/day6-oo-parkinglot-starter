package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingBoyTest {
    @Test
    public void should_given_a_car_return_parking_ticket_when_park_the_car() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car("park num 1");

        Ticket ticket = parkingBoy.park(car);

        assertNotNull(ticket);
    }

    @Test
    public void should_given_a_ticket_return_park_car_when_fetch_the_car() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car("park num 1");
        Ticket ticket = parkingBoy.park(car);

        Car fetchedCar = parkingBoy.fetch(ticket);

        assertEquals(car, fetchedCar);
    }

    @Test
    public void should_given_no_position_parking_lot_return_error_message__when_no_position() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.park(new Car("park num 1"));

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> parkingBoy.park(new Car("park num 2"))
        );
        assertEquals("no available position.", exception.getMessage());
    }

    @Test
    public void should_given_unrecognized_ticket_return_error_message_when_ticket_invalid() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> parkingBoy.fetch(new Ticket(null, 1, parkingLot))
        );
        assertEquals("Unrecognized parking ticket.", exception.getMessage());
    }
}
