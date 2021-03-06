package com.Bridgelabz.EmployeePayroll;

import com.Bridgelabz.Employeepayroll.EmployeePayrollData;
import com.Bridgelabz.Employeepayroll.EmployeePayrollService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;





public class EmployeePayrollServiceTest {
    @Test
    public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
        EmployeePayrollData[] arrayOfEmployees = {
                new EmployeePayrollData(1, "Saurabh Yeggewar", 100000.0),
                new EmployeePayrollData(2, "Saurabh Sir", 200000.0),
                new EmployeePayrollData(3, "Prashant  Sir", 300000.0)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmployees));
        employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);

        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(12, entries);

    }

    @Test
    public void givenFile_WhenRead_ShouldReturnNumberOfEntries() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        long entries = employeePayrollService.readDataFromFile(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(12, entries);
    }
}
