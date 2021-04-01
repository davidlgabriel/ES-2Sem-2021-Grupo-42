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
	
	
	public Interface() {
		setBounds(100, 100, 1215, 558);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{19, 20, 20, 111, 25, 4, 30, 50, 40, 50, 30, 75, 30, 32, 30, 11, 20, 10, 30, 70, 22, 34, 31, 75, 0};
		gridBagLayout.rowHeights = new int[]{24, 34, 24, 30, 0, 0, 0, 0, 0};
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
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"LOC_method", "CYCLO_method"}));
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.gridx = 3;
		gbc_comboBox_2.gridy = 1;
		getContentPane().add(comboBox_2, gbc_comboBox_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLACK);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"IS BETWEEN", "=", ">", "<", ">=", "<="}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 1;
		getContentPane().add(comboBox, gbc_comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 7;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		
		JLabel lblNewLabel_1_1_1_1_1_3 = new JLabel("AND");
		lblNewLabel_1_1_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1_1_1_1_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_3.gridx = 8;
		gbc_lblNewLabel_1_1_1_1_1_3.gridy = 1;
		getContentPane().add(lblNewLabel_1_1_1_1_1_3, gbc_lblNewLabel_1_1_1_1_1_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.gridx = 9;
		gbc_textField_2.gridy = 1;
		getContentPane().add(textField_2, gbc_textField_2);
		
		JComboBox comboBox_2_2 = new JComboBox();
		comboBox_2_2.setModel(new DefaultComboBoxModel(new String[] {"", "AND", "OR"}));
		comboBox_2_2.setForeground(Color.BLACK);
		comboBox_2_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_2_2 = new GridBagConstraints();
		gbc_comboBox_2_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2_2.gridx = 11;
		gbc_comboBox_2_2.gridy = 1;
		getContentPane().add(comboBox_2_2, gbc_comboBox_2_2);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("THAN");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1.gridx = 13;
		gbc_lblNewLabel_1_1_1_1_1_1.gridy = 1;
		getContentPane().add(lblNewLabel_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("is_Long_Method");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1_1_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridx = 15;
		gbc_lblNewLabel_1_1_1_1_1_1_1.gridy = 1;
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("IS");
		lblNewLabel_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1_1_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1_2.gridx = 17;
		gbc_lblNewLabel_1_1_1_1_1_2.gridy = 1;
		getContentPane().add(lblNewLabel_1_1_1_1_1_2, gbc_lblNewLabel_1_1_1_1_1_2);
		
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
		
		JComboBox comboBox_2_2_1 = new JComboBox();
		comboBox_2_2_1.setModel(new DefaultComboBoxModel(new String[] {"", "AND", "OR"}));
		comboBox_2_2_1.setForeground(Color.BLACK);
		comboBox_2_2_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_2_2_1 = new GridBagConstraints();
		gbc_comboBox_2_2_1.anchor = GridBagConstraints.NORTH;
		gbc_comboBox_2_2_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2_2_1.gridx = 11;
		gbc_comboBox_2_2_1.gridy = 4;
		getContentPane().add(comboBox_2_2_1, gbc_comboBox_2_2_1);
		
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
