package ra.config;

import java.util.Scanner;

public class Config {
    public static Scanner scanner(){
        return new Scanner(System.in);
    }
    public static int validateInt(){
        int n ;
        System.out.println("Mời nhập: ");
        while (true){
            try {
                n = Integer.parseInt(scanner().nextLine());
                break;
            }catch (NumberFormatException e){
                System.out.println("Sai dinh dang moi nhap lai");
            }
        }
        return n;
    }
    public static double validateDouble(){
        double n;
        System.out.println("Mời nhập: ");
        while (true){
            try {
                n = Double.parseDouble(scanner().nextLine());
                break;
            }catch (NumberFormatException e ){
                System.out.println("Sai định dạng mời nhập lại");
            }
        }
        return n;
    }
}
