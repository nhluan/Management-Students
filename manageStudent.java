import java.util.ArrayList;

public class manageStudent {
    //private
    private ArrayList<Student> students = new ArrayList<Student>();

    //constructor

    public manageStudent() {
//        this.students = new ArrayList<Student>();
    }

    public manageStudent(ArrayList<Student> students) {
        this.students = students;
    }

    //get

    public ArrayList<Student> getStudents() {
        ArrayList<Student> result = new ArrayList<Student>();
        for (int i = 0; i < students.size(); i++){
            result.add(students.get(i));
        }

        return result;

//        return this.students;
    }

    public void add(Student st) {
        // check id
        this.students.add(st);
    }

    public void delete(String id) {
        for (int i = 0; i < students.size(); i++){
            if (id.equals(students.get(i).getId())){
                //delete
                students.remove(i);
            }
        }
    }

    public void updateName (String name, String id){
        for (int i = 0; i < students.size(); i++){
            if (id.equals(students.get(i).getId())){
                students.get(i).setName(name);
            }
        }
    }

    public void updateGpa (float gpa, String id){
        for (int i = 0; i < students.size(); i++){
            if (id.equals(students.get(i).getId())){
                students.get(i).setGpa(gpa);
            }
        }
    }

    public void updateAddress (String address, String id){
        for (int i = 0; i < students.size(); i++){
            if (id.equals(students.get(i).getId())){
                students.get(i).setAddress(address);
            }
        }
    }

    public void updateNote (String node, String id){
        for (int i = 0; i < students.size(); i++){
            if (id.equals(students.get(i).getId())){
                students.get(i).setNotes(node);
            }
        }
    }

    public void printStudents(){
        ArrayList<Student> result = this.getStudents();
        for (int i = 0; i < result.size(); i++){
            System.out.println("ID: " + result.get(i).getId());
            System.out.println("Name: " + result.get(i).getName());
            System.out.println("GPA: " + result.get(i).getGpa());
            System.out.println("Address: " + result.get(i).getAddress());
            System.out.println("Notes: " + result.get(i).getNotes());
            System.out.println("-------------------------------------");
        }
    }

    public void printStudentByID(){
        ArrayList<Student> ss = new ArrayList<Student>();
        ss = this.getStudents();
        ArrayList<Student> result = new ArrayList<Student>();
        Handle handle = new Handle();

        while (ss.isEmpty() != true) {
            int pos = handle.findMinID(ss);
            Student add = ss.get(pos);
            ss.remove(pos);
            result.add(add);
        }

        for (int i = 0; i < result.size(); i++){
            System.out.println("ID: " + result.get(i).getId());
            System.out.println("Name: " + result.get(i).getName());
            System.out.println("GPA: " + result.get(i).getGpa());
            System.out.println("Address: " + result.get(i).getAddress());
            System.out.println("Notes: " + result.get(i).getNotes());
            System.out.println("-------------------------------------");
        }
    }

    public void printStudentByGPA(){
        ArrayList<Student> ss = new ArrayList<Student>();
        ss = this.getStudents();
        ArrayList<Student> result = new ArrayList<Student>();
        Handle handle = new Handle();

        while (ss.isEmpty() != true) {
            int pos = handle.findMinGPA(ss);
            Student add = ss.get(pos);
            ss.remove(pos);
            result.add(add);
        }

        for (int i = 0; i < result.size(); i++){
            System.out.println("ID: " + result.get(i).getId());
            System.out.println("Name: " + result.get(i).getName());
            System.out.println("GPA: " + result.get(i).getGpa());
            System.out.println("Address: " + result.get(i).getAddress());
            System.out.println("Notes: " + result.get(i).getNotes());
            System.out.println("-------------------------------------");
        }
    }



}
