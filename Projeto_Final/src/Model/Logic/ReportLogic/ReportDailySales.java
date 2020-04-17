/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Logic.ReportLogic;

import Model.DAO.SaleDAO;
import Model.Object.Sale;
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
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adriano
 */
public class ReportDailySales { 
    public void draw() throws DocumentException, IOException {
        
        try {
            Document doc = new Document();
            Calendar data = Calendar.getInstance();
            int month = data.get(MONTH)+1;
            try {
                PdfWriter.getInstance(doc, new FileOutputStream("ReportDailySales"+data.get(DAY_OF_MONTH)+month+data.get(YEAR)+".pdf"));
            } catch (FileNotFoundException ex) {
                java.util.logging.Logger.getLogger(ReportDailySales.class.getName()).log(Level.SEVERE, null, ex);
            }
            doc.open();
            
            float fntSize, lineSpacing;
            fntSize = 6.7f;
            lineSpacing = 10f;
            Paragraph p;
            String line = "Relatório gerado em: " + data.get(DATE) + "/" + month + "/" + data.get(YEAR);
            p = new Paragraph(new Phrase(lineSpacing,line,FontFactory.getFont(FontFactory.TIMES_ROMAN, fntSize)));
            
            doc.add(p);
            
            line = "Vendas diárias: ";
            p = new Paragraph(new Phrase(lineSpacing,line,FontFactory.getFont(FontFactory.TIMES_ROMAN, fntSize)));             
            
            doc.add(p);
            
            SaleDAO dao = new SaleDAO();
            LinkedList<Sale> sales = null;
            try {
                sales = dao.retrieveDailyAll();
            } catch (Exception ex) {
                Logger.getLogger(ReportDailySales.class.getName()).log(Level.SEVERE, null, ex);
            }
            float total = 0f;
            int i ;
            for(i = 0 ; i < sales.size(); i++ ){
        	Sale sale = sales.get(i);
        	line = sale.toString();
                p = new Paragraph(new Phrase(lineSpacing,line,FontFactory.getFont(FontFactory.TIMES_ROMAN, fntSize))); 
        	total += sale.getValue();
        	doc.add(p);
            }
            line = "Total de vendas do dia: " + data.get(DATE) + "/" + month + "/" + data.get(YEAR);
            line += "\nR$: " + total;
            p = new Paragraph(new Phrase(lineSpacing,line,FontFactory.getFont(FontFactory.TIMES_ROMAN, fntSize)));
            doc.add(p);

            doc.close();
            
        } catch (DocumentException ex) {
            java.util.logging.Logger.getLogger(ReportDailySales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ReportDailySales.class.getName()).log(Level.SEVERE, null, ex);
        }       
        
    }
}
