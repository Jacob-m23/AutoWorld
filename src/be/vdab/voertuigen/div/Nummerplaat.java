package be.vdab.voertuigen.div;

import java.io.Serializable;
import java.util.Objects;

public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
    private final String plaat;

    public Nummerplaat(String plaat) {
        this.plaat = plaat;
    }

    public String getPlaat() {
        return plaat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nummerplaat that = (Nummerplaat) o;
        return Objects.equals(plaat, that.plaat);
    }

    @Override
    public int hashCode() {
        return this.plaat.hashCode();
    }

    @Override
    public String toString() {
        return plaat;
    }

    @Override
    public int compareTo(Nummerplaat o) {
        return this.plaat.compareTo(o.plaat);
    }
}
