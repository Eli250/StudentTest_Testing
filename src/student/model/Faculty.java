/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Eli
 */
@Entity
public class Faculty implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "faculty_name", unique = true)
    private String name;
    @OneToMany(mappedBy = "faculty", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Department> department;

    public Faculty(String name) {
        this.name = name;
    }
    public Faculty(){
        
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }

    
}
