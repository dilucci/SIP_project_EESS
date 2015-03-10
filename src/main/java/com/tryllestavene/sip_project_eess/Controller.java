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
    private ArrayList<ElectiveSubject> subjectFinalList;
    private ArrayList<Student> studentList;
    private ArrayList<Student> validVoteStudentList;
    
    public Controller() {
        subjectList = new ArrayList();
        poolAList = new ArrayList();
        poolBList = new ArrayList();
        subjectFinalList = new ArrayList();
        studentList = new ArrayList();
        validVoteStudentList = new ArrayList();
    }
    
    public void initialize(){
        Student student1 = new Student("Bjarke","Carlsen");
        Student student2 = new Student("Emil","Christiansen");
        Student student3 = new Student("Jesper","Dahl");
        Student student4 = new Student("Kenn","Jacobsen");
        Student student5 = new Student("Aske","Rode");
        Student student6 = new Student("Thor","Kristensen");
        Student student7 = new Student("Patrick","Larsen");
        Student student8 = new Student("Johan","Leu");
        Student student9 = new Student("Jesper","Olsen");
        Student student10 = new Student("Martin","Olgenkjær");
        Student student11 = new Student("Henrik","Stavnem");
        Student student12 = new Student("Nicklas","Thomsen");
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        studentList.add(student8);
        studentList.add(student9);
        studentList.add(student10);
        studentList.add(student11);
        studentList.add(student12);
        ElectiveSubject subject1 = new ElectiveSubject("C#", "sejt", "Torben");
        ElectiveSubject subject2 = new ElectiveSubject("Python", "sejt", "Ulrik");
        ElectiveSubject subject3 = new ElectiveSubject("Android", "sejt", "Peter");
        ElectiveSubject subject4 = new ElectiveSubject("SW Design", "sejt", "Frederik");
        ElectiveSubject subject5 = new ElectiveSubject("Games", "sejt", "Michael");
        ElectiveSubject subject6 = new ElectiveSubject("Databases", "sejt", "Henrik");
        ElectiveSubject subject7 = new ElectiveSubject("Test", "sejt", "Sebastian");
        ElectiveSubject subject8 = new ElectiveSubject("Arduino", "sejt", "Tobias");
        insertIntoPool("s", subject1);
        insertIntoPool("s", subject2);
        insertIntoPool("s", subject3);
        insertIntoPool("s", subject4);
        insertIntoPool("s", subject5);
        insertIntoPool("s", subject6);
        insertIntoPool("s", subject7);
        insertIntoPool("s", subject8);
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
        
        //insert into subjectFinalList(2st round) if string = f
        if(pool.toLowerCase().equals("f")){
            if (!subjectFinalList.contains(subject)) {
            subjectFinalList.add(subject);
            return true;
            }
        }

        return false;
    }
    
    public void setSubjectListFinal(ArrayList<ElectiveSubject> list) {
        subjectFinalList = list;
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
        
        //remove from subjectFinalList(2st round) if string = f
        if(pool.toLowerCase().equals("f")){
            if (subjectFinalList.contains(subject)) {
            subjectFinalList.remove(subject);
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
        return subjectFinalList;
    }
    
    public void calculate(ArrayList poolA, ArrayList poolB){
        if (true) {
            
        }
    }
    
    public boolean acceptStudentVote(Student student) {
        System.out.println("HALLO");
        if (student.getFirstPriosList().size() == 2 && student.getSecondPriosList().size() == 2) {
            System.out.println("NICE");
            validVoteStudentList.add(student);
            return true;
        }
        return false;
    }

    public ArrayList getValidVoteStudentList() {
        return validVoteStudentList;
    }
}
