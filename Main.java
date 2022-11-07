import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.logging.Handler;

public class Main {
    public static Student inputData(String id, String name, float gpa, String address, String notes){
        Student result = new Student(id, name, gpa, address, notes);

        return result;
    }
    public static void main(String[] args) throws IOException {
        Scanner myInput = new Scanner(System.in);

        manageStudent students = new manageStudent();
        Handle handle = new Handle();

        //tao file txt
        //E:\nhluan\Student\thirdYear\hk1\Java\Project\Project1\20127559\
        File save = new File("saveStudents.txt");
        try {
            save.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }

        int choose = 0;

        do {
            System.out.println("----------------------------MENU----------------------------");
            System.out.println(
                    "1. Add student\n" +
                    "2. Update student information\n"
                    + "3. Delete student\n"
                    + "4. View student list\n"
                    + "5. Save file\n"
                    + "6. Import file csv\n"
                    + "7. Export file csv\n"
                    + "0. Stop"
            );

            System.out.print("Enter your choice: ");
            choose = myInput.nextInt();
            myInput.nextLine();

            //handle
            if (choose == 1){ //add studentdi
                System.out.print("Id: "); String id = myInput.nextLine();
                System.out.print("Name: "); String name = myInput.nextLine();
                System.out.print("GPA: "); float gpa = myInput.nextFloat();
                myInput.nextLine();
                System.out.print("Address: "); String address = myInput.nextLine();
                System.out.print("Notes: "); String notes = myInput.nextLine();

                Student add = inputData(id, name, gpa, address, notes);

                //check id
                if (handle.checkStudent(add, students) == 0){
                    students.add(add);
                    System.out.println("Added");
                }
                else {
                    System.out.println("Already exist!!!");
                }
            }
            else if (choose == 2){
                //update infor of student
                System.out.print("Enter ID student need change: ");
                String idNeed = myInput.nextLine();

                //check ID
                //exist
                if (handle.checkID(idNeed.trim(), students) == 1){
                    //menu
                    int chooseUp = 0;

                    do {
                        System.out.println("--------------------MENU UPDATE--------------------");
                        System.out.println(
                                "1. Update Name\n"
                                + "2. Update GPA\n"
                                + "3. Update Address\n"
                                + "4. Update Notes\n"
                                + "0. Stop\n"
                                + "Don't update ID!!!\n"
                        );

                        //read from user
                        System.out.print("Enter your choice: ");
                        chooseUp = myInput.nextInt();
                        myInput.nextLine(); //huy bo enter char

                        //handle
                        if (chooseUp == 1){
                            System.out.print("Enter name: ");
                            String nameUp = myInput.nextLine();

                            //update
                            students.updateName(nameUp, idNeed);
                        }
                        else if (chooseUp == 2){
                            System.out.print("Enter GPA: ");
                            float gpaUp = myInput.nextFloat();

                            //update
                            students.updateGpa(gpaUp, idNeed);
                        }
                        else if (chooseUp == 3){
                            System.out.print("Enter address: ");
                            String addressUp = myInput.nextLine();

                            //update
                            students.updateAddress(addressUp, idNeed);
                        }
                        else if (chooseUp == 4){
                            System.out.print("Enter notes: ");
                            String noteUp = myInput.nextLine();

                            //update
                            students.updateNote(noteUp, idNeed);
                        }
                    }
                    while (chooseUp != 0);
                }
                else {
                    System.out.println("NOT exist!!!");
                }
            }
            else if (choose == 3){
                //delete student
                System.out.print("Enter ID student need delete: ");
                String idNeed = myInput.nextLine();

                //handle

                //check ID
                if (handle.checkID(idNeed.trim(), students) == 1){
                    students.delete(idNeed);
                    System.out.println("Deleted!!!");
                }
                else {
                    System.out.println("NOT exits student need delete!!!");
                }
            }
            else if (choose == 4){
                //menu
                int choice = 0;
                do {
                    System.out.println("-----------------Menu-----------------");
                    System.out.println(
                            "1. The student id in ascending order\n"
                            + "2. The GPA in ascending order\n"
                            + "3. The students in normal\n"
                            + "0. Stop\n"
                    );

                    //read user input
                    System.out.print("Enter your choice: ");
                    choice = myInput.nextInt();

                    if (choice == 1){
                        students.printStudentByID();
                    }
                    else if (choice == 2){
                        students.printStudentByGPA();
                    }
                    else if (choice == 3){
                        students.printStudents();
                    }
                    else {
                        System.out.println("Error range!!!Please press again!!!");
                    }
                }
                while (choice != 0);
            }
            else if (choose == 5){
                //save file text
                //E:\nhluan\Student\thirdYear\hk1\Java\Project\Project1\20127559\
                PrintWriter wf = new PrintWriter("saveStudents.txt");
                handle.writeFile(wf, students.getStudents());
                wf.close();
                System.out.println("Saved!!!");

            }
            else if (choose == 6){
                //import csv
                //E:\nhluan\Student\thirdYear\hk1\Java\Project\Project1\20127559\
                String pathFile = "students.csv";
                BufferedReader reader = null;
                String line = "";
                int i = 1; //lan doc dau tien
                try {
                    reader = new BufferedReader(new FileReader(pathFile));

                    while ((line = reader.readLine()) != null){
                        String[] rowData = line.split(",");

                        if (i == 1){
                            i++;
                            continue;
                        }
                        else{
                            //id name gpa address notes
                            String id = rowData[0];
                            if (handle.checkID(id, students) == 1) {
                                continue;
                            }
                            String name = rowData[1];
                            float gpa = Float.parseFloat(rowData[2]);
                            String address = rowData[3];
                            String notes = rowData[4];

                            //add
                            Student add = new Student(id, name, gpa, address, notes);

                            //add
                            students.add(add);
                        }

                    }

                    System.out.println("Imported!!!");
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    try {
                        reader.close();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            else if (choose == 7) {
                //export csv
                try {
                    //E:\nhluan\Student\thirdYear\hk1\Java\Project\Project1\20127559\
                    PrintWriter writer1 = new PrintWriter(new File("export.csv"));
                    StringBuilder myObSt = new StringBuilder();
                    ArrayList<Student> ss = students.getStudents();
                    //add row 1
                    myObSt.append("ID");
                    myObSt.append(",");
                    myObSt.append("Name");
                    myObSt.append(",");
                    myObSt.append("GPA");
                    myObSt.append(",");
                    myObSt.append("Address");
                    myObSt.append(",");
                    myObSt.append("Notes");
                    myObSt.append("\n");

                    writer1.write(myObSt.toString());
                    myObSt.setLength(0);

                    for (int i = 0; i < ss.size(); i++ ){
                        Student temp = ss.get(i);

                        //create line
                        myObSt.append(temp.getId());
                        myObSt.append(",");
                        myObSt.append(temp.getName());
                        myObSt.append(",");
                        myObSt.append(temp.getGpa());
                        myObSt.append(",");
                        myObSt.append(temp.getAddress());
                        myObSt.append(",");
                        myObSt.append(temp.getNotes());
                        myObSt.append("\n");

                        //save
                        writer1.write(myObSt.toString());

                        //renew
                        myObSt.setLength(0);
                    }

                    //close
                    writer1.close();

                    //show
                    System.out.println("Exported!!!");
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
            else {
                System.out.println("Error!!! Please enter your choice again.");
            }


        } while (choose != 0);
    }




}
