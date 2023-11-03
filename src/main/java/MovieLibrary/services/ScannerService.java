package MovieLibrary.services;

import java.util.Scanner;

public class ScannerService {
    private final Scanner scanner = new Scanner(System.in);

    public int readStartYear() {
        System.out.print("Enter start year: ");
        return scanner.nextInt();
    }

    public int readEndYear() {
        System.out.print("Enter end year: ");
        return scanner.nextInt();
    }
    public String readFirstName(){
        System.out.print("Enter actor's first name: ");
        return scanner.nextLine();
    }
    public String readLastName(){
        System.out.print("Enter actor's last name: ");
        return scanner.nextLine();
    }

    public int readAction() {
        return scanner.nextInt();
    }
}
