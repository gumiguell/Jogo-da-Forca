import java.io.*;
// teste
public class Forca
{
    public static void main (String args [])
    {
        char continuar = ' ';

        do
        {
			Palavra palavra = 
			BancoDePalavras.getPalavraSorteada();
			
			Tracinhos tracinhos = null;
			try
			{
			    tracinhos = new Tracinhos (palavra.getTamanho());
            }
            catch (Exception erro)
            {}
            
			ControladorDeLetrasJaDigitadas
			controladorDeLetrasJaDigitadas =
			new ControladorDeLetrasJaDigitadas ();
			
			ControladorDeErros controladorDeErros = null;
			try
			{
			    controladorDeErros = new ControladorDeErros ((int)(palavra.getTamanho()*0.6));
			}
			catch (Exception erro)
			{}

			while (tracinhos.isAindaComTracinhos() &&
				  !controladorDeErros.isAtingidoMaximoDeErros())
			{
				System.out.println ("Palavra...: "+tracinhos);
				System.out.println ("Digitadas.: "+controladorDeLetrasJaDigitadas);
				System.out.println ("Erros.....: "+controladorDeErros);

				try
				{
					System.out.print   ("Qual letra? ");
					char letra = Character.toUpperCase (Teclado.getUmChar());

					if (controladorDeLetrasJaDigitadas.isJaDigitada (letra))
						System.err.println ("Essa letra já foi digitada!\n");
					else
					{
						controladorDeLetrasJaDigitadas.registre (letra);

						int qtd = palavra.getQuantidade (letra);

						if (qtd==0)
						{
							System.err.println ("A palavra não tem essa letra!\n");
							controladorDeErros.registreUmErro ();
						}
						else
						{
							for (int i=0; i<qtd; i++)
							{
								int posicao = palavra.getPosicaoDaIezimaOcorrencia (i,letra);
								tracinhos.revele (posicao, letra);
							}
							System.out.println ();
						}
					}
				}
				catch (Exception erro)
				{
					System.err.println (erro.getMessage());
				}
			}

			if (controladorDeErros.isAtingidoMaximoDeErros ())
				System.out.println ("Que pena! Voce perdeu! A palavra era "+palavra+"\n");
			else // !tracinhos.isAindaComTracinhos()
				System.out.println ("Parabens! Voce ganhou! A palavra era mesmo "+palavra+"\n");

			for(;;)
			{
				try
				{
					System.out.print ("Deseja jogar de novo (S/N)? ");
					continuar = Character.toUpperCase (Teclado.getUmChar());
					if (continuar!='S' && continuar!='N')
						System.err.println ("Opcao invalida! Tente novamente...");
					else
						break;
				}
				catch (Exception erro)
				{
					System.err.println ("Opcao invalida! Tente novamente...");
				}
			}
		}
        while (continuar=='S');
    }
}
