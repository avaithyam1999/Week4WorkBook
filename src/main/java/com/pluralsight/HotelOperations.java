package com.pluralsight;

public class HotelOperations {
    public static void main(String[] args) {
        Reservation reservation1 = new Reservation("king", 3, true);
        System.out.println(reservation1.getReservationTotal());

        Employee employee1 = new Employee(111,"Jitty","Management", 100.95, 50);
        System.out.println(employee1.getOvertimeHours());
        employee1.punchIn();


        Room room1 = new Room(2, 150.00, false, false, true);
        room1.checkIn();
        room1.checkOut();
    }
}
