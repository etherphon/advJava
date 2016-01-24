/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jahjavafinal;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author jhedding
 */
public class JahJavaFinal {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner keyboard = new Scanner(System.in);
        String tinput = "";
        
        Club newClub = new Club();
        newClub.openFile();
        while (!"exit".equalsIgnoreCase(tinput)) {
            System.out.println("Student Club Membership Database\n");
            System.out.print("Choose an option: \n1. Add\n2. Delete\n3. Edit\n4. List\n5. Exit\n\n");
            System.out.print("Action: ");
            tinput = keyboard.nextLine();
            
            if (tinput.equalsIgnoreCase("ADD") || tinput.equals("1")) {
                newClub.addStudent();
            }
            if (tinput.equalsIgnoreCase("DELETE") || tinput.equals("2")) {
                newClub.delStudent();
            } 
            if (tinput.equalsIgnoreCase("EDIT") || tinput.equals("3")) {
                newClub.editStudent();
            }
            if (tinput.equalsIgnoreCase("LIST") || tinput.equals("4")) {
                newClub.listStudents();
            }
            if (tinput.equalsIgnoreCase("EXIT") || tinput.equals("5")) {
                break;
            }
            
        }
        
        newClub.saveFile();
    }
    
}
