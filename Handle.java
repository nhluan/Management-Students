import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.*;

public class Handle {
    public Handle() {
    }

    public int checkStudent(Student s, manageStudent ss){
        ArrayList<Student> students = ss.getStudents();

        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId().equals(s.getId())){
                return 1;
            }
        }
        return 0;
    }

    //1: exits
    //0: no
    public int checkID(String id, manageStudent ss){
        ArrayList<Student> students = ss.getStudents();

        for (int i = 0; i < students.size(); i++){
            if (id.equals(ss.getStudents().get(i).getId())){
                return 1;
            }
        }
        return 0;
    }

    public int findMinID(ArrayList<Student> ss){
        int pos = 0;
        int min = Integer.parseInt(ss.get(0).getId());

        for (int i = 0; i < ss.size(); i++){
            if (Integer.parseInt(ss.get(i).getId()) <= min){
                min = Integer.parseInt(ss.get(i).getId());
                pos = i;
            }
        }

        return pos;
    }

    public int findMinGPA(ArrayList<Student> ss){
        int pos = 0;
        float   min = ss.get(0).getGpa();

        for (int i = 0; i < ss.size(); i++){
            if (ss.get(i).getGpa() <= min) {
                min = ss.get(i).getGpa();
                pos = i;
            }
        }

        return pos;
    }

    //file
    public void writeFile (PrintWriter wf, ArrayList<Student> ss){
        for (int i = 0; i < ss.size(); i++){
            wf.println(
                    ss.get(i).getId()
                    + ", "
                    + ss.get(i).getName()
                    + ", "
                    + ss.get(i).getGpa()
                    + ", "
                    + ss.get(i).getAddress()
                    + ", "
                    + ss.get(i).getNotes()
            );
        }
    }


}
