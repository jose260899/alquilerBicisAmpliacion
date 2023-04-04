
//José Ayala y Mónica Alcañiz

package alquilerBici;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

public class AlquilerBici {

	private JFrame alquilerBici;
	private JTable tableUsuario;
	private JTable tableBici;
	private JTextField textFieldNombre;
	private JTextField textFieldCrearUsuario;
	private JTextField textFieldcrearBici;
	private JScrollPane scrollPaneUsuario;
	private JScrollPane scrollPaneBici;
	private JTextField textFieldIdActualizarUsuario;
	private JTextField textFieldNombreActualizarUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlquilerBici window = new AlquilerBici();
					window.alquilerBici.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AlquilerBici() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		alquilerBici = new JFrame();
		alquilerBici.setTitle("Alquilar Bici");
		alquilerBici.getContentPane().setBackground(new Color(255, 235, 205));
		alquilerBici.setBounds(100, 100, 976, 755);
		alquilerBici.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		alquilerBici.getContentPane().setLayout(null);

		JLabel lbltitulo = new JLabel("Byke on the go");
		lbltitulo.setForeground(new Color(153, 0, 51));
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Broadway", Font.ITALIC, 40));
		lbltitulo.setBounds(285, 0, 365, 46);
		alquilerBici.getContentPane().add(lbltitulo);

		tableUsuario = new JTable();
		tableUsuario.setBounds(10, 279, 226, -84);
		alquilerBici.getContentPane().add(tableUsuario);

		tableBici = new JTable();
		tableBici.setBounds(10, 435, 226, -84);
		alquilerBici.getContentPane().add(tableBici);

		JLabel lblcrearUsuario = new JLabel("Crear Usuario:");
		lblcrearUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblcrearUsuario.setBounds(10, 322, 153, 14);
		alquilerBici.getContentPane().add(lblcrearUsuario);

		JLabel lblnombreUsuario = new JLabel("Nombre");
		lblnombreUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblnombreUsuario.setBounds(50, 347, 81, 14);
		alquilerBici.getContentPane().add(lblnombreUsuario);

		JLabel lblidUsuarioCrear = new JLabel("idUsuario");
		lblidUsuarioCrear.setFont(new Font("Arial", Font.BOLD, 12));
		lblidUsuarioCrear.setBounds(50, 372, 115, 14);
		alquilerBici.getContentPane().add(lblidUsuarioCrear);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(141, 341, 86, 20);
		alquilerBici.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				Pattern pat = Pattern.compile("^[A-Za-zÑñÁáÉéÍíÓóÚúÜü ]{1,50}$");
				Matcher mat = pat.matcher(textFieldNombre.getText());
				if (!mat.matches()) {
					JOptionPane.showMessageDialog(null, "El nombre no tiene un formato correcto");
				}
			}

		});

		JLabel lblAlquilarBici = new JLabel("Alquilar bici:");
		lblAlquilarBici.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAlquilarBici.setBounds(704, 322, 181, 14);
		alquilerBici.getContentPane().add(lblAlquilarBici);

		JLabel lblidBici = new JLabel("idBici");
		lblidBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblidBici.setBounds(704, 347, 84, 14);
		alquilerBici.getContentPane().add(lblidBici);

		JLabel lbliduUsuarioAlquilar = new JLabel("idUsuario");
		lbliduUsuarioAlquilar.setFont(new Font("Arial", Font.BOLD, 12));
		lbliduUsuarioAlquilar.setBounds(704, 372, 88, 14);
		alquilerBici.getContentPane().add(lbliduUsuarioAlquilar);

		JComboBox comboBoxidBiciAlquilar = new JComboBox();
		comboBoxidBiciAlquilar.setBounds(795, 339, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidBiciAlquilar);

		JComboBox comboBoxidUsuarioAlquilar = new JComboBox();
		comboBoxidUsuarioAlquilar.setBounds(795, 364, 86, 22);
		alquilerBici.getContentPane().add(comboBoxidUsuarioAlquilar);

		JLabel lblDevolverBici = new JLabel("Devolver Bici");
		lblDevolverBici.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDevolverBici.setBounds(714, 433, 153, 14);
		alquilerBici.getContentPane().add(lblDevolverBici);

		JLabel lblidUsuarioDevolver = new JLabel("idUsuario");
		lblidUsuarioDevolver.setFont(new Font("Arial", Font.BOLD, 12));
		lblidUsuarioDevolver.setBounds(704, 463, 88, 14);
		alquilerBici.getContentPane().add(lblidUsuarioDevolver);

		JComboBox comboBoxIdUsuarioDevolver = new JComboBox();
		comboBoxIdUsuarioDevolver.setBounds(795, 458, 86, 22);
		alquilerBici.getContentPane().add(comboBoxIdUsuarioDevolver);

		scrollPaneUsuario = new JScrollPane(tableUsuario);
		scrollPaneUsuario.setForeground(new Color(153, 0, 51));
		scrollPaneUsuario.setBorder(new LineBorder(new Color(128, 0, 0), 3));
		scrollPaneUsuario.setBounds(157, 83, 281, 182);
		alquilerBici.getContentPane().add(scrollPaneUsuario);

		scrollPaneBici = new JScrollPane(tableBici);
		scrollPaneBici.setBorder(new LineBorder(new Color(153, 0, 0), 3));
		scrollPaneBici.setBounds(490, 83, 281, 182);
		alquilerBici.getContentPane().add(scrollPaneBici);

		JLabel lblIdbicicrear = new JLabel("idBiciCrear");
		lblIdbicicrear.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIdbicicrear.setBounds(379, 347, 81, 14);
		alquilerBici.getContentPane().add(lblIdbicicrear);

		textFieldcrearBici = new JTextField();
		textFieldcrearBici.setColumns(10);
		textFieldcrearBici.setBounds(483, 341, 86, 20);
		alquilerBici.getContentPane().add(textFieldcrearBici);

		JLabel lblborrarUsuario = new JLabel("Borrar usuario:");
		lblborrarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblborrarUsuario.setBounds(10, 432, 130, 15);
		alquilerBici.getContentPane().add(lblborrarUsuario);

		JComboBox comboBoxborrarUsuario = new JComboBox();
		comboBoxborrarUsuario.setBounds(170, 458, 86, 22);
		alquilerBici.getContentPane().add(comboBoxborrarUsuario);

		JLabel lblElegirBici = new JLabel("Elegir bici:");
		lblElegirBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblElegirBici.setBounds(379, 462, 106, 15);
		alquilerBici.getContentPane().add(lblElegirBici);

		JComboBox comboBoxborrarBici = new JComboBox();
		comboBoxborrarBici.setBounds(483, 458, 86, 22);
		alquilerBici.getContentPane().add(comboBoxborrarBici);

		JLabel lblElegirUsuario = new JLabel("Elegir Usuario");
		lblElegirUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblElegirUsuario.setBounds(50, 463, 113, 14);
		alquilerBici.getContentPane().add(lblElegirUsuario);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 16));
		lblUsuario.setBounds(257, 58, 81, 14);
		alquilerBici.getContentPane().add(lblUsuario);

		JLabel lblBici = new JLabel("BICICLETA");
		lblBici.setFont(new Font("Arial", Font.BOLD, 16));
		lblBici.setBounds(584, 58, 93, 14);
		alquilerBici.getContentPane().add(lblBici);

		JLabel lblBorrarBici = new JLabel("Borrar bici:");
		lblBorrarBici.setFont(new Font("Arial", Font.BOLD, 12));
		lblBorrarBici.setBounds(343, 432, 106, 15);
		alquilerBici.getContentPane().add(lblBorrarBici);
		
		JLabel lblActualizarUsuario = new JLabel("Actualizar Usuario");
		lblActualizarUsuario.setFont(new Font("Dialog", Font.BOLD, 12));
		lblActualizarUsuario.setBounds(316, 567, 153, 14);
		alquilerBici.getContentPane().add(lblActualizarUsuario);
		
		JLabel lblnombreUsuario_1 = new JLabel("Nombre");
		lblnombreUsuario_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblnombreUsuario_1.setBounds(344, 599, 81, 14);
		alquilerBici.getContentPane().add(lblnombreUsuario_1);
		
		JLabel lblidUsuarioCrear_1 = new JLabel("idUsuario");
		lblidUsuarioCrear_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblidUsuarioCrear_1.setBounds(344, 624, 115, 14);
		alquilerBici.getContentPane().add(lblidUsuarioCrear_1);
		
		textFieldIdActualizarUsuario = new JTextField();
		textFieldIdActualizarUsuario.setEnabled(false);
		textFieldIdActualizarUsuario.setColumns(10);
		textFieldIdActualizarUsuario.setBounds(435, 618, 86, 20);
		alquilerBici.getContentPane().add(textFieldIdActualizarUsuario);
		
		textFieldNombreActualizarUsuario = new JTextField();
		textFieldNombreActualizarUsuario.setColumns(10);
		textFieldNombreActualizarUsuario.setBounds(435, 593, 86, 20);
		alquilerBici.getContentPane().add(textFieldNombreActualizarUsuario);
		
		JButton btnActualizarUsuario = new JButton("Actualizar Usuario");
		btnActualizarUsuario.setFont(new Font("Dialog", Font.BOLD, 12));
		btnActualizarUsuario.setBounds(354, 650, 167, 23);
		alquilerBici.getContentPane().add(btnActualizarUsuario);

		DefaultTableModel modelUsuario = new DefaultTableModel();
		modelUsuario.addColumn("Código");
		modelUsuario.addColumn("Nombre");
		modelUsuario.addColumn("Bici alquilada");

		DefaultTableModel modelBici = new DefaultTableModel();
		modelBici.addColumn("Código");
		modelBici.addColumn("Estado");

		
		JButton btnMostrarBici = new JButton("Mostrar Bicis");
		btnMostrarBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					modelBici.setRowCount(0);
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM bici");

					comboBoxidBiciAlquilar.removeAllItems();
					comboBoxborrarBici.removeAllItems();

					while (rs.next()) {
						Object[] row = new Object[2];
						row[0] = rs.getInt("idbici");
						row[1] = rs.getString("disponibilidad");

						modelBici.addRow(row);
						comboBoxidBiciAlquilar.addItem(rs.getInt("idbici"));
						comboBoxborrarBici.addItem(rs.getInt("idbici"));

					}

					tableBici.setModel(modelBici);
					tableBici.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnMostrarBici.setFont(new Font("Arial", Font.BOLD, 12));
		btnMostrarBici.setBounds(554, 276, 153, 23);
		alquilerBici.getContentPane().add(btnMostrarBici);

		
		JButton btnmostrarUsuario = new JButton("Mostrar Usuario");
		btnmostrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					modelUsuario.setRowCount(0);
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");

					comboBoxidUsuarioAlquilar.removeAllItems();
					comboBoxborrarUsuario.removeAllItems();
					comboBoxIdUsuarioDevolver.removeAllItems();

					while (rs.next()) {
						Object[] row = new Object[3];
						row[0] = rs.getInt("idusuario");
						row[1] = rs.getString("nombre");
						row[2] = rs.getInt("bici_idbici");
						modelUsuario.addRow(row);
						comboBoxidUsuarioAlquilar.addItem(rs.getInt("idusuario"));
						comboBoxborrarUsuario.addItem(rs.getInt("idusuario"));
						comboBoxIdUsuarioDevolver.addItem(rs.getInt("idusuario"));
					}
					con.close();

					tableUsuario.setModel(modelUsuario);
					tableUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		btnmostrarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		btnmostrarUsuario.setBounds(221, 276, 153, 23);
		alquilerBici.getContentPane().add(btnmostrarUsuario);
		
		
		JButton btnborrarBici = new JButton("Borrar Bici");
		btnborrarBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement dele_pstmt = con.prepareStatement("DELETE FROM bici WHERE idbici = ? ");
					dele_pstmt.setInt(1, (int) comboBoxborrarBici.getSelectedItem());
					int rowsDeleted = dele_pstmt.executeUpdate();
					dele_pstmt.close();
					btnMostrarBici.doClick();
					JOptionPane.showMessageDialog(null, "Bici eliminada correctamente");

				} catch (SQLException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Formato del id no correcto",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnborrarBici.setFont(new Font("Arial", Font.BOLD, 12));
		btnborrarBici.setBounds(407, 498, 153, 23);
		alquilerBici.getContentPane().add(btnborrarBici);
		
		comboBoxborrarBici.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt4 = con.createStatement();
					ResultSet rs4 = stmt4.executeQuery("SELECT idbici FROM bici WHERE disponibilidad = 0");
					comboBoxborrarBici.removeAllItems();
					while (rs4.next()) {
						comboBoxborrarBici.addItem(rs4.getInt("idbici"));
					}
				}catch(SQLException e1) {
					
				}
			}
		});

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alquilerBici.dispose();
			}
		});

		btnSalir.setBounds(789, 22, 89, 23);
		alquilerBici.getContentPane().add(btnSalir);

		textFieldCrearUsuario = new JTextField();
		textFieldCrearUsuario.setColumns(10);
		textFieldCrearUsuario.setBounds(141, 366, 86, 20);
		alquilerBici.getContentPane().add(textFieldCrearUsuario);

		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreUsuario = textFieldNombre.getText();
				if (nombreUsuario.isEmpty()) {
					JOptionPane.showMessageDialog(null, "La casilla nombre está vacía");
				} else {

					try {

						Connection con = ConnectionSingleton.getConnection();
						PreparedStatement ins_pstmt = con.prepareStatement("INSERT INTO usuario (nombre, idusuario)  VALUES (?,?)");
						ins_pstmt.setString(1, textFieldNombre.getText());
						ins_pstmt.setInt(2, Integer.parseInt(textFieldCrearUsuario.getText()));
						int rowsInserted = ins_pstmt.executeUpdate();
						ins_pstmt.close();
						btnmostrarUsuario.doClick();
						JOptionPane.showMessageDialog(null, "Usuario creado correctamente");
						textFieldNombre.setText("");
						textFieldCrearUsuario.setText("");
						
					} catch (SQLIntegrityConstraintViolationException error) {
						JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
						textFieldNombre.setText("");
						textFieldCrearUsuario.setText("");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null, "El formato del id no es válido", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
				
			}
		});
		btnCrearUsuario.setBounds(74, 400, 153, 23);
		alquilerBici.getContentPane().add(btnCrearUsuario);

		JButton btnAlquilar = new JButton("Alquilar");
		btnAlquilar.setFont(new Font("Arial", Font.BOLD, 12));
		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = ConnectionSingleton.getConnection();
					
					PreparedStatement foreign = con.prepareStatement( "SET FOREIGN_KEY_CHECKS=0;");
					foreign.executeUpdate();
					
					PreparedStatement updtBici = con.prepareStatement("UPDATE bici SET disponibilidad = 1 WHERE idbici = ?;");
					updtBici.setInt(1, (int) comboBoxidBiciAlquilar.getSelectedItem());
					updtBici.executeUpdate();
					updtBici.close();
					
					PreparedStatement updtUsuario = con.prepareStatement("UPDATE usuario SET bici_idbici = ? WHERE idusuario = ?");
					updtUsuario.setInt(1, (int) comboBoxidBiciAlquilar.getSelectedItem());
					updtUsuario.setInt(2, (int) comboBoxidUsuarioAlquilar.getSelectedItem());
					updtUsuario.executeUpdate();
					updtUsuario.close();
					
					
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
					modelUsuario.setRowCount(0);
					comboBoxborrarUsuario.removeAllItems();
					comboBoxidBiciAlquilar.removeAllItems();
					comboBoxidUsuarioAlquilar.removeAllItems();
					while (rs.next()) {
						Object[] row = new Object[3];
						row[0] = rs.getInt("idusuario");
						row[1] = rs.getString("nombre");
						row[2] = rs.getInt("bici_idbici");
						modelUsuario.addRow(row);
						
						comboBoxborrarUsuario.addItem(rs.getInt("idusuario"));
					}
					
					
					//Actualizacion de bicis
					
					modelBici.setRowCount(0);
					Statement stmt3 = con.createStatement();
					ResultSet rs3 = stmt3.executeQuery("SELECT * FROM bici");

					comboBoxborrarBici.removeAllItems();

					while (rs3.next()) {
						Object[] row = new Object[2];
						row[0] = rs3.getInt("idbici");
						row[1] = rs3.getString("disponibilidad");
						modelBici.addRow(row);
						comboBoxborrarBici.addItem(rs3.getInt("idbici"));
					}
					
					JOptionPane.showMessageDialog(null, "Bici alquilada correctamente");
					
					
				} catch (SQLIntegrityConstraintViolationException error) {
					JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Formato no válido", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException e3) {
					JOptionPane.showMessageDialog(null, "Hay entradas vacías", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAlquilar.setBounds(714, 400, 160, 23);
		alquilerBici.getContentPane().add(btnAlquilar);
		
		comboBoxidBiciAlquilar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt4 = con.createStatement();
					ResultSet rs4 = stmt4.executeQuery("SELECT idbici FROM bici WHERE disponibilidad = 0");
					comboBoxidBiciAlquilar.removeAllItems();
					while (rs4.next()) {
						comboBoxidBiciAlquilar.addItem(rs4.getInt("idbici"));
					}
				}catch(SQLException e1) {
					
				}
			}
		});
		
		
		comboBoxidUsuarioAlquilar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt2 = con.createStatement();
					
					ResultSet rs2 = stmt2.executeQuery("SELECT idusuario FROM usuario WHERE bici_idbici IS NULL");
					comboBoxidUsuarioAlquilar.removeAllItems();
					while (rs2.next()) {
						comboBoxidUsuarioAlquilar.addItem(rs2.getInt("idusuario"));
					}
				}catch(SQLException e1) {
					
				}
			}
		});

		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.setFont(new Font("Arial", Font.BOLD, 12));
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection con = ConnectionSingleton.getConnection();
					
					
					PreparedStatement foreign = con.prepareStatement( "SET FOREIGN_KEY_CHECKS=0;");
					foreign.executeUpdate();
					
					PreparedStatement dele_pstmt2 = con.prepareStatement("UPDATE bici SET disponibilidad = 0 WHERE idbici = (SELECT bici_idbici FROM usuario WHERE idusuario = ?);");
					dele_pstmt2.setInt(1, (int) comboBoxIdUsuarioDevolver.getSelectedItem());
					
					dele_pstmt2.executeUpdate();
					dele_pstmt2.close();
					
					PreparedStatement dele_pstmt = con.prepareStatement("UPDATE usuario SET bici_idbici = NULL WHERE idusuario = ?");
					dele_pstmt.setInt(1, (int) comboBoxIdUsuarioDevolver.getSelectedItem());
					dele_pstmt.executeUpdate();
					dele_pstmt.close();
					
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
					modelUsuario.setRowCount(0);
					comboBoxborrarUsuario.removeAllItems();
					
					
					while (rs.next()) {
						Object[] row = new Object[3];
						row[0] = rs.getInt("idusuario");
						row[1] = rs.getString("nombre");
						row[2] = rs.getInt("bici_idbici");
						modelUsuario.addRow(row);
						comboBoxborrarUsuario.addItem(rs.getInt("idusuario"));
					}
					
					
					//Actualizacion de bicis
					
					modelBici.setRowCount(0);
					Statement stmt3 = con.createStatement();
					ResultSet rs3 = stmt3.executeQuery("SELECT * FROM bici");

					comboBoxborrarBici.removeAllItems();
					comboBoxIdUsuarioDevolver.removeAllItems();
					

					while (rs3.next()) {
						Object[] row = new Object[2];
						row[0] = rs3.getInt("idbici");
						row[1] = rs3.getString("disponibilidad");
						modelBici.addRow(row);
						comboBoxborrarBici.addItem(rs3.getInt("idbici"));
					}
					
					JOptionPane.showMessageDialog(null, "Bici devuelta correctamente");

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Formato no válido", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NullPointerException e3) {
					JOptionPane.showMessageDialog(null, "Hay entradas vacías", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				//btnMostrarBici.doClick();
//				btnmostrarUsuario.doClick();

			}
		});
		btnDevolver.setBounds(721, 498, 160, 23);
		alquilerBici.getContentPane().add(btnDevolver);
		
		comboBoxIdUsuarioDevolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt2 = con.createStatement();
					
					ResultSet rs2 = stmt2.executeQuery("SELECT idusuario FROM usuario WHERE bici_idbici != 0");
					comboBoxIdUsuarioDevolver.removeAllItems();
					while (rs2.next()) {
						comboBoxIdUsuarioDevolver.addItem(rs2.getInt("idusuario"));
					}
					
				}catch(SQLException e1) {
					
				}
			}
		});

		JLabel lblCrearBici = new JLabel("Crear Bici:");
		lblCrearBici.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCrearBici.setBounds(343, 322, 153, 14);
		alquilerBici.getContentPane().add(lblCrearBici);

		JButton btnCrearBici = new JButton("Crear Bici");
		btnCrearBici.setFont(new Font("Arial", Font.BOLD, 12));
		btnCrearBici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement ins_pstmt = con
							.prepareStatement("INSERT INTO bici (idbici, disponibilidad)  VALUES (?,0)");
					ins_pstmt.setInt(1, Integer.parseInt(textFieldcrearBici.getText()));
					int rowsInserted = ins_pstmt.executeUpdate();
					ins_pstmt.close();
					JOptionPane.showMessageDialog(null, "Bici creada correctamente");
					textFieldcrearBici.setText("");

				} catch (SQLIntegrityConstraintViolationException error) {
					textFieldcrearBici.setText("");
					JOptionPane.showMessageDialog(null, "No pueden haber entradas duplicadas");
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "Formato no válido", "Error", JOptionPane.ERROR_MESSAGE);
				}
				btnMostrarBici.doClick();
			}
		});
		btnCrearBici.setBounds(407, 400, 153, 23);
		alquilerBici.getContentPane().add(btnCrearBici);

		JButton btnBotonBorrarUsuario = new JButton("Borrar Usuario");
		btnBotonBorrarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		btnBotonBorrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement dele_pstmt = con.prepareStatement("DELETE FROM usuario WHERE idusuario = ? ");
					dele_pstmt.setInt(1, (int) comboBoxborrarUsuario.getSelectedItem());

					int rowsDeleted = dele_pstmt.executeUpdate();
					dele_pstmt.close();
					JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");

				} catch (SQLException e3) {
					JOptionPane.showMessageDialog(null, e3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Hay entradas vacías",
							JOptionPane.ERROR_MESSAGE);
				}
				btnmostrarUsuario.doClick();
			}
		});
		btnBotonBorrarUsuario.setBounds(74, 498, 153, 23);
		alquilerBici.getContentPane().add(btnBotonBorrarUsuario);
		
		
		
		comboBoxborrarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con = ConnectionSingleton.getConnection();
					Statement stmt2 = con.createStatement();
					
					ResultSet rs2 = stmt2.executeQuery("SELECT idusuario FROM usuario WHERE bici_idbici IS NULL");
					comboBoxborrarUsuario.removeAllItems();
					while (rs2.next()) {
						comboBoxborrarUsuario.addItem(rs2.getInt("idusuario"));
					}
				}catch(SQLException e1) {
					
				}
			}
		});
		
		
		tableUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableUsuario.getSelectedRow();
				TableModel model = tableUsuario.getModel();
				textFieldIdActualizarUsuario.setText(model.getValueAt(index, 0).toString());
				textFieldNombreActualizarUsuario.setText(model.getValueAt(index, 1).toString());
			}
		});
		
		btnActualizarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Connection con = ConnectionSingleton.getConnection();
					PreparedStatement dele_pstmt = con.prepareStatement("UPDATE usuario SET nombre = ? WHERE idusuario = ?");
					dele_pstmt.setString(1, textFieldNombreActualizarUsuario.getText());
					dele_pstmt.setInt(2, Integer.parseInt(textFieldIdActualizarUsuario.getText()));
					dele_pstmt.executeUpdate();
					dele_pstmt.close();
					btnmostrarUsuario.doClick();
					
				}catch(SQLException e1) {
					
				}
				
				
			}
		});

	}
}
