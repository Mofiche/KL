import java.math.BigInteger;

class Algorithmen {

        private int ggt(int a, int b) {
            if (b == 0) return a;      // Algorithmus für den größten gemeinsamen Teiler
            else return ggt(b, a % b);
        }

   /**     private int u = 0;
        private int v = 0;

        private int erweiterterggt(int a, int b) { // ax + by = ggt(a,b)


            if (b == 0) {
                u = 1;
                v = 0;
            } else {
                erweiterterggt(b, a % b);
                int x = u;
                u = v;
                v = x - a / b * v;
            }

            return u;

        }
      **/

        private int kgv(int a, int b) {
            if (a == b) return a;  // Algorithmus für das kleinste gemeinsame Vielfache
            return (a * b) / ggt(a, b);
        }

        private boolean teilerfremdheit(int a, int b) {  // Algotithmus zur Überprüfung der Teilerfremdheit
            return kgv(a, b) == a * b;
        }

        private boolean primzahltest(int Number) {
            for (int i = 2; i <= Number - 1; i++) {                                       // Prüft ob eine Zahl prim ist
                if (Number % i == 0) return false;
            }
            return true;
        }

        public int char2int(char a) {
            int ret = 0;
            switch (a) {
                case 'a':
                    ret = 1;
                    break;
                case 'b':
                    ret = 2;
                    break;
                case 'c':
                    ret = 3;
                    break;
                case 'd':
                    ret = 4;
                    break;
                case 'e':
                    ret = 5;
                    break;
                case 'f':
                    ret = 6;
                    break;
                case 'g':
                    ret = 7;
                    break;
                case 'h':
                    ret = 8;
                    break;
                case 'i':
                    ret = 9;
                    break;
                case 'j':
                    ret = 10;
                    break;
                case 'k':
                    ret = 11;
                    break;
                case 'l':
                    ret = 12;
                    break;
                case 'm':
                    ret = 13;
                    break;
                case 'n':
                    ret = 14;
                    break;
                case 'o':
                    ret = 15;
                    break;
                case 'p':
                    ret = 16;
                    break;
                case 'q':
                    ret = 17;
                    break;
                case 'r':
                    ret = 18;
                    break;
                case 's':
                    ret = 19;
                    break;
                case 't':
                    ret = 20;
                    break;
                case 'u':
                    ret = 21;
                    break;
                case 'v':
                    ret = 22;
                    break;
                case 'w':
                    ret = 23;
                    break;
                case 'x':
                    ret = 24;
                    break;
                case 'y':
                    ret = 25;
                    break;
                case 'z':
                    ret = 26;
                    break;

                case 'A':
                    ret = 27;
                    break;
                case 'B':
                    ret = 28;
                    break;
                case 'C':
                    ret = 29;
                    break;
                case 'D':
                    ret = 30;
                    break;
                case 'E':
                    ret = 31;
                    break;
                case 'F':
                    ret = 32;
                    break;
                case 'G':
                    ret = 33;
                    break;
                case 'H':
                    ret = 34;
                    break;
                case 'I':
                    ret = 35;
                    break;
                case 'J':
                    ret = 36;
                    break;
                case 'K':
                    ret = 37;
                    break;
                case 'L':
                    ret = 38;
                    break;
                case 'M':
                    ret = 39;
                    break;
                case 'N':
                    ret = 40;
                    break;
                case 'O':
                    ret = 41;
                    break;
                case 'P':
                    ret = 42;
                    break;
                case 'Q':
                    ret = 43;
                    break;
                case 'R':
                    ret = 44;
                    break;
                case 'S':
                    ret = 45;
                    break;
                case 'T':
                    ret = 46;
                    break;
                case 'U':
                    ret = 47;
                    break;
                case 'V':
                    ret = 48;
                    break;
                case 'W':
                    ret = 49;
                    break;
                case 'X':
                    ret = 50;
                    break;
                case 'Y':
                    ret = 51;
                    break;
                case 'Z':
                    ret = 52;
                    break;
            }
            return ret;
        }  // Funktion zur Umwandlung von Buchstaben in Zahlen

        private char int2char(int a) {
            char ret = 0;
            switch (a) {
                case 1:
                    ret = 'a';
                    break;
                case 2:
                    ret = 'b';
                    break;
                case 3:
                    ret = 'c';
                    break;
                case 4:
                    ret = 'd';
                    break;
                case 5:
                    ret = 'e';
                    break;
                case 6:
                    ret = 'f';
                    break;
                case 7:
                    ret = 'g';
                    break;
                case 8:
                    ret = 'h';
                    break;
                case 9:
                    ret = 'i';
                    break;
                case 10:
                    ret = 'j';
                    break;
                case 11:
                    ret = 'k';
                    break;
                case 12:
                    ret = 'l';
                    break;
                case 13:
                    ret = 'm';
                    break;
                case 14:
                    ret = 'n';
                    break;
                case 15:
                    ret = 'o';
                    break;
                case 16:
                    ret = 'p';
                    break;
                case 17:
                    ret = 'q';
                    break;
                case 18:
                    ret = 'r';
                    break;
                case 19:
                    ret = 's';
                    break;
                case 20:
                    ret = 't';
                    break;
                case 21:
                    ret = 'u';
                    break;
                case 22:
                    ret = 'v';
                    break;
                case 23:
                    ret = 'w';
                    break;
                case 24:
                    ret = 'x';
                    break;
                case 25:
                    ret = 'y';
                    break;
                case 26:
                    ret = 'z';
                    break;

                case 27:
                    ret = 'A';
                    break;
                case 28:
                    ret = 'B';
                    break;
                case 29:
                    ret = 'C';
                    break;
                case 30:
                    ret = 'D';
                    break;
                case 31:
                    ret = 'E';
                    break;
                case 32:
                    ret = 'F';
                    break;
                case 33:
                    ret = 'G';
                    break;
                case 34:
                    ret = 'H';
                    break;
                case 35:
                    ret = 'I';
                    break;
                case 36:
                    ret = 'J';
                    break;
                case 37:
                    ret = 'K';
                    break;
                case 38:
                    ret = 'L';
                    break;
                case 39:
                    ret = 'M';
                    break;
                case 40:
                    ret = 'N';
                    break;
                case 41:
                    ret = 'O';
                    break;
                case 42:
                    ret = 'P';
                    break;
                case 43:
                    ret = 'Q';
                    break;
                case 44:
                    ret = 'R';
                    break;
                case 45:
                    ret = 'S';
                    break;
                case 46:
                    ret = 'T';
                    break;
                case 47:
                    ret = 'U';
                    break;
                case 48:
                    ret = 'V';
                    break;
                case 49:
                    ret = 'X';
                    break;
                case 50:
                    ret = 'X';
                    break;
                case 51:
                    ret = 'Y';
                    break;
                case 52:
                    ret = 'Z';
                    break;
            }
            return ret;
        } // Funktion zur Umwandlung von Zahlen in Buchstaben
    
        public BigInteger[] String2BigIntegerArray(String input){


            char[] input_c = input.toCharArray();
            BigInteger[] output = new BigInteger[input_c.length];

            for (int i = 0 ; i < input_c.length; i++ ) output[i] = new BigInteger(String.valueOf(char2int(input_c[i])));
            
            return output;
        }


        String Caesar_encrypt(String input, int key) {
            String output = "";

            char[] input_c = input.toCharArray();
            char[] output_c = new char[input_c.length];

            for (int i = 0; i < input_c.length; i++) {
                char a = input_c[i];
                int b = char2int(a);
                a = int2char(b + (key % 26)); // key%26 für key>26
                output_c[i] = a;
            }
            output = new String(output_c);
            return output;
        }

        String Caesar_decrypt(String input, int key) {
            String output = "";

            char[] input_c = input.toCharArray();
            char[] output_c = new char[input_c.length];

            for (int i = 0; i < input_c.length; i++) {
                char a = input_c[i];
                int b = char2int(a);
                a = int2char(b - (key % 26)); // key%26 für key>26
                output_c[i] = a;
            }
            output = new String(output_c);
            return output;
        }

        String Vignerre_encrypt(String input, String key) {

            key = key.toLowerCase();
            input = input.toLowerCase();
            char[] input_c = input.toCharArray();
            char[] key_c = key.toCharArray();
            char[] output_c = new char[input_c.length];

            for (int i = 0; i < input_c.length; i++) {
                char a = input_c[i];
                int b = char2int(a);

                char c = key_c[i % key_c.length];
                int d = char2int(c);
                a = int2char((b + d) % 52);
                output_c[i] = a;
            }

            return new String(output_c);
        }

        String Vignerre_decrypt(String input, String key) {

            key = key.toLowerCase();
            input = input.toLowerCase();
            char[] input_c = input.toCharArray();
            char[] key_c = key.toCharArray();
            char[] output_c = new char[input_c.length];

            for (int i = 0; i < input_c.length; i++) {
                char a = input_c[i];
                int b = char2int(a);

                char c = key_c[i % key_c.length];
                int d = char2int(c);
                a = int2char((b - d) % 26);
                output_c[i] = a;
            }

            return new String(output_c);
        }

    BigInteger[] RSA(int a, int b){



        BigInteger p = new BigInteger(String.valueOf(a));
        BigInteger q = new BigInteger(String.valueOf(b));
        BigInteger mod = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        BigInteger public_k = new BigInteger("23"); // 5.Fermat Zahl = 2^16 +1
        BigInteger private_k = public_k.modInverse(phi);

        return new BigInteger[]{mod,public_k, private_k};
    }

        BigInteger RSA_decrypt(BigInteger input, BigInteger private_k , BigInteger mod){
        return input.modPow(private_k,mod);
         }

        BigInteger RSA_encrypt(BigInteger input , BigInteger public_k , BigInteger mod){
        return input.modPow(public_k,mod);
    }


    }

