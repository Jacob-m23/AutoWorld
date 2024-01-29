package be.vdab.util;

public enum Maat {
    METER(1), CENTIMETER(0.01), DECIMETER(0.1);
    private final double tovMeter;

    Maat(double tovMeter) {
        this.tovMeter = tovMeter;
    }

    public double getTovMeter() {
        return tovMeter;
    }
}
