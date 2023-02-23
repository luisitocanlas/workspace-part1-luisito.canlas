package com.transportation;

class Boat extends Vehicle {
    // INSTANCE VARIABLES

    // CONSTRUCTORS
    public Boat(String vin) {
        super(vin);
    }

    // BUSINESS METHODS
    @Override
    public void moveTo(String location) {
        System.out.println("Boat moving to " + location);
    }

    // ACCESSOR METHODS

    // toString()

}