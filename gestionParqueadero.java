/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parquedero;
import javax.swing.*;
/**
 *
 * @author hebertromero
 */
public class gestionParqueadero {
    
     cuposParquedero parquea = new cuposParquedero();

    /**
     * Método para parquear un carro:
     * Primero se verifica que existan puestos disponibles. Si hay puestos 
     * se piden los datos del carro y se parquea.
     * En caso de no tener puestos disponibles se muestra un mensaje indicando esto.
     */
    public void parquearCarro() 
    {
            String placa = JOptionPane.showInputDialog("Placa del carro:");
            // Verifica que el carro ya no esté parqueadao
            if (parquea.buscarCarro(placa) == null) 
            {
                String marca = JOptionPane.showInputDialog("Marca del carro:");
                String modeloCadena = JOptionPane.showInputDialog("Modelo del carro:");
                int modelo = Integer.parseInt(modeloCadena);
                Autos nuevo = new Autos(placa, marca, modelo);
                boolean pudoParquear = parquea.parquearCarro(nuevo);
                if (pudoParquear) 
                {
                   JOptionPane.showMessageDialog(null,"El carro fue parqueado exitosamente.");
                }
                else 
                {
                    JOptionPane.showMessageDialog(null,"No fue posible parquear el carro. Intente más tarde");
                }
            }
            else 
            {
                JOptionPane.showMessageDialog(null,"Ya hay un carro parqueado con esa placa.");
            }
    }
    
    /**
     * Método que permite buscar un carro en el parqueadero y mostrar sus datos.
     * Para buscar el carro es necesario solicitar al usuario la placa.
     * Si el carro no se encuentra se debe mostrar un mensaje indicando esto.
     */
    public void buscarCarro() {
        String placa = JOptionPane.showInputDialog("Placa del carro:");
        Autos carro = parquea.buscarCarro(placa);
        if (carro == null) 
        {
            JOptionPane.showMessageDialog(null,"No se encuentra parqueado un carro con esa placa");
        }
        else
        {
             JOptionPane.showMessageDialog(null,"Los datos del carro son:  \n" +
                                    "Placa: "+ carro.getPlaca() + "\n"+
                                    "Marca: "+ carro.getMarca());
        }
    }

    /**
     * Método que permite sacar un carro del parqueadero.
     * Para sacar el carro se debe pedir la placa y luego se debe mostrar un mensaje
     * indicando si fue posible sacar el carro o si no se encontraba en el parqueadero. 
     */
    public void sacarCarro() {
        String placa = JOptionPane.showInputDialog("Placa del carro:");
        boolean pudoSacar = parquea.sacarCarro(placa);
        if (pudoSacar) 
        {
            JOptionPane.showMessageDialog(null,"El carro se retiró del parqueadero exitosamente");
        }
        else 
        {
            JOptionPane.showMessageDialog(null,"No se encuentra parqueado un carro con esa placa");
        }
    }

    /**
     * Método que muestra el menú del parqueadero al usuario, para que seleccione
     * lo que desea realizar: parquear un carro, buscar un carro o sacar un carro.
     */
    public void menu() {
        
        int opcion=-1;
        do {
            // Menú con las opciones disponibles
            String valorSeleccionado = 
            JOptionPane.showInputDialog(" ---- MENU PARQUEADERO ---  \n" +
                        "1.Parquear un carro    \n" +
                        "2.Buscar un carro  \n" +
                        "3.Sacar un carro   \n" +
                        "0.Terminar     \n\n" +
                        "Opción seleccionada: ");
            try 
            {
                opcion = Integer.parseInt(valorSeleccionado);
                switch (opcion){
                    // Opcion 1: Parquear un carro
                    case 1: parquearCarro();
                            break;
                    
                    // Opcion 2: Buscar un carro y mostrar sus datos 
                    case 2: buscarCarro();
                            break;
                    
                    // Opcion 3: Sacar un carro del parqueadero
                    case 3: sacarCarro();
                            break;
    
                    case 0: break;
                    
                    default: JOptionPane.showMessageDialog(null,"Opción no disponible");    
                }
            }
            catch (NumberFormatException errorIngreso)
            {
                JOptionPane.showMessageDialog(null,"Dato ingresado incorrecto. Debe ser numérico");   
            }
        }
        while (opcion != 0);
        JOptionPane.showMessageDialog(null," - Terminación exitosa -");

    }

    
    
    
    
    
}
