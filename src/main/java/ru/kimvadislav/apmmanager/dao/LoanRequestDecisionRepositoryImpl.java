package ru.kimvadislav.apmmanager.dao;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.kimvadislav.apmmanager.model.LoanContract;
import ru.kimvadislav.apmmanager.model.LoanRequestDecision;

import javax.persistence.Query;
import java.util.List;

@Repository
public class LoanRequestDecisionRepositoryImpl implements LoanRequestDecisionRepository {
    @Override
    public void saveDescision(LoanRequestDecision loanRequestDecision) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        session.beginTransaction();
        session.save(loanRequestDecision);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<LoanRequestDecision> findAllRequestsWithAproval() {
        String sql = "SELECT * FROM requestsdecision WHERE decision = true";

        Session session = new Configuration().configure()
                .buildSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(sql)
                .addEntity(LoanRequestDecision.class);
        List<LoanRequestDecision> loanRequestDecisions = query.getResultList();

        session.getTransaction().commit();
        session.close();
        return loanRequestDecisions;
    }

    @Override
    public List<LoanRequestDecision> findAll() {
        String sql = "SELECT * FROM requestsdecision";

        Session session = new Configuration().configure()
                .buildSessionFactory().openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(sql)
                .addEntity(LoanRequestDecision.class);
        List<LoanRequestDecision> loanRequestDecisions = query.getResultList();

        session.getTransaction().commit();
        session.close();

        return loanRequestDecisions;
    }
}
