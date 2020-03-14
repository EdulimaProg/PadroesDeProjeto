package Prototype;

class Ovelha implements Cloneable{
    private String nome;

    public Ovelha(String nome){

    }
    public String toString(){
        return nome;
    }
    public Object clone(){
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return object;
    }
}
interface Prototype{
    public Ovelha duplicar(Ovelha ovelha);
}

class PrototypeIpl implements Prototype{

    @Override
    public Ovelha duplicar(Ovelha ovelha) {
        return (Ovelha)ovelha.clone();
    }
}
public class Proto {
    public static void main(String[] args) {
        new Proto().executar();
    }
    public void executar(){
        Ovelha original = new Ovelha("Dolly");
        Ovelha clone = new PrototypeIpl().duplicar(original);
    }
}
