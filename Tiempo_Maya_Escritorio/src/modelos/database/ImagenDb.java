/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.objetos.Imagen;

/**
 *
 * @author jose_
 */
public class ImagenDb {
    
    public void crear(Imagen imagen){}
    public void modificar(Imagen imagen){}
    public void eliminar(int id){}
    
    public Imagen getImagen(int id){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM rutaImagen WHERE id=?;");
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if(resultado.next()) return instanciarDeResultSet(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    private Imagen instanciarDeResultSet(ResultSet resultado) throws SQLException{
        return new Imagen(
                resultado.getInt("id"),
                resultado.getString("dirWeb"),
                resultado.getString("dirEscritorio"),
                resultado.getString("categoria")
        );
    }
}
