package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> emails = new HashMap<>();
        emails.put("i.ivanov@yandex.ru", "Иванов И.И.");
        emails.put("p.petrov@mail.ru", "Петров П.П.");
        emails.put("s.sergeev@gmail.com", "Сергеев С.С.");
        for (String email: emails.keySet()) {
            System.out.println(email + " " + emails.get(email));
        }
    }
}
