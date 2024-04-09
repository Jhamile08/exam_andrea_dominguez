package controller;

import Utils.Utils;
import entity.Coder;
import entity.Company;
import entity.Vacant;
import model.CoderModel;
import model.CompanyModel;
import model.VacantModel;

import javax.swing.*;

public class VacantController {
    public static void create() {
        CompanyModel objModelCompany = new CompanyModel();
        Object[] option = Utils.listToArray(objModelCompany.findAll());
        Company CompanySelected = (Company) JOptionPane.showInputDialog(null,"Select the company: ",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        if(CompanySelected == null){
            JOptionPane.showMessageDialog(null, "Company not found");
        }
        String title = JOptionPane.showInputDialog("Insert the vacant's title: ");
        String description = JOptionPane.showInputDialog("Insert the vacant's description: ");
        String duration = JOptionPane.showInputDialog("Insert the duration:  ");
        String tecnology = JOptionPane.showInputDialog("Insert the vacant's tecnology:  ");
        Vacant instanceVacant = (Vacant) instanceModel().insert(new Vacant(CompanySelected.getId(), title, description,"ACTIVE",duration, tecnology));
        JOptionPane.showMessageDialog(null, instanceVacant.toString());
    }
    public static void getAll(){
        String listVacant = "Vacant list\n";
        for(Object iterator : instanceModel().findAll()){
            Vacant objVacant = (Vacant) iterator;
            listVacant += objVacant.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listVacant);
    }
    public static void upDate(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Vacant VacantSelected = (Vacant) JOptionPane.showInputDialog(null,"Select the vacant to edit",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        if(VacantSelected == null){
            JOptionPane.showMessageDialog(null, "Vacant not found");
        }

        VacantSelected.setCompany_id(Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the new flight's departure time: ", VacantSelected.getCompany_id())));
        VacantSelected.setTitle(JOptionPane.showInputDialog(null, "Insert the new vacant's title: ", VacantSelected.getTitle()));
        VacantSelected.setDescription(JOptionPane.showInputDialog(null, "Insert the new vacant's description: ", VacantSelected.getDescription()));
        VacantSelected.setTecnology(JOptionPane.showInputDialog(null, "Insert the new vacant tecnology: ", VacantSelected.getTecnology()));

        instanceModel().upDate(VacantSelected);
    }
    public static void delete(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Vacant VacantSelected = (Vacant) JOptionPane.showInputDialog(null,"Select the vacant to delete",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        int confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete this vacant?\n " + VacantSelected.info());
        if(confirm == 0) instanceModel().delete(VacantSelected);

    }
    public static VacantModel instanceModel(){
        return new VacantModel();
    }

    public static void getByName(){
        String name = JOptionPane.showInputDialog("\n Enter the vacant title or tecnology to find: ");
        VacantModel objVacantModel = new VacantModel();

        String listaString = "The vacant: "+name+" is:\n";
        for(Vacant iterador: objVacantModel.foundByname(name)){
            listaString += iterador.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, listaString);

    }
}
