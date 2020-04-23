package Service;

import Dao.WorkerDAO;
import Entity.Worker;
import Util.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class WorkerService extends SessionUtil implements WorkerDAO {
    public void add(Worker worker) {
        openTransactionSession();

        Session session = getSession();
        session.save(worker);

        closeTransactionSession();
    }

    public Worker getByID(Long id) {
        openTransactionSession();

        Session session = getSession();
        Criteria criteria = session.createCriteria(Worker.class);
        criteria.add(Restrictions.eq("id",id));

        Worker worker = (Worker) criteria.uniqueResult();

        closeTransactionSession();

        return worker;
    }

    public List<Worker> getAll() {
        openTransactionSession();

        Session session = getSession();
        Criteria criteria = session.createCriteria(Worker.class);

        List<Worker> results = criteria.list();

        closeTransactionSession();
        return results;
    }

    public void update(Worker worker) {
        openTransactionSession();

        Session session = getSession();
        session.persist(worker);
        session.update(worker);

        closeTransactionSession();
    }

    public void remove(Worker worker) {
        openTransactionSession();

        Session session = getSession();
        session.remove(worker);

        closeTransactionSession();
    }
}
