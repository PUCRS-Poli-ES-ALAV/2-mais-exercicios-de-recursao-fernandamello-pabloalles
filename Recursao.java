import java.util.ArrayList;

public class Recursao {
    public static void main(String[] args) {
    }

    /*
    Modelagem:
    Ex.: n=-1  n=0  n=1  n=5
    1. Situação de erro: n<0
    2. Situações de parada:
        n==0 -> 1
        n==1 -> 1
    3. Recursão:
        n * fatorial(n-1)
        5 * fatorial(4)
    */
    public static int fatorial(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("número deve ser zero ou positivo");
        }
        if(n == 0 || n == 1) {
            return 1;
        }

        return n * fatorial(n-1);
    }

    /*
    Modelagem:
    Ex.: n=-1  n=0  n=5
    1. Situação de erro: n<0
    2. Situações de parada:
        n==0 -> 0
    3. Recursão:
        n + somatorio(n-1)
        5 + somatorio(4)
    */
    public static int somatorio(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("número deve ser zero ou positivo");
        }

        if(n == 0) return 0;

        return n + somatorio(n-1);
    }

    /*
    Modelagem:
    Ex.: n=-1  n=0  n=5
    1. Situação de erro: n<=0
    2. Situações de parada:
        n==1 -> 1
        n==2 -> 1
    3. Recursão:
        fibonacci(n-1) + fibonacci(n-2)
        fibonacci(4) + fibonacci(3)
    */
    public static int fibonacci(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("número deve ser positivo");
        }

        if(n == 1) return 1;
        if(n == 2) return 1;

        return fibonacci(n-1) + fibonacci(n-2);
    }

    /*
    Modelagem:
    Ex.: k=-1,j=3  k=2,j=-1
    1. Situação de erro: não existe
    2. Situações de parada:
        k=j -> k
    3. Recursão:
        k + somatorioEntreNumeros(k+1,j)
        -1 + somatorioEntreNumeros(0,3)
        -1 + somatorioEntreNumeros(0,2)
    */
    public static int somatorioEntreNumeros(int k, int j) {
        if(k == j) return k;

        if(k > j) {
            int tmp = k;
            k = j;
            j = tmp;
        }

        return k + somatorioEntreNumeros(k+1, j);
    }

    /*
    Modelagem:
    Ex.: str=null  str=""  str="a"  str="abba"
    1. Situação de erro:
        str == null -> IllegalArgumentException
    2. Situações de parada:
        str.comprimento == 0 -> true
        str.comprimento == 1 -> true
        pos == (str.comprimento)/2 -> true
        str[pos] != str[str.comprimento-1-pos] -> false
    3. Recursão:
        true && palindromo(str, pos+1)
        true && palindromo('abba', 1)
    */
    public static boolean palindromo(String str) {
        if(str == null){
            throw new IllegalArgumentException("String não pode ser null");
        }

        if(str.length() == 0 || str.length() == 1)
            return true;

        return palindromo(str, 0);
    }
    public static boolean palindromo(String str, int pos) {
        if(pos == str.length()/2)
            return true;

        if(str.charAt(pos) != str.charAt(str.length()-1-pos))
            return false;

        return true && palindromo(str, pos+1);
    }

    /*
    Modelagem:
    Ex.: n=-1  n=0  n=6
    1. Situação de erro:
        n < 0 -> IllegalArgumentException
    2. Situações de parada:
        n == 0 -> ""
    3. Recursão:
        convBase2(n/2) + "1" ou convBase2(n/2) + "0"
        convBase2(3) + "0"
    */
    public static String convBase2(int n) {
        if(n<0) {
            throw new IllegalArgumentException("número não pode ser negativo");
        }

        if(n == 0) return "";

        if(n%2 != 0) {
            return convBase2(n/2) + "1";
        }
        else {
            return convBase2(n/2) + "0";
        }
    }

    /*
    Modelagem:
    Ex.: arr=null  arr={}  arr={1,2,3}
    1. Situação de erro:
        arr == null -> IllegalArgumentException
    2. Situações de parada:
        arr.size() == 0 -> 0
    3. Recursão:
        arr.remove(0) + somatorio2(arr)
        1 + somatorio2({2,3})
    */
    public static int somatorio2(ArrayList<Integer> arr) {
        if(arr == null)
            throw new IllegalArgumentException("arraylist não pode ser null");

        if(arr.size() == 0)
            return 0;
        
        return arr.remove(0) + somatorio2(arr);
    }

    /*
    Modelagem:
    Ex.: arr=null  arr={}  arr={1,2,3}
    1. Situação de erro:
        arr == null -> IllegalArgumentException
        arr.size() == 0 -> IllegalArgumentException
    2. Situações de parada:
        arr.size() == 0 -> maior (método auxiliar)
    3. Recursão:
        findBiggest(arr,maior)
        findBiggest({2,3},1)
    */
    public static int findBiggest(ArrayList<Integer> arr) {
        if(arr == null)
            throw new IllegalArgumentException("arraylist não pode ser null");

        if(arr.size() == 0) {
            throw new IllegalArgumentException("arraylist não pode ser vazia");  
        }

        return findBiggest(arr, 0);
    }
    public static int findBiggest(ArrayList<Integer> arr, int maior) {
        if(arr.size() == 0){
            return maior;
        }

        int tmp = arr.remove(0);
        if(tmp > maior)
            return findBiggest(arr,tmp);
        
        return findBiggest(arr,maior);
    }

    /*
    Modelagem:
    Ex.: str="batata" match="ta"
    1. Situação de erro:
        str == null -> IllegalArgumentException
        match == null -> IllegalArgumentException
        str.comprimento == 0 -> IllegalArgumentException
        match.comprimento == 0 -> IllegalArgumentException
    2. Situações de parada:
        indexM == (match.comprimento - 1) && match.charAt(indexM) != str.charAt(indexS) -> false
        indexM == (match.comprimento - 1) && match.charAt(indexM) == str.charAt(indexS) -> true
    3. Recursão:
        if (str.charAt(indexS) == match.charAt(indexM)) {
            return true && findSubStr(str, match, indexS+1, indexM+1);
        }
        else {
            return findSubStr(str, match, indexS+1, indexM);
        }
    */
    public static boolean findSubStr(String str, String match) {
        if(str == null || match == null)
            throw new IllegalArgumentException("string s cannot be null");
        if(str.length() == 0 || match.length() == 0)
            throw new IllegalArgumentException("string s cannot be empty");

        return findSubStr(str, match, 0, 0);  
    }
    public static boolean findSubStr(String str, String match, int indexS, int indexM) {
        if(indexM == (match.length() - 1)) {
            if(match.charAt(indexM) != str.charAt(indexS))
                return false;
            else
                return true;
        }

        if(str.charAt(indexS) == match.charAt(indexM)) {
            return true && findSubStr(str, match, indexS+1, indexM+1);
        }
        else {
            return findSubStr(str, match, indexS+1, indexM);
        }
    }

    /*
    Modelagem:
    Ex.: n=10  n=0  n=600  n=-10
    1. Situação de erro:
        Nenhuma
    2. Situações de parada:
        if(n==0) -> return 1;
    3. Recursão:
        1+nroDigit(n)
        1+nroDigit(60)
        1
    */
    public static int nroDigit(int n) {        
        n = n/10;
        if(n!=0)
            return 1 + nroDigit(n);        
        return 1;
    }

    /*
    Modelagem:
    Ex.: s=null  s="" s="a" s="abc"
    1. Situação de erro:
        s == null -> IllegalArgumentException
        s.comprimento == 0 -> IllegalArgumentException (string vazia)
    2. Situações de parada:
        s.comprimento == 1 -> add(p+s) -> return a
    3. Recursão:
        for(i=0; i<s.comprimento; i++)
            permutations(s[i], s[0...i]+s[i+1...s.comprimento], new ArrayList<String>())
        
        ex.:
        for(i=0; i<"abc".comprimento; i++)
            permutations("a", ""+"bc", new ArrayList<String>())
    */
    public static ArrayList<String> permutations(String s) {
        if(s == null)
            throw new IllegalArgumentException("string s cannot be null");
        if(s.length() == 0)
            throw new IllegalArgumentException("string s cannot be empty");

        ArrayList<String> a = new ArrayList<String>();
        return permutations("", s, a);
    }
    public static ArrayList<String> permutations(String p, String s, ArrayList<String> a) {
        if(s.length() == 1) {
            a.add(p+s);
            return a;
        }
        for(int i=0; i<s.length(); i++) {
            ArrayList<String> tmp = permutations(
                ""+s.charAt(i), 
                s.substring(0, i) + s.substring(i + 1, s.length()), 
                new ArrayList<String>()
            );

            for(int j=0; j<tmp.size(); j++){
                if(tmp.get(j).length() != s.length())
                    tmp.set(j, s.charAt(i)+tmp.get(j));

                if(!a.contains(tmp.get(j)))
                    a.add(tmp.get(j));
            }
        }

        return a;
    }
}