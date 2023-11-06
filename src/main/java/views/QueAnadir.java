package views;

import javax.swing.*;
import java.awt.*;

public class QueAnadir extends JFrame {

	private static final long serialVersionUID = 1L;
	public JLabel label;
	public JButton cliente, video;
	private JPanel mainPanel, buttonPanel;
    
	public QueAnadir() {
        setSize(400, 150);

        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        
        label = new JLabel("¿Qué quieres añadir?");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(label, BorderLayout.CENTER);

        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        
        cliente = new JButton("Cliente");
        video = new JButton("Video");

        
        buttonPanel.add(cliente);
        buttonPanel.add(video);

        
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        
        add(mainPanel);

	}
}
