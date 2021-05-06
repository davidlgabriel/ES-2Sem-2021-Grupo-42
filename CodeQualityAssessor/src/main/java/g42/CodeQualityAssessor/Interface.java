package g42.CodeQualityAssessor;

import javax.swing.JButton;
import javax.swing.JDialog;

import org.apache.poi.EncryptedDocumentException;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
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
	private File diretorioEscolhido = null;
	private ArrayList<String> caminhoFicheiros = new ArrayList<>();
	private JTextField LMC1valorM2;
	private JTextField LMC1valorM1;
	private JTextField GCC1valorM1;
	private JTextField GCC1valorM2;
	private JTextField LMC2valorM1;
	private JTextField LMC2valorM2;
	private JTextField GCC2valorM1;
	private JTextField GCC2valorM2;
	private JTextField GCC3valorM1;
	private JTextField GCC3valorM2;
	private JLabel LabelANDC1LM;
	private JLabel LabelANDC2LM;
	private JLabel LabelANDC2GC;
	private JLabel LabelANDC3GC;
	private JLabel LabelANDC1GC;
	private JLabel LabelDiretorio;
	private JLabel LabelCountPackages;
	private JLabel LabelCountClasses;
	private JComboBox ListaMetricasC2LM;
	private JComboBox LM_And_Or;
	private JComboBox ListaMetricasC1LM;
	private JComboBox ListaOpcoesC1LM;
	private JComboBox ListaOpcoesC2LM;
	private JComboBox GC_And_Or;
	private JComboBox ListaMetricasC2GC;
	private JComboBox ListaOpcoesC2GC;
	private JComboBox second_GC_And_Or;
	private JComboBox ListaMetricasC3GC;
	private JComboBox ListaOpcoesC3GC;
	private JComboBox ListaOpcoesC1GC;
	private JComboBox isTrueFalse_LM;
	private JComboBox ListaMetricasC1GC;
	private JComboBox isTrueFalse_GC;
	private JTextField NomeRegraLM;
	private JButton BotaoCriarRegraLM;
	private JButton ConfirmarRegraLM;
	private JComboBox ListaRegrasLMAlterar;
	private JLabel labelNome_LM;
	private JLabel labelNome_GC;
	private JTextField NomeRegraGC;
	private JButton ConfirmarRegraGC;
	private JButton BotaoCriarRegraGC;
	private JComboBox ListaRegrasGCAlterar;
	private JLabel LabelCountMetodos;
	private JLabel LabelCountLinhasCodigo;
	private JTable tableExcel;
	private JScrollPane scrollPaneExcel;
	private JButton BotaoAplicarRegras;

	private String regraLMAlterar = "";
	private String regraGCAlterar = "";

	private HashMap<String, Regra> regrasGodClass = new HashMap<>();
	private HashMap<String, Regra> regrasLongMethod = new HashMap<>();
	private JComboBox ListaRegrasLMAplicar;
	private JComboBox ListaRegrasGCAplicar;
	private JLabel LabelTextoVP;
	private JLabel LabelTextoFP;
	private JLabel LabelTextVN;
	private JLabel LabelTextoFN;
	private JLabel LabelCountVP;
	private JLabel LabelCountFP;
	private JLabel LabelCountVN;
	private JLabel LabelCountFN;

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

		setBounds(100, 100, 1297, 750);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 20, 110, 4, 50, 40, 50, 75, 32, 11, 37,
				100, 70, 80, 0 };
		gridBagLayout.rowHeights = new int[] { 35, 35, 35, 35, 0, 28, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0 };
		getContentPane().setLayout(gridBagLayout);

		JLabel if_LM = new JLabel("IF");
		if_LM.setHorizontalAlignment(SwingConstants.CENTER);
		if_LM.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_if_LM = new GridBagConstraints();
		gbc_if_LM.insets = new Insets(0, 0, 5, 5);
		gbc_if_LM.gridx = 0;
		gbc_if_LM.gridy = 0;
		getContentPane().add(if_LM, gbc_if_LM);

		// LM First 1
		ListaMetricasC1LM = new JComboBox(new String[] { "LOC_method", "CYCLO_method" });
		ListaMetricasC1LM.setModel(new DefaultComboBoxModel(new String[] { "LOC_method", "CYCLO_method" }));
		ListaMetricasC1LM.setForeground(Color.BLACK);
		ListaMetricasC1LM.setBackground(Color.WHITE);
		GridBagConstraints gbc_ListaMetricasC1LM = new GridBagConstraints();
		gbc_ListaMetricasC1LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaMetricasC1LM.insets = new Insets(0, 0, 5, 5);
		gbc_ListaMetricasC1LM.gridx = 1;
		gbc_ListaMetricasC1LM.gridy = 0;
		getContentPane().add(ListaMetricasC1LM, gbc_ListaMetricasC1LM);

		// LM First 2
		ListaOpcoesC1LM = new JComboBox(new String[] { "IS BETWEEN", "=", ">", "<", ">=", "<=" });
		ListaOpcoesC1LM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ListaOpcoesC1LM.getSelectedItem().equals("IS BETWEEN")) {
					LabelANDC1LM.setVisible(true);
					LMC1valorM2.setVisible(true);
				} else {
					LabelANDC1LM.setVisible(false);
					LMC1valorM2.setVisible(false);
				}
			}
		});
		ListaOpcoesC1LM.setBackground(Color.WHITE);
		ListaOpcoesC1LM.setForeground(Color.BLACK);
		GridBagConstraints gbc_ListaOpcoesC1LM = new GridBagConstraints();
		gbc_ListaOpcoesC1LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaOpcoesC1LM.insets = new Insets(0, 0, 5, 5);
		gbc_ListaOpcoesC1LM.gridx = 2;
		gbc_ListaOpcoesC1LM.gridy = 0;
		getContentPane().add(ListaOpcoesC1LM, gbc_ListaOpcoesC1LM);

		LMC1valorM1 = new JTextField();
		LMC1valorM1.setColumns(10);
		GridBagConstraints gbc_LMC1valorM1 = new GridBagConstraints();
		gbc_LMC1valorM1.fill = GridBagConstraints.HORIZONTAL;
		gbc_LMC1valorM1.insets = new Insets(0, 0, 5, 5);
		gbc_LMC1valorM1.gridx = 3;
		gbc_LMC1valorM1.gridy = 0;
		getContentPane().add(LMC1valorM1, gbc_LMC1valorM1);
		LMC1valorM1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		LabelANDC1LM = new JLabel("AND");
		LabelANDC1LM.setHorizontalAlignment(SwingConstants.CENTER);
		LabelANDC1LM.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_LabelANDC1LM = new GridBagConstraints();
		gbc_LabelANDC1LM.fill = GridBagConstraints.BOTH;
		gbc_LabelANDC1LM.insets = new Insets(0, 0, 5, 5);
		gbc_LabelANDC1LM.gridx = 4;
		gbc_LabelANDC1LM.gridy = 0;
		getContentPane().add(LabelANDC1LM, gbc_LabelANDC1LM);

		LMC1valorM2 = new JTextField();
		LMC1valorM2.setColumns(10);
		GridBagConstraints gbc_LMC1valorM2 = new GridBagConstraints();
		gbc_LMC1valorM2.fill = GridBagConstraints.HORIZONTAL;
		gbc_LMC1valorM2.insets = new Insets(0, 0, 5, 5);
		gbc_LMC1valorM2.gridx = 5;
		gbc_LMC1valorM2.gridy = 0;
		getContentPane().add(LMC1valorM2, gbc_LMC1valorM2);
		LMC1valorM2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if ((((caracter < '0') || (caracter > '9')) && (caracter != '\b'))) {
					e.consume();
				}
			}
		});

		// LM SECOND 1
		ListaMetricasC2LM = new JComboBox(new String[] { "LOC_method", "CYCLO_method" });
		ListaMetricasC2LM.setModel(new DefaultComboBoxModel(new String[] { "LOC_method", "CYCLO_method" }));
		ListaMetricasC2LM.setForeground(Color.BLACK);
		ListaMetricasC2LM.setBackground(Color.WHITE);
		ListaMetricasC2LM.setVisible(false);
		isTrueFalse_LM = new JComboBox(new String[] { "TRUE", "FALSE" });
		isTrueFalse_LM.setForeground(Color.BLACK);
		isTrueFalse_LM.setBackground(Color.WHITE);
		GridBagConstraints gbc_isTrueFalse_LM = new GridBagConstraints();
		gbc_isTrueFalse_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_isTrueFalse_LM.insets = new Insets(0, 0, 5, 5);
		gbc_isTrueFalse_LM.gridx = 10;
		gbc_isTrueFalse_LM.gridy = 0;
		getContentPane().add(isTrueFalse_LM, gbc_isTrueFalse_LM);

		ConfirmarRegraLM = new JButton("Confirm");
		ConfirmarRegraLM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoConfirmLM();
			}
		});
		GridBagConstraints gbc_ConfirmarRegraLM = new GridBagConstraints();
		gbc_ConfirmarRegraLM.insets = new Insets(0, 0, 5, 5);
		gbc_ConfirmarRegraLM.gridx = 11;
		gbc_ConfirmarRegraLM.gridy = 0;
		getContentPane().add(ConfirmarRegraLM, gbc_ConfirmarRegraLM);

		BotaoCriarRegraLM = new JButton("Create Rule");
		BotaoCriarRegraLM.setEnabled(false);
		BotaoCriarRegraLM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarRegraLM();
			}
		});
		BotaoCriarRegraLM.setVisible(true);
		GridBagConstraints gbc_BotaoCriarRegraLM = new GridBagConstraints();
		gbc_BotaoCriarRegraLM.insets = new Insets(0, 0, 5, 0);
		gbc_BotaoCriarRegraLM.gridx = 12;
		gbc_BotaoCriarRegraLM.gridy = 0;
		getContentPane().add(BotaoCriarRegraLM, gbc_BotaoCriarRegraLM);
		GridBagConstraints gbc_ListaMetricasC2LM = new GridBagConstraints();
		gbc_ListaMetricasC2LM.insets = new Insets(0, 0, 5, 5);
		gbc_ListaMetricasC2LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaMetricasC2LM.gridx = 1;
		gbc_ListaMetricasC2LM.gridy = 1;
		getContentPane().add(ListaMetricasC2LM, gbc_ListaMetricasC2LM);

		LM_And_Or = new JComboBox(new String[] { "", "AND", "OR" });
		LM_And_Or.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (LM_And_Or.getSelectedItem().equals("")) {
					ListaMetricasC2LM.setVisible(false);
					ListaOpcoesC2LM.setVisible(false);
					LMC2valorM1.setVisible(false);
					LabelANDC2LM.setVisible(false);
					LMC2valorM2.setVisible(false);
					LMC2valorM1.setText("");
					LMC2valorM2.setText("");

				} else {
					ListaMetricasC2LM.setVisible(true);
					ListaOpcoesC2LM.setVisible(true);
					LMC2valorM1.setVisible(true);
					LabelANDC2LM.setVisible(true);
					LMC2valorM2.setVisible(true);
					ListaOpcoesC2LM.setSelectedItem("IS BETWEEN");

				}
			}
		});
		LM_And_Or.setForeground(Color.BLACK);
		LM_And_Or.setBackground(Color.WHITE);
		GridBagConstraints gbc_LM_And_Or = new GridBagConstraints();
		gbc_LM_And_Or.fill = GridBagConstraints.HORIZONTAL;
		gbc_LM_And_Or.insets = new Insets(0, 0, 5, 5);
		gbc_LM_And_Or.gridx = 6;
		gbc_LM_And_Or.gridy = 0;
		getContentPane().add(LM_And_Or, gbc_LM_And_Or);

		JLabel label2_LM = new JLabel("THAN");
		label2_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label2_LM.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label2_LM = new GridBagConstraints();
		gbc_label2_LM.anchor = GridBagConstraints.WEST;
		gbc_label2_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label2_LM.gridx = 7;
		gbc_label2_LM.gridy = 0;
		getContentPane().add(label2_LM, gbc_label2_LM);

		JLabel label3_LM = new JLabel("is_Long_Method");
		label3_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label3_LM.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_label3_LM = new GridBagConstraints();
		gbc_label3_LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_label3_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label3_LM.gridx = 8;
		gbc_label3_LM.gridy = 0;
		getContentPane().add(label3_LM, gbc_label3_LM);

		JLabel label4_LM = new JLabel("IS");
		label4_LM.setHorizontalAlignment(SwingConstants.CENTER);
		label4_LM.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label4_LM = new GridBagConstraints();
		gbc_label4_LM.fill = GridBagConstraints.BOTH;
		gbc_label4_LM.insets = new Insets(0, 0, 5, 5);
		gbc_label4_LM.gridx = 9;
		gbc_label4_LM.gridy = 0;
		getContentPane().add(label4_LM, gbc_label4_LM);

		// LM Second 2
		ListaOpcoesC2LM = new JComboBox(new String[] { "IS BETWEEN", "=", ">", "<", ">=", "<=" });
		ListaOpcoesC2LM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ListaOpcoesC2LM.getSelectedItem().equals("IS BETWEEN")) {
					LabelANDC2LM.setVisible(true);
					LMC2valorM2.setVisible(true);
				} else {
					LabelANDC2LM.setVisible(false);
					LMC2valorM2.setVisible(false);
				}
			}
		});
		ListaOpcoesC2LM.setForeground(Color.BLACK);
		ListaOpcoesC2LM.setBackground(Color.WHITE);
		ListaOpcoesC2LM.setVisible(false);
		GridBagConstraints gbc_ListaOpcoesC2LM = new GridBagConstraints();
		gbc_ListaOpcoesC2LM.insets = new Insets(0, 0, 5, 5);
		gbc_ListaOpcoesC2LM.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaOpcoesC2LM.gridx = 2;
		gbc_ListaOpcoesC2LM.gridy = 1;
		getContentPane().add(ListaOpcoesC2LM, gbc_ListaOpcoesC2LM);

		LMC2valorM1 = new JTextField();
		LMC2valorM1.setColumns(10);
		LMC2valorM1.setVisible(false);
		GridBagConstraints gbc_LMC2valorM1 = new GridBagConstraints();
		gbc_LMC2valorM1.insets = new Insets(0, 0, 5, 5);
		gbc_LMC2valorM1.fill = GridBagConstraints.HORIZONTAL;
		gbc_LMC2valorM1.gridx = 3;
		gbc_LMC2valorM1.gridy = 1;
		getContentPane().add(LMC2valorM1, gbc_LMC2valorM1);
		LMC2valorM1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		LabelANDC2LM = new JLabel("AND");
		LabelANDC2LM.setHorizontalAlignment(SwingConstants.CENTER);
		LabelANDC2LM.setFont(new Font("Arial", Font.PLAIN, 12));
		LabelANDC2LM.setVisible(false);
		GridBagConstraints gbc_LabelANDC2LM = new GridBagConstraints();
		gbc_LabelANDC2LM.insets = new Insets(0, 0, 5, 5);
		gbc_LabelANDC2LM.gridx = 4;
		gbc_LabelANDC2LM.gridy = 1;
		getContentPane().add(LabelANDC2LM, gbc_LabelANDC2LM);

		LMC2valorM2 = new JTextField();
		LMC2valorM2.setColumns(10);
		LMC2valorM2.setVisible(false);
		GridBagConstraints gbc_LMC2valorM2 = new GridBagConstraints();
		gbc_LMC2valorM2.insets = new Insets(0, 0, 5, 5);
		gbc_LMC2valorM2.fill = GridBagConstraints.HORIZONTAL;
		gbc_LMC2valorM2.gridx = 5;
		gbc_LMC2valorM2.gridy = 1;
		getContentPane().add(LMC2valorM2, gbc_LMC2valorM2);
		LMC2valorM2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		NomeRegraLM = new JTextField();
		NomeRegraLM.setEnabled(false);
		NomeRegraLM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode()!=8 && !(NomeRegraLM.getText()+e.getKeyChar()).equals("") || (NomeRegraLM.getText()).length()>=2) && e.getKeyCode() != 32) {
					BotaoCriarRegraLM.setEnabled(true);
				} else {
					BotaoCriarRegraLM.setEnabled(false);
				}
			}
		});

		labelNome_LM = new JLabel("Nome :");
		GridBagConstraints gbc_labelNome_LM = new GridBagConstraints();
		gbc_labelNome_LM.anchor = GridBagConstraints.EAST;
		gbc_labelNome_LM.insets = new Insets(0, 0, 5, 5);
		gbc_labelNome_LM.gridx = 10;
		gbc_labelNome_LM.gridy = 1;
		getContentPane().add(labelNome_LM, gbc_labelNome_LM);
		GridBagConstraints gbc_NomeRegraLM = new GridBagConstraints();
		gbc_NomeRegraLM.insets = new Insets(0, 0, 5, 5);
		gbc_NomeRegraLM.fill = GridBagConstraints.HORIZONTAL;
		gbc_NomeRegraLM.gridx = 11;
		gbc_NomeRegraLM.gridy = 1;
		getContentPane().add(NomeRegraLM, gbc_NomeRegraLM);
		NomeRegraLM.setColumns(10);

		ListaRegrasLMAlterar = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 12;
		gbc_comboBox.gridy = 1;
		ListaRegrasLMAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				regraLMAlterar = (String) ListaRegrasLMAlterar.getSelectedItem();
				if (regraLMAlterar==null || regraLMAlterar.equals(""))
					resetCamposLM();
				else
					alterarRegraLM();
			}
		});
		getContentPane().add(ListaRegrasLMAlterar, gbc_comboBox);

		JLabel if_GC = new JLabel("IF");
		if_GC.setHorizontalAlignment(SwingConstants.CENTER);
		if_GC.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_if_GC = new GridBagConstraints();
		gbc_if_GC.insets = new Insets(0, 0, 5, 5);
		gbc_if_GC.gridx = 0;
		gbc_if_GC.gridy = 2;
		getContentPane().add(if_GC, gbc_if_GC);

		ListaMetricasC1GC = new JComboBox(new String[] { "NOM_class", "LOC_class", "WMC_class" });
		ListaMetricasC1GC.setForeground(Color.BLACK);
		ListaMetricasC1GC.setBackground(Color.WHITE);
		GridBagConstraints gbc_ListaMetricasC1GC = new GridBagConstraints();
		gbc_ListaMetricasC1GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaMetricasC1GC.insets = new Insets(0, 0, 5, 5);
		gbc_ListaMetricasC1GC.gridx = 1;
		gbc_ListaMetricasC1GC.gridy = 2;
		getContentPane().add(ListaMetricasC1GC, gbc_ListaMetricasC1GC);

		ListaOpcoesC1GC = new JComboBox(new String[] { "IS BETWEEN", "=", ">", "<", ">=", "<=" });
		ListaOpcoesC1GC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ListaOpcoesC1GC.getSelectedItem().equals("IS BETWEEN")) {
					LabelANDC1GC.setVisible(true);
					GCC1valorM2.setVisible(true);
				} else {
					LabelANDC1GC.setVisible(false);
					GCC1valorM2.setVisible(false);
				}
			}
		});
		ListaOpcoesC1GC.setForeground(Color.BLACK);
		ListaOpcoesC1GC.setBackground(Color.WHITE);
		GridBagConstraints gbc_ListaOpcoesC1GC = new GridBagConstraints();
		gbc_ListaOpcoesC1GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaOpcoesC1GC.insets = new Insets(0, 0, 5, 5);
		gbc_ListaOpcoesC1GC.gridx = 2;
		gbc_ListaOpcoesC1GC.gridy = 2;
		getContentPane().add(ListaOpcoesC1GC, gbc_ListaOpcoesC1GC);

		GCC1valorM1 = new JTextField();
		GCC1valorM1.setColumns(10);
		GridBagConstraints gbc_GCC1valorM1 = new GridBagConstraints();
		gbc_GCC1valorM1.fill = GridBagConstraints.HORIZONTAL;
		gbc_GCC1valorM1.insets = new Insets(0, 0, 5, 5);
		gbc_GCC1valorM1.gridx = 3;
		gbc_GCC1valorM1.gridy = 2;
		getContentPane().add(GCC1valorM1, gbc_GCC1valorM1);
		GCC1valorM1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		LabelANDC1GC = new JLabel("AND");
		LabelANDC1GC.setHorizontalAlignment(SwingConstants.CENTER);
		LabelANDC1GC.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_LabelANDC1GC = new GridBagConstraints();
		gbc_LabelANDC1GC.fill = GridBagConstraints.VERTICAL;
		gbc_LabelANDC1GC.insets = new Insets(0, 0, 5, 5);
		gbc_LabelANDC1GC.gridx = 4;
		gbc_LabelANDC1GC.gridy = 2;
		getContentPane().add(LabelANDC1GC, gbc_LabelANDC1GC);

		GCC1valorM2 = new JTextField();
		GCC1valorM2.setColumns(10);
		GridBagConstraints gbc_GCC1valorM2 = new GridBagConstraints();
		gbc_GCC1valorM2.fill = GridBagConstraints.HORIZONTAL;
		gbc_GCC1valorM2.insets = new Insets(0, 0, 5, 5);
		gbc_GCC1valorM2.gridx = 5;
		gbc_GCC1valorM2.gridy = 2;
		getContentPane().add(GCC1valorM2, gbc_GCC1valorM2);
		GCC1valorM2.addKeyListener(new KeyAdapter() {
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
					ListaMetricasC2GC.setVisible(false);
					ListaOpcoesC2GC.setVisible(false);
					GCC2valorM1.setVisible(false);
					LabelANDC2GC.setVisible(false);
					GCC2valorM2.setVisible(false);
					second_GC_And_Or.setVisible(false);
					ListaMetricasC3GC.setVisible(false);
					ListaOpcoesC3GC.setVisible(false);
					GCC3valorM1.setVisible(false);
					LabelANDC3GC.setVisible(false);
					GCC3valorM2.setVisible(false);
					GCC3valorM2.setText("");
					GCC2valorM1.setText("");
					GCC2valorM2.setText("");
					GCC3valorM1.setText("");
					GCC3valorM2.setText("");
				} else {
					ListaMetricasC2GC.setVisible(true);
					ListaOpcoesC2GC.setVisible(true);
					GCC2valorM1.setVisible(true);
					LabelANDC2GC.setVisible(true);
					GCC2valorM2.setVisible(true);
					second_GC_And_Or.setVisible(true);
					ListaOpcoesC2GC.setSelectedItem("IS BETWEEN");
				}
			}
		});
		GC_And_Or.setForeground(Color.BLACK);
		GC_And_Or.setBackground(Color.WHITE);
		GridBagConstraints gbc_GC_And_Or = new GridBagConstraints();
		gbc_GC_And_Or.fill = GridBagConstraints.HORIZONTAL;
		gbc_GC_And_Or.insets = new Insets(0, 0, 5, 5);
		gbc_GC_And_Or.gridx = 6;
		gbc_GC_And_Or.gridy = 2;
		getContentPane().add(GC_And_Or, gbc_GC_And_Or);

		JLabel label2_GC = new JLabel("THAN");
		label2_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label2_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label2_GC = new GridBagConstraints();
		gbc_label2_GC.anchor = GridBagConstraints.WEST;
		gbc_label2_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label2_GC.gridx = 7;
		gbc_label2_GC.gridy = 2;
		getContentPane().add(label2_GC, gbc_label2_GC);

		JLabel label3_GC = new JLabel("is_God_Class");
		label3_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label3_GC.setFont(new Font("Arial", Font.BOLD, 14));
		GridBagConstraints gbc_label3_GC = new GridBagConstraints();
		gbc_label3_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_label3_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label3_GC.gridx = 8;
		gbc_label3_GC.gridy = 2;
		getContentPane().add(label3_GC, gbc_label3_GC);

		JLabel label4_GC = new JLabel("IS");
		label4_GC.setHorizontalAlignment(SwingConstants.CENTER);
		label4_GC.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_label4_GC = new GridBagConstraints();
		gbc_label4_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_label4_GC.insets = new Insets(0, 0, 5, 5);
		gbc_label4_GC.gridx = 9;
		gbc_label4_GC.gridy = 2;
		getContentPane().add(label4_GC, gbc_label4_GC);

		isTrueFalse_GC = new JComboBox(new String[] { "TRUE", "FALSE" });
		isTrueFalse_GC.setForeground(Color.BLACK);
		isTrueFalse_GC.setBackground(Color.WHITE);
		GridBagConstraints gbc_isTrueFalse_GC = new GridBagConstraints();
		gbc_isTrueFalse_GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_isTrueFalse_GC.insets = new Insets(0, 0, 5, 5);
		gbc_isTrueFalse_GC.gridx = 10;
		gbc_isTrueFalse_GC.gridy = 2;
		getContentPane().add(isTrueFalse_GC, gbc_isTrueFalse_GC);

		ConfirmarRegraGC = new JButton("Confirm");
		ConfirmarRegraGC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoConfirmGC();
			}
		});
		GridBagConstraints gbc_SaveButton_GC = new GridBagConstraints();
		gbc_SaveButton_GC.insets = new Insets(0, 0, 5, 5);
		gbc_SaveButton_GC.gridx = 11;
		gbc_SaveButton_GC.gridy = 2;
		getContentPane().add(ConfirmarRegraGC, gbc_SaveButton_GC);

		// GC Second 1
		ListaMetricasC2GC = new JComboBox(new String[] { "NOM_class", "LOC_class", "WMC_class" });
		ListaMetricasC2GC.setForeground(Color.BLACK);
		ListaMetricasC2GC.setBackground(Color.WHITE);
		ListaMetricasC2GC.setVisible(false);

		BotaoCriarRegraGC = new JButton("Create Rule");
		BotaoCriarRegraGC.setEnabled(false);
		BotaoCriarRegraGC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criarRegraGC();
			}
		});
		GridBagConstraints gbc_CreateButton_GC = new GridBagConstraints();
		gbc_CreateButton_GC.insets = new Insets(0, 0, 5, 0);
		gbc_CreateButton_GC.gridx = 12;
		gbc_CreateButton_GC.gridy = 2;
		getContentPane().add(BotaoCriarRegraGC, gbc_CreateButton_GC);
		GridBagConstraints gbc_ListaMetricasC2GC = new GridBagConstraints();
		gbc_ListaMetricasC2GC.insets = new Insets(0, 0, 5, 5);
		gbc_ListaMetricasC2GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaMetricasC2GC.gridx = 1;
		gbc_ListaMetricasC2GC.gridy = 3;
		getContentPane().add(ListaMetricasC2GC, gbc_ListaMetricasC2GC);

		// GC Second 2
		ListaOpcoesC2GC = new JComboBox(new String[] { "IS BETWEEN", "=", ">", "<", ">=", "<=" });
		ListaOpcoesC2GC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ListaOpcoesC2GC.getSelectedItem().equals("IS BETWEEN")) {
					LabelANDC2GC.setVisible(true);
					GCC2valorM2.setVisible(true);
				} else {
					LabelANDC2GC.setVisible(false);
					GCC2valorM2.setVisible(false);
				}
			}
		});
		ListaOpcoesC2GC.setForeground(Color.BLACK);
		ListaOpcoesC2GC.setBackground(Color.WHITE);
		ListaOpcoesC2GC.setVisible(false);
		GridBagConstraints gbc_ListaOpcoesC2GC = new GridBagConstraints();
		gbc_ListaOpcoesC2GC.insets = new Insets(0, 0, 5, 5);
		gbc_ListaOpcoesC2GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaOpcoesC2GC.gridx = 2;
		gbc_ListaOpcoesC2GC.gridy = 3;
		getContentPane().add(ListaOpcoesC2GC, gbc_ListaOpcoesC2GC);

		GCC2valorM1 = new JTextField();
		GCC2valorM1.setColumns(10);
		GCC2valorM1.setVisible(false);
		GridBagConstraints gbc_GCC2valorM1 = new GridBagConstraints();
		gbc_GCC2valorM1.insets = new Insets(0, 0, 5, 5);
		gbc_GCC2valorM1.fill = GridBagConstraints.HORIZONTAL;
		gbc_GCC2valorM1.gridx = 3;
		gbc_GCC2valorM1.gridy = 3;
		getContentPane().add(GCC2valorM1, gbc_GCC2valorM1);
		GCC2valorM1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		LabelANDC2GC = new JLabel("AND");
		LabelANDC2GC.setHorizontalAlignment(SwingConstants.CENTER);
		LabelANDC2GC.setFont(new Font("Arial", Font.PLAIN, 12));
		LabelANDC2GC.setVisible(false);
		GridBagConstraints gbc_LabelANDC2GC = new GridBagConstraints();
		gbc_LabelANDC2GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_LabelANDC2GC.insets = new Insets(0, 0, 5, 5);
		gbc_LabelANDC2GC.gridx = 4;
		gbc_LabelANDC2GC.gridy = 3;
		getContentPane().add(LabelANDC2GC, gbc_LabelANDC2GC);

		GCC2valorM2 = new JTextField();
		GCC2valorM2.setColumns(10);
		GCC2valorM2.setVisible(false);
		GridBagConstraints gbc_GCC2valorM2 = new GridBagConstraints();
		gbc_GCC2valorM2.insets = new Insets(0, 0, 5, 5);
		gbc_GCC2valorM2.fill = GridBagConstraints.HORIZONTAL;
		gbc_GCC2valorM2.gridx = 5;
		gbc_GCC2valorM2.gridy = 3;
		getContentPane().add(GCC2valorM2, gbc_GCC2valorM2);
		GCC2valorM2.addKeyListener(new KeyAdapter() {
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
					ListaMetricasC3GC.setVisible(false);
					ListaOpcoesC3GC.setVisible(false);
					GCC3valorM1.setVisible(false);
					LabelANDC3GC.setVisible(false);
					GCC3valorM2.setVisible(false);
					GCC3valorM1.setText("");
					GCC3valorM2.setText("");
				} else {

					ListaMetricasC3GC.setVisible(true);
					ListaOpcoesC3GC.setVisible(true);
					GCC3valorM1.setVisible(true);
					LabelANDC3GC.setVisible(true);
					GCC3valorM2.setVisible(true);
					ListaOpcoesC3GC.setSelectedItem("IS BETWEEN");
				}
			}
		});
		second_GC_And_Or.setForeground(Color.BLACK);
		second_GC_And_Or.setBackground(Color.WHITE);
		second_GC_And_Or.setVisible(false);
		GridBagConstraints gbc_second_GC_And_Or = new GridBagConstraints();
		gbc_second_GC_And_Or.insets = new Insets(0, 0, 5, 5);
		gbc_second_GC_And_Or.fill = GridBagConstraints.HORIZONTAL;
		gbc_second_GC_And_Or.gridx = 6;
		gbc_second_GC_And_Or.gridy = 3;
		getContentPane().add(second_GC_And_Or, gbc_second_GC_And_Or);

		ListaMetricasC3GC = new JComboBox(new String[] { "NOM_class", "LOC_class", "WMC_class" });
		ListaMetricasC3GC.setBackground(Color.WHITE);
		ListaMetricasC3GC.setForeground(Color.BLACK);
		ListaMetricasC3GC.setVisible(false);

		labelNome_GC = new JLabel("Nome :");
		GridBagConstraints gbc_labelNome2 = new GridBagConstraints();
		gbc_labelNome2.anchor = GridBagConstraints.EAST;
		gbc_labelNome2.insets = new Insets(0, 0, 5, 5);
		gbc_labelNome2.gridx = 10;
		gbc_labelNome2.gridy = 3;
		getContentPane().add(labelNome_GC, gbc_labelNome2);

		NomeRegraGC = new JTextField();
		NomeRegraGC.setEnabled(false);
		NomeRegraGC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.getKeyCode()!=8 && !(NomeRegraGC.getText()+e.getKeyChar()).equals("") || (NomeRegraGC.getText()).length()>=2) && e.getKeyCode() != 32) {
					BotaoCriarRegraGC.setEnabled(true);
				} else {
					BotaoCriarRegraGC.setEnabled(false);
				}
			}
		});
		NomeRegraGC.setColumns(10);
		GridBagConstraints gbc_textFieldNome2 = new GridBagConstraints();
		gbc_textFieldNome2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNome2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNome2.gridx = 11;
		gbc_textFieldNome2.gridy = 3;
		getContentPane().add(NomeRegraGC, gbc_textFieldNome2);

		ListaRegrasGCAlterar = new JComboBox();
		GridBagConstraints gbc_ListaRegrasGCAlterar = new GridBagConstraints();
		gbc_ListaRegrasGCAlterar.insets = new Insets(0, 0, 5, 0);
		gbc_ListaRegrasGCAlterar.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaRegrasGCAlterar.gridx = 12;
		gbc_ListaRegrasGCAlterar.gridy = 3;
		ListaRegrasGCAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				regraGCAlterar = (String) ListaRegrasGCAlterar.getSelectedItem();

				if (regraGCAlterar==null || regraGCAlterar.equals(""))
					resetCamposGC();
				else
					alterarRegraGC();
			}
		});
		getContentPane().add(ListaRegrasGCAlterar, gbc_ListaRegrasGCAlterar);

		GridBagConstraints gbc_ListaMetricasC3GC = new GridBagConstraints();
		gbc_ListaMetricasC3GC.insets = new Insets(0, 0, 5, 5);
		gbc_ListaMetricasC3GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaMetricasC3GC.gridx = 1;
		gbc_ListaMetricasC3GC.gridy = 4;
		getContentPane().add(ListaMetricasC3GC, gbc_ListaMetricasC3GC);

		ListaOpcoesC3GC = new JComboBox(new String[] { "IS BETWEEN", "=", ">", "<", ">=", "<=" });
		ListaOpcoesC3GC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ListaOpcoesC3GC.getSelectedItem().equals("IS BETWEEN")) {
					LabelANDC3GC.setVisible(true);
					GCC3valorM2.setVisible(true);
				} else {
					LabelANDC3GC.setVisible(false);
					GCC3valorM2.setVisible(false);
				}
			}
		});
		ListaOpcoesC3GC.setForeground(Color.BLACK);
		ListaOpcoesC3GC.setBackground(Color.WHITE);
		ListaOpcoesC3GC.setVisible(false);
		GridBagConstraints gbc_ListaOpcoesC3GC = new GridBagConstraints();
		gbc_ListaOpcoesC3GC.insets = new Insets(0, 0, 5, 5);
		gbc_ListaOpcoesC3GC.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaOpcoesC3GC.gridx = 2;
		gbc_ListaOpcoesC3GC.gridy = 4;
		getContentPane().add(ListaOpcoesC3GC, gbc_ListaOpcoesC3GC);

		GCC3valorM1 = new JTextField();
		GCC3valorM1.setVisible(false);
		GridBagConstraints gbc_GCC3valorM1 = new GridBagConstraints();
		gbc_GCC3valorM1.insets = new Insets(0, 0, 5, 5);
		gbc_GCC3valorM1.fill = GridBagConstraints.HORIZONTAL;
		gbc_GCC3valorM1.gridx = 3;
		gbc_GCC3valorM1.gridy = 4;
		getContentPane().add(GCC3valorM1, gbc_GCC3valorM1);
		GCC3valorM1.setColumns(10);
		GCC3valorM1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		LabelANDC3GC = new JLabel("AND");
		LabelANDC3GC.setFont(new Font("Arial", Font.PLAIN, 12));
		LabelANDC3GC.setVisible(false);
		GridBagConstraints gbc_LabelANDC3GC = new GridBagConstraints();
		gbc_LabelANDC3GC.insets = new Insets(0, 0, 5, 5);
		gbc_LabelANDC3GC.gridx = 4;
		gbc_LabelANDC3GC.gridy = 4;
		getContentPane().add(LabelANDC3GC, gbc_LabelANDC3GC);

		GCC3valorM2 = new JTextField();
		GCC3valorM2.setVisible(false);
		GridBagConstraints gbc_GCC3valorM2 = new GridBagConstraints();
		gbc_GCC3valorM2.insets = new Insets(0, 0, 5, 5);
		gbc_GCC3valorM2.fill = GridBagConstraints.HORIZONTAL;
		gbc_GCC3valorM2.gridx = 5;
		gbc_GCC3valorM2.gridy = 4;
		getContentPane().add(GCC3valorM2, gbc_GCC3valorM2);
		GCC3valorM2.setColumns(10);

		LabelDiretorio = new JLabel("Diretório");
		GridBagConstraints gbc_LabelDiretorio = new GridBagConstraints();
		gbc_LabelDiretorio.insets = new Insets(0, 0, 5, 5);
		gbc_LabelDiretorio.gridx = 1;
		gbc_LabelDiretorio.gridy = 5;
		getContentPane().add(LabelDiretorio, gbc_LabelDiretorio);
		GCC3valorM2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
			}
		});

		JButton BotaoEscolherDiretorio = new JButton("Escolher diretório");
		BotaoEscolherDiretorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoEscolherDiretorio();
			}
		});
		GridBagConstraints gbc_BotaoEscolherDiretorio = new GridBagConstraints();
		gbc_BotaoEscolherDiretorio.insets = new Insets(0, 0, 5, 5);
		gbc_BotaoEscolherDiretorio.gridx = 3;
		gbc_BotaoEscolherDiretorio.gridy = 5;
		getContentPane().add(BotaoEscolherDiretorio, gbc_BotaoEscolherDiretorio);

		JButton BotaoCriarExcel = new JButton("Criar Excel");
		BotaoCriarExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoCriarExcel();
			}
		});

		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 5;
		gbc_btnNewButton_3.gridy = 5;
		getContentPane().add(BotaoCriarExcel, gbc_btnNewButton_3);

		JLabel LabelDiretorio_1 = new JLabel("Número de Packages:");
		GridBagConstraints gbc_LabelDiretorio_1 = new GridBagConstraints();
		gbc_LabelDiretorio_1.insets = new Insets(0, 0, 5, 5);
		gbc_LabelDiretorio_1.gridx = 1;
		gbc_LabelDiretorio_1.gridy = 6;
		getContentPane().add(LabelDiretorio_1, gbc_LabelDiretorio_1);
		
		LabelCountPackages = new JLabel("0");
		GridBagConstraints gbc_LabelCountPackages = new GridBagConstraints();
		gbc_LabelCountPackages.insets = new Insets(0, 0, 5, 5);
		gbc_LabelCountPackages.gridx = 2;
		gbc_LabelCountPackages.gridy = 6;
		getContentPane().add(LabelCountPackages, gbc_LabelCountPackages);

		ListaRegrasLMAplicar = new JComboBox();
		GridBagConstraints gbc_ListaRegrasLMAplicar = new GridBagConstraints();
		gbc_ListaRegrasLMAplicar.insets = new Insets(0, 0, 5, 5);
		gbc_ListaRegrasLMAplicar.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaRegrasLMAplicar.gridx = 8;
		gbc_ListaRegrasLMAplicar.gridy = 6;
		getContentPane().add(ListaRegrasLMAplicar, gbc_ListaRegrasLMAplicar);
		
		LabelTextoVP = new JLabel("Verdadeiros positivos");
		GridBagConstraints gbc_LabelTextoVP = new GridBagConstraints();
		gbc_LabelTextoVP.insets = new Insets(0, 0, 5, 5);
		gbc_LabelTextoVP.gridx = 11;
		gbc_LabelTextoVP.gridy = 6;
		getContentPane().add(LabelTextoVP, gbc_LabelTextoVP);
		
		LabelCountVP = new JLabel("0");
		GridBagConstraints gbc_LabelCountVP = new GridBagConstraints();
		gbc_LabelCountVP.insets = new Insets(0, 0, 5, 0);
		gbc_LabelCountVP.gridx = 12;
		gbc_LabelCountVP.gridy = 6;
		getContentPane().add(LabelCountVP, gbc_LabelCountVP);

		JLabel LabelDiretorio_3 = new JLabel("Número de classes:");
		GridBagConstraints gbc_LabelDiretorio_3 = new GridBagConstraints();
		gbc_LabelDiretorio_3.insets = new Insets(0, 0, 5, 5);
		gbc_LabelDiretorio_3.gridx = 1;
		gbc_LabelDiretorio_3.gridy = 7;
		getContentPane().add(LabelDiretorio_3, gbc_LabelDiretorio_3);

		LabelCountClasses = new JLabel("0");
		GridBagConstraints gbc_LabelCountClasses = new GridBagConstraints();
		gbc_LabelCountClasses.insets = new Insets(0, 0, 5, 5);
		gbc_LabelCountClasses.gridx = 2;
		gbc_LabelCountClasses.gridy = 7;
		getContentPane().add(LabelCountClasses, gbc_LabelCountClasses);

		ListaRegrasGCAplicar = new JComboBox();
		GridBagConstraints gbc_ListaRegrasGCAplicar = new GridBagConstraints();
		gbc_ListaRegrasGCAplicar.insets = new Insets(0, 0, 5, 5);
		gbc_ListaRegrasGCAplicar.fill = GridBagConstraints.HORIZONTAL;
		gbc_ListaRegrasGCAplicar.gridx = 8;
		gbc_ListaRegrasGCAplicar.gridy = 7;
		getContentPane().add(ListaRegrasGCAplicar, gbc_ListaRegrasGCAplicar);
		
		LabelTextoFP = new JLabel("Falsos positivos");
		GridBagConstraints gbc_LabelTextoFP = new GridBagConstraints();
		gbc_LabelTextoFP.insets = new Insets(0, 0, 5, 5);
		gbc_LabelTextoFP.gridx = 11;
		gbc_LabelTextoFP.gridy = 7;
		getContentPane().add(LabelTextoFP, gbc_LabelTextoFP);
		
		LabelCountFP = new JLabel("0");
		GridBagConstraints gbc_LabelCountFP = new GridBagConstraints();
		gbc_LabelCountFP.insets = new Insets(0, 0, 5, 0);
		gbc_LabelCountFP.gridx = 12;
		gbc_LabelCountFP.gridy = 7;
		getContentPane().add(LabelCountFP, gbc_LabelCountFP);

		LabelCountMetodos = new JLabel("0");
		GridBagConstraints gbc_LabelDiretorio_6 = new GridBagConstraints();
		gbc_LabelDiretorio_6.insets = new Insets(0, 0, 5, 5);
		gbc_LabelDiretorio_6.gridx = 2;
		gbc_LabelDiretorio_6.gridy = 8;
		getContentPane().add(LabelCountMetodos, gbc_LabelDiretorio_6);

		JLabel LabelDiretorio_5 = new JLabel("Número de métodos:");
		GridBagConstraints gbc_LabelDiretorio_5 = new GridBagConstraints();
		gbc_LabelDiretorio_5.insets = new Insets(0, 0, 5, 5);
		gbc_LabelDiretorio_5.gridx = 1;
		gbc_LabelDiretorio_5.gridy = 8;
		getContentPane().add(LabelDiretorio_5, gbc_LabelDiretorio_5);

		BotaoAplicarRegras = new JButton("Aplicar Regras");
		BotaoAplicarRegras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acaoAplicarRegras();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 8;
		gbc_btnNewButton.gridy = 8;
		getContentPane().add(BotaoAplicarRegras, gbc_btnNewButton);
		
		LabelTextVN = new JLabel("Verdadeiros negativos");
		GridBagConstraints gbc_LabelTextVN = new GridBagConstraints();
		gbc_LabelTextVN.insets = new Insets(0, 0, 5, 5);
		gbc_LabelTextVN.gridx = 11;
		gbc_LabelTextVN.gridy = 8;
		getContentPane().add(LabelTextVN, gbc_LabelTextVN);
		
		LabelCountVN = new JLabel("0");
		GridBagConstraints gbc_LabelCountVN = new GridBagConstraints();
		gbc_LabelCountVN.insets = new Insets(0, 0, 5, 0);
		gbc_LabelCountVN.gridx = 12;
		gbc_LabelCountVN.gridy = 8;
		getContentPane().add(LabelCountVN, gbc_LabelCountVN);

		LabelCountLinhasCodigo = new JLabel("0");
		GridBagConstraints gbc_LabelDiretorio_8 = new GridBagConstraints();
		gbc_LabelDiretorio_8.insets = new Insets(0, 0, 5, 5);
		gbc_LabelDiretorio_8.gridx = 2;
		gbc_LabelDiretorio_8.gridy = 9;
		getContentPane().add(LabelCountLinhasCodigo, gbc_LabelDiretorio_8);

		JLabel LabelDiretorio_7 = new JLabel("Número de linhas de código:");
		GridBagConstraints gbc_LabelDiretorio_7 = new GridBagConstraints();
		gbc_LabelDiretorio_7.insets = new Insets(0, 0, 5, 5);
		gbc_LabelDiretorio_7.gridx = 1;
		gbc_LabelDiretorio_7.gridy = 9;
		getContentPane().add(LabelDiretorio_7, gbc_LabelDiretorio_7);
		
		LabelTextoFN = new JLabel("Falsos negativos");
		GridBagConstraints gbc_LabelTextoFN = new GridBagConstraints();
		gbc_LabelTextoFN.insets = new Insets(0, 0, 5, 5);
		gbc_LabelTextoFN.gridx = 11;
		gbc_LabelTextoFN.gridy = 9;
		getContentPane().add(LabelTextoFN, gbc_LabelTextoFN);
		
		LabelCountFN = new JLabel("0");
		GridBagConstraints gbc_LabelCountFN = new GridBagConstraints();
		gbc_LabelCountFN.insets = new Insets(0, 0, 5, 0);
		gbc_LabelCountFN.gridx = 12;
		gbc_LabelCountFN.gridy = 9;
		getContentPane().add(LabelCountFN, gbc_LabelCountFN);

		carregarRegras();
	}

	private void criarRegraLM() {
		if (regraLMAlterar!= null && !regraLMAlterar.equals(""))
			this.regrasLongMethod.remove(regraLMAlterar);
		else {
			for (String s : regrasLongMethod.keySet())
				if (s.equals(NomeRegraLM.getText()))
					return;
		}
		String expressao = criarExpressaoLM();
		boolean valorRegra = retirarValorBooleanRegra(this.isTrueFalse_LM);
		Regra regra = new Regra(this.NomeRegraLM.getText(), expressao, valorRegra, 0);
		this.regrasLongMethod.put(regra.getNome(), regra);
		resetCamposLM();
		ListaRegrasLMAlterar.removeAllItems();
		ListaRegrasLMAplicar.removeAllItems();
		ListaRegrasLMAlterar.addItem("");
		ListaRegrasLMAplicar.addItem("");

		for (HashMap.Entry<String, Regra> entry : regrasLongMethod.entrySet()) {
			String key = entry.getKey();
			ListaRegrasLMAlterar.addItem(key);
			ListaRegrasLMAplicar.addItem(key);
		}
	}

	private String criarExpressaoLM() {
		String expressao = "";
		String condicao1 = criarCondicao(this.ListaMetricasC1LM, this.ListaOpcoesC1LM, this.LMC1valorM1,
				this.LMC1valorM2);
		if (!this.LM_And_Or.getSelectedItem().equals("")) {
			String condicao2 = criarCondicao(this.ListaMetricasC2LM, this.ListaOpcoesC2LM, this.LMC2valorM1,
					this.LMC2valorM2);

			if (this.LM_And_Or.getSelectedItem().equals("AND"))
				expressao = condicao1 + " && " + condicao2;
			else
				expressao = condicao1 + " || " + condicao2;

		} else {
			expressao = condicao1;
		}
		return expressao;
	}
	
	private boolean retirarValorBooleanRegra(JComboBox valorRegra) {
		if (valorRegra.getSelectedItem().equals("TRUE"))
			return true;
		else
			return false;
	}

	private void criarRegraGC() {
		if (regraGCAlterar!=null && !regraGCAlterar.equals(""))
			this.regrasGodClass.remove(regraGCAlterar);
		else {
			for (String s : regrasGodClass.keySet())
				if (s.equals(NomeRegraGC.getText()))
					return;
		}
		String expressao = criarExpressaoGC();
		boolean valorRegra = retirarValorBooleanRegra(this.isTrueFalse_GC);
		Regra regra = new Regra(this.NomeRegraGC.getText(), expressao, valorRegra, 1);
		this.regrasGodClass.put(regra.getNome(), regra);
		resetCamposGC();
		ListaRegrasGCAlterar.removeAllItems();
		ListaRegrasGCAplicar.removeAllItems();
		ListaRegrasGCAlterar.addItem("");
		ListaRegrasGCAplicar.addItem("");

		for (HashMap.Entry<String, Regra> entry : regrasGodClass.entrySet()) {
			String key = entry.getKey();
			ListaRegrasGCAlterar.addItem(key);
			ListaRegrasGCAplicar.addItem(key);
		}
	}

	private String criarExpressaoGC() {
		String expressao = "";
		String condicao1 = criarCondicao(this.ListaMetricasC1GC, this.ListaOpcoesC1GC, this.GCC1valorM1,
				this.GCC1valorM2);
		if (!this.GC_And_Or.getSelectedItem().equals("")) {
			String condicao2 = criarCondicao(this.ListaMetricasC2GC, this.ListaOpcoesC2GC, this.GCC2valorM1,
					this.GCC2valorM2);

			if (!this.second_GC_And_Or.getSelectedItem().equals("")) {
				String condicao3 = criarCondicao(this.ListaMetricasC3GC, this.ListaOpcoesC3GC, this.GCC3valorM1,
						this.GCC3valorM2);
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
		return expressao;
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
		NomeRegraLM.setText("");
		ConfirmarRegraLM.setEnabled(true);
		BotaoCriarRegraLM.setEnabled(false);
		NomeRegraLM.setEnabled(false);
		ListaMetricasC1LM.setSelectedItem("LOC_method");
		ListaOpcoesC1LM.setSelectedItem("LOC_method");
		ListaOpcoesC1LM.setSelectedItem("IS BETWEEN");
		ListaOpcoesC2LM.setSelectedItem("IS BETWEEN");
		isTrueFalse_LM.setSelectedItem("TRUE");
		LM_And_Or.setSelectedItem("");
		LMC1valorM1.setText("");
		LMC1valorM2.setText("");
		LMC2valorM1.setText("");
		LMC2valorM2.setText("");
		BotaoCriarRegraLM.setText("Create Rule");
		makeEnableLM(true);
	}

	private void resetCamposGC() {
		NomeRegraGC.setText("");
		ConfirmarRegraGC.setEnabled(true);
		BotaoCriarRegraGC.setEnabled(false);
		NomeRegraGC.setEnabled(false);
		ListaOpcoesC1GC.setSelectedItem("IS BETWEEN");
		ListaOpcoesC2GC.setSelectedItem("IS BETWEEN");
		ListaOpcoesC3GC.setSelectedItem("IS BETWEEN");
		GC_And_Or.setSelectedItem("");
		second_GC_And_Or.setSelectedItem("");
		isTrueFalse_GC.setSelectedItem("TRUE");
		GCC1valorM1.setText("");
		GCC1valorM2.setText("");
		GCC2valorM1.setText("");
		GCC2valorM2.setText("");
		GCC3valorM1.setText("");
		GCC3valorM2.setText("");
		BotaoCriarRegraGC.setText("Create Rule");
		makeEnableGC(true);
	}

	private void carregarRegras() {
		ListaRegrasLMAlterar.addItem("");
		ListaRegrasGCAlterar.addItem("");
		ListaRegrasLMAplicar.addItem("");
		ListaRegrasGCAplicar.addItem("");
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
						ListaRegrasLMAlterar.addItem(nome);
						ListaRegrasLMAplicar.addItem(nome);
					}
					else {
						regrasGodClass.put(nome, regra);
						ListaRegrasGCAlterar.addItem(nome);
						ListaRegrasGCAplicar.addItem(nome);
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
			guardarRegrasLista(myWriter,regrasLongMethod);
			guardarRegrasLista(myWriter,regrasGodClass);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void guardarRegrasLista(FileWriter myWriter, HashMap<String,Regra> listaRegras) throws IOException {
		for(Regra r : listaRegras.values()) {
			escreverRegra(myWriter, r);
		}
	}

	private void escreverRegra(FileWriter myWriter, Regra r) throws IOException {
		myWriter.write(r.getNome() + "\n");
		myWriter.write(r.getExpressao() + "\n");
		myWriter.write(r.getValorCodeSmell()+ " " + r.getTipoCodeSmell() + "\n");
	}

	private void makeVisibleLM() {
		ConfirmarRegraLM.setEnabled(false);
		NomeRegraLM.setEnabled(true);
		if(!NomeRegraLM.getText().equals(""))
			BotaoCriarRegraLM.setEnabled(true);
	}

	private void makeVisibleGC() {
		ConfirmarRegraGC.setEnabled(false);
		NomeRegraGC.setEnabled(true);
		if(!NomeRegraGC.getText().equals(""))
			BotaoCriarRegraGC.setEnabled(true);
	}

	private void makeEnableLM(boolean b) {
		ListaMetricasC1LM.setEnabled(b);
		ListaOpcoesC1LM.setEnabled(b);
		ListaMetricasC2LM.setEnabled(b);
		ListaOpcoesC2LM.setEnabled(b);
		LMC1valorM1.setEnabled(b);
		LMC1valorM2.setEnabled(b);
		LMC2valorM1.setEnabled(b);
		LMC2valorM2.setEnabled(b);
		LM_And_Or.setEnabled(b);
		isTrueFalse_LM.setEnabled(b);
	}

	private void makeEnableGC(boolean b) {
		ListaMetricasC1GC.setEnabled(b);
		ListaOpcoesC1GC.setEnabled(b);
		ListaMetricasC2GC.setEnabled(b);
		ListaOpcoesC2GC.setEnabled(b);
		ListaMetricasC3GC.setEnabled(b);
		ListaOpcoesC3GC.setEnabled(b);
		GCC1valorM1.setEnabled(b);
		GCC1valorM2.setEnabled(b);
		GCC2valorM1.setEnabled(b);
		GCC2valorM2.setEnabled(b);
		GCC3valorM1.setEnabled(b);
		GCC3valorM2.setEnabled(b);
		GC_And_Or.setEnabled(b);
		second_GC_And_Or.setEnabled(b);
		isTrueFalse_GC.setEnabled(b);
	}

	private void alterarRegraLM() {
		BotaoCriarRegraLM.setText("Change Rule");
		for (HashMap.Entry<String, Regra> entry : regrasLongMethod.entrySet()) {
			String key = entry.getKey();
			Regra regra = entry.getValue();

			if (key == regraLMAlterar) {
				NomeRegraLM.setText(regra.getNome());
				colocarValorBooleanRegra(regra,isTrueFalse_LM);
				String[] expressao = regra.getExpressao().split(" ");
				ListaMetricasC1LM.setSelectedItem(expressao[1]);
				LMC1valorM1.setText(expressao[3]);
				if (expressao[4].equals("&&")) {
					ListaOpcoesC1LM.setSelectedItem("IS BETWEEN");
					LMC1valorM2.setText(expressao[7]);
					if (expressao.length > 9) {
						if (expressao[9].equals("&&"))
							LM_And_Or.setSelectedItem("AND");
						else
							LM_And_Or.setSelectedItem("OR");
						ListaMetricasC2LM.setSelectedItem(expressao[11]);
						LMC2valorM1.setText(expressao[13]);
						if (expressao[14].equals("&&")) {
							ListaOpcoesC2LM.setSelectedItem("IS BETWEEN");
							LMC2valorM2.setText(expressao[17]);
						} else {
							ListaOpcoesC2LM.setSelectedItem(expressao[12]);
						}
					}
				} else {
					ListaOpcoesC1LM.setSelectedItem(expressao[2]);
					if (expressao.length > 5) {
						if (expressao[5].equals("&&")) {
							LM_And_Or.setSelectedItem("AND");
						} else {
							LM_And_Or.setSelectedItem("OR");
						}
						ListaMetricasC2LM.setSelectedItem(expressao[7]);
						LMC2valorM1.setText(expressao[9]);
						if (expressao[10].equals("&&")) {
							ListaOpcoesC2LM.setSelectedItem("IS BETWEEN");
							LMC2valorM2.setText(expressao[13]);
						} else {
							ListaOpcoesC2LM.setSelectedItem(expressao[8]);
						}
					}
				}
			}
		}
	}
	
	private void colocarValorBooleanRegra(Regra regra, JComboBox isTrueFalse) {
		if (regra.getValorCodeSmell()) {
			isTrueFalse.setSelectedItem("TRUE");
		} else {
			isTrueFalse.setSelectedItem("FALSE");
		}
	}

	private void alterarRegraGC() {
		BotaoCriarRegraGC.setText("Change Rule");
		for (HashMap.Entry<String, Regra> entry : regrasGodClass.entrySet()) {
			String key = entry.getKey();
			Regra regra = entry.getValue();

			if (key == regraGCAlterar) {
				NomeRegraGC.setText(regra.getNome());
				colocarValorBooleanRegra(regra,isTrueFalse_GC);
				String[] expressao = regra.getExpressao().split(" ");
				ListaMetricasC1GC.setSelectedItem(expressao[2]);
				GCC1valorM1.setText(expressao[4]);
				if (expressao[5].equals("&&")) {
					ListaOpcoesC1GC.setSelectedItem("IS BETWEEN");
					GCC1valorM2.setText(expressao[8]);
					if (expressao.length > 12) {
						if (expressao[10].equals("&&"))
							GC_And_Or.setSelectedItem("AND");
						else
							GC_And_Or.setSelectedItem("OR");
						ListaMetricasC2GC.setSelectedItem(expressao[12]);
						GCC2valorM1.setText(expressao[14]);
						if (expressao[15].equals("&&")) {
							ListaOpcoesC2GC.setSelectedItem("IS BETWEEN");
							GCC2valorM2.setText(expressao[18]);
							if (expressao.length > 22) {
								if (expressao[21].equals("&&"))
									second_GC_And_Or.setSelectedItem("AND");
								else
									second_GC_And_Or.setSelectedItem("OR");
								ListaMetricasC3GC.setSelectedItem(expressao[23]);
								GCC3valorM1.setText(expressao[25]);
								if (expressao[26].equals("&&")) {
									ListaOpcoesC3GC.setSelectedItem("IS BETWEEN");
									GCC3valorM2.setText(expressao[29]);
								} else {
									ListaOpcoesC3GC.setSelectedItem(expressao[24]);
								}

							}
						} else {
							ListaOpcoesC2GC.setSelectedItem(expressao[13]);
							if (expressao.length > 18) {
								if (expressao[17].equals("&&"))
									second_GC_And_Or.setSelectedItem("AND");
								else
									second_GC_And_Or.setSelectedItem("OR");
								ListaMetricasC3GC.setSelectedItem(expressao[19]);
								GCC3valorM1.setText(expressao[21]);
								if (expressao[22].equals("&&")) {
									ListaOpcoesC3GC.setSelectedItem("IS BETWEEN");
									GCC3valorM2.setText(expressao[25]);
								} else {
									ListaOpcoesC3GC.setSelectedItem(expressao[20]);
								}
							}
						}
					}
				} else {
					ListaOpcoesC1GC.setSelectedItem(expressao[3]);
					if (expressao.length > 8) {
						if (expressao[6].equals("&&")) {
							GC_And_Or.setSelectedItem("AND");
						} else {
							GC_And_Or.setSelectedItem("OR");
						}
						ListaMetricasC2GC.setSelectedItem(expressao[8]);
						GCC2valorM1.setText(expressao[10]);
						if (expressao[11].equals("&&")) {
							ListaOpcoesC2GC.setSelectedItem("IS BETWEEN");
							GCC2valorM2.setText(expressao[14]);
							if (expressao.length > 17) {
								if (expressao[17].equals("&&"))
									second_GC_And_Or.setSelectedItem("AND");
								else
									second_GC_And_Or.setSelectedItem("OR");
								ListaMetricasC3GC.setSelectedItem(expressao[19]);
								GCC3valorM1.setText(expressao[21]);
								if (expressao[22].equals("&&")) {
									ListaOpcoesC3GC.setSelectedItem("IS BETWEEN");
									GCC3valorM2.setText(expressao[25]);
								} else {
									ListaOpcoesC3GC.setSelectedItem(expressao[20]);
								}
							}
						} else {
							ListaOpcoesC2GC.setSelectedItem(expressao[9]);
							if (expressao.length > 13) {
								if (expressao[13].equals("&&"))
									second_GC_And_Or.setSelectedItem("AND");
								else
									second_GC_And_Or.setSelectedItem("OR");
								ListaMetricasC3GC.setSelectedItem(expressao[15]);
								GCC3valorM1.setText(expressao[17]);
								if (expressao[18].equals("&&")) {
									ListaOpcoesC3GC.setSelectedItem("IS BETWEEN");
									GCC3valorM2.setText(expressao[21]);
								} else {
									ListaOpcoesC3GC.setSelectedItem(expressao[16]);
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void acaoConfirmLM() {
		if ((ListaOpcoesC1LM.getSelectedItem().equals("IS BETWEEN")
				&& (Integer.parseInt(LMC1valorM1.getText()) < Integer.parseInt(LMC1valorM2.getText()))
				&& !LMC1valorM1.getText().equals("") && !LMC1valorM2.getText().equals(""))
				|| (!ListaOpcoesC1LM.getSelectedItem().equals("IS BETWEEN")
						&& !LMC1valorM1.getText().equals(""))) {
			if (LM_And_Or.getSelectedItem().equals("AND") || LM_And_Or.getSelectedItem().equals("OR")) {
				if ((ListaOpcoesC2LM.getSelectedItem().equals("IS BETWEEN")
						&& (Integer.parseInt(LMC2valorM1.getText()) < Integer
								.parseInt(LMC2valorM2.getText()))
						&& !LMC2valorM1.getText().equals("") && !LMC2valorM2.getText().equals(""))
						|| (!ListaOpcoesC2LM.getSelectedItem().equals("IS BETWEEN")
								&& !LMC2valorM1.getText().equals(""))) {
					makeVisibleLM();
					makeEnableLM(false);
				}
			} else {
				makeVisibleLM();
				makeEnableLM(false);
			}
		}
	}
	
	private void acaoConfirmGC() {
		if ((ListaOpcoesC1GC.getSelectedItem().equals("IS BETWEEN") && !GCC1valorM1.getText().equals("")
				&& !GCC1valorM2.getText().equals("")
				&& (Integer.parseInt(GCC1valorM1.getText()) < Integer.parseInt(GCC1valorM2.getText())))
				|| (!ListaOpcoesC1GC.getSelectedItem().equals("IS BETWEEN")
						&& !GCC1valorM1.getText().equals(""))) {
			if (GC_And_Or.getSelectedItem().equals("AND") || GC_And_Or.getSelectedItem().equals("OR")) {
				if ((ListaOpcoesC2GC.getSelectedItem().equals("IS BETWEEN")
						&& !GCC2valorM1.getText().equals("") && !GCC2valorM2.getText().equals("")
						&& (Integer.parseInt(GCC2valorM1.getText()) < Integer
								.parseInt(GCC2valorM2.getText())))
						|| (!ListaOpcoesC2GC.getSelectedItem().equals("IS BETWEEN")
								&& !GCC2valorM1.getText().equals(""))) {
					if (second_GC_And_Or.getSelectedItem().equals("AND")
							|| second_GC_And_Or.getSelectedItem().equals("OR")) {
						if ((ListaOpcoesC3GC.getSelectedItem().equals("IS BETWEEN")
								&& !GCC3valorM1.getText().equals("") && !GCC3valorM2.getText().equals("")
								&& (Integer.parseInt(GCC3valorM1.getText()) < Integer
										.parseInt(GCC3valorM2.getText())))
								|| (!ListaOpcoesC3GC.getSelectedItem().equals("IS BETWEEN")
										&& !GCC3valorM1.getText().equals(""))) {
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
	
	public void acaoCriarExcel() {
		percorrer();
		excel = new EscreverMétricasParaExcel(caminhoFicheiros);
		try {
			excel.escreverNoFicheiro();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		colocarEstatisticas();
		
		mostrarExcel();
	}

	private void colocarEstatisticas() {
		Set<String> packages = new HashSet<>(excel.getnomePackages());
		LabelCountPackages.setText(Integer.toString(packages.size()));
		LabelCountClasses.setText(Integer.toString(excel.getNumberClasses()));
		ArrayList<Integer> LOC_métodos = excel.getLOC_method_array();
		LabelCountMetodos.setText(Integer.toString(LOC_métodos.size()));
		int soma = 0;
		LabelCountLinhasCodigo.setText(Integer.toString(somarLinhasCodigo(LOC_métodos, soma)));
	}

	private int somarLinhasCodigo(ArrayList<Integer> LOC_métodos, int soma) {
		for (int aux : LOC_métodos)
			soma += aux;
		return soma;
	}

	private void mostrarExcel() {
		DefaultTableModel defaultValues = new DefaultTableModel(getValores(), new String[] {
				"MethodID","package","class", "method", "NOM_class", "LOC_class", "WMC_class", "is_God_Class", "LOC_method","CYCLO_method", "is_Long_Method"});

		scrollPaneExcel = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 11;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 10;
		getContentPane().add(scrollPaneExcel, gbc_scrollPane);

		tableExcel = new JTable(defaultValues);
		JTableHeader header = tableExcel.getTableHeader();
		header.setReorderingAllowed(false);
		header.setBackground(Color.LIGHT_GRAY);
		scrollPaneExcel.setViewportView(tableExcel);
	}
	
	private void acaoAplicarRegras() {
		if(excel!=null && ListaRegrasLMAplicar.getSelectedItem()!=null && ListaRegrasGCAplicar.getSelectedItem()!=null && !ListaRegrasLMAplicar.getSelectedItem().equals("") && !ListaRegrasGCAplicar.getSelectedItem().equals("")) {
			Regra regraLM = buscarRegraSelecionada(regrasLongMethod, ListaRegrasLMAplicar);
			Regra regraGC = buscarRegraSelecionada(regrasGodClass, ListaRegrasGCAplicar);
			try {
				verificarCS = new VerificacaoCodeSmells(excel.getProjeto_name(), regraLM, regraGC);
				colocarValoresPainelAcerto();
				
			} catch (EncryptedDocumentException | IOException | ScriptException e1) {
				e1.printStackTrace();
			}

			mostrarExcelComCodeSmells();
		}
	}

	private void colocarValoresPainelAcerto() {
		LabelCountVP.setText(Integer.toString(verificarCS.getVerdadeiros_positivos()));
		LabelCountFP.setText(Integer.toString(verificarCS.getFalsos_positivos()));
		LabelCountVN.setText(Integer.toString(verificarCS.getVerdadeiros_negativos()));
		LabelCountFN.setText(Integer.toString(verificarCS.getFalsos_negativos()));
	}
	
	private Regra buscarRegraSelecionada(HashMap<String,Regra> listaRegras, JComboBox NomesRegras) {
		for (HashMap.Entry<String, Regra> entry : listaRegras.entrySet()) {
			String key = entry.getKey();
			if(key.equals(NomesRegras.getSelectedItem()))
				return entry.getValue();
		}
		return null;
	}

	private void mostrarExcelComCodeSmells() {
		DefaultTableModel defaultValues = new DefaultTableModel(getValores(), new String[] {
				"MethodID","package","class", "method", "NOM_class", "LOC_class", "WMC_class", "is_God_Class", "LOC_method","CYCLO_method", "is_Long_Method"});

		tableExcel = new JTable(defaultValues);
		JTableHeader header = tableExcel.getTableHeader();
		header.setReorderingAllowed(false);
		header.setBackground(Color.LIGHT_GRAY);
		scrollPaneExcel.setViewportView(tableExcel);
	}
	
	private void acaoEscolherDiretorio() {
		JFileChooser diretorio = new JFileChooser();
		diretorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		int returnValue = diretorio.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			diretorioEscolhido = diretorio.getSelectedFile();
			LabelDiretorio.setText(diretorioEscolhido.getAbsolutePath());
			LabelCountClasses.setText("0");
			LabelCountPackages.setText("0");
			LabelCountMetodos.setText("0");
			LabelCountLinhasCodigo.setText("0");
			LabelCountVP.setText("0");
			LabelCountVN.setText("0");
			LabelCountFP.setText("0");
			LabelCountFN.setText("0");
		}
	}

	public void percorrer() {
		caminhoFicheiros = new ArrayList<String>();
		String[] aux = diretorioEscolhido.getAbsolutePath().replace("\\", "/").split("/");
		caminhoFicheiros.add(aux[aux.length - 1]);
		for (File f : diretorioEscolhido.listFiles()) {
			verificacaoPastaSRC(f);
		}
	}

	private void verificacaoPastaSRC(File f) {
		String s = f.getAbsolutePath().replace("\\", "/");
		String[] v = s.split("/");
		if (f.isDirectory() && v[v.length - 1].equals("src")) {
			percorrerDiretorio(f);
		}
	}

	private void percorrerDiretorio(File f) {
		for (File ficheiro : f.listFiles()) {
			String s = f.getAbsolutePath().replace("\\", "/");
			String[] v = s.split("/");
			verificacaoDiretorioOuFicheiro(ficheiro, v);
		}
	}

	private void verificacaoDiretorioOuFicheiro(File ficheiro, String[] v) {
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

	private void percorrerFicheiro(File f) {
		if (f.getAbsolutePath().endsWith(".java")) {
			caminhoFicheiros.add(f.getAbsolutePath());
		}
	}

	public ArrayList<String> getCaminhoFicheiros() {
		return caminhoFicheiros;
	}

	public File getdiretorioEscolhido() {
		return diretorioEscolhido;
	}

	public void setdiretorioEscolhido(File diretorioEscolhido) {
		this.diretorioEscolhido = diretorioEscolhido;
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