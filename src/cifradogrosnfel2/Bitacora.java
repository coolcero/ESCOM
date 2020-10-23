
package cifradogrosnfel2;

import java.sql.Connection;
import java.sql.Statement;


public class Bitacora {

    public void enviarBitacora(String operacion, String descripcion){
    
        Connection connection;
        Conexion conexion = new Conexion();
        conexion.conectar();
        connection = conexion.getConnetion();
        
        
        try{
<<<<<<< HEAD
            Statement stm = connection.createStatement(); 
            //comentario
=======
            Statement stm = connection.createStatement();//empezamos
>>>>>>> 51e0a9688a3bb66b7fd15489c7f5a769c98c6d41
            stm.executeUpdate("INSERT INTO public.bitacora(fecha, operacion, descripcion) "
                            + "VALUES ((select now()) ,'" + operacion + "', '" + descripcion + "')");
                    
            
           }
        
        catch(Exception ex){
            System.out.println("Error en sql:"+ ex.getMessage());
    
    
         }finally{
        
        
        conexion.desconectar();
        }
        
    
}
}
