package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.vo.Requerimiento_3Vo;
import util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3Vo> requerimiento3() throws SQLException {
        
        ArrayList<Requerimiento_3Vo> respuesta = new ArrayList<Requerimiento_3Vo>();
        
        Connection conn = JDBCUtilities.getConnection();

        try{
            
            String consulta =   "SELECT p.ID_Proyecto, p.Ciudad, l.Nombre "+
                                "FROM Proyecto p JOIN Lider l "+
                                "ON(l.ID_Lider =p.ID_Lider) "+ 
                                "WHERE p.ID_Proyecto BETWEEN 1 AND 30; "; 
            
            PreparedStatement statement = conn.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Requerimiento_3Vo requerimiento_3 = new Requerimiento_3Vo();
                requerimiento_3.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                requerimiento_3.setCiudad(resultSet.getString("Ciudad"));
                requerimiento_3.setNombre(resultSet.getString("Nombre"));
                                
                respuesta.add(requerimiento_3);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error consultando: "+e);

        }finally{
            if(conn != null) {
            conn.close();
            }
        }
        return respuesta;
    }
}