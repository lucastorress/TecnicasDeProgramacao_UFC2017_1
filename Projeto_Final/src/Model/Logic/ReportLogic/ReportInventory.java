/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic.ReportLogic;

import Model.DAO.ProductDAO;
import Model.Object.Product;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adriano
 */
public class ReportInventory {
    public void draw() throws DocumentException, IOException {
        
        try {
            Document doc = new Document();
            Calendar data = Calendar.getInstance();
            int month = data.get(MONTH)+1;
            try {
                PdfWriter.getInstance(doc, new FileOutputStream("InventoryReport"+data.get(DAY_OF_MONTH)+month+data.get(YEAR)+".pdf"));
            } catch (FileNotFoundException ex) {
                java.util.logging.Logger.getLogger(ReportInventory.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.open();
            
            float fntSize, lineSpacing;
            fntSize = 6.7f;
            lineSpacing = 10f;
            Paragraph p;
            //String line = "ID da Venda / Referência do Vendedor / Referência do Cliente / Transportadora (S/N) / Status / Valor em Reais / Data da Venda";
            String line = "Relatório gerado em: " + data.get(DATE) + "/" + month + "/" + data.get(YEAR);
            p = new Paragraph(new Phrase(lineSpacing,line,FontFactory.getFont(FontFactory.TIMES_ROMAN, fntSize)));
            
            doc.add(p);
            
            line = "Itens em estoque: ";
            p = new Paragraph(new Phrase(lineSpacing,line,FontFactory.getFont(FontFactory.TIMES_ROMAN, fntSize)));             
            
            doc.add(p);
            
            ProductDAO dao = new ProductDAO();
            HashMap<Product, Integer> stock = null;
            try {
                stock = dao.retrieveStock();
            } catch (Exception ex) {
                Logger.getLogger(ReportInventory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            float total = 0;
            for(Product product : stock.keySet()) {
                total += stock.get(product);
        	line = product.toString();
                line += " / Quantity: " + stock.get(product);
                p = new Paragraph(new Phrase(lineSpacing,line,FontFactory.getFont(FontFactory.TIMES_ROMAN, fntSize)));
                doc.add(p);
            }
            
            line = "Total de itens em estoque: " + total;
            p = new Paragraph(new Phrase(lineSpacing,line,FontFactory.getFont(FontFactory.TIMES_ROMAN, fntSize)));
            doc.add(p);
            
            doc.close();
            
            
        } catch (DocumentException ex) {
            java.util.logging.Logger.getLogger(ReportInventory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ReportInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
