package task01;

public class App {
    private static final String EMPLOYEES_FILE = "employees.txt";
    private static final String COMPANY_STATISTICS_FILE = "company_statistics.txt";

    public static void main(String[] args) {

        Employee[] company = FileUtils.getEmployeesFromFile(EMPLOYEES_FILE);
        FileUtils.setCompanyStatisticsToFile(company, COMPANY_STATISTICS_FILE);
    }
}