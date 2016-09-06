# Controlador para impresoras POS

Aplicacion Java para imprimir documentos .pdf y .txt para impresoras POS. Principalmente desarrollada para [Dromedicas del Oriente](http://www.dromedicas.com.co/).
Fue desarrollada para imprimir documentos documentos desde **PHP** sin vista previa; principalmente desde la solucion DROPOS.

### Implementación

Para ser usada es requerida algunas librerias adicionales como [Apache PDFBox](https://pdfbox.apache.org/).
Para su uso implemente la variable de entorno **Java** en su entorno **PHP** asi:

_Implementacion Variable Java en app **PHP**_

```php
<?
    $JAVA_HOME = "C:/Program Files/Java/jre7";
        $PATH = "$JAVA_HOME/bin";
        putenv("JAVA_HOME=$JAVA_HOME");
        putenv("PATH=$PATH");
 		$output = shell_exec("java -version 2>&1");
 		echo $output;
?>
```

Este **.jar** debe ser invocado donde configuro su varible de entorno. 
```php
<?
   $printcmd = "java -jar C:/AppServ/www/dropos/lib/controladorimp.jar 2>&1 venta.pdf factura.txt";
        
   system($printcmd);
?>
```
### Ventajas

  Algunas de sus ventajas:
  * No requiere parametros especiales por tipo de archivo.
  * Recibe lotes de archivos ( *.txt *.pdf).
  * No genera previsualizacion del documento.
