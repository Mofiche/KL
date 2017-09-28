import java.math.BigInteger;

public class RSA {

    private long modinv(long m, long mod){  //Methode zur Berechnung des modularen inversen einer Zahl
       BigInteger n = new BigInteger(String.valueOf(m));
       BigInteger mo = new BigInteger(String.valueOf(mod));
       return n.modInverse(mo).longValueExact();
   }

    private long modpow(long i, long x, long n) { // Methode zur Berechnung des Modolus einer Potenz
        BigInteger imp = new BigInteger(String.valueOf(i));
        BigInteger xmp = new BigInteger(String.valueOf(x));
        BigInteger nmp = new BigInteger(String.valueOf(n));

        return imp.modPow(xmp,nmp).longValueExact();
    }

   RSAKey[] gen(long p, long q , long e){ // Methode zur Erzeugung der RSA-Schlüssel

       RSAKey pub = new RSAKey(e, p * q);
       RSAKey pri = new RSAKey(modinv(e,(p-1)*(q-1)),p*q);
       return new RSAKey[]{pub,pri};
   }

   String crypt(String message, RSAKey key){ // Methode zur Ver- / Entschlüsselung
       String output = "";

       for(char i : message.toCharArray()){
           output += (char) (modpow(i,key.x,key.n)% 128);
       }

       return output;
   }
}
