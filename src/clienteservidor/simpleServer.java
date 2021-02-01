package clienteservidor;
import java.net.*;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

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
	          
	        dos.writeUTF("Conexión con el servidor Establecida\n");
		    
		    Scanner sc = new Scanner(System.in);

		    //Envia un mensaje
		    dos.writeUTF("Introduzca un número entero para el tamaño de la matriz\n");
		    
		    String cadena = new String (dis.readUTF());
		    //*****************************************
	        //Leyendo numero
	        int num = (dis.readInt());
	        
	        System.out.println("El numero es: " + num);
	        //Creando Matriz
	        int m[][] = new int[num][num];
	        ArrayList vector = new ArrayList();
	        
	        for (int i = 0; i < m.length; i++) {
	            
	            for (int j = 0; j < m.length; j++) {
	                
	                int x = (int) (Math.random() * num + 1);
	                
	                m[i][j] = x;
	                vector.add(x);
	                
	            }
	            
	        }
	        
	        System.out.println("La matriz es: ");
	        //Leyendo elementos de matriz
	        for (int i = 0; i < m.length; i++) {
	            for (int j = 0; j < m.length; j++) {
	                
	                System.out.print(m[i][j] + " ");
	            }
	            System.out.println(" ");
	        }
	        
	        ObjectOutputStream output = new ObjectOutputStream(s1out);
	        output.writeObject(vector);
	        //**************************************
		    
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