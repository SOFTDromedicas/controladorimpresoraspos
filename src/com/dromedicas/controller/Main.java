package com.dromedicas.controller;


import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

/**
*
* @author 
*/
public class Main {

	public static void main(String[] args) {
		
		Properties propiedades = new Properties();
		FileInputStream entrada;
		String url = "";
		String impresora = "";
		
		try {
			entrada = 
					new FileInputStream( "C:\\AppServ\\www\\dropos\\properties\\propiedades.dat" );
			//cargo las propiedades
			propiedades.load(entrada);
			entrada.close();
			Set< Object > claves = propiedades.keySet(); // obtiene los nombres de las propiedades
			
			// asigna los valores
			for ( Object clave : claves )
			 {
				if(clave.equals("url"))
					url = propiedades.getProperty( ( String ) clave ) ;
				if(clave.equals("printer"))
					impresora = propiedades.getProperty( ( String ) clave ) ;
				
			/*	
			System.out.printf(
			 "%s\t%s\n", clave, propiedades.getProperty( ( String ) clave ) );
			*/
			 } // fin de for	
			
			System.out.println("url: "+url);
			System.out.println("impresora: "+impresora);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//imprimirPDF(args);
		
	}// fin del main
	
	
	
	
	
	
	private static void imprimirPDF(String...s){
		
		String uri;
		uri = "C:\\AppServ\\www\\dropos\\print\\";
		try {
			// validacion de multiples archivos
			if (s.length > 1) {
				for (String e : s) {
					printFile(new File(uri + e + ".pdf"));
				}
			} else {
				//printFile(new File( uri + "factura_3" + ".pdf"));
				printFile(new File(uri + s[0]+".pdf"));
			}
		} catch (Exception e) {
			System.out.println("Error:");
			e.printStackTrace();
		}
		
	}
	
	
	private static void printFile(File f) {
		try {	
			PDDocument pdf = PDDocument.load(f);
			PrinterJob job = PrinterJob.getPrinterJob();
			PDFPageable pdfPg = new PDFPageable(pdf);
			PrintService myPrintService = findPrintService("POS-80");
			job.setPageable(pdfPg);
			job.setPrintService( myPrintService  );
			job.print();
		} catch (Exception e) {
			System.out.println("Error en printFile:");
			e.printStackTrace();
		}
	}	
	
	
	private static PrintService findPrintService(String printerName) {
	    PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
	    for (PrintService printService : printServices) {
	        if (printService.getName().trim().equals(printerName)) {
	            return printService;
	        }
	    }
	    return null;
	}
			
}



