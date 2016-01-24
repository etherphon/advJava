/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jahjavafinal;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author jhedding
 */
public class Club {

    ArrayList<Student> studentClub = new ArrayList<>(25);
    Scanner keyboard = new Scanner(System.in);

    int input;
    int idTemp;
    String nameTemp;
    String mailTemp;
    String tinput;
    int numStudent = 1;
    boolean removed = false;
    boolean edited = false;
    boolean found = false;

    public Club() {
    }

    public void openFile() {
        try {
            File file = new File("studentclub.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader fr = new FileReader(file.getAbsoluteFile());
            BufferedReader br = new BufferedReader(fr);

            while (true) {
	    String line = br.readLine();
	    if (line == null) {
		break;
	    }
            
            String[] sTemp = line.split(":");
	    studentClub.add(new Student(Integer.parseInt(sTemp[0]), sTemp[1], sTemp[2]));
            }
            
            numStudent = studentClub.size();
            br.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveFile() {
        try {
            File file = new File("studentclub.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            for (Student studentClub1 : studentClub) {
                bw.write(studentClub1.idNum + ":" + studentClub1.name
                        + ":" + studentClub1.email + "\n");
            }

            bw.close();
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addStudent() {
        if (studentClub.size() < 25) {
            System.out.print("Enter student name: ");
            nameTemp = keyboard.nextLine();
            System.out.print("Enter student email: ");
            mailTemp = keyboard.nextLine();
            studentClub.add(new Student(900 + numStudent, nameTemp, mailTemp));
            System.out.println("\nStudent has been added.\n");
            numStudent++;
        } else {
            System.out.println("Club is full!\n");
        }
    }

    public void delStudent() {
        for (int i = 0; i < studentClub.size(); i++) {
            System.out.println("ID Number: " + studentClub.get(i).idNum
                    + " Name: " + studentClub.get(i).name);
        }
        System.out.print("Enter the name of the student you'd like to delete: ");
        nameTemp = keyboard.nextLine();
        for (int i = 0; i < studentClub.size(); i++) {
            if (studentClub.get(i).name.equalsIgnoreCase(nameTemp)) {
                studentClub.remove(i);
                removed = true;
            }
        }
        if (removed) {
            System.out.println("Student has been removed.\n");
            removed = false;
        } else {
            System.out.println("Student not found.\n");
        }
    }

    public void listStudents() {
        System.out.println("ID\t\tName\t\t\tEmail");
        System.out.println("-----------------------------------------------------------------------");
        for (Student studentClub1 : studentClub) {
            System.out.print(studentClub1.idNum + "\t|\t" + studentClub1.name
                    + "\t|\t" + studentClub1.email + "\n");
        }
        System.out.println();
    }

    public void editStudent() {
        for (int i = 0; i < studentClub.size(); i++) {
            System.out.println("ID Number: " + studentClub.get(i).idNum
                    + " Name: " + studentClub.get(i).name);
        }
        System.out.print("Enter the name of the student you'd like to edit: ");
        nameTemp = keyboard.nextLine();
        for (int i = 0; i < studentClub.size(); i++) {
            if (studentClub.get(i).name.equalsIgnoreCase(nameTemp)) {
                found = true;
                Student student = (Student) studentClub.get(i);
                System.out.print("Would you like to edit the name? Y/N: ");
                tinput = keyboard.nextLine();
                if ("Y".equalsIgnoreCase(tinput)) {
                    System.out.print("Enter a new name: ");
                    nameTemp = keyboard.nextLine();
                    student.setName(nameTemp);
                    edited = true;
                }
                System.out.print("Would you like to edit the email? Y/N: ");
                tinput = keyboard.nextLine();
                if ("Y".equalsIgnoreCase(tinput)) {
                    System.out.print("Enter a new email: ");
                    nameTemp = keyboard.nextLine();
                    student.setEmail(nameTemp);
                    edited = true;
                }
            }
        }

        if (!found) {
            System.out.println("Error: Student not found.\n");
        }

        if (edited) {
            System.out.println("\nChanges applied.\n");
            edited = false;
            found = false;
        } else {
            System.out.println("No changes made.\n");
        }

    }

}
