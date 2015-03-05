/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tryllestavene.sip_project_eess;

import java.util.ArrayList;

public class Controller {
    private ArrayList<ElectiveSubject> subjectList;
    private ArrayList<ElectiveSubject> poolAList;
    private ArrayList<ElectiveSubject> poolBList;
    
    public Controller() {
        subjectList = new ArrayList();
        poolAList = new ArrayList<>();
        poolBList = new ArrayList();
    }

    public boolean insertIntoPoolA(ElectiveSubject subject) {
        if (!poolAList.contains(subject)) {
            poolAList.add(subject);
            return true;
        }
        return false;
    }
    
    public boolean insertIntoPoolB(ElectiveSubject subject) {
        if (!poolBList.contains(subject)) {
            poolBList.add(subject);
            return true;
        }
        return false;
    }

    public ArrayList<ElectiveSubject> getPoolA() {
        return poolAList;
    }

    public ArrayList<ElectiveSubject> getPoolB() {
        return poolBList;
    }
    
    
    
}
