package Model.Logic.ReportLogic;

import Model.DAO.ProductDAO;
import Model.Object.Product;
import Model.Object.Store;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryReport extends Decorator {
    public InventoryReport(Report report) {
	super(report);
    }
    @Override
    public void draw() throws DocumentException, IOException {
        super.draw();
        
        Document document = (Document) report;
        String filename = "C:/Users/tecno/Documents/NetBeansProjects/Técnicas de Programação/dailysalesreport.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        String string = "Itens em estoque: ";
        document.add(new Paragraph(string));
        string = "";
        ProductDAO dao = new ProductDAO();
        HashMap<Product, Integer> stock = null;
        try {
            stock = dao.retrieveStock();
        } catch (Exception ex) {
            Logger.getLogger(InventoryReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        float total = 0;
        for(Product product : stock.keySet()) {
        	total += stock.get(product);
        	string += product.toString();
        	string += " / Quantity: " + stock.get(product);
        	document.add(new Paragraph(string));
        	string = "";
        }
        string = "Total de itens em estoque: " + total;
        document.add(new Paragraph(string));

        document.close();
    }
    public void draw(Store store) throws DocumentException, IOException {
        super.draw();
        
        Document document = (Document) report;
        String filename = "C:/Users/tecno/Documents/NetBeansProjects/Técnicas de Programação/dailysalesreport.pdf";
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        String string = "Itens no estoque " + store.getStoreId();
        try {
            document.add(new Paragraph(string));
        } catch (DocumentException ex) {
            Logger.getLogger(InventoryReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        string = "";
        ProductDAO dao = new ProductDAO();
        HashMap<Product, Integer> stock = null;
        try {
            stock = dao.retrieveStock(store);
        } catch (Exception ex) {
            Logger.getLogger(InventoryReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        float total = 0;
        for(Product product : stock.keySet()) {
            total += stock.get(product);
            string += product.toString();
            try {
                document.add(new Paragraph(string));
            } catch (DocumentException ex) {
                Logger.getLogger(InventoryReport.class.getName()).log(Level.SEVERE, null, ex);
            }
            string = "";
        }
        string = "Total de itens em estoque: " + total;
        try {
            document.add(new Paragraph(string));
        } catch (DocumentException ex) {
            Logger.getLogger(InventoryReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.close();
    }
}