




public class Test {

    public static void main(String[] args) {

        Algorithmen alg = new Algorithmen();

      /** System.out.println(alg.erweiterterggt(23,120));



        String a = "KomplexeLeistung";

        String c = alg.Caesar_encrypt(a,1);
        System.out.println(a);
        System.out.println(c);
        c = alg.Caesar_decrypt(c , 1);
        System.out.println(c);

        c = alg.Vignerre_encrypt(a,"ABCDEF");
        System.out.println(a);
        System.out.println(c);
        c = alg.Vignerre_decrypt(c , "ABCDEF");
        System.out.println(c);


       **/

      RSA_key[] keys;
      keys = alg.RSA_Key_generation(11,13,23);
      System.out.println(keys[0].p);
      System.out.println(keys[0].q);
      System.out.println(keys[1].p);
      System.out.println(keys[1].q);


    }

}
/**

// Zerlegt Zahlen mit der Methode von Fermat.
// Erster Parmeter ist die Zahl n, zweiter optionaler Parameter die Startzahl der Suche

/**
import javax.swing.*;
import java.math.BigInteger;

public class Test extends Thread
{
    private BigInteger n;
    public boolean fertig = false;
    public BigInteger start = null;
    private BigInteger wert = null;
    private static BigInteger ZWEI = BigInteger.valueOf(2);
    private static BigInteger SIEBEN = BigInteger.valueOf(7);
    private static BigInteger DREI = BigInteger.valueOf(3);
    private static BigInteger FUENF = BigInteger.valueOf(5);
    private static boolean DEBUG = false;
    public static long zeit_start;

    public Test(BigInteger p_n, BigInteger p_start)
    {
        if (p_n.isProbablePrime(1)) System.out.println ("Ist wahrsch. Primzahl");
        n = p_n; start = p_start; wert = null;

        // folgende Anweisungen für das Betriebssystem
        fertig = false;
        this.setPriority(Thread.MIN_PRIORITY);  // damit man nebenher noch was machen kann

        // Haken, dass beim Herunterfahren (oder CTRL + C) die aktuellen Werte nicht verloren gehen
        Runtime.getRuntime().addShutdownHook(new FermatHaken(this));
    }

    // Die Hauptsausführung
    public void run()
    {
        zeit_start = System.currentTimeMillis();
        if (start == null)
        {
            start = holeWurzel(n, false);
            // Ist die Zahl eine Quadratzahl, dann schon fertig !
            if (start.multiply(start).equals(n))
            {
                System.out.println ("Quadratzahl " + n); fertig = true; return;
            }
            start = start.add(BigInteger.ONE);
        }
        else System.out.println ("Mache weiter ...");
        wert = start.modPow(ZWEI,n);

        do
        {
            if (DEBUG) System.out.println (start + " --> " + wert);
            // Signatur:
            // System.out.println ("," +wert.intValue() % 3 + "," + wert.intValue() % 5 + "," + wert.intValue() % 7);

            BigInteger test = istWurzel(wert);
            // System.out.println ("nach istWurzel");
            if (test != null)
            {
                BigInteger erg = n.gcd(start.subtract(test));
                if (! erg.equals(BigInteger.ONE)) System.out.println ("Teiler " + erg + " bei " + start);
                System.out.println ("fertig"); fertig = true; break;
            }
            if (fertig) break;  // nicht mehr weitermachen. Besser: in neuen Variablen speichern !
            wert = wert.add(start); if (wert.compareTo(n) >= 0) wert = wert.subtract(n);
            wert = wert.add(start); if (wert.compareTo(n) >= 0) wert = wert.subtract(n);
            wert = wert.add(BigInteger.ONE); if (wert.compareTo(n) >= 0) wert = wert.subtract(n);
            start = start.add(BigInteger.ONE);
        }
        while (! fertig);

    }

    // diese Methode ist für die Effizenz sehr entscheidend - Versucht, in den ganzen Zahlen Z eine Wurzel zu ziehen
    // 20.01.2009: modifiziert zu QuadratSieb4: static, kein mod n
    private static final BigInteger istWurzel(BigInteger para)
    {
        if ((para.getLowestSetBit() & 1) == 1) return null;
        // ist ungerade oder durch 4 teilbar
        int weg = para.getLowestSetBit();
        BigInteger q = para.shiftRight(weg);
        weg = weg >> 1;
        if (1 != q.and(Test.SIEBEN).intValue()) return null;  //  kein Quadrat

        return holeWurzel(para, true);  // exakt berechnen.
    }


    // berechnet Wurzel mit Heron-Verfahren.
    // wenn angegeben nurExakt, wird Wurzel nur bei exakter Gleichheit zurckgeliefert
    // x[n+1] = (x[n] + q/x[n]) / 2
    private final static BigInteger holeWurzel (BigInteger eingabe, boolean nurExakt)
    {
        // System.out.println ("Wurzel der " + eingabe + " exakt " + nurExakt);
        if (eingabe.signum() < 0) return null;
        if (eingabe.compareTo(ZWEI) < 0) return eingabe;  // 0, 1
        // Fr Startwert bilde die obersten 2 Bit ab (auf die Hlfte des Exponenten)
        BigInteger wert = BigInteger.ONE;
        for (int i = eingabe.bitLength() -1, tmp = 0; (i >= 2) && (tmp < 2); --i)
        {
            if (eingabe.testBit(i) && !wert.testBit(i >> 1))
            {
                wert = wert.setBit(i >> 1); ++tmp;
            }
        }
        BigInteger erg = null, vorgaenger = null;
        BigInteger rueck [];

        // Schleife durchlaufen. Divsision arbeitet ganzzahlig
        // bei 35: Hier Oszillation zwischen 6 --> 5 --> 6 ) !
        while (true) {
            rueck = eingabe.divideAndRemainder(wert);
            if ((rueck[0].equals(wert)) &&
                    (rueck[1].equals(BigInteger.ZERO)) ) return wert;  // exakt gefunden
            // nchsten Folgewert berechnen
            erg = rueck[0].add (wert);
            erg = erg.shiftRight(1);
            // System.out.println (erg.toString() );  // fr Testzwecke, zum Sehen der Approximation
            if (erg.equals(wert))
                return (nurExakt ? null : wert);  // keine Vernderung mehr, aber Rest

            if ((vorgaenger != null) && (erg.equals(vorgaenger)))
            {
                if (nurExakt) return null;
                if (wert.compareTo(erg) < 0) return wert; else return erg;  // immer das kleinere nehmen
            }
            vorgaenger = wert; wert = erg;
        }
    } // Ende Methode holeWurzel

    BigInteger numb = new BigInteger (JOptionPane.showInputDialog("Enter number"));

    public static void main (String [] args)
    {
        /*
        if (args.length < 1)
        {
            System.out.println ("Syntax: Fermat <zahl> <Startx> "); System.exit(1);
        }


        // Eingabeprüfung
        boolean fehler = false;
        for (int i = 0; i < args.length; ++i)
        {
            try
            {
                BigInteger rueck = new BigInteger(args[i]); if (rueck.signum() < 0) fehler = true;
            }
            catch (Exception ex) { fehler = true; }
            if (fehler) { System.out.println ("Fehlerhafter Eingabeparameter " + (i+1)); System.exit(1); }
        }


        new Test(new BigInteger(numb.toString()),
                (args.length >= 2) ? new BigInteger(args[1]) : null
        ).start();
    }

    // wegen Shutdown: innere Klasse
    class FermatHaken extends Thread
    {
        private Test w;
        FermatHaken(Test p) { w = p; }
        public void run()
        {

            long zeit_ende = System.currentTimeMillis();
            System.out.println("Zahl war :" + numb.toString);
            System.out.println ("Zeitaufwand (Min): " + (zeit_ende - zeit_start) / (1000 * 60.0));


            if (! w.fertig)
            {
                w.fertig = true;  // damit oben nicht mehr weitergemacht wird !
                System.out.println ("Abbruchstand:\nx= " + w.start.toString());
            }
        }
    }

}
**/