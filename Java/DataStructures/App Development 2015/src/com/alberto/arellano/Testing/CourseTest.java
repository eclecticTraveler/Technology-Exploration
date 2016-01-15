package com.alberto.arellano.Testing;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Field;

/**
 * Created by rome on 10/29/2015.
 */
public class CourseTest {
    Course testCourse;
    StudentBean alberto, hansol, lloyd, evan;
    ProfessorBean barney, barzee, jackson, erickson;

    @Before
    public void startUp() throws  Exception{

        testCourse = new Course();

        alberto = new StudentBean("Alberto","Arellano",26, "A", "936630292", "Senior");
        hansol  = new StudentBean("Hansol","SomeLastName",27, "A+", "555555555", "Junior");
        lloyd   = new StudentBean("Lloyd","Something",28, "A++", "66666666","Senior");
        evan    = new StudentBean("Evan",null,29, "A+++", "7777777", "Senior");

        barney   = new ProfessorBean(null,"Barney",50, "Programming", "x2449");
        barzee   = new ProfessorBean("Rex","Barzee",51, "Programming", "x2446");
        jackson  = new ProfessorBean("Ken","Jackson",52, "Programming", "x2445");
        erickson = new ProfessorBean("Roberto","Erickson",53, "Networking", "x2447");

    }
    @Test
    public void testGetCount(){

    }

    @Test
    public void testAddStudentProfile(){

        // Start with 2
        testCourse.addStudentProfile(alberto);
        testCourse.addStudentProfile(lloyd);
        int numOfStudents = testCourse.getCount();
        assertEquals(2, numOfStudents);

        // Repeat the instance
        testCourse.addStudentProfile(lloyd);
        numOfStudents = testCourse.getCount();
        assertEquals(3, numOfStudents);

        // What if it has a null value hope it does not add it
        testCourse.addStudentProfile(null);
        numOfStudents = testCourse.getCount();
        assertNotEquals(4, numOfStudents);

        // What if a user has a null value it should NOT add it
        testCourse.addStudentProfile(evan);
        numOfStudents = testCourse.getCount();
        assertEquals(3, numOfStudents);



    }
    @Test
    public void testCourseId() {
        try {
            Course aCourseTest = new Course();
            Field idField = Course.class.getDeclaredField("uniqueId");
            idField.setAccessible(true);
            String anId = (String)idField.get(aCourseTest);
            assertEquals("93663", anId);
        }catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException ex)
        {
            ex.printStackTrace();
        }


//        Person aPerson = new Person();
//        Field theNameField = Person.class.getDeclaredField("name");
//        theNameField.setAccessible(true);
//        String aName = (String)theNameField.get(aPerson);
//// aName could be tested for a specific value here
//        assertEquals("bob", aName);
//// or modified as in the line of code below.
//        aName = "Ungala";
    }
    @Test
    public void testSessionId(){

        try {
            // Set a private Variable
            Course aCourseTestTwo = new Course();
            Field sessionField = Course.class.getDeclaredField("sessionId");
            sessionField.setAccessible(true);
            String aSessionId = (String)sessionField.get(aCourseTestTwo);
            aSessionId = "123456789";
            assertEquals("123456789", aSessionId);
        }catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException ex)
        {
            ex.printStackTrace();
        }

    }
    @Test
    public void testRemoveStudentProfile(){
        testCourse.addStudentProfile(alberto);
        testCourse.addStudentProfile(lloyd);
        testCourse.addStudentProfile(hansol);
        // Delete by iNumber
        boolean wasDeleted = testCourse.removeStudentProfile("936630292");
        assertEquals(true, wasDeleted);
        // Another way to do the one above it evaluates as True
        assertTrue(wasDeleted);

    }


    // Make sure that an exception was succesfully thrown
    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddProfessorsProfile(){
        testCourse.addProfessorsProfile(-1, barney);

    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void throwsNothing() {
        // no exception expected, none thrown: passes.
    }

    @Test
    public void throwsExceptionWithSpecificType() {
        thrown.expect(NullPointerException.class);
        throw new NullPointerException();
    }


    //    @Test
//    public void testGetProfessorsName(){}


//   @Rule public ExpectedException thrown = ExpectedException.none();
//    @Test
//    public void testAddProfessorsProfile(){
//        thrown.expect(Exception.class);
//        thrown.expectMessage("Can't have nulls");
//
//        testCourse.addProfessorsProfile(barney);
//
//    }

//    @Test(expected = Exception.class)
//    public void testAddProfessorsProfile(){
//
//        testCourse.addProfessorsProfile(barney);
//
//    }
}
