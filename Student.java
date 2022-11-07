public class Student {
    //private:
    private String id;
    private String name;
    private float gpa;
    private String address;
    private String notes;

    public Student(String id, String name, float gpa, String address, String notes) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.address = address;
        this.notes = notes;
    }

    //getter setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
