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
 *
 */
public class PrintPdf {
	
	/**
	 * 
	 * @param printer nombre del dispositivo
	 * @param files lista de argumentos de longitud variable a imprimir
	 */
	public static void printPdf( String device, File...files ){
		for (File f : files) {
			printFile(f, device);
		}		
	}
	
	/**
	 * 
	 * @param f archivo a imprimir
	 */
	private static void printFile(File f, String device) {
		try {	
			PDDocument pdf = PDDocument.load(f);
			PrinterJob job = PrinterJob.getPrinterJob();
			PDFPageable pdfPg = new PDFPageable(pdf);
			PrintService myPrintService = findPrintService(device);
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
