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
}