package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String, String>() {{
        put("UA","Ukraine");
        put("RU", "Russia");
        put("CA", "Canada");
    }};

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for(Map.Entry entry: countries.entrySet()) {
                if (entry.getValue().equals(customer.getCountryName())) return (String) entry.getKey();
            }
            return null;
        }


        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] list = contact.getName().split(" ");
            return list[1];
        }

        @Override
        public String getContactLastName() {
            String[] list = contact.getName().split(",");
            return list[0];
        }

        @Override
        public String getDialString() {
            StringBuilder sb = new StringBuilder(contact.getPhoneNumber());
            while (sb.indexOf("-") > 0) {
                sb.deleteCharAt(sb.indexOf("-"));
            }
            while (sb.indexOf("(") > 0) {
                sb.deleteCharAt(sb.indexOf("("));
            }
            while (sb.indexOf(")") > 0) {
                sb.deleteCharAt(sb.indexOf(")"));
            }
            return sb.insert(0, "callto://").toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }


    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}