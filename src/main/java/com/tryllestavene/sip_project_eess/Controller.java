/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tryllestavene.sip_project_eess;

import Entities.Student;
import Entities.ElectiveSubject;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

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

    public void initialize() {
        Student student1 = new Student("Bjarke", "Carlsen");
        Student student2 = new Student("Emil", "Christiansen");
        Student student3 = new Student("Jesper", "Dahl");
        Student student4 = new Student("Kenn", "Jacobsen");
        Student student5 = new Student("Aske", "Rode");
        Student student6 = new Student("Thor", "Kristensen");
        Student student7 = new Student("Patrick", "Larsen");
        Student student8 = new Student("Johan", "Leu");
        Student student9 = new Student("Jesper", "Olsen");
        Student student10 = new Student("Martin", "Olgenkjær");
        Student student11 = new Student("Henrik", "Stavnem");
        Student student12 = new Student("Nicklas", "Thomsen");
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

    public boolean insertIntoPool(String pool, ElectiveSubject subject) {
        if (pool.toLowerCase().equals("a")) {
            if (!poolAList.contains(subject)) {
                poolAList.add(subject);
                return true;
            }
        }

        //insert into poolB if string = b
        if (pool.toLowerCase().equals("b")) {
            if (!poolBList.contains(subject)) {
                poolBList.add(subject);
                return true;
            }
        }

        //insert into subjectList(1st round) if string = s
        if (pool.toLowerCase().equals("s")) {
            if (!subjectList.contains(subject)) {
                subjectList.add(subject);
                return true;
            }
        }

        //insert into subjectFinalList(2st round) if string = f
        if (pool.toLowerCase().equals("f")) {
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
    
    public void setPoolLists(ArrayList<ElectiveSubject> poolA, ArrayList<ElectiveSubject> poolB) {
        poolAList = poolA;
        poolBList = poolB;
    }

    public boolean removeFromPool(String pool, ElectiveSubject subject) {
        //remove from poolA if string = a
        if (pool.toLowerCase().equals("a")) {
            if (poolAList.contains(subject)) {
                poolAList.remove(subject);
                return true;
            }
        }

        //remove from poolB if string = b
        if (pool.toLowerCase().equals("b")) {
            if (poolBList.contains(subject)) {
                poolBList.remove(subject);
                return true;
            }
        }

        //remove from subjectList(1st round) if string = s
        if (pool.toLowerCase().equals("s")) {
            if (subjectList.contains(subject)) {
                subjectList.remove(subject);
                return true;
            }
        }

        //remove from subjectFinalList(2st round) if string = f
        if (pool.toLowerCase().equals("f")) {
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

    public ArrayList calculateSatisfaction(ArrayList<ElectiveSubject> poolA, ArrayList<ElectiveSubject> poolB) {
        int satisfaction = 0;
        System.out.println("PoolA: " + poolA);
        System.out.println("PoolB: " + poolB);
        
        if (!validVoteStudentList.isEmpty() && !poolA.isEmpty() && !poolB.isEmpty()) {
            
        
        for (Student student : validVoteStudentList) {
            ArrayList<ElectiveSubject> first = student.getFirstPriosList();
            ArrayList<ElectiveSubject> second = student.getSecondPriosList();

            //if (a = 1st || a = 2nd || b = 1st || b = 2nd)
            if ((poolA.contains(first.get(0)) || poolA.contains(first.get(1))) || (poolB.contains(first.get(0)) || poolB.contains(first.get(1)))
                    || (poolA.contains(second.get(0)) || poolA.contains(second.get(1))) || (poolB.contains(second.get(0)) || poolB.contains(second.get(1)))) {

                //if (a = 1st || b = 1st)
                if ((poolA.contains(first.get(0)) || poolA.contains(first.get(1))) || (poolB.contains(first.get(0)) || poolB.contains(first.get(1)))) {
                    
                    //if (a = 1st && b = 1st)
                    if ((poolA.contains(first.get(0)) || poolA.contains(first.get(1))) && (poolB.contains(first.get(0)) || poolB.contains(first.get(1)))) {
                        satisfaction = 3;
                    }
                    
                    //else if (a = 2nd || b = 2nd)
                    else {
                        if ((poolA.contains(second.get(0)) || poolA.contains(second.get(1))) || (poolB.contains(second.get(0)) || poolB.contains(second.get(1)))) {
                            satisfaction = 2;
                        }
                        
                        //else (a = 0 || b = 0)
                        else {
                            satisfaction = -1;
                        }
                    }
                }
                
                //else if (a = 2nd || b = 2nd)
                else {
                    if ((poolA.contains(second.get(0)) || poolA.contains(second.get(1))) || (poolB.contains(second.get(0)) || poolB.contains(second.get(1)))) {
                        
                        //if (a = 2st && b = 2st)
                        if ((poolA.contains(second.get(0)) || poolA.contains(second.get(1))) && (poolB.contains(second.get(0)) || poolB.contains(second.get(1)))) {
                            satisfaction = 1;
                        }
                        
                        //else (a = 0 || b = 0)
                        else {
                            satisfaction = -2;
                        }
                    }
                }
            }
            
            //else 0,0,0,0
            else {
                satisfaction = -3;
            }
            student.setSatisfaction(satisfaction);
            System.out.println(student.getFirstName() + " " + student.getSatisfaction());
        }
        }
        return validVoteStudentList;
    }

    public boolean submitStudentVote(Student student) {
        if (student.getFirstPriosList().size() == 2 && student.getSecondPriosList().size() == 2) {
            validVoteStudentList.add(student);
            return true;
        }
        return false;
    }

    public ArrayList getValidVoteStudentList() {
        return validVoteStudentList;
    }

    public ArrayList<Student> getAllStudents() {
        return studentList;
    }

    public ElectiveSubject getSubject(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
