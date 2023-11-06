package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VerVideo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private JLabel nombreLabel, apellidoLabel;
    public JTextField nombreTextField, apellidoTextField, clienteTextField;
    public JButton guardarButton, cancelarButton;

    public VerVideo() {
        
        setSize(450, 350);

        
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets.left = 10;
        constraints.insets.right = 10;
        constraints.insets.top = 5;
        constraints.insets.bottom = 5;

        
        nombreLabel = new JLabel("Id a buscar:");
        nombreTextField = new JTextField(25);

        apellidoLabel = new JLabel("Resultado:");
        apellidoTextField = new JTextField(25);
        apellidoTextField.setEditable(false);
        
        clienteTextField = new JTextField(25);
        clienteTextField.setEditable(false);
        
        guardarButton = new JButton("Buscar");
        cancelarButton = new JButton("Atras");
        
        
        constraints.gridy = 0;
        mainPanel.add(nombreLabel, constraints);
        constraints.gridy = 1;
        mainPanel.add(apellidoLabel, constraints);
        
        
        constraints.gridy = 0;
        constraints.gridx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER; // Extender por toda la fila
        mainPanel.add(nombreTextField, constraints);
        constraints.gridy = 1;
        mainPanel.add(apellidoTextField, constraints);
        constraints.gridy = 2;
        mainPanel.add(clienteTextField, constraints);
        
        constraints.gridwidth = 1; 
        constraints.gridy = 5;
        mainPanel.add(guardarButton, constraints);
        constraints.gridx = 2;
        mainPanel.add(cancelarButton, constraints);

        add(mainPanel);
    }
}