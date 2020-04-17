package Model.Logic.ReportLogic;

import Model.DAO.UserDAO;
import Model.Object.Store;
import Model.Object.User;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SellersReport extends Decorator {
    public SellersReport(Report report) {
        super(report);
    }
    @Override
    public void draw() throws DocumentException, IOException {
        super.draw();
        
        Document document = (Document) report;
        String filename = "C:/Users/tecno/Documents/NetBeansProjects/Técnicas de Programação/sellersreport.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        String string = "Vendedores cadastrados: ";
        document.add(new Paragraph(string));
        string = "";
        UserDAO dao = new UserDAO();
        LinkedList<User> sellers = null;
        try {
            sellers = dao.retrieveAll();
        } catch (Exception ex) {
            Logger.getLogger(SellersReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0; i < sellers.size(); i++) {
            User seller = sellers.get(i);
            string += seller.toString();
            document.add(new Paragraph(string));
            string = "";
        }
        string = "Total de vendedores cadastrados: " + sellers.size();
        document.add(new Paragraph(string));

        document.close();

    }
    public void draw(Store store) throws DocumentException, IOException {
        super.draw();
        
        Document document = (Document) report;
        String filename = "C:/Users/tecno/Documents/NetBeansProjects/Técnicas de Programação/sellersreport.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        String string = "Vendedores cadastrados em " + store.getStoreId() + " :";
        document.add(new Paragraph(string));
        string = "";
        UserDAO dao = new UserDAO();
        LinkedList<User> sellers = null;
        try {
            sellers = dao.retrieveAll(store);
        } catch (Exception ex) {
            Logger.getLogger(SellersReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0; i < sellers.size(); i++) {
        	User seller = sellers.get(i);
        	string += seller.toString();
        	document.add(new Paragraph(string));
        	string = "";
        }
        string = "Total de vendedores cadastrados em " + store.getStoreId() + " : " + sellers.size();
        document.add(new Paragraph(string));

        document.close();

	}
}