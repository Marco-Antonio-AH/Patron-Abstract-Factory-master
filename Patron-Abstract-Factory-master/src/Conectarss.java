import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conectarss {
    Connection conectar = null;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/juego_1", "root", "");
            System.out.println("Conexión aceptada...");

        } catch (Exception e) {
            System.out.println("Mensaje de error: " + e);
            JOptionPane.showMessageDialog(null, "No se pudo conectar");
        }
        return conectar;
    }

    public void guardar(String nombre, int nivel) {
        try {
            String instruccion = "INSERT INTO `personajes` (`Nombre`, `Nivel`) VALUES ('" +
                    nombre + "', '" +
                    nivel + "')";
            System.out.println(instruccion);
            Statement st = conectar.createStatement();
            st.executeUpdate(instruccion);
        } catch (Exception e) {
            System.out.println("Mensaje de error: " + e);
        }

    }
}
