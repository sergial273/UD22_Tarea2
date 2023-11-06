package UD22_Tarea2.UD22_Tarea2;

import connexion.Connector;
import controllers.Controlador;
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

public class App 
{

	
    public static void main( String[] args )
    {
        Cliente c = new Cliente();
        MenuInicio ini = new MenuInicio();
        Anadir a = new Anadir();
        Ver v = new Ver();
        Connector con = new Connector();
        Quitar q = new Quitar();
        QueAnadir an = new QueAnadir();
        AnadirVideo anadirvideo = new AnadirVideo();
        VerVideo vervideo = new VerVideo();
        Video video = new Video();
        QuitarVideo quitarVideo = new QuitarVideo();
        Controlador control = new Controlador(ini, c, a, v, con, q, an, anadirvideo, vervideo, video, quitarVideo);
        control.iniciarVista();
    }
}
