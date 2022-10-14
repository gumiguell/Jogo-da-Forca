public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
        if(texto==null||texto == "")
            throw new Exception("Digite um valor válido.");
        this.texto = (String)texto;
    }

    public int getQuantidade (char letra)
    {
        int conte = 0;
        for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i)==letra)
                conte++;
        }
        return conte;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    { 
        byte iezima = -1;
        for(byte j = 0; j < texto.length(); j++){
            if(texto.charAt(j)==letra)
                iezima++;
        
            if(iezima == i)
            return j;
        }
        throw new Exception("Não foi encontrada a iézima posição");
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }
    
    @Override
    public boolean equals (Object obj)
    {
        if(this==obj) return true;
        if(obj==null) return false;
        if(this.getClass() != obj.getClass()) return false;

        Palavra dat = (Palavra)obj;
        if(!this.texto.equals(dat.texto)) return false;
        //if(this.texto != dat.texto) return false;

        else return true;
    }

    @Override
    public int hashCode () 
    {
        int ret = 8;
        ret = 7 * ret + String.valueOf(this.texto).hashCode();

        if (ret<0) ret=-ret;
        return ret;
    }
    
    public int compareTo (Palavra palavra)
    {
        if(this.texto != palavra.texto) return -1;
        return this.texto.compareTo(palavra.texto);
    }
}