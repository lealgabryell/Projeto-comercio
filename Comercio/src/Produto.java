public class Produto {
    String cod;
    String modelo;
    float valor;
    int estoque;
    String validade;

    public void setEstoque(int estoque){
        this.estoque = estoque;
    }

    public int getEstoque(){
        return estoque;
    }

    public void setCodigo(String cod){
        this.cod = cod;
    }

    public String getCodigo(){
        return cod;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getModelo(){
        return modelo;
    }

    public void setValor(float valor){
        this.valor = valor;
    }

    public float getValor(){
        return valor;
    }

    public void imprimeProduto(){
        System.out.println(getModelo() + "  |  R$" + getValor() + "  |  " + getCodigo() + "  |  " + getEstoque() + " em estoque");
    }
    

}
