package Service;

import Dao.UserDAO;
import Entity.User;
import Util.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserService extends SessionUtil implements UserDAO {
    //Добавление пользователя
    public void add(User user) {
        openTransactionSession();

        Session session = getSession();
        session.save(user);

        closeTransactionSession();
    }
    //Получение по id
    public User getByID(Long id) {
        openTransactionSession();

        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id",id));

        User user = (User) criteria.uniqueResult();

        closeTransactionSession();

        return user;
    }
    //Получение всех
    public List<User> getAll() {
        openTransactionSession();

        Session session = getSession();
        Criteria criteria = session.createCriteria(User.class);

        List<User> results = criteria.list();

        closeTransactionSession();
        return results;
    }
    //Обновление данных
    public void update(User user) {
        openTransactionSession();

        Session session = getSession();
        //session.persist(user);
        session.update(user);

        closeTransactionSession();
    }
    //Удаление данных
    public void remove(User user) {
        openTransactionSession();

        Session session = getSession();
        session.remove(user);

        closeTransactionSession();
    }
}