package credentialServices;

import employee.Employee;

import java.util.Locale;
import java.util.Random;

public class CredentialServices {
    String companyName = "lab";
    public String generateEmailAddress(String firstName, String lastName, String department){
        String emailAddress = null;
        emailAddress = String.format("%s%s@%s.%s.com",firstName.toLowerCase(),lastName.toLowerCase(),department.toLowerCase(),companyName);
        return emailAddress;
    }
    public String generatePassword(){
        String password = "";
        String upperEnglishLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerEnglishLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "~`!@#$%^&*()-_=+[{]};:,<.>/?";
        String allCombinations = upperEnglishLetters + lowerEnglishLetters + numbers + specialCharacters;
        Random random = new Random();
        password = password + upperEnglishLetters.charAt(random.nextInt(upperEnglishLetters.length()));
        password = password + lowerEnglishLetters.charAt(random.nextInt(lowerEnglishLetters.length()));
        password = password + numbers.charAt(random.nextInt(numbers.length()));
        password = password + specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        for(int i=1;i<=4;i++) {
            password = password + allCombinations.charAt(random.nextInt(allCombinations.length()));
        }
        return password;
    }
    public void  showCredentials(Employee employee){
        System.out.println(String.format("Dear %s, your generated credentials are as follows:",employee.getFirstName()));
        System.out.println(String.format("Email ---> %s",employee.getEmail()));
        System.out.println(String.format("Password ---> %s",employee.getPassword()));
    }

}
