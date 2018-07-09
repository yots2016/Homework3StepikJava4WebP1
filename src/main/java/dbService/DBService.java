package dbService;

import dbService.dataSets.UsersDataSet;

public interface DBService {
    long addUser(String login, String password) throws DBException;

    UsersDataSet getUserByName(String login) throws DBException;
}
