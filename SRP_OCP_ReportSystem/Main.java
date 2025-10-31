package SRP_OCP_ReportSystem;

public class Main {
    public static void main(String[] args) {
        Report report = new Report("Monthly Sales", "Sales increased by 15% in October.");
        ReportService service = new ReportService();

        ReportExporter textExporter = new TextReportExporter();
        ReportExporter jsonExporter = new JsonReportExporter();

        service.generateReport(report, textExporter);
        service.generateReport(report, jsonExporter);
    }
}
