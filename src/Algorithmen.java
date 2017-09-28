class Algorithmen{

   private Caesar caesar = new Caesar();  // Cäsar Referenz wird initialisiert
   private Vigenere vigenere = new Vigenere(); // Vigenere Referenz wird initialisiert
   private RSA rsa = new RSA(); // RSA Referenz wird initialisiert

   String Caesar_encrypt(String input, int key){
       return caesar.encrypt(input,key); // Anwendung der encrypt-Methode der Cäsar Klasse
   }

   String Caesar_decrypt(String input, int key){
        return caesar.decrypt(input,key); // Anwendung der decrypt-Methode der Cäsar Klasse
   }

   String Vigenere_encrypt(String input, String key){
     return vigenere.encrypt(input,key); // Anwendung der encrypt-Methode der Vigenere Klasse
   }

   String Vigenere_decrypt(String input, String key){
       return vigenere.decrypt(input,key); // Anwendung der decrypt-Methode der Vigenere Klasse
   }

    String RSA_crypt(String input, RSAKey key){
        return rsa.crypt(input,key); // Anwendung der encrypt-Methode der RSA Klasse
    }


}