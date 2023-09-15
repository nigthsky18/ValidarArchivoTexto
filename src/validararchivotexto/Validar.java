/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validararchivotexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
        String resultado = "\nTeléfono: ", codicion = "^[3]+\\d{9}$";
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
        String codicion = "^(ING)\\d{4}$";
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
        String codicion = "^(0[1-9]|1[0-2]):[0-5][0-9] (PM|AM)$"; //HH:MM AM|PM
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
        String resultado = "\nFecha de nacimiento: ";
        String codicion = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$"; //DD/MM/AAAA
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

    public String validarUsuario(String usuario) {
        String resultado = "\nUsuario: ";
        String codicion = "^[\\w]{6,15}";
        Pattern patron = Pattern.compile(codicion);

        if (patron.matcher(usuario).matches())
        {
            resultado = resultado + usuario + "   -->Válido!";
        } else
        {
            resultado += usuario + "  -->Inválido -->X";
        }
        return resultado;

    }

    public String validarContraseña(String contraseña) {
        String resultado = "\nContraseña: ";
        String codicion = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$";
        Pattern patron = Pattern.compile(codicion);

        if (patron.matcher(contraseña).matches())
        {
            resultado = resultado + contraseña + "   -->Válido!";
        } else
        {
            resultado += contraseña + "  -->Inválido -->X";
        }
        return resultado;

    }

    public void validarDatos(String archivo, boolean b) {

        try ( BufferedReader leer = new BufferedReader(new FileReader(archivo)))
        {

            String linea = leer.readLine(); //toma cada linea del archivo

            while (linea != null) //mientras haya lineas
            {

                String[] campos = linea.split(",|;"); //vector con cada uno de los datos del usuario
                if (!b) //si es la op 2
                {
                    mostrarInformacion(campos);
                } else //si es la op 3
                {
                    //editarArchivo(linea);
                }

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
                case 0 ->
                {
                    String nombre = s[0];
                    nombre = nombre.replaceAll("\\s+", " ");
                    concatenar = nombre;
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
                    String fechaNacimiento = s[5].trim();
                    concatenar += validarFechaNacimiento(fechaNacimiento);
                }
                case 6 ->
                {
                    String hora = s[6].trim();
                    concatenar += validarHoraNacimiento(hora);

                }
                case 7 ->
                {
                    String usuario = s[7].trim();
                    concatenar += validarUsuario(usuario);
                }
                case 8 ->
                {
                    String contraseña = s[8].trim();
                    concatenar += validarContraseña(contraseña);

                }

            }
        }
        JOptionPane.showMessageDialog(null, concatenar, "Información de usuario", 3);
    }

//    public void editarArchivo(String linea)  {
//
//        String[] campos = linea.split(",|;");
//        String[] lineas = new String[8];
//        try{
//        BufferedWriter bw = new BufferedWriter(new FileWriter("Archivo.txt"));     
//        for (int i = 0; i < 8; i++)
//        {
//            switch (i)
//            {
//                case 0, 7,8 ->
//                {
//                        campos[i] = campos[i].replaceAll("s$", "c");
//                }
//            }
//            
//            bw.write(linea);
//            bw.newLine();
//        
//        
//        
//        }
//        bw.close();
//        }catch(IOException e)
//        {
//           e.printStackTrace();
//        }
//
//    }
}
