import java.util.Scanner;

class Mobil {
	String jenis, mesin;

	Mobil(String jenis) {
		this.jenis = jenis;
	}

	void jalan() {
		System.out.println("Mobil "+this.jenis+" jalan...");
	}

	void kurangiKecepatan() {
		System.out.println("Mobil "+this.jenis+" mengurangi kecepatan...");
	}

	void berhenti() {
		System.out.println("Mobil "+this.jenis+" stop...");
	}
}


class PejalanKaki {
	String nama;

	PejalanKaki(String nama) {
		this.nama = nama;
	}

	void menyeberang() {
		System.out.println("Pejalan kaki "+this.nama+" melewati zebra cross...");
	}

	void bersiap() {
		System.out.println("Pejalan kaki "+this.nama+" bersiap melewati zebra cross...");
	}

	void menunggu() {
		System.out.println("Pejalan kaki "+this.nama+" menunggu...");
	}
}


public class Main {
	public static void main(String[] args) {
		// Declarate object
		PejalanKaki pejalan_kaki = new PejalanKaki("P_71190525");
		Mobil mobil = new Mobil("M_71190525");
		Scanner inp = new Scanner(System.in);

		// Get user input
		System.out.println("Kode lampu lalu lintas saat ini: ");
		int kodeLampu = inp.nextInt();

		// Condition
		if (kodeLampu == 1) {
			System.out.println("-----Lampu hijau-----");
			mobil.jalan();
			pejalan_kaki.menunggu();

		} else if (kodeLampu == 2) {
			System.out.println("-----Lampu kuning-----");
			mobil.kurangiKecepatan();
			pejalan_kaki.bersiap();

		} else if (kodeLampu == 3) {
			System.out.println("-----Lampu merah-----");
			mobil.berhenti();
			pejalan_kaki.menyeberang();

		} else {
			System.out.println("Kode lalu lintas tidak valid");
		}
	}
}

