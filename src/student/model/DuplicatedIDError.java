/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.model;

/**
 *
 * @author Eli
 */
public class DuplicatedIDError extends RuntimeException{
    
    public DuplicatedIDError(String message) {
        super(message);
    }
    
}
