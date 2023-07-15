import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RakTest {

    private Rak rak;

    @Before
    public void setUp() {
        rak = new Rak(5, "Rak Obat");
    }

    @Test
    public void testGetKategoriRak() {
        String expectedKategori = "Rak Obat";
        String actualKategori = rak.getKategoriRak();
        assertEquals(expectedKategori, actualKategori);
    }

    @Test
    public void testTambahObat() {
        Obat obat1 = new Obat("Paracetamol");
        Obat obat2 = new Obat("Amoxicillin");

        rak.tambahObat(obat1, 0);
        rak.tambahObat(obat2, 2);

        Obat[] daftarObat = rak.getListObat();
        assertEquals(obat1, daftarObat[0]);
        assertEquals(obat2, daftarObat[2]);
    }

    @Test
    public void testPrintRak() {
        // Pengujian printRak hanya memeriksa apakah metode dapat dijalankan tanpa error.
        rak.printRak();
    }

    @Test
    public void testGetListObat() {
        Obat obat1 = new Obat("Paracetamol");
        Obat obat2 = new Obat("Amoxicillin");

        rak.tambahObat(obat1, 0);
        rak.tambahObat(obat2, 2);

        Obat[] expectedDaftarObat = new Obat[]{obat1, null, obat2, null, null};
        Obat[] actualDaftarObat = rak.getListObat();
        assertArrayEquals(expectedDaftarObat, actualDaftarObat);
    }
}
