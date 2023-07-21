public class relational_factory implements conexion_factory {

  @Override
  public conectar getConnection() {
    return new relacionalDB();
  }

}