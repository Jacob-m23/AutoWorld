package be.vdab.util;

import java.io.Serializable;
import java.util.Objects;

public class Volume implements Comparable<Volume>, Serializable {
    private final int breedte;
    private final int hoogte;
    private final int diepte;
    private final Maat maat;

    public Volume(int breedte, int hoogte, int diepte, Maat maat) {
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.diepte = diepte;
        this.maat = maat;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public int getDiepte() {
        return diepte;
    }

    public Maat getMaat() {
        return maat;
    }

    public double getVolume() {
        return breedte * hoogte * diepte * maat.getTovMeter();
    }

    @Override
    public int compareTo(Volume o) {
        return Double.compare(this.getVolume(), o.getVolume());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volume volume = (Volume) o;
        return breedte == volume.breedte && hoogte == volume.hoogte && diepte == volume.diepte && maat == volume.maat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(breedte, hoogte, diepte, maat);
    }

    @Override
    public String toString() {
        return getVolume() + " " + maat;
    }
}
