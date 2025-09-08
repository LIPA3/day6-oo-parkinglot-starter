package com.afs.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ParkingLot {
    private Integer capacity;
    private static final Integer CAPACITY = 10;
    private Map<Ticket, Car> ticketCars = new HashMap<>();

    public ParkingLot() {
        this.capacity = CAPACITY;
    }

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        return IntStream.rangeClosed(1, capacity).boxed()
                .filter(position -> ticketCars.keySet().stream().noneMatch(ticket -> ticket.position() == position))
                .findFirst()
                .map(position -> {
                    Ticket ticket = new Ticket(car, position, this);
                    ticketCars.put(ticket, car);
                    return ticket;
                })
                .orElse(null);
    }

    public Car fetch(Ticket ticketResult) {
        return ticketCars.remove(ticketResult);
    }
}
