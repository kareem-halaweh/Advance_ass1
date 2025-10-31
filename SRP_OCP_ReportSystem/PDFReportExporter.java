package SRP_OCP_ReportSystem;

public class PDFReportExporter implements ReportExporter {
    @Override
    public void export(Report report) {
        System.out.println("Exporting report as PDF...");
        System.out.println("{ \"title\": \"" + report.getTitle() + "\", \"content\": \"" + report.getContent() + "\" }");
    }
}
