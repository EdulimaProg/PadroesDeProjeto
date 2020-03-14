package Singleton;

class ContaCorrente{

    private String numeroConta;
    //cria-se um objeto da classe
    private static ContaCorrente contaCorrente;
//  cria-se um contructor para evitar que a classe seja intacianda diretamente
    private ContaCorrente(){
    }
//  metodo que cria uma nova conta corrente sem alterar o estado
    public static ContaCorrente newInstance(){
        if(contaCorrente == null){
            contaCorrente = new ContaCorrente();
        }
            return contaCorrente;
    }
//  metódo que cria o numero da conta
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }


//  metódo que chama o numero da conta
    public String toString() {
        return numeroConta;
    }
}

public class Sing {
    public static void main(String[] args) {
        new Sing().criarContas();
    }
    public void criarContas(){
        ContaCorrente ct1 = ContaCorrente.newInstance();
        ct1.setNumeroConta("123-45");
        System.out.println(ct1+" "+ct1.hashCode());

        ContaCorrente ct2 = ContaCorrente.newInstance();
        ct2.setNumeroConta("323-35");
        System.out.println(ct2+" "+ct2.hashCode());

    }
}
