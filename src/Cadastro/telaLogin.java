package Cadastro;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class telaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordSenha;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaLogin frame = new telaLogin();
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
	public telaLogin() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaCadastro tc = new telaCadastro(); 
				tc.setVisible(true);
				}
		});
		btnCadastrar.setForeground(new Color(224, 255, 255));
		btnCadastrar.setBackground(new Color(0, 206, 209));
		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnCadastrar.setBounds(252, 193, 117, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnEntrar = new JButton("ENTRAR");
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = classeConexao.getConnection();
					String sql = "select * from dados_usuarios where email=? and senha=?";
					PreparedStatement stmt  = con.prepareStatement(sql);
				
					stmt.setString(1, txtEmail.getText());
					stmt.setString(2, new String(passwordSenha.getPassword()));
					ResultSet rs = stmt.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null,"Usuario " + txtEmail.getText() +" encontrado");
					}else {
						JOptionPane.showMessageDialog(null,"Usuario " + txtEmail.getText() +" nao existe ou a Senha está incorreta","LOGIN",JOptionPane.ERROR_MESSAGE);
					}
					stmt.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEntrar.setForeground(new Color(224, 255, 255));
		btnEntrar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnEntrar.setBackground(new Color(0, 206, 209));
		btnEntrar.setBounds(77, 193, 103, 23);
		contentPane.add(btnEntrar);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setForeground(new Color(0, 0, 0));
		passwordSenha.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		passwordSenha.setBackground(new Color(224, 255, 255));
		passwordSenha.setBounds(94, 127, 225, 26);
		contentPane.add(passwordSenha);
		
		JLabel labelSenha = new JLabel("SENHA:");
		labelSenha.setForeground(new Color(0, 206, 209));
		labelSenha.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelSenha.setBounds(24, 127, 56, 22);
		contentPane.add(labelSenha);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtEmail.setBackground(new Color(224, 255, 255));
		txtEmail.setBounds(94, 46, 305, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel labelEmail = new JLabel("EMAIL:");
		labelEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		labelEmail.setForeground(new Color(0, 206, 209));
		labelEmail.setBounds(24, 46, 56, 22);
		contentPane.add(labelEmail);
	}
}
