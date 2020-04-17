package Model.Logic.ReportLogic;

import Model.DAO.ClientDAO;
import Model.Object.Client;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientsReport extends Decorator {
    public ClientsReport(Report report) {
        super(report);
    }
    public void draw() throws DocumentException, IOException {
        super.draw();
        
        Document document = new Document();
        String filename = "clientsreport.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        String string = "Clientes cadastrados: ";
        document.add(new Paragraph(string));
        string = "";
        ClientDAO dao = new ClientDAO();
        LinkedList<Client> clients = null;
        try {
            clients = dao.retrieveAll();
        } catch (Exception ex) {
            Logger.getLogger(ClientsReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0; i < clients.size(); i++) {
        	Client client = clients.get(i);
        	string += client.toString();
        	document.add(new Paragraph(string));
        	string = "";
        }
        string = "Total de clientes cadastrados: " + clients.size();
        document.add(new Paragraph(string));

        document.close();

	}
}