/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author kousik
 */
public class GeneratePasswordController implements Initializable {
    
    @FXML
    private Button generate;
    
    @FXML
    private TextField password;
    
    @FXML
    private ComboBox length;
    
    @FXML
    private CheckBox upperCase, numbers, specialChar;
    
    private Generate generatePass;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        boolean upperCase, numbers, specialChar;
        
        if(length.getValue() == null){
            this.generatePass = new Generate( this.upperCase.isSelected(),
                                                this.numbers.isSelected(),
                                                this.specialChar.isSelected()
                                            );
        } else {
            this.generatePass = new Generate( (int) length.getValue(),
                                                this.upperCase.isSelected(),
                                                this.numbers.isSelected(),
                                                this.specialChar.isSelected()
                                            );
        }
        
//        System.out.println(this.length.getValue());
        password.setText(this.generatePass.getPassword());
//        System.out.println(length.getValue());
        
    }
    
    @FXML
    private void test(ActionEvent event){
//        System.out.println(this.length.getPromptText());
//        System.out.println(length.getValue());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        for(int i = 8; i <= 16; i++)
            length.getItems().add(i);
    }    
    
}
