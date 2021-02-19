package student.tests;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import student.dao.GenericDao;
import student.model.Course;
import student.model.Department;
import student.model.Faculty;
import student.model.Gender;
import student.model.Student;
import student.util.HibernateInit;

/**
 *
 * @author Eli
 */
public class GeneralStudentTests extends AbstractTestCase {

    GenericDao<Course> courseDao = new GenericDao<>(Course.class);
    GenericDao<Department> departmentDao = new GenericDao<>(Department.class);
    GenericDao<Faculty> facultyDao = new GenericDao<>(Faculty.class);
    GenericDao<Student> studentDao = new GenericDao<>(Student.class);

    @BeforeTest
    public void startDataBase() {
        System.out.println("Starting Database ... Creating Tables");
        HibernateInit.getSessionFactory();
    }

    @BeforeMethod
    public void initializeTestData() {
        System.err.println("Initializing Test Data ... ");
        executeOperation(DataOperations.INSERT_FACULTY);
        executeOperation(DataOperations.INSERT_DEPT);
        executeOperation(DataOperations.INSERT_COURSE);
        executeOperation(DataOperations.INSERT_STUDENT);
    }

    @Test
    public void testFindAll() {
        System.err.println("Finding All Students");
        List<Student> st = studentDao.findAll();
        Assert.assertEquals(st.size(), 4);
    }

    @Test
    public void testFindOne() {
        Student st = studentDao.findById("22012");
        Assert.assertEquals(st.getEmailAddress(), "hirwa@gmail.com");
    }
   @Test
    public void testUpdateStudent() {
        Student s = studentDao.findById("22012");
        s.setName("Billy Mugaba");
        String msg = studentDao.update(s);
        Assert.assertEquals(msg, "Updated Successfully!");
    }
    @Test
    public void testUpdateCourse(){
        Course c = courseDao.findById("INSY317");
        c.setName("Programming with PL/SQL");
        String msg= courseDao.update(c);
        Assert.assertEquals(msg, "Updated Successfully!");
    }
        @Test
    public void testUpdateDepartment(){
        Department d = departmentDao.findById("NETW");
        d.setName("Networks and Communication Systems");
        String msg= departmentDao.update(d);
        Assert.assertEquals(msg, "Updated Successfully!");
    }
    @Test
    public void testCreateFaculty() {
        Faculty f = new Faculty();
        f.setName("Media Production");
        String msg = facultyDao.create(f);
        Assert.assertEquals(msg, "Success");
    }
      @Test
    public void testUpdateFaculty() {
        Faculty f = facultyDao.findById(401);
        f.setName("Religion and Theology");
        String msg = facultyDao.update(f);
        Assert.assertEquals(msg, "Updated Successfully!");
    }

    @Test
    public void testCreateDepartment() {
        Department d = new Department();
        d.setName("Video Coverage");
        d.setDepId("MD01");
        GenericDao<Faculty> facDao = new GenericDao<>(Faculty.class);
        Faculty df = facDao.findById(5);
        d.setFaculty(df);
        String msg = departmentDao.create(d);
        Assert.assertEquals(msg, "Success");
    }

    @Test
    public void testCreateCourse() {
        Course c = new Course();
        c.setCode("INSY411");
        c.setName("Computer Networks");
        c.setCredits(4);
        Department d = departmentDao.findById("NETW");
        c.setDepartment(d);
        String msg = courseDao.create(c);
        Assert.assertEquals(msg, "Success");
    }

    @Test
    public void testCreateStudent() {
        Student st = new Student();
        st.setName("Tuyishimire Evelyne");
        st.setStudentId("22222");
        st.setGender(Gender.FEMALE);
        st.setEmailAddress("evelyne@unilak.ac.rw");
        st.setDateOfBirth(LocalDate.of(1997, Month.OCTOBER, 12));
        Department d = departmentDao.findById("LITR");
        st.setDepartment(d);
        String msg = studentDao.create(st);
        Assert.assertEquals(msg, "Success");
    }


    @Test
    public void testStudentRegistration() {
        Course c1 = courseDao.findById("INSY317");
        Course c2 = courseDao.findById("COSC421");
        Course c3 = courseDao.findById("ENGL123");

        Student st1 = studentDao.findById("22012");
        Student st2 = studentDao.findById("22226");
        Student st3 = studentDao.findById("19785");

        st1.registerCourse(c1);
        st1.registerCourse(c2);
        st1.registerCourse(c3);

        st2.registerCourse(c1);
        st2.registerCourse(c2);

        st3.registerCourse(c2);
        st2.registerCourse(c3);

        studentDao.update(st1);
        studentDao.update(st2);
        studentDao.update(st3);

        Student st = studentDao.findById("22012");
        List<Course> regCourses = st.getRegisteredCourses();
        Assert.assertEquals(regCourses.size(), 3);
    }
 
    @AfterMethod
    public void cleanTestData() {
        System.err.println("Cleaning Test Data ...");
        executeOperation(DataOperations.DELETE_REG);
        executeOperation(DataOperations.DELETE_STUD);
        executeOperation(DataOperations.DELETE_COURSE);
        executeOperation(DataOperations.DELETE_DEPT);
        executeOperation(DataOperations.DELETE_FAC);
    }
}
