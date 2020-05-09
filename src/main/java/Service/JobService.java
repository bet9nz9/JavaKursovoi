package Service;

import Dao.JobDAO;
import Entity.Job;
import Util.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class JobService extends SessionUtil implements JobDAO {
    //Добавление работы
    public void add(Job job) {
        openTransactionSession();

        Session session = getSession();
        session.save(job);

        closeTransactionSession();
        Job.setListOfJobs(new JobService().getAll());
    }
    //Получение по id
    public Job getByID(Long id) {
        openTransactionSession();

        Session session = getSession();
        Criteria criteria = session.createCriteria(Job.class);
        criteria.add(Restrictions.eq("id",id));

        Job job = (Job) criteria.uniqueResult();

        closeTransactionSession();

        return job;
    }
    //Получение всех
    public List<Job> getAll() {
        openTransactionSession();

        Session session = getSession();
        Criteria criteria = session.createCriteria(Job.class);

        List<Job> results = criteria.list();

        closeTransactionSession();
        return results;
    }
    //Обновление данных
    public void update(Job job) {
        openTransactionSession();

        Session session = getSession();
        session.update(job);

        closeTransactionSession();
    }
    //Удаление данных
    public void remove(Job job) {
        openTransactionSession();

        Session session = getSession();
        session.remove(job);

        closeTransactionSession();
    }
}
