package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO {
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public long getUserID(String name) {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        UsersDataSet usersDataSet = ((UsersDataSet) criteria.add(Restrictions.eq("name", name))
                .uniqueResult());
        if (usersDataSet != null) {
            return usersDataSet.getId();
        } else {
            return 0;
        }
    }

    public long insertUser(String name, String password) {
        return (Long) session.save(new UsersDataSet(name, password));
    }
}
