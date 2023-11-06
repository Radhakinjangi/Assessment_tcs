package Device_Managment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Phone {
    private int phoneId;
    private String os;
    private String brand;
    private int price;

    public Phone(int phoneId, String os, String brand, int price) {
        this.phoneId = phoneId;
        this.os = os;
        this.brand = brand;
        this.price = price;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public String getOs() {
        return os;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }
}

public class Device_Managment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Phone> phones = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int phoneId = scanner.nextInt();
            String os = scanner.next();
            String brand = scanner.next();
            int price = scanner.nextInt();
            phones.add(new Phone(phoneId, os, brand, price));
        }

        String brandToFind = scanner.next();
        String osToFind = scanner.next();

        int priceForBrand = findPriceForGivenBrand(phones, brandToFind);
        System.out.println(priceForBrand > 0 ? priceForBrand : "The given Brand is not available");

        Phone phoneWithOs = getPhoneIdBasedOnOs(phones, osToFind);
        System.out.println(phoneWithOs != null ? phoneWithOs.getPhoneId() : "No phones are available with specified os and price range");

        scanner.close();
    }

    public static int findPriceForGivenBrand(List<Phone> phones, String brand) {
        return phones.stream()
                .filter(phone -> phone.getBrand().equalsIgnoreCase(brand))
                .mapToInt(Phone::getPrice)
                .sum();
    }

    public static Phone getPhoneIdBasedOnOs(List<Phone> phones, String os) {
        return phones.stream()
                .filter(phone -> phone.getOs().equalsIgnoreCase(os) && phone.getPrice() >= 50000)
                .findFirst()
                .orElse(null);
    }
}
