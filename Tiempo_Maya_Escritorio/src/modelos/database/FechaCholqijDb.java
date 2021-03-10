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
import modelos.objetos.FechaCholqij;

/**
 *
 * @author jose_
 */
public class FechaCholqijDb {

    public void crear(FechaCholqij fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO calendariocholqij "
                    + "(nahual,energia,fecha,descripcion) VALUES (?,?,?,?);");
            statement.setInt(1,fecha.getNahual().getId());
            statement.setInt(2, fecha.getEnergia().getId());
            statement.setDate(3, fecha.getFecha());
            statement.setString(4, fecha.getDescripcion());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void modificar(FechaCholqij fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE calendariocholqij "
                    + "SET nahual=?, energia=?, fecha=?, descripcion=? WHERE id=?;");
            statement.setInt(1,fecha.getNahual().getId());
            statement.setInt(2, fecha.getEnergia().getId());
            statement.setDate(3, fecha.getFecha());
            statement.setString(4, fecha.getDescripcion());
            statement.setInt(5, fecha.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminar(FechaCholqij fecha){
        try{
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM calendariocholqij WHERE id=?;");
            statement.setInt(1, fecha.getId());
            statement.executeUpdate();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public FechaCholqij getFecha(int id) {
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM calendariocholqij WHERE id=?;");
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if(resultado.next()) return instanciarDeResultSet(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<FechaCholqij> getFechas(){
        List<FechaCholqij> fechas = new ArrayList();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM calendariocholqij;");
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()) fechas.add(instanciarDeResultSet(resultado));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fechas;
    }
    
    private FechaCholqij instanciarDeResultSet(ResultSet resultado) throws SQLException{
        NahualDb accesoNahual = new NahualDb();
        EnergiaDb accesoEnergia = new EnergiaDb();
        return new FechaCholqij(
                resultado.getInt("id"),
                accesoNahual.getNahual(resultado.getInt("nahual")),
                accesoEnergia.getEnergia(resultado.getInt("energia")),
                resultado.getDate("fecha"),
                resultado.getString("descripcion")
        );
    }
}
