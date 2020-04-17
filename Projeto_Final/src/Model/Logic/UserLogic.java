package Model.Logic;

import Model.Object.User;
import Model.DAO.UserDAO;
import Utility.LogDAO;
import static Utility.StringDate.*;

public class UserLogic {
    public void SignUp(String name, String cpf, String phone, String birthday, String username, String password, User loggedUser) throws Exception {
        LogDAO.write("Tentativa de cadastro de usuário: " + name + ", " + cpf + ", " + phone + ", " + birthday + ", " + username + ".");
        UserDAO userdao = new UserDAO();
        User user;
        try {
            user = userdao.retrieveByCPF(cpf);
        } catch(Exception exception) {
            throw exception;
        }

        if(user == null) {
            user = new User();
            user.setName(name);
            user.setCPF(cpf);
            user.setPhone(phone);
            user.setBirthday(stringToDate(birthday));
            user.setStoreId(loggedUser.getStoreId());
            user.setUsername(username);
            user.setPassword(password);
            try {
                userdao.insert(user);
                LogDAO.write("Novo usuário com nome de usuário " + username + " cadastrado com sucesso.");
            } catch(Exception exception) {
                throw exception;
            }
        } else {
            LogDAO.write("Erro de cadastro: o CPF ou nome de usuário já está cadastrado no sistema.");
            throw new Exception("Usuário já existe.");
        }
    }
  
    public User Search(String cpf) throws Exception {
        UserDAO userdao = new UserDAO();
        User user;
        try {
            user = userdao.retrieveByCPF(cpf);
            LogDAO.write("Pesquisa de usuário com cpf " + cpf + " efetuada.");
            return user;
        } catch(Exception exception) {
      	    throw exception;
        }
    }
    public User SearchName(String name) throws Exception{
        UserDAO userdao = new UserDAO();
        User user;
        try {
            user = userdao.retrieveByName(name);
            return user;
        } catch(Exception exception) {
           throw exception;
        }
    }
  
    public void Update(String name, String cpf, String phone, String birthday, String username, String password) throws Exception {
        UserDAO userdao = new UserDAO();
        User user;
        try {
            user = new User();
            
            user.setName(name);
            user.setCPF(cpf);
            user.setPhone(phone);
            user.setBirthday(stringToDate(birthday));
            user.setUsername(username);
            user.setPassword(password);
            userdao.update(user);
            LogDAO.write("Dados do usuário com cpf " + cpf + " atualizados para:" +
                         "nome: " + name + ", phone: " + phone + ", birthday: " + birthday +
                         "nome de usuário: " + username + "senha: " + password + ".");
        } catch(Exception exception) {
      	    throw exception;
        }	
    }
  
    public void Delete(String name, String cpf, String phone, String birthday, String username, String password) throws Exception {
  	UserDAO userdao = new UserDAO();
        User user;
        try {
      	    user = userdao.retrieveByCPF(cpf);
            if(user == null){
                throw new Exception();
            } else {
                userdao.delete(user);
                LogDAO.write("Usuário " + username + " deletado.");
            }
        } catch(Exception exception) {
      	    throw new Exception();
        }
    }
}
