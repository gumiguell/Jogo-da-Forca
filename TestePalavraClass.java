import javax.swing.text.DefaultEditorKit.PasteAction;

public class TestePalavraClass 
{
    public static void main(String[] args)
    {
        try
        {    
            Palavra palavra = new Palavra("texto");
            Palavra p1 = new Palavra("alo");
            System.out.println(palavra.equals(p1));
            System.out.println(palavra.getQuantidade('a'));
            System.out.println(palavra.getTamanho());
            System.out.println(palavra.hashCode());
            System.out.println(palavra.toString());
            System.out.println(palavra.compareTo(p1));
            System.out.println(palavra.getPosicaoDaIezimaOcorrencia(1, 'b'));
        }
        catch(Exception erro){
            System.out.println(erro.getMessage());
        }
}    
    
}
