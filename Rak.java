public class Rak {
    private int size;
    private String kategori;
    private Obat[] daftarObat;

    public Rak(int size, String kategori){
        this.kategori = kategori;
        this.daftarObat = new Obat[size];
        this.size = size;
    }

    // TODO : Implementasi method getKategoriRak
    public String getKategoriRak() {
        return kategori;
    }

    // TODO : Implementasi method tambahObat
    public void tambahObat(Obat obat, int index) {
        this.daftarObat[index] = obat;
    }
    
    // TODO : Implementasi method printRak
    public void printRak(){
        System.out.println("==================");
        for (int i = 0; i < daftarObat.length; i++){
            String namaObat = "Kosong";
            if (daftarObat[i] != null){
                namaObat = daftarObat[i].getNama();
            }
            System.out.print("| " + namaObat + " ");
        }
        System.out.println();
        System.out.println("==================\n");
        return;
    }

    // TODO : Implementasi method getListObat
    public Obat[] getListObat() {
        return daftarObat;
    }
    
}
