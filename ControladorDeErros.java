public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
		// verifica se qtdMax fornecida n�o � positiva, lan�ando
		// uma exce��o.
		// armazena qtdMax fornecida em this.qtdMax.
        if(qtdMax < 0)
            throw new Exception("ERRO");
         this.qtdMax = qtdMax;   
    }

    public void registreUmErro () throws Exception
    {
        // verifica se this.qtdErr ja � igual a this.qtdMax,
        // lan�ando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo
        if(isAtingidoMaximoDeErros())
            throw new Exception("ERRO");
          
        this.qtdErr++;        
    }

    public boolean isAtingidoMaximoDeErros()
    {
        // returna true se this.qtdErr for igual a this.qtdMax,
        // ou ent�o false, caso contrario.
        if(this.qtdErr == this.qtdMax)
            return true;
     
        return false;
    }

    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
        if(this==obj) return true;
        if(obj==null) return false;
        ControladorDeErros control = (ControladorDeErros) obj;
        if(this.qtdErr!=control.qtdErr) return false;
        if(this.qtdMax!=control.qtdMax) return false;

        return true;
    }

    public int hashCode ()
    {
        int ret = 2;
        ret = 7 * ret + Integer.valueOf(this.qtdMax).hashCode();
        ret = 2 * ret + Integer.valueOf(this.qtdErr).hashCode();

        if (ret<0) ret=-ret;
        return ret;
    }

    public ControladorDeErros (ControladorDeErros c) throws Exception // construtor de c�pia
    {
        // copiar c.qtdMax e c.qtdErr, respectivamente em, this.qtdMax e this.qtdErr
        if (c==null)
            throw new Exception("Controlador de Erros ausente");
        
        this.qtdMax= c.qtdMax;
        this.qtdErr = c.qtdErr;
    }

    public Object clone ()
    {
        // returnar uma c�pia de this
        ControladorDeErros ret=null;

        try
        {
            ret = new ControladorDeErros(this);
        }
        catch (Exception erro)
        {} // não ocorrerá
        
        return ret;
    }
}