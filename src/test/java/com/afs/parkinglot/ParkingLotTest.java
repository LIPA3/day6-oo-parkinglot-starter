package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    public void should_given_parking_lot_and_a_car_return_parking_ticket_when_park_the_car() {
        ParkingLot parkingLot = new ParkingLot();
        String carId = "park num 1";
        Car car = new Car(carId);
        Ticket ticket = new Ticket(car,1,parkingLot);
        Ticket ticketResult = parkingLot.park(car);

        assertEquals(ticket,ticketResult);
    }
    @Test
    public void should_given_parking_lot_and_a_ticket_return_park_car_when_fetch_the_car(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("park num 1");
        Ticket ticketResult = parkingLot.park(car);

        Car carResult = parkingLot.fetch(ticketResult);

        assertEquals(car, carResult);
    }
    @Test
    public void should_given_parking_lot_with_two_parked_cars_and_two_tickets_return_right_car_with_each_tickets_when_fetch_the_car_twice(){
        ParkingLot parkingLot = new ParkingLot();
        Car car1 = new Car("park num 1");
        Car car2 = new Car("park num 2");
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        Car fetchedCar1 = parkingLot.fetch(ticket1);
        Car fetchedCar2 = parkingLot.fetch(ticket2);

        assertEquals(car1, fetchedCar1);
        assertEquals(car2, fetchedCar2);
    }
    @Test
    public void should_given_parking_lot_and_a_wrong_ticket_return_nothing_when_fetch_the_car(){
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("park num 1");
        parkingLot.park(car);
        Ticket wrongTicket = parkingLot.park(null);

        Car fetchedCar = parkingLot.fetch(wrongTicket);

        assertEquals(null, fetchedCar);
    }
    @Test
    public void should_given_parking_lot_and_a_used_ticket_return_nothing_when_fetch_the_car(){
        ParkingLot parkingLot = new ParkingLot();

        Car car = new Car("park num 1");
        Ticket ticket = parkingLot.park(car);
        parkingLot.fetch(ticket);

        Car fetchedCar = parkingLot.fetch(ticket);

        assertEquals(null, fetchedCar);
    }
    @Test
    public void should_given_parking_lot_without_any_position_and_a_car_return_nothing_when_park_the_car(){
        ParkingLot parkingLot = new ParkingLot(1);
        Car car1 = new Car("park num 1");
        Car car2 = new Car("park num 2");
        parkingLot.park(car1);

        Ticket ticketResult = parkingLot.park(car2);

        assertEquals(null, ticketResult);
    }
}
