public class aplicacion {

  private final conexion_factory connectionFactory;

  public aplicacion(conexion_factory connectionFactory) {
    this.connectionFactory = connectionFactory;
  }

  public void start() {
    conectar connection = connectionFactory.getConnection();
    connection.conexion();
    // proceder a la ejecución de la aplicación...
  }

}