package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
       
        ArrayList<Requerimiento_2Vo> respuesta = new ArrayList<Requerimiento_2Vo>();
       
        Connection conn = JDBCUtilities.getConnection();

        try{
            
            String consulta = "SELECT p.ID_Proyecto, mc.Nombre_Material "+
                            "FROM Proyecto p JOIN Compra c ON (p.ID_Proyecto=c.ID_Proyecto) "+
                            "JOIN MaterialConstruccion mc ON (c.ID_MaterialConstruccion=mc.ID_MaterialConstruccion) "+
                            "WHERE (p.ID_Proyecto IN (12,15,18)) "+
                            "ORDER BY p.ID_Proyecto DESC; "; 

            PreparedStatement statement = conn.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Requerimiento_2Vo requerimiento_2 = new Requerimiento_2Vo();
                requerimiento_2.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                requerimiento_2.setNombre_Material(resultSet.getString("Nombre_Material"));
                                
                respuesta.add(requerimiento_2);
            }
            resultSet.close();
            statement.close();

        } catch(SQLException e) {
            System.out.println("Error consultando: "+e);

        }finally{
            if(conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }   
}
        