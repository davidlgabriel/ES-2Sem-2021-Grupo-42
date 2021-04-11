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
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
	private EscreverMétricasParaExcel excel = null;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	private JLabel label5;
	
	private JComboBox firstOfSecond_LM;
	private JComboBox LM_And_Or;
	private JComboBox firstOfFirst_LM;
	private JComboBox secondOfFirst_LM;
	private JComboBox secondOfSecond_LM;
	
	
	public Interface() {
		setBounds(100, 100, 1500, 603);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{19, 20, 20, 110, 25, 4, 30, 50, 40, 50, 30, 75, 30, 32, 30, 11, 20, 10, 30, 70, 22, 34, 31, 75, 0};
		gridBagLayout.rowHeights = new int[]{24, 35, 35, 30, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("AND");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1.gridx = 8;
		gbc_lblNewLabel_1_1_1_1_1.gridy = 4;
		getContentPane().add(lblNewLabel_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 9;
		gbc_textField_3.gridy = 4;
		getContentPane().add(textField_3, gbc_textField_3);
		
		JComboBox GC_And_Or = new JComboBox();
		GC_And_Or.setModel(new DefaultComboBoxModel(new String[] {"", "AND", "OR"}));
		GC_And_Or.setForeground(Color.BLACK);
		GC_And_Or.setBackground(Color.WHITE);
		GridBagConstraints gbc_GC_And_Or = new GridBagConstraints();
		gbc_GC_And_Or.anchor = GridBagConstraints.NORTH;
		gbc_GC_And_Or.fill = GridBagConstraints.HORIZONTAL;
		gbc_GC_And_Or.insets = new Insets(0, 0, 5, 5);
		gbc_GC_And_Or.gridx = 11;
		gbc_GC_And_Or.gridy = 4;
		getContentPane().add(GC_And_Or, gbc_GC_And_Or);
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("THAN");
		lblNewLabel_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1_1_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_2.gridx = 13;
		gbc_lblNewLabel_1_1_1_1_1_1_2.gridy = 4;
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_2, gbc_lblNewLabel_1_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("is_God_Class");
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.gridx = 15;
		gbc_lblNewLabel_1_1_1_1_1_1_1_1.gridy = 4;
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1 = new JLabel("IS");
		lblNewLabel_1_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_2_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1_1_1_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_2_1.gridx = 17;
		gbc_lblNewLabel_1_1_1_1_1_2_1.gridy = 4;
		getContentPane().add(lblNewLabel_1_1_1_1_1_2_1, gbc_lblNewLabel_1_1_1_1_1_2_1);
		
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
		
		JLabel lblNewLabel = new JLabel("Diretório");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 7;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número de Packages:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 15;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("0");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 15;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Número de classes:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 16;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("0");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 5;
		gbc_lblNewLabel_4.gridy = 16;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Número de métodos:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 17;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("0");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 5;
		gbc_lblNewLabel_6.gridy = 17;
		getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Número de linhas de código:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 3;
		gbc_lblNewLabel_7.gridy = 18;
		getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("0");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.gridx = 5;
		gbc_lblNewLabel_8.gridy = 18;
		getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JButton btnNewButton_2 = new JButton("Escolher diretório");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser diretorio = new JFileChooser();
				diretorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				int returnValue = diretorio.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
				selectedFile = diretorio.getSelectedFile();
				lblNewLabel.setText(selectedFile.getAbsolutePath());
				
				percorrer();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 7;
		gbc_btnNewButton_2.gridy = 7;
		getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Criar Excel");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excel = new EscreverMétricasParaExcel(caminhoFicheiros);
				try {
					excel.escreverNomeDoFicheiro();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Set <String> packages = new HashSet<>(excel.getnomePackages());
				lblNewLabel_2.setText(Integer.toString(packages.size()));
				lblNewLabel_4.setText(Integer.toString(excel.getNumberClasses()));
				ArrayList<Integer> LOC_métodos = excel.getLOC_method_array();
				lblNewLabel_6.setText(Integer.toString(LOC_métodos.size()));
				int soma = 0;
				for(int aux: LOC_métodos)
					soma+=aux;
				lblNewLabel_8.setText(Integer.toString(soma));
			}
		});
		
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 9;
		gbc_btnNewButton_3.gridy = 7;
		getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
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
