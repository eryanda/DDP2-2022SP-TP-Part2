public class Lemari {
    private int ukuran;
    private Rak[] rak;

    public Lemari(int ukuran){
        this.ukuran = ukuran;
        rak = new Rak[ukuran];
    }


    /**
     * 
     * @param rak
     * @param index
     */
    public void addRak(Rak rak, int index){
        this.rak[index] = rak;
    }

    // TODO : Implementasi method print
    public void print(){
        System.out.println("Rak obat hari ini berukuran " + ukuran + "x" + rak[0].getSize());
        for (int i = 0; i < ukuran; i++) {
            System.out.println(rak[i].getKategoriRak());
            System.out.println("==================");
            rak[i].printRak();
            System.out.println("==================");
        }
    }

    // TODO : Implementasi method beliObat
    /**
     * 
     * @param obat
     * @param jumlah
     * @return
     */
    public boolean beliObat(Obat obat, int jumlah) {
        Rak rakObat = null;
        for (Rak rak : rak) {
            if (rak.containsObat(obat)) {
                rakObat = rak;
                break;
            }
        }
        if (rakObat != null) {
            return rakObat.beliObat(obat, jumlah);
        }
        return false;
    }

    // TODO : Implementasi method searchObat
    /**
     * 
     * @param namaObat
     * @return 
     */
    public Obat searchObat(String namaObat) {
        for (Rak rak : rak) {
            Obat obat = rak.searchObat(namaObat);
            if (obat != null) {
                return obat;
            }
        }
        return null;
    }

    // TODO : Implementasi method getRak
    /**
     * 
     * @param i
     * @return
     */
    public Rak getRak(int i) {
        return rak[i];
    }
}
