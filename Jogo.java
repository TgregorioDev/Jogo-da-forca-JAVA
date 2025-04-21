import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private final Palavra palavra;
    private final Jogador jogador;

    public Jogo(Palavra palavra, Jogador jogador){ //onstrutor que fará com que sempre que um jogo for criado, ele passe a palavra e o jogador
        this.palavra = palavra;
        this.jogador = jogador;
    }

    public void iniciarJogo(){
        var numeroChutes = 10;
        var chutes = new ArrayList<String>();

        this.palavra.gerarPalavraSecreta();

        var scanner = new Scanner(System.in);
        System.out.println("Ola " + this.jogador.getNome() + ", bem-vindo ao Jogo da Forca");
        System.out.println("Você tem " + numeroChutes + " chutes para advinhar a palavra secreta.");
        System.out.println(this.palavra.getPalavraComChute() + "\n");

        while (!this.palavra.palavraCompleta() && chutes.size() < numeroChutes){ //enquanto a palavra NÃO estiver completa, continue
            System.out.println("Digite seu chute: ");
            var chute = scanner.nextLine(); //método que pegará o que foi escrito e armazenará na variável chute

            if (chutes.contains(chute)){
                System.out.println("Voce ja chutou esta letra, tente novamente!");
                continue;
            }
            chutes.add(chute);

            this.palavra.revelarLetra(chute);

            System.out.println("Palavra: " + this.palavra.getPalavraComChute());

            if (this.palavra.palavraCompleta()){
                System.out.println("Parabens " + this.jogador.getNome() + " Voce venceu!");
            } else if (chutes.size() == numeroChutes){
                System.out.println("Poxa " + this.jogador.getNome() + " voce perdeu! A palavra era " + this.palavra.getPalavraSecreta());
            }
        }  
    }
}
