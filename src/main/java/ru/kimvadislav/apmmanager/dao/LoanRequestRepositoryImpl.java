package ru.kimvadislav.apmmanager.dao;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.kimvadislav.apmmanager.model.LoanRequest;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class LoanRequestRepositoryImpl implements LoanRequestRepository {
    @Override
    public void saveRequest(LoanRequest loanRequest) {
        Session session = new Configuration().configure().buildSessionFactory()
                .openSession();
        session.beginTransaction();
        session.save(loanRequest);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Optional<LoanRequest> findRequestById(Long id) {
        Session session = new Configuration().configure().buildSessionFactory()
                .openSession();
        session.beginTransaction();

        LoanRequest loanRequest = session.get(LoanRequest.class, id);

        session.getTransaction().commit();
        session.close();
        return Optional.of(loanRequest);
    }

    @Override
    public Optional<LoanRequest> findByPassportInfoAndLoanAmount(
            String passportSeries, String passportNumber, BigDecimal loanAmount) {

        String sql = "SELECT * FROM requests req " +
                "WHERE passportseries = :passportSeries " +
                "AND passportnumber = :passportNumber " +
                "AND loanamount = :loanAmount";

        Session session = new Configuration().configure().buildSessionFactory()
                .openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(sql)
                .setParameter("passportSeries", passportSeries)
                .setParameter("passportNumber", passportNumber)
                .setParameter("loanAmount", loanAmount)
                .addEntity(LoanRequest.class);
        LoanRequest loanRequest = (LoanRequest) query.getSingleResult();

        session.getTransaction().commit();
        session.close();

        return Optional.of(loanRequest);
    }

    @Override
    public List<LoanRequest> findAll() {
        String sql = "SELECT * FROM requests";

        Session session = new Configuration().configure()
                .buildSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(sql)
                .addEntity(LoanRequest.class);

        return query.getResultList();
    }

    @Override
    public List<LoanRequest> findRequestByPhoneNumber(String data) {
        String sql = "SELECT * FROM requests " +
                "WHERE phonenumber = :phoneNumber";

        Session session = new Configuration().configure()
                .buildSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(sql)
                .setParameter("phoneNumber", data)
                .addEntity(LoanRequest.class);
        List<LoanRequest> loanRequest = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return loanRequest;
    }

    @Override
    public List<LoanRequest> findRequestByFio(String name, String surname, String patronymic) {
        String sql = "SELECT * FROM requests " +
                "WHERE name = :name " +
                "AND surname = :surname " +
                "AND patronymic = :patronymic";

        Session session = new Configuration().configure()
                .buildSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(sql)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .setParameter("patronymic", patronymic)
                .addEntity(LoanRequest.class);
        List<LoanRequest> loanRequest = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return loanRequest;
    }

    @Override
    public LoanRequest findRequestByPassportData(String passportSeries, String passportNumber) {
        String sql = "SELECT * FROM requests " +
                "WHERE passportseries = :passportSeries " +
                "AND passportnumber = :passportNumber";

        Session session = new Configuration().configure()
                .buildSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(sql)
                .setParameter("passportSeries", passportSeries)
                .setParameter("passportNumber", passportNumber)
                .addEntity(LoanRequest.class);
        LoanRequest loanRequest = (LoanRequest) query.getSingleResult();

        session.getTransaction().commit();
        session.close();

        return loanRequest;
    }
}
