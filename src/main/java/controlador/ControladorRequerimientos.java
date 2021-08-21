package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import modelo.dao.Requerimiento_1Dao;
import modelo.dao.Requerimiento_2Dao;
import modelo.dao.Requerimiento_3Dao;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import modelo.vo.Requerimiento_3Vo;

public class ControladorRequerimientos {
    
    private final Requerimiento_1Dao REQUERIMIENTO_1DAO;
    private final Requerimiento_2Dao REQUERIMIENTO_2DAO;
    private final Requerimiento_3Dao REQUERIMIENTO_3DAO;

    public ControladorRequerimientos(){
        this.REQUERIMIENTO_1DAO= new Requerimiento_1Dao();
        this.REQUERIMIENTO_2DAO= new Requerimiento_2Dao();
        this.REQUERIMIENTO_3DAO= new Requerimiento_3Dao();
    }

    public ArrayList<Requerimiento_1Vo> consultarRequerimiento1() throws SQLException {
        return this.REQUERIMIENTO_1DAO.requerimiento_1();
    }

    public ArrayList<Requerimiento_2Vo> consultarRequerimiento2() throws SQLException {
        return this.REQUERIMIENTO_2DAO.requerimiento2();
    }

    public ArrayList<Requerimiento_3Vo> consultarRequerimiento3() throws SQLException {
        return this.REQUERIMIENTO_3DAO.requerimiento3();
    }
}
