package be.vdab;

import be.vdab.schoolgerief.Boekentas;
import be.vdab.util.Laadbaar;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {
    private static TreeSet<Voertuig> voertuigen = new TreeSet<>();
    private static final List<Boekentas> boekentassen = new ArrayList<>();
    private static final Path path = Path.of("src/be/vdab/wagenpark.dat");

    public static void main(String[] args) {
//        voegVoertuigenToe();
//        toonVoertuigen();
//        schrijfVoertuigen();

//        leesVoertuigen();
//        toonVoertuigen();

//        voegBoekentassenToe();
//        toonBoekentassen();

        toonLaadbaarObjecten();
    }

    private static void voegVoertuigenToe() {
        voertuigen.add(new Personenwagen("Audi", 50000, 5));
        voertuigen.add(new Personenwagen("BMW", 60000, 5));
        voertuigen.add(new Pickup("Ford", 70000, 5, new Volume(200, 100, 50, Maat.CENTIMETER)));
        voertuigen.add(new Pickup("VW", 80000, 5, new Volume(250, 120, 50, Maat.CENTIMETER)));
        voertuigen.add(new Vrachtwagen("Scania", 90000, new Volume(1000, 250, 300, Maat.CENTIMETER), 10000, 3));
        voertuigen.add(new Vrachtwagen("Volvo", 150000, new Volume(1200, 300, 350, Maat.CENTIMETER), 12000, 4));
    }

    private static void toonVoertuigen() {
        voertuigen.forEach(System.out::println);
    }

    private static void schrijfVoertuigen() {
        try (var stream = new ObjectOutputStream(Files.newOutputStream(path))) {
            stream.writeObject(voertuigen);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    private static void leesVoertuigen() {
        try (var stream = new ObjectInputStream(Files.newInputStream(path))) {
            voertuigen = (TreeSet<Voertuig>) stream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
        }
    }

    private static void voegBoekentassenToe() {
        boekentassen.add(new Boekentas(new Volume(20, 30, 10, Maat.CENTIMETER), "rood"));
        boekentassen.add(new Boekentas(new Volume(25, 35, 15, Maat.CENTIMETER), "groen"));
        boekentassen.add(new Boekentas(new Volume(30, 40, 20, Maat.CENTIMETER), "blauw"));
        boekentassen.add(new Boekentas(new Volume(35, 45, 25, Maat.CENTIMETER), "geel"));
    }

    private static void toonBoekentassen() {
        boekentassen.forEach(System.out::println);
    }

    private static void toonLaadbaarObjecten() {
        var laadbaar = new ArrayList<Laadbaar>();
        laadbaar.add(new Pickup("Ford", 70000, 5, new Volume(200, 100, 50, Maat.CENTIMETER)));
        laadbaar.add(new Vrachtwagen("Scania", 90000, new Volume(1000, 250, 300, Maat.CENTIMETER), 10000, 3));
        laadbaar.add(new Boekentas(new Volume(20, 30, 10, Maat.CENTIMETER), "rood"));

        laadbaar.forEach(System.out::println);
        System.out.println(
                laadbaar.stream().mapToDouble(l -> l.getLaadvolume().getVolume()).sum() + " cm³"
        );
    }
}
