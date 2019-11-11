package task01;

class CompanyStatistics {

    static double calculateAverageSalary(Employee[] company) {
        double salariesSum = 0;
        for (Employee employee : company) {
            salariesSum += employee.getSalary();
        }
        return salariesSum / company.length;
    }

    static double calculateMinSalary(Employee[] company) {
        double minSalary = Double.MAX_VALUE;
        for (Employee employee : company) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    static double calculateMaxSalary(Employee[] company) {
        double maxSalary = Double.MIN_VALUE;
        for (Employee employee : company) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    static String[] getUniqueDepartments(Employee[] company) {
        String[] departments = new String[company.length];
        int uniqueCompanyNumbers = 0;

        for (Employee employee : company) {
            boolean departmentExists = false;
            for (String department : departments) {
                if (employee.getDepartment().equals(department)) {
                    departmentExists = true;
                    break;
                }
            }
            if (!departmentExists) {
                departments[uniqueCompanyNumbers] = employee.getDepartment();
                uniqueCompanyNumbers++;
            }
        }
        return departments;
    }

    static int calculateEmployeesInDepartment(String departmentName, Employee[] company) {
        int numberOfEmployees = 0;
        for (Employee employee : company) {
            if (departmentName.equals(employee.getDepartment())) {
                numberOfEmployees++;
            }
        }
        return numberOfEmployees;
    }
}