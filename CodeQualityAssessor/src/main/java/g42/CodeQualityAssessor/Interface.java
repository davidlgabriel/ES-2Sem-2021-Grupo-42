package g42.CodeQualityAssessor;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Interface extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Interface dialog = new Interface();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	private File selectedFile = null;
	private ArrayList<String> caminhoFicheiros= new ArrayList<>();
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
	private JTextField textFieldNome_LM;
	private JButton CreateButton_LM;
	private JButton SaveButton_LM;
	private JComboBox comboBox;
	private JLabel labelNome_LM;
	
	
	public Interface() {
		setBounds(100, 100, 1215, 603);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{19, 20, 20, 110, 25, 4, 30, 50, 40, 50, 30, 75, 30, 32, 30, 11, 18, 37, 100, 70, 22, 80, 31, 75, 0};
		gridBagLayout.rowHeights = new int[]{24, 35, 35, 30, 35, 35, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel if_LM = new JLabel("IF");
		if_LM.setHorizontalAlignment(SwingConstants.CENTER);
		if_LM.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_if_LM = new GridBagConstraints();
		gbc_if_LM.insets = new Insets(0, 0, 5, 5);
		gbc_if_LM.gridx = 1;
		gbc_if_LM.gridy = 1;
		getContentPane().add(if_LM, gbc_if_LM);
		
		//LM First 1
		firstOfFirst_LM = new JComboBox(new String[] {"LOC_method", "CYCLO_method"});
		firstOfFirst_LM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//firstOfSecond_LM.selec
				for(int x=0; x < firstOfSecond_LM.getItemCount(); x++) {
					if(firstOfFirst_LM.getSelectedItem() == firstOfSecond_LM.getItemAt(x)) {
						firstOfSecond_LM.removeItemAt(x);
					}
				}
			}
		});
		firstOfFirst_LM.setForeground(Color.BLACK);
		firstOfFirst_LM.setBackground(Color.WHITE);
		GridBagConstraints gbc_firstOfFirst_LM = new GridBagConstraints();
		gbc_firstOfFirst_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstOfFirst_LM.insets = new Insets(0, 0, 5, 5);
		gbc_firstOfFirst_LM.gridx = 3;
		gbc_firstOfFirst_LM.gridy = 1;
		getContentPane().add(firstOfFirst_LM, gbc_firstOfFirst_LM);
		
		//LM First 2
		secondOfFirst_LM = new JComboBox(new String[] {"IS BETWEEN", "=", ">", "<", ">=", "<="});
		secondOfFirst_LM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secondOfFirst_LM.getSelectedItem().equals("IS BETWEEN")) {
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
		gbc_secondOfFirst_LM.gridy = 1;
		getContentPane().add(secondOfFirst_LM, gbc_secondOfFirst_LM);
		
		textField1_LM = new JTextField();
		textField1_LM.setColumns(10);
		GridBagConstraints gbc_textField1_LM = new GridBagConstraints();
		gbc_textField1_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField1_LM.insets = new Insets(0, 0, 5, 5);
		gbc_textField1_LM.gridx = 7;
		gbc_textField1_LM.gridy = 1;
		getContentPane().add(textField1_LM, gbc_textField1_LM);
		
		label1_LM = new JLabel("AND");
		label1_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label1_LM.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label1_LM = new GridBagConstraints();
		gbc_label1_LM.fill = GridBagConstraints.BOTH;
		gbc_label1_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label1_LM.gridx = 8;
		gbc_label1_LM.gridy = 1;
		getContentPane().add(label1_LM, gbc_label1_LM);
		
		textField2_LM = new JTextField();
		textField2_LM.setColumns(10);
		GridBagConstraints gbc_textField2_LM = new GridBagConstraints();
		gbc_textField2_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField2_LM.insets = new Insets(0, 0, 5, 5);
		gbc_textField2_LM.gridx = 9;
		gbc_textField2_LM.gridy = 1;
		getContentPane().add(textField2_LM, gbc_textField2_LM);
		
		//LM SECOND 1
		firstOfSecond_LM = new JComboBox(new String[] {"LOC_method", "CYCLO_method"});		
		firstOfSecond_LM.setForeground(Color.BLACK);
		firstOfSecond_LM.setBackground(Color.WHITE);
		firstOfSecond_LM.setVisible(false);
		
		JComboBox isTrueFalse_LM = new JComboBox();
		isTrueFalse_LM.setModel(new DefaultComboBoxModel(new String[] {"TRUE", "FALSE"}));
		isTrueFalse_LM.setForeground(Color.BLACK);
		isTrueFalse_LM.setBackground(Color.WHITE);
		GridBagConstraints gbc_isTrueFalse_LM = new GridBagConstraints();
		gbc_isTrueFalse_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_isTrueFalse_LM.insets = new Insets(0, 0, 5, 5);
		gbc_isTrueFalse_LM.gridx = 18;
		gbc_isTrueFalse_LM.gridy = 1;
		getContentPane().add(isTrueFalse_LM, gbc_isTrueFalse_LM);
		
		SaveButton_LM = new JButton("Save");
		SaveButton_LM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((secondOfFirst_LM.getSelectedItem().equals("IS BETWEEN") && !textField1_LM.getText().equals("") && !textField2_LM.getText().equals(""))
						|| (!secondOfFirst_LM.getSelectedItem().equals("IS BETWEEN") && !textField1_LM.getText().equals(""))) {
					if(LM_And_Or.getSelectedItem().equals("AND") || LM_And_Or.getSelectedItem().equals("OR")) {
						if((secondOfSecond_LM.getSelectedItem().equals("IS BETWEEN") && !textField3_LM.getText().equals("") && !textField4_LM.getText().equals(""))
								|| (!secondOfSecond_LM.getSelectedItem().equals("IS BETWEEN") && !textField3_LM.getText().equals(""))) {
							makeVizible();
						}
					} else {
						makeVizible();
					}
				}
			}
		});
		GridBagConstraints gbc_SaveButton_LM = new GridBagConstraints();
		gbc_SaveButton_LM.insets = new Insets(0, 0, 5, 5);
		gbc_SaveButton_LM.gridx = 19;
		gbc_SaveButton_LM.gridy = 1;
		getContentPane().add(SaveButton_LM, gbc_SaveButton_LM);
		
		CreateButton_LM = new JButton("Create New Rule");
		CreateButton_LM.setEnabled(false);
		CreateButton_LM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.addItem(textFieldNome_LM.getText());
				textFieldNome_LM.setText("");
				SaveButton_LM.setEnabled(true);
				secondOfFirst_LM.setSelectedItem("IS BETWEEN");
				secondOfSecond_LM.setSelectedItem("IS BETWEEN");
				LM_And_Or.setSelectedItem("");
				textField1_LM.setText("");
				textField2_LM.setText("");
				textField3_LM.setText("");
				textField4_LM.setText("");
				textFieldNome_LM.setVisible(false);
				CreateButton_LM.setVisible(false);
				labelNome_LM.setVisible(false);
				
			}
		});
		CreateButton_LM.setVisible(false);
		GridBagConstraints gbc_CreateButton_LM = new GridBagConstraints();
		gbc_CreateButton_LM.insets = new Insets(0, 0, 5, 5);
		gbc_CreateButton_LM.gridx = 21;
		gbc_CreateButton_LM.gridy = 1;
		getContentPane().add(CreateButton_LM, gbc_CreateButton_LM);
		GridBagConstraints gbc_firstOfSecond_LM = new GridBagConstraints();
		gbc_firstOfSecond_LM.insets = new Insets(0, 0, 5, 5);
		gbc_firstOfSecond_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstOfSecond_LM.gridx = 3;
		gbc_firstOfSecond_LM.gridy = 2;
		getContentPane().add(firstOfSecond_LM, gbc_firstOfSecond_LM);
		
		LM_And_Or = new JComboBox(new String[] {"", "AND", "OR"});
		LM_And_Or.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(LM_And_Or.getSelectedItem().equals("")) {
					firstOfSecond_LM.setVisible(false);
					secondOfSecond_LM.setVisible(false);
					textField3_LM.setVisible(false);
					label5_LM.setVisible(false);
					textField4_LM.setVisible(false);
					
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
		gbc_LM_And_Or.gridy = 1;
		getContentPane().add(LM_And_Or, gbc_LM_And_Or);
		
		JLabel label2_LM = new JLabel("THAN");
		label2_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label2_LM.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label2_LM = new GridBagConstraints();
		gbc_label2_LM.anchor = GridBagConstraints.WEST;
		gbc_label2_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label2_LM.gridx = 13;
		gbc_label2_LM.gridy = 1;
		getContentPane().add(label2_LM, gbc_label2_LM);
		
		JLabel label3_LM = new JLabel("is_Long_Method");
		label3_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label3_LM.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_label3_LM = new GridBagConstraints();
		gbc_label3_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_label3_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label3_LM.gridx = 15;
		gbc_label3_LM.gridy = 1;
		getContentPane().add(label3_LM, gbc_label3_LM);
		
		JLabel label4_LM = new JLabel("IS");
		label4_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label4_LM.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label4_LM = new GridBagConstraints();
		gbc_label4_LM.fill = GridBagConstraints.BOTH;
		gbc_label4_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label4_LM.gridx = 17;
		gbc_label4_LM.gridy = 1;
		getContentPane().add(label4_LM, gbc_label4_LM);
		
		//LM Second 2
		secondOfSecond_LM = new JComboBox(new String[] {"IS BETWEEN", "=", ">", "<", ">=", "<="});
		secondOfSecond_LM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secondOfSecond_LM.getSelectedItem().equals("IS BETWEEN")) {
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
		gbc_secondOfSecond_LM.gridy = 2;
		getContentPane().add(secondOfSecond_LM, gbc_secondOfSecond_LM);
		
		textField3_LM = new JTextField();
		textField3_LM.setColumns(10);
		textField3_LM.setVisible(false);
		GridBagConstraints gbc_textField3_LM = new GridBagConstraints();
		gbc_textField3_LM.insets = new Insets(0, 0, 5, 5);
		gbc_textField3_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField3_LM.gridx = 7;
		gbc_textField3_LM.gridy = 2;
		getContentPane().add(textField3_LM, gbc_textField3_LM);
		
		label5_LM = new JLabel("AND");
		label5_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label5_LM.setFont(new Font("Arial", Font.PLAIN, 12));
		label5_LM.setVisible(false);
		GridBagConstraints gbc_label5_LM = new GridBagConstraints();
		gbc_label5_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label5_LM.gridx = 8;
		gbc_label5_LM.gridy = 2;
		getContentPane().add(label5_LM, gbc_label5_LM);
		
		textField4_LM = new JTextField();
		textField4_LM.setColumns(10);
		textField4_LM.setVisible(false);
		GridBagConstraints gbc_textField4_LM = new GridBagConstraints();
		gbc_textField4_LM.insets = new Insets(0, 0, 5, 5);
		gbc_textField4_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField4_LM.gridx = 9;
		gbc_textField4_LM.gridy = 2;
		getContentPane().add(textField4_LM, gbc_textField4_LM);
		
		textFieldNome_LM = new JTextField();
		textFieldNome_LM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!textFieldNome_LM.getText().equals("") && e.getKeyCode() != 32) {
					CreateButton_LM.setEnabled(true);
				} else { 
					CreateButton_LM.setEnabled(false);
				}
			}
		});

		textFieldNome_LM.setVisible(false);
		
		labelNome_LM = new JLabel("Nome :");
		labelNome_LM.setVisible(false);
		GridBagConstraints gbc_labelNome_LM = new GridBagConstraints();
		gbc_labelNome_LM.anchor = GridBagConstraints.EAST;
		gbc_labelNome_LM.insets = new Insets(0, 0, 5, 5);
		gbc_labelNome_LM.gridx = 18;
		gbc_labelNome_LM.gridy = 2;
		getContentPane().add(labelNome_LM, gbc_labelNome_LM);
		GridBagConstraints gbc_textFieldNome_LM = new GridBagConstraints();
		gbc_textFieldNome_LM.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNome_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNome_LM.gridx = 19;
		gbc_textFieldNome_LM.gridy = 2;
		getContentPane().add(textFieldNome_LM, gbc_textFieldNome_LM);
		textFieldNome_LM.setColumns(10);
		
		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 21;
		gbc_comboBox.gridy = 2;
		getContentPane().add(comboBox, gbc_comboBox);
		
		JLabel if_GC = new JLabel("IF");
		if_GC.setHorizontalAlignment(SwingConstants.CENTER);
		if_GC.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_if_GC = new GridBagConstraints();
		gbc_if_GC.insets = new Insets(0, 0, 5, 5);
		gbc_if_GC.gridx = 1;
		gbc_if_GC.gridy = 4;
		getContentPane().add(if_GC, gbc_if_GC);
		
		JComboBox firstOfFirst_GC = new JComboBox(new String[] {"NOM_class", "LOC_class", "WMC_class"});
		firstOfFirst_GC.setForeground(Color.BLACK);
		firstOfFirst_GC.setBackground(Color.WHITE);
		GridBagConstraints gbc_firstOfFirst_GC = new GridBagConstraints();
		gbc_firstOfFirst_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstOfFirst_GC.insets = new Insets(0, 0, 5, 5);
		gbc_firstOfFirst_GC.gridx = 3;
		gbc_firstOfFirst_GC.gridy = 4;
		getContentPane().add(firstOfFirst_GC, gbc_firstOfFirst_GC);
		
		secondOfFirst_GC = new JComboBox(new String[] {"IS BETWEEN", "=", ">", "<", ">=", "<="});
		secondOfFirst_GC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secondOfFirst_GC.getSelectedItem().equals("IS BETWEEN")) {
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
		gbc_secondOfFirst_GC.gridy = 4;
		getContentPane().add(secondOfFirst_GC, gbc_secondOfFirst_GC);
		
		textField1_GC = new JTextField();
		textField1_GC.setColumns(10);
		GridBagConstraints gbc_textField1_GC = new GridBagConstraints();
		gbc_textField1_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField1_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField1_GC.gridx = 7;
		gbc_textField1_GC.gridy = 4;
		getContentPane().add(textField1_GC, gbc_textField1_GC);
		
		label1_GC = new JLabel("AND");
		label1_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label1_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label1_GC = new GridBagConstraints();
		gbc_label1_GC.fill = GridBagConstraints.VERTICAL;
		gbc_label1_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label1_GC.gridx = 8;
		gbc_label1_GC.gridy = 4;
		getContentPane().add(label1_GC, gbc_label1_GC);
		
		textField2_GC = new JTextField();
		textField2_GC.setColumns(10);
		GridBagConstraints gbc_textField2_GC = new GridBagConstraints();
		gbc_textField2_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField2_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField2_GC.gridx = 9;
		gbc_textField2_GC.gridy = 4;
		getContentPane().add(textField2_GC, gbc_textField2_GC);
		
		GC_And_Or = new JComboBox(new String[] {"", "AND", "OR"});
		GC_And_Or.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GC_And_Or.getSelectedItem().equals("")) {
					firstOfSecond_GC.setVisible(false);
					secondOfSecond_GC.setVisible(false);
					textField3_GC.setVisible(false);
					label5_GC.setVisible(false);
					textField4_GC.setVisible(false);
					second_GC_And_Or.setVisible(false);
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
		gbc_GC_And_Or.gridy = 4;
		getContentPane().add(GC_And_Or, gbc_GC_And_Or);
		
		JLabel label2_GC = new JLabel("THAN");
		label2_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label2_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label2_GC = new GridBagConstraints();
		gbc_label2_GC.anchor = GridBagConstraints.WEST;
		gbc_label2_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label2_GC.gridx = 13;
		gbc_label2_GC.gridy = 4;
		getContentPane().add(label2_GC, gbc_label2_GC);
		
		JLabel label3_GC = new JLabel("is_God_Class");
		label3_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label3_GC.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_label3_GC = new GridBagConstraints();
		gbc_label3_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_label3_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label3_GC.gridx = 15;
		gbc_label3_GC.gridy = 4;
		getContentPane().add(label3_GC, gbc_label3_GC);
		
		JLabel label4_GC = new JLabel("IS");
		label4_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label4_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label4_GC = new GridBagConstraints();
		gbc_label4_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_label4_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label4_GC.gridx = 17;
		gbc_label4_GC.gridy = 4;
		getContentPane().add(label4_GC, gbc_label4_GC);
		
		JComboBox isTrueFalse_GC = new JComboBox(new String[] {"TRUE", "FALSE"});
		isTrueFalse_GC.setForeground(Color.BLACK);
		isTrueFalse_GC.setBackground(Color.WHITE);
		GridBagConstraints gbc_isTrueFalse_GC = new GridBagConstraints();
		gbc_isTrueFalse_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_isTrueFalse_GC.insets = new Insets(0, 0, 5, 5);
		gbc_isTrueFalse_GC.gridx = 19;
		gbc_isTrueFalse_GC.gridy = 4;
		getContentPane().add(isTrueFalse_GC, gbc_isTrueFalse_GC);
		
		JButton buttonGC = new JButton("Create rule");
		GridBagConstraints gbc_buttonGC = new GridBagConstraints();
		gbc_buttonGC.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonGC.insets = new Insets(0, 0, 5, 5);
		gbc_buttonGC.gridx = 21;
		gbc_buttonGC.gridy = 4;
		getContentPane().add(buttonGC, gbc_buttonGC);
		
		//GC Second 1
		firstOfSecond_GC = new JComboBox(new String[] {"NOM_class", "LOC_class", "WMC_class"});
		firstOfSecond_GC.setForeground(Color.BLACK);
		firstOfSecond_GC.setBackground(Color.WHITE);
		firstOfSecond_GC.setVisible(false);
		GridBagConstraints gbc_firstOfSecond_GC = new GridBagConstraints();
		gbc_firstOfSecond_GC.insets = new Insets(0, 0, 5, 5);
		gbc_firstOfSecond_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstOfSecond_GC.gridx = 3;
		gbc_firstOfSecond_GC.gridy = 5;
		getContentPane().add(firstOfSecond_GC, gbc_firstOfSecond_GC);
		
		//GC Second 2
		secondOfSecond_GC = new JComboBox(new String[] {"IS BETWEEN", "=", ">", "<", ">=", "<="});
		secondOfSecond_GC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secondOfSecond_GC.getSelectedItem().equals("IS BETWEEN")) {
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
		gbc_secondOfSecond_GC.gridy = 5;
		getContentPane().add(secondOfSecond_GC, gbc_secondOfSecond_GC);
		
		textField3_GC = new JTextField();
		textField3_GC.setColumns(10);
		textField3_GC.setVisible(false);
		GridBagConstraints gbc_textField3_GC = new GridBagConstraints();
		gbc_textField3_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField3_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField3_GC.gridx = 7;
		gbc_textField3_GC.gridy = 5;
		getContentPane().add(textField3_GC, gbc_textField3_GC);
		
		label5_GC = new JLabel("AND");
		label5_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label5_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		label5_GC.setVisible(false);
		GridBagConstraints gbc_label5_GC = new GridBagConstraints();
		gbc_label5_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_label5_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label5_GC.gridx = 8;
		gbc_label5_GC.gridy = 5;
		getContentPane().add(label5_GC, gbc_label5_GC);
		
		textField4_GC = new JTextField();
		textField4_GC.setColumns(10);
		textField4_GC.setVisible(false);
		GridBagConstraints gbc_textField4_GC = new GridBagConstraints();
		gbc_textField4_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField4_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField4_GC.gridx = 9;
		gbc_textField4_GC.gridy = 5;
		getContentPane().add(textField4_GC, gbc_textField4_GC);
		
		//GC Second 3
		second_GC_And_Or = new JComboBox(new String[] {"", "AND", "OR"});
		second_GC_And_Or.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(second_GC_And_Or.getSelectedItem().equals("")) {
					firstOfThird_GC.setVisible(false);
					secondOfThird_GC.setVisible(false);
					textField5_GC.setVisible(false);
					label6_GC.setVisible(false);
					textField6_GC.setVisible(false);
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
		gbc_second_GC_And_Or.gridy = 5;
		getContentPane().add(second_GC_And_Or, gbc_second_GC_And_Or);
		
		firstOfThird_GC = new JComboBox(new String[] {"NOM_class", "LOC_class", "WMC_class"});
		firstOfThird_GC.setBackground(Color.WHITE);
		firstOfThird_GC.setForeground(Color.BLACK);
		firstOfThird_GC.setVisible(false);
		GridBagConstraints gbc_firstOfThird_GC = new GridBagConstraints();
		gbc_firstOfThird_GC.insets = new Insets(0, 0, 5, 5);
		gbc_firstOfThird_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstOfThird_GC.gridx = 3;
		gbc_firstOfThird_GC.gridy = 6;
		getContentPane().add(firstOfThird_GC, gbc_firstOfThird_GC);
		
		secondOfThird_GC = new JComboBox(new String[] {"IS BETWEEN", "=", ">", "<", ">=", "<="});
		secondOfThird_GC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secondOfThird_GC.getSelectedItem().equals("IS BETWEEN")) {
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
		gbc_secondOfThird_GC.gridy = 6;
		getContentPane().add(secondOfThird_GC, gbc_secondOfThird_GC);
		
		textField5_GC = new JTextField();
		textField5_GC.setVisible(false);
		GridBagConstraints gbc_textField5_GC = new GridBagConstraints();
		gbc_textField5_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField5_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField5_GC.gridx = 7;
		gbc_textField5_GC.gridy = 6;
		getContentPane().add(textField5_GC, gbc_textField5_GC);
		textField5_GC.setColumns(10);
		
		label6_GC = new JLabel("AND");
		label6_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		label6_GC.setVisible(false);
		GridBagConstraints gbc_label6_GC = new GridBagConstraints();
		gbc_label6_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label6_GC.gridx = 8;
		gbc_label6_GC.gridy = 6;
		getContentPane().add(label6_GC, gbc_label6_GC);
		
		textField6_GC = new JTextField();
		textField6_GC.setVisible(false);
		GridBagConstraints gbc_textField6_GC = new GridBagConstraints();
		gbc_textField6_GC.insets = new Insets(0, 0, 5, 5);
		gbc_textField6_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField6_GC.gridx = 9;
		gbc_textField6_GC.gridy = 6;
		getContentPane().add(textField6_GC, gbc_textField6_GC);
		textField6_GC.setColumns(10);
	}	
	
	private void makeVizible() {
		labelNome_LM.setVisible(true);
		textFieldNome_LM.setVisible(true);
		CreateButton_LM.setVisible(true);
		SaveButton_LM.setEnabled(false);
	}
	
	private void percorrer(){
		String[] aux = selectedFile.getAbsolutePath().replace("\\","/").split("/");
		caminhoFicheiros.add(aux[aux.length-1]);
		for(File f: selectedFile.listFiles()){
			String s = f.getAbsolutePath().replace("\\","/");
			String [] v = s.split("/");
			if(f.isDirectory() && v[v.length-1].equals("src")){
				percorrerDiretorio(f);
			}
		}
	}
	
	private void percorrerDiretorio(File f){
		for(File ficheiro: f.listFiles()){
			String s = f.getAbsolutePath().replace("\\","/");
			String [] v = s.split("/");
			if(v[v.length-1].equals("src")){
				if(ficheiro.isDirectory())	
					percorrerDiretorio(ficheiro);
			} else {
				if(ficheiro.isDirectory())	
					percorrerDiretorio(ficheiro);
				else 
					percorrerFicheiro(ficheiro);
			}	
		}
	}
	
	private void percorrerFicheiro(File f){
		if(f.getAbsolutePath().endsWith(".java")){
			caminhoFicheiros.add(f.getAbsolutePath());
		}
	}

	public ArrayList<String> getCaminhoFicheiros(){
		return caminhoFicheiros;
	}
}
