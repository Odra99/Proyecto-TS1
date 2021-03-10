/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.objetos.FechaRuedaCalendarica;

/**
 *
 * @author jose_
 */
public class FechaRuedaCalendaricaDb {
    
    public void crear(FechaRuedaCalendarica fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO ruedacalendarica"
                    + "(idFechaHaab,idFechaCholqij,Descripcion) VALUES (?,?,?);");
            statement.setInt(1, fecha.getFechaHaab().getId());
            statement.setInt(2, fecha.getFechaCholqij().getId());
            statement.setString(3, fecha.getDescripcion());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void modificar(FechaRuedaCalendarica fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE ruedacalendarica SET"
                    + "idFechaHaab=?, idFechaCholqij=?, descripcion=? WHERE id=?;");
            statement.setInt(1, fecha.getFechaHaab().getId());
            statement.setInt(2, fecha.getFechaCholqij().getId());
            statement.setString(3, fecha.getDescripcion());
            statement.setInt(4, fecha.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminar(FechaRuedaCalendarica fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM ruedacalendarica WHERE id=?;");
            statement.setInt(1, fecha.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<FechaRuedaCalendarica> getFechas(){
        List<FechaRuedaCalendarica> fechas = new ArrayList();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM ruedacalendarica;");
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()) fechas.add(instanciarDeResultSet(resultado));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fechas;
    }
    
    public FechaRuedaCalendarica getFecha(int id){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM ruedacalendarica WHERE id=?;");
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if(resultado.next()) return instanciarDeResultSet(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    private FechaRuedaCalendarica instanciarDeResultSet(ResultSet resultado) throws SQLException{
        FechaHaabDb accesoHaab = new FechaHaabDb();
        FechaCholqijDb accesoCholqij = new FechaCholqijDb();
        return new FechaRuedaCalendarica(
                resultado.getInt("id"),
                accesoHaab.getFecha(resultado.getInt("idFechaHaab")),
                accesoCholqij.getFecha(resultado.getInt("idFechaCholqij")),
                resultado.getString("descripcion")
        );
    }
}
