import java.math.BigInteger;

/**
 * Created by Moritz on 27.09.2017.
 */
public class RSA {


   /** public static KeyPair gen() throws NoSuchAlgorithmException {
        KeyPair key = null;
        KeyPairGenerator keygen = null;
        keygen = KeyPairGenerator.getInstance("RSA");
        keygen.initialize(512);
        key = keygen.generateKeyPair();
        return key;
    }

    public static byte[] encrypt(String message , PublicKey pk) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,pk);
        return cipher.doFinal(message.getBytes());
    }

    public static String decrypt(byte[] chiffrat, PrivateKey sk) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,sk);
        byte[] dec = cipher.doFinal(chiffrat);
        return new String(dec);


    }
    **/


   long mod(long m, long mod){
       BigInteger n = new BigInteger(String.valueOf(m));
       BigInteger mo = new BigInteger(String.valueOf(mod));
       return n.modInverse(mo).longValueExact();
   }

    long modpow(long i, long x, long n) {
        BigInteger imp = new BigInteger(String.valueOf(i));
        BigInteger xmp = new BigInteger(String.valueOf(x));
        BigInteger nmp = new BigInteger(String.valueOf(n));

        return imp.modPow(xmp,nmp).longValueExact();
    }

   public RSAKey[] gen(long p, long q , long e){

       RSAKey pub = new RSAKey(e, p * q);
       RSAKey pri = new RSAKey(mod(e,(p-1)*(q-1)),p*q);
       return new RSAKey[]{pub,pri};
   }

   String encrypt(String message, RSAKey key){
       String output = "";

       for(char i : message.toCharArray()){
           if(modpow(i,key.x,key.n)% 128 < 32) output += (char) ((modpow(i,key.x,key.n)% 128) +32);
           else
           output += (char) (modpow(i,key.x,key.n)% 128);
       }

       return output;
   }

    String decrypt(String message, RSAKey key){
        String output = "";

        for(char i : message.toCharArray()){
            if(modpow(i,key.x,key.n)% 128 < 32) output += (char) ((modpow(i,key.x,key.n)% 128) +32);
            else
                output += (char) (modpow(i,key.x,key.n)% 128);
        }

        return output;
    }




}
