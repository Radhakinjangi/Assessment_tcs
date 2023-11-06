package Inventory_Replenish;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Inventory {
    private String inventoryId;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;

    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
}

public class Inventory_Replenish {
    public static void main(String[] args) {
        List<Inventory> inventories = new ArrayList<>();
        int limit;

        // Read values for four Inventory objects and the limit
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            String inventoryId = scanner.next();
            int maximumQuantity = scanner.nextInt();
            int currentQuantity = scanner.nextInt();
            int threshold = scanner.nextInt();
            inventories.add(new Inventory(inventoryId, maximumQuantity, currentQuantity, threshold));
        }

        limit = scanner.nextInt();

        // Call the replenish method using streams and print the status
        List<Inventory> replenishedInventories = replenish(inventories, limit);

        for (Inventory inventory : replenishedInventories) {
            String message = inventory.getInventoryId();
            if (inventory.getThreshold() > 75) {
                message += " Critical Filling";
            } else if (inventory.getThreshold() >= 50 && inventory.getThreshold() <= 75) {
                message += " Moderate Filling";
            } else {
                message += " Non-Critical Filling";
            }
            System.out.println(message);
        }
        scanner.close();
    }

    public static List<Inventory> replenish(List<Inventory> inventories, int limit) {
        return inventories.stream()
            .filter(inventory ->inventory.getThreshold()<=limit)
            .map(inventory -> {
                int shortage = inventory.getMaximumQuantity() - inventory.getCurrentQuantity();
                if (shortage > 0) {
                    inventory.setCurrentQuantity(inventory.getCurrentQuantity() + shortage);
                }
                return inventory;
            })
            .collect(Collectors.toList());
    }
}