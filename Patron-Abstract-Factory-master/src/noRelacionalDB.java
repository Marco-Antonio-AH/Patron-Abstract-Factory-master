import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import org.bson.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class noRelacionalDB implements conectar {

  MongoClient mongoClient = MongoClients.create();

  @Override
  public void conexion() {
    System.out.println("Conectando a la base de datos no relacional...");
    // System.out.println(mongoClient.getDatabase("no-relacional").getCollection("Alumnos"));

    mostrarTodo();
  }

  public void mostrarTodo() {
    Logger mongoLogger = Logger.getLogger("com.mongodb");
    mongoLogger.setLevel(Level.SEVERE);
    // Select the "people" collection
    MongoCollection<Document> collection = mongoClient.getDatabase("no-relacional").getCollection("Alumnos");

    System.out.println("Mostrando todos los elementos de la colección");

    // Performing a read operation on the collection.
    FindIterable<Document> fi = collection.find();
    MongoCursor<Document> cursor = fi.iterator();
    try {
      while (cursor.hasNext()) {
        System.out.println(cursor.next().toJson());
      }
    } finally {
      cursor.close();
    }
  }

}