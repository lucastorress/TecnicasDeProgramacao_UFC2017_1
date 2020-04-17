package Model.Logic.ReportLogic;

import com.itextpdf.text.DocumentException;
import java.io.IOException;

abstract class Decorator implements Report {
    // 4. "has a" relationship
    Report report;

    public Decorator(Report report) {
        this.report = report;
    }

    // 5. Delegation
    @Override
    public void draw() throws DocumentException, IOException {
        this.report.draw();
    }
}