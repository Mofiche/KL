public class Vigenere {

    String encrypt(String input, String key) {
        String ret = "";
        input = input.replaceAll("[^a-zA-Z]","").toUpperCase();
        for( int i = 0; i < input.length(); ++i )
        {
            ret += (char) ( ( input.charAt( i ) + 65 - key.charAt(i%key.length()) ) % 26 + 65 );
        }
        return ret.toLowerCase();
    }

    String decrypt(String input, String key) {
        String ret = "";
        input = input.replaceAll("[^a-zA-Z]","").toUpperCase();
        for( int i = 0; i < input.length(); ++i )
        {
            ret += (char) ( ( input.charAt( i ) - 65 + key.charAt(i%key.length()) ) % 26 + 65 );
        }
        return ret.toLowerCase();
    }
}
