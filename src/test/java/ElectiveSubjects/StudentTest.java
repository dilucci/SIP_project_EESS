/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectiveSubjects;

import Entities.ElectiveSubject;
import Entities.Student;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class StudentTest {
    private static ElectiveSubject subject1;
    private static ElectiveSubject subject2;
    private static ElectiveSubject subject3;
    private static ElectiveSubject subject4;
    
    public StudentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        subject1 = new ElectiveSubject("Android", "nice", "Peter");
        subject2 = new ElectiveSubject("C#", "fedt", "Torben");
        subject3 = new ElectiveSubject("Arduino", "sejt", "Tobias");
        subject4 = new ElectiveSubject("Game", "awesome", "Henrik");
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

   @Test
   public void testCreateStudent() throws Exception {
       Student student1 = new Student("Sebucci","Lucci");
       assertThat(student1.getFirstName(),is("Sebucci"));
       assertThat(student1.getLastName(),is("Lucci"));
   }
   
   @Test
   public void testAddPrioSubject() throws Exception {
       Student student1 = new Student("Sebucci","Lucci");
       student1.addFirstPrioSubject(subject1);
       assertThat(student1.getFirstPriosList().size(), is(1));
       student1.addFirstPrioSubject(subject2);
       assertThat(student1.getFirstPriosList().size(), is(2));
       student1.addSecondPrioSubject(subject3);
       assertThat(student1.getSecondPriosList().size(), is(1));
       student1.addSecondPrioSubject(subject4);
       assertThat(student1.getSecondPriosList().size(), is(2));
   }
   
   @Test
   public void testAddPrioSubjectAlreadyExisting() throws Exception {
       Student student1 = new Student("Sebucci","Lucci");
       student1.addFirstPrioSubject(subject1);
       assertThat(student1.getFirstPriosList().size(), is(1));
       student1.addFirstPrioSubject(subject1);
       assertThat(student1.getFirstPriosList().size(), is(1));
   }
   
   @Test
   public void testAddPrioSubjectMoreThanTwoSubjects() throws Exception {
       Student student1 = new Student("Sebucci","Lucci");
       student1.addFirstPrioSubject(subject1);
       assertThat(student1.getFirstPriosList().size(), is(1));
       student1.addFirstPrioSubject(subject2);
       assertThat(student1.getFirstPriosList().size(), is(2));
       assertThat(student1.addFirstPrioSubject(subject3),is(false));
       assertThat(student1.getFirstPriosList().size(), is(2));
   }
}
