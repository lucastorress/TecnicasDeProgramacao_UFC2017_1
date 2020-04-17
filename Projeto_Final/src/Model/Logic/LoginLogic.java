package Model.Logic;

import Model.DAO.UserDAO;

import Model.Object.User;
import Utility.LogDAO;

public class LoginLogic {
    
    public User Login(String username, String password) throws Exception {
        UserDAO userdao = new UserDAO();
        try {
            boolean loginSuccess = tryLogin(username, password);
            if(loginSuccess) {
                User user = userdao.retrieveByUsername(username);
                LogDAO.write("Usuário " + username + " efetuou login.");
                return user;
            } else {
                LogDAO.write("Falha ao realizar login com nome de usuário " + username + ".");
                throw new Exception("Esse usuário não existe ou a senha está errada.");
            }
        } catch(Exception exception) {
            throw new Exception("Erro1: "+exception.getMessage());
            //throw new Exception(exception.getMessage());
        }
    }

    private boolean tryLogin(String username, String password) throws Exception {
        UserDAO userdao = new UserDAO();
        try {
            boolean validLogin = (password.equals(userdao.retrievePassword(username)));
            return validLogin;
        } catch(Exception exception) {
            throw new Exception("Erro2: "+exception.getMessage());
        }
    }
}
