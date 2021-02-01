package clienteservidor;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class simpleClient{
	public static int entero = 0;
	public static float flotante = 0;
	public static boolean boleano = false;
	public static boolean bandera = true;
	public static String cadena = "";
	
	  public static void main(String args[]) throws IOException 
	  {
	    //Abrir una conexión al server en el puerto 1234
	    Socket s1 = new Socket("localhost",1234);
	    
	   //Obtener un manejador de flujo de entrada del socket y leer la entrada
	    InputStream s1In = s1.getInputStream();
	    DataInputStream dis = new DataInputStream(s1In);
	    
	    OutputStream s1out = s1.getOutputStream();
	    DataOutputStream dos = new DataOutputStream (s1out);
	    
	    Scanner sc = new Scanner(System.in);

	    String st = new String (dis.readUTF());
	    System.out.println(st);
	    
	    entero = sc.nextInt();
	    dos.writeInt(entero);
	    
	    do{
	    	st = new String (dis.readUTF());
		    System.out.println(st);
		    if(st == "Por favor envie un dato entero"){
			    entero = sc.nextInt();
			    dos.writeInt(entero);
		    }else if(st == "Por favor envie un dato flotante") {
			    float flotante = sc.nextFloat();
			    dos.writeFloat(flotante);
		    }else {
			    bandera = false;
		    }
	    }while(bandera == true);
	    
	    sc.close();
	    
	    //Cerrar la conexion
	    dos.close();
	    s1out.close();
	    dis.close();
	    s1In.close();
	    s1.close();
	  }
	}