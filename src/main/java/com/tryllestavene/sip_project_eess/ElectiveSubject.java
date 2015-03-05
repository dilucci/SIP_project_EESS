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
    private final ElectiveSubjectInterface subjectIF;
    private String title;
    private String description;
    private String proposedTeacher;
    private int firstPriorityCount;
    private int secondPriorityCount;

    public ElectiveSubject(ElectiveSubjectInterface subjectIF, String title, String description, String proposedTeacher, int firstPriorityCount, int secondPriorityCount) {
        this.subjectIF = subjectIF;
        this.title = title;
        this.description = description;
        this.proposedTeacher = proposedTeacher;
        this.firstPriorityCount = firstPriorityCount;
        this.secondPriorityCount = secondPriorityCount;
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

    public int getFirstPriorityCount() {
        return firstPriorityCount;
    }

    public void setFirstPriorityCount(int firstPriorityCount) {
        this.firstPriorityCount = firstPriorityCount;
    }

    public int getSecondPriorityCount() {
        return secondPriorityCount;
    }

    public void setSecondPriorityCount(int secondPriorityCount) {
        this.secondPriorityCount = secondPriorityCount;
    }
    
}
