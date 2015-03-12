/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectiveSubjects;

import com.tryllestavene.sip_project_eess.Controller;
import com.tryllestavene.sip_project_eess.ElectiveSubject;
import com.tryllestavene.sip_project_eess.ElectiveSubjectInterface;
import com.tryllestavene.sip_project_eess.Student;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.is;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Seb
 */
public class ControllerTest {
    private final Mockery context = new JUnitRuleMockery();
    private ElectiveSubject subject1;
    private ElectiveSubject subject2;
    private ElectiveSubject subject3;
    private ElectiveSubject subject4;
    private ElectiveSubject subject5;
    private ElectiveSubject subject6;
    private ElectiveSubject subject7;
    private ElectiveSubject subject8;
    private Student student1;
    private Student student2;
    private Student student3;
    private Controller controller;
//    private ArrayList<ElectiveSubject> subjectList;
//    private ArrayList<ElectiveSubject> poolAList;
//    private ArrayList<ElectiveSubject> poolBList;
    
    
    public ControllerTest() {
    }
    
    @Before
    public void setUp() {
        //final ElectiveSubjectInterface subjectIF = context.mock(ElectiveSubjectInterface.class);
        subject1 = new ElectiveSubject("Android", "nice", "Peter");
        subject2 = new ElectiveSubject("C#", "fedt", "Torben");
        subject3 = new ElectiveSubject("Arduino", "sejt", "Tobias");
        subject4 = new ElectiveSubject("Game", "awesome", "Henrik");
        subject5 = new ElectiveSubject("Games", "sejt", "Michael");
        subject6 = new ElectiveSubject("Databases", "sejt", "Henrik");
        subject7 = new ElectiveSubject("Test", "sejt", "Sebastian");
        subject8 = new ElectiveSubject("Arduino", "sejt", "Tobias");
        
        student1 = new Student("Martin","Olgenkjær");
        student2 = new Student("Henrik","Stavnem");
        student3 = new Student("Nicklas","Thomsen");
        
        controller = new Controller();
//        subjectList = new ArrayList();
//        poolAList = new ArrayList();
//        poolBList = new ArrayList();
    }
    
    @Test
    public void testInsertIntoPool() throws Exception {
        controller.insertIntoPool("a", subject1);
        assertThat(controller.getPoolA().contains(subject1), is(true));
        assertThat(controller.getPoolA().size(), is(1));
        
        controller.insertIntoPool("a", subject2);
        assertThat(controller.getPoolA().contains(subject2), is(true));
        assertThat(controller.getPoolA().size(), is(2));
        
        controller.insertIntoPool("b", subject3);
        assertThat(controller.getPoolB().contains(subject3), is(true));
        assertThat(controller.getPoolB().size(), is(1));
    }
    
    @Test
    public void testInsertIntoPoolObjAlreadyExists() throws Exception {
        assertThat(controller.insertIntoPool("a", subject1), is(true));
        assertThat(controller.getPoolA().size(), is(1));
        //insert object, which already exists and check if size is still 1
        assertThat(controller.insertIntoPool("a", subject1), is(false));
        assertThat(controller.getPoolA().size(), is(1));
    }
    
    @Test
    public void removeFromPool() throws Exception {
        assertThat(controller.insertIntoPool("a", subject1), is(true));
        assertThat(controller.insertIntoPool("a", subject2), is(true));
        assertThat(controller.getPoolA().size(), is(2));
        assertThat(controller.removeFromPool("a", subject1), is(true));
        assertThat(controller.getPoolA().size(), is(1));
        assertThat(controller.getPoolA().contains(subject1), is(false));
    }
    
    @Test
    public void removeFromPoolNonExisting() throws Exception {
        assertThat(controller.removeFromPool("a", subject1), is(false));
    }
    
    @Test
    public void testAcceptStudentVote() throws Exception {
        student1.addFirstPrioSubject(subject1);
        student1.addFirstPrioSubject(subject2);
        student1.addSecondPrioSubject(subject3);
        student1.addSecondPrioSubject(subject4);
        assertThat(controller.acceptStudentVote(student1),is(true));
        assertThat(controller.getValidVoteStudentList().size(),is(1));
    }
    
    @Test
    public void testAcceptStudentVoteInvalid() throws Exception {
        student1.addFirstPrioSubject(subject1);
        student1.addFirstPrioSubject(subject2);
        student1.addSecondPrioSubject(subject3);
        assertThat(controller.acceptStudentVote(student1),is(false));
        assertThat(controller.getValidVoteStudentList().size(),is(0));
    }
    
    @Test
    public void calculateSatisfaction() throws Exception {
        student1.addFirstPrioSubject(subject1); //happy 1.1 (+3) //Android
        student1.addFirstPrioSubject(subject2); //C#
        student1.addSecondPrioSubject(subject3); //Arduino
        student1.addSecondPrioSubject(subject4); //Game
        assertThat(controller.acceptStudentVote(student1),is(true));
        
        student2.addFirstPrioSubject(subject4); //less happy 1.2 (+2)
        student2.addFirstPrioSubject(subject2);
        student2.addSecondPrioSubject(subject3);
        student2.addSecondPrioSubject(subject1);
        assertThat(controller.acceptStudentVote(student2),is(true));
        
        student3.addFirstPrioSubject(subject7); //angry 0.0 (-3)
        student3.addFirstPrioSubject(subject6);
        student3.addSecondPrioSubject(subject8);
        student3.addSecondPrioSubject(subject5);
        assertThat(controller.acceptStudentVote(student3),is(true));
        
        controller.insertIntoPool("a", subject1);
        controller.insertIntoPool("a", subject3);
        controller.insertIntoPool("b", subject4);
        controller.insertIntoPool("b", subject2);
        assertThat(controller.calculate(controller.getPoolA(), controller.getPoolB()).size(), is(3));
        assertThat(student1.getSatisfaction(),is(3));
        assertThat(student2.getSatisfaction(),is(2));
        assertThat(student3.getSatisfaction(),is(-3));
    }
}
