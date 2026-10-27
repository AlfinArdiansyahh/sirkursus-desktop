package app;

import model.Orang;
import model.Peserta;
import model.Instruktur;
import model.Kursus;
import java.util.ArrayList;
import java.util.List;

public class DemoPolymorphism {

    public static void tampilkanInfo(Orang orang) {
        System.out.println(orang.getInfo());
    }

    public static void cetakSemua(List<Orang> daftar) {
        for (Orang o : daftar) {
            System.out.println(o.getInfo());
        }
    }

    public static void main(String[] args) {

        // Membuat objek Peserta
        Peserta peserta = new Peserta(
            1, "Ahmad Fauzan", "081234567801",
            "252001", "Informatika"
        );

        // Membuat objek Instruktur
        Instruktur instruktur = new Instruktur(
            2, "Dina Pratama", "081211110001",
            "Java Desktop"
        );

        // Menyimpan kedua objek dalam List<Orang>
        List<Orang> daftarOrang = new ArrayList<>();

        daftarOrang.add(peserta);
        daftarOrang.add(instruktur);

        // 1. Loop Polymorphism
        System.out.println("=== Loop Polymorphism ===");
        cetakSemua(daftarOrang);

        // 2. Polymorphic Argument
        System.out.println("\n=== Polymorphic Argument ===");
        tampilkanInfo(peserta);
        tampilkanInfo(instruktur);

        // 3. Instanceof dan Casting
        System.out.println("\n=== Instanceof ===");

        for (Orang o : daftarOrang) {
            if (o instanceof Peserta) {
                Peserta p = (Peserta) o;

                System.out.println(
                    "NIM khusus peserta: " + p.getNim()
                );
            }
        }

        // 4. Pengujian Validasi
        System.out.println("\n=== Uji Validasi ===");

        try {
            peserta.setNama("");
        } catch (IllegalArgumentException e) {
            System.out.println(
                "Validasi nama: " + e.getMessage()
            );
        }

        try {
            Kursus kursus = new Kursus(
                "K001", "Java", "Dasar", -50000
            );
        } catch (IllegalArgumentException e) {
            System.out.println(
                "Validasi biaya: " + e.getMessage()
            );
        }
    }
}