package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import connexion.Connector;
import models.Cliente;
import models.Video;
import views.Anadir;
import views.AnadirVideo;
import views.MenuInicio;
import views.QueAnadir;
import views.Quitar;
import views.QuitarVideo;
import views.Ver;
import views.VerVideo;

public class Controlador implements ActionListener {
	
	private MenuInicio menu;
	private Cliente cliente;
	private Video video;
	private Anadir anadirCliente;
	private Ver ver;
	private Connector connector;
	private Quitar quitar;
	private QueAnadir queanadir;
	private AnadirVideo anadirVideo;
	private VerVideo verVideo;
	private QuitarVideo quitarVideo;
	private boolean verBool = false;
	private boolean quitarBool = false;
	
	public Controlador(MenuInicio menu, Cliente cliente, Anadir anadir, Ver ver, Connector connector, Quitar quitar, QueAnadir queanadir, AnadirVideo anadirVideo, VerVideo verVideo, Video video, QuitarVideo quitarVideo){
		this.cliente = cliente;
		this.menu = menu;
		this.anadirCliente = anadir;
		this.ver = ver;
		this.connector = connector;
		this.quitar = quitar;
		this.queanadir = queanadir;
		this.anadirVideo = anadirVideo;
		this.verVideo = verVideo;
		this.video = video;
		this.quitarVideo = quitarVideo;
		this.menu.anadir.addActionListener(this);
		this.menu.ver.addActionListener(this);
		this.menu.quitar.addActionListener(this);
		this.anadirCliente.guardarButton.addActionListener(this);
		this.anadirCliente.cancelarButton.addActionListener(this);
		this.ver.guardarButton.addActionListener(this);
		this.ver.cancelarButton.addActionListener(this);
		this.quitar.cancelarButton.addActionListener(this);
		this.quitar.guardarButton.addActionListener(this);
		this.queanadir.cliente.addActionListener(this);
		this.queanadir.video.addActionListener(this);
		this.anadirVideo.cancelarButton.addActionListener(this);
		this.anadirVideo.guardarButton.addActionListener(this);
		this.verVideo.guardarButton.addActionListener(this);
		this.verVideo.cancelarButton.addActionListener(this);
		this.quitarVideo.cancelarButton.addActionListener(this);
		this.quitarVideo.guardarButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(menu.anadir == e.getSource()) {
			menu.setVisible(false);
			iniciarVistaAnadir();
			
		}
		else if(menu.ver == e.getSource()) {
			menu.setVisible(false);
			verBool = true;
			quitarBool = true;
			queanadir.label.setText("¿Qué quieres ver?");
			iniciarVistaAnadir();
		}
		else if(menu.quitar == e.getSource()) {
			menu.setVisible(false);
			quitarBool = true;
			iniciarVistaAnadir();
		}
		else if(queanadir.video== e.getSource()) {
			queanadir.setVisible(false);
			if(verBool) {
				iniciarVistaVerVideo();
			}
			else if(quitarBool) {
				iniciarVistaQuitarVideo();
			}
			else {
				iniciarVistaAnadirVideo();
			}
			
		}
		else if(queanadir.cliente== e.getSource()) {
			queanadir.setVisible(false);
			if(verBool) {		
				iniciarVistaVerCliente();
			}
			else if(quitarBool) {
				iniciarVistaQuitarCliente();
			}
			else {
				iniciarVistaAnadirCliente();
			}	
		}
		else if(anadirCliente.guardarButton== e.getSource()) {
			anadirValorCliente();
		}
		else if(anadirVideo.guardarButton== e.getSource()) {
			anadirValorVideo();
		}
		else if(ver.guardarButton== e.getSource()) {
			mostrarValor();
			
		}
		else if(verVideo.guardarButton== e.getSource()) {
			mostrarValorVideo();
			
		}
		else if(quitar.guardarButton== e.getSource()) {
			quitarValor();
			
		}
		else if(quitarVideo.guardarButton== e.getSource()) {
			quitarValorVideo();
			
		}
		else if(anadirCliente.cancelarButton == e.getSource() || anadirVideo.cancelarButton == e.getSource() || ver.cancelarButton == e.getSource() || quitar.cancelarButton == e.getSource() || verVideo.cancelarButton == e.getSource() || quitarVideo.cancelarButton == e.getSource()) {
			//cambiar visibilidades
			queanadir.label.setText("¿Qué quieres añadir?");
			verBool = false;
			anadirCliente.setVisible(false);
			anadirVideo.setVisible(false);
			ver.setVisible(false);
			verVideo.setVisible(false);
			quitar.setVisible(false);
			quitarVideo.setVisible(false);
			menu.setVisible(true);
			
		}
	}
	
	public void iniciarVista() {
		menu.setTitle("Menu inicio");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
	}
	
	public void iniciarVistaAnadir() {
		queanadir.setTitle("Anadir");
		queanadir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		queanadir.setLocationRelativeTo(null);
		queanadir.setVisible(true);
	}
	
	public void iniciarVistaAnadirCliente() {
		anadirCliente.setTitle("Anadir");
		anadirCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		anadirCliente.setLocationRelativeTo(null);
		anadirCliente.setVisible(true);
	}
	
	public void iniciarVistaAnadirVideo() {
		anadirVideo.setTitle("Anadir");
		anadirVideo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		anadirVideo.setLocationRelativeTo(null);
		anadirVideo.setVisible(true);
	}
	
	public void iniciarVistaVerCliente() {
		ver.setTitle("Ver");
		ver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ver.setLocationRelativeTo(null);
		ver.setVisible(true);
	}
	
	public void iniciarVistaVerVideo() {
		verVideo.setTitle("Ver");
		verVideo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		verVideo.setLocationRelativeTo(null);
		verVideo.setVisible(true);
	}
	
	public void iniciarVistaQuitarCliente() {
		quitar.setTitle("Quitar");
		quitar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quitar.setLocationRelativeTo(null);
		quitar.setVisible(true);
	}
	
	public void iniciarVistaQuitarVideo() {
		quitarVideo.setTitle("Quitar");
		quitarVideo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		quitarVideo.setLocationRelativeTo(null);
		quitarVideo.setVisible(true);
	}
	
	public void mostrarValor() {
		cliente = connector.leer(ver.nombreTextField.getText());
		if (cliente.getId() != 0) {
			ver.apellidoTextField.setText(cliente.toString());
		}
		else {
			JOptionPane.showMessageDialog(null, "El elemento no se encuentra en la base de datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}
	    
	}
	
	public void mostrarValorVideo() {
		video = connector.leerVideo(verVideo.nombreTextField.getText());
		
		if (video.getId() != 0) {
			verVideo.apellidoTextField.setText(video.toString());
			Object a = video.getCliId();
			if(a != null) {
				cliente = connector.leer(String.valueOf(video.getCliId()));
				if (cliente != null) {
					verVideo.clienteTextField.setText(cliente.toString());
				}
				else {
					verVideo.clienteTextField.setText("Este video no pertenece a ningun cliente");
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "El elemento no se encuentra en la base de datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}
	    
	}
	
	public void anadirValorCliente() {

		boolean podido = connector.escribir(anadirCliente.nombreTextField.getText(), anadirCliente.apellidoTextField.getText(), anadirCliente.direccionTextField.getText(), anadirCliente.dniTextField.getText(), anadirCliente.fechaTextField.getText());
		
		if (podido) {
			JOptionPane.showMessageDialog(null, "Values added successfully",
				      "Ok", JOptionPane.DEFAULT_OPTION);
		}
		else {
			JOptionPane.showMessageDialog(null, "Error en los campos de los datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}
	    
	}
	
	public void anadirValorVideo() {

		boolean podido = connector.escribirVideo(anadirVideo.tituloTextField.getText(), anadirVideo.directorTextField.getText(), anadirVideo.clienteTextField.getText());
		
		if (podido) {
			JOptionPane.showMessageDialog(null, "Values added successfully",
				      "Ok", JOptionPane.DEFAULT_OPTION);
		}
		else {
			JOptionPane.showMessageDialog(null, "Error en los campos de los datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}
	    
	}
	
	public void quitarValor() {
		boolean podido =  connector.quitar(quitar.nombreTextField.getText());
		if (podido) {
			JOptionPane.showMessageDialog(null, "Client deleted successfully",
				      "Ok", JOptionPane.DEFAULT_OPTION);
		}
		else {
			JOptionPane.showMessageDialog(null, "Error en los campos de los datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}    
	}
	
	public void quitarValorVideo() {
		boolean podido =  connector.quitarVideo(quitarVideo.nombreTextField.getText());
		if (podido) {
			JOptionPane.showMessageDialog(null, "Client deleted successfully",
				      "Ok", JOptionPane.DEFAULT_OPTION);
		}
		else {
			JOptionPane.showMessageDialog(null, "Error en los campos de los datos",
				      "Error", JOptionPane.ERROR_MESSAGE);
		}    
	}
}
