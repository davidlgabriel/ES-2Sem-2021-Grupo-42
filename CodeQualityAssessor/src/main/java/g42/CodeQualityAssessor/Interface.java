package g42.CodeQualityAssessor;

import javax.swing.JButton;
import javax.swing.JDialog;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.script.ScriptException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Font;
import java.awt.Color;

public class Interface extends JDialog {

	public static void main(String[] args) {
		try {
			Interface dialog = new Interface();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private EscreverMétricasParaExcel excel = null;
	private VerificacaoCodeSmells verificarCS = null;
	private File selectedFile = null;
	private ArrayList<String> caminhoFicheiros = new ArrayList<>();
	private JTextField textField2_LM;
	private JTextField textField1_LM;
	private JTextField textField1_GC;
	private JTextField textField2_GC;
	private JTextField textField3_LM;
	private JTextField textField4_LM;
	private JTextField textField3_GC;
	private JTextField textField4_GC;
	private JTextField textField5_GC;
	private JTextField textField6_GC;
	private JLabel label1_LM;
	private JLabel label5_LM;
	private JLabel label5_GC;
	private JLabel label6_GC;
	private JLabel label1_GC;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JComboBox firstOfSecond_LM;
	private JComboBox LM_And_Or;
	private JComboBox firstOfFirst_LM;
	private JComboBox secondOfFirst_LM;
	private JComboBox secondOfSecond_LM;
	private JComboBox GC_And_Or;
	private JComboBox firstOfSecond_GC;
	private JComboBox secondOfSecond_GC;
	private JComboBox second_GC_And_Or;
	private JComboBox firstOfThird_GC;
	private JComboBox secondOfThird_GC;
	private JComboBox secondOfFirst_GC;
	private JComboBox isTrueFalse_LM;
	private JComboBox firstOfFirst_GC;
	private JComboBox isTrueFalse_GC;
	private JTextField textFieldNome_LM;
	private JButton CreateButton_LM;
	private JButton SaveButton_LM;
	private JComboBox comboBox;
	private JLabel labelNome_LM;
	private JLabel labelNome2;
	private JTextField textFieldNome2;
	private JButton SaveButton_GC;
	private JButton CreateButton_GC;
	private JComboBox comboBox2;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JButton CreateButton2;

	private String regraLMAlterar = "";
	private String regraGCAlterar = "";

	private HashMap<String, Regra> regrasGodClass = new HashMap<>();
	private HashMap<String, Regra> regrasLongMethod = new HashMap<>();

	public Interface() {
        this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosed(WindowEvent e) {
				guardarRegras();
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		setBounds(100, 100, 1386, 566);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 19, 20, 20, 110, 25, 4, 30, 50, 40, 50, 30, 75, 30, 32, 30, 11, 18, 37,
				100, 70 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 30, 35, 35, 0, 0, 0, 28, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0 };
		getContentPane().setLayout(gridBagLayout);

		JLabel if_LM = new JLabel("IF");
		if_LM.setHorizontalAlignment(SwingConstants.CENTER);
		if_LM.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_if_LM = new GridBagConstraints();
		gbc_if_LM.insets = new Insets(0, 0, 5, 5);
		gbc_if_LM.gridx = 1;
		gbc_if_LM.gridy = 0;
		getContentPane().add(if_LM, gbc_if_LM);

		// LM First 1
		firstOfFirst_LM = new JComboBox(new String[] { "LOC_method", "CYCLO_method" });
		firstOfFirst_LM.setModel(new DefaultComboBoxModel(new String[] { "LOC_method", "CYCLO_method" }));
		firstOfFirst_LM.setForeground(Color.BLACK);
		firstOfFirst_LM.setBackground(Color.WHITE);
		GridBagConstraints gbc_firstOfFirst_LM = new GridBagConstraints();
		gbc_firstOfFirst_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstOfFirst_LM.insets = new Insets(0, 0, 5, 5);
		gbc_firstOfFirst_LM.gridx = 3;
		gbc_firstOfFirst_LM.gridy = 0;
		getContentPane().add(firstOfFirst_LM, gbc_firstOfFirst_LM);

		// LM First 2
		secondOfFirst_LM = new JComboBox(new String[] { "IS BETWEEN", "=", ">", "<", ">=", "<=" });
		secondOfFirst_LM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (secondOfFirst_LM.getSelectedItem().equals("IS BETWEEN")) {
					label1_LM.setVisible(true);
					textField2_LM.setVisible(true);
				} else {
					label1_LM.setVisible(false);
					textField2_LM.setVisible(false);
				}
			}
		});
		secondOfFirst_LM.setBackground(Color.WHITE);
		secondOfFirst_LM.setForeground(Color.BLACK);
		GridBagConstraints gbc_secondOfFirst_LM = new GridBagConstraints();
		gbc_secondOfFirst_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondOfFirst_LM.insets = new Insets(0, 0, 5, 5);
		gbc_secondOfFirst_LM.gridx = 5;
		gbc_secondOfFirst_LM.gridy = 0;
		getContentPane().add(secondOfFirst_LM, gbc_secondOfFirst_LM);

		textField1_LM = new JTextField();
		textField1_LM.setColumns(10);
		GridBagConstraints gbc_textField1_LM = new GridBagConstraints();
		gbc_textField1_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField1_LM.insets = new Insets(0, 0, 5, 5);
		gbc_textField1_LM.gridx = 7;
		gbc_textField1_LM.gridy = 0;
		getContentPane().add(textField1_LM, gbc_textField1_LM);
		textField1_LM.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		label1_LM = new JLabel("AND");
		label1_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label1_LM.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label1_LM = new GridBagConstraints();
		gbc_label1_LM.fill = GridBagConstraints.BOTH;
		gbc_label1_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label1_LM.gridx = 8;
		gbc_label1_LM.gridy = 0;
		getContentPane().add(label1_LM, gbc_label1_LM);

		textField2_LM = new JTextField();
		textField2_LM.setColumns(10);
		GridBagConstraints gbc_textField2_LM = new GridBagConstraints();
		gbc_textField2_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField2_LM.insets = new Insets(0, 0, 5, 5);
		gbc_textField2_LM.gridx = 9;
		gbc_textField2_LM.gridy = 0;
		getContentPane().add(textField2_LM, gbc_textField2_LM);
		textField2_LM.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if ((((caracter < '0') || (caracter > '9')) && (caracter != '\b'))) {
					e.consume();
				}
			}
		});

		// LM SECOND 1
		firstOfSecond_LM = new JComboBox(new String[] { "LOC_method", "CYCLO_method" });
		firstOfSecond_LM.setModel(new DefaultComboBoxModel(new String[] { "LOC_method", "CYCLO_method" }));
		firstOfSecond_LM.setForeground(Color.BLACK);
		firstOfSecond_LM.setBackground(Color.WHITE);
		firstOfSecond_LM.setVisible(false);
		isTrueFalse_LM = new JComboBox(new String[] { "TRUE", "FALSE" });
		isTrueFalse_LM.setForeground(Color.BLACK);
		isTrueFalse_LM.setBackground(Color.WHITE);
		GridBagConstraints gbc_isTrueFalse_LM = new GridBagConstraints();
		gbc_isTrueFalse_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_isTrueFalse_LM.insets = new Insets(0, 0, 5, 5);
		gbc_isTrueFalse_LM.gridx = 18;
		gbc_isTrueFalse_LM.gridy = 0;
		getContentPane().add(isTrueFalse_LM, gbc_isTrueFalse_LM);

		SaveButton_LM = new JButton("Confirm");
		SaveButton_LM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((secondOfFirst_LM.getSelectedItem().equals("IS BETWEEN")
						&& (Integer.parseInt(textField1_LM.getText()) < Integer.parseInt(textField2_LM.getText()))
						&& !textField1_LM.getText().equals("") && !textField2_LM.getText().equals(""))
						|| (!secondOfFirst_LM.getSelectedItem().equals("IS BETWEEN")
								&& !textField1_LM.getText().equals(""))) {
					if (LM_And_Or.getSelectedItem().equals("AND") || LM_And_Or.getSelectedItem().equals("OR")) {
						if ((secondOfSecond_LM.getSelectedItem().equals("IS BETWEEN")
								&& (Integer.parseInt(textField3_LM.getText()) < Integer
										.parseInt(textField4_LM.getText()))
								&& !textField3_LM.getText().equals("") && !textField4_LM.getText().equals(""))
								|| (!secondOfSecond_LM.getSelectedItem().equals("IS BETWEEN")
										&& !textField3_LM.getText().equals(""))) {
							makeVisibleLM();
							makeEnableLM(false);
						}
					} else {
						makeVisibleLM();
						makeEnableLM(false);
					}
				}
			}
		});
		GridBagConstraints gbc_SaveButton_LM = new GridBagConstraints();
		gbc_SaveButton_LM.insets = new Insets(0, 0, 5, 5);
		gbc_SaveButton_LM.gridx = 19;
		gbc_SaveButton_LM.gridy = 0;
		getContentPane().add(SaveButton_LM, gbc_SaveButton_LM);

		CreateButton_LM = new JButton("Create Rule");
		CreateButton_LM.setEnabled(false);
		CreateButton_LM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarRegraLM();
			}
		});
		CreateButton_LM.setVisible(true);
		GridBagConstraints gbc_CreateButton_LM = new GridBagConstraints();
		gbc_CreateButton_LM.insets = new Insets(0, 0, 5, 0);
		gbc_CreateButton_LM.gridx = 21;
		gbc_CreateButton_LM.gridy = 0;
		getContentPane().add(CreateButton_LM, gbc_CreateButton_LM);
		GridBagConstraints gbc_firstOfSecond_LM = new GridBagConstraints();
		gbc_firstOfSecond_LM.insets = new Insets(0, 0, 5, 5);
		gbc_firstOfSecond_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstOfSecond_LM.gridx = 3;
		gbc_firstOfSecond_LM.gridy = 1;
		getContentPane().add(firstOfSecond_LM, gbc_firstOfSecond_LM);

		LM_And_Or = new JComboBox(new String[] { "", "AND", "OR" });
		LM_And_Or.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (LM_And_Or.getSelectedItem().equals("")) {
					firstOfSecond_LM.setVisible(false);
					secondOfSecond_LM.setVisible(false);
					textField3_LM.setVisible(false);
					label5_LM.setVisible(false);
					textField4_LM.setVisible(false);
					textField3_LM.setText("");
					textField4_LM.setText("");

				} else {
					firstOfSecond_LM.setVisible(true);
					secondOfSecond_LM.setVisible(true);
					textField3_LM.setVisible(true);
					label5_LM.setVisible(true);
					textField4_LM.setVisible(true);
					secondOfSecond_LM.setSelectedItem("IS BETWEEN");

				}
			}
		});
		LM_And_Or.setForeground(Color.BLACK);
		LM_And_Or.setBackground(Color.WHITE);
		GridBagConstraints gbc_LM_And_Or = new GridBagConstraints();
		gbc_LM_And_Or.fill = GridBagConstraints.HORIZONTAL;
		gbc_LM_And_Or.insets = new Insets(0, 0, 5, 5);
		gbc_LM_And_Or.gridx = 11;
		gbc_LM_And_Or.gridy = 0;
		getContentPane().add(LM_And_Or, gbc_LM_And_Or);

		JLabel label2_LM = new JLabel("THAN");
		label2_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label2_LM.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label2_LM = new GridBagConstraints();
		gbc_label2_LM.anchor = GridBagConstraints.WEST;
		gbc_label2_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label2_LM.gridx = 13;
		gbc_label2_LM.gridy = 0;
		getContentPane().add(label2_LM, gbc_label2_LM);

		JLabel label3_LM = new JLabel("is_Long_Method");
		label3_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label3_LM.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_label3_LM = new GridBagConstraints();
		gbc_label3_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_label3_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label3_LM.gridx = 15;
		gbc_label3_LM.gridy = 0;
		getContentPane().add(label3_LM, gbc_label3_LM);

		JLabel label4_LM = new JLabel("IS");
		label4_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label4_LM.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label4_LM = new GridBagConstraints();
		gbc_label4_LM.fill = GridBagConstraints.BOTH;
		gbc_label4_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label4_LM.gridx = 17;
		gbc_label4_LM.gridy = 0;
		getContentPane().add(label4_LM, gbc_label4_LM);

		// LM Second 2
		secondOfSecond_LM = new JComboBox(new String[] { "IS BETWEEN", "=", ">", "<", ">=", "<=" });
		secondOfSecond_LM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (secondOfSecond_LM.getSelectedItem().equals("IS BETWEEN")) {
					label5_LM.setVisible(true);
					textField4_LM.setVisible(true);
				} else {
					label5_LM.setVisible(false);
					textField4_LM.setVisible(false);
				}
			}
		});
		secondOfSecond_LM.setForeground(Color.BLACK);
		secondOfSecond_LM.setBackground(Color.WHITE);
		secondOfSecond_LM.setVisible(false);
		GridBagConstraints gbc_secondOfSecond_LM = new GridBagConstraints();
		gbc_secondOfSecond_LM.insets = new Insets(0, 0, 5, 5);
		gbc_secondOfSecond_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondOfSecond_LM.gridx = 5;
		gbc_secondOfSecond_LM.gridy = 1;
		getContentPane().add(secondOfSecond_LM, gbc_secondOfSecond_LM);

		textField3_LM = new JTextField();
		textField3_LM.setColumns(10);
		textField3_LM.setVisible(false);
		GridBagConstraints gbc_textField3_LM = new GridBagConstraints();
		gbc_textField3_LM.insets = new Insets(0, 0, 5, 5);
		gbc_textField3_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField3_LM.gridx = 7;
		gbc_textField3_LM.gridy = 1;
		getContentPane().add(textField3_LM, gbc_textField3_LM);
		textField3_LM.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		label5_LM = new JLabel("AND");
		label5_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label5_LM.setFont(new Font("Arial", Font.PLAIN, 12));
		label5_LM.setVisible(false);
		GridBagConstraints gbc_label5_LM = new GridBagConstraints();
		gbc_label5_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label5_LM.gridx = 8;
		gbc_label5_LM.gridy = 1;
		getContentPane().add(label5_LM, gbc_label5_LM);

		textField4_LM = new JTextField();
		textField4_LM.setColumns(10);
		textField4_LM.setVisible(false);
		GridBagConstraints gbc_textField4_LM = new GridBagConstraints();
		gbc_textField4_LM.insets = new Insets(0, 0, 5, 5);
		gbc_textField4_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField4_LM.gridx = 9;
		gbc_textField4_LM.gridy = 1;
		getContentPane().add(textField4_LM, gbc_textField4_LM);
		textField4_LM.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		textFieldNome_LM = new JTextField();
		textFieldNome_LM.setEnabled(false);
		textFieldNome_LM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!textFieldNome_LM.getText().equals("") && e.getKeyCode() != 32) {
					CreateButton_LM.setEnabled(true);
				} else {
					CreateButton_LM.setEnabled(false);
				}
			}
		});

		labelNome_LM = new JLabel("Nome :");
		GridBagConstraints gbc_labelNome_LM = new GridBagConstraints();
		gbc_labelNome_LM.anchor = GridBagConstraints.EAST;
		gbc_labelNome_LM.insets = new Insets(0, 0, 5, 5);
		gbc_labelNome_LM.gridx = 18;
		gbc_labelNome_LM.gridy = 1;
		getContentPane().add(labelNome_LM, gbc_labelNome_LM);
		GridBagConstraints gbc_textFieldNome_LM = new GridBagConstraints();
		gbc_textFieldNome_LM.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNome_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNome_LM.gridx = 19;
		gbc_textFieldNome_LM.gridy = 1;
		getContentPane().add(textFieldNome_LM, gbc_textFieldNome_LM);
		textFieldNome_LM.setColumns(10);

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 21;
		gbc_comboBox.gridy = 1;
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				regraLMAlterar = (String) comboBox.getSelectedItem();
				if (regraLMAlterar==null || regraLMAlterar.equals(""))
					resetCamposLM();
				else
					alterarRegraLM();
			}
		});
		getContentPane().add(comboBox, gbc_comboBox);

		JLabel if_GC = new JLabel("IF");
		if_GC.setHorizontalAlignment(SwingConstants.CENTER);
		if_GC.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_if_GC = new GridBagConstraints();
		gbc_if_GC.insets = new Insets(0, 0, 5, 5);
		gbc_if_GC.gridx = 1;
		gbc_if_GC.gridy = 3;
		getContentPane().add(if_GC, gbc_if_GC);

		firstOfFirst_GC = new JComboBox(new String[] { "NOM_class", "LOC_class", "WMC_class" });
		firstOfFirst_GC.setForeground(Color.BLACK);
		firstOfFirst_GC.setBackground(Color.WHITE);
		GridBagConstraints gbc_firstOfFirst_GC = new GridBagConstraints();
		gbc_firstOfFirst_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstOfFirst_GC.insets = new Insets(0, 0, 5, 5);
		gbc_firstOfFirst_GC.gridx = 3;
		gbc_firstOfFirst_GC.gridy = 3;
		getContentPane().add(firstOfFirst_GC, gbc_firstOfFirst_GC);

		secondOfFirst_GC = new JComboBox(new String[] { "IS BETWEEN", "=", ">", "<", ">=", "<=" });
		secondOfFirst_GC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (secondOfFirst_GC.getSelectedItem().equals("IS BETWEEN")) {
					label1_GC.setVisible(true);
					textField2_GC.setVisible(true);
				} else {
					label1_GC.setVisible(false);
					textField2_GC.setVisible(false);
				}
			}
		});
		secondOfFirst_GC.setForeground(Color.BLACK);
		secondOfFirst_GC.setBackground(Color.WHITE);
		GridBagConstraints gbc_secondOfFirst_GC = new GridBagConstraints();
		gbc_secondOfFirst_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondOfFirst_GC.insets = new Insets(0, 0, 5, 5);
		gbc_secondOfFirst_GC.gridx = 5;
		gbc_secondOfFirst_GC.gridy = 3;
		getContentPane().add(secondOfFirst_GC, gbc_secondOfFirst_GC);

		textField1_GC = new JTextField();
		textField1_GC.setColumns(10);
		GridBagConstraints gbc_textField1_GC = new GridBagConstraints();
		gbc_textField1_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField1_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField1_GC.gridx = 7;
		gbc_textField1_GC.gridy = 3;
		getContentPane().add(textField1_GC, gbc_textField1_GC);
		textField1_GC.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		label1_GC = new JLabel("AND");
		label1_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label1_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label1_GC = new GridBagConstraints();
		gbc_label1_GC.fill = GridBagConstraints.VERTICAL;
		gbc_label1_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label1_GC.gridx = 8;
		gbc_label1_GC.gridy = 3;
		getContentPane().add(label1_GC, gbc_label1_GC);

		textField2_GC = new JTextField();
		textField2_GC.setColumns(10);
		GridBagConstraints gbc_textField2_GC = new GridBagConstraints();
		gbc_textField2_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField2_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField2_GC.gridx = 9;
		gbc_textField2_GC.gridy = 3;
		getContentPane().add(textField2_GC, gbc_textField2_GC);
		textField2_GC.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		GC_And_Or = new JComboBox(new String[] { "", "AND", "OR" });
		GC_And_Or.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (GC_And_Or.getSelectedItem().equals("")) {
					firstOfSecond_GC.setVisible(false);
					secondOfSecond_GC.setVisible(false);
					textField3_GC.setVisible(false);
					label5_GC.setVisible(false);
					textField4_GC.setVisible(false);
					second_GC_And_Or.setVisible(false);
					firstOfThird_GC.setVisible(false);
					secondOfThird_GC.setVisible(false);
					textField5_GC.setVisible(false);
					label6_GC.setVisible(false);
					textField6_GC.setVisible(false);
					textField6_GC.setText("");
					textField3_GC.setText("");
					textField4_GC.setText("");
					textField5_GC.setText("");
					textField6_GC.setText("");
				} else {
					firstOfSecond_GC.setVisible(true);
					secondOfSecond_GC.setVisible(true);
					textField3_GC.setVisible(true);
					label5_GC.setVisible(true);
					textField4_GC.setVisible(true);
					second_GC_And_Or.setVisible(true);
					secondOfSecond_GC.setSelectedItem("IS BETWEEN");
				}
			}
		});
		GC_And_Or.setForeground(Color.BLACK);
		GC_And_Or.setBackground(Color.WHITE);
		GridBagConstraints gbc_GC_And_Or = new GridBagConstraints();
		gbc_GC_And_Or.fill = GridBagConstraints.HORIZONTAL;
		gbc_GC_And_Or.insets = new Insets(0, 0, 5, 5);
		gbc_GC_And_Or.gridx = 11;
		gbc_GC_And_Or.gridy = 3;
		getContentPane().add(GC_And_Or, gbc_GC_And_Or);

		JLabel label2_GC = new JLabel("THAN");
		label2_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label2_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label2_GC = new GridBagConstraints();
		gbc_label2_GC.anchor = GridBagConstraints.WEST;
		gbc_label2_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label2_GC.gridx = 13;
		gbc_label2_GC.gridy = 3;
		getContentPane().add(label2_GC, gbc_label2_GC);

		JLabel label3_GC = new JLabel("is_God_Class");
		label3_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label3_GC.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_label3_GC = new GridBagConstraints();
		gbc_label3_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_label3_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label3_GC.gridx = 15;
		gbc_label3_GC.gridy = 3;
		getContentPane().add(label3_GC, gbc_label3_GC);

		JLabel label4_GC = new JLabel("IS");
		label4_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label4_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label4_GC = new GridBagConstraints();
		gbc_label4_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_label4_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label4_GC.gridx = 17;
		gbc_label4_GC.gridy = 3;
		getContentPane().add(label4_GC, gbc_label4_GC);

		isTrueFalse_GC = new JComboBox(new String[] { "TRUE", "FALSE" });
		isTrueFalse_GC.setForeground(Color.BLACK);
		isTrueFalse_GC.setBackground(Color.WHITE);
		GridBagConstraints gbc_isTrueFalse_GC = new GridBagConstraints();
		gbc_isTrueFalse_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_isTrueFalse_GC.insets = new Insets(0, 0, 5, 5);
		gbc_isTrueFalse_GC.gridx = 18;
		gbc_isTrueFalse_GC.gridy = 3;
		getContentPane().add(isTrueFalse_GC, gbc_isTrueFalse_GC);

		SaveButton_GC = new JButton("Confirm");
		SaveButton_GC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((secondOfFirst_GC.getSelectedItem().equals("IS BETWEEN") && !textField1_GC.getText().equals("")
						&& !textField2_GC.getText().equals("")
						&& (Integer.parseInt(textField1_GC.getText()) < Integer.parseInt(textField2_GC.getText())))
						|| (!secondOfFirst_GC.getSelectedItem().equals("IS BETWEEN")
								&& !textField1_GC.getText().equals(""))) {
					if (GC_And_Or.getSelectedItem().equals("AND") || GC_And_Or.getSelectedItem().equals("OR")) {
						if ((secondOfSecond_GC.getSelectedItem().equals("IS BETWEEN")
								&& !textField3_GC.getText().equals("") && !textField4_GC.getText().equals("")
								&& (Integer.parseInt(textField3_GC.getText()) < Integer
										.parseInt(textField4_GC.getText())))
								|| (!secondOfSecond_GC.getSelectedItem().equals("IS BETWEEN")
										&& !textField3_GC.getText().equals(""))) {
							if (second_GC_And_Or.getSelectedItem().equals("AND")
									|| second_GC_And_Or.getSelectedItem().equals("OR")) {
								if ((secondOfThird_GC.getSelectedItem().equals("IS BETWEEN")
										&& !textField5_GC.getText().equals("") && !textField6_GC.getText().equals("")
										&& (Integer.parseInt(textField5_GC.getText()) < Integer
												.parseInt(textField6_GC.getText())))
										|| (!secondOfThird_GC.getSelectedItem().equals("IS BETWEEN")
												&& !textField5_GC.getText().equals(""))) {
									makeVisibleGC();
									makeEnableGC(false);
								}

							} else {
								makeVisibleGC();
								makeEnableGC(false);
							}
						}
					} else {
						makeVisibleGC();
						makeEnableGC(false);
					}
				}
			}
		});
		GridBagConstraints gbc_SaveButton_GC = new GridBagConstraints();
		gbc_SaveButton_GC.insets = new Insets(0, 0, 5, 5);
		gbc_SaveButton_GC.gridx = 19;
		gbc_SaveButton_GC.gridy = 3;
		getContentPane().add(SaveButton_GC, gbc_SaveButton_GC);

		// GC Second 1
		firstOfSecond_GC = new JComboBox(new String[] { "NOM_class", "LOC_class", "WMC_class" });
		firstOfSecond_GC.setForeground(Color.BLACK);
		firstOfSecond_GC.setBackground(Color.WHITE);
		firstOfSecond_GC.setVisible(false);

		CreateButton_GC = new JButton("Create Rule");
		CreateButton_GC.setEnabled(false);
		CreateButton_GC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarRegraGC();
			}
		});
		GridBagConstraints gbc_CreateButton_GC = new GridBagConstraints();
		gbc_CreateButton_GC.insets = new Insets(0, 0, 5, 0);
		gbc_CreateButton_GC.gridx = 21;
		gbc_CreateButton_GC.gridy = 3;
		getContentPane().add(CreateButton_GC, gbc_CreateButton_GC);
		GridBagConstraints gbc_firstOfSecond_GC = new GridBagConstraints();
		gbc_firstOfSecond_GC.insets = new Insets(0, 0, 5, 5);
		gbc_firstOfSecond_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstOfSecond_GC.gridx = 3;
		gbc_firstOfSecond_GC.gridy = 4;
		getContentPane().add(firstOfSecond_GC, gbc_firstOfSecond_GC);

		// GC Second 2
		secondOfSecond_GC = new JComboBox(new String[] { "IS BETWEEN", "=", ">", "<", ">=", "<=" });
		secondOfSecond_GC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (secondOfSecond_GC.getSelectedItem().equals("IS BETWEEN")) {
					label5_GC.setVisible(true);
					textField4_GC.setVisible(true);
				} else {
					label5_GC.setVisible(false);
					textField4_GC.setVisible(false);
				}
			}
		});
		secondOfSecond_GC.setForeground(Color.BLACK);
		secondOfSecond_GC.setBackground(Color.WHITE);
		secondOfSecond_GC.setVisible(false);
		GridBagConstraints gbc_secondOfSecond_GC = new GridBagConstraints();
		gbc_secondOfSecond_GC.insets = new Insets(0, 0, 5, 5);
		gbc_secondOfSecond_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondOfSecond_GC.gridx = 5;
		gbc_secondOfSecond_GC.gridy = 4;
		getContentPane().add(secondOfSecond_GC, gbc_secondOfSecond_GC);

		textField3_GC = new JTextField();
		textField3_GC.setColumns(10);
		textField3_GC.setVisible(false);
		GridBagConstraints gbc_textField3_GC = new GridBagConstraints();
		gbc_textField3_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField3_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField3_GC.gridx = 7;
		gbc_textField3_GC.gridy = 4;
		getContentPane().add(textField3_GC, gbc_textField3_GC);
		textField3_GC.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		label5_GC = new JLabel("AND");
		label5_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label5_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		label5_GC.setVisible(false);
		GridBagConstraints gbc_label5_GC = new GridBagConstraints();
		gbc_label5_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_label5_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label5_GC.gridx = 8;
		gbc_label5_GC.gridy = 4;
		getContentPane().add(label5_GC, gbc_label5_GC);

		textField4_GC = new JTextField();
		textField4_GC.setColumns(10);
		textField4_GC.setVisible(false);
		GridBagConstraints gbc_textField4_GC = new GridBagConstraints();
		gbc_textField4_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField4_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField4_GC.gridx = 9;
		gbc_textField4_GC.gridy = 4;
		getContentPane().add(textField4_GC, gbc_textField4_GC);
		textField4_GC.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		// GC Second 3
		second_GC_And_Or = new JComboBox(new String[] { "", "AND", "OR" });
		second_GC_And_Or.setModel(new DefaultComboBoxModel(new String[] { "", "AND", "OR" }));
		second_GC_And_Or.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (second_GC_And_Or.getSelectedItem().equals("")) {
					firstOfThird_GC.setVisible(false);
					secondOfThird_GC.setVisible(false);
					textField5_GC.setVisible(false);
					label6_GC.setVisible(false);
					textField6_GC.setVisible(false);
					textField5_GC.setText("");
					textField6_GC.setText("");
				} else {

					firstOfThird_GC.setVisible(true);
					secondOfThird_GC.setVisible(true);
					textField5_GC.setVisible(true);
					label6_GC.setVisible(true);
					textField6_GC.setVisible(true);
					secondOfThird_GC.setSelectedItem("IS BETWEEN");
				}
			}
		});
		second_GC_And_Or.setForeground(Color.BLACK);
		second_GC_And_Or.setBackground(Color.WHITE);
		second_GC_And_Or.setVisible(false);
		GridBagConstraints gbc_second_GC_And_Or = new GridBagConstraints();
		gbc_second_GC_And_Or.insets = new Insets(0, 0, 5, 5);
		gbc_second_GC_And_Or.fill = GridBagConstraints.HORIZONTAL;
		gbc_second_GC_And_Or.gridx = 11;
		gbc_second_GC_And_Or.gridy = 4;
		getContentPane().add(second_GC_And_Or, gbc_second_GC_And_Or);

		firstOfThird_GC = new JComboBox(new String[] { "NOM_class", "LOC_class", "WMC_class" });
		firstOfThird_GC.setBackground(Color.WHITE);
		firstOfThird_GC.setForeground(Color.BLACK);
		firstOfThird_GC.setVisible(false);

		labelNome2 = new JLabel("Nome :");
		GridBagConstraints gbc_labelNome2 = new GridBagConstraints();
		gbc_labelNome2.anchor = GridBagConstraints.EAST;
		gbc_labelNome2.insets = new Insets(0, 0, 5, 5);
		gbc_labelNome2.gridx = 18;
		gbc_labelNome2.gridy = 4;
		getContentPane().add(labelNome2, gbc_labelNome2);

		textFieldNome2 = new JTextField();
		textFieldNome2.setEnabled(false);
		textFieldNome2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!textFieldNome2.getText().equals("") && e.getKeyCode() != 32) {
					CreateButton_GC.setEnabled(true);
				} else {
					CreateButton_GC.setEnabled(false);
				}
			}
		});
		textFieldNome2.setColumns(10);
		GridBagConstraints gbc_textFieldNome2 = new GridBagConstraints();
		gbc_textFieldNome2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNome2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNome2.gridx = 19;
		gbc_textFieldNome2.gridy = 4;
		getContentPane().add(textFieldNome2, gbc_textFieldNome2);

		comboBox2 = new JComboBox();
		GridBagConstraints gbc_comboBox2 = new GridBagConstraints();
		gbc_comboBox2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox2.gridx = 21;
		gbc_comboBox2.gridy = 4;
		comboBox2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				regraGCAlterar = (String) comboBox2.getSelectedItem();

				if (regraGCAlterar==null || regraGCAlterar.equals(""))
					resetCamposGC();
				else
					alterarRegraGC();
			}
		});
		getContentPane().add(comboBox2, gbc_comboBox2);
		
		GridBagConstraints gbc_firstOfThird_GC = new GridBagConstraints();
		gbc_firstOfThird_GC.insets = new Insets(0, 0, 5, 5);
		gbc_firstOfThird_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstOfThird_GC.gridx = 3;
		gbc_firstOfThird_GC.gridy = 5;
		getContentPane().add(firstOfThird_GC, gbc_firstOfThird_GC);

		secondOfThird_GC = new JComboBox(new String[] { "IS BETWEEN", "=", ">", "<", ">=", "<=" });
		secondOfThird_GC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (secondOfThird_GC.getSelectedItem().equals("IS BETWEEN")) {
					label6_GC.setVisible(true);
					textField6_GC.setVisible(true);
				} else {
					label6_GC.setVisible(false);
					textField6_GC.setVisible(false);
				}
			}
		});
		secondOfThird_GC.setForeground(Color.BLACK);
		secondOfThird_GC.setBackground(Color.WHITE);
		secondOfThird_GC.setVisible(false);
		GridBagConstraints gbc_secondOfThird_GC = new GridBagConstraints();
		gbc_secondOfThird_GC.insets = new Insets(0, 0, 5, 5);
		gbc_secondOfThird_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondOfThird_GC.gridx = 5;
		gbc_secondOfThird_GC.gridy = 5;
		getContentPane().add(secondOfThird_GC, gbc_secondOfThird_GC);

		textField5_GC = new JTextField();
		textField5_GC.setVisible(false);
		GridBagConstraints gbc_textField5_GC = new GridBagConstraints();
		gbc_textField5_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField5_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField5_GC.gridx = 7;
		gbc_textField5_GC.gridy = 5;
		getContentPane().add(textField5_GC, gbc_textField5_GC);
		textField5_GC.setColumns(10);
		textField5_GC.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		label6_GC = new JLabel("AND");
		label6_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		label6_GC.setVisible(false);
		GridBagConstraints gbc_label6_GC = new GridBagConstraints();
		gbc_label6_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label6_GC.gridx = 8;
		gbc_label6_GC.gridy = 5;
		getContentPane().add(label6_GC, gbc_label6_GC);

		textField6_GC = new JTextField();
		textField6_GC.setVisible(false);
		GridBagConstraints gbc_textField6_GC = new GridBagConstraints();
		gbc_textField6_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField6_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField6_GC.gridx = 9;
		gbc_textField6_GC.gridy = 5;
		getContentPane().add(textField6_GC, gbc_textField6_GC);
		textField6_GC.setColumns(10);

		JLabel lblNewLabel = new JLabel("Diretório");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 8;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		textField6_GC.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		JButton btnNewButton_2 = new JButton("Escolher diretório");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser diretorio = new JFileChooser();
				diretorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				int returnValue = diretorio.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					selectedFile = diretorio.getSelectedFile();
					lblNewLabel.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 7;
		gbc_btnNewButton_2.gridy = 8;
		getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
				
		JButton btnNewButton_3 = new JButton("Criar Excel");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				percorrer();
				excel = new EscreverMétricasParaExcel(caminhoFicheiros);
				try {
					excel.escreverNoFicheiro();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				Set<String> packages = new HashSet<>(excel.getnomePackages());
				lblNewLabel_2.setText(Integer.toString(packages.size()));
				lblNewLabel_4.setText(Integer.toString(excel.getNumberClasses()));
				ArrayList<Integer> LOC_métodos = excel.getLOC_method_array();
				lblNewLabel_6.setText(Integer.toString(LOC_métodos.size()));
				int soma = 0;
				for (int aux : LOC_métodos)
					soma += aux;
				lblNewLabel_8.setText(Integer.toString(soma));
				DefaultTableModel defaultValues = new DefaultTableModel(getValores(), new String[] {
						"MethodID","package","class", "method", "NOM_class", "LOC_class", "WMC_class", "is_God_Class", "LOC_method","CYCLO_method", "is_Long_Method"});

				scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridwidth = 11;
				gbc_scrollPane.gridheight=10;
				gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 13;
				getContentPane().add(scrollPane, gbc_scrollPane);

				table = new JTable(defaultValues);
				JTableHeader header = table.getTableHeader();
				header.setReorderingAllowed(false);
				header.setBackground(Color.LIGHT_GRAY);
				scrollPane.setViewportView(table);
			}
		});
		
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 8;
		gbc_btnNewButton_3.gridy = 8;
		getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		lblNewLabel_2 = new JLabel("0");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 9;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Número de Packages:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 9;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		lblNewLabel_4 = new JLabel("0");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 5;
		gbc_lblNewLabel_4.gridy = 10;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel_3 = new JLabel("Número de classes:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 10;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		btnNewButton = new JButton("Aplicar Regras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Regra regra1 = new Regra("regra1", "LOC_method>50 && CYCLO_method>10", true, 0);
				Regra regra2 = new Regra("regra2", "WMC_class>50 || NOM_class>10", false, 1);
				try {
	//					verificarCS = new VerificacaoCodeSmells(excel.getProjeto_name(), null, null);  //ESTES VALORES A NULL É PARA SE COLOCAREM AS REGRAS SELECIONADAS
					verificarCS = new VerificacaoCodeSmells(excel.getProjeto_name(), regra1, regra2);
				} catch (EncryptedDocumentException | IOException | ScriptException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
				DefaultTableModel defaultValues = new DefaultTableModel(getValores(), new String[] {
						"MethodID","package","class", "method", "NOM_class", "LOC_class", "WMC_class", "is_God_Class", "LOC_method","CYCLO_method", "is_Long_Method"});
	
				table = new JTable(defaultValues);
				JTableHeader header = table.getTableHeader();
				header.setReorderingAllowed(false);
				header.setBackground(Color.LIGHT_GRAY);
				scrollPane.setViewportView(table);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 11;
		gbc_btnNewButton.gridy = 10;
		getContentPane().add(btnNewButton, gbc_btnNewButton);

		lblNewLabel_6 = new JLabel("0");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 5;
		gbc_lblNewLabel_6.gridy = 11;
		getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);

		JLabel lblNewLabel_5 = new JLabel("Número de métodos:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 11;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);

		lblNewLabel_8 = new JLabel("0");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 5;
		gbc_lblNewLabel_8.gridy = 12;
		getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);

		JLabel lblNewLabel_7 = new JLabel("Número de linhas de código:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 3;
		gbc_lblNewLabel_7.gridy = 12;
		getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		carregarRegras();
	}

	private void criarRegraLM() {
		if (regraLMAlterar!= null && !regraLMAlterar.equals(""))
			this.regrasLongMethod.remove(regraLMAlterar);
		else {
			for (String s : regrasLongMethod.keySet())
				if (s.equals(textFieldNome_LM.getText()))
					return;
		}
		String expressao = "";
		String condicao1 = criarCondicao(this.firstOfFirst_LM, this.secondOfFirst_LM, this.textField1_LM,
				this.textField2_LM);
		if (!this.LM_And_Or.getSelectedItem().equals("")) {
			String condicao2 = criarCondicao(this.firstOfSecond_LM, this.secondOfSecond_LM, this.textField3_LM,
					this.textField4_LM);

			if (this.LM_And_Or.getSelectedItem().equals("AND"))
				expressao = condicao1 + " && " + condicao2;
			else
				expressao = condicao1 + " || " + condicao2;

		} else {
			expressao = condicao1;
		}
		boolean valorRegra;
		if (this.isTrueFalse_LM.getSelectedItem().equals("TRUE"))
			valorRegra = true;
		else
			valorRegra = false;
		Regra regra = new Regra(this.textFieldNome_LM.getText(), expressao, valorRegra, 0);
		this.regrasLongMethod.put(regra.getNome(), regra);
		System.out.println(expressao);
		resetCamposLM();
		comboBox.removeAllItems();
		comboBox.addItem("");

		for (HashMap.Entry<String, Regra> entry : regrasLongMethod.entrySet()) {
			String key = entry.getKey();
			System.out.println(key);
			comboBox.addItem(key);
		}
	}

	private void criarRegraGC() {
		if (regraGCAlterar!=null && !regraGCAlterar.equals(""))
			this.regrasGodClass.remove(regraGCAlterar);
		else {
			for (String s : regrasGodClass.keySet())
				if (s.equals(textFieldNome2.getText()))
					return;
		}
		String expressao = "";
		String condicao1 = criarCondicao(this.firstOfFirst_GC, this.secondOfFirst_GC, this.textField1_GC,
				this.textField2_GC);
		if (!this.GC_And_Or.getSelectedItem().equals("")) {
			String condicao2 = criarCondicao(this.firstOfSecond_GC, this.secondOfSecond_GC, this.textField3_GC,
					this.textField4_GC);

			if (!this.second_GC_And_Or.getSelectedItem().equals("")) {
				String condicao3 = criarCondicao(this.firstOfThird_GC, this.secondOfThird_GC, this.textField5_GC,
						this.textField6_GC);
				if (this.GC_And_Or.getSelectedItem().equals("AND"))
					expressao = "( " + condicao1 + " && " + condicao2 + " )";
				else
					expressao = "( " + condicao1 + " || " + condicao2 + " )";
				if (this.second_GC_And_Or.getSelectedItem().equals("AND"))
					expressao = expressao + " && " + condicao3;
				else
					expressao = expressao + " || " + condicao3;
			} else {
				if (this.GC_And_Or.getSelectedItem().equals("AND"))
					expressao = "( " + condicao1 + " && " + condicao2 + " )";
				else
					expressao = "( " + condicao1 + " || " + condicao2 + " )";
			}
		} else {
			expressao = "( " + condicao1 + " )";
		}
		boolean valorRegra;
		if (this.isTrueFalse_GC.getSelectedItem().equals("TRUE"))
			valorRegra = true;
		else
			valorRegra = false;
		Regra regra = new Regra(this.textFieldNome2.getText(), expressao, valorRegra, 1);
		this.regrasGodClass.put(regra.getNome(), regra);
		System.out.println(expressao);
		resetCamposGC();
		comboBox2.removeAllItems();
		comboBox2.addItem("");

		for (HashMap.Entry<String, Regra> entry : regrasGodClass.entrySet()) {
			String key = entry.getKey();
			System.out.println(key);
			comboBox2.addItem(key);
		}
	}

	private String criarCondicao(JComboBox jcb1, JComboBox jcb2, JTextField jtf1, JTextField jtf2) {
		String aux = "";
		if (jcb2.getSelectedItem().equals("IS BETWEEN")) {
			aux = "( " + jcb1.getSelectedItem() + " >= " + jtf1.getText() + " && " + jcb1.getSelectedItem() + " <= "
					+ jtf2.getText() + " )";
		} else {
			if (jcb2.getSelectedItem().equals("=")) {
				aux = "( " + jcb1.getSelectedItem() + " == " + jtf1.getText() + " )";
			} else {
				aux = "( " + jcb1.getSelectedItem() + " " + jcb2.getSelectedItem() + " " + jtf1.getText() + " )";
			}
		}
		return aux;
	}

	private void resetCamposLM() {
		textFieldNome_LM.setText("");
		SaveButton_LM.setEnabled(true);
		CreateButton_LM.setEnabled(false);
		textFieldNome_LM.setEnabled(false);
		firstOfFirst_LM.setSelectedItem("LOC_method");
		secondOfFirst_LM.setSelectedItem("LOC_method");
		secondOfFirst_LM.setSelectedItem("IS BETWEEN");
		secondOfSecond_LM.setSelectedItem("IS BETWEEN");
		isTrueFalse_LM.setSelectedItem("TRUE");
		LM_And_Or.setSelectedItem("");
		textField1_LM.setText("");
		textField2_LM.setText("");
		textField3_LM.setText("");
		textField4_LM.setText("");
		CreateButton_LM.setText("Create Rule");
		makeEnableLM(true);
	}

	private void resetCamposGC() {
		textFieldNome2.setText("");
		SaveButton_GC.setEnabled(true);
		CreateButton_GC.setEnabled(false);
		textFieldNome2.setEnabled(false);
		secondOfFirst_GC.setSelectedItem("IS BETWEEN");
		secondOfSecond_GC.setSelectedItem("IS BETWEEN");
		secondOfThird_GC.setSelectedItem("IS BETWEEN");
		GC_And_Or.setSelectedItem("");
		second_GC_And_Or.setSelectedItem("");
		isTrueFalse_GC.setSelectedItem("TRUE");
		textField1_GC.setText("");
		textField2_GC.setText("");
		textField3_GC.setText("");
		textField4_GC.setText("");
		textField5_GC.setText("");
		textField6_GC.setText("");
		makeEnableGC(true);
	}

    private void carregarRegras() {
		comboBox.addItem("");
		comboBox2.addItem("");
		File myObj = new File("regras.txt");
		if(myObj.canRead()) {
		    Scanner myReader;
			try {
				myReader = new Scanner(myObj);
				while (myReader.hasNextLine()) {
			        String nome = myReader.nextLine();
			        String expressao = myReader.nextLine();
			        String s = myReader.nextLine();
			        String [] aux = s.split(" ");
			        Regra regra = new Regra(nome,expressao,Boolean.parseBoolean(aux[0]),Integer.parseInt(aux[1]));
			        if(Integer.parseInt(aux[1])==0) {
			        	regrasLongMethod.put(nome, regra);
			        	comboBox.addItem(nome);
			        }
			        else {
			        	regrasGodClass.put(nome, regra);
			        	comboBox2.addItem(nome);
			        }
				}
				myReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

    private void guardarRegras() {
		try {
		      FileWriter myWriter = new FileWriter("regras.txt");
		      for(Regra r : regrasLongMethod.values()) {
		    	  myWriter.write(r.getNome() + "\n");
		    	  myWriter.write(r.getExpressao() + "\n");
		    	  myWriter.write(r.getValorCodeSmell()+ " " + r.getTipoCodeSmell() + "\n");
		      }
		      for(Regra r : regrasGodClass.values()) {
		    	  myWriter.write(r.getNome() + "\n");
		    	  myWriter.write(r.getExpressao() + "\n");
		    	  myWriter.write(r.getValorCodeSmell()+ " " + r.getTipoCodeSmell() + "\n");
		      }
		      myWriter.close();
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
    
	private void makeVisibleLM() {
		SaveButton_LM.setEnabled(false);
		textFieldNome_LM.setEnabled(true);
	}

	private void makeVisibleGC() {
		SaveButton_GC.setEnabled(false);
		textFieldNome2.setEnabled(true);
	}

	private void makeEnableLM(boolean b) {
		firstOfFirst_LM.setEnabled(b);
		secondOfFirst_LM.setEnabled(b);
		firstOfSecond_LM.setEnabled(b);
		secondOfSecond_LM.setEnabled(b);
		textField1_LM.setEnabled(b);
		textField2_LM.setEnabled(b);
		textField3_LM.setEnabled(b);
		textField4_LM.setEnabled(b);
		LM_And_Or.setEnabled(b);
		isTrueFalse_LM.setEnabled(b);
	}

	private void makeEnableGC(boolean b) {
		firstOfFirst_GC.setEnabled(b);
		secondOfFirst_GC.setEnabled(b);
		firstOfSecond_GC.setEnabled(b);
		secondOfSecond_GC.setEnabled(b);
		firstOfThird_GC.setEnabled(b);
		secondOfThird_GC.setEnabled(b);
		textField1_GC.setEnabled(b);
		textField2_GC.setEnabled(b);
		textField3_GC.setEnabled(b);
		textField4_GC.setEnabled(b);
		textField5_GC.setEnabled(b);
		textField6_GC.setEnabled(b);
		GC_And_Or.setEnabled(b);
		second_GC_And_Or.setEnabled(b);
		isTrueFalse_GC.setEnabled(b);
	}

	private void alterarRegraLM() {
		CreateButton_LM.setText("Change Rule");
		for (HashMap.Entry<String, Regra> entry : regrasLongMethod.entrySet()) {
			String key = entry.getKey();
			Regra regra = entry.getValue();

			if (key == regraLMAlterar) {
				System.out.println(regra.getValorCodeSmell());
				if (regra.getValorCodeSmell()) {
					isTrueFalse_LM.setSelectedItem("TRUE");
				} else {
					isTrueFalse_LM.setSelectedItem("FALSE");
				}
				String[] expressao = regra.getExpressao().split(" ");
				firstOfFirst_LM.setSelectedItem(expressao[1]);
				textField1_LM.setText(expressao[3]);
				if (expressao[4].equals("&&")) {
					secondOfFirst_LM.setSelectedItem("IS BETWEEN");
					textField2_LM.setText(expressao[7]);
					if (expressao.length > 9) {
						if (expressao[9].equals("&&"))
							LM_And_Or.setSelectedItem("AND");
						else
							LM_And_Or.setSelectedItem("OR");
						firstOfSecond_LM.setSelectedItem(expressao[11]);
						textField3_LM.setText(expressao[13]);
						if (expressao[14].equals("&&")) {
							secondOfSecond_LM.setSelectedItem("IS BETWEEN");
							textField4_LM.setText(expressao[17]);
						} else {
							secondOfSecond_LM.setSelectedItem(expressao[12]);
						}
					}
				} else {
					secondOfFirst_LM.setSelectedItem(expressao[2]);
					if (expressao.length > 5) {
						if (expressao[5].equals("&&")) {
							LM_And_Or.setSelectedItem("AND");
						} else {
							LM_And_Or.setSelectedItem("OR");
						}
						firstOfSecond_LM.setSelectedItem(expressao[7]);
						textField3_LM.setText(expressao[9]);
						if (expressao[10].equals("&&")) {
							secondOfSecond_LM.setSelectedItem("IS BETWEEN");
							textField4_LM.setText(expressao[13]);
						} else {
							secondOfSecond_LM.setSelectedItem(expressao[8]);
						}
					}
				}
			}
		}
	}

	private void alterarRegraGC() {
		CreateButton_GC.setText("Change Rule");
		for (HashMap.Entry<String, Regra> entry : regrasGodClass.entrySet()) {
			String key = entry.getKey();
			Regra regra = entry.getValue();

			if (key == regraGCAlterar) {
				System.out.println(regra.getValorCodeSmell());
				if (regra.getValorCodeSmell()) {
					isTrueFalse_GC.setSelectedItem("TRUE");
				} else {
					isTrueFalse_GC.setSelectedItem("FALSE");
				}
				String[] expressao = regra.getExpressao().split(" ");
				firstOfFirst_GC.setSelectedItem(expressao[2]);
				textField1_GC.setText(expressao[4]);
				if (expressao[5].equals("&&")) {
					secondOfFirst_GC.setSelectedItem("IS BETWEEN");
					textField2_GC.setText(expressao[8]);
					if (expressao.length > 10) {
						if (expressao[10].equals("&&"))
							GC_And_Or.setSelectedItem("AND");
						else
							GC_And_Or.setSelectedItem("OR");
						firstOfSecond_GC.setSelectedItem(expressao[12]);
						textField3_GC.setText(expressao[14]);
						if (expressao[15].equals("&&")) {
							secondOfSecond_GC.setSelectedItem("IS BETWEEN");
							textField4_GC.setText(expressao[18]);
							if (expressao.length > 22) {
								if (expressao[21].equals("&&"))
									second_GC_And_Or.setSelectedItem("AND");
								else
									second_GC_And_Or.setSelectedItem("OR");
								firstOfThird_GC.setSelectedItem(expressao[23]);
								textField5_GC.setText(expressao[25]);
								if (expressao[26].equals("&&")) {
									secondOfThird_GC.setSelectedItem("IS BETWEEN");
									textField6_GC.setText(expressao[29]);
								} else {
									secondOfThird_GC.setSelectedItem(expressao[24]);
								}

							}
						} else {
							secondOfSecond_GC.setSelectedItem(expressao[13]);
							if (expressao.length > 16) {
								if (expressao[17].equals("&&"))
									second_GC_And_Or.setSelectedItem("AND");
								else
									second_GC_And_Or.setSelectedItem("OR");
								firstOfThird_GC.setSelectedItem(expressao[19]);
								textField5_GC.setText(expressao[21]);
								if (expressao[22].equals("&&")) {
									secondOfThird_GC.setSelectedItem("IS BETWEEN");
									textField6_GC.setText(expressao[25]);
								} else {
									secondOfThird_GC.setSelectedItem(expressao[20]);
								}
							}
						}
					}
				} else {
					secondOfFirst_GC.setSelectedItem(expressao[3]);
					if (expressao.length > 6) {
						if (expressao[6].equals("&&")) {
							GC_And_Or.setSelectedItem("AND");
						} else {
							GC_And_Or.setSelectedItem("OR");
						}
						firstOfSecond_GC.setSelectedItem(expressao[8]);
						textField3_GC.setText(expressao[10]);
						if (expressao[11].equals("&&")) {
							secondOfSecond_GC.setSelectedItem("IS BETWEEN");
							textField4_GC.setText(expressao[14]);
							if (expressao.length > 17) {
								if (expressao[17].equals("&&"))
									second_GC_And_Or.setSelectedItem("AND");
								else
									second_GC_And_Or.setSelectedItem("OR");
								firstOfThird_GC.setSelectedItem(expressao[19]);
								textField5_GC.setText(expressao[21]);
								if (expressao[22].equals("&&")) {
									secondOfThird_GC.setSelectedItem("IS BETWEEN");
									textField6_GC.setText(expressao[25]);
								} else {
									secondOfThird_GC.setSelectedItem(expressao[20]);
								}
							}
						} else {
							secondOfSecond_GC.setSelectedItem(expressao[9]);
							if (expressao.length > 13) {
								if (expressao[13].equals("&&"))
									second_GC_And_Or.setSelectedItem("AND");
								else
									second_GC_And_Or.setSelectedItem("OR");
								firstOfThird_GC.setSelectedItem(expressao[15]);
								textField5_GC.setText(expressao[17]);
								if (expressao[18].equals("&&")) {
									secondOfThird_GC.setSelectedItem("IS BETWEEN");
									textField6_GC.setText(expressao[21]);
								} else {
									secondOfThird_GC.setSelectedItem(expressao[16]);
								}
							}
						}
					}
				}
			}
		}
	}

	public void percorrer() {
		caminhoFicheiros = new ArrayList<String>();
		String[] aux = selectedFile.getAbsolutePath().replace("\\", "/").split("/");
		caminhoFicheiros.add(aux[aux.length - 1]);
		for (File f : selectedFile.listFiles()) {
			String s = f.getAbsolutePath().replace("\\", "/");
			String[] v = s.split("/");
			if (f.isDirectory() && v[v.length - 1].equals("src")) {
				percorrerDiretorio(f);
			}
		}
	}

	private void percorrerDiretorio(File f) {
		for (File ficheiro : f.listFiles()) {
			String s = f.getAbsolutePath().replace("\\", "/");
			String[] v = s.split("/");
			if (v[v.length - 1].equals("src")) {
				if (ficheiro.isDirectory())
					percorrerDiretorio(ficheiro);
			} else {
				if (ficheiro.isDirectory())
					percorrerDiretorio(ficheiro);
				else
					percorrerFicheiro(ficheiro);
			}
		}
	}

	private void percorrerFicheiro(File f) {
		if (f.getAbsolutePath().endsWith(".java")) {
			caminhoFicheiros.add(f.getAbsolutePath());
		}
	}

	public ArrayList<String> getCaminhoFicheiros() {
		return caminhoFicheiros;
	}

	public File getSelectedFile() {
		return selectedFile;
	}

	public void setSelectedFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}

	private Object[][] getValores(){
		Ficheiro f = new Ficheiro(excel.getProjeto_name()+".xlsx");
		int height = f.getListaLinhas().size();
		Object[][] matrix = new Object[height][11];
		for (int i = 0; i < height; i++){
			Linha row = f.getListaLinhas().get(i);
			matrix[i][0] = row.getIdMetodo();
			matrix[i][1] = row.getNomePacote();
			matrix[i][2] = row.getNomeClasse();
			matrix[i][3] = row.getNomeMetodo();
			matrix[i][4] = row.getNOM_Class();
			matrix[i][5] = row.getLOC_Class();
			matrix[i][6] = row.getWMC_Class();
			matrix[i][7] = row.isIs_God_Class();
			matrix[i][8] = row.getLOC_Method();
			matrix[i][9] = row.getCyclo_Method();
			matrix[i][10] = row.isIs_Long_Method();
		}
		return matrix;
	}
}