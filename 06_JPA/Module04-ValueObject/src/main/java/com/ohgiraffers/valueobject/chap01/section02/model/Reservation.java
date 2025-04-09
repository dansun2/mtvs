package com.ohgiraffers.valueobject.chap01.section02.model;

import com.ohgiraffers.valueobject.chap01.section02.model.vo.GuestCount;
import com.ohgiraffers.valueobject.chap01.section02.model.vo.StayPeriod;
import jakarta.persistence.*;

@Entity
@Table(name = "hotel_reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String guestName;
    private String roomNumber;

    @Embedded
    private GuestCount numberOfGuests;

    @Embedded
    private StayPeriod stayPeriod;

    private int roomRate;

    protected Reservation() {
    }

    public Reservation(String guestName, String roomNumber, GuestCount numberOfGuests, StayPeriod stayPeriod, int roomRate) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.numberOfGuests = numberOfGuests;
        this.stayPeriod = stayPeriod;
        this.roomRate = roomRate;
    }

    public int calculateTotalPrice() {
        return stayPeriod.getNights() * roomRate;
    }

    public Long getId() {
        return id;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public GuestCount getNumberOfGuests() {
        return numberOfGuests;
    }

    public StayPeriod getStayPeriod() {
        return stayPeriod;
    }

    public int getRoomRate() {
        return roomRate;
    }
}
