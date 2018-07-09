package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.DBServiceImpl;
import dbService.dataSets.UsersDataSet;

public class AccountService {

    private final DBService dbService = DBServiceImpl.getInstance();

    public void addNewUser(String login, String password) {
        try {
            dbService.addUser(login, password);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UsersDataSet getUserByLogin(String login) {
        try {
            return dbService.getUserByName(login);
        } catch (DBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
