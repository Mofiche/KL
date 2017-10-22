
class Caesar {
    String encrypt(String input, int key){ // Methode zur Verschlüsselung
        String ret = "";
        input = input.replaceAll("[^a-zA-Z]","").toUpperCase();
        for( int i = 0; i < input.length(); ++i )
        {
            if(input.charAt(i) == ' ') ret+= input.charAt(i);
                else{
            ret += (char) ((input.charAt(i) - 65 + key) % 26 + 65);
        }
        }
        return ret.toLowerCase();
    }

    String decrypt(String input, int key){ // Methode zur Entschlüsselung
        String ret = "";
        input = input.toUpperCase();
        for( int i = 0; i < input.length(); ++i ) {
            if (input.charAt(i) == ' ') ret += input.charAt(i);
            else {
                ret += (char) ((input.charAt(i) + 65 - key) % 26 + 65);
            }
        }
        return ret.toLowerCase();
    }

}
