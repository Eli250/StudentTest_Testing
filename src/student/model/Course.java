/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Eli
 */
@Entity
public class Course implements Serializable {
    @Id
    @Column(name="course_code", length = 10)
    private String code;
    @Column(name = "course_name")
    private String name;
    private int credits;
    
    @ManyToOne
    @JoinColumn(name="dept_id")
    private Department department;

    @ManyToMany(mappedBy = "registeredCourses")
    private List<Student> student;

    public Course() {
    }

    public Course(String code, String name, int credits, Department department) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.department = department;
    }

    public Course(Department department) {
        this.department = department;
    }

    public Course(List<Student> student) {
        this.student = student;
    }
       
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return code + " - " + name;
    }
    
    
}
