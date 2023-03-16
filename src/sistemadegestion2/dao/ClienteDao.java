/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadegestion2.dao;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.util.StringUtils;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemadegestion2.models.Cliente;

/**
 *
 * @author usuario
 */
public class ClienteDao {
        String bd = "";
        String url = "jdbc:mysql://localhost:3306/cine";
        String user = "root";
        String password = "";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection cx = null;

    public ClienteDao() {
    }
    
    public void guardar(Cliente cliente){
            try {
                Class.forName(driver);
                cx = DriverManager.getConnection(url+bd, user, password);
                String sql = "INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `email`, `telefono`) "
                        + "VALUES (NULL, '"+cliente.getNombre()+"', '"+cliente.getApellido()+"', "
                        + "'"+cliente.getEmail()+"', '"+cliente.getTelefono()+"');";
                
                
                
                java.sql.Statement statement =  cx.createStatement();
                statement.execute(sql);
                
            } catch (Exception ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
    
    public List<Cliente> mostrar(){
        List<Cliente> listado = new ArrayList<>();
            try {
                Class.forName(driver);
                cx = DriverManager.getConnection(url+bd, user, password);
                
                String sql = "SELECT * FROM `clientes`;";
                
                
                
                java.sql.Statement statement =  cx.createStatement();
                ResultSet resultado = statement.executeQuery(sql);
                while (resultado.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setNombre(resultado.getString("nombre"));
                    cliente.setApellido(resultado.getString("apellido"));
                    cliente.setEmail(resultado.getString("email"));
                    cliente.setTelefono(resultado.getString("telefono"));
                    cliente.setId(resultado.getString("id"));
                    listado.add(cliente);
                    
                }
                
            } catch (Exception ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return listado;
    }
    
     public void eliminar(Cliente cliente){
            try {
                
                Class.forName(driver);
                cx = DriverManager.getConnection(url+bd, user, password);
                String sql = "DELETE FROM clientes WHERE `clientes`.`id` = " + cliente.getId();
                
                
                
                java.sql.Statement statement =  cx.createStatement();
                statement.execute(sql);
                
            } catch (Exception ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
     
     
     
      public void modificar(Cliente cliente){
            try {
                
                Class.forName(driver);
                cx = DriverManager.getConnection(url+bd, user, password);
                String sql = "UPDATE `clientes` SET `nombre` = '"+cliente.getNombre()
                        +"', `apellido` = '"+cliente.getApellido()+"', `email` = '"+cliente.getEmail()
                        +"', `telefono` = '"+cliente.getTelefono()+"' WHERE `clientes`.`id` = " 
                        +cliente.getId() + ";";
                
                
                
                java.sql.Statement statement =  cx.createStatement();
                statement.execute(sql);
                
            } catch (Exception ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }

    public void guardarOModifircar(Cliente cliente) {
        if (StringUtils.isEmptyOrWhitespaceOnly(cliente.getId())) {
            guardar(cliente);
        }else{
            modificar(cliente);
        }
 
    }
    
    
    
    public List<Cliente> verificar(){
        List<Cliente> listado = new ArrayList<>();
            try {
                Class.forName(driver);
                cx = DriverManager.getConnection(url+bd, user, password);
                
                String sql = "SELECT * FROM `clientes` WHERE nombre = "" AND telefono = "";";

                
                
                
                java.sql.Statement statement =  cx.createStatement();
                ResultSet resultado = statement.executeQuery(sql);
                while (resultado.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setNombre(resultado.getString("nombre"));
                    cliente.setApellido(resultado.getString("apellido"));
                    cliente.setEmail(resultado.getString("email"));
                    cliente.setTelefono(resultado.getString("telefono"));
                    cliente.setId(resultado.getString("id"));
                    listado.add(cliente);
                    
                }
                
            } catch (Exception ex) {
                Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return listado;
    }
   
    
    
}
