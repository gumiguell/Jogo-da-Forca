import java.util.Arrays;

public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
		// verifica se qtd n�o � positiva, lan�ando uma exce��o.
		// instancia this.texto com um vetor com tamanho igual qtd.
		// preenche this.texto com underlines (_).
        if(qtd < 0)
        throw new Exception("ERRO");

        this.texto = new char[qtd];
        for(int i = 0; i < qtd; i++){
            this.texto[i] = '_';
        }
    }

    public void revele (int posicao, char letra) throws Exception
    {
		// verifica se posicao � negativa ou ent�o igual ou maior
		// do que this.texto.length, lan�ando uma exce��o.
		// armazena a letra fornecida na posicao tambem fornecida
		// do vetor this.texto
        for(int i = 0; i < texto.length; i++){
            if(posicao < 0 || posicao >= texto.length)
                throw new Exception("ERRO");
        }
        texto[posicao] = letra;
    }

    public boolean isAindaComTracinhos ()
    {
        // percorre o vetor de char this.texto e verifica
        // se o mesmo ainda contem algum underline ou se ja
        // foram todos substituidos por letras; retornar true
        // caso ainda reste algum underline, ou false caso
        // contrario
        for (char x : this.texto) 
        {
            if(x == '_')
                return true;
        }
        return false;
    }

    public String toString ()
    {
        // retorna um String com TODOS os caracteres que h�
        // no vetor this.texto, intercalados com espa�os em
        // branco
        return Arrays.toString(texto) + " ";
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
        if(this == obj) return true;
        if(obj==null) return false;
        return true;
    }

    public int hashCode ()
    {
        int ret = 6;
        ret = 3 * ret + Arrays.hashCode(this.texto);

        if (ret<0) ret=-ret;
        return ret;
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de c�pia
    {
        // intanciar this.texto um vetor com o mesmo tamanho de t.texto  //TERMINAR
        // e copilar o conte�do de t.texto para this.texto   

        if (t==null)
            throw new Exception("Tracinhos ausente");
        
        this.texto= t.texto;
    }

    public Object clone ()
    {
        // retornar uma copia de this
        Tracinhos ret=null;
        try
        {
            ret = new Tracinhos(this);
        }
        catch (Exception erro)
        {} // não ocorrerá
        
        return ret;
    }
}