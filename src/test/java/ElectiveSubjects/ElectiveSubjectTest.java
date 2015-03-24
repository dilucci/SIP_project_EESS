/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectiveSubjects;

import Entities.ElectiveSubject;
import static org.hamcrest.CoreMatchers.is;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Seb
 */
public class ElectiveSubjectTest {
    private final Mockery context = new JUnitRuleMockery();
    
    public ElectiveSubjectTest() {
    }
    
    @Test
    public void testCreateElectiveSubject () throws Exception {
        //final ElectiveSubjectInterface subjectIF = context.mock(ElectiveSubjectInterface.class);
        ElectiveSubject subject = new ElectiveSubject("Android", "sygt det er sejt det android", "Peter");
        assertThat(subject.getTitle(), is("Android"));
    }
}
