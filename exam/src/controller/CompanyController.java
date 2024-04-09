package controller;

import entity.Coder;
import entity.Company;
import model.CoderModel;
import model.CompanyModel;

import javax.swing.*;

public class CompanyController {
    public static void create(){
        String name = JOptionPane.showInputDialog("Insert the company's name: ");
        String sector = JOptionPane.showInputDialog("Insert the sector: ");
        String ubication = JOptionPane.showInputDialog("Insert the ubication: ");
        String contact = JOptionPane.showInputDialog("Insert the contact:  ");

        Company instanceCompany = (Company) instanceModel().insert(new Company(name, sector, ubication,contact));
        JOptionPane.showMessageDialog(null, instanceCompany.toString());

    }

    public static void getAll(){
        String listCompany = "Company list\n";
        for(Object iterator : instanceModel().findAll()){
            Company objCompany = (Company) iterator;
            listCompany += objCompany.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listCompany);
    }
    public static CompanyModel instanceModel(){
        return new CompanyModel();
    }

}


