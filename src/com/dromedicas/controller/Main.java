package com.dromedicas.controller;


import java.awt.print.PrinterJob;
import java.io.File;

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
		// ubicacion base de los archivos de impresion
		String uri;
		uri = "C:\\AppServ\\www\\dropos\\print\\";
		try {
			// validacion de multiples archivos
			if (args.length > 1) {
				for (String e : args) {
					printFile(new File(uri + e + ".pdf"));
				}
			} else {
				//printFile(new File( uri + "factura_3" + ".pdf"));
				printFile(new File(uri + args[0]+".pdf"));
			}
		} catch (Exception e) {
			System.out.println("Error:");
			e.printStackTrace();
		}
	}// fin del main
	
	
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



