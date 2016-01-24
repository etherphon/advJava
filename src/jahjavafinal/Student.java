/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jahjavafinal;

/**
 *
 * @author jhedding
 */
public class Student {
    int idNum;
    String name;
    String email;

    public Student(int idNum, String name, String email) {
        this.idNum = idNum;
        this.name = name;
        this.email = email;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
