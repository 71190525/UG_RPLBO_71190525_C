package com.ug4.soal1;
import java.util.Scanner;


class Bus {
    String name;
    Driver driver;
    protected Integer CAPACITY;
    Passenger[] passenger;
    Integer usedCapacity;
    double fares, profit;
    protected String ROUTE;

    Bus(String jenis, Driver driver) {
        this.name = name;
        this.driver = driver;
    }

    String getName() {
        return this.name;
    }

    void setName() {}

    Driver getDriver() {
        return this.driver;
    }

    void setDriver() {}

    Integer getCapacity() {
        return this.CAPACITY;
    }

    Passenger[] getPassenger() {
        return this.passenger;
    }

    Integer getUsedCapacity() {
        return this.usedCapacity;
    }

    void setUsedCapacity(Integer usedCpacity) {
        this.usedCapacity = usedCapacity;
    }

    double getFares() {
        return this.fares;
    }

    double getProfit() {
        return this.profit;
    }

    String[] getRoute() {
        return this.ROUTE;
    }

    void setProfit(double profit) {
        this.profit = profit;
    }

    boolean checkPassengerBalance(Passenger passenger) {
        if (passenger.getBalance() > 0) {
            return true;
        } else {
            return false;
        }
    }

    void topUpBalance(double balance,  Passenger, passenger) {
        passenger.setBalance()
    }

    void takePassenger(Passenger passenger) {}

    void dropPassenger(Passenger passenger) {}

    void proceedOrder(String order, Passenger passenger) {

    }

    String cancelOrder(Passenger passenger) {
        return "Order telah di batalkan";
    }


}


class Driver {
    String name, gender;
    Integer age;

    Driver(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    Integer getAge() {
        return this.age;
    }

    void setAge(Integer age) {
        this.age = age;
    }

    String getGender() {
        return this.gender;
    }

    void setGender(String gender) {
        this.gender = gender;
    }
}


class Passenger {
    String name, email, destiny;
    double balance;

    Passenger(String name, String email, double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getBalance() {
        return this.balance;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    String getEmail() {
        return this.email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getDestiny() {
        return this.destiny;
    }

    void setDestiny(String destiny) {
        String destiny = destiny;
    }

}



public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main( String[] args )
    {
        initiateMenu();
    }

    private static void initiateMenu(){
        //menginisialisasikan object penumpang
        Passenger adit = new Passenger("Adit","adit@gmail.com",100000);
        Passenger surya = new Passenger("Surya","surya@gmail.com",20000);
        Passenger krismon = new Passenger("Krismon","krismon@gmail.com", 10000);
        Driver pakTole = new Driver("Pak Tole","pria",35);

        /*
        Membuat instance object Bus. Disini tarif perjalanan (fares) yang diatur adalah Rp 15.000
        kalian bebas mengatur jumlah tarif perjalanan (fares) sesuai keinginan kalian pada Class Bus
         */
        Bus dutaBus = new Bus("Duta Bus",pakTole);

        /*
        masuk pada test case. sistem akan langsung mengarahkan pada method menu()
         */
        System.out.println("Duta Bus");
        //case penumpang adit
        menu(adit,dutaBus);
        //case penumpang surya
        menu(surya,dutaBus);
        //case penumpang krismon
        menu(krismon,dutaBus);

        //case telah sampai di tujuan pertama
        System.out.println("Pemberhentian pertama telah sampai pada Kampus Universitas Kristen Duta Wacana");
        dutaBus.dropPassenger(dutaBus.getRoute()[0],adit);
        dutaBus.dropPassenger(dutaBus.getRoute()[0],surya);
        dutaBus.dropPassenger(dutaBus.getRoute()[0],krismon);
        System.out.println("Sisa penumpang sebanyak " + dutaBus.getUsedCapacity() + " orang");
        System.out.println("============================================");
        System.out.println();
        System.out.println();

        //case telah sampai di tujuan kedua
        System.out.println("Pemberhentian kedua telah sampai pada Asrama Omah Babadan");
        dutaBus.dropPassenger(dutaBus.getRoute()[1],adit);
        dutaBus.dropPassenger(dutaBus.getRoute()[1],surya);
        dutaBus.dropPassenger(dutaBus.getRoute()[1],krismon);
        System.out.println("Sisa penumpang sebanyak " + dutaBus.getUsedCapacity() + " orang");
        System.out.println("============================================");
        System.out.println();
        System.out.println();

        //case telah sampai di tujuan kedua
        System.out.println("Pemberhentian ketiga telah sampai pada Asrama Teologi");
        dutaBus.dropPassenger(dutaBus.getRoute()[2],adit);
        dutaBus.dropPassenger(dutaBus.getRoute()[2],surya);
        dutaBus.dropPassenger(dutaBus.getRoute()[2],krismon);
        System.out.println("Sisa penumpang sebanyak " + dutaBus.getUsedCapacity() + " orang");
        System.out.println("============================================");
        System.out.println();
        System.out.println();

        //menampilkan keuntungan yang diperoleh
        System.out.println("Keuntungan hari ini");
        System.out.println("Keuntungan sebesar : Rp " +dutaBus.getProfit() + "0;-");
    }

    private static void menu(Passenger passenger, Bus bus){
        System.out.println("Selamat Datang Kak " + passenger.getName());
        double tarif = bus.getFares();
        double balance = passenger.getBalance();
        if (balance >= tarif) {
            showDestination();
        } else {
            topUpMenu();
        }
        System.out.println("============================================\n\n\n");
    }

    private static void showDestination(
            Bus bus,
            Passenger passenger
    ){
        String destiny;
        int i = 0;
        System.out.println("Pilihan rute perjalanan");
        for(String rute : bus.getRoute()){
            i++;
            System.out.print(i + ". " + rute + "\n");
        }
        System.out.print("masukan destinasi perjalanan anda : ");
        destiny = scanner.nextLine();
        //mengecek apakah input sudah sesuai atau belum
        if(destiny.isEmpty()) {
            System.out.println("Mohon pilih destinasi anda!");
            showDestination();
        }
        else{
            boolean found = false;
            for(String route: bus.getRoute()){
                if (route == destiny) {
                    found = true;
                }
            }
            System.out.println("Destinasi tidak di temukan")
        }
    }

    private static void topUpMenu(
            Bus bus,
            Passenger passenger
    ){
        String choice;
        double balance;
        System.out.println("Anda ingin top up ?");
        System.out.print("jawaban anda (ya/tidak): ");
        choice = scanner.nextLine();
        //melakukan pengecekan pada input pilihan
        if(choice.equalsIgnoreCase("ya")) {
            System.out.print("Masukan nominal top up : ");

            topup = scanner.nextLine();
            //mengecek apakah input sudah sesuai atau belum
            if(topup.isEmpty()) {
                System.out.println("Inputan anda tidak valid!");
                topUpMenu();
            } else {
                dutaBus.proceedOrder(destiny, passenger);
            }
        }
        else if(choice.equalsIgnoreCase("tidak")){
            System.out.println("Anda telah membatalkan order");
        }
        else{
            System.out.println("Inputan anda tidak valid!");
            topUpMenu();
        }

    }
}
