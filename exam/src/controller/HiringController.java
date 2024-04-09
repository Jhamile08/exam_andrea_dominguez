package controller;

import Utils.Utils;
import entity.Coder;
import entity.Company;
import entity.Hiring;
import entity.Vacant;
import model.CoderModel;
import model.CompanyModel;
import model.HiringModel;
import model.VacantModel;

import javax.swing.*;
import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

public class HiringController {
    public static void create() {
        VacantModel objVacantModel = new VacantModel();
        CoderModel objCoderModel = new CoderModel();
        Object[] option = Utils.listToArray(objVacantModel.findAll());
        Vacant VacantSelected = (Vacant) JOptionPane.showInputDialog(null,"Select the vacant: ",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );

        Object[] option2 = Utils.listToArray(objCoderModel.findAll());
        Coder CoderSelected = (Coder) JOptionPane.showInputDialog(null,"Select the coder: ",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option2, option2[0]
        );
        if(VacantSelected.getTecnology().contains(CoderSelected.getCv())){
            Float salary = Float.parseFloat(JOptionPane.showInputDialog("Insert the salary: "));
            Hiring instanceHiring = (Hiring) instanceModel().insert(new Hiring(VacantSelected.getId(), CoderSelected.getId(),"INACTIVE" , salary));

            objVacantModel.upDateState(VacantSelected);
            JOptionPane.showMessageDialog(null, instanceHiring.toString());
        }else{
            JOptionPane.showMessageDialog(null,"Your skills aren't complatible");
        }

    }

    public static void getAll(){
        String listHiring = "Hiring list\n";
        for(Object iterator : instanceModel().findAll()){
            Hiring objHiring = (Hiring) iterator;
            listHiring += objHiring.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, listHiring);
    }
    public static void upDate(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Hiring HiringSelected = (Hiring) JOptionPane.showInputDialog(null,"Select the hiring to edit",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        HiringSelected.setVacant_id(Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the new vacant id: ", HiringSelected.getVacant_id())));
        HiringSelected.setCoder_id(Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the coder id: ", HiringSelected.getCoder_id())));
        HiringSelected.setDate_aplication(JOptionPane.showInputDialog(null, "Insert the new date aplication: ", HiringSelected.getDate_aplication()));
        HiringSelected.setState(JOptionPane.showInputDialog(null, "Insert the new state: ", HiringSelected.getState()));
        HiringSelected.setSalary(Float.parseFloat(JOptionPane.showInputDialog(null, "Insert the new  salary: ", HiringSelected.getSalary())));

        instanceModel().upDate(HiringSelected);
    }
    public static void delete(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Hiring HiringSelected = (Hiring) JOptionPane.showInputDialog(null,"Select the hiring to delete",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        int confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete this hiring?\n " + HiringSelected.toString());
        if(confirm == 0) instanceModel().delete(HiringSelected);

    }
    public static HiringModel instanceModel(){
        return new HiringModel();
    }


}
