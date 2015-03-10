/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tryllestavene.sip_project_eess;

import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Student {

    private String firstName;
    private String lastName;
    private ArrayList<ElectiveSubject> firstPriosList;
    private ArrayList<ElectiveSubject> secondPriosList;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList getFirstPriosList() {
        return firstPriosList;
    }

    public boolean addFirstPrioSubject(ElectiveSubject subject) {
        if (firstPriosList.size() < 2) {
            if (!firstPriosList.contains(subject)) {
                firstPriosList.add(subject);
                return true;
            }
        }
        return false;
    }

    public ArrayList getSecondPriosList() {
        return secondPriosList;
    }

    public boolean addSecondPrioSubject(ElectiveSubject subject) {
        if (secondPriosList.size() < 2) {
            if (!secondPriosList.contains(subject)) {
                secondPriosList.add(subject);
                return true;
            }
        }
        return false;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        firstPriosList = new ArrayList();
        secondPriosList = new ArrayList();
    }

}
