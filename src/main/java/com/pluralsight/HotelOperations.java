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

        Hotel grandBudapestHotel = new Hotel("Grand Budapest Hotel", 15, 100);
        System.out.println(grandBudapestHotel);


        if (grandBudapestHotel.bookRoom(5, false)) {
            System.out.println(grandBudapestHotel);
        }else{
            System.out.println("Go home!");
        }


        if (grandBudapestHotel.bookRoom(10, true)) {
            System.out.println(grandBudapestHotel);
        }else{
            System.out.println("Go home snob!");
        }


    }
}
