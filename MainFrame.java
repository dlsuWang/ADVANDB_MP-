/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package advandb;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSetMetaData;
import javax.swing.*;

/**
 *
 * @author Nikko
 */
public class MainFrame extends JFrame{
    
    private JPanel pnlQueries, pnlVariations, pnlUserInputs, pnlMessage;
    private JLabel lblChooseQuery, lblChooseVariation, lblSupplyInformation, lblEstimatedTime;
    private JButton btnQuery1, btnQuery2, btnQuery3, btnQuery4, btnQuery5, btnQuery6, btnQuery7, infoQuery, btnExecute;
    private ButtonGroup bgVariations;
    private JRadioButton rbNormal, rbHeuristics, rbIndexes, rbViews, rbStoredProcedure;
    private TablePanel tpDataTable;
    private ImageIcon iconinfo;
    private Image imgScaledIcon;
    private Controller controller;
    /*****USER INPUTS 1*****/
    private JPanel pnl_User_Query1, pnl_User_Query2, pnl_User_Query3, pnl_User_Query4, pnl_User_Query5, pnl_User_Query6, pnl_User_Query7;
    private JRadioButton rbMale, rbFemale, rbPublicSch, rbPrivateSch, rbSSS, rbGSIS, rbBothAgency, rbNeitherAgency, rbBothSch, rbBothSex;
    private ButtonGroup bgSex, bgSchoolType, bgAgency;
    /*****USER INPUTS 1*****/
    /*****USER INPUTS 2*****/
    private JCheckBox chCalam1, chCalam2, chCalam3, chCalam4, chCalam5, chCalam6, chCalam7, chCalam8, chCalam9, chCalam10, chCalam11;
    private JTextField txtCalam1, txtCalam2, txtCalam3, txtCalam4, txtCalam5, txtCalam6, txtCalam7, txtCalam8, txtCalam9, txtCalam10, txtCalam11;
    /*****USER INPUTS 2*****/
    /*****USER INPUTS 3*****/
    private JRadioButton rbMale2, rbFemale2,rbBothSex2, rbCollege, rbMasters, rbYes1, rbNo1, rbYes2, rbNo2, rbIDK, rbEmployed, rbUnemployed;
    private ButtonGroup bgSex2, bgEduc, bgRegVote, bgJobInd, bgVotedLast;
    private JComboBox cbWorkCl, cbDeath;
    private String[] stWorkCl = {"Working for private household","Working for private business/establishment/farm","Working for government/corporation","Self-employed without any employee","Employer in own family-operated or business","Working with pay on family-operated or business","Working without pay on family-operated or business"};
    private String[] stDeath = {"Diseases of the heart","Diseases of the vascular system", "Pneumonia", "Tuberculosis", "Cancer","Diarrhea", "Measles","Complication during pregnancy or childbirth","Accident (ex. hit by a vehicle)", "Diabetes", "Disease of the lungs", "Disease of the kidney","Drowned from flood","Victim of landslide","Electrocuted during typhoon","Murder","Others" };
    /*****USER INPUTS 3*****/
    /*****USER INPUTS 4*****/
    private JCheckBox chAgriEquip1, chAgriEquip2, chAgriEquip3, chAgriEquip4, chAgriEquip5, chAgriEquip6, chAgriEquip7,chAgriEquip8,chAgriEquip9;
    private JCheckBox chAgriEquip10,chAgriEquip11,chAgriEquip12,chAgriEquip13,chAgriEquip14,chAgriEquip15,chAgriEquip16,chAgriEquip17,chAgriEquip18;
    private JRadioButton rbSugarCane, rbPalay, rbCorn, rbOthers;
    private ButtonGroup bgCrops;
    /*****USER INPUTS 4*****/
    /*****USER INPUTS 5*****/
    private JCheckBox chAF1,chAF2, chAF3,chAF4, chAF5,chAF6,chAF7,chAF8,chAF9;
    private JCheckBox chAE1, chAE2,chAE3,chAE4,chAE5,chAE6,chAE7,chAE8;
    /*****USER INPUTS 5*****/
    /*****USER INPUTS 6*****/
    private JRadioButton rbSugarCane2, rbPalay2, rbCorn2, rbOthers2;
    private ButtonGroup bgCrops2;
    /*****USER INPUTS 6*****/
    /*****USER INPUTS 7*****/
    private JTextField txtFishVol;
    private JCheckBox chAEQ1, chAEQ2,chAEQ3,chAEQ4,chAEQ5,chAEQ6,chAEQ7,chAEQ8;
    /*****USER INPUTS 7*****/
    public MainFrame(){
        initComponents();
        initInputPanel();
    }
    
    public void initComponents(){
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.decode("#ffffff"));
        UIManager.put("Button.select", Color.decode("#dddddd"));
        /*Controller*/
        controller = new Controller(this);
        
        /*pnlQueries*/
        pnlQueries = new JPanel();
        pnlQueries.setBackground(Color.decode("#3b465e"));
	pnlQueries.setBounds(600, 0, 300, 180);
	getContentPane().add(pnlQueries);
	pnlQueries.setLayout(null);
        
        lblChooseQuery = new JLabel("Choose Query:");
        lblChooseQuery.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblChooseQuery.setForeground(Color.WHITE);
        lblChooseQuery.setBounds(20, 5, 100, 30);
        pnlQueries.add(lblChooseQuery);
        
        btnQuery1 = new JButton("Query 1");
	btnQuery1.setBounds(17,35,120,30);
	btnQuery1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnQuery1.setBackground(Color.decode("#bfbfbf"));
        btnQuery1.setForeground(Color.decode("#585555"));
	btnQuery1.setFocusPainted(false);
	btnQuery1.setBorderPainted(false);
        btnQuery1.addActionListener(new doActionListener());
        pnlQueries.add(btnQuery1);
        btnQuery2 = new JButton("Query 2");
	btnQuery2.setBounds(17,70,120,30);
	btnQuery2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnQuery2.setBackground(Color.decode("#bfbfbf"));
        btnQuery2.setForeground(Color.decode("#585555"));
	btnQuery2.setFocusPainted(false);
	btnQuery2.setBorderPainted(false);
        btnQuery2.addActionListener(new doActionListener());
        pnlQueries.add(btnQuery2);
        btnQuery3 = new JButton("Query 3");
	btnQuery3.setBounds(17,105,120,30);
	btnQuery3.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnQuery3.setBackground(Color.decode("#bfbfbf"));
        btnQuery3.setForeground(Color.decode("#585555"));
	btnQuery3.setFocusPainted(false);
	btnQuery3.setBorderPainted(false);
        btnQuery3.addActionListener(new doActionListener());
        pnlQueries.add(btnQuery3);
        btnQuery4 = new JButton("Query 4");
	btnQuery4.setBounds(17,140,120,30);
	btnQuery4.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnQuery4.setBackground(Color.decode("#bfbfbf"));
        btnQuery4.setForeground(Color.decode("#585555"));
	btnQuery4.setFocusPainted(false);
	btnQuery4.setBorderPainted(false);
        btnQuery4.addActionListener(new doActionListener());
        pnlQueries.add(btnQuery4);
        btnQuery5 = new JButton("Query 5");
	btnQuery5.setBounds(155,35,120,30);
	btnQuery5.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnQuery5.setBackground(Color.decode("#bfbfbf"));
        btnQuery5.setForeground(Color.decode("#585555"));
	btnQuery5.setFocusPainted(false);
	btnQuery5.setBorderPainted(false);
        btnQuery5.addActionListener(new doActionListener());
        pnlQueries.add(btnQuery5);
        btnQuery6 = new JButton("Query 6");
	btnQuery6.setBounds(155,70,120,30);
	btnQuery6.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnQuery6.setBackground(Color.decode("#bfbfbf"));
        btnQuery6.setForeground(Color.decode("#585555"));
	btnQuery6.setFocusPainted(false);
	btnQuery6.setBorderPainted(false);
        btnQuery6.addActionListener(new doActionListener());
        pnlQueries.add(btnQuery6);
        btnQuery7 = new JButton("Query 7");
	btnQuery7.setBounds(155,105,120,30);
	btnQuery7.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnQuery7.setBackground(Color.decode("#bfbfbf"));
        btnQuery7.setForeground(Color.decode("#585555"));
	btnQuery7.setFocusPainted(false);
	btnQuery7.setBorderPainted(false);
        btnQuery7.addActionListener(new doActionListener());
        pnlQueries.add(btnQuery7);
        /*pnlQueries*/
        /*Info for Query Buttons*/
        infoQuery = new JButton();
        iconinfo = new ImageIcon("src/images/info.png");
        imgScaledIcon = iconinfo.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        iconinfo = new ImageIcon(imgScaledIcon);
        infoQuery.setIcon(iconinfo);
	infoQuery.setFocusPainted(false);
	infoQuery.setBorderPainted(false);
	infoQuery.setContentAreaFilled(false);
	infoQuery.setBounds(257,150,20,20);
        infoQuery.addActionListener(new doActionListener());
	pnlQueries.add(infoQuery);
        /*Info for Query Buttons*/
        /*pnlVariations*/
        pnlVariations = new JPanel();
	pnlVariations.setBackground(Color.decode("#8c9bab"));
	pnlVariations.setBounds(600, 180, 300, 130);
	getContentPane().add(pnlVariations);
        pnlVariations.setLayout(null);
        lblChooseVariation = new JLabel("Choose Variation:");
        lblChooseVariation.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblChooseVariation.setForeground(Color.WHITE);
        lblChooseVariation.setBounds(20, 5, 150, 30);
        pnlVariations.add(lblChooseVariation);
        rbNormal = new JRadioButton("Normal");
        rbNormal.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbNormal.setBounds(19, 30, 70, 30);
        rbNormal.setForeground(Color.WHITE);
        rbNormal.setSelected(false);
	rbNormal.setContentAreaFilled(false);
	rbNormal.setFocusPainted(false);
	rbNormal.addActionListener(new doActionListener());
        rbHeuristics = new JRadioButton("Heuristics");
        rbHeuristics.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbHeuristics.setBounds(19, 60, 80, 30);
        rbHeuristics.setForeground(Color.WHITE);
        rbHeuristics.setSelected(false);
	rbHeuristics.setContentAreaFilled(false);
	rbHeuristics.setFocusPainted(false);
	rbHeuristics.addActionListener(new doActionListener());
        rbIndexes = new JRadioButton("Indexes");
        rbIndexes.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbIndexes.setBounds(19, 90, 80, 30);
        rbIndexes.setForeground(Color.WHITE);
        rbIndexes.setSelected(false);
	rbIndexes.setContentAreaFilled(false);
	rbIndexes.setFocusPainted(false);
	rbIndexes.addActionListener(new doActionListener());
        rbViews = new JRadioButton("Views");
        rbViews.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbViews.setBounds(140, 30, 120, 30);
        rbViews.setForeground(Color.WHITE);
        rbViews.setSelected(false);
	rbViews.setContentAreaFilled(false);
	rbViews.setFocusPainted(false);
	rbViews.addActionListener(new doActionListener());
        rbStoredProcedure = new JRadioButton("Stored Procedure");
        rbStoredProcedure.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rbStoredProcedure.setBounds(140, 60, 125, 30);
        rbStoredProcedure.setForeground(Color.WHITE);
        rbStoredProcedure.setSelected(false);
	rbStoredProcedure.setContentAreaFilled(false);
	rbStoredProcedure.setFocusPainted(false);
	rbStoredProcedure.addActionListener(new doActionListener());
        bgVariations = new ButtonGroup();
        bgVariations.add(rbNormal);
        bgVariations.add(rbHeuristics);
        bgVariations.add(rbIndexes);
        bgVariations.add(rbViews);
        bgVariations.add(rbStoredProcedure);
        
        pnlVariations.add(rbNormal);
        pnlVariations.add(rbHeuristics);
        pnlVariations.add(rbIndexes);
        pnlVariations.add(rbViews);
        pnlVariations.add(rbStoredProcedure);
        /*pnlVariations*/
        
        /*pnlMessage*/
        pnlMessage = new JPanel();
        pnlMessage.setBackground(Color.decode("#aaa49c"));
	pnlMessage.setBounds(0, 550, 600, 22);
	getContentPane().add(pnlMessage);
        pnlMessage.setLayout(null);
        lblEstimatedTime = new JLabel("Estimated Execution Time: 0 seconds. 0 row(s) returned.");
        lblEstimatedTime.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblEstimatedTime.setForeground(Color.BLACK);
        lblEstimatedTime.setBounds(2, 0, 500, 23);
        pnlMessage.add(lblEstimatedTime);
        /*pnlMessage*/
        /*tpDataTable*/
        tpDataTable = new TablePanel(controller);
        tpDataTable.setBounds(20, 20, 560, 510);
        getContentPane().add(tpDataTable);
        /*tpDataTable*/
        
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setTitle("ADVANDB");
	this.setVisible(true);
    }
    
    public void initInputPanel(){
        /*pnlUserInputs*/
        pnlUserInputs = new JPanel();
        pnlUserInputs.setBackground(Color.decode("#585555"));
	pnlUserInputs.setBounds(600, 310, 300, 265);
	getContentPane().add(pnlUserInputs);
        pnlUserInputs.setLayout(null);
        
        btnExecute = new JButton("Execute");
        btnExecute.setBounds(19,230,120,20);
	btnExecute.setFont(new Font("Tahoma", Font.PLAIN, 12));
	btnExecute.setBackground(Color.decode("#bfbfbf"));
        btnExecute.setForeground(Color.decode("#585555"));
	btnExecute.setFocusPainted(false);
	btnExecute.setBorderPainted(false);
        btnExecute.addActionListener(new doActionListener());
        pnlUserInputs.add(btnExecute);
        
        UserInputQuery1Panel();
        UserInputQuery2Panel();
        UserInputQuery3Panel();
        UserInputQuery4Panel();
        UserInputQuery5Panel();
        UserInputQuery6Panel();
        UserInputQuery7Panel();
        /*pnlUserInputs*/   
    }
    
    public void UserInputQuery2Panel(){
        pnl_User_Query2 = new JPanel();
        pnl_User_Query2.setBackground(Color.decode("#585555"));
	pnl_User_Query2.setBounds(0, 0, 300, 220);
	pnlUserInputs.add(pnl_User_Query2);
        pnl_User_Query2.setLayout(null);
        pnl_User_Query2.setVisible(false);
        
        JLabel lblCalam = new JLabel("Calamity/ies experienced:");
        lblCalam.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCalam.setForeground(Color.WHITE);
        lblCalam.setBounds(10, 1, 170, 30);
        pnl_User_Query2.add(lblCalam);
        chCalam1 = new JCheckBox("Bagyo/Typhoon");
        chCalam1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chCalam1.setBounds(5, 20, 110, 30);
        chCalam1.setForeground(Color.WHITE);
        chCalam1.setSelected(false);
        chCalam1.setContentAreaFilled(false);
        chCalam1.setFocusPainted(false);
        chCalam1.addActionListener(new doActionListener());
        pnl_User_Query2.add(chCalam1);
        chCalam2 = new JCheckBox("Baha/Flood");
        chCalam2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chCalam2.setBounds(105, 20, 80, 30);
        chCalam2.setForeground(Color.WHITE);
        chCalam2.setSelected(false);
        chCalam2.setContentAreaFilled(false);
        chCalam2.setFocusPainted(false);
        chCalam2.addActionListener(new doActionListener());
        pnl_User_Query2.add(chCalam2);
        chCalam3 = new JCheckBox("<html>Tagtuyot/<br>Drought</html>");
        chCalam3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chCalam3.setBounds(205, 20, 70, 30);
        chCalam3.setForeground(Color.WHITE);
        chCalam3.setSelected(false);
        chCalam3.setContentAreaFilled(false);
        chCalam3.setFocusPainted(false);
        chCalam3.addActionListener(new doActionListener());
        pnl_User_Query2.add(chCalam3);
        chCalam4 = new JCheckBox("<html>Lindol/Earth-<br>quake</html>");
        chCalam4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chCalam4.setBounds(5, 45, 90, 30);
        chCalam4.setForeground(Color.WHITE);
        chCalam4.setSelected(false);
        chCalam4.setContentAreaFilled(false);
        chCalam4.setFocusPainted(false);
        chCalam4.addActionListener(new doActionListener());
        pnl_User_Query2.add(chCalam4);
        chCalam5 = new JCheckBox("<html>Pagsabog ng <br>Bulkan</html>");
        chCalam5.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chCalam5.setBounds(105, 45, 90, 30);
        chCalam5.setForeground(Color.WHITE);
        chCalam5.setSelected(false);
        chCalam5.setContentAreaFilled(false);
        chCalam5.setFocusPainted(false);
        chCalam5.addActionListener(new doActionListener());
        pnl_User_Query2.add(chCalam5);
        chCalam6 = new JCheckBox("Landslide");
        chCalam6.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chCalam6.setBounds(205, 45, 70, 30);
        chCalam6.setForeground(Color.WHITE);
        chCalam6.setSelected(false);
        chCalam6.setContentAreaFilled(false);
        chCalam6.setFocusPainted(false);
        chCalam6.addActionListener(new doActionListener());
        pnl_User_Query2.add(chCalam6);
        chCalam7 = new JCheckBox("Tsunami");
        chCalam7.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chCalam7.setBounds(5, 70, 70, 30);
        chCalam7.setForeground(Color.WHITE);
        chCalam7.setSelected(false);
        chCalam7.setContentAreaFilled(false);
        chCalam7.setFocusPainted(false);
        chCalam7.addActionListener(new doActionListener());
        pnl_User_Query2.add(chCalam7);
        chCalam8 = new JCheckBox("Sunog");
        chCalam8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chCalam8.setBounds(105, 70, 60, 30);
        chCalam8.setForeground(Color.WHITE);
        chCalam8.setSelected(false);
        chCalam8.setContentAreaFilled(false);
        chCalam8.setFocusPainted(false);
        chCalam8.addActionListener(new doActionListener());
        pnl_User_Query2.add(chCalam8);
        chCalam9 = new JCheckBox("Forest Fire");
        chCalam9.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chCalam9.setBounds(205, 70, 80, 30);
        chCalam9.setForeground(Color.WHITE);
        chCalam9.setSelected(false);
        chCalam9.setContentAreaFilled(false);
        chCalam9.setFocusPainted(false);
        chCalam9.addActionListener(new doActionListener());
        pnl_User_Query2.add(chCalam9);
        chCalam10 = new JCheckBox("<html>Armadong <br>Digmaan</html>");
        chCalam10.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chCalam10.setBounds(5, 95, 70, 30);
        chCalam10.setForeground(Color.WHITE);
        chCalam10.setSelected(false);
        chCalam10.setContentAreaFilled(false);
        chCalam10.setFocusPainted(false);
        chCalam10.addActionListener(new doActionListener());
        pnl_User_Query2.add(chCalam10);
        chCalam11 = new JCheckBox("Others");
        chCalam11.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chCalam11.setBounds(105, 95, 60, 30);
        chCalam11.setForeground(Color.WHITE);
        chCalam11.setSelected(false);
        chCalam11.setContentAreaFilled(false);
        chCalam11.setFocusPainted(false);
        chCalam11.addActionListener(new doActionListener());
        pnl_User_Query2.add(chCalam11);
        JLabel lblExp = new JLabel("Times Experienced:");
        lblExp.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblExp.setForeground(Color.WHITE);
        lblExp.setBounds(10, 115, 110, 30);
        pnl_User_Query2.add(lblExp);
        JLabel lblCalam1 = new JLabel("Bagyo:");
        lblCalam1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblCalam1.setForeground(Color.WHITE);
        lblCalam1.setBounds(10, 135, 80, 30);
        pnl_User_Query2.add(lblCalam1);
        txtCalam1 = new JTextField();
        txtCalam1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCalam1.setBounds(65, 142, 30, 17);
        pnl_User_Query2.add(txtCalam1);
        JLabel lblCalam2 = new JLabel("Baha:");
        lblCalam2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblCalam2.setForeground(Color.WHITE);
        lblCalam2.setBounds(10, 155, 60, 30);
        pnl_User_Query2.add(lblCalam2);
        txtCalam2 = new JTextField();
        txtCalam2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCalam2.setBounds(65, 162, 30, 17);
        pnl_User_Query2.add(txtCalam2);
        JLabel lblCalam3 = new JLabel("Tagtuyot:");
        lblCalam3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblCalam3.setForeground(Color.WHITE);
        lblCalam3.setBounds(10, 175, 80, 30);
        pnl_User_Query2.add(lblCalam3);
        txtCalam3 = new JTextField();
        txtCalam3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCalam3.setBounds(65, 182, 30, 17);
        pnl_User_Query2.add(txtCalam3);
        JLabel lblCalam4 = new JLabel("Lindol:");
        lblCalam4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblCalam4.setForeground(Color.WHITE);
        lblCalam4.setBounds(10, 195, 80, 30);
        pnl_User_Query2.add(lblCalam4);
        txtCalam4 = new JTextField();
        txtCalam4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCalam4.setBounds(65, 202, 30, 17);
        pnl_User_Query2.add(txtCalam4);
        JLabel lblCalam5 = new JLabel("<html>Pagsabog ng<br>Bulkan</html>:");
        lblCalam5.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblCalam5.setForeground(Color.WHITE);
        lblCalam5.setBounds(100, 135, 80, 30);
        pnl_User_Query2.add(lblCalam5);
        txtCalam5 = new JTextField();
        txtCalam5.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCalam5.setBounds(170, 142, 30, 17);
        pnl_User_Query2.add(txtCalam5);
        JLabel lblCalam6 = new JLabel("Landslide:");
        lblCalam6.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblCalam6.setForeground(Color.WHITE);
        lblCalam6.setBounds(100, 155, 60, 30);
        pnl_User_Query2.add(lblCalam6);
        txtCalam6 = new JTextField();
        txtCalam6.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCalam6.setBounds(170, 162, 30, 17);
        pnl_User_Query2.add(txtCalam6);
        JLabel lblCalam7 = new JLabel("Tsunami:");
        lblCalam7.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblCalam7.setForeground(Color.WHITE);
        lblCalam7.setBounds(100, 175, 80, 30);
        pnl_User_Query2.add(lblCalam7);
        txtCalam7 = new JTextField();
        txtCalam7.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCalam7.setBounds(170, 182, 30, 17);
        pnl_User_Query2.add(txtCalam7);
        JLabel lblCalam8 = new JLabel("Sunog:");
        lblCalam8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblCalam8.setForeground(Color.WHITE);
        lblCalam8.setBounds(100, 195, 80, 30);
        pnl_User_Query2.add(lblCalam8);
        txtCalam8 = new JTextField();
        txtCalam8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCalam8.setBounds(170, 202, 30, 17);
        pnl_User_Query2.add(txtCalam8);
        JLabel lblCalam9 = new JLabel("<html>Forest<br>Fire:</html");
        lblCalam9.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblCalam9.setForeground(Color.WHITE);
        lblCalam9.setBounds(205, 135, 90, 30);
        pnl_User_Query2.add(lblCalam9);
        txtCalam9 = new JTextField();
        txtCalam9.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCalam9.setBounds(255, 142, 30, 17);
        pnl_User_Query2.add(txtCalam9);
        JLabel lblCalam10 = new JLabel("<html>Armadong<br>Digmaan:</html>");
        lblCalam10.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblCalam10.setForeground(Color.WHITE);
        lblCalam10.setBounds(205, 160, 70, 30);
        pnl_User_Query2.add(lblCalam10);
        txtCalam10 = new JTextField();
        txtCalam10.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCalam10.setBounds(255, 167, 30, 17);
        pnl_User_Query2.add(txtCalam10);
        JLabel lblCalam11 = new JLabel("Others:");
        lblCalam11.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblCalam11.setForeground(Color.WHITE);
        lblCalam11.setBounds(205, 180, 70, 30);
        pnl_User_Query2.add(lblCalam11);
        txtCalam11 = new JTextField();
        txtCalam11.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtCalam11.setBounds(255, 187, 30, 17);
        pnl_User_Query2.add(txtCalam11);
    }
    public void UserInputQuery1Panel(){
        pnl_User_Query1 = new JPanel();
        pnl_User_Query1.setBackground(Color.decode("#585555"));
	pnl_User_Query1.setBounds(0, 0, 300, 200);
	pnlUserInputs.add(pnl_User_Query1);
        pnl_User_Query1.setLayout(null);
        pnl_User_Query1.setVisible(false);
        
            JLabel lblSchType = new JLabel("School Type:");
            lblSchType.setFont(new Font("Tahoma", Font.PLAIN, 12));
            lblSchType.setForeground(Color.WHITE);
            lblSchType.setBounds(10, 17, 100, 30);
            pnl_User_Query1.add(lblSchType);
            rbPublicSch = new JRadioButton("Public");
            rbPublicSch.setFont(new Font("Tahoma", Font.PLAIN, 12));
            rbPublicSch.setBounds(50, 35, 60, 30);
            rbPublicSch.setForeground(Color.WHITE);
            rbPublicSch.setSelected(true);
            rbPublicSch.setContentAreaFilled(false);
            rbPublicSch.setFocusPainted(false);
            rbPublicSch.addActionListener(new doActionListener());
            rbPrivateSch = new JRadioButton("Private");
            rbPrivateSch.setFont(new Font("Tahoma", Font.PLAIN, 12));
            rbPrivateSch.setBounds(115, 35, 70, 30);
            rbPrivateSch.setForeground(Color.WHITE);
            rbPrivateSch.setSelected(false);
            rbPrivateSch.setContentAreaFilled(false);
            rbPrivateSch.setFocusPainted(false);
            rbPrivateSch.addActionListener(new doActionListener());
            rbBothSch = new JRadioButton("Both");
            rbBothSch.setFont(new Font("Tahoma", Font.PLAIN, 12));
            rbBothSch.setBounds(185, 35, 70, 30);
            rbBothSch.setForeground(Color.WHITE);
            rbBothSch.setSelected(false);
            rbBothSch.setContentAreaFilled(false);
            rbBothSch.setFocusPainted(false);
            rbBothSch.addActionListener(new doActionListener());
            bgSchoolType = new ButtonGroup();
            bgSchoolType.add(rbPrivateSch);bgSchoolType.add(rbPublicSch);bgSchoolType.add(rbBothSch);
            pnl_User_Query1.add(rbPrivateSch);pnl_User_Query1.add(rbPublicSch);pnl_User_Query1.add(rbBothSch);
            JLabel lblSex = new JLabel("Sex:");
            lblSex.setFont(new Font("Tahoma", Font.PLAIN, 12));
            lblSex.setForeground(Color.WHITE);
            lblSex.setBounds(10, 50, 100, 30);
            pnl_User_Query1.add(lblSex);
            rbMale = new JRadioButton("Male");
            rbMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
            rbMale.setBounds(50, 63, 60, 30);
            rbMale.setForeground(Color.WHITE);
            rbMale.setSelected(true);
            rbMale.setContentAreaFilled(false);
            rbMale.setFocusPainted(false);
            rbMale.addActionListener(new doActionListener());
            rbFemale = new JRadioButton("Female");
            rbFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
            rbFemale.setBounds(115, 63, 70, 30);
            rbFemale.setForeground(Color.WHITE);
            rbFemale.setSelected(false);
            rbFemale.setContentAreaFilled(false);
            rbFemale.setFocusPainted(false);
            rbFemale.addActionListener(new doActionListener());
            rbBothSex = new JRadioButton("Both Sexes");
            rbBothSex.setFont(new Font("Tahoma", Font.PLAIN, 12));
            rbBothSex.setBounds(185, 63, 90, 30);
            rbBothSex.setForeground(Color.WHITE);
            rbBothSex.setSelected(false);
            rbBothSex.setContentAreaFilled(false);
            rbBothSex.setFocusPainted(false);
            rbBothSex.addActionListener(new doActionListener());
            bgSex = new ButtonGroup();
            bgSex.add(rbFemale);bgSex.add(rbMale);bgSex.add(rbBothSex);
            pnl_User_Query1.add(rbFemale);pnl_User_Query1.add(rbMale);pnl_User_Query1.add(rbBothSex);
            JLabel lblAgency = new JLabel("Agency:");
            lblAgency.setFont(new Font("Tahoma", Font.PLAIN, 12));
            lblAgency.setForeground(Color.WHITE);
            lblAgency.setBounds(10, 82, 100, 30);
            pnl_User_Query1.add(lblAgency);
            rbSSS = new JRadioButton("SSS");
            rbSSS.setFont(new Font("Tahoma", Font.PLAIN, 12));
            rbSSS.setBounds(50, 100, 60, 30);
            rbSSS.setForeground(Color.WHITE);
            rbSSS.setSelected(true);
            rbSSS.setContentAreaFilled(false);
            rbSSS.setFocusPainted(false);
            rbSSS.addActionListener(new doActionListener());
            rbGSIS = new JRadioButton("GSIS");
            rbGSIS.setFont(new Font("Tahoma", Font.PLAIN, 12));
            rbGSIS.setBounds(155, 100, 70, 30);
            rbGSIS.setForeground(Color.WHITE);
            rbGSIS.setSelected(false);
            rbGSIS.setContentAreaFilled(false);
            rbGSIS.setFocusPainted(false);
            rbGSIS.addActionListener(new doActionListener());
            rbBothAgency = new JRadioButton("Both Agencies");
            rbBothAgency.setFont(new Font("Tahoma", Font.PLAIN, 12));
            rbBothAgency.setBounds(50, 120, 120, 30);
            rbBothAgency.setForeground(Color.WHITE);
            rbBothAgency.setSelected(false);
            rbBothAgency.setContentAreaFilled(false);
            rbBothAgency.setFocusPainted(false);
            rbBothAgency.addActionListener(new doActionListener());
            rbNeitherAgency = new JRadioButton("Neither Agencies");
            rbNeitherAgency.setFont(new Font("Tahoma", Font.PLAIN, 12));
            rbNeitherAgency.setBounds(155, 120, 120, 30);
            rbNeitherAgency.setForeground(Color.WHITE);
            rbNeitherAgency.setSelected(false);
            rbNeitherAgency.setContentAreaFilled(false);
            rbNeitherAgency.setFocusPainted(false);
            rbNeitherAgency.addActionListener(new doActionListener());
            bgAgency = new ButtonGroup();
            bgAgency.add(rbSSS);bgAgency.add(rbGSIS);bgAgency.add(rbBothAgency);bgAgency.add(rbNeitherAgency);
            pnl_User_Query1.add(rbSSS);pnl_User_Query1.add(rbGSIS);pnl_User_Query1.add(rbBothAgency);pnl_User_Query1.add(rbNeitherAgency);
    }
    public void UserInputQuery3Panel(){
        pnl_User_Query3 = new JPanel();
        pnl_User_Query3.setBackground(Color.decode("#585555"));
	pnl_User_Query3.setBounds(0, 0, 300, 220);
	pnlUserInputs.add(pnl_User_Query3);
        pnl_User_Query3.setLayout(null);
        pnl_User_Query3.setVisible(false);
        
        JLabel lblSex = new JLabel("Sex:");
            lblSex.setFont(new Font("Tahoma", Font.PLAIN, 11));
            lblSex.setForeground(Color.WHITE);
            lblSex.setBounds(10, 1, 100, 30);
            pnl_User_Query3.add(lblSex);
            rbMale2 = new JRadioButton("Male");
            rbMale2.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbMale2.setBounds(52, 1, 50, 30);
            rbMale2.setForeground(Color.WHITE);
            rbMale2.setSelected(true);
            rbMale2.setContentAreaFilled(false);
            rbMale2.setFocusPainted(false);
            rbMale2.addActionListener(new doActionListener());
            rbFemale2 = new JRadioButton("Female");
            rbFemale2.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbFemale2.setBounds(117, 1, 60, 30);
            rbFemale2.setForeground(Color.WHITE);
            rbFemale2.setSelected(false);
            rbFemale2.setContentAreaFilled(false);
            rbFemale2.setFocusPainted(false);
            rbFemale2.addActionListener(new doActionListener());
            rbBothSex2 = new JRadioButton("Both Sexes");
            rbBothSex2.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbBothSex2.setBounds(187, 1, 80, 30);
            rbBothSex2.setForeground(Color.WHITE);
            rbBothSex2.setSelected(false);
            rbBothSex2.setContentAreaFilled(false);
            rbBothSex2.setFocusPainted(false);
            rbBothSex2.addActionListener(new doActionListener());
            bgSex2 = new ButtonGroup();
            bgSex2.add(rbFemale2);bgSex2.add(rbMale2);bgSex2.add(rbBothSex2);
            pnl_User_Query3.add(rbFemale2);pnl_User_Query3.add(rbMale2);pnl_User_Query3.add(rbBothSex2);
            JLabel lblEduc = new JLabel("<html>Educational<br>Level:</html>");
            lblEduc.setFont(new Font("Tahoma", Font.PLAIN, 11));
            lblEduc.setForeground(Color.WHITE);
            lblEduc.setBounds(10, 26, 100, 30);
            pnl_User_Query3.add(lblEduc);
            rbCollege = new JRadioButton("<html>College<br>Graduate</html>");
            rbCollege.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbCollege.setBounds(70, 26, 80, 30);
            rbCollege.setForeground(Color.WHITE);
            rbCollege.setSelected(true);
            rbCollege.setContentAreaFilled(false);
            rbCollege.setFocusPainted(false);
            rbCollege.addActionListener(new doActionListener());
            rbMasters = new JRadioButton("<html>Master's/<br>PhD Graduate</html>");
            rbMasters.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbMasters.setBounds(160, 26, 100, 30);
            rbMasters.setForeground(Color.WHITE);
            rbMasters.setSelected(false);
            rbMasters.setContentAreaFilled(false);
            rbMasters.setFocusPainted(false);
            rbMasters.addActionListener(new doActionListener());
            bgEduc = new ButtonGroup();
            bgEduc.add(rbCollege);bgEduc.add(rbMasters);
            pnl_User_Query3.add(rbMasters);pnl_User_Query3.add(rbCollege);
            JLabel lblRegVote = new JLabel("<html>Registered<br>Voter:</html>");
            lblRegVote.setFont(new Font("Tahoma", Font.PLAIN, 11));
            lblRegVote.setForeground(Color.WHITE);
            lblRegVote.setBounds(10, 56, 100, 30);
            pnl_User_Query3.add(lblRegVote);
            rbYes1 = new JRadioButton("Yes");
            rbYes1.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbYes1.setBounds(70, 56, 50, 30);
            rbYes1.setForeground(Color.WHITE);
            rbYes1.setSelected(true);
            rbYes1.setContentAreaFilled(false);
            rbYes1.setFocusPainted(false);
            rbYes1.addActionListener(new doActionListener());
            rbNo1 = new JRadioButton("No");
            rbNo1.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbNo1.setBounds(130, 56, 50, 30);
            rbNo1.setForeground(Color.WHITE);
            rbNo1.setSelected(false);
            rbNo1.setContentAreaFilled(false);
            rbNo1.setFocusPainted(false);
            rbNo1.addActionListener(new doActionListener());
            bgRegVote = new ButtonGroup();
            bgRegVote.add(rbYes1);bgRegVote.add(rbNo1);
            pnl_User_Query3.add(rbNo1);pnl_User_Query3.add(rbYes1);
            JLabel lblVotedLast = new JLabel("<html>Voted Last<br>Election:</html>");
            lblVotedLast.setFont(new Font("Tahoma", Font.PLAIN, 11));
            lblVotedLast.setForeground(Color.WHITE);
            lblVotedLast.setBounds(10, 83, 100, 30);
            pnl_User_Query3.add(lblVotedLast);
            rbYes2 = new JRadioButton("Yes");
            rbYes2.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbYes2.setBounds(70, 83, 50, 30);
            rbYes2.setForeground(Color.WHITE);
            rbYes2.setSelected(true);
            rbYes2.setContentAreaFilled(false);
            rbYes2.setFocusPainted(false);
            rbYes2.addActionListener(new doActionListener());
            rbNo2 = new JRadioButton("No");
            rbNo2.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbNo2.setBounds(130, 83, 50, 30);
            rbNo2.setForeground(Color.WHITE);
            rbNo2.setSelected(false);
            rbNo2.setContentAreaFilled(false);
            rbNo2.setFocusPainted(false);
            rbNo2.addActionListener(new doActionListener());
            rbIDK = new JRadioButton("Don't Know");
            rbIDK.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbIDK.setBounds(190, 83, 80, 30);
            rbIDK.setForeground(Color.WHITE);
            rbIDK.setSelected(false);
            rbIDK.setContentAreaFilled(false);
            rbIDK.setFocusPainted(false);
            rbIDK.addActionListener(new doActionListener());
            bgVotedLast = new ButtonGroup();
            bgVotedLast.add(rbYes2);bgVotedLast.add(rbNo2); bgVotedLast.add(rbIDK);
            pnl_User_Query3.add(rbNo2);pnl_User_Query3.add(rbYes2);pnl_User_Query3.add(rbIDK);
            JLabel lblJobInd = new JLabel("Job Ind");
            lblJobInd.setFont(new Font("Tahoma", Font.PLAIN, 11));
            lblJobInd.setForeground(Color.WHITE);
            lblJobInd.setBounds(10, 109, 100, 30);
            pnl_User_Query3.add(lblJobInd);
            rbEmployed = new JRadioButton("Employed");
            rbEmployed.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbEmployed.setBounds(70, 109, 80, 30);
            rbEmployed.setForeground(Color.WHITE);
            rbEmployed.setSelected(true);
            rbEmployed.setContentAreaFilled(false);
            rbEmployed.setFocusPainted(false);
            rbEmployed.addActionListener(new doActionListener());
            rbUnemployed = new JRadioButton("Unemployed");
            rbUnemployed.setFont(new Font("Tahoma", Font.PLAIN, 11));
            rbUnemployed.setBounds(140, 109, 90, 30);
            rbUnemployed.setForeground(Color.WHITE);
            rbUnemployed.setSelected(false);
            rbUnemployed.setContentAreaFilled(false);
            rbUnemployed.setFocusPainted(false);
            rbUnemployed.addActionListener(new doActionListener());
            bgJobInd = new ButtonGroup();
            bgJobInd.add(rbEmployed);bgJobInd.add(rbUnemployed);
            pnl_User_Query3.add(rbEmployed);pnl_User_Query3.add(rbUnemployed);
            JLabel lblWork = new JLabel("<html>Employee<br>Type:</html>");
            lblWork.setFont(new Font("Tahoma", Font.PLAIN, 11));
            lblWork.setForeground(Color.WHITE);
            lblWork.setBounds(10, 135, 110, 30);
            pnl_User_Query3.add(lblWork);
            cbWorkCl = new JComboBox(stWorkCl);
            cbWorkCl.setFont(new Font("Tahoma", Font.PLAIN, 9));
            cbWorkCl.setBounds(70, 142, 210, 18);
            cbWorkCl.setBackground(Color.decode("#c0c0c0"));
            cbWorkCl.setForeground(Color.BLACK);
            cbWorkCl.setSelectedIndex(0);
            cbWorkCl.addActionListener(new doActionListener());
            pnl_User_Query3.add(cbWorkCl);
            JLabel lblDeath = new JLabel("<html>Cause of<br>Death</html>");
            lblDeath.setFont(new Font("Tahoma", Font.PLAIN, 11));
            lblDeath.setForeground(Color.WHITE);
            lblDeath.setBounds(10, 164, 110, 30);
            pnl_User_Query3.add(lblDeath);
            cbDeath = new JComboBox(stDeath);
            cbDeath.setFont(new Font("Tahoma", Font.PLAIN, 10));
            cbDeath.setBounds(70, 171, 210, 18);
            cbDeath.setBackground(Color.decode("#c0c0c0"));
            cbDeath.setForeground(Color.BLACK);
            cbDeath.setSelectedIndex(0);
            cbDeath.addActionListener(new doActionListener());
            pnl_User_Query3.add(cbDeath);
    }
    public void UserInputQuery4Panel(){
        pnl_User_Query4 = new JPanel();
        pnl_User_Query4.setBackground(Color.decode("#585555"));
	pnl_User_Query4.setBounds(0, 0, 300, 220);
	pnlUserInputs.add(pnl_User_Query4);
        pnl_User_Query4.setLayout(null);
        pnl_User_Query4.setVisible(false);
        
        JLabel lblAgri = new JLabel("Agriculture Equipment/s:");
        lblAgri.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAgri.setForeground(Color.WHITE);
        lblAgri.setBounds(10, 1, 170, 30);
        pnl_User_Query4.add(lblAgri);
        chAgriEquip1 = new JCheckBox("Beast of Burden");
        chAgriEquip1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip1.setBounds(5, 20, 105, 30);
        chAgriEquip1.setForeground(Color.WHITE);
        chAgriEquip1.setSelected(false);
        chAgriEquip1.setContentAreaFilled(false);
        chAgriEquip1.setFocusPainted(false);
        chAgriEquip1.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip1);
        chAgriEquip2 = new JCheckBox("Plow");
        chAgriEquip2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip2.setBounds(105, 20, 50, 30);
        chAgriEquip2.setForeground(Color.WHITE);
        chAgriEquip2.setSelected(false);
        chAgriEquip2.setContentAreaFilled(false);
        chAgriEquip2.setFocusPainted(false);
        chAgriEquip2.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip2);
        chAgriEquip3 = new JCheckBox("Harrow");
        chAgriEquip3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip3.setBounds(205, 20, 60, 30);
        chAgriEquip3.setForeground(Color.WHITE);
        chAgriEquip3.setSelected(false);
        chAgriEquip3.setContentAreaFilled(false);
        chAgriEquip3.setFocusPainted(false);
        chAgriEquip3.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip3);
        chAgriEquip4 = new JCheckBox("Mower");
        chAgriEquip4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip4.setBounds(5, 45, 60, 30);
        chAgriEquip4.setForeground(Color.WHITE);
        chAgriEquip4.setSelected(false);
        chAgriEquip4.setContentAreaFilled(false);
        chAgriEquip4.setFocusPainted(false);
        chAgriEquip4.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip4);
        chAgriEquip5 = new JCheckBox("<html>Thresher/Corn Sheller</html>");
        chAgriEquip5.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip5.setBounds(105, 45, 90, 30);
        chAgriEquip5.setForeground(Color.WHITE);
        chAgriEquip5.setSelected(false);
        chAgriEquip5.setContentAreaFilled(false);
        chAgriEquip5.setFocusPainted(false);
        chAgriEquip5.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip5);
        chAgriEquip6 = new JCheckBox("Insecticide");
        chAgriEquip6.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip6.setBounds(205, 45, 80, 30);
        chAgriEquip6.setForeground(Color.WHITE);
        chAgriEquip6.setSelected(false);
        chAgriEquip6.setContentAreaFilled(false);
        chAgriEquip6.setFocusPainted(false);
        chAgriEquip6.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip6);
        chAgriEquip7 = new JCheckBox("Farm Tractor");
        chAgriEquip7.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip7.setBounds(5, 70, 90, 30);
        chAgriEquip7.setForeground(Color.WHITE);
        chAgriEquip7.setSelected(false);
        chAgriEquip7.setContentAreaFilled(false);
        chAgriEquip7.setFocusPainted(false);
        chAgriEquip7.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip7);
        chAgriEquip8 = new JCheckBox("Hand Tractor");
        chAgriEquip8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip8.setBounds(105, 70, 90, 30);
        chAgriEquip8.setForeground(Color.WHITE);
        chAgriEquip8.setSelected(false);
        chAgriEquip8.setContentAreaFilled(false);
        chAgriEquip8.setFocusPainted(false);
        chAgriEquip8.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip8);
        chAgriEquip9 = new JCheckBox("<html>Turtle/<br>Mudboat</html>");
        chAgriEquip9.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip9.setBounds(205, 70, 70, 30);
        chAgriEquip9.setForeground(Color.WHITE);
        chAgriEquip9.setSelected(false);
        chAgriEquip9.setContentAreaFilled(false);
        chAgriEquip9.setFocusPainted(false);
        chAgriEquip9.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip9);
        chAgriEquip10 = new JCheckBox("<html>Planter/Trans-<br>planter/dryer</html>");
        chAgriEquip10.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip10.setBounds(5, 100, 90, 30);
        chAgriEquip10.setForeground(Color.WHITE);
        chAgriEquip10.setSelected(false);
        chAgriEquip10.setContentAreaFilled(false);
        chAgriEquip10.setFocusPainted(false);
        chAgriEquip10.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip10);
        chAgriEquip11 = new JCheckBox("<html>Mechanical<br>Dryer</html>");
        chAgriEquip11.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip11.setBounds(105, 100, 90, 30);
        chAgriEquip11.setForeground(Color.WHITE);
        chAgriEquip11.setSelected(false);
        chAgriEquip11.setContentAreaFilled(false);
        chAgriEquip11.setFocusPainted(false);
        chAgriEquip11.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip11);
        chAgriEquip12 = new JCheckBox("<html>Multipurpose/<br>Drying Pvmnt.</html>");
        chAgriEquip12.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip12.setBounds(205, 100, 100, 30);
        chAgriEquip12.setForeground(Color.WHITE);
        chAgriEquip12.setSelected(false);
        chAgriEquip12.setContentAreaFilled(false);
        chAgriEquip12.setFocusPainted(false);
        chAgriEquip12.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip12);
        chAgriEquip13 = new JCheckBox("<html>Rice/Corn/<br>Feed Mill</html>");
        chAgriEquip13.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip13.setBounds(5, 130, 75, 30);
        chAgriEquip13.setForeground(Color.WHITE);
        chAgriEquip13.setSelected(false);
        chAgriEquip13.setContentAreaFilled(false);
        chAgriEquip13.setFocusPainted(false);
        chAgriEquip13.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip13);
        chAgriEquip14 = new JCheckBox("Harvester");
        chAgriEquip14.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip14.setBounds(105, 130, 80, 30);
        chAgriEquip14.setForeground(Color.WHITE);
        chAgriEquip14.setSelected(false);
        chAgriEquip14.setContentAreaFilled(false);
        chAgriEquip14.setFocusPainted(false);
        chAgriEquip14.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip14);
        chAgriEquip15 = new JCheckBox("<html>Warehouse/<br>Granary</html>");
        chAgriEquip15.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip15.setBounds(205, 130, 80, 30);
        chAgriEquip15.setForeground(Color.WHITE);
        chAgriEquip15.setSelected(false);
        chAgriEquip15.setContentAreaFilled(false);
        chAgriEquip15.setFocusPainted(false);
        chAgriEquip15.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip15);
        chAgriEquip16 = new JCheckBox("Farmshed");
        chAgriEquip16.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip16.setBounds(5, 150, 75, 30);
        chAgriEquip16.setForeground(Color.WHITE);
        chAgriEquip16.setSelected(false);
        chAgriEquip16.setContentAreaFilled(false);
        chAgriEquip16.setFocusPainted(false);
        chAgriEquip16.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip16);
        chAgriEquip17 = new JCheckBox("Irrigation Pump");
        chAgriEquip17.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip17.setBounds(105, 150, 100, 30);
        chAgriEquip17.setForeground(Color.WHITE);
        chAgriEquip17.setSelected(false);
        chAgriEquip17.setContentAreaFilled(false);
        chAgriEquip17.setFocusPainted(false);
        chAgriEquip17.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip17);
        chAgriEquip18 = new JCheckBox("Others");
        chAgriEquip18.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAgriEquip18.setBounds(205, 150, 60, 30);
        chAgriEquip18.setForeground(Color.WHITE);
        chAgriEquip18.setSelected(false);
        chAgriEquip18.setContentAreaFilled(false);
        chAgriEquip18.setFocusPainted(false);
        chAgriEquip18.addActionListener(new doActionListener());
        pnl_User_Query4.add(chAgriEquip18);
        JLabel lblCrop = new JLabel("Crop/s:");
        lblCrop.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCrop.setForeground(Color.WHITE);
        lblCrop.setBounds(10, 172, 170, 30);
        pnl_User_Query4.add(lblCrop);
        rbSugarCane = new JRadioButton("Sugar Cane");
        rbSugarCane.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rbSugarCane.setBounds(5, 190, 90, 30);
        rbSugarCane.setForeground(Color.WHITE);
        rbSugarCane.setSelected(false);
        rbSugarCane.setContentAreaFilled(false);
        rbSugarCane.setFocusPainted(false);
        rbSugarCane.addActionListener(new doActionListener());
        pnl_User_Query4.add(rbSugarCane);
        rbPalay = new JRadioButton("Palay");
        rbPalay.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rbPalay.setBounds(85, 190, 70, 30);
        rbPalay.setForeground(Color.WHITE);
        rbPalay.setSelected(false);
        rbPalay.setContentAreaFilled(false);
        rbPalay.setFocusPainted(false);
        rbPalay.addActionListener(new doActionListener());
        pnl_User_Query4.add(rbPalay);
        rbCorn = new JRadioButton("Corn");
        rbCorn.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rbCorn.setBounds(155, 190, 60, 30);
        rbCorn.setForeground(Color.WHITE);
        rbCorn.setSelected(false);
        rbCorn.setContentAreaFilled(false);
        rbCorn.setFocusPainted(false);
        rbCorn.addActionListener(new doActionListener());
        pnl_User_Query4.add(rbCorn);
        rbOthers = new JRadioButton("Others");
        rbOthers.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rbOthers.setBounds(225, 190, 70, 30);
        rbOthers.setForeground(Color.WHITE);
        rbOthers.setSelected(false);
        rbOthers.setContentAreaFilled(false);
        rbOthers.setFocusPainted(false);
        rbOthers.addActionListener(new doActionListener());
        pnl_User_Query4.add(rbOthers);
        bgCrops = new ButtonGroup();
        bgCrops.add(rbPalay);
        bgCrops.add(rbSugarCane);
        bgCrops.add(rbCorn);
        bgCrops.add(rbOthers);
    }
    public void UserInputQuery5Panel(){
        pnl_User_Query5 = new JPanel();
        pnl_User_Query5.setBackground(Color.decode("#585555"));
	pnl_User_Query5.setBounds(0, 0, 300, 220);
	pnlUserInputs.add(pnl_User_Query5);
        pnl_User_Query5.setLayout(null);
        pnl_User_Query5.setVisible(false);
        
        JLabel lblAquaF = new JLabel("Aqua Farm/s:");
        lblAquaF.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblAquaF.setForeground(Color.WHITE);
        lblAquaF.setBounds(10, 1, 170, 30);
        pnl_User_Query5.add(lblAquaF);
        chAF1 = new JCheckBox("Fishpond");
        chAF1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAF1.setBounds(5, 20, 70, 30);
        chAF1.setForeground(Color.WHITE);
        chAF1.setSelected(false);
        chAF1.setContentAreaFilled(false);
        chAF1.setFocusPainted(false);
        chAF1.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAF1);
        chAF2 = new JCheckBox("Fishpen");
        chAF2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAF2.setBounds(105, 20, 70, 30);
        chAF2.setForeground(Color.WHITE);
        chAF2.setSelected(false);
        chAF2.setContentAreaFilled(false);
        chAF2.setFocusPainted(false);
        chAF2.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAF2);
        chAF3 = new JCheckBox("Fish Cage");
        chAF3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAF3.setBounds(205, 20, 80, 30);
        chAF3.setForeground(Color.WHITE);
        chAF3.setSelected(false);
        chAF3.setContentAreaFilled(false);
        chAF3.setFocusPainted(false);
        chAF3.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAF3);
        chAF4 = new JCheckBox("Seaweed Farm");
        chAF4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAF4.setBounds(5, 45, 100, 30);
        chAF4.setForeground(Color.WHITE);
        chAF4.setSelected(false);
        chAF4.setContentAreaFilled(false);
        chAF4.setFocusPainted(false);
        chAF4.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAF4);
        chAF5 = new JCheckBox("Oyster Farm");
        chAF5.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAF5.setBounds(105, 45, 90, 30);
        chAF5.setForeground(Color.WHITE);
        chAF5.setSelected(false);
        chAF5.setContentAreaFilled(false);
        chAF5.setFocusPainted(false);
        chAF5.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAF5);
        chAF6 = new JCheckBox("Mussel Farm");
        chAF6.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAF6.setBounds(205, 45, 90, 30);
        chAF6.setForeground(Color.WHITE);
        chAF6.setSelected(false);
        chAF6.setContentAreaFilled(false);
        chAF6.setFocusPainted(false);
        chAF6.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAF6);
        chAF7 = new JCheckBox("Fish Tank");
        chAF7.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAF7.setBounds(5, 70, 90, 30);
        chAF7.setForeground(Color.WHITE);
        chAF7.setSelected(false);
        chAF7.setContentAreaFilled(false);
        chAF7.setFocusPainted(false);
        chAF7.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAF7);
        chAF8 = new JCheckBox("Hatchery");
        chAF8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAF8.setBounds(105, 70, 90, 30);
        chAF8.setForeground(Color.WHITE);
        chAF8.setSelected(false);
        chAF8.setContentAreaFilled(false);
        chAF8.setFocusPainted(false);
        chAF8.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAF8);
        chAF9 = new JCheckBox("Others");
        chAF9.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAF9.setBounds(205, 70, 70, 30);
        chAF9.setForeground(Color.WHITE);
        chAF9.setSelected(false);
        chAF9.setContentAreaFilled(false);
        chAF9.setFocusPainted(false);
        chAF9.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAF9);
        JLabel lblFishE = new JLabel("Fishing Equipment/s:");
        lblFishE.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFishE.setForeground(Color.WHITE);
        lblFishE.setBounds(10, 95, 170, 30);
        pnl_User_Query5.add(lblFishE);
        chAE1 = new JCheckBox("Fish Net");
        chAE1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAE1.setBounds(5, 115, 80, 30);
        chAE1.setForeground(Color.WHITE);
        chAE1.setSelected(false);
        chAE1.setContentAreaFilled(false);
        chAE1.setFocusPainted(false);
        chAE1.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAE1);
        chAE2 = new JCheckBox("Electricity");
        chAE2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAE2.setBounds(105, 115, 90, 30);
        chAE2.setForeground(Color.WHITE);
        chAE2.setSelected(false);
        chAE2.setContentAreaFilled(false);
        chAE2.setFocusPainted(false);
        chAE2.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAE2);
        chAE3 = new JCheckBox("Bagnets");
        chAE3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAE3.setBounds(205, 115, 80, 30);
        chAE3.setForeground(Color.WHITE);
        chAE3.setSelected(false);
        chAE3.setContentAreaFilled(false);
        chAE3.setFocusPainted(false);
        chAE3.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAE3);
        chAE4 = new JCheckBox("Gillnets");
        chAE4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAE4.setBounds(5, 140, 80, 30);
        chAE4.setForeground(Color.WHITE);
        chAE4.setSelected(false);
        chAE4.setContentAreaFilled(false);
        chAE4.setFocusPainted(false);
        chAE4.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAE4);
        chAE5 = new JCheckBox("Traps");
        chAE5.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAE5.setBounds(105, 140, 60, 30);
        chAE5.setForeground(Color.WHITE);
        chAE5.setSelected(false);
        chAE5.setContentAreaFilled(false);
        chAE5.setFocusPainted(false);
        chAE5.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAE5);
        chAE6 = new JCheckBox("Hook & Lines");
        chAE6.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAE6.setBounds(205, 140, 100, 30);
        chAE6.setForeground(Color.WHITE);
        chAE6.setSelected(false);
        chAE6.setContentAreaFilled(false);
        chAE6.setFocusPainted(false);
        chAE6.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAE6);
        chAE7 = new JCheckBox("Sift Net");
        chAE7.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAE7.setBounds(5, 165, 80, 30);
        chAE7.setForeground(Color.WHITE);
        chAE7.setSelected(false);
        chAE7.setContentAreaFilled(false);
        chAE7.setFocusPainted(false);
        chAE7.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAE7);
        chAE8 = new JCheckBox("Others");
        chAE8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAE8.setBounds(105, 165, 70, 30);
        chAE8.setForeground(Color.WHITE);
        chAE8.setSelected(false);
        chAE8.setContentAreaFilled(false);
        chAE8.setFocusPainted(false);
        chAE8.addActionListener(new doActionListener());
        pnl_User_Query5.add(chAE8);
        
    }
    public void UserInputQuery6Panel(){
        pnl_User_Query6 = new JPanel();
        pnl_User_Query6.setBackground(Color.decode("#585555"));
	pnl_User_Query6.setBounds(0, 0, 300, 220);
	pnlUserInputs.add(pnl_User_Query6);
        pnl_User_Query6.setLayout(null);
        pnl_User_Query6.setVisible(false);
        
        JLabel lblCrop = new JLabel("Crop/s:");
        lblCrop.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblCrop.setForeground(Color.WHITE);
        lblCrop.setBounds(10, 2, 170, 30);
        pnl_User_Query6.add(lblCrop);
        rbSugarCane2 = new JRadioButton("Sugar Cane");
        rbSugarCane2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rbSugarCane2.setBounds(5, 30, 90, 30);
        rbSugarCane2.setForeground(Color.WHITE);
        rbSugarCane2.setSelected(false);
        rbSugarCane2.setContentAreaFilled(false);
        rbSugarCane2.setFocusPainted(false);
        rbSugarCane2.addActionListener(new doActionListener());
        pnl_User_Query6.add(rbSugarCane2);
        rbPalay2 = new JRadioButton("Palay");
        rbPalay2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rbPalay2.setBounds(85, 30, 70, 30);
        rbPalay2.setForeground(Color.WHITE);
        rbPalay2.setSelected(false);
        rbPalay2.setContentAreaFilled(false);
        rbPalay2.setFocusPainted(false);
        rbPalay2.addActionListener(new doActionListener());
        pnl_User_Query6.add(rbPalay2);
        rbCorn2 = new JRadioButton("Corn");
        rbCorn2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rbCorn2.setBounds(155, 30, 60, 30);
        rbCorn2.setForeground(Color.WHITE);
        rbCorn2.setSelected(false);
        rbCorn2.setContentAreaFilled(false);
        rbCorn2.setFocusPainted(false);
        rbCorn2.addActionListener(new doActionListener());
        pnl_User_Query6.add(rbCorn2);
        rbOthers2 = new JRadioButton("Others");
        rbOthers2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        rbOthers2.setBounds(225, 30, 70, 30);
        rbOthers2.setForeground(Color.WHITE);
        rbOthers2.setSelected(false);
        rbOthers2.setContentAreaFilled(false);
        rbOthers2.setFocusPainted(false);
        rbOthers2.addActionListener(new doActionListener());
        pnl_User_Query6.add(rbOthers2);
        bgCrops2 = new ButtonGroup();
        bgCrops2.add(rbPalay2);
        bgCrops2.add(rbSugarCane2);
        bgCrops2.add(rbCorn2);
        bgCrops2.add(rbOthers2);
    }
    public void UserInputQuery7Panel(){
        pnl_User_Query7 = new JPanel();
        pnl_User_Query7.setBackground(Color.decode("#585555"));
	pnl_User_Query7.setBounds(0, 0, 300, 220);
	pnlUserInputs.add(pnl_User_Query7);
        pnl_User_Query7.setLayout(null);
        pnl_User_Query7.setVisible(false);
        
        JLabel lblFishE = new JLabel("Fishing Equipment/s:");
        lblFishE.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFishE.setForeground(Color.WHITE);
        lblFishE.setBounds(10, 2, 170, 30);
        pnl_User_Query7.add(lblFishE);
        chAEQ1 = new JCheckBox("Fish Net");
        chAEQ1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAEQ1.setBounds(5, 25, 80, 30);
        chAEQ1.setForeground(Color.WHITE);
        chAEQ1.setSelected(false);
        chAEQ1.setContentAreaFilled(false);
        chAEQ1.setFocusPainted(false);
        chAEQ1.addActionListener(new doActionListener());
        pnl_User_Query7.add(chAEQ1);
        chAEQ2 = new JCheckBox("Electricity");
        chAEQ2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAEQ2.setBounds(105, 25, 90, 30);
        chAEQ2.setForeground(Color.WHITE);
        chAEQ2.setSelected(false);
        chAEQ2.setContentAreaFilled(false);
        chAEQ2.setFocusPainted(false);
        chAEQ2.addActionListener(new doActionListener());
        pnl_User_Query7.add(chAEQ2);
        chAEQ3 = new JCheckBox("Bagnets");
        chAEQ3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAEQ3.setBounds(205, 25, 80, 30);
        chAEQ3.setForeground(Color.WHITE);
        chAEQ3.setSelected(false);
        chAEQ3.setContentAreaFilled(false);
        chAEQ3.setFocusPainted(false);
        chAEQ3.addActionListener(new doActionListener());
        pnl_User_Query7.add(chAEQ3);
        chAEQ4 = new JCheckBox("Gillnets");
        chAEQ4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAEQ4.setBounds(5, 50, 80, 30);
        chAEQ4.setForeground(Color.WHITE);
        chAEQ4.setSelected(false);
        chAEQ4.setContentAreaFilled(false);
        chAEQ4.setFocusPainted(false);
        chAEQ4.addActionListener(new doActionListener());
        pnl_User_Query7.add(chAEQ4);
        chAEQ5 = new JCheckBox("Traps");
        chAEQ5.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAEQ5.setBounds(105, 50, 60, 30);
        chAEQ5.setForeground(Color.WHITE);
        chAEQ5.setSelected(false);
        chAEQ5.setContentAreaFilled(false);
        chAEQ5.setFocusPainted(false);
        chAEQ5.addActionListener(new doActionListener());
        pnl_User_Query7.add(chAEQ5);
        chAEQ6 = new JCheckBox("Hook & Lines");
        chAEQ6.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAEQ6.setBounds(205, 50, 100, 30);
        chAEQ6.setForeground(Color.WHITE);
        chAEQ6.setSelected(false);
        chAEQ6.setContentAreaFilled(false);
        chAEQ6.setFocusPainted(false);
        chAEQ6.addActionListener(new doActionListener());
        pnl_User_Query7.add(chAEQ6);
        chAEQ7 = new JCheckBox("Sift Net");
        chAEQ7.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAEQ7.setBounds(5, 75, 80, 30);
        chAEQ7.setForeground(Color.WHITE);
        chAEQ7.setSelected(false);
        chAEQ7.setContentAreaFilled(false);
        chAEQ7.setFocusPainted(false);
        chAEQ7.addActionListener(new doActionListener());
        pnl_User_Query7.add(chAEQ7);
        chAEQ8 = new JCheckBox("Others");
        chAEQ8.setFont(new Font("Tahoma", Font.PLAIN, 11));
        chAEQ8.setBounds(105, 75, 70, 30);
        chAEQ8.setForeground(Color.WHITE);
        chAEQ8.setSelected(false);
        chAEQ8.setContentAreaFilled(false);
        chAEQ8.setFocusPainted(false);
        chAEQ8.addActionListener(new doActionListener());
        pnl_User_Query7.add(chAEQ8);
        
        JLabel lblFishVol = new JLabel("Total Fish Volume(greater than):");
        lblFishVol.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFishVol.setForeground(Color.WHITE);
        lblFishVol.setBounds(10, 100, 190, 30);
        pnl_User_Query7.add(lblFishVol);
        txtFishVol = new JTextField();
        txtFishVol.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtFishVol.setBounds(200, 107, 40, 17);
        pnl_User_Query7.add(txtFishVol);
        
    }
    public void normalButtonState(){
        btnQuery1.setBackground(Color.decode("#bfbfbf"));
        btnQuery2.setBackground(Color.decode("#bfbfbf"));
        btnQuery3.setBackground(Color.decode("#bfbfbf"));
        btnQuery4.setBackground(Color.decode("#bfbfbf"));
        btnQuery5.setBackground(Color.decode("#bfbfbf"));
        btnQuery6.setBackground(Color.decode("#bfbfbf"));
        btnQuery7.setBackground(Color.decode("#bfbfbf"));
        btnQuery1.setForeground(Color.decode("#585555"));
        btnQuery2.setForeground(Color.decode("#585555"));
        btnQuery3.setForeground(Color.decode("#585555"));
        btnQuery4.setForeground(Color.decode("#585555"));
        btnQuery5.setForeground(Color.decode("#585555"));
        btnQuery6.setForeground(Color.decode("#585555"));
        btnQuery7.setForeground(Color.decode("#585555"));
        btnQuery1.setSelected(false);
        btnQuery2.setSelected(false);
        btnQuery3.setSelected(false);
        btnQuery4.setSelected(false);
        btnQuery5.setSelected(false);
        btnQuery6.setSelected(false);
        btnQuery7.setSelected(false);
        pnl_User_Query1.setVisible(false);
        pnl_User_Query2.setVisible(false);
        pnl_User_Query3.setVisible(false);
        pnl_User_Query4.setVisible(false);
        pnl_User_Query5.setVisible(false);
        pnl_User_Query6.setVisible(false);
        pnl_User_Query7.setVisible(false);
    }
    public class doActionListener implements ActionListener{
        
        public void actionPerformed(ActionEvent action){
            if(action.getSource() == btnQuery1){
                normalButtonState(); //change all back to normal
                btnQuery1.setBackground(Color.decode("#82837e")); //then change the selected
                btnQuery1.setForeground(Color.decode("#e5e1db"));
                btnQuery1.setSelected(true);
                pnl_User_Query1.setVisible(true);
            }else if(action.getSource() == btnQuery2){
                normalButtonState(); //change all back to normal
                btnQuery2.setBackground(Color.decode("#82837e")); //then change the selected
                btnQuery2.setForeground(Color.decode("#e5e1db"));
                btnQuery2.setSelected(true);
                pnl_User_Query2.setVisible(true);
            }else if(action.getSource() == btnQuery3){
                normalButtonState(); //change all back to normal
                btnQuery3.setBackground(Color.decode("#82837e")); //then change the selected
                btnQuery3.setForeground(Color.decode("#e5e1db"));
                btnQuery3.setSelected(true);
                pnl_User_Query3.setVisible(true);
            }else if(action.getSource() == btnQuery4){
                normalButtonState(); //change all back to normal
                btnQuery4.setBackground(Color.decode("#82837e")); //then change the selected
                btnQuery4.setForeground(Color.decode("#e5e1db"));
                btnQuery4.setSelected(true);
                pnl_User_Query4.setVisible(true);
            }else if(action.getSource() == btnQuery5){
                normalButtonState(); //change all back to normal
                btnQuery5.setBackground(Color.decode("#82837e")); //then change the selected
                btnQuery5.setForeground(Color.decode("#e5e1db"));
                btnQuery5.setSelected(true);
                pnl_User_Query5.setVisible(true);
            }else if(action.getSource() == btnQuery6){
                normalButtonState(); //change all back to normal
                btnQuery6.setBackground(Color.decode("#82837e")); //then change the selected
                btnQuery6.setForeground(Color.decode("#e5e1db"));
                btnQuery6.setSelected(true);
                pnl_User_Query6.setVisible(true);
            }else if(action.getSource() == btnQuery7){
                normalButtonState(); //change all back to normal
                btnQuery7.setBackground(Color.decode("#82837e")); //then change the selected
                btnQuery7.setForeground(Color.decode("#e5e1db"));
                btnQuery7.setSelected(true);
                pnl_User_Query7.setVisible(true);
            }else if(action.getSource() == infoQuery){
                JOptionPane.showMessageDialog(null, "Query 1:\nQuery 2:\nQuery 3:\nQuery 4:\nQuery 5:\nQuery 6:\nQuery 7:", "About",JOptionPane.INFORMATION_MESSAGE);
            }else if(action.getSource() == btnExecute){
                if(btnQuery1.isSelected() == true){
                    int sch_type=0, sex=0, sss_ind=0;
                    
                    if(rbPublicSch.isSelected()) sch_type = 1;
                    else if(rbPrivateSch.isSelected()) sch_type = 2;
                    else if(rbBothSch.isSelected()) sch_type = 3;
                    
                    if(rbMale.isSelected()) sex = 1;
                    else if(rbFemale.isSelected()) sex = 2;
                    else if(rbBothSex.isSelected()) sex = 3;
                    
                    if(rbSSS.isSelected()) sss_ind = 1;
                    else if(rbGSIS.isSelected()) sss_ind = 2;
                    else if(rbBothAgency.isSelected()) sss_ind = 3;
                    else if(rbNeitherAgency.isSelected()) sss_ind = 4;
                    
                    if(rbNormal.isSelected())controller.loadQuery1RS(sch_type,sex,sss_ind, 1); //last param, 1-normal,2-heuristic,3-index,4-views,5-storedprocedure
                    else if(rbHeuristics.isSelected())controller.loadQuery1RS(sch_type,sex,sss_ind, 2);
                    else if(rbIndexes.isSelected())controller.loadQuery1RS(sch_type,sex,sss_ind, 3);
                    else if(rbViews.isSelected())controller.loadQuery1RS(sch_type,sex,sss_ind, 4);
                    else if(rbStoredProcedure.isSelected())controller.loadQuery1RS(sch_type,sex,sss_ind, 5);
                }else if(btnQuery2.isSelected() == true){
                    // 1- YES, 2- NO
                    int c1 = 2,c2 = 2,c3 = 2,c4 = 2,c5 = 2,c6 = 2,c7 = 2,c8 = 2,c9 = 2,c10 = 2,c11 = 2;
                    int v1 = 0,v2 = 0,v3 = 0,v4 = 0,v5 = 0,v6 = 0,v7 = 0,v8 = 0,v9 = 0,v10 = 0,v11 = 0;
                    
                    if(chCalam1.isSelected()) c1 = 1;if(chCalam6.isSelected()) c6 = 1;if(chCalam11.isSelected()) c11 = 1;
                    if(chCalam2.isSelected()) c2 = 1;if(chCalam7.isSelected()) c7 = 1;if(!txtCalam5.getText().equalsIgnoreCase("")) v5 = Integer.parseInt(txtCalam5.getText());
                    if(chCalam3.isSelected()) c3 = 1;if(chCalam8.isSelected()) c8 = 1;if(!txtCalam6.getText().equalsIgnoreCase("")) v6 = Integer.parseInt(txtCalam6.getText());
                    if(chCalam4.isSelected()) c4 = 1;if(chCalam9.isSelected()) c9 = 1;if(!txtCalam7.getText().equalsIgnoreCase("")) v7 = Integer.parseInt(txtCalam7.getText());
                    if(chCalam5.isSelected()) c5 = 1;if(chCalam10.isSelected()) c10 = 1;if(!txtCalam8.getText().equalsIgnoreCase("")) v8 = Integer.parseInt(txtCalam8.getText());
                    if(!txtCalam1.getText().equalsIgnoreCase("")) v1 = Integer.parseInt(txtCalam1.getText());if(!txtCalam9.getText().equalsIgnoreCase("")) v9 = Integer.parseInt(txtCalam9.getText());
                    if(!txtCalam2.getText().equalsIgnoreCase("")) v2 = Integer.parseInt(txtCalam2.getText());if(!txtCalam10.getText().equalsIgnoreCase("")) v10 = Integer.parseInt(txtCalam10.getText());
                    if(!txtCalam3.getText().equalsIgnoreCase("")) v3 = Integer.parseInt(txtCalam3.getText());if(!txtCalam11.getText().equalsIgnoreCase("")) v11 = Integer.parseInt(txtCalam11.getText());
                    if(!txtCalam4.getText().equalsIgnoreCase("")) v4 = Integer.parseInt(txtCalam4.getText());
                    
                    if(rbNormal.isSelected())controller.loadQuery2RS(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11, 1); //last param, 1-normal,2-heuristic,3-index,4-views,5-storedprocedure
                    else if(rbHeuristics.isSelected())controller.loadQuery2RS(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11, v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11, 2);
                    else if(rbIndexes.isSelected())controller.loadQuery2RS(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11, v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11, 3);
                    else if(rbViews.isSelected())controller.loadQuery2RS(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11, v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11, 4);
                    else if(rbStoredProcedure.isSelected())controller.loadQuery2RS(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11, v1, v2,v3,v4,v5,v6,v7,v8,v9,v10,v11, 5);
                }else if(btnQuery3.isSelected() == true){
                    int reg=0, sex=0, job=0, educ = 0, last =0, work = 0, death = 0;
                    
                    if(rbEmployed.isSelected()) job = 1;
                    else if(rbUnemployed.isSelected()) job = 2;
                    
                    if(rbCollege.isSelected()) educ = 300;
                    else if(rbMasters.isSelected()) educ = 400;
                    
                    if(rbMale2.isSelected()) sex = 1;
                    else if(rbFemale2.isSelected()) sex = 2;
                    else if(rbBothSex2.isSelected()) sex = 3;
                    
                    if(rbYes1.isSelected()) reg = 1;
                    else if(rbNo1.isSelected()) reg = 2;
                    
                    if(rbYes2.isSelected()) last = 1;
                    else if(rbNo2.isSelected()) last = 2;
                    else if(rbIDK.isSelected()) last = 3;
                    
                    work = cbWorkCl.getSelectedIndex()+1;
                    death = cbDeath.getSelectedIndex()+1;
                    
                    if(rbNormal.isSelected())controller.loadQuery3RS(sex,educ,reg,last,job,work,death, 1); //last param, 1-normal,2-heuristic,3-index,4-views,5-storedprocedure
                    else if(rbHeuristics.isSelected())controller.loadQuery3RS(sex,educ,reg,last,job,work,death, 2);
                    else if(rbIndexes.isSelected())controller.loadQuery3RS(sex,educ,reg,last,job,work,death, 3);
                    else if(rbViews.isSelected())controller.loadQuery3RS(sex,educ,reg,last,job,work,death, 4);
                    else if(rbStoredProcedure.isSelected())controller.loadQuery3RS(sex,educ,reg,last,job,work,death, 5);
                }else if(btnQuery4.isSelected() == true){
                    // 1- YES, 2- NO
                    int agri1 = 2,agri2 = 2,agri3 = 2,agri4 = 2,agri5 = 2,agri6 = 2,agri7 = 2,agri8 = 2,agri9 = 2,agri10 = 2,agri11 = 2,agri12 = 2,agri13 = 2,agri14 = 2,agri15 = 2,agri16 = 2,agri17 = 2,agri18 = 2;
                    int sugarcane = 2, palay = 2, corn = 2, others = 2;
                    
                    if(chAgriEquip1.isSelected()) agri1 = 1;
                    if(chAgriEquip2.isSelected()) agri2 = 1;
                    if(chAgriEquip3.isSelected()) agri3 = 1;
                    if(chAgriEquip4.isSelected()) agri4 = 1;
                    if(chAgriEquip5.isSelected()) agri5 = 1;
                    if(chAgriEquip6.isSelected()) agri6 = 1;
                    if(chAgriEquip7.isSelected()) agri7 = 1;
                    if(chAgriEquip8.isSelected()) agri8 = 1;
                    if(chAgriEquip9.isSelected()) agri9 = 1;
                    if(chAgriEquip10.isSelected()) agri10 = 1;
                    if(chAgriEquip11.isSelected()) agri11 = 1;
                    if(chAgriEquip12.isSelected()) agri12 = 1;
                    if(chAgriEquip13.isSelected()) agri13 = 1;
                    if(chAgriEquip14.isSelected()) agri14 = 1;
                    if(chAgriEquip15.isSelected()) agri15 = 1;
                    if(chAgriEquip16.isSelected()) agri16 = 1;
                    if(chAgriEquip17.isSelected()) agri17 = 1;
                    if(chAgriEquip18.isSelected()) agri18 = 1;
                    if(rbSugarCane.isSelected()) sugarcane = 1;
                    if(rbPalay.isSelected()) palay= 1;
                    if(rbCorn.isSelected()) corn = 1;
                    if(rbOthers.isSelected()) others = 1;    
                                        
                    if(rbNormal.isSelected())controller.loadQuery4RS(agri1,agri2,agri3,agri4,agri5,agri6,agri7,agri8,agri9,agri10,agri11,agri12,agri13,agri14,agri15,agri16,agri17,agri18,sugarcane,palay,corn,others, 1); //last param, 1-normal,2-heuristic,3-index,4-views,5-storedprocedure
                    else if(rbHeuristics.isSelected())controller.loadQuery4RS(agri1,agri2,agri3,agri4,agri5,agri6,agri7,agri8,agri9,agri10,agri11,agri12,agri13,agri14,agri15,agri16,agri17,agri18,sugarcane,palay,corn,others, 2);
                    else if(rbIndexes.isSelected())controller.loadQuery4RS(agri1,agri2,agri3,agri4,agri5,agri6,agri7,agri8,agri9,agri10,agri11,agri12,agri13,agri14,agri15,agri16,agri17,agri18,sugarcane,palay,corn,others, 3);
                    else if(rbViews.isSelected())controller.loadQuery4RS(agri1,agri2,agri3,agri4,agri5,agri6,agri7,agri8,agri9,agri10,agri11,agri12,agri13,agri14,agri15,agri16,agri17,agri18,sugarcane,palay,corn,others, 4);
                    else if(rbStoredProcedure.isSelected())controller.loadQuery4RS(agri1,agri2,agri3,agri4,agri5,agri6,agri7,agri8,agri9,agri10,agri11,agri12,agri13,agri14,agri15,agri16,agri17,agri18,sugarcane,palay,corn,others, 5);
                }else if(btnQuery5.isSelected() == true){
                    // 1- YES, 2- NO
                    int af1 = 2, af2 = 2, af3 = 2, af4 = 2, af5 = 2, af6 = 2, af7 = 2, af8 = 2, af9  =2;
                    int ae1 = 2, ae2 = 2, ae3 = 2, ae4 = 2, ae5 = 2, ae6 = 2, ae7 = 2, ae8 = 2;
                    
                    if(chAF1.isSelected()) af1 = 1;if(chAF6.isSelected()) af6 = 1;if(chAE1.isSelected()) ae1 = 1;if(chAE6.isSelected()) ae6 = 1;
                    if(chAF2.isSelected()) af2 = 1;if(chAF7.isSelected()) af7 = 1;if(chAE2.isSelected()) ae2 = 1;if(chAE7.isSelected()) ae7 = 1;
                    if(chAF3.isSelected()) af3 = 1;if(chAF8.isSelected()) af8 = 1;if(chAE3.isSelected()) ae3 = 1;if(chAE8.isSelected()) ae8 = 1;
                    if(chAF4.isSelected()) af4 = 1;if(chAF9.isSelected()) af9 = 1;if(chAE4.isSelected()) ae4 = 1;
                    if(chAF5.isSelected()) af5 = 1;                               if(chAE5.isSelected()) ae5 = 1;
                    
                    if(rbNormal.isSelected())controller.loadQuery5RS(af1,af2,af3,af4,af5,af6,af7,af8,af9,ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, 1); //last param, 1-normal,2-heuristic,3-index,4-views,5-storedprocedure
                    else if(rbHeuristics.isSelected())controller.loadQuery5RS(af1,af2,af3,af4,af5,af6,af7,af8,af9,ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, 2);
                    else if(rbIndexes.isSelected())controller.loadQuery5RS(af1,af2,af3,af4,af5,af6,af7,af8,af9,ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, 3);
                    else if(rbViews.isSelected())controller.loadQuery5RS(af1,af2,af3,af4,af5,af6,af7,af8,af9,ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, 4);
                    else if(rbStoredProcedure.isSelected())controller.loadQuery5RS(af1,af2,af3,af4,af5,af6,af7,af8,af9,ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, 5);
                }else if(btnQuery6.isSelected() == true){
                    // 1- YES, 2- NO
                    int sugarcane = 2, palay = 2, corn = 2, others = 2;
                    
                    if(rbCorn2.isSelected()) corn = 1;
                    if(rbOthers2.isSelected()) others = 1;
                    if(rbSugarCane2.isSelected()) sugarcane = 1;
                    if(rbPalay2.isSelected()) palay= 1;
                    
                    if(rbNormal.isSelected())controller.loadQuery6RS(sugarcane,palay,corn,others, 1); //last param, 1-normal,2-heuristic,3-index,4-views,5-storedprocedure
                    else if(rbHeuristics.isSelected())controller.loadQuery6RS(sugarcane,palay,corn,others, 2);
                    else if(rbIndexes.isSelected())controller.loadQuery6RS(sugarcane,palay,corn,others, 3);
                    else if(rbViews.isSelected())controller.loadQuery6RS(sugarcane,palay,corn,others, 4);
                    else if(rbStoredProcedure.isSelected())controller.loadQuery6RS(sugarcane,palay,corn,others, 5);
                }else if(btnQuery7.isSelected() == true){
                    // 1- YES, 2- NO
                    int ae1 = 2, ae2 = 2, ae3 = 2, ae4 = 2, ae5 = 2, ae6 = 2, ae7 = 2, ae8 = 2, amount = 2;
                    
                    if(chAEQ1.isSelected()) ae1 = 1;if(chAEQ5.isSelected()) ae5 = 1;
                    if(chAEQ2.isSelected()) ae2 = 1;if(chAEQ6.isSelected()) ae6 = 1;
                    if(chAEQ3.isSelected()) ae3 = 1;if(chAEQ7.isSelected()) ae7 = 1;
                    if(chAEQ4.isSelected()) ae4 = 1;if(chAEQ8.isSelected()) ae8 = 1;
                    if(!txtFishVol.getText().equalsIgnoreCase("")) amount = Integer.parseInt(txtFishVol.getText());
 
                    if(rbNormal.isSelected())controller.loadQuery7RS(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount, 1); //last param, 1-normal,2-heuristic,3-index,4-views,5-storedprocedure
                    else if(rbHeuristics.isSelected())controller.loadQuery7RS(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8,amount,  2);
                    else if(rbIndexes.isSelected())controller.loadQuery7RS(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount, 3);
                    else if(rbViews.isSelected())controller.loadQuery7RS(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount, 4);
                    else if(rbStoredProcedure.isSelected())controller.loadQuery7RS(ae1,ae2,ae3,ae4,ae5,ae6,ae7,ae8, amount, 5);
                }
            }
        }
    }
    
    public void sendRSToTable(ResultSet rs){
        tpDataTable.setResultSet(rs);
    }
    
    public void postExecutionTimeAndTupleVal(double time, int numoftuples){
        lblEstimatedTime.setText("Estimated Execution Time: "+ time + " seconds. "+ numoftuples + " row(s) returned."  );
        repaint();
        revalidate();
    }
}
