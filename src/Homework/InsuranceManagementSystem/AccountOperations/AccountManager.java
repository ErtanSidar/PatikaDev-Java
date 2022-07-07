package Homework.InsuranceManagementSystem.AccountOperations;


import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

import Homework.InsuranceManagementSystem.Address.Address;
import Homework.InsuranceManagementSystem.Address.HomeAddress;
import Homework.InsuranceManagementSystem.UserOperations.User;
import Homework.InsuranceManagementSystem.exception.InvalidAuthenticationException;

public class AccountManager {

    TreeSet<Account> users = new TreeSet<>();

    public void addUsers() throws ClassCastException {
        Address address = new HomeAddress("Ankara", "Çankaya", "Yeniacun Sokak", "3E sitesi Ankara Çankaya");
        User user1 = new User("Ertan", "Sidar", "essoft3@gmail.com", "12345", "işsiz", 25, address, "Individual");
        Account account = new Individual(user1);

        Address address2 = new HomeAddress("Van", "Merkez", "Lale Sokak", "lale sokak no 46 van merkez");
        User user2 = new User("Ali", "Veli", "aliveli@gmail.com", "456", "doktor", 43, address2, "Enterprise");
        Account account2 = new Enterprise(user2);
        users.add(account);
        users.add(account2);
    }

    public Account login(String email, String password) {
        addUsers();
        try {
            for (Account acc : users) {
                if (acc.getUser().getEmail().equals(email) && acc.getUser().getPassword().equals(password)) {
                    acc.login(email, password, acc);
                    return acc;
                }
            }
            throw new InvalidAuthenticationException("Şifre veya email yanlış girildi!");

        } catch (InvalidAuthenticationException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
