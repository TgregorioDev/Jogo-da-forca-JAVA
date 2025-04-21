import java.util.Arrays;
import java.util.List;

public class Palavra {
    private List<String> palavras = 
    Arrays.asList("faca", "garfo", "colher", "prato", "tigela", "panela"); //lista de palavras
    private String palavraSecreta; //atributo onde pegaremos uma palavra e armazenaremos para utilizar no jogo
    private String palavraComChute; //para armazenar letra chutada pelo jogador

    public void gerarPalavraSecreta(){
        var range = this.palavras.size() - 1; //ira trazer o tamanho da lista
        var index = (int) (Math.random() * range); //método que irá selecionar uma palavra da lista

        this.palavraSecreta = this.palavras.get(index); //irá pegar o número sorteado e armazenar na variável palavraSecreta
        this.palavraComChute = "_".repeat(this.palavraSecreta.length()); //criará os hífens correspondentes ao número de caracteres que a palavra possui.

    }

    public void revelarLetra(String letra){
        for(int i = 0; i < this.palavraSecreta.length(); i++){ //laço de repetição que irá revelar a palavra aos poucos
            if(this.palavraSecreta.charAt(i) == letra.charAt(0)){ //este condicional irá verificar se as letras digitadas correspondem a palavra sorteada
                this.palavraComChute = this.palavraComChute.substring(0, i) + letra + this.palavraComChute.substring(i + 1);
            }
        }
    }

    public boolean palavraCompleta(){ //verificara se a palavra digitada está completa
        return !this.palavraComChute.contains("_"); //se tiver mais hífens retornara "true", informando que a palavra não está completa
    }

    public List<String> getPalavras(){
        return palavras;
    }

    public String getPalavraSecreta(){
        return palavraSecreta;
    }

    public String getPalavraComChute(){
        return palavraComChute;
    }
    public void setPalavraComChute(String palavraComChute){
        this.palavraComChute = palavraComChute;
    }

}
