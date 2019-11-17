package teamrocket;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static EntityManager entityManager;

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("grajdolex-hibernate");

        entityManager = entityManagerFactory.createEntityManager();
    }
}