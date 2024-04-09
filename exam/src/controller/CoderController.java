package controller;

import Utils.Utils;

import javax.swing.*;

import entity.Coder;
import model.CoderModel;

public class CoderController {
    public static void create() {
        String name = JOptionPane.showInputDialog("Insert the coder's name: ");
        String surname = JOptionPane.showInputDialog("Insert the coder's surname: ");
        String identity = JOptionPane.showInputDialog("Insert the identity: ");
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Insert the number of the cohorte "));
        String cv = JOptionPane.showInputDialog("Write your cv:  ");
        String clan = JOptionPane.showInputDialog("Insert your clan:  ");

        Coder instanceFlight = (Coder) instanceModel().insert(new Coder(name, surname, identity,cohorte, cv, clan));
        JOptionPane.showMessageDialog(null, instanceFlight.info());
    }
    public static void getAll(){
        String listCoder = "Coder list\n";
        for(Object iterator : instanceModel().findAll()){
            Coder objCoder = (Coder) iterator;
            listCoder += objCoder.info() + "\n";
        }
        JOptionPane.showMessageDialog(null, listCoder);
    }
    public static void upDate(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Coder coderSelected = (Coder) JOptionPane.showInputDialog(null,"Select the coder to edit",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        if(coderSelected == null){
            JOptionPane.showMessageDialog(null, "Coder not found");
        }
        coderSelected.setName(JOptionPane.showInputDialog(null,"Enter the new coder's name: ", coderSelected.getName()));
        coderSelected.setSurname(JOptionPane.showInputDialog(null, "Insert the new coder's surname: ", coderSelected.getSurname()));
        coderSelected.setIdentity(JOptionPane.showInputDialog(null, "Insert the new coder's identity: ", coderSelected.getIdentity()));
        coderSelected.setCohorte(Integer.parseInt(JOptionPane.showInputDialog(null, "Insert the new cohorte: ", coderSelected.getCohorte())));
        coderSelected.setCv(JOptionPane.showInputDialog(null, "Insert the new cv: ", coderSelected.getCv()));
        coderSelected.setClan(JOptionPane.showInputDialog(null, "Insert the new coder's clan: ", coderSelected.getClan()));
        instanceModel().upDate(coderSelected);
    }
    public static void delete(){
        Object[] option = Utils.listToArray(instanceModel().findAll());
        Coder CoderSelected = (Coder) JOptionPane.showInputDialog(null,"Select the coder to delete",
                "",
                JOptionPane.QUESTION_MESSAGE,null,
                option, option[0]
        );
        int confirm =  JOptionPane.showConfirmDialog(null,"Are you sure that you want to delete this coder?\n " + CoderSelected.info());
        if(confirm == 0) instanceModel().delete(CoderSelected);

    }
    public static void getByName(){
        String name = JOptionPane.showInputDialog("\n Enter the coder clan to find: ");
        CoderModel objCoderModel = new CoderModel();

        String listaString = "The coder with name "+name+" is:\n";
        for(Coder iterador: objCoderModel.foundByName(name)){
            listaString += iterador.info() + "\n";
        }

            JOptionPane.showMessageDialog(null, listaString );

    }
    public static void getByCohorte(){
        String name = JOptionPane.showInputDialog("\n Enter the coder cohorte to find: ");
        CoderModel objCoderModel = new CoderModel();

        String listaString = "The coder with name "+name+" is:\n";
        for(Coder iterador: objCoderModel.foundByCohorte(name)){
            listaString += iterador.info() + "\n";
        }

        JOptionPane.showMessageDialog(null, listaString );

    }
    public static CoderModel instanceModel(){
        return new CoderModel();
    }
}
