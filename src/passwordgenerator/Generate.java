/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordgenerator;

import java.util.Random;

/**
 *
 * @author kousik
 */
public class Generate {
    /* Data Members */
    
    private String password;
    private int length;
    private boolean upperCase, numbers, specialChar;
    
    /* Constructor */
    
    public Generate(boolean upperCase, boolean numbers, boolean specialChar){
        this.upperCase = upperCase;
        this.numbers = numbers;
        this.specialChar = specialChar;
        this.length = Generate.random(8, 16);
        this.generatePassword();
    }
    
    public Generate(int len, boolean upperCase,
                        boolean numbers, boolean specialChar
                    ){
        this.upperCase = upperCase;
        this.numbers = numbers;
        this.specialChar = specialChar;
        this.length = len;
        this.generatePassword();
    }
    
    /* Methods */
    
    private void setPassword(String pass){
        this.password = pass;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    private void generatePassword(){
        StringBuilder pass = new StringBuilder();
        while(pass.length() != this.length){
            int num = Generate.random(1, 10);
            
            if(this.specialChar && num == 1 ||
                    this.upperCase && num == 2 ||
                    this.numbers && num == 3
              ){
               switch(num){
                case 1:
                    pass.append(randomSpecialChar());
                    break;
                case 2:
                    pass.append(randomCapAlpha());
                    break;
                case 3:
                    pass.append(randomNumber());
                    break;
            } 
                
            } else {
                    pass.append(randomSmallAlpha());
            }
            
            
        }
        
        this.setPassword(pass.toString());
        
    }
    
    private String randomCapAlpha(){
        int alpha = Generate.random(65, 90);
        return Character.toString((char) alpha);
    }
    
    private String randomSmallAlpha(){
        int alpha = Generate.random(97, 122);
        return Character.toString((char) alpha);
    }
    
    private String randomNumber(){
        int alpha = Generate.random(48, 57);
        return Character.toString((char) alpha);
    }
    
    private String randomSpecialChar(){
        int alpha = Generate.random(0, 3);
        String character;
        switch(alpha){
            case 0:
                character = "&";
                break;
            case 1:
                character = "@";
                break;
            case 2:
                character = "$";
                break;
            default:
                character="@";
        }
        return character;
    }
    
    /* Random number generator between range */
    public static int random(int min, int max){
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
