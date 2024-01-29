package be.vdab.voertuigen;

import be.vdab.voertuigen.div.Div;
import be.vdab.voertuigen.div.Nummerplaat;

import java.io.Serializable;
import java.util.Objects;

public class Voertuig implements Comparable<Voertuig>, Serializable {
    private static final long serialVersionUID = 1L;
    private final Nummerplaat nummerplaat = Div.INSTANCE.getNummerplaat();
    private String merk;
    private int aankoopprijs;

    public Voertuig(String merk, int aankoopprijs) {
        setMerk(merk);
        setAankoopprijs(aankoopprijs);
    }

    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        Objects.requireNonNull(merk);
        this.merk = merk;
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    public void setAankoopprijs(int aankoopprijs) {
        if (aankoopprijs < 0) {
            throw new IllegalArgumentException("Aankoopprijs moet positief zijn");
        }
        this.aankoopprijs = aankoopprijs;
    }

    @Override
    public int compareTo(Voertuig o) {
        return this.nummerplaat.compareTo(o.nummerplaat);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voertuig voertuig = (Voertuig) o;
        return nummerplaat.equals(voertuig.nummerplaat);
    }

    @Override
    public int hashCode() {
        return nummerplaat.hashCode();
    }

    @Override
    public String toString() {
        return nummerplaat + "," + merk + "," + aankoopprijs;
    }
}
