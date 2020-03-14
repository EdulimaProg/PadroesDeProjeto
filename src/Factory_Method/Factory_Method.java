package Factory_Method;

//Classe Veiculo que contém as propriedades padrões de veiculo
abstract class Veiculo {
    private String modelo;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
// classe opala que fabrica um veiculo especifico
class Opala extends Veiculo{
    public Opala() {
        setModelo("Opala");
    }
}
class Vectra extends Veiculo{
    public Vectra() {
        setModelo("Vectra");
    }
}

// criador da fabrica de veiculos
abstract class GMCriador{
    public abstract Opala factoryOpala();
     public abstract Vectra factoryVectra();
}

//fabrica que cria os veiculos
class GMCriadorConcreto extends GMCriador{

    @Override
    public Opala factoryOpala() {
        return new Opala();
    }

    @Override
    public Vectra factoryVectra() {
        return new Vectra();
    }
}
public class Factory_Method {
    public static void main(String[] args) {
        new Factory_Method().executar();
    }

   public void executar(){
        GMCriador gm = new GMCriadorConcreto();
        Veiculo vectra = gm.factoryVectra();
       Veiculo Opala = gm.factoryOpala();

       System.out.println(vectra.getModelo());
       System.out.println(Opala.getModelo());
   }
}
