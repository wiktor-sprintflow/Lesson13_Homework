package task01;

public class App {
    private static final String EMPLOYEES_FILE = "employees.txt";
    private static final String COMPANY_STATISTICS_FILE = "company_statistics.txt";

    public static void main(String[] args) {

        FileUtils fileUtils = new FileUtils();
        Employee[] company = fileUtils.getEmployeesFromFile(EMPLOYEES_FILE);
        fileUtils.setCompanyStatisticsToFile(company, COMPANY_STATISTICS_FILE);
    }
}