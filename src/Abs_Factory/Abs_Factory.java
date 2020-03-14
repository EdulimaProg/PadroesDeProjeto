package Abs_Factory;

import java.util.Scanner;
// nesse padrão são as fabriicas que me retornam o que eu quero
//Classe Abs_Factory.Pet
abstract class Pet{
    private String nome;

    public Pet(String nome){
        this.nome = nome;
    }
    public String toString(){
        return nome;
    }
}
// a familia pet é divida em dois grupos, Abs_Factory.Cachorro e gato
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
        super("Abs_Factory.Shitzu");
    }
}
//Anima ideal para guarda
class Pastor extends Cachorro{

    public Pastor() {
        super("Abs_Factory.Pastor");
    }
}
// animal ideal para compania
class Persa extends Gato{

    public Persa() {
        super("Abs_Factory.Persa");
    }
}
//Anima ideal para guarda

class RagDoll extends Gato{

    public RagDoll() {
        super("Abs_Factory.RagDoll");
    }
}
//Abs_Factory.Modelo de Abs_Factory.Cachorro e Gatos
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
        System.out.println("Abs_Factory.Cachorro: "+ modelo.getCachorro() );
        System.out.println("Abs_Factory.Gato: "+ modelo.getGato() );
    }

}
