
import controller.CoderController;
import controller.CompanyController;
import controller.HiringController;
import controller.VacantController;
import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ConfigDB.openConnection();

        String option = "";
        do{
            option = JOptionPane.showInputDialog(
                    """
                       Welcome to RIWI
                       
                       1.Consult coders
                       2.Consult vacants   
                       3.Consult hiring 
                       4.Consult company 
                       5.close
                            """);
            switch (option){
                case"1":
                    String option2 = "";
                    do{
                        option2 = JOptionPane.showInputDialog(
                                """ 
                                      CODERS
                                       
                                       1. Create coders
                                       2. Show coders       
                                       3. Delete coders  
                                       4. Update coders  
                                       5. Search coders by clan
                                       6. Search coders by cohorte
                                       7. Back
                                       
                                            """);
                        switch (option2){
                            case"1":
                                CoderController.create();
                                break;
                            case"2":
                                CoderController.getAll();
                                break;
                            case"3":
                                CoderController.delete();
                                break;
                            case"4":
                                CoderController.upDate();
                                 break;
                            case"5":
                                CoderController.getByName();
                                break;
                            case"6":
                                CoderController.getByCohorte();
                                break;
                        }

                    }while (!option2.equals("7"));
                    break;
                case"2":
                    String option3 = "";
                    do{
                        option3 = JOptionPane.showInputDialog(
                                """
                                   VACANT
                                   
                                   1. Create vacant
                                   2. Show vacant       
                                   3. Delete vacant  
                                   4. Update vacant  
                                   5. Search vacant for title and tecnology 
                                   6. Back
                                   
                                        """);
                        switch (option3){
                            case"1":
                                VacantController.create();
                                break;
                            case"2":
                                VacantController.getAll();
                                break;
                            case"3":
                                VacantController.delete();
                                break;
                            case"4":
                                VacantController.upDate();
                                break;
                            case"5":
                                VacantController.getByName();
                                break;
                        }

                    }while (!option3.equals("6"));
                    break;
                case"3":
                    String option4 = "";
                    do{
                        option4 = JOptionPane.showInputDialog(
                                """
                                   HIRING
                                   
                                   1. Create hiring
                                   2. Show hiring       
                                   3. Delete hiring  
                                   4. Update hiring  
                                   5. Back
                                   
                                        """);
                        switch (option4){
                            case"1":
                                HiringController.create();
                                break;
                            case"2":
                                HiringController.getAll();
                                break;
                            case"3":
                                HiringController.delete();
                                break;
                            case"4":
                                HiringController.upDate();
                                break;
                        }

                    }while (!option4.equals("5"));
                    break;
                case"4":
                    String option5 = "";
                    do{
                        option5 = JOptionPane.showInputDialog(
                                """
                                   COMPANY
                              
                                   1. Create company              
                                   2. Back
                                   
                                        """);
                        switch (option5){
                            case"1":
                                CompanyController.create();
                                break;
                        }

                    }while (!option5.equals("5"));
                    break;
            }

        }while (!option.equals("5"));
    }
}