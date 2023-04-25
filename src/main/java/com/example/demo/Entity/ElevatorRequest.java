package com.example.demo.Entity;

import jakarta.persistence.Entity;

@Entity
public class ElevatorRequest {
	
	private int floor;

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

}
