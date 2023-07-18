import java.util.Scanner;

public class HaloDDP {
    public static void main(String[] args) {
        int BASE_PRICE = 5000; 
        Scanner input = new Scanner(System.in);

        boolean valid = false;
        int row = 0;
        int column = 0;
        String [] daftarKategori = new String [row + 1];
        while(!valid){
            System.out.println("Selamat datang Haloddp. Berapa ukuran lemari obat hari ini? (max row 5) ");
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
                System.out.println("Rak obat hari ini berukuran " + ukuran);
                valid = true;
            } else {
                System.out.println("Format lemari tidak sesuai. Seharusnya <row>x<column>");
                System.exit(0);
            }

        }

        // TODO : Buat objek lemari dengan ukuran yang sudah ditentukan
        Lemari lemari = new Lemari(row);

        System.out.println("\nSilahkan tentukan kategori obat untuk setiap rak");
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
                System.out.print("Masukkan nama obat: ");
                String namaObat = input.nextLine();
                System.out.print("Masukkan kategori obat: ");
                String kategoriObat = input.nextLine();
                int indexRak = -1;
                for(int i = 0; i<= row; i++){
                    if (daftarKategori[i].equals(kategoriObat)){
                        System.out.println("Kategori obat valid");
                        indexRak = i-1;
                        break;
                    }
                }
                if(indexRak == -1){
                    System.out.println("Kategori obat tidak valid");
                    continue;
                }
                 
                System.out.print("Masukkan posisi obat: ");
                String posObat = input.nextLine();
                String [] index = posObat.split(",");
                int baris = Integer.parseInt(index[0]);
                int kolom = Integer.parseInt(index[1]);
                if (baris > row || kolom > column){
                    System.out.println("Posisi tidak ada di lemari");
                    continue;
                }

                System.out.print("Masukkan stok obat: ");
                int stokObat = input.nextInt();
                input.nextLine();
                Obat obat = new Obat(namaObat, stokObat, kategoriObat);
                System.out.print("Masukkan nomor rak (1-" + row + "): ");
                int nomorRak = input.nextInt();
                input.nextLine(); // Handle newline character after nextInt()
                Rak rak = lemari.getRak(nomorRak - 1);

                // if (rak != null) {
                //     rak.tambahObat(obat);
                //     System.out.println("Obat berhasil ditambahkan ke rak " + nomorRak);
                // } else {
                //     System.out.println("Nomor rak tidak valid.");
                // }



            } else if (menu.equals("2")) {
                // TODO : Implementasi print obat

            } else if (menu.equals("3")) {
                // TODO : Implementasi beli obat
                System.out.print("Obat apa yang ingin dibeli? ");
                String beliObat = input.nextLine();
                System.out.print("Ingin beli berapa banyak? ");
                int banyakObat = input.nextInt();

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
