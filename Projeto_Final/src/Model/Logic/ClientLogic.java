package Model.Logic;

import Model.Object.Client;
import Model.DAO.ClientDAO;
import Utility.LogDAO;
import static Utility.StringDate.stringToDate;

public class ClientLogic {
    public void signUp(String name, String cpf, String phone, String birthday) throws Exception {
        LogDAO.write("Tentativa de cadastro de cliente: " + name + ", " + cpf + ", " + phone + ", " + birthday + ".");
        ClientDAO clientdao = new ClientDAO();
        Client client;
        try {
            client = clientdao.retrieveByCPF(cpf);
        } catch(Exception exception) {
            throw exception;
        }

        if(client == null) {
            client = new Client();
            client.setName(name);
            client.setCPF(cpf);
            client.setPhone(phone);
            client.setBirthday(stringToDate(birthday));
            try {
                clientdao.insert(client);
                LogDAO.write("Novo cliente com CPF " + cpf + " cadastrado com sucesso.");
            } catch(Exception exception) {
                throw exception;
            }
        } else {
            LogDAO.write("Erro de cadastro: CPF " + cpf + " já está cadastrado no sistema.");
            throw new Exception("Cliente com cpf passado já existe.");
        }
    }
  
    public Client search(String cpf) throws Exception {
        ClientDAO clientdao = new ClientDAO();
        Client client;
        try {
            client = clientdao.retrieveByCPF(cpf);
            LogDAO.write("Pesquisa de cliente com cpf " + cpf + " efetuada.");
            return client;
        } catch(Exception exception) {
            throw exception;
        }
    }
  
    public void update(String name, String cpf, String phone, String birthday) throws Exception {
        ClientDAO clientdao = new ClientDAO();
        Client client;
        try {
            client = clientdao.retrieveByCPF(cpf);
            if(client == null) {
          	throw new Exception();
            } else {
                client.setName(name);
                client.setPhone(phone);
                client.setBirthday(stringToDate(birthday));
                clientdao.update(client);
                LogDAO.write("Dados do cliente com cpf " + cpf + " atualizados para:" +
                             "nome: " + name + ", phone: " + phone + ", birthday: " + birthday + ".");
            }
        } catch(Exception exception) {
            throw exception;
        }	
    }
  
    public void delete(String cpf) throws Exception {
  	ClientDAO clientdao = new ClientDAO();
        Client client;
        try {
      	    client = clientdao.retrieveByCPF(cpf);
            if(client == null){
                throw new Exception();
            } else {
                clientdao.delete(client);
                LogDAO.write("Cliente com cpf " + cpf + " deletado.");
            }
        } catch(Exception exception) {
            throw exception;
        }
    }
    
    public void delete(int id) throws Exception {
        ClientDAO clientdao = new ClientDAO();
        Client client;
        try {
            client = new Client();
            client.setClientId(id);
            clientdao.delete(client);
            LogDAO.write("Cliente com id " + id + " deletado.");
        } catch(Exception exception) {
            throw exception;
        }
    }
}
