/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.tryllestavene.sip_project_eess.Controller;
import com.tryllestavene.sip_project_eess.ElectiveSubject;
import com.tryllestavene.sip_project_eess.Student;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emilovich
 */
public class GUI_Main extends javax.swing.JFrame {

    private Controller ctr;
    private ArrayList<ElectiveSubject> subjectList;
    private DefaultListModel subjectListModel;
    private DefaultListModel subjectListFinalModel;
    private DefaultListModel selectedFirstPrioritiesModel;
    private DefaultListModel selectedSecondPrioritiesModel;
    private DefaultTableModel subjectsFinalTableModel;
    private DefaultTableModel poolASubjectsTableModel;
    private DefaultTableModel poolBSubjectsTableModel;
    private DefaultTableModel studentsTableModel;
    private DefaultComboBoxModel studentsModel;

    public GUI_Main() {
        ctr = new Controller();
        initComponents();
        subjectListModel = new DefaultListModel();
        subjectListFinalModel = new DefaultListModel();
        subjectsFinalTableModel = new DefaultTableModel();
        poolASubjectsTableModel = new DefaultTableModel();
        poolBSubjectsTableModel = new DefaultTableModel();
        studentsTableModel = new DefaultTableModel();
        selectedFirstPrioritiesModel = new DefaultListModel();
        selectedSecondPrioritiesModel = new DefaultListModel();
        studentsModel = new DefaultComboBoxModel();
        refreshSubjectsFinalTableHOP();

        initUI();

    }

    private void initUI() {
        ctr.initialize(); //initializes program with dummy objects
        initComboBox();
        refreshListsHOP();
        initializeTablesHOP();
    }

    private void initComboBox() {
        ArrayList<Student> students = ctr.getAllStudents();
        for (Student student : students) {
            studentsModel.addElement(student);
        }
        jComboBoxStudents.setModel(studentsModel);
    }

    private void refreshListsStudent() {
        subjectListFinalModel.clear();
        selectedFirstPrioritiesModel.clear();
        selectedSecondPrioritiesModel.clear();
        ArrayList<ElectiveSubject> subjectListFinal = ctr.getAllSubjectsFinal();
        for (ElectiveSubject subject : subjectListFinal) {
            subjectListFinalModel.addElement(subject);
        }
        jListElectiveSubjectStudent.setModel(subjectListFinalModel);
    }

    private void initializeTablesHOP() {
        subjectsFinalTableModel.setColumnCount(0);
        subjectsFinalTableModel.addColumn("Subject");
        subjectsFinalTableModel.addColumn("1st");
        subjectsFinalTableModel.addColumn("2nd");

        studentsTableModel.setColumnCount(0);
        studentsTableModel.addColumn("Name");
        studentsTableModel.addColumn("1st");
        studentsTableModel.addColumn("2nd");
        studentsTableModel.addColumn("Satisfaction");

        poolASubjectsTableModel.setColumnCount(0);
        poolASubjectsTableModel.addColumn("Subject");
        poolASubjectsTableModel.addColumn("1st");
        poolASubjectsTableModel.addColumn("2nd");

        poolBSubjectsTableModel.setColumnCount(0);
        poolBSubjectsTableModel.addColumn("Subject");
        poolBSubjectsTableModel.addColumn("1st");
        poolBSubjectsTableModel.addColumn("2nd");
    }

    private void refreshListsHOP() {
        subjectList = ctr.getAllSubjects();
        subjectListModel.clear();
        subjectListFinalModel.clear();
        for (ElectiveSubject subject : subjectList) {
            subjectListModel.addElement(subject);
        }
        jListSuggestedSubjects.setModel(subjectListModel);
        jListSuggestedSubjectsFinal.setModel(subjectListFinalModel);
    }

    private void refreshSubjectsFinalTableHOP() {
        subjectsFinalTableModel.setRowCount(0);
        subjectsFinalTableModel.getDataVector().removeAllElements();
        subjectsFinalTableModel.fireTableDataChanged();
        ArrayList<ElectiveSubject> subjectListFinal;
        subjectListFinal = ctr.getAllSubjectsFinal();
        for (ElectiveSubject subject : subjectListFinal) {
            Object[] electiveSubjectArray = new Object[3];
            electiveSubjectArray[0] = subject;
            electiveSubjectArray[1] = subject.getFirstPrioCounter();
            electiveSubjectArray[2] = subject.getSecondPrioCounter();
            subjectsFinalTableModel.addRow(electiveSubjectArray);
        }
        jTableSubjectsFinalHOP.setModel(subjectsFinalTableModel);
    }

    private void refreshStudentTableHOP() {
        studentsTableModel.setRowCount(0);
        studentsTableModel.getDataVector().removeAllElements();
        studentsTableModel.fireTableDataChanged();
        ArrayList<Student> studentList;
        studentList = ctr.getAllStudents();
        for (Student student : studentList) {
            Object[] studentsArray = new Object[4];
            studentsArray[0] = student.getFirstName() + " " + student.getLastName();
            studentsArray[1] = student.getFirstPriosList();
            studentsArray[2] = student.getSecondPriosList();
            studentsArray[3] = student.getSatisfaction();
            studentsTableModel.addRow(studentsArray);
        }
        jTableStudentsHOP.setModel(studentsTableModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTeacher = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTitle = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButtonSaveSuggestionSTUD = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBoxStudents = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListElectiveSubjectStudent = new javax.swing.JList();
        jButtonSelectFirstPrio = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButtonSelectSecondPrio = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jListFirstPriorities = new javax.swing.JList();
        jScrollPane9 = new javax.swing.JScrollPane();
        jListSecondPriorities = new javax.swing.JList();
        jButtonSaveSelectedPriorities = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonDeSelectFirstPrio = new javax.swing.JButton();
        jButtonDeSelectSecondPrio = new javax.swing.JButton();
        jLabelSelectionStatus = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jButton2ndRoundSelect = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldTeacherHOP = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldTitleHOP = new javax.swing.JTextField();
        jLabelStatusHOP = new javax.swing.JLabel();
        jButtonSaveNewSuggestionHOP = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaDescriptionHOP = new javax.swing.JTextArea();
        jButtonAddSubjectsHOP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSuggestedSubjects = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jButtonRemoveSubjectsHOP = new javax.swing.JButton();
        jButtonSaveSuggestedSubjects = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jListSuggestedSubjectsFinal = new javax.swing.JList();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableSubjectsFinalHOP = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTablePoolB = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTablePoolA = new javax.swing.JTable();
        jButtonAddToPoolAHOP = new javax.swing.JButton();
        jButtonRemoveFromPoolAHOP = new javax.swing.JButton();
        jButtonAddToPoolBHOP = new javax.swing.JButton();
        jButtonRemoveFromPoolBHOP = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTableStudentsHOP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1115, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Teacher", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Teacher: ");

        jLabel1.setText("Suggestion to elective subjects");

        jTextFieldTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTeacherActionPerformed(evt);
            }
        });

        jLabel3.setText("Title:");

        jLabel4.setText("Description:");

        jTextFieldTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTitleActionPerformed(evt);
            }
        });

        jLabel10.setText("Label for confirmation");

        jButtonSaveSuggestionSTUD.setText("Save Suggestion");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jComboBoxStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStudentsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(78, 78, 78)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldTitle)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(89, 89, 89)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextFieldTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(jButtonSaveSuggestionSTUD)
                                    .addGap(477, 477, 477))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(353, 353, 353))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jComboBoxStudents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(58, 58, 58)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSaveSuggestionSTUD)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("Selection of elective subjects 1st Round");

        jScrollPane3.setViewportView(jListElectiveSubjectStudent);

        jButtonSelectFirstPrio.setText("+");
        jButtonSelectFirstPrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectFirstPrioActionPerformed(evt);
            }
        });

        jLabel17.setText("Please select beneath which subject you want for next semester");

        jLabel18.setText("select two prio in each list. (Note: Two exactly)");

        jButtonSelectSecondPrio.setText("+");
        jButtonSelectSecondPrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectSecondPrioActionPerformed(evt);
            }
        });

        jScrollPane8.setViewportView(jListFirstPriorities);

        jScrollPane9.setViewportView(jListSecondPriorities);

        jButtonSaveSelectedPriorities.setText("Submit selection");
        jButtonSaveSelectedPriorities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveSelectedPrioritiesActionPerformed(evt);
            }
        });

        jLabel6.setText("First priorities:");

        jLabel7.setText("Second Priorities:");

        jButtonDeSelectFirstPrio.setText("-");
        jButtonDeSelectFirstPrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeSelectFirstPrioActionPerformed(evt);
            }
        });

        jButtonDeSelectSecondPrio.setText("-");
        jButtonDeSelectSecondPrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeSelectSecondPrioActionPerformed(evt);
            }
        });

        jLabelSelectionStatus.setText("....");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel11)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jButtonSelectFirstPrio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonDeSelectFirstPrio))
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jButtonSelectSecondPrio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonDeSelectSecondPrio))
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addContainerGap(98, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSelectionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jButtonSaveSelectedPriorities)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSelectSecondPrio)
                    .addComponent(jButtonSelectFirstPrio)
                    .addComponent(jButtonDeSelectFirstPrio)
                    .addComponent(jButtonDeSelectSecondPrio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSelectionStatus)
                .addGap(18, 18, 18)
                .addComponent(jButtonSaveSelectedPriorities)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setText("Selection of elective subjects 2nd Round");

        jScrollPane5.setViewportView(jList4);

        jLabel15.setText("Pool A");

        jLabel16.setText("Pool B");

        jScrollPane6.setViewportView(jList5);

        jButton2ndRoundSelect.setText("Save Selection");

        jLabel20.setText("Please select beneath which subject you want for next semester");

        jLabel19.setText("select two prio in each list. (Note: Two exactly)");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jButton2ndRoundSelect)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel15)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addComponent(jButton2ndRoundSelect)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student", jPanel2);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("Teacher: ");

        jLabel13.setText("Suggestion to elective subjects");

        jTextFieldTeacherHOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTeacherHOPActionPerformed(evt);
            }
        });

        jLabel21.setText("Title:");

        jLabel22.setText("Description:");

        jTextFieldTitleHOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTitleHOPActionPerformed(evt);
            }
        });

        jLabelStatusHOP.setText("Label for confirmation");

        jButtonSaveNewSuggestionHOP.setText("Save Suggestion");
        jButtonSaveNewSuggestionHOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveNewSuggestionHOPActionPerformed(evt);
            }
        });

        jTextAreaDescriptionHOP.setColumns(20);
        jTextAreaDescriptionHOP.setRows(5);
        jScrollPane4.setViewportView(jTextAreaDescriptionHOP);

        jButtonAddSubjectsHOP.setText(">>");
        jButtonAddSubjectsHOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddSubjectsHOPActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListSuggestedSubjects);

        jLabel5.setText("List of suggested subjects");

        jButtonRemoveSubjectsHOP.setText("<<");
        jButtonRemoveSubjectsHOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveSubjectsHOPActionPerformed(evt);
            }
        });

        jButtonSaveSuggestedSubjects.setText("save");
        jButtonSaveSuggestedSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveSuggestedSubjectsActionPerformed(evt);
            }
        });

        jScrollPane12.setViewportView(jListSuggestedSubjectsFinal);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabelStatusHOP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSaveSuggestedSubjects))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addGap(78, 78, 78)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldTitleHOP)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(89, 89, 89)
                                    .addComponent(jTextFieldTeacherHOP, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel13)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButtonAddSubjectsHOP)
                                            .addComponent(jButtonRemoveSubjectsHOP))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(15, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSaveNewSuggestionHOP)
                .addGap(78, 78, 78))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldTitleHOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTeacherHOP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSaveNewSuggestionHOP)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAddSubjectsHOP)
                        .addGap(27, 27, 27)
                        .addComponent(jButtonRemoveSubjectsHOP)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatusHOP, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSaveSuggestedSubjects, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableSubjectsFinalHOP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Subject", "1st", "2nd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSubjectsFinalHOP.setColumnSelectionAllowed(true);
        jScrollPane7.setViewportView(jTableSubjectsFinalHOP);
        jTableSubjectsFinalHOP.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTableSubjectsFinalHOP.getColumnModel().getColumnCount() > 0) {
            jTableSubjectsFinalHOP.getColumnModel().getColumn(0).setResizable(false);
            jTableSubjectsFinalHOP.getColumnModel().getColumn(1).setResizable(false);
            jTableSubjectsFinalHOP.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(jTable2);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(403, 403, 403)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTablePoolB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Subject", "1st", "2nd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePoolB.setColumnSelectionAllowed(true);
        jScrollPane11.setViewportView(jTablePoolB);
        jTablePoolB.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTablePoolB.getColumnModel().getColumnCount() > 0) {
            jTablePoolB.getColumnModel().getColumn(0).setResizable(false);
            jTablePoolB.getColumnModel().getColumn(1).setResizable(false);
            jTablePoolB.getColumnModel().getColumn(2).setResizable(false);
        }

        jTablePoolA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Subject", "1st", "2nd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePoolA.setColumnSelectionAllowed(true);
        jScrollPane13.setViewportView(jTablePoolA);
        jTablePoolA.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTablePoolA.getColumnModel().getColumnCount() > 0) {
            jTablePoolA.getColumnModel().getColumn(0).setResizable(false);
            jTablePoolA.getColumnModel().getColumn(1).setResizable(false);
            jTablePoolA.getColumnModel().getColumn(2).setResizable(false);
        }

        jButtonAddToPoolAHOP.setText("+");
        jButtonAddToPoolAHOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddToPoolAHOPActionPerformed(evt);
            }
        });

        jButtonRemoveFromPoolAHOP.setText("-");
        jButtonRemoveFromPoolAHOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveFromPoolAHOPActionPerformed(evt);
            }
        });

        jButtonAddToPoolBHOP.setText("+");
        jButtonAddToPoolBHOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddToPoolBHOPActionPerformed(evt);
            }
        });

        jButtonRemoveFromPoolBHOP.setText("-");
        jButtonRemoveFromPoolBHOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveFromPoolBHOPActionPerformed(evt);
            }
        });

        jLabel8.setText("Pool A");

        jLabel9.setText("Pool B");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButtonAddToPoolAHOP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoveFromPoolAHOP))
                            .addComponent(jLabel8))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jButtonAddToPoolBHOP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoveFromPoolBHOP))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(396, 396, 396)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(462, 462, 462)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(463, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(92, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddToPoolAHOP)
                            .addComponent(jButtonRemoveFromPoolAHOP)
                            .addComponent(jButtonAddToPoolBHOP)
                            .addComponent(jButtonRemoveFromPoolBHOP))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableStudentsHOP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "1st Prio", "2nd Prio", "Satisfaction"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(jTableStudentsHOP);
        if (jTableStudentsHOP.getColumnModel().getColumnCount() > 0) {
            jTableStudentsHOP.getColumnModel().getColumn(0).setResizable(false);
            jTableStudentsHOP.getColumnModel().getColumn(1).setResizable(false);
            jTableStudentsHOP.getColumnModel().getColumn(2).setResizable(false);
            jTableStudentsHOP.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 457, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Head of program", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTeacherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTeacherActionPerformed

    private void jTextFieldTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTitleActionPerformed

    private void jTextFieldTitleHOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTitleHOPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTitleHOPActionPerformed

    private void jTextFieldTeacherHOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTeacherHOPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTeacherHOPActionPerformed

    private void jButtonSaveNewSuggestionHOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveNewSuggestionHOPActionPerformed
        String title;
        String description;
        String teacher;

        if (jTextFieldTitleHOP.getText().length() > 0 && jTextAreaDescriptionHOP.getText().length() > 0 && jTextFieldTeacherHOP.getText().length() > 0) {
            title = jTextFieldTitleHOP.getText();
            description = jTextAreaDescriptionHOP.getText();
            teacher = jTextFieldTeacherHOP.getText();
            ElectiveSubject subject = new ElectiveSubject(title, description, teacher);
            ctr.insertIntoPool("s", subject);
            refreshListsHOP();
        }
        else {
            jLabelStatusHOP.setText("All fields must be filled.");
        }
    }//GEN-LAST:event_jButtonSaveNewSuggestionHOPActionPerformed

    private void jButtonAddSubjectsHOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddSubjectsHOPActionPerformed
        if (jListSuggestedSubjects.getSelectedValue() != null) {
            ElectiveSubject subject = (ElectiveSubject) jListSuggestedSubjects.getSelectedValue();
            subjectListFinalModel.addElement(subject);
            subjectListModel.removeElement(subject);
        }

    }//GEN-LAST:event_jButtonAddSubjectsHOPActionPerformed

    private void jButtonRemoveSubjectsHOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveSubjectsHOPActionPerformed
        if (jListSuggestedSubjectsFinal.getSelectedValue() != null) {
            ElectiveSubject subject = (ElectiveSubject) jListSuggestedSubjectsFinal.getSelectedValue();
            subjectListModel.addElement(subject);
            subjectListFinalModel.removeElement(subject);
        }
    }//GEN-LAST:event_jButtonRemoveSubjectsHOPActionPerformed

    private void jButtonSaveSuggestedSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveSuggestedSubjectsActionPerformed
        ArrayList<ElectiveSubject> suggestedSubjectList = new ArrayList();
        for (int i = 0; i < subjectListFinalModel.size(); i++) {
            suggestedSubjectList.add((ElectiveSubject) subjectListFinalModel.getElementAt(i));
        }
        ctr.setSubjectListFinal(suggestedSubjectList);
        refreshSubjectsFinalTableHOP();
        jListElectiveSubjectStudent.setModel(subjectListFinalModel);
    }//GEN-LAST:event_jButtonSaveSuggestedSubjectsActionPerformed

    private void jButtonDeSelectSecondPrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeSelectSecondPrioActionPerformed
        if (jListSecondPriorities.getSelectedValue() != null) {
            ElectiveSubject subject = (ElectiveSubject) jListSecondPriorities.getSelectedValue();
            subjectListFinalModel.addElement(subject);
            selectedSecondPrioritiesModel.removeElement(subject);
        }
    }//GEN-LAST:event_jButtonDeSelectSecondPrioActionPerformed

    private void jButtonDeSelectFirstPrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeSelectFirstPrioActionPerformed
        if (jListFirstPriorities.getSelectedValue() != null) {
            ElectiveSubject subject = (ElectiveSubject) jListFirstPriorities.getSelectedValue();
            subjectListFinalModel.addElement(subject);
            selectedFirstPrioritiesModel.removeElement(subject);
        }
    }//GEN-LAST:event_jButtonDeSelectFirstPrioActionPerformed

    private void jButtonSaveSelectedPrioritiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveSelectedPrioritiesActionPerformed
        if (selectedSecondPrioritiesModel.size() == 2 && selectedFirstPrioritiesModel.size() == 2) {
            Student student = (Student) jComboBoxStudents.getSelectedItem();
            for (int i = 0; i < selectedFirstPrioritiesModel.size(); i++) {
                student.addFirstPrioSubject((ElectiveSubject) selectedFirstPrioritiesModel.getElementAt(i));
            }
            for (int i = 0; i < selectedSecondPrioritiesModel.size(); i++) {
                student.addSecondPrioSubject((ElectiveSubject) selectedSecondPrioritiesModel.getElementAt(i));
            }
            if (ctr.submitStudentVote(student)) {
                jComboBoxStudents.removeItem(jComboBoxStudents.getSelectedItem());
                refreshSubjectsFinalTableHOP();
                jLabelSelectionStatus.setText("Selection submitted!");
            }
            else {
                jLabelSelectionStatus.setText("Submission failed");
            }
            System.out.println(student);
            System.out.println(student.getFirstPriosList());
            System.out.println(student.getSecondPriosList());
            System.out.println(ctr.getValidVoteStudentList());
        }
        else {
            jLabelSelectionStatus.setText("You must have 2 subjects for each priority.");
        }
    }//GEN-LAST:event_jButtonSaveSelectedPrioritiesActionPerformed

    private void jButtonSelectSecondPrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectSecondPrioActionPerformed
        if (jListElectiveSubjectStudent.getSelectedValue() != null) {
            if (selectedSecondPrioritiesModel.size() < 2) {
                ElectiveSubject subject = (ElectiveSubject) jListElectiveSubjectStudent.getSelectedValue();
                selectedSecondPrioritiesModel.addElement(subject);
                jListSecondPriorities.setModel(selectedSecondPrioritiesModel);
                subjectListFinalModel.removeElement(subject);
            }
            else {
                jLabelSelectionStatus.setText("Select only 2 subjects");
            }
        }
    }//GEN-LAST:event_jButtonSelectSecondPrioActionPerformed

    private void jButtonSelectFirstPrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectFirstPrioActionPerformed
        if (jListElectiveSubjectStudent.getSelectedValue() != null) {
            if (selectedFirstPrioritiesModel.size() < 2) {
                ElectiveSubject subject = (ElectiveSubject) jListElectiveSubjectStudent.getSelectedValue();
                selectedFirstPrioritiesModel.addElement(subject);
                jListFirstPriorities.setModel(selectedFirstPrioritiesModel);
                subjectListFinalModel.removeElement(subject);
            }
            else {
                jLabelSelectionStatus.setText("Select only 2 subjects");
            }
        }
    }//GEN-LAST:event_jButtonSelectFirstPrioActionPerformed

    private void jComboBoxStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStudentsActionPerformed
        refreshListsStudent();
    }//GEN-LAST:event_jComboBoxStudentsActionPerformed

    private void jButtonAddToPoolAHOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddToPoolAHOPActionPerformed
        if (jTableSubjectsFinalHOP.getSelectedRow() > -1) {
            int selectedRowIndex = jTableSubjectsFinalHOP.getSelectedRow();
            if (subjectsFinalTableModel.getValueAt(selectedRowIndex, 0) instanceof ElectiveSubject) {
                ElectiveSubject subject = (ElectiveSubject) subjectsFinalTableModel.getValueAt(selectedRowIndex, 0);
                Object[] subjects = new Object[3];
                subjects[0] = subject;
                subjects[1] = subject.getFirstPrioCounter();
                subjects[2] = subject.getSecondPrioCounter();
                poolASubjectsTableModel.addRow(subjects);
                jTablePoolA.setModel(poolASubjectsTableModel);
            }
        }
    }//GEN-LAST:event_jButtonAddToPoolAHOPActionPerformed

    private void jButtonRemoveFromPoolAHOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveFromPoolAHOPActionPerformed
        if (jTablePoolA.getSelectedRow() > -1) {
            int selectedRowIndex = jTablePoolA.getSelectedRow();
            poolASubjectsTableModel.removeRow(selectedRowIndex);
        }
    }//GEN-LAST:event_jButtonRemoveFromPoolAHOPActionPerformed

    private void jButtonAddToPoolBHOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddToPoolBHOPActionPerformed
        //VIRKER IKKE ENDNU!!
        
        if (jTableSubjectsFinalHOP.getSelectedRow() > -1) {
            int selectedRowIndex = jTableSubjectsFinalHOP.getSelectedRow();
            if (subjectsFinalTableModel.getValueAt(selectedRowIndex, 0) instanceof ElectiveSubject) {
                boolean alreadyExists = false;
                ElectiveSubject chosenSubject = (ElectiveSubject) subjectsFinalTableModel.getValueAt(selectedRowIndex, 0);
                ElectiveSubject existingSubject;
                for (int i = 0; i < poolBSubjectsTableModel.getRowCount(); i++) {
                    existingSubject = (ElectiveSubject) subjectsFinalTableModel.getValueAt(i, 0);
                    if (chosenSubject == existingSubject) {
                        alreadyExists = true;
                    }
                }
                if (!alreadyExists) {
                    ElectiveSubject subject = (ElectiveSubject) subjectsFinalTableModel.getValueAt(selectedRowIndex, 0);
                    Object[] subjects = new Object[3];
                    subjects[0] = subject;
                    subjects[1] = subject.getFirstPrioCounter();
                    subjects[2] = subject.getSecondPrioCounter();
                    poolBSubjectsTableModel.addRow(subjects);
                    jTablePoolB.setModel(poolBSubjectsTableModel);
                }
            }
        }
    }//GEN-LAST:event_jButtonAddToPoolBHOPActionPerformed

    private void jButtonRemoveFromPoolBHOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveFromPoolBHOPActionPerformed
        if (jTablePoolB.getSelectedRow() > -1) {
            int selectedRowIndex = jTablePoolB.getSelectedRow();
            poolBSubjectsTableModel.removeRow(selectedRowIndex);
        }
    }//GEN-LAST:event_jButtonRemoveFromPoolBHOPActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2ndRoundSelect;
    private javax.swing.JButton jButtonAddSubjectsHOP;
    private javax.swing.JButton jButtonAddToPoolAHOP;
    private javax.swing.JButton jButtonAddToPoolBHOP;
    private javax.swing.JButton jButtonDeSelectFirstPrio;
    private javax.swing.JButton jButtonDeSelectSecondPrio;
    private javax.swing.JButton jButtonRemoveFromPoolAHOP;
    private javax.swing.JButton jButtonRemoveFromPoolBHOP;
    private javax.swing.JButton jButtonRemoveSubjectsHOP;
    private javax.swing.JButton jButtonSaveNewSuggestionHOP;
    private javax.swing.JButton jButtonSaveSelectedPriorities;
    private javax.swing.JButton jButtonSaveSuggestedSubjects;
    private javax.swing.JButton jButtonSaveSuggestionSTUD;
    private javax.swing.JButton jButtonSelectFirstPrio;
    private javax.swing.JButton jButtonSelectSecondPrio;
    private javax.swing.JComboBox jComboBoxStudents;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSelectionStatus;
    private javax.swing.JLabel jLabelStatusHOP;
    private javax.swing.JList jList4;
    private javax.swing.JList jList5;
    private javax.swing.JList jListElectiveSubjectStudent;
    private javax.swing.JList jListFirstPriorities;
    private javax.swing.JList jListSecondPriorities;
    private javax.swing.JList jListSuggestedSubjects;
    private javax.swing.JList jListSuggestedSubjectsFinal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTablePoolA;
    private javax.swing.JTable jTablePoolB;
    private javax.swing.JTable jTableStudentsHOP;
    private javax.swing.JTable jTableSubjectsFinalHOP;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaDescriptionHOP;
    private javax.swing.JTextField jTextFieldTeacher;
    private javax.swing.JTextField jTextFieldTeacherHOP;
    private javax.swing.JTextField jTextFieldTitle;
    private javax.swing.JTextField jTextFieldTitleHOP;
    // End of variables declaration//GEN-END:variables
}
