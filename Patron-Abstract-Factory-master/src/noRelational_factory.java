public class noRelational_factory implements conexion_factory {

  @Override
  public conectar getConnection() {
    return new noRelacionalDB();
  }

}