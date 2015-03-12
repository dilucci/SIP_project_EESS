/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tryllestavene.sip_project_eess;

/**
 *
 * @author Seb
 */
public class ElectiveSubject {
    //private final ElectiveSubjectInterface subjectIF;
    private String title;
    private String description;
    private String proposedTeacher;
    private int firstPrioCounter;
    private int secondPrioCounter;

    public int getFirstPrioCounter() {
        return firstPrioCounter;
    }

    public void incrementFirstPrio() {
        firstPrioCounter = firstPrioCounter + 1;
    }

    public int getSecondPrioCounter() {
        return secondPrioCounter;
    }

    public void incrementSecondPrioCounter() {
        secondPrioCounter = secondPrioCounter + 1;
    }

    public ElectiveSubject(String title, String description, String proposedTeacher) {
        //this.subjectIF = subjectIF;
        this.title = title;
        this.description = description;
        this.proposedTeacher = proposedTeacher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProposedTeacher() {
        return proposedTeacher;
    }

    public void setProposedTeacher(String proposedTeacher) {
        this.proposedTeacher = proposedTeacher;
    }
    
    @Override
    public String toString() {
        return title;
    }
    
}
