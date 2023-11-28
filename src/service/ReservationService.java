package service;

import model.Customer;
import model.IRoom;
import model.Reservation;

import java.util.*;

public class ReservationService {

    Collection<Reservation> allReservations = new ArrayList<Reservation>();
    Collection<IRoom> allRooms = new ArrayList<IRoom>();
    public void addRoom(IRoom room) {
        allRooms.add(room);
    }

    public IRoom getARoom(String roomId) {
        for (IRoom room : allRooms) {
            if (room.getRoomNumber().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation res = new Reservation(customer, room, checkInDate, checkOutDate);
        allReservations.add(res);
        return res;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> qualifiedRooms = new ArrayList<>();
        for (IRoom room : allRooms) {
            for (Reservation reservation : allReservations) {
                // if it has never been reserved:
                if (!reservation.room.equals(room)) {
                    qualifiedRooms.add(room);
                } else {
                    // if within the date range:
                    if (reservation.checkInDate.after(checkOutDate) || reservation.checkOutDate.before(checkInDate)) {
                        qualifiedRooms.add(room);
                    } else {
                        // check if there is availability for the next week window:
                        Calendar c1 = Calendar.getInstance();
                        Calendar c2 = Calendar.getInstance();
                        c1.setTime(checkInDate);
                        c2.setTime(checkOutDate);
                        c1.add(Calendar.DATE, 7);
                        c2.add(Calendar.DATE, 7);
                        return findRooms(c1.getTime(), c2.getTime());
                    }
                }
            }
        }
        return qualifiedRooms;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer) {
        Collection<Reservation> resForThisCustomer = new ArrayList<>();
        for (Reservation reservation : allReservations) {
            if (reservation.customer.equals(customer)) {
                resForThisCustomer.add(reservation);
            }
        }
        return resForThisCustomer;
    }

    public void printAllReservation() {
        System.out.println(allReservations);
    }
}
