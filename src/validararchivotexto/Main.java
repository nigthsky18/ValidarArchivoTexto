
package validararchivotexto;

import javax.swing.JOptionPane;

public class Main {

    
    public static void main(String[] args) 
    {
        int opcion;
        Validar documento=new Validar();
        String archivo= "Archivo.txt";
        
        do
        {   
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """ 
                                                                     Ingresa una de las opciones
                                                                     1. Mostrar datos del archivo
                                                                     2. Validar datos
                                                                     3. Cambiar las "s" al final, por "c".
                                                                     0. Salir.
                                                                     """, "Menú Principal",3));
            switch(opcion)
            {
                case 1->
                {
                    documento.mostrarArchivo(archivo);
                }
                case 2->
                {
                    documento.validarDatos(archivo);
                }
                case 3->
                {
                    
                }
                case 0->{}
            }
        
    }while(opcion!=0);
    
    }
}
