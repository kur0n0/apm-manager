package ru.kimvadislav.apmmanager.dao;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.kimvadislav.apmmanager.model.LoanContract;

import javax.persistence.Query;
import java.util.Date;
import java.util.Optional;

@Repository
public class LoanContractRepositoryImpl implements LoanContractRepository {
    @Override
    public void saveContract(LoanContract loanContract) {
        Session session = new Configuration().configure()
                .buildSessionFactory().openSession();
        session.beginTransaction();
        session.save(loanContract);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Optional<LoanContract> findContractById(Long id) {
        Session session = new Configuration().configure()
                .buildSessionFactory().openSession();
        session.beginTransaction();

        LoanContract loanContract = session.get(LoanContract.class, id);

        session.getTransaction().commit();
        session.close();

        return Optional.of(loanContract);
    }

    @Override
    public void signContract(Long id) {
        String sql = "UPDATE contracts " +
                "SET signdate = :signDate, " +
                "issigned = true " +
                "WHERE loanrequestid = :id";

        Session session = new Configuration().configure()
                .buildSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(sql)
                .setParameter("signDate", new Date())
                .setParameter("id", id);
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
