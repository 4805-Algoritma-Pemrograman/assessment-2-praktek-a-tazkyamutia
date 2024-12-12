import java.util.ArrayList;
import java.util.Scanner;

public class Nomor2 {
    static ArrayList<Integer>keranjangBelanja = new ArrayList<>();

    public static void main(String[] args){
        int[] hargaMenu = {35000, 45000, 20000, 15000};
        String[] namaMenu = {"Burger", "Steak", "Spaghetti", "Kentang"};

        Scanner scanner = new Scanner(System.in);
        char inputLagi;

        do {
            System.out.print("Masukan nama menu [Burger/Steak/Spaghetti/Kentang]:");
            String inputMenu = scanner.nextLine();

            for (int i = 0; i < namaMenu.length; i++) {
                if (inputMenu.equalsIgnoreCase(namaMenu[i])) {
                    keranjangBelanja.add(hargaMenu[i]);
                    break;
                }
            }

            System.out.print("Input lagi (Y/N)?: ");
            inputLagi = scanner.next().charAt(0);
            scanner.nextLine(); 
        } while (inputLagi == 'Y');
        
        int totalBelanja = hitungTotalBelanja();
        int diskon = hitungDiskon(totalBelanja);
        int totalBayar = totalBelanja - diskon;

        System.out.println("Total item pesanan = " + keranjangBelanja.size());
        System.out.println("Total yang harus dibayar = " + totalBayar);
    }

    public static int hitungTotalBelanja() {
        int total = 0;
        for (int harga : keranjangBelanja) {
            total += harga;
        }
        return total;
    }

    public static int hitungDiskon(int totalBelanja) {
        if (totalBelanja < 50000) {
            return 0;
        } else if (totalBelanja >= 50000 && totalBelanja <= 100000) {
            return (int) (totalBelanja * 0.05);
        } else {
            return (int) (totalBelanja * 0.1);
        } 
    }
}

