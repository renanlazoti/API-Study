package Entities;

public class Car {
    private String color, model, chassis;
    private int modelYear;

    public Car(String color, String model, String chassis, int modelYear) {
        this.color = color;
        this.model = model;
        this.chassis = chassis;
        this.modelYear = modelYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
}
