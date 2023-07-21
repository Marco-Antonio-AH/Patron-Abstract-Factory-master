import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class test {

    public enum DatabaseType {
        Relacional, No_Relacional;
    }

    public static void main(String[] args) {

        // We should fetch the database type from an
        // external resource (ex: configuration file).
        // In order to keep this example simple we will
        // use a private static method and an Enum
        DatabaseType databaseType = DatabaseType.valueOf(type());
        conexion_factory connectionFactory = getConnectionFactory(databaseType);

        aplicacion application = new aplicacion(connectionFactory);
        application.start();
    }

    private static conexion_factory getConnectionFactory(

            DatabaseType databaseType) {
        switch (databaseType) {
            case Relacional:
                return new relational_factory();
            case No_Relacional:
                return new noRelational_factory();
            default:
                return new noRelational_factory();

        }
    }

    public static String type() {

        String databaseType = "";
        try (InputStream input = test.class.getClassLoader().getResourceAsStream("database.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Lo siento, no se encontró database.properties");
                return "";
            }

            prop.load(input);

            databaseType = prop.getProperty("jdbc.databaseType");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return databaseType;
    }

}