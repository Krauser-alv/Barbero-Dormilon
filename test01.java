import javax.swing.JOptionPane;
public class test01
{
    public static void main(String[]args)throws InterruptedException{
        /*** Barbería **/
        
        int c = Integer.parseInt(JOptionPane.showInputDialog("\t BIENVENIDO A LA BARBERIA \nIngrese Número de clientes: "));  
        int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Número de asientos: "));
        StdOut.println("");
        Barber Barbero = new Barber(c, a);
        Barbero.atender(c,a);

        
    }
}
