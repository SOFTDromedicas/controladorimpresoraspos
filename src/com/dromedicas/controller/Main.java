package com.dromedicas.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

/**
*
* @author 
*/
public class Main {
	
	private static String url;
	private static String impresora ;

	public static void main(String[] args) {		
		try {
			for(String file: args){
				preparedPrinter( file );
			}			
		} catch (Exception e) {
			System.err.print("Falla al recibir los archivos");
			e.printStackTrace();
		}
	}// fin del main
	
	
	private static String preparedPrinter( String document ){
		try {
			 cargaParametros();
			 //Determino el tipo de archivo
			 //Divide la cadena antes en el punto de la extension del archivo
			 String cadenas[] = document.split("\\.(?=[^\\.]+$)");
			 if(cadenas[1].equals("txt"))
			 {	
				 String uri = url + document;
				 File file = new File(uri);
				 PrintTxt.printTxt(file);			 
				 				 
			 }else{
				 if(cadenas[1].equals("pdf")){
					 String uri = url + document;
					 File file = new File(uri);
					 PrintPdf.printPdf(impresora, file); 
				 }
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return "";		
	}	
	
	
	private static void cargaParametros(){
		try {
			// Obtengo los parametros de impresion y url de archivos
			Properties propiedades = new Properties();
			FileInputStream entrada;

			String uriPropiedades = "C:\\AppServ\\www\\dropos\\properties\\propiedades.dat";
			entrada = new FileInputStream(uriPropiedades);
			// cargo las propiedades
			propiedades.load(entrada);
			// cierra el flujo de entrada
			entrada.close();
			// obtiene las claves de las propiedades
			Set<Object> claves = propiedades.keySet();
			// asigna los valores
			for (Object clave : claves) {
				if (clave.equals("url"))
					url = propiedades.getProperty((String) clave);
				if (clave.equals("printer"))
					impresora = propiedades.getProperty((String) clave);
			} // fin de for
		} catch (Exception e) {
			System.err.print("Falla en la carga de los parametros");
			e.printStackTrace();
		}
	}
	
}


