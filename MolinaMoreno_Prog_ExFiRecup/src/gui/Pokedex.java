package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import container.Contenedor;

import models.Pokemon;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.util.spi.TimeZoneNameProvider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Pokedex {

	protected JFrame frmPokedexV;
	private JTextField fieldNombre;
	private JTextField fieldNumero;
	private JTextField fieldNivel;
	private JTextField fieldRegion;
	private JTextField fieldComentarios;
	private JComboBox comboTipos;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnInsertar;
	private JButton btnBuscar;
	private JLabel lblIndice;

	private int indicePokemon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pokedex window = new Pokedex();
					window.frmPokedexV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pokedex() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokedexV = new JFrame();
		frmPokedexV.setTitle("Pokedex v1.0");
		frmPokedexV.setBounds(100, 100, 450, 334);
		frmPokedexV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedexV.getContentPane().setLayout(null);

		btnAnterior = new JButton("<");
		btnAnterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				prevPokemon();
				mostrarPokemon();
				label();
			}
		});
		btnAnterior.setBounds(10, 28, 57, 30);
		frmPokedexV.getContentPane().add(btnAnterior);

		btnSiguiente = new JButton(">");
		btnSiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nextPokemon();
				mostrarPokemon();
				label();

			}
		});

		btnSiguiente.setBounds(367, 28, 46, 30);
		frmPokedexV.getContentPane().add(btnSiguiente);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(33, 87, 46, 14);
		frmPokedexV.getContentPane().add(lblNombre);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(33, 125, 46, 14);
		frmPokedexV.getContentPane().add(lblNumero);

		JLabel lvlNivel = new JLabel("Nivel Evoluci\u00F3n");
		lvlNivel.setBounds(10, 173, 80, 14);
		frmPokedexV.getContentPane().add(lvlNivel);

		JLabel lblRegion = new JLabel("Regi\u00F3n");
		lblRegion.setBounds(33, 207, 46, 14);
		frmPokedexV.getContentPane().add(lblRegion);

		fieldNombre = new JTextField();
		fieldNombre.setBounds(99, 84, 86, 20);
		frmPokedexV.getContentPane().add(fieldNombre);
		fieldNombre.setColumns(10);

		fieldNumero = new JTextField();
		fieldNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();

				}
			}
		});

		fieldNumero.setColumns(10);
		fieldNumero.setBounds(99, 122, 86, 20);
		frmPokedexV.getContentPane().add(fieldNumero);

		fieldNivel = new JTextField();
		fieldNivel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char caracter = e.getKeyChar();
				if (((caracter < '1') || (caracter > '3')) && (caracter != '\b')) {

					e.consume();

				}
			}
		});
		fieldNivel.setColumns(10);
		fieldNivel.setBounds(99, 170, 86, 20);
		frmPokedexV.getContentPane().add(fieldNivel);

		fieldRegion = new JTextField();
		fieldRegion.setColumns(10);
		fieldRegion.setBounds(99, 204, 86, 20);
		frmPokedexV.getContentPane().add(fieldRegion);

		fieldComentarios = new JTextField();
		fieldComentarios.setBounds(282, 131, 142, 99);
		frmPokedexV.getContentPane().add(fieldComentarios);
		fieldComentarios.setColumns(10);

		JLabel lblComentarios = new JLabel("Comentarios");
		lblComentarios.setBounds(205, 117, 67, 30);
		frmPokedexV.getContentPane().add(lblComentarios);

		comboTipos = new JComboBox();
		comboTipos.setModel(new DefaultComboBoxModel(
				new String[] { "Fuego", "Agua", "Hielo", "Tierra", "Lucha", "Hada", "Siniestro", "Psiquico", "Fantasma",
						"Roca", "Normal", "Volador", "Dragon", "Planta", "Electrico", "Veneno", "Bicho", "Acero" }));
		comboTipos.setBounds(300, 84, 113, 20);
		frmPokedexV.getContentPane().add(comboTipos);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(226, 87, 46, 14);
		frmPokedexV.getContentPane().add(lblTipo);

		JLabel lblTitulo = new JLabel("Pokedex");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitulo.setBounds(114, 26, 101, 30);
		frmPokedexV.getContentPane().add(lblTitulo);

		lblIndice = new JLabel("label Indice");
		lblIndice.setBounds(261, 28, 80, 30);
		frmPokedexV.getContentPane().add(lblIndice);

		btnInsertar = new JButton("Insertar Nuevo Pokemon");
		btnInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modoInsertar();
			}
		});
		btnInsertar.setBounds(64, 250, 136, 23);
		frmPokedexV.getContentPane().add(btnInsertar);

		btnBuscar = new JButton("Buscar Pokemon");
		btnBuscar.setBounds(229, 250, 136, 23);
		frmPokedexV.getContentPane().add(btnBuscar);

		modoLeer();

	}

	private void modoLeer() {
		label();
		fieldComentarios.setEnabled(false);
		fieldNombre.setEnabled(false);
		fieldNivel.setEnabled(false);
		fieldNumero.setEnabled(false);
		comboTipos.setEnabled(false);
		fieldRegion.setEnabled(false);
		btnAnterior.setEnabled(true);
		btnSiguiente.setEnabled(true);
		mostrarPokemon();

	}

	private void modoInsertar() {
		limpiar();
		fieldComentarios.setEnabled(true);
		fieldNombre.setEnabled(true);
		fieldNivel.setEnabled(true);
		fieldNumero.setEnabled(true);
		comboTipos.setEnabled(true);
		fieldRegion.setEnabled(true);

		btnAnterior.setEnabled(false);
		btnSiguiente.setEnabled(false);
		btnInsertar.setText("Confirmar");

		btnInsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Pokemon p = container.Contenedor.ml.get(indicePokemon);

				
				if (!container.Contenedor.ml.isEmpty()) {
					if (p.getNombre().equals(fieldNombre.getText())) {

						JOptionPane.showMessageDialog(frmPokedexV, "Error, nombre de pokemon ya Existente", null,
								JOptionPane.INFORMATION_MESSAGE);

						if (fieldNumero.getText().equals(p.getNumero())) {

							JOptionPane.showMessageDialog(frmPokedexV, "Error, numero de pokemon ya Existente", null,
									JOptionPane.INFORMATION_MESSAGE);

							String nombre, region, comentario, tipo;
							int nivel, numero;
							comentario = fieldComentarios.getText();
							region = fieldRegion.getText();
							nombre = fieldNombre.getText();
							nivel = Integer.parseInt(fieldNivel.getText());
							numero = Integer.parseInt(fieldNumero.getText());
							tipo = comboTipos.getName();

							Pokemon pAux = new Pokemon(nombre, numero, nivel, region, tipo, comentario);
							container.Contenedor.ml.add(pAux);
							modoLeer();
						}
					}

				}

				if (container.Contenedor.ml.isEmpty()) {
					String nombre, region, comentario, tipo;
					int nivel, numero;

					comentario = fieldComentarios.getText();
					region = fieldRegion.getText();
					nombre = fieldNombre.getText();
					nivel = Integer.parseInt(fieldNivel.getText());
					numero = Integer.parseInt(fieldNumero.getText());
					tipo = comboTipos.getName();

					Pokemon pAux = new Pokemon(nombre, numero, nivel, region, tipo, comentario);
					container.Contenedor.ml.add(pAux);
					modoLeer();
				}

			}
		});

	}

	public void mostrarPokemon() {

		if (!container.Contenedor.ml.isEmpty()) {
			Pokemon p = container.Contenedor.ml.get(indicePokemon);

			fieldNombre.setText(p.getNombre());
			fieldNumero.setText("" + p.getNumero());
			fieldNivel.setText("" + p.getNivel());
			fieldRegion.setText(p.getRegion());
			comboTipos.setSelectedItem(p.getTipo());
			fieldComentarios.setText(p.getComentarios());

		}
	}

	private int nextPokemon() {
		++indicePokemon;
		if (indicePokemon == container.Contenedor.ml.size()) {
			indicePokemon = 0;
		}
		return indicePokemon;
	}

	private int prevPokemon() {
		--indicePokemon;
		if (indicePokemon < 0) {
			indicePokemon = container.Contenedor.ml.size() - 1;
		}
		return indicePokemon;
	}

	public void label() {
		int miIndice = indicePokemon + 1;
		lblIndice.setText(miIndice + "/" + (container.Contenedor.ml.size()));
	}

	public void limpiar() {

		fieldComentarios.setText("");
		fieldRegion.setText("");
		fieldNombre.setText("");
		fieldNivel.setText("");
		fieldNumero.setText("");

	}

}
