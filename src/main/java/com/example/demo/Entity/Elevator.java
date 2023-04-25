package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Elevator {
	
	private int currentFloor;
    private List<Integer> pendingFloors = new ArrayList<>();

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public List<Integer> getPendingFloors() {
        return pendingFloors;
    }

    public void setPendingFloors(List<Integer> pendingFloors) {
        this.pendingFloors = pendingFloors;
    }
}

