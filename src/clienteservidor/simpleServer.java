package clienteservidor;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class simpleServer 	{
	
	  public static void main(String args[]) throws IOException 
	  {
	    // Registrar el servicio en el puerto 1234
	    ServerSocket s = new ServerSocket(1234);
	    
	    //Espera y acepta conexiones
	    while(true){
	          Socket s1 = s.accept();
		    //Obtiene un flujo de comunicación asociado con el socket
		    OutputStream s1out = s1.getOutputStream();
		    DataOutputStream dos = new DataOutputStream (s1out);

		    InputStream s1In = s1.getInputStream();
		    DataInputStream dis = new DataInputStream(s1In);
		    
		    Scanner sc = new Scanner(System.in);

		    //Envia un mensaje
		    dos.writeUTF("Conexión con el servidor Establecida\n"+"Por favor envie un dato de entero: ");
		    String cadena = new String (dis.readUTF());

		    //System.out.println("Recibido: "+ cadena);
			//System.out.println("Tipo de dato a pedir: ");
		    
		    do{
			    //String cadena = new String (dis.readUTF());
    			System.out.println("Recibido: " + cadena);
    			System.out.println("Tipo de dato a pedir: ");
			    String cadServer = sc.next();
			    dos.writeUTF("Por favor envie un dato " + cadServer);
			  }while(cadena != "adios");
		    
		    dos.writeUTF("Sesión Finalizada. Hasta luego!");
		    sc.close();
		    
	        //Cierra la conexión, pero no el socket del servidor
		    dis.close();
		    s1In.close();
		    dos.close();
		    s1out.close();         
		    s1.close();
		  }
      }
      }