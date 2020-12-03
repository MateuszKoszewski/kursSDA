package HibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.projekt.praktyczny.kalkulator.walut.Currency;

import javax.persistence.NoResultException;
import java.util.Optional;

public class CalculatorHttpDb {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorHttpDb.class);
    private static final SessionFactory sessionFactory;

    static {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().
                configure("hibernate.cfg.xml").
                build();
        final Metadata metadata = new MetadataSources(registry)
                .buildMetadata();
        sessionFactory = metadata.buildSessionFactory();
    }

    public Currency findByDate(String date, String currency) {
        Session session = sessionFactory.openSession();
        Query<Currency> query = session.createQuery("FROM Currency c WHERE c.date = :date AND c.toCurrency = :currency", Currency.class);
        query.setParameter("date", date);
        query.setParameter("currency", currency);
        Currency value = null;
        try {
            value = query.getSingleResult();  //rownie dobrze mozna uzyc metody find
        } catch (NoResultException e){
//            LOGGER.error(e.getMessage());
        }

            session.close();
        return value;
    }

    public void addCurrency(Currency currency) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

            try {
                transaction = session.beginTransaction();
                session.save(currency);
                transaction.commit();
            } catch (RuntimeException e) {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
                LOGGER.error(e.getMessage());
            }
            session.close();
    }
}

