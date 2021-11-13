package Cadastro;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import java.awt.SystemColor;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class telaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtCPF;
	private JTextField txtEmail;
	private JPasswordField passwordSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaCadastro frame = new telaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public telaCadastro() {
		setTitle("CADASTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNome = new JLabel("NOME: ");
		labelNome.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelNome.setForeground(new Color(0, 206, 209));
		labelNome.setBounds(8, 19, 50, 22);
		contentPane.add(labelNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtNome.setBackground(new Color(224, 255, 255));
		txtNome.setBounds(60, 19, 225, 23);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel labelEndeco = new JLabel("ENDERE\u00C7O:");
		labelEndeco.setForeground(new Color(0, 206, 209));
		labelEndeco.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelEndeco.setBounds(8, 56, 80, 22);
		contentPane.add(labelEndeco);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtEndereco.setBackground(new Color(224, 255, 255));
		txtEndereco.setBounds(92, 56, 304, 23);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelCPF.setForeground(new Color(0, 206, 209));
		labelCPF.setBounds(10, 95, 39, 22);
		contentPane.add(labelCPF);
		
		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtCPF.setBackground(new Color(224, 255, 255));
		txtCPF.setBounds(46, 95, 129, 23);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel labelEmail = new JLabel("EMAIL:");
		labelEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelEmail.setForeground(new Color(0, 206, 209));
		labelEmail.setBounds(10, 138, 50, 22);
		contentPane.add(labelEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtEmail.setBackground(new Color(224, 255, 255));
		txtEmail.setBounds(67, 138, 249, 23);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel labelSenha = new JLabel("SENHA:");
		labelSenha.setForeground(new Color(0, 206, 209));
		labelSenha.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelSenha.setBounds(8, 181, 56, 23);
		contentPane.add(labelSenha);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBackground(new Color(224, 255, 255));
		passwordSenha.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		passwordSenha.setBounds(69, 181, 225, 23);
		contentPane.add(passwordSenha);
		
		JButton bntCadastrar = new JButton("CADASTRAR");
		bntCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = classeConexao.getConnection();
					String sql = "insert into dados_usuarios (nome_usuario,endereco, cpf, email, senha) values (?,?,?,?,?) ";
					PreparedStatement stmt  = con.prepareStatement(sql);
				
					stmt.setString(1, txtNome.getText());
					stmt.setString(2, txtEndereco.getText());
					stmt.setString(3, txtCPF.getText());
					stmt.setString(4, txtEmail.getText());
					stmt.setString(5, new String(passwordSenha.getPassword()));
					
					stmt.execute();
					
					stmt.close();
					con.close();
					
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		bntCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		bntCadastrar.setForeground(new Color(224, 255, 255));
		bntCadastrar.setBackground(new Color(0, 206, 209));
		bntCadastrar.setBounds(159, 218, 124, 23);
		contentPane.add(bntCadastrar);
	}

}
