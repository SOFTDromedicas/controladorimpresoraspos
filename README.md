# Controlador para impresoras POS

Aplicacion Java para imprimir documentos .pdf y .txt. Desarrollada por [Dromedicas del Oriente](http://www.dromedicas.com.co/).
Su principal funcion es imprimir documentos desde **PHP** sin vista previa.

### Implementación

Desarrollada con base en [Apache PDFBox](https://pdfbox.apache.org/).
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
