//Padrão Criacional

//Criar uma classe geral
abstract class Veiculo{

    private String modelo;
    private String tipo;

    public Veiculo(String modelo, String tipo) {
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

}
// Criar uma Classe especifica que extende a clase principal
class Ferrari extends Veiculo{
    private String nome;

    public Ferrari(String modelo) {
        super(modelo, "Esportivo");
        this.nome = "Ferrari";
    }

    public String toString(){
        return "Carro: "+ nome + " " + getModelo() + " " + getTipo();
    }
}
class Jeep extends Veiculo{
    private String nome;

    public Jeep(String modelo) {
        super(modelo, "Utilitario");
        this.nome = "Jeep";
    }

    public String toString(){
        return "Carro: "+ nome + " " + getModelo() + " " + getTipo();
    }
}
// intrface ajuda a criar as classes necessearias
interface MontadoraBuilder{
    void montar(char tipo, String modelo);
    Veiculo getVeiculo();
}
// a classe que implementa a classe principal
class MontadoraVeiculoBuilder implements MontadoraBuilder{
private Veiculo veiculo;
    @Override
    public void montar(char tipo, String modelo) {
        switch (tipo) {
            case 'F' : veiculo = new Ferrari(modelo); break;
            case 'J' : veiculo = new Jeep(modelo); break;
        }
    }
    @Override
    public Veiculo getVeiculo() {
        return veiculo;
    }
}
//classe para gerenciar a classe de criação
class Montadora{
    private MontadoraVeiculoBuilder builder = new MontadoraVeiculoBuilder();
    public Veiculo montar(char tipo, String modelo){
        builder.montar(tipo, modelo);
        return builder.getVeiculo();
    }
}

public class Build {
    public static void main(String[] args) {
        new Build().executar();
    }
    public void executar(){
        Montadora montadora = new Montadora();
        Veiculo carro1 = montadora.montar('F', "F7");
        Veiculo carro2 = montadora.montar('J', "Renegade");
        System.out.println(carro1);
        System.out.println(carro2);

    }
}
