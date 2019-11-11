package task01;

import java.io.*;

class FileUtils {

    static Employee[] getEmployeesFromFile(String employeesFile) {
        File file = new File(employeesFile);
        int employeesNumber = calculateEmployeesInFile(file);
        Employee[] company = new Employee[employeesNumber];

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] employeeDetails = line.split(";");
                company[index] = new Employee(employeeDetails[0], employeeDetails[1], employeeDetails[2], employeeDetails[3], Double.parseDouble(employeeDetails[4]));
                index++;
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return company;
    }

    private static int calculateEmployeesInFile(File file) {
        int employeesNumber = 0;
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            while ((bufferedReader.readLine()) != null) {
                employeesNumber++;
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return employeesNumber;
    }

    static void setCompanyStatisticsToFile(Employee[] company, String statisticsFile) {
        File file = new File(statisticsFile);
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            bufferedWriter.write("Średnia wypłata: " + CompanyStatistics.calculateAverageSalary(company));
            bufferedWriter.newLine();
            bufferedWriter.write("Najmniejsza wypłata: " + CompanyStatistics.calculateMinSalary(company));
            bufferedWriter.newLine();
            bufferedWriter.write("Największa wypłata: " + CompanyStatistics.calculateMaxSalary(company));
            bufferedWriter.newLine();
            bufferedWriter.write("Łączna liczba pracowników: " + company.length);
            bufferedWriter.newLine();

            int iterator = 0;
            String[] departments = CompanyStatistics.getUniqueDepartments(company);
            while (departments[iterator] != null) {
                bufferedWriter.write("Liczba pracowników w dziale " + departments[iterator] + ": " +
                        CompanyStatistics.calculateEmployeesInDepartment(departments[iterator], company));
                bufferedWriter.newLine();
                iterator++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}