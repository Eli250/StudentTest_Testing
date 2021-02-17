/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.tests;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;

/**
 *
 * @author Eli
 */
public class AbstractTestCase {

    public static void executeOperation(Operation operation) {
        try {
            DbSetup dbSetup = new DbSetup(new DriverManagerDestination("jdbc:postgresql://localhost:5432/student_db", "eli", "eli"),
                    operation);
            dbSetup.launch();
        } catch (Exception e) {
            throw e;
        }
    }
}
