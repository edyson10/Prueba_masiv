package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Elevator;
import com.example.demo.Entity.ElevatorRequest;

@RestController
public class ElevatorController {

	private Elevator elevator = new Elevator();

    @GetMapping("/status")
    public Elevator getElevatorStatus() {
        return elevator;
    }
    
    @PostMapping("/move")
    public void moveElevator(@RequestBody ElevatorRequest request) throws InterruptedException {
        int requestedFloor = request.getFloor();
        if (requestedFloor < 1 || requestedFloor > 10) {
            throw new IllegalArgumentException("Floor number out of range");
        }
        if (requestedFloor == elevator.getCurrentFloor()) {
            return;
        }
        elevator.getPendingFloors().add(requestedFloor);
        while (!elevator.getPendingFloors().isEmpty()) {
            int nextFloor = elevator.getPendingFloors().get(0);
            elevator.setCurrentFloor(nextFloor);
            elevator.getPendingFloors().remove(0);
            Thread.sleep(1000);
        }
    }
    
    @PostMapping("/call")
    public void callElevator(@RequestBody ElevatorRequest request) {
        int requestedFloor = request.getFloor();
        if (requestedFloor < 1 || requestedFloor > 10) {
            throw new IllegalArgumentException("Floor number out of range");
        }
        elevator.getPendingFloors().add(requestedFloor);
    }

}

