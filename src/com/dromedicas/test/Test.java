package com.dromedicas.test;

public class Test {

	public static void main(String[] args) {
		String[] files = {"factura.txt", 
						  "facturaP1.pdf", 
						  "factura1.txt", 
						  "facturaP2.pdf", 
						  "facturaP3.pdf"};
		
		
		System.out.println("Archivos recibidos");
		System.out.print("[ ");
		for(String ele: files )
			System.out.print(" " +ele+ " ");
		System.out.print("  ]");
		System.out.println("");
		
		String temp[];
		int contadorTXT = 0;
		int contadorPDF = 0;
		
		
		for(int i = 0; i < files.length; i++){
			temp =files[i].split("\\.(?=[^\\.]+$)");		
			
			System.out.println(">" + temp[1]);
			
			if(temp[1].equals("txt"))
				contadorTXT++;
			else
				if(temp[1].equals("pdf"))
					contadorPDF++;
		}
		
		System.out.println("Total Recibos TXT: " + contadorTXT + " Total PDF: " + contadorPDF);
		

	}

}
