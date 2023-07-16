import java.util.Scanner;

public class HaloDDP {
    public static void main(String[] args) {
        int BASE_PRICE = 5000; 
        Scanner input = new Scanner(System.in);

        System.out.println("Selamat datang Haloddp. Berapa ukuran lemari obat hari ini? (max row 5) ");
        boolean valid = false;
        int row = 0;
        int column = 0;
        while(!valid){
            String ukuran = input.nextLine();
            String[] parts = ukuran.split("x");

            // TODO : Implementasi validasi input ukuran lemari
            if (parts.length == 2) {
                row = Integer.parseInt(parts[0]);
                column = Integer.parseInt(parts[1]);
                if (row < 1 || column < 1){
                    System.out.println("Ukuran lemari tidak bisa < 1");
                    System.exit(0);
                }
                valid = true;
            } else {
                System.out.println("Format lemari tidak sesuai. Seharusnya <row>x<column>");
                System.exit(0);
            }

        }

        // TODO : Buat objek lemari dengan ukuran yang sudah ditentukan
        Lemari lemari = new Lemari(row);

        System.out.println("Silahkan tentukan kategori obat untuk setiap rak");
        // TODO : Implementasi input kategori rak
        for (int i = 0; i < row; i++) {
            System.out.print("Rak ke-" + (i+1) + " : ");
            String kategori = input.nextLine();
            Rak rak = new Rak(column, kategori);
            lemari.addRak(rak, i);
            System.out.println("Rak ke-" + (i+1) + " adalah rak obat " + kategori);
        }

        System.out.println("Rak obat hari ini: ");
        for (int i = 0; i < row; i++ ){
            Rak rak = lemari.getRak(i);
            System.out.println(rak.getKategoriRak());
            rak.printRak();
        }

        // for (Rak rak : lemari ) {
        //     System.out.println("Rak dengan kategori " + rak.getKategoriRak());
        // }
        

        // Rak rak = rak.getKategoriRak()
        // System.out.println(rak.getKategoriRak());

        while (true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Tambah obat");
            System.out.println("2. Lihat obat");
            System.out.println("3. Beli obat");
            System.out.println("99. Keluar");
            System.out.print("Pilih menu: ");
            String menu = input.nextLine();

            if (menu.equals("1")) {
                // TODO : Implementasi input obat

            } else if (menu.equals("2")) {
                // TODO : Implementasi print obat
            } else if (menu.equals("3")) {
                // TODO : Implementasi beli obat
            } else if (menu.equals("99")){
                // TODO : Implementasi keluar
                break;
            } else {
                System.out.println("Menu tidak tersedia");
            }
        }

        input.close();
        System.out.println("Terima kasih telah menggunakan Haloddp!");
    }
}
