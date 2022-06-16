
//hola soy daviddd
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class HolaMundoSwing extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	private JButton btnIncrementar1;
	private JButton btnIncrementar10;
	private int contador;
	private JLabel lblIncrementar;
	private JCheckBox chckbxBotones;
	private JComboBox<String> cmbBox;

	public static void main(String[] args) {
		HolaMundoSwing ventana = new HolaMundoSwing();
		ventana.setVisible(true);
	}

	public HolaMundoSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);

		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());

		btnIncrementar1 = new JButton("Incrementar 1");
		panelPrincipal.add(btnIncrementar1, BorderLayout.SOUTH);
		btnIncrementar1.addActionListener(this);

		btnIncrementar10 = new JButton("Incrementar 10");
		panelPrincipal.add(btnIncrementar10, BorderLayout.NORTH);
		btnIncrementar10.addActionListener(this);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height - 500;
		int width = toolkit.getScreenSize().width - 500;
		setPreferredSize(new Dimension(width, height));
		pack();
		setLocationRelativeTo(null);

		setContentPane(panelPrincipal);

		lblIncrementar = new JLabel("New label");
		lblIncrementar.setHorizontalAlignment(SwingConstants.CENTER);
		panelPrincipal.add(lblIncrementar, BorderLayout.CENTER);

		setVisible(true);
		contador = 0;
		lblIncrementar.setText("Todav�a no se ha pulsado el bot�n");

		chckbxBotones = new JCheckBox("Activar botones");
		chckbxBotones.setSelected(true);
		panelPrincipal.add(chckbxBotones, BorderLayout.WEST);
		chckbxBotones.addActionListener(this);

		cmbBox = new JComboBox<>();
		panelPrincipal.add(cmbBox, BorderLayout.EAST);

		String[] opciones = new String[] { "opci�n1", "opci�n2", "opci�n3" };
		for (String opcion : opciones) {
			cmbBox.addItem(opcion);
		}
		cmbBox.setSelectedIndex(1);
		cmbBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Nueva opci�n seleccionada: " +
						cmbBox.getSelectedItem());
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "Incrementar 1":
			gestionarPulsacionBotonIncrementar1();
			break;
		case "Incrementar 10":
			gestionarPulsacionBotonIncrementar10();
			break;
		case "Activar botones":
			gestionarActivacionBotones();
		
		}
	}

	public void gestionarPulsacionBotonIncrementar10() {
		contador += 10;
		lblIncrementar.setText("Contador: " + contador);
	}

	public void gestionarPulsacionBotonIncrementar1() {
		contador++;
		// escribo en el label el valor de contador
		lblIncrementar.setText("Contador: " + contador);

		System.out.println(contador);
		if (contador % 2 == 0) {
			panelPrincipal.setBackground(Color.GREEN);
			btnIncrementar1.setForeground(Color.red);
		} else {
			panelPrincipal.setBackground(Color.yellow);
			btnIncrementar1.setForeground(Color.blue);
		}
	}

	public void gestionarActivacionBotones() {
		// si el checkbox esta activado -> activamos los botones
		if (chckbxBotones.isSelected()) {
			System.out.println("activo botones");
			btnIncrementar1.setEnabled(true);
			btnIncrementar10.setEnabled(true);
		} else {
			System.out.println("desactivo botones");
			btnIncrementar1.setEnabled(false);
			btnIncrementar10.setEnabled(false);
		}
	}
}