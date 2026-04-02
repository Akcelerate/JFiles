import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    // Objects
    private String patientID;
    private String name;
    private String ailment;

    // Constructor
    Patient(String p, String n, String a) {
        this.patientID = p;
        this.name = n;
        this.ailment = a;
    }

    // Method
    void displayPatientDetails() {
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Ailment: " + ailment);
    }

    String getPatientID() {
        return patientID;
    }

}

class Doctor {
    // Objects
    private String doctorID;
    private String name;
    private String specialization;
    private ArrayList<Patient> patients;
    private static int doctors = 0;

    // Constructor
    Doctor(String d, String n, String s) {
        this.doctorID = d;
        this.name = n;
        this.specialization = s;
        this.patients = new ArrayList<>();
        doctors++;
    }

    // Methods
    void addPatient(Patient patient) {
        patients.add(patient);
    }

    void displayDoctorDetails() {
        System.out.println("Doctor ID: " + doctorID);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
        System.out.println("Associate Patient Details:");
        for (Patient p : patients) {
            p.displayPatientDetails();
        }
    }

    static int totalDoctors(){
        return doctors;
    }

    public String getDoctorID() {
        return doctorID;
    }

}

public class Hospital {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        ArrayList<Doctor> doctorList = new ArrayList<>();

        System.out.println("Enter All Doctor Details");
        for (int i = 1; i == 1;) {
            System.out.print("Doctor ID: ");
            String id = inp.nextLine();
            System.out.print("Name: ");
            String name = inp.nextLine();
            System.out.print("Specialization: ");
            String sp = inp.nextLine();

            doctorList.add(new Doctor(id, name, sp));

            System.out.print("Enter '1' to enter details of next doctor\nEnter '0' to finish");
            i = inp.nextInt();
        }

        ArrayList<Patient> patientList = new ArrayList<>();
        System.out.println("Enter All Patient Details");
        for (int i = 1; i == 1;) {
            System.out.print("Patient ID: ");
            String id = inp.next();
            inp.nextLine();
            System.out.print("Name: ");
            String name = inp.nextLine();
            System.out.print("Ailment: ");
            String ail = inp.nextLine();

            patientList.add(new Patient(id, name, ail));

            System.out.print("\nDoctor (ID) to assign Patient: ");
            String di = inp.nextLine();
            for (Doctor d : doctorList) {
                if (d.getDoctorID().equals(di)) {
                    d.addPatient(patientList.get(patientList.size() - 1));
                }else{}
            }

            System.out.println("Enter '1' to enter details of next patient\nEnter '0' to finish");
            i = inp.nextInt();
        }

        System.out.println("Doctor Details: ");
        for (Doctor d : doctorList) {
            d.displayDoctorDetails();
        }

        System.out.println("\nTotal Doctors in Hospital: " + Doctor.totalDoctors());

        inp.close();
    }
}
