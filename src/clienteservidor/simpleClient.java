package clienteservidor;
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class simpleClient{
	
	  public static void main(String args[]) throws IOException, ClassNotFoundException 
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
	    
        int tamanioMat = sc.nextInt();
        sc.nextLine();
        dos.writeInt(tamanioMat);
        
        ObjectInputStream inp = new ObjectInputStream(s1In);
        ArrayList lista = (ArrayList) inp.readObject();
        //ip.readObject(lista);
		    
        
	    sc.close();
	    
	    //Cerrar la conexion
	    dos.close();
	    s1out.close();
	    dis.close();
	    s1In.close();
	    s1.close();
	  }
	}