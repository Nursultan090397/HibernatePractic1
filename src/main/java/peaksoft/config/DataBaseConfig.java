package peaksoft.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.models.Client;

import java.util.Properties;

public class DataBaseConfig {

    public static SessionFactory createSessionFactory(){
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");

        properties.put(Environment.URL, "jdbc:postgresql://localhost:2022/postgres");

        properties.put(Environment.USER, "postgres");

        properties.put(Environment.PASS, "081262");

        properties.put(Environment.HBM2DDL_AUTO, "create");

        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");

        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Client.class);

        return configuration.buildSessionFactory();

    }
    public static EntityManagerFactory createdEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("peaksoft");
    }
}
