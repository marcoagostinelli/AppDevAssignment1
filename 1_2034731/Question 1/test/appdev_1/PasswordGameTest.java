/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdev_1;

import java.util.regex.Pattern;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marco
 */
public class PasswordGameTest {

    public PasswordGameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of genRandNumbers method, of class PasswordGame.
     */
    @Test
    public void testGenRandNumbers() {
        System.out.println("genRandNumbers");
        PasswordGame instance = new PasswordGame();
        int[] result = instance.genRandNumbers();
        if (result.length != 3) {
            fail("invalid random array");
        }
        //this method simply generates an array of 3 numbers
    }

    /**
     * Test of newPasswordGen method, of class PasswordGame.
     */
    @Test
    public void testNewPasswordGen() {
        System.out.println("newPasswordGen");
        PasswordGame instance = new PasswordGame();
        instance.genRandNumbers();//get the random array of numbers
        if (instance.password.contains("\n") || instance.password.length() == 1) {
            fail("method did not detect newLine or single character");
        }
    }

    /**
     * Test of checkForEqual method, of class PasswordGame.
     */
    @Test
    public void testCheckForEqual() {
        System.out.println("checkForEqual");
        PasswordGame instance = new PasswordGame();
        boolean result = instance.checkForEqual();
        boolean expResult;
        if (instance.pass1.equals(instance.pass2) || instance.pass1.equals(instance.pass3) || instance.pass2.equals(instance.pass3)) {
            expResult = false;
        }else{
            expResult = true;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of checkForLength method, of class PasswordGame.
     */
    @Test
    public void testCheckForLength() {
        System.out.println("checkForLength");
        PasswordGame instance = new PasswordGame();
        boolean result = instance.checkForLength();
        boolean expResult;
        if (instance.password.length() < 8 || instance.password.length() > 15) {
            expResult = false;
        }else{
            expResult = true;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of checkForUpperCase method, of class PasswordGame.
     */
    @Test
    public void testCheckForUpperCase() {
        System.out.println("checkForUpperCase");
        PasswordGame instance = new PasswordGame();
        boolean result = instance.checkForUpperCase();
        boolean expResult;
        if (!Pattern.matches(".*[A-Z].*", instance.password)) {
            expResult = false;
        }else{
            expResult = true;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of checkForLowerCase method, of class PasswordGame.
     */
    @Test
    public void testCheckForLowerCase() {
        System.out.println("checkForLowerCase");
        PasswordGame instance = new PasswordGame();
        boolean result = instance.checkForLowerCase();
        boolean expResult;
        if (!Pattern.matches(".*[a-z].*", instance.password)) {
            expResult = false;
        }else{
            expResult = true;
        }
        assertEquals(expResult, result);

    }

    /**
     * Test of checkForSpecialCharacter method, of class PasswordGame.
     */
    @Test
    public void testCheckForSpecialCharacter() {
        System.out.println("checkForSpecialCharacter");
        PasswordGame instance = new PasswordGame();
        boolean expResult = false;
        boolean result = instance.checkForSpecialCharacter();
        if (!Pattern.matches("\\w*\\W\\w*", instance.password)) {
            expResult = false;
        }else{
            expResult = true;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of resetConditions method, of class PasswordGame.
     */
    @Test
    public void testResetConditions() {
        System.out.println("resetConditions");
        PasswordGame instance = new PasswordGame();
        instance.resetConditions();
        if (instance.newLine !=0 && instance.single !=0&& instance.equal !=0&&
                instance.length !=0&& instance.upper !=0&& instance.lower !=0&&
                instance.special!=0){
            fail("method did not set every variable to 0");
        }
    }

}
