package Model.Logic.ReportLogic;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class ConcreteReport implements Report {
    private Document document;
    String name;

    public ConcreteReport(String name) {
    	this.name = name;
    }
    //escreva o cabeçalho
    @Override
    public void draw() throws DocumentException, IOException {
        String filename = "C:/Users/user/Desktop/tecnicas/src/Other" + this.name + ".pdf";
        this.document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
     
        String top = "";
        document.add(new Paragraph(top));
        top = "";
        top += "Data da requisição: ";
        Date date = new Date();
        top += date.toString();
        document.add(new Paragraph(top));
        document.close();
    }
}