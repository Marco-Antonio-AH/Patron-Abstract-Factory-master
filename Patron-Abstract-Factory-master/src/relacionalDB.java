
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class relacionalDB implements conectar {

  @Override
  public void conexion() {
    System.out.println("Conectando a la tabla relacional...");
    con();
  }

  Connection conectar = null;

  public Connection con() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conectar = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/relacional", "root", "");
      System.out.println("Conexión aceptada...");

      // our SQL SELECT query.
      // if you only need a few columns, specify them by name instead of using "*"
      String query = "SELECT * FROM alumnos";

      // create the java statement
      Statement st = conectar.createStatement();

      // execute the query, and get a java resultset
      ResultSet rs = st.executeQuery(query);

      // iterate through the java resultset
      while (rs.next()) {

        String firstName = rs.getString(1);
        int edad = rs.getInt(2);

        // print the results
        System.out.println("Nombre: " + firstName + " Edad: " + edad);
      }
      st.close();

    } catch (Exception e) {
      System.out.println("Mensaje de error: " + e);
      JOptionPane.showMessageDialog(null, "No se pudo conectar");
    }
    return conectar;
  }

}
