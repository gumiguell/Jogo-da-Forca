public class TesteControladorDeLetrasClass {
    public static void main(String[] args){
        try{
            ControladorDeLetrasJaDigitadas c = new ControladorDeLetrasJaDigitadas();
            ControladorDeLetrasJaDigitadas c1 = c;
            System.out.println((c1.hashCode()));
            System.out.println(c.equals(c1));
            System.out.println(c.hashCode());
            System.out.println(c.isJaDigitada('a'));
            System.out.println(c.toString());
        }
        catch(Exception erro){
            System.out.println(erro.getMessage());
        }
    }
}