package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.vo.Requerimiento_1Vo;

import util.JDBCUtilities;

public class Requerimiento_1Dao {

    public ArrayList<Requerimiento_1Vo> requerimiento_1() throws SQLException {
       
        ArrayList<Requerimiento_1Vo> respuesta = new ArrayList<Requerimiento_1Vo>();
        Connection conn = JDBCUtilities.getConnection();

        try{
            
            String consulta =   "SELECT l.ID_Lider, l.Nombre, l.Primer_Apellido, l.Salario "+
                                "FROM Lider l "+
                                "WHERE (l.Salario > (Select AVG(Salario) FROM Lider l) "+
                                "ORDER BY Salario DESC; ";
            PreparedStatement statement = conn.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Requerimiento_1Vo requerimiento_1 = new Requerimiento_1Vo();
                requerimiento_1.setID_Lider(resultSet.getInt("ID_Lider"));
                requerimiento_1.setNombre(resultSet.getString("Nombre"));
                requerimiento_1.setPrimer_Apellido(resultSet.getString("Primer_Apellido"));
                requerimiento_1.setSalario(resultSet.getInt("Salario"));
                
                respuesta.add(requerimiento_1);
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