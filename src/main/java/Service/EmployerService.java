package Service;

import Dao.EmployerDAO;
import Models.Employer;
import Util.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class EmployerService extends SessionUtil implements EmployerDAO {
    public void add(Employer employer) {
        openTransactionSession();

        Session session = getSession();
        session.save(employer);

        closeTransactionSession();
    }

    public Employer getByID(Long id) {
        openTransactionSession();

        Session session = getSession();
        Criteria criteria = session.createCriteria(Employer.class);
        criteria.add(Restrictions.eq("id",id));

        Employer employer = (Employer) criteria.uniqueResult();

        closeTransactionSession();

        return employer;
    }

    public List<Employer> getAll() {
        openTransactionSession();

        Session session = getSession();
        Criteria criteria = session.createCriteria(Employer.class);

        List<Employer> results = criteria.list();

        closeTransactionSession();
        return results;
    }

    public void update(Employer employer) {
        openTransactionSession();

        Session session = getSession();
        session.persist(employer);
        session.update(employer);

        closeTransactionSession();
    }

    public void remove(Employer employer) {
        openTransactionSession();

        Session session = getSession();
        session.remove(employer);

        closeTransactionSession();
    }
}
