package Model.Logic.ReportLogic;

import Model.DAO.RegisterDAO;
import Model.Object.Register;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterFlux extends Decorator {
    public RegisterFlux(Report report) {
        super(report);
    }
    public void draw() throws DocumentException, IOException {
        super.draw();
        String filename = "C:/Users/tecno/Documents/NetBeansProjects/Técnicas de Programação/registerfluxreport.pdf";
        Document document = (Document) report;
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        
        String string = "Fluxo do caixa nos ultimos dias:";
        document.add(new Paragraph(string));
        RegisterDAO dao = new RegisterDAO();
        LinkedList<Register> register = null;
        try {
            register = dao.retrieveAll();
        } catch (Exception ex) {
            Logger.getLogger(RegisterFlux.class.getName()).log(Level.SEVERE, null, ex);
        }
        float total = 0;
        for(int i=0; i < register.size(); i++) {
            Register reg = register.get(i);
            string = reg.toString();
            total+= reg.getCashRegister();
            document.add(new Paragraph(string));
        }
        
        
        string = "Total R$: " + total;
        document.add(new Paragraph(string));
        document.close();
        
        
    }
}