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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JInternalFrame;
import java.awt.Dimension;

public class Interface extends JDialog {

	/**
	 * Launch the applcation.
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
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	private JLabel label5;
	private JLabel label9;
	
	private JComboBox firstOfSecond_LM;
	private JComboBox LM_And_Or;
	private JComboBox firstOfFirst_LM;
	private JComboBox secondOfFirst_LM;
	private JComboBox secondOfSecond_LM;
	private JComboBox GC_And_Or;
	private JComboBox firstOfSecond_GC;
	private JComboBox secondOfSecond_GC;
	private JComboBox GC_And_Or_1;
	private JTextField textField_6;
	private JTextField textField_7;
	private JComboBox firstOfThird_GC;
	private JComboBox secondOfThird_GC;
	private JTextField textField_8;
	private JLabel label10;
	private JTextField textField_9;
	
	
	public Interface() {
		setBounds(100, 100, 1215, 603);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{19, 20, 20, 110, 25, 4, 30, 50, 40, 50, 30, 75, 30, 32, 30, 11, 20, 10, 30, 70, 22, 34, 31, 75, 0};
		gridBagLayout.rowHeights = new int[]{24, 35, 35, 30, 35, 35, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1_1 = new JLabel("IF");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 1;
		getContentPane().add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		//LM First 1
		firstOfFirst_LM = new JComboBox(new String[] {"LOC_method", "CYCLO_method"});
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
		secondOfFirst_LM.setBackground(Color.WHITE);
		secondOfFirst_LM.setForeground(Color.BLACK);
		GridBagConstraints gbc_secondOfFirst_LM = new GridBagConstraints();
		gbc_secondOfFirst_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondOfFirst_LM.insets = new Insets(0, 0, 5, 5);
		gbc_secondOfFirst_LM.gridx = 5;
		gbc_secondOfFirst_LM.gridy = 1;
		getContentPane().add(secondOfFirst_LM, gbc_secondOfFirst_LM);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 7;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		
		JLabel label1 = new JLabel("AND");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.fill = GridBagConstraints.BOTH;
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 8;
		gbc_label1.gridy = 1;
		getContentPane().add(label1, gbc_label1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 9;
		gbc_textField_2.gridy = 1;
		getContentPane().add(textField_2, gbc_textField_2);
		
		//LM SECOND 1
		firstOfSecond_LM = new JComboBox(new String[] {"LOC_method", "CYCLO_method"});
		firstOfSecond_LM.setForeground(Color.BLACK);
		firstOfSecond_LM.setBackground(Color.WHITE);
		firstOfSecond_LM.setVisible(false);
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
					textField_4.setVisible(false);
					label5.setVisible(false);
					textField_5.setVisible(false);
				} else {
					firstOfSecond_LM.setVisible(true);
					secondOfSecond_LM.setVisible(true);
					textField_4.setVisible(true);
					label5.setVisible(true);
					textField_5.setVisible(true);
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
		
		JLabel label2 = new JLabel("THAN");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.anchor = GridBagConstraints.WEST;
		gbc_label2.insets = new Insets(0, 0, 5, 5);
		gbc_label2.gridx = 13;
		gbc_label2.gridy = 1;
		getContentPane().add(label2, gbc_label2);
		
		JLabel label3 = new JLabel("is_Long_Method");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_label3 = new GridBagConstraints();
		gbc_label3.fill = GridBagConstraints.HORIZONTAL;
		gbc_label3.insets = new Insets(0, 0, 5, 5);
		gbc_label3.gridx = 15;
		gbc_label3.gridy = 1;
		getContentPane().add(label3, gbc_label3);
		
		JLabel label4 = new JLabel("IS");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label4 = new GridBagConstraints();
		gbc_label4.fill = GridBagConstraints.BOTH;
		gbc_label4.insets = new Insets(0, 0, 5, 5);
		gbc_label4.gridx = 17;
		gbc_label4.gridy = 1;
		getContentPane().add(label4, gbc_label4);
		
		JComboBox comboBox_2_2_2_1 = new JComboBox();
		comboBox_2_2_2_1.setModel(new DefaultComboBoxModel(new String[] {"TRUE", "FALSE"}));
		comboBox_2_2_2_1.setForeground(Color.BLACK);
		comboBox_2_2_2_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_2_2_2_1 = new GridBagConstraints();
		gbc_comboBox_2_2_2_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2_2_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2_2_2_1.gridx = 19;
		gbc_comboBox_2_2_2_1.gridy = 1;
		getContentPane().add(comboBox_2_2_2_1, gbc_comboBox_2_2_2_1);
		
		JButton btnNewButton = new JButton("New Rule");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 21;
		gbc_btnNewButton.gridy = 1;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JComboBox comboBox_2_2_2_1_1 = new JComboBox();
		comboBox_2_2_2_1_1.setForeground(Color.BLACK);
		comboBox_2_2_2_1_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_2_2_2_1_1 = new GridBagConstraints();
		gbc_comboBox_2_2_2_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2_2_2_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2_2_2_1_1.gridx = 23;
		gbc_comboBox_2_2_2_1_1.gridy = 1;
		getContentPane().add(comboBox_2_2_2_1_1, gbc_comboBox_2_2_2_1_1);
		
		//LM Second 2
		secondOfSecond_LM = new JComboBox(new String[] {"IS BETWEEN", "=", ">", "<", ">=", "<="});
		secondOfSecond_LM.setForeground(Color.BLACK);
		secondOfSecond_LM.setBackground(Color.WHITE);
		secondOfSecond_LM.setVisible(false);
		GridBagConstraints gbc_secondOfSecond_LM = new GridBagConstraints();
		gbc_secondOfSecond_LM.insets = new Insets(0, 0, 5, 5);
		gbc_secondOfSecond_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondOfSecond_LM.gridx = 5;
		gbc_secondOfSecond_LM.gridy = 2;
		getContentPane().add(secondOfSecond_LM, gbc_secondOfSecond_LM);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setVisible(false);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 7;
		gbc_textField_4.gridy = 2;
		getContentPane().add(textField_4, gbc_textField_4);
		
		label5 = new JLabel("AND");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setFont(new Font("Arial", Font.PLAIN, 12));
		label5.setVisible(false);
		GridBagConstraints gbc_label5 = new GridBagConstraints();
		gbc_label5.insets = new Insets(0, 0, 5, 5);
		gbc_label5.gridx = 8;
		gbc_label5.gridy = 2;
		getContentPane().add(label5, gbc_label5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setVisible(false);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 9;
		gbc_textField_5.gridy = 2;
		getContentPane().add(textField_5, gbc_textField_5);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("IF");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 1;
		gbc_lblNewLabel_1_1_1.gridy = 4;
		getContentPane().add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"NOM_class", "LOC_class", "WMC_class"}));
		comboBox_2_1.setForeground(Color.BLACK);
		comboBox_2_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_2_1 = new GridBagConstraints();
		gbc_comboBox_2_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2_1.gridx = 3;
		gbc_comboBox_2_1.gridy = 4;
		getContentPane().add(comboBox_2_1, gbc_comboBox_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"IS BETWEEN", "=", ">", "<", ">=", "<="}));
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 4;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 7;
		gbc_textField_1.gridy = 4;
		getContentPane().add(textField_1, gbc_textField_1);
		
		JLabel label6 = new JLabel("AND");
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label6 = new GridBagConstraints();
		gbc_label6.fill = GridBagConstraints.VERTICAL;
		gbc_label6.insets = new Insets(0, 0, 5, 5);
		gbc_label6.gridx = 8;
		gbc_label6.gridy = 4;
		getContentPane().add(label6, gbc_label6);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 9;
		gbc_textField_3.gridy = 4;
		getContentPane().add(textField_3, gbc_textField_3);
		
		GC_And_Or = new JComboBox();
		GC_And_Or.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GC_And_Or.getSelectedItem().equals("")) {
					firstOfSecond_GC.setVisible(false);
					secondOfSecond_GC.setVisible(false);
					textField_6.setVisible(false);
					label9.setVisible(false);
					textField_7.setVisible(false);
					GC_And_Or_1.setVisible(false);
				} else {
					firstOfSecond_GC.setVisible(true);
					secondOfSecond_GC.setVisible(true);
					textField_6.setVisible(true);
					label9.setVisible(true);
					textField_7.setVisible(true);
					GC_And_Or_1.setVisible(true);
				}
			}
		});
		GC_And_Or.setModel(new DefaultComboBoxModel(new String[] {"", "AND", "OR"}));
		GC_And_Or.setForeground(Color.BLACK);
		GC_And_Or.setBackground(Color.WHITE);
		GridBagConstraints gbc_GC_And_Or = new GridBagConstraints();
		gbc_GC_And_Or.fill = GridBagConstraints.HORIZONTAL;
		gbc_GC_And_Or.insets = new Insets(0, 0, 5, 5);
		gbc_GC_And_Or.gridx = 11;
		gbc_GC_And_Or.gridy = 4;
		getContentPane().add(GC_And_Or, gbc_GC_And_Or);
		
		JLabel label7 = new JLabel("THAN");
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		label7.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label7 = new GridBagConstraints();
		gbc_label7.anchor = GridBagConstraints.WEST;
		gbc_label7.insets = new Insets(0, 0, 5, 5);
		gbc_label7.gridx = 13;
		gbc_label7.gridy = 4;
		getContentPane().add(label7, gbc_label7);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("is_God_Class");
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.gridx = 15;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.gridy = 4;
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1_1);
		
		JLabel label8 = new JLabel("IS");
		label8.setHorizontalAlignment(SwingConstants.CENTER);
		label8.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label8 = new GridBagConstraints();
		gbc_label8.fill = GridBagConstraints.HORIZONTAL;
		gbc_label8.insets = new Insets(0, 0, 5, 5);
		gbc_label8.gridx = 17;
		gbc_label8.gridy = 4;
		getContentPane().add(label8, gbc_label8);
		
		JComboBox comboBox_2_2_2_1_2 = new JComboBox();
		comboBox_2_2_2_1_2.setModel(new DefaultComboBoxModel(new String[] {"TRUE", "FALSE"}));
		comboBox_2_2_2_1_2.setForeground(Color.BLACK);
		comboBox_2_2_2_1_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_2_2_2_1_2 = new GridBagConstraints();
		gbc_comboBox_2_2_2_1_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2_2_2_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2_2_2_1_2.gridx = 19;
		gbc_comboBox_2_2_2_1_2.gridy = 4;
		getContentPane().add(comboBox_2_2_2_1_2, gbc_comboBox_2_2_2_1_2);
		
		JButton btnNewButton_1 = new JButton("New Rule");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 21;
		gbc_btnNewButton_1.gridy = 4;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 23;
		gbc_comboBox_3.gridy = 4;
		getContentPane().add(comboBox_3, gbc_comboBox_3);
		
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
		secondOfSecond_GC.setForeground(Color.BLACK);
		secondOfSecond_GC.setBackground(Color.WHITE);
		secondOfSecond_GC.setVisible(false);
		GridBagConstraints gbc_secondOfSecond_GC = new GridBagConstraints();
		gbc_secondOfSecond_GC.insets = new Insets(0, 0, 5, 5);
		gbc_secondOfSecond_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondOfSecond_GC.gridx = 5;
		gbc_secondOfSecond_GC.gridy = 5;
		getContentPane().add(secondOfSecond_GC, gbc_secondOfSecond_GC);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setVisible(false);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 7;
		gbc_textField_6.gridy = 5;
		getContentPane().add(textField_6, gbc_textField_6);
		
		label9 = new JLabel("AND");
		label9.setHorizontalAlignment(SwingConstants.CENTER);
		label9.setFont(new Font("Arial", Font.PLAIN, 12));
		label9.setVisible(false);
		GridBagConstraints gbc_label9 = new GridBagConstraints();
		gbc_label9.fill = GridBagConstraints.HORIZONTAL;
		gbc_label9.insets = new Insets(0, 0, 5, 5);
		gbc_label9.gridx = 8;
		gbc_label9.gridy = 5;
		getContentPane().add(label9, gbc_label9);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setVisible(false);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 9;
		gbc_textField_7.gridy = 5;
		getContentPane().add(textField_7, gbc_textField_7);
		
		//GC Second 3
		GC_And_Or_1 = new JComboBox(new String[] {"", "AND", "OR"});
		GC_And_Or_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GC_And_Or_1.getSelectedItem().equals("")) {
					firstOfThird_GC.setVisible(false);
					secondOfThird_GC.setVisible(false);
					textField_8.setVisible(false);
					label10.setVisible(false);
					textField_9.setVisible(false);
				} else {
					firstOfThird_GC.setVisible(true);
					secondOfThird_GC.setVisible(true);
					textField_8.setVisible(true);
					label10.setVisible(true);
					textField_9.setVisible(true);
				}
			}
		});
		GC_And_Or_1.setForeground(Color.BLACK);
		GC_And_Or_1.setBackground(Color.WHITE);
		GC_And_Or_1.setVisible(false);
		GridBagConstraints gbc_GC_And_Or_1 = new GridBagConstraints();
		gbc_GC_And_Or_1.insets = new Insets(0, 0, 5, 5);
		gbc_GC_And_Or_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_GC_And_Or_1.gridx = 11;
		gbc_GC_And_Or_1.gridy = 5;
		getContentPane().add(GC_And_Or_1, gbc_GC_And_Or_1);
		
		firstOfThird_GC = new JComboBox(new String[] {"NOM_class", "LOC_class", "WMC_class"});
		firstOfThird_GC.setVisible(false);
		GridBagConstraints gbc_firstOfThird_GC = new GridBagConstraints();
		gbc_firstOfThird_GC.insets = new Insets(0, 0, 5, 5);
		gbc_firstOfThird_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstOfThird_GC.gridx = 3;
		gbc_firstOfThird_GC.gridy = 6;
		getContentPane().add(firstOfThird_GC, gbc_firstOfThird_GC);
		
		secondOfThird_GC = new JComboBox(new String[] {"IS BETWEEN", "=", ">", "<", ">=", "<="});
		secondOfThird_GC.setVisible(false);
		GridBagConstraints gbc_secondOfThird_GC = new GridBagConstraints();
		gbc_secondOfThird_GC.insets = new Insets(0, 0, 5, 5);
		gbc_secondOfThird_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_secondOfThird_GC.gridx = 5;
		gbc_secondOfThird_GC.gridy = 6;
		getContentPane().add(secondOfThird_GC, gbc_secondOfThird_GC);
		
		textField_8 = new JTextField();
		textField_8.setVisible(false);
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 7;
		gbc_textField_8.gridy = 6;
		getContentPane().add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		label10 = new JLabel("AND");
		label10.setFont(new Font("Arial", Font.PLAIN, 12));
		label10.setVisible(false);
		GridBagConstraints gbc_label10 = new GridBagConstraints();
		gbc_label10.insets = new Insets(0, 0, 5, 5);
		gbc_label10.gridx = 8;
		gbc_label10.gridy = 6;
		getContentPane().add(label10, gbc_label10);
		
		textField_9 = new JTextField();
		textField_9.setVisible(false);
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 9;
		gbc_textField_9.gridy = 6;
		getContentPane().add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
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
