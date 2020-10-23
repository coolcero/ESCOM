
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
            Statement stm = connection.createStatement();//empezamos
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
