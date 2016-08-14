/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parquedero;

/**
 *
 * @author hebertromero
 */
public class cuposParquedero {
    
    private Autos[] carros = new Autos[20];

 /**
  * Método para parquear un carro.
  * Se busca una posición disponible y si se encuentra se guarda 
  * el carro y se retorna true, indicando que se pudo parquear. 
  * Si no se encuentra ninguna posición disponible se retorna false,
  * indicado que no se pudo parquear el carro.
  * @param carro el carro que se desea parquear
  * @return  true si se pudo parquear o false en caso contrario
  */
 public boolean parquearCarro(Autos carro) 
 {
        for (int i = 0; i < carros.length; i++) 
        {
                      if (carros[i] == null)
                      {
                       carros[i] = carro;
                       return true;
                      }
        }
  return false;
 }
 

 /**http://javayotros.blogspot.com/
  * Método para sacar un carro del parqueadero, dada su placa.
  * Si se encuentra el carro se retira del parqueadero y 
  * se retorna true, indicando que si se pudo sacar el carro.
  * Si  no se encuentra el carro, se retorna false.
  * @param placa la placa del carro que se desea sacar del paqueadero
  * @return  true si se pudo sacar el carro o false en caso contrario
  */
 public boolean sacarCarro(String placa)
 {
        for (int i = 0; i < carros.length; i++) 
        {
                if (carros[i] != null)
                {
                            if (carros[i].getPlaca().equals(placa))
                            {
                                carros[i] = null;
                                return true;
                            }
                }
        }
    return false;
 }
 
 
 /**
  * Método para buscar un carro en el parqueadero, dada la placa.
  * @param placa la placa del carro que se desea buscar
  * @return  el carro (si se encuentra) o null si no se encuentra
  */
 public Autos buscarCarro(String placa)
 {
            for (int i = 0; i < carros.length; i++) 
            {
                    if (carros[i] != null)
                    {
                            if (carros[i].getPlaca().equals(placa))
                            {
                                   return carros[i];
                            }
                    }
            }
  return null;
 }

  

    
}
