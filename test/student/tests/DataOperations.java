package student.tests;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Eli
 */
public class DataOperations {
    public static Operation INSERT_FACULTY = Operations.insertInto("faculty")
            .columns("id","faculty_name")
            .values(101,"Information Technology")
            .values(201,"Business Administration")
            .values(301,"Education")
            .values(401,"Theology")
            .build();
    public static Operation INSERT_DEPT = Operations.insertInto("department")
            .columns("dept_id","dept_name","faculty_name")
            .values("SFT","SOFTWARE ENGINEERING",101)
            .values("NETW","NETWORKS",101)
            .values("LITR","Literature",301)
            .build();
    public static Operation INSERT_COURSE = Operations.insertInto("course")
            .columns("course_code","credits","course_name","dept_id")
            .values("INSY317",4,"PL/SQL","SFT")
            .values("COSC421",4,"TCP/IP","NETW")
            .values("ENGL123",3,"English Grammar","LITR")
            .build();
    public static Operation INSERT_STUDENT = Operations.insertInto("student")
            .columns("stud_id","dateofbirth","email","gender","name","phone","dept_id")
            .values("22012",LocalDate.of(1996, Month.JULY, 25),"hirwa@gmail.com","MALE","Hirwa Mugaba Eli","0788394168","SFT")
            .values("22226",LocalDate.of(1998, Month.MARCH, 6),"josh@gmail.com","MALE","Ishimwe Joshua","0781394168","SFT")
            .values("22634",LocalDate.of(2001, Month.NOVEMBER, 25),"divine@gmail.com","FEMALE","UWASE Divine","0782394168","NETW")
            .values("19785",LocalDate.of(1999, Month.JANUARY, 12),"queen@gmail.com","FEMALE","Kereen Queen","0783394168","LITR")
            .build();
    public static Operation DELETE_REG = Operations.deleteAllFrom("registration");
    public static Operation DELETE_FAC = Operations.deleteAllFrom("faculty");
    public static Operation DELETE_DEPT = Operations.deleteAllFrom("department");
    public static Operation DELETE_COURSE = Operations.deleteAllFrom("course");
    public static Operation DELETE_STUD = Operations.deleteAllFrom("student");
}
