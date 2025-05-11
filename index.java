import java.util.Scanner;

public class HospitalManagement {
    static class Patient {
        int id;
        String name;
        String ailment;

        Patient(int id, String name, String ailment) {
            this.id = id;
            this.name = name;
            this.ailment = ailment;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Ailment: " + ailment;
        }
    }

    static Patient[] patients = new Patient[100];
    static int patientCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Delete Patient");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addPatient(sc);
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    deletePatient(sc);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        sc.close();
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Ailment: ");
        String ailment = scanner.nextLine();
        patients[patientCount++] = new Patient(id, name, ailment);
        System.out.println("Patient added successfully.");
    }

    private static void viewPatients() {
        if (patientCount == 0) {
            System.out.println("No patients found.");
        } else {
            System.out.println("\n--- List of Patients ---");
            for (int i = 0; i < patientCount; i++) {
                System.out.println(patients[i]);
            }
        }
    }

    private static void deletePatient(Scanner scanner) {
        if (patientCount == 0) {
            System.out.println("No patients to delete.");
            return;
        }

        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < patientCount; i++) {
            if (patients[i].id == id) {
                for (int j = i; j < patientCount - 1; j++) {
                    patients[j] = patients[j + 1];
                }
                patients[--patientCount] = null;
                found = true;
                System.out.println("Patient deleted successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Patient with ID " + id + " not found.");
        }
    }
}

