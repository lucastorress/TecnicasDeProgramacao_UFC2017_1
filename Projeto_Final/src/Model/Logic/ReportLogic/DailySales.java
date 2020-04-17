package Model.Logic.ReportLogic;

import Model.DAO.SaleDAO;
import Model.Object.Sale;
import Model.Object.Store;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DailySales extends Decorator { 
    public DailySales(Report report) {
        super(report);
    }
    @Override
    public void draw() throws DocumentException, IOException {
        super.draw();
        
        Document document = (Document) report;
        String filename = "C:/Users/tecno/Documents/NetBeansProjects/Técnicas de Programação/srcdailysalesreport.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        String string = "Vendas Diárias: ";
        document.add(new Paragraph(string));
        string = "";
        SaleDAO dao = new SaleDAO();
        LinkedList<Sale> sales = null;
        try {
            sales = dao.retrieveDailyAll();
        } catch (Exception ex) {
            Logger.getLogger(DailySales.class.getName()).log(Level.SEVERE, null, ex);
        }
        float total = 0f;
        int i ;
        for(i = 0 ; i < sales.size(); i++ ){
        	Sale sale = sales.get(i);
        	string += sale.toString();
        	total += sale.getValue();
        	document.add(new Paragraph(string));
        	string = "";
        }
        Date date = new Date();
        string = "Total de vendas do dia: " + date.toString();
        string += "R$: " + total;
        document.add(new Paragraph(string));

        document.close();
        
    }
     public void draw(Store store) throws DocumentException, IOException {
        super.draw();
        
        Document document = (Document) report;
        String filename = "C:/Users/tecno/Documents/NetBeansProjects/Técnicas de Programação/srcdailysalesreport.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        String string = "Vendas Diárias: ";
        document.add(new Paragraph(string));
        string = "";
        SaleDAO dao = new SaleDAO();
        LinkedList<Sale> sales = null;
        try {
            sales = dao.retrieveDailyAll(store);
        } catch (Exception ex) {
            Logger.getLogger(DailySales.class.getName()).log(Level.SEVERE, null, ex);
        }
        float total = 0f;
        int i ;
        for(i = 0 ; i < sales.size(); i++ ){
        	Sale sale = sales.get(i);
        	string += sale.toString();
        	total += sale.getValue();
        	document.add(new Paragraph(string));
        	string = "";
        }
        Date date = new Date();
        string = "Total de vendas do dia: " + date.toString() ;
        string += "R$: " + total;
        document.add(new Paragraph(string));

        document.close();
        
    }
}
