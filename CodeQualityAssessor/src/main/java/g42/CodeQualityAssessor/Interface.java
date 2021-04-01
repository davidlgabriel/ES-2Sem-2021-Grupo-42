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
		setBounds(100, 100, 1192, 558);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 28, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox, -903, SpringLayout.EAST, getContentPane());
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLACK);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"IS BETWEEN", "IS EQUAL "}));
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("IF");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 30, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 10, SpringLayout.WEST, getContentPane());
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("AND");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1, 34, SpringLayout.NORTH, getContentPane());
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		textField_2 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1, 16, SpringLayout.EAST, textField_2);
		springLayout.putConstraint(SpringLayout.NORTH, textField_2, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 20, SpringLayout.EAST, comboBox);
		textField_2.setColumns(10);
		getContentPane().add(textField_2);
		
		JComboBox comboBox_2_2 = new JComboBox();
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, 0, SpringLayout.SOUTH, comboBox_2_2);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_2_2, -1, SpringLayout.NORTH, comboBox);
		comboBox_2_2.setForeground(Color.RED);
		comboBox_2_2.setBackground(Color.WHITE);
		getContentPane().add(comboBox_2_2);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("THAN");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1_1, 620, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2_2, -18, SpringLayout.WEST, lblNewLabel_1_1_1_1_1_1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1_1_1_1_1_1, 0, SpringLayout.SOUTH, comboBox_2_2);
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("is_Long_Method");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1_1_1, 0, SpringLayout.NORTH, lblNewLabel_1_1_1_1_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1_1_1, 18, SpringLayout.EAST, lblNewLabel_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("IS");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1_2, 2, SpringLayout.NORTH, lblNewLabel_1_1_1_1_1_1_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1_2, 24, SpringLayout.EAST, lblNewLabel_1_1_1_1_1_1_1);
		lblNewLabel_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_1_1_1_1_1_2);
		
		JComboBox comboBox_2 = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 19, SpringLayout.EAST, comboBox_2);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_2, 28, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2, 18, SpringLayout.EAST, lblNewLabel_1_1);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2, -1013, SpringLayout.EAST, getContentPane());
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"LOC_method", "CYCLO_method"}));
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setBackground(Color.WHITE);
		getContentPane().add(comboBox_2);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2_2, 24, SpringLayout.EAST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 22, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, textField, 12, SpringLayout.EAST, lblNewLabel_1_1_1_1_1);
		springLayout.putConstraint(SpringLayout.EAST, textField, -679, SpringLayout.EAST, getContentPane());
		textField.setColumns(10);
		getContentPane().add(textField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("IF");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 61, SpringLayout.SOUTH, lblNewLabel_1_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 0, SpringLayout.WEST, lblNewLabel_1_1);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		getContentPane().add(lblNewLabel_1_1_1);
		
		JComboBox comboBox_2_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_2_1, 54, SpringLayout.SOUTH, comboBox_2);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2_1, 6, SpringLayout.EAST, lblNewLabel_1_1_1);
		comboBox_2_1.setModel(new DefaultComboBoxModel(new String[] {"NOM_class", "LOC_class", "WMC_class"}));
		comboBox_2_1.setForeground(Color.BLACK);
		comboBox_2_1.setBackground(Color.WHITE);
		getContentPane().add(comboBox_2_1);
		
		JComboBox comboBox_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.WEST, comboBox_1, 308, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2_1, -15, SpringLayout.WEST, comboBox_1);
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_1, -4, SpringLayout.NORTH, lblNewLabel_1_1_1);
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setBackground(Color.WHITE);
		getContentPane().add(comboBox_1);
		
		textField_1 = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 413, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, comboBox_1, -14, SpringLayout.WEST, textField_1);
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, lblNewLabel_1_1_1);
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1_1_1_1_3 = new JLabel("AND");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1_3, 12, SpringLayout.EAST, textField_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1_3, 0, SpringLayout.NORTH, lblNewLabel_1_1_1);
		lblNewLabel_1_1_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_1_1_1_1_1_3);
		
		textField_3 = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField_3, -3, SpringLayout.NORTH, lblNewLabel_1_1_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_3, 6, SpringLayout.EAST, lblNewLabel_1_1_1_1_1_3);
		textField_3.setColumns(10);
		getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("THAN");
		springLayout.putConstraint(SpringLayout.EAST, textField_3, -121, SpringLayout.WEST, lblNewLabel_1_1_1_1_1_1_2);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1_1_2, 0, SpringLayout.NORTH, lblNewLabel_1_1_1);
		lblNewLabel_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("is_God_Class");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1_1_1_1, 775, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1_1_1_1_2, -14, SpringLayout.WEST, lblNewLabel_1_1_1_1_1_1_1_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1_1_1_1, -2, SpringLayout.NORTH, lblNewLabel_1_1_1);
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		getContentPane().add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2_1 = new JLabel("IS");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1_1_1_2_1, 907, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1_1_1_1_1_1, -22, SpringLayout.WEST, lblNewLabel_1_1_1_1_1_2_1);
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1_1_1_2_1, 0, SpringLayout.NORTH, lblNewLabel_1_1_1);
		lblNewLabel_1_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().add(lblNewLabel_1_1_1_1_1_2_1);
		
		JComboBox comboBox_2_2_2_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_2_2_2_1, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2_2_2_1, 16, SpringLayout.EAST, lblNewLabel_1_1_1_1_1_2);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_2_2_2_1, 0, SpringLayout.SOUTH, lblNewLabel_1_1_1_1_1_1_1);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2_2_2_1, -275, SpringLayout.EAST, getContentPane());
		comboBox_2_2_2_1.setForeground(Color.RED);
		comboBox_2_2_2_1.setBackground(Color.WHITE);
		getContentPane().add(comboBox_2_2_2_1);
		
		JComboBox comboBox_2_2_2_1_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_2_2_2_1_1, -4, SpringLayout.NORTH, lblNewLabel_1_1_1);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2_2_2_1_1, -10, SpringLayout.EAST, getContentPane());
		comboBox_2_2_2_1_1.setForeground(Color.RED);
		comboBox_2_2_2_1_1.setBackground(Color.WHITE);
		getContentPane().add(comboBox_2_2_2_1_1);
		
		JButton btnNewButton = new JButton("New button");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, lblNewLabel_1_1_1_1_1_1_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 45, SpringLayout.EAST, comboBox_2_2_2_1);
		getContentPane().add(btnNewButton);
		
		JComboBox comboBox_3 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_3, 0, SpringLayout.NORTH, comboBox);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_3, 37, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.SOUTH, comboBox_3, 0, SpringLayout.SOUTH, lblNewLabel_1_1_1_1_1_1_1);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_3, -36, SpringLayout.EAST, getContentPane());
		getContentPane().add(comboBox_3);
		
		JComboBox comboBox_2_2_1 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_2_2_1, 100, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2_2_1, 24, SpringLayout.EAST, textField_3);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2_2_1, -16, SpringLayout.WEST, lblNewLabel_1_1_1_1_1_1_2);
		comboBox_2_2_1.setForeground(Color.RED);
		comboBox_2_2_1.setBackground(Color.WHITE);
		getContentPane().add(comboBox_2_2_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2_2_2_1_1, 6, SpringLayout.EAST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, -4, SpringLayout.NORTH, lblNewLabel_1_1_1);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 85, SpringLayout.EAST, lblNewLabel_1_1_1_1_1_2_1);
		getContentPane().add(btnNewButton_1);
		
		JComboBox comboBox_2_2_2_1_2 = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox_2_2_2_1_2, -4, SpringLayout.NORTH, lblNewLabel_1_1_1);
		springLayout.putConstraint(SpringLayout.WEST, comboBox_2_2_2_1_2, 16, SpringLayout.EAST, lblNewLabel_1_1_1_1_1_2_1);
		springLayout.putConstraint(SpringLayout.EAST, comboBox_2_2_2_1_2, -6, SpringLayout.WEST, btnNewButton_1);
		comboBox_2_2_2_1_2.setForeground(Color.RED);
		comboBox_2_2_2_1_2.setBackground(Color.WHITE);
		getContentPane().add(comboBox_2_2_2_1_2);
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
