package Model.Logic.ReportLogic;

import com.itextpdf.text.DocumentException;
import java.io.IOException;

interface Report {
    void draw() throws DocumentException, IOException;
   
}