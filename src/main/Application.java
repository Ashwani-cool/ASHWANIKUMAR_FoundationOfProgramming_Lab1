package main;

import credentialServices.CredentialServices;
import employee.Employee;

import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        boolean deptFlag = false;
        Scanner sc = new Scanner(System.in);
        String firstName;
        String lastName;
        String departmentName;
        Integer departmentNumber;

        System.out.println("Please enter employee's first name:");
        firstName = sc.next();
        System.out.println("Please enter employee's last name:");
        lastName = sc.next();
        Employee employeeObject = new Employee(firstName,lastName);
        do {
            System.out.println("Please enter department from the following:");
            System.out.println("1. Technical");
            System.out.println("2. Admin");
            System.out.println("3. Human Resource");
            System.out.println("4. Legal");
            departmentNumber = sc.nextInt();
            switch (departmentNumber){
                case 1:
                    employeeObject.setDepartment("Tech");
                    deptFlag=false;
                    break;
                case 2:
                    employeeObject.setDepartment("Admin");
                    deptFlag=false;
                    break;
                case 3:
                    employeeObject.setDepartment("HR");
                    deptFlag=false;
                    break;
                case 4:
                    employeeObject.setDepartment("Legal");
                    deptFlag=false;
                    break;
                default:
                    deptFlag = true;
                    System.out.println("You selected incorrect option!! please select correct option");
            }
        } while (deptFlag);
        CredentialServices credService = new CredentialServices();
        String emailAddress = credService.generateEmailAddress(firstName,lastName,employeeObject.getDepartment());
        String password = credService.generatePassword();
        employeeObject.setEmail(emailAddress);
        employeeObject.setPassword(password);
        credService.showCredentials(employeeObject);

    }
}
