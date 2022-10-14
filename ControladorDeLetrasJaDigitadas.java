public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        // torna this.letrasJaDigitadas igual ao String vazio
         this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo
        for(int i = 0; i<letrasJaDigitadas.length(); i++)
        {
            if(letrasJaDigitadas.charAt(i)==letra)
            return true;
        }
        return false;
    }

    public void registre (char letra) throws Exception
    {
		// verifica se a letra fornecida ja foi digitada (pode usar
		// o m�todo this.isJaDigitada, para isso), lancando uma exce��o
		// em caso afirmativo.
		// concatena a letra fornecida a this.letrasJaDigitadas.

        if(this.isJaDigitada(letra))
            throw new Exception("ERRO");
        this.letrasJaDigitadas += letra;
    }

    public String toString ()
    {
		// retorna um String com TODAS as letras presentes em
		// this.letrasJaDigitadas separadas por v�rgula (,).
       
        if(letrasJaDigitadas.length() < 1)
            return letrasJaDigitadas;
        
        return letrasJaDigitadas+=',';   
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj s�o iguais
        if(this==obj) return true;
        if(obj==null) return false;
        if(this.letrasJaDigitadas!=((ControladorDeLetrasJaDigitadas)obj).letrasJaDigitadas) return false;
        return true;
    }

    public int hashCode ()
    {
        int ret = 4;
        ret = 13 * ret + (this.letrasJaDigitadas).hashCode();

        if (ret<0) ret=-ret;
        return ret;
    }

    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception // construtor de c�pia
    {
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas
        if (controladorDeLetrasJaDigitadas==null)
            throw new Exception("Controlador de Letras ausente");
        
        this.letrasJaDigitadas= controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object to ()
    {
        // criar uma c�pia do this com o construtor de c�pia e retornar
        ControladorDeLetrasJaDigitadas ret=null;

        try
        {
            ret = new ControladorDeLetrasJaDigitadas(this);
        }
        catch (Exception erro)
        {} // não ocorrerá
        
        return ret;
    }
}