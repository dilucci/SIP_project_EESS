/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectiveSubjects;

import com.tryllestavene.sip_project_eess.Controller;
import com.tryllestavene.sip_project_eess.ElectiveSubject;
import com.tryllestavene.sip_project_eess.ElectiveSubjectInterface;
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
    private Controller controller;
    private ArrayList<ElectiveSubject> subjectList;
    private ArrayList<ElectiveSubject> poolAList;
    private ArrayList<ElectiveSubject> poolBList;
    
    
    public ControllerTest() {
    }
    
    @Before
    public void setUp() {
        final ElectiveSubjectInterface subjectIF = context.mock(ElectiveSubjectInterface.class);
        subject1 = new ElectiveSubject(subjectIF, "Android", "nice", "Peter", 2, 1);
        subject2 = new ElectiveSubject(subjectIF, "C#", "fedt", "Torben", 1, 2);
        subject3 = new ElectiveSubject(subjectIF, "Arduino", "sejt", "Tobias", 0, 0);
        
        controller = new Controller();
        subjectList = new ArrayList();
        poolAList = new ArrayList();
        poolBList = new ArrayList();
    }
    
    @Test
    public void testInsertIntoPool() throws Exception {
        controller.insertIntoPoolA(subject1);
        assertThat(controller.getPoolA().contains(subject1), is(true));
        assertThat(controller.getPoolA().size(), is(1));
        
        controller.insertIntoPoolA(subject2);
        assertThat(controller.getPoolA().contains(subject2), is(true));
        assertThat(controller.getPoolA().size(), is(2));
        
        controller.insertIntoPoolB(subject3);
        assertThat(controller.getPoolB().contains(subject3), is(true));
        assertThat(controller.getPoolB().size(), is(1));
    }
}
