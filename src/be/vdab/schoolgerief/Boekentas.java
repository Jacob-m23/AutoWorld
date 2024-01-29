package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.io.Serializable;
import java.util.Objects;

public class Boekentas implements Laadbaar, Serializable {
    private Volume laadvolume;
    private String kleur;

    public Boekentas(Volume laadvolume, String kleur) {
        setLaadvolume(laadvolume);
        setKleur(kleur);
    }

    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume volume) {
        if (volume.getVolume() > 0.0) {
            this.laadvolume = volume;
        } else {
            throw new IllegalArgumentException("Laadvolume moet positief zijn");
        }
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        Objects.requireNonNull(kleur);
        if (kleur.isBlank() || kleur.isEmpty()) {
            throw new IllegalArgumentException("Kleur mag niet leeg zijn");
        } else {
            this.kleur = kleur;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boekentas boekentas = (Boekentas) o;
        return laadvolume.equals(boekentas.laadvolume) && kleur.equals(boekentas.kleur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laadvolume, kleur);
    }

    @Override
    public String toString() {
        return laadvolume + "," + kleur;
    }
}
