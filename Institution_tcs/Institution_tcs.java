package Institution_tcs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class Institution {
    private int institutionId;
    private String institutionName;
    private String noOfStudentsPlaced;
    private int noOfStudentsCleared;
    private String location;
    private String grade;

    public Institution(int institutionId, String institutionName, String noOfStudentsPlaced, int noOfStudentsCleared, String location) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
        this.grade = "";
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getNoOfStudentsPlaced() {
        return noOfStudentsPlaced;
    }

    public int getNoOfStudentsCleared() {
        return noOfStudentsCleared;
    }

    public String getLocation() {
        return location;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

public class Institution_tcs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Institution> institutions = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int institutionId = scanner.nextInt();
            String institutionName = scanner.next();
            String noOfStudentsPlaced = scanner.next();
            int noOfStudentsCleared = scanner.nextInt();
            String location = scanner.next();
            institutions.add(new Institution(institutionId, institutionName, noOfStudentsPlaced, noOfStudentsCleared, location));
        }

        String locationToFind = scanner.next();
        String institutionNameToFind = scanner.next();

        int numCleared = findNumClearancedByLoc(institutions, locationToFind);
        if (numCleared > 0) {
            System.out.println(numCleared);
        } else {
            System.out.println("There are no cleared students in this particular location");
        }

        Institution institution = updateInstitutionGrade(institutions, institutionNameToFind);
        if (institution != null) {
            System.out.println(institution.getInstitutionName() + "::" + institution.getGrade());
        } else {
            System.out.println("No Institute is available with the specified name");
        }

        scanner.close();
    }

    public static int findNumClearancedByLoc(List<Institution> institutions, String location) {
        return institutions.stream()
                .filter(institution -> institution.getLocation().equalsIgnoreCase(location))
                .mapToInt(Institution::getNoOfStudentsCleared)
                .sum();
    }

    public static Institution updateInstitutionGrade(List<Institution> institutions, String institutionName) {
        Optional<Institution> result = institutions.stream()
                .filter(institution -> institution.getInstitutionName().equalsIgnoreCase(institutionName))
                .map(institution -> {
                    int rating = (Integer.parseInt(institution.getNoOfStudentsPlaced()) * 100) / institution.getNoOfStudentsCleared();
                    institution.setGrade(rating >= 80 ? "A" : "B");
                    return institution;
                })
                .findFirst();

        return result.orElse(null);
    }
}
