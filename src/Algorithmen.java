import java.math.BigInteger;

class Algorithmen {

        private BigInteger[] String2BigIntegerArray(String input){


            char[] input_c = input.toCharArray();
            BigInteger[] output = new BigInteger[input_c.length];

            for (int i = 0 ; i < input_c.length; i++ ) output[i] = new BigInteger(String.valueOf((int)(input_c[i])));
            
            return output;
        }

        private String BigIntegerArray2String(BigInteger[] input){

               char[] output_c = new char[input.length];

             for (int i = 0 ; i < input.length; i++ ) {
                 output_c[i] = (char)(input[i].intValue());
             }
                return new String(output_c);
    }


        String Caesar_encrypt(String str, int key) {

            String ret = "";
            str = str.replaceAll("[^a-zA-Z]","").toUpperCase();
            for( int i = 0; i < str.length(); ++i )
            {
                ret += (char) ( ( str.charAt( i ) - 65 + key ) % 26 + 65 );
            }
            return ret.toLowerCase();


        }

        String Caesar_decrypt(String str, int key) {

            String ret = "";
            str = str.toUpperCase();
            for( int i = 0; i < str.length(); ++i )
            {

                ret += (char)
                        ( ( str.charAt( i ) + 65 - key ) % 26 + 65 );

            }
            return ret.toLowerCase();

        }

        String Vignerre_encrypt(String input, String key) {
            String ret = "";
            input = input.replaceAll("[^a-zA-Z]","").toUpperCase();
            for( int i = 0; i < input.length(); ++i )
            {
                ret += (char) ( ( input.charAt( i ) + 65 - key.charAt(i%key.length()) ) % 26 + 65 );
            }
            return ret.toLowerCase();
        }


        String Vignerre_decrypt(String input, String key) {
            String ret = "";
            input = input.replaceAll("[^a-zA-Z]","").toUpperCase();
            for( int i = 0; i < input.length(); ++i )
            {
                ret += (char) ( ( input.charAt( i ) - 65 + key.charAt(i%key.length()) ) % 26 + 65 );
            }
            return ret.toLowerCase();
            }


        BigInteger[] RSA(int a, int b) {



            BigInteger p = new BigInteger(String.valueOf(a));
            BigInteger q = new BigInteger(String.valueOf(b));
            BigInteger mod = p.multiply(q);
            BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

            BigInteger public_k = new BigInteger("65537"); // 5.Fermat Zahl = 2^16 +1
            BigInteger private_k = public_k.modInverse(phi);

            return new BigInteger[]{mod, public_k, private_k};


       }

        String RSA_decrypt (BigInteger input[], BigInteger private_k, BigInteger mod){
            BigInteger[] ergebnis = new BigInteger[input.length];
            for(int i = 0; i < input.length ; i++) {
                ergebnis[i] = input[i].modPow(private_k, mod);
            }

            return BigIntegerArray2String(ergebnis);
        }

        BigInteger[] RSA_encrypt (String a, BigInteger public_k, BigInteger mod){

            BigInteger[] input;
            input = String2BigIntegerArray(a);

            BigInteger[] ergebnis = new BigInteger[input.length];
            for(int i = 0; i < input.length ; i++) {
                ergebnis[i] = input[i].modPow(public_k, mod);
            }

            return ergebnis;
        }


    }

