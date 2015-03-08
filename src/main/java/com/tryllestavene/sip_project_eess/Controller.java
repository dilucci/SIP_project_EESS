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
    private ArrayList<ElectiveSubject> subjectListFinal;
    
    public Controller() {
        subjectList = new ArrayList();
        poolAList = new ArrayList();
        poolBList = new ArrayList();
        subjectListFinal = new ArrayList();
    }
    
    public void initialize(){
        ElectiveSubject subject1 = new ElectiveSubject("Android", "nice", "Peter", 2, 1);
        ElectiveSubject subject2 = new ElectiveSubject("C#", "fedt", "Torben", 1, 2);
        ElectiveSubject subject3 = new ElectiveSubject("Arduino", "sejt", "Tobias", 0, 0);
        insertIntoPool("s", subject1);
        insertIntoPool("s", subject2);
        insertIntoPool("s", subject3);
    }

    public boolean insertIntoPool(String pool, ElectiveSubject subject){
        if(pool.toLowerCase().equals("a")){
            if(!poolAList.contains(subject)) {
            poolAList.add(subject);
            return true;
             }
        }
        
        //insert into poolB if string = b
        if(pool.toLowerCase().equals("b")){
            if(!poolBList.contains(subject)) {
            poolBList.add(subject);
            return true;
            }
        }
        
        //insert into subjectList(1st round) if string = s
        if(pool.toLowerCase().equals("s")){
            if (!subjectList.contains(subject)) {
            subjectList.add(subject);
            return true;
            }
        }
        
        //insert into subjectListFinal(2st round) if string = f
        if(pool.toLowerCase().equals("f")){
            if (!subjectListFinal.contains(subject)) {
            subjectListFinal.add(subject);
            return true;
            }
        }

        return false;
    }
    
    public void setSubjectListFinal(ArrayList<ElectiveSubject> list) {
        subjectListFinal = list;
    }
    
    public boolean removeFromPool(String pool, ElectiveSubject subject){
        //remove from poolA if string = a
        if(pool.toLowerCase().equals("a")){
            if (poolAList.contains(subject)) {
            poolAList.remove(subject);
            return true;
            }
        }
        
        //remove from poolB if string = b
        if(pool.toLowerCase().equals("b")){
            if (poolBList.contains(subject)) {
            poolBList.remove(subject);
            return true;
            }
        }
        
        //remove from subjectList(1st round) if string = s
        if(pool.toLowerCase().equals("s")){
            if (subjectList.contains(subject)) {
            subjectList.remove(subject);
            return true;
            }
        }
        
        //remove from subjectListFinal(2st round) if string = f
        if(pool.toLowerCase().equals("f")){
            if (subjectListFinal.contains(subject)) {
            subjectListFinal.remove(subject);
            return true;
            }
        }
        
        return false;
    }

    
    public ArrayList<ElectiveSubject> getPoolA() {
        return poolAList;
    }

    public ArrayList<ElectiveSubject> getPoolB() {
        return poolBList;
    }
    
    public ArrayList<ElectiveSubject> getAllSubjects() {
        return subjectList;
    }
    
    public ArrayList<ElectiveSubject> getAllSubjectsFinal() {
        return subjectListFinal;
    }
}
