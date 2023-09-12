/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validararchivotexto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Mariana M
 */
public class Validar {

    public void mostrarArchivo(String archivo) {
        String linea;
        try ( BufferedReader leer = new BufferedReader(new FileReader(archivo)))
        {

            while ((linea = leer.readLine()) != null)
            {
                System.out.println(linea + "\n");
            }
            leer.close();

        } catch (IOException e)
        {
            e.printStackTrace();

        }

    }

    public String validarCorreo(String correo) {

        String resultado = "\nCorreo: ";
        String codicion = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,3}$";

        Pattern patron = Pattern.compile(codicion);
        if (patron.matcher(correo).matches())
        {
            resultado = resultado + correo + "   -->Válido!";
        } else
        {
            resultado = resultado + correo + "  -->Inválido -->X";
        }
        return resultado;
    }

    public String validarTelefono(String telefono) {
        String resultado = "\nTeléfono: ", codicion = "^[3] +\\d{9}$";
        Pattern patron = Pattern.compile(codicion);

        if (patron.matcher(telefono).matches())
        {
            resultado = resultado + telefono + "   -->Válido!";
        } else
        {
            resultado = resultado + telefono + "  -->Inválido -->X";
        }
        return resultado;
    }

    public String validarMaterias(String materia) {
        String resultado = "\nMateria: ";
        String codicion = "^(ING)\\d{4,8}$";
        Pattern patron = Pattern.compile(codicion);

        if (patron.matcher(materia).matches())
        {
            resultado = resultado + materia + "   -->Válido!";
        } else
        {
            resultado = resultado + materia + "  -->Inválido -->X";
        }
        return resultado;
    }

    public String validarHoraNacimiento(String hora) {
        String resultado = "\nHora de nacimiento: ";
        String codicion = "^(0[1-9]|1[0-2]):[0-5][0-9] (PM|AM)$";
        Pattern patron = Pattern.compile(codicion);

        if (patron.matcher(hora).matches())
        {
            resultado = resultado + hora + "   -->Válido!";
        } else
        {
            resultado += hora + "  -->Inválido -->X";
        }
        return resultado;
        
    }

    public String validarFechaNacimiento(String fecha) {
        String resultado = "\nHora de nacimiento: ";
        String codicion = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        Pattern patron = Pattern.compile(codicion);

        if (patron.matcher(fecha).matches())
        {
            resultado = resultado + fecha + "   -->Válido!";
        } else
        {
            resultado += fecha + "  -->Inválido -->X";
        }
        return resultado;

    }

    public void validarUsuario() {

    }

    public void validarContraseña() {

    }

    public void validarDatos(String archivo) {

        try ( BufferedReader leer = new BufferedReader(new FileReader(archivo)))
        {

            String linea = leer.readLine(); //toma cada linea del archivo

            while (linea != null) //mientras haya lineas
            {
                
                String[] campos = linea.split(",|;"); //vector con cada uno de los datos del usuario
                mostrarInformacion(campos);

                linea = leer.readLine();// Leer la siguiente línea 
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void mostrarInformacion(String[] s) {
        String concatenar = "";
        int i;
        for (i = 0; i <= 8; i++)
        {
            switch (i)
            {
                case 0->
                {
                 String nombre= s[0];
                 nombre= nombre.replaceAll("\\s+"," ");
                 concatenar= nombre;                     
                }
                case 1 ->
                {
                    String telefono = s[1].trim();
                    concatenar = concatenar + validarTelefono(telefono);
                }
                case 2 ->
                {
                    String correo = s[2].trim();
                    concatenar = concatenar + validarCorreo(correo);

                }
                case 3 ->
                {
                    String materia1 = s[3].trim();// trim() funcion para eliminar espacios 
                    String materia2 = s[4].trim();
                    concatenar = concatenar + validarMaterias(materia1);
                }
                case 4 ->
                {
                    String materia2 = s[4].trim();
                    concatenar = concatenar + validarMaterias(materia2);
                }
                case 5 ->
                {
                   String fechaNacimiento=s[5].trim();
                   concatenar+= validarFechaNacimiento(fechaNacimiento);
                }
                case 6 ->
                {
                   String hora=s[6].trim();
                   concatenar+= validarHoraNacimiento(hora);
                    
                }

            }
        }
        JOptionPane.showMessageDialog(null, concatenar, "Información de usuario", 3);
    }
}
