/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.database.ConexionDb;
import api.login.Login;

/**
 *
 * @author luisGonzalez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            //INICIAMOS CONECTANDO  DB  
            ConexionDb.obtenerConexion();
            
//            Usuario user  = new Usuario();
//            MenuPrincipal menu = new MenuPrincipal(user);
//            menu.setVisible(true);
/*
            Comenté el login dado que entiendo, se usa para realizar ciertas actividades (aceptar hechos
            agregarlos) pero la funcionalidad del sistema en sí es abierto, habría que agregar una opcion
            pero no obligar a iniciar sesion ¿no? xd
*/

            Login logeo = new Login();
            logeo.iniciar();
            //logeo.setVisible(true);
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
