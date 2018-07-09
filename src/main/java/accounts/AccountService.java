package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

public class AccountService {

    public void addNewUser(String login, String password) {
        try {
            DBService.getInstance().addUser(login, password);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UsersDataSet getUserByLogin(String login) {
        try {
            return   DBService.getInstance().getUserByName(login);
        } catch (DBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
