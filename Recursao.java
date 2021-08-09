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
            throw new IllegalArgumentException("número deve ser positivo");
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
            throw new IllegalArgumentException("número deve ser positivo");
        }

        if(n == 0) return 0;

        return n + somatorio(n-1);
    }

    /*
    Modelagem:
    Ex.: n=-1  n=0  n=5
    1. Situação de erro: n<0
    2. Situações de parada:
        n==0 -> 0
        n==1 -> 1
    3. Recursão:
        fibonacci(n-1) + fibonacci(n-2)
        fibonacci(4) + fibonacci(3)
    */
    public static int fibonacci(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("número deve ser positivo");
        }

        if(n == 0) return 0;
        if(n == 1) return 1;

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
}