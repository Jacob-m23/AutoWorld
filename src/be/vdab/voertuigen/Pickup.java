package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

import java.util.Objects;

public class Pickup extends Personenwagen implements Laadbaar {
    private Volume laadvolume;
    public Pickup(String merk, int aankoopprijs, int zitplaatsen, Volume laadvolume) {
        super(merk, aankoopprijs, zitplaatsen);
        setLaadvolume(laadvolume);
    }

    public Volume getLaadvolume() {
        return laadvolume;
    }

    public void setLaadvolume(Volume laadvolume) {
        Objects.requireNonNull(laadvolume);
        this.laadvolume = laadvolume;
    }

    @Override
    public String toString() {
        return super.toString() + "," + laadvolume;
    }
}
