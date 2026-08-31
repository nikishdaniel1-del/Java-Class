package Threads;

class Booking extends Thread {
    public void run() {
        System.out.println("Booking Starting...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("User Details Saved.\nRedirecting To Payment.");
    }
}

class Payment extends Thread {
    public void run() {
        System.out.println("Payment Starting...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Payment completed.\nRedirecting To Seat Allocation.");
    }
}

class SeatAllocation extends Thread {
    public void run() {
        System.out.println("SeatAllocation Starting...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Seat Allocated.");
    }
}

class TicketGeneration extends Thread {
    public void run() {
        System.out.println("Ticket Booking Starting...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Ticket Booked Successfully");
    }
}

public class RailwayReserveSystem {
    public static void main(String[] args) throws InterruptedException{
        Booking booking = new Booking();
        Payment payment = new Payment();
        SeatAllocation seatAllocation = new SeatAllocation();
        TicketGeneration ticketGeneration = new TicketGeneration();
        booking.start();
        booking.join();
        System.out.println("Before Execution Payment Thread : "+payment.isAlive());
        payment.start();
        System.out.println("During Execution Payment Thread : "+payment.isAlive());
        payment.join();
        System.out.println("After Execution Payment Thread : "+payment.isAlive());
        seatAllocation.start();
        seatAllocation.join();
        ticketGeneration.start();
        ticketGeneration.join();
        System.out.println("Reservation Completed.");
    }
}