import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

class Algorithmen{
    private KeyPair pair = null;
    Algorithmen() throws NoSuchAlgorithmException {
    }

   private Caesar caesar = new Caesar();
   private Vigenere vigenere = new Vigenere();
   private RSA rsa = new RSA();



   String Caesar_encrypt(String input, int key){
       if(key > 0 && key < 26 && !input.isEmpty()) return caesar.encrypt(input,key);
       else {
           JOptionPane.showMessageDialog(null,"Bitte geben sie eine Zahl zwischen 1 und 25 ein");
           return null;
       }
   }

   String Caesar_decrypt(String input, int key){
       if(key > 0 && key < 26 && !input.isEmpty()) return caesar.decrypt(input,key);
       else {
           JOptionPane.showMessageDialog(null,"Bitte geben sie eine Zahl zwischen 1 und 25 ein");
            return null;
       }
   }

   String Vigenere_encrypt(String input, String key){
     return vigenere.encrypt(input,key);
   }

   String Vigenere_decrypt(String input, String key){
       return vigenere.decrypt(input,key);
   }

    String RSA_encrypt(String input, RSAKey key){
        return rsa.encrypt(input,key);
    }

    String RSA_decrypt(String input, RSAKey key){
        return rsa.decrypt(input,key);
    }

}