package eu.iris.ms.school;

import java.util.ArrayList;
import java.util.List;

public class Student {
    protected String studentId ;
    protected String firstName ;
    protected String lastName;
    protected String email ;
    protected int age ;
    protected List<Double> grades;

    public Student (String studentId, String firstName, String lastName ,String email ,int age){
        if(studentId == null || studentId.isBlank()) throw new IllegalArgumentException ("Student ID cannot be null or empty");
        if (!studentId.matches("STU[0-9]{3}")) throw new IllegalArgumentException ("Student ID must match pattern STU### (e.g., STU001)");
        if(firstName == null || firstName.isBlank()) throw new IllegalArgumentException ("First name cannot be null or empty");
        if(firstName.trim().length() < 2) throw new IllegalArgumentException ("First name must be at least 2 characters long");
        if(lastName == null || lastName.isBlank()) throw new IllegalArgumentException ("First name cannot be null or empty");
        if(lastName.trim().length() < 2) throw new IllegalArgumentException ("First name must be at least 2 characters long");
        if(email == null || !email.contains("@") || !email.substring(email.indexOf("@")).contains(".") ) throw new IllegalArgumentException ("Invalid email format");
        if(age < 16 || age > 65 ) throw new IllegalArgumentException ("Age must be between 16 and 65");

        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.grades = new ArrayList<>();

    }

    public void addGrade(double grade) throws  IllegalArgumentException {
        if(grade < 0.0 || grade > 20.0) throw new IllegalArgumentException ("Grade must be between 0 and 20");
        this.grades.add(grade);
    }

    public double getAverageGrade() throws IllegalStateException {
        if(grades.size() < 1.0 ) throw new IllegalStateException ("Cannot calculate average: no grades available");
        double total = 0;

        for (double grade : grades) {
            total += grade;
        }

        return total / grades.size();
    }

    public int getGradeCount() {
        return grades.size();
    }

    public boolean hasPassingGrade(){
        if(this.grades.isEmpty()) return false;
        if(this.getAverageGrade() < 10) return false;

        return true;

    }
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public double getBestGrade(){
        if(this.grades.isEmpty()) return 0.0;
        double bestGrade = 0;

        for (double grade : grades) {
            if(grade > bestGrade) bestGrade = grade;
        }
        return bestGrade;
    }

    public double getWorstGrade(){
        if(this.grades.isEmpty()) return 0.0;
        double bestGrade = 20.0;

        for (double grade : grades) {
            if(grade < bestGrade) bestGrade = grade;
        }
        return bestGrade;
    }
    public List<Double> getGrades(){
        return new ArrayList<>(this.grades);
    }
}
