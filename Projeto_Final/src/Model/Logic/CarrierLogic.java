/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic;

import Model.DAO.CarrierDAO;
import Model.Object.Carrier;

/**
 *
 * @author user
 */
public class CarrierLogic {
    public Carrier search(int id) throws Exception{
        CarrierDAO dao = new CarrierDAO();
        try{
            Carrier carrier = dao.retrieve(id);
            return carrier;
        } catch(Exception e) {
            throw e;
        }
    }
    public Carrier searchByName(String name) throws Exception{
        CarrierDAO dao = new CarrierDAO();
        try{
            Carrier carrier = dao.retrieveByName(name);
            return carrier;
        } catch(Exception e) {
            throw e;
        }
    }
    public Carrier searchByCNPJ(String cnpj) throws Exception {
        CarrierDAO dao = new CarrierDAO();
        try{
            Carrier carrier = dao.retrieveByCNPJ(cnpj);
            return carrier;
        } catch(Exception e) {
            throw e;
        }
    }
    public void update(int id, String name, String cnpj) throws Exception{
        CarrierDAO dao = new CarrierDAO();
        Carrier carrier;
        try{
            carrier = dao.retrieve(id);
            carrier.setCNPJ(cnpj);
            carrier.setName(name);
            dao.update(carrier);
        } catch(Exception e) {
            throw e;
        }
    }
    
    public void delete(int id) throws Exception{
        CarrierDAO dao = new CarrierDAO();
        Carrier carrier;
        try {
      	    carrier = new Carrier();
            carrier.setCarrierId(id);
            dao.delete(carrier);
        } catch(Exception e) {
            throw e;
        }
    }
    
    public void SignUp(String name, String cnpj) throws Exception{
        CarrierDAO dao = new CarrierDAO();
        Carrier carrier = new Carrier();
        carrier.setName(name);
        carrier.setCNPJ(cnpj);
        try {
            dao.insert(carrier);
        } catch(Exception e) {
            throw e;
        }
    }
}
