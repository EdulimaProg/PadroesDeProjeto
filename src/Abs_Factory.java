import javax.jws.WebParam;
import java.util.Scanner;
// nesse padrão são as fabriicas que me retornam o que eu quero
//Classe Pet
abstract class Pet{
    private String nome;

    public Pet(String nome){
        this.nome = nome;
    }
    public String toString(){
        return nome;
    }
}
// a familia pet é divida em dois grupos, Cachorro e gato
abstract class Cachorro extends Pet{

    public Cachorro(String nome) {
        super(nome);
    }
}
abstract class Gato extends Pet{

    public Gato(String nome) {
        super(nome);
    }
}
// quais são os cachorros e gatos ideais para guarda e quais são os ideais para compania
// animal ideal para compania
class Shitzu extends Cachorro{

    public Shitzu() {
        super("Shitzu");
    }
}
//Anima ideal para guarda
class Pastor extends Cachorro{

    public Pastor() {
        super("Pastor");
    }
}
// animal ideal para compania
class Persa extends Gato{

    public Persa() {
        super("Persa");
    }
}
//Anima ideal para guarda

class RagDoll extends Gato{

    public RagDoll() {
        super("RagDoll");
    }
}
//Modelo de Cachorro e Gatos
interface Modelo{
    Cachorro getCachorro();
    Gato getGato();
}

//Fabrica de pets De Companhia
class FabricaCompanhia implements Modelo{

    @Override
    public Cachorro getCachorro() {
        return new Shitzu();
    }

    @Override
    public Gato getGato() {
        return new Persa();
    }
}
//Fabrica de Pets de Guarda
class FabricaGuarda implements Modelo{

    @Override
    public Cachorro getCachorro() {
        return new Pastor();
    }

    @Override
    public Gato getGato() {
        return new RagDoll();
    }
}

public class Abs_Factory {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        new Abs_Factory().executar();

    }
    public void executar(){
        System.out.println("Informe 1-para companhia ou 2 para guarda");
        byte opc = sc.nextByte();
        Modelo modelo = null;

        switch (opc){
            case 1: modelo = new FabricaCompanhia(); break;
            case 2: modelo = new FabricaGuarda();break;
        }
        System.out.println("Cachorro: "+ modelo.getCachorro() );
        System.out.println("Gato: "+ modelo.getGato() );
    }

}
