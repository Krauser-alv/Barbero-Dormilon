import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Barber
{
    public int nClientesV;
    public int nAsientosV;

    Barber(int nClientes, int nAsientos){
        this.nClientesV=nClientes;
        this.nAsientosV=nAsientos;
        }
    
    boolean []nAsientos(int nAsientos){
        boolean []nSillas = new boolean[nAsientos];
        return nSillas;
    }
    
    public void ocuparA(int nClientes, boolean nAsientos[]){
        
        for(int i = 0; i < nClientes; i++)
            nAsientos[i] = !nAsientos[i];
            
        StdOut.println("Asientos ocupados: ");

        for(int i = 1; i <= nClientes; i++)
            StdOut.print(i + " ");
           
        if(nClientes < nAsientosV) StdOut.println("\nAsientos disponibles: "+(nAsientosV - nClientes));
        else StdOut.println("\nSin más asientos asientos disponibles ");
        
        
    }
    
    public void desocuparA(int n, boolean nAsientos[]){
       for(int i = 0; i < n; i++)
            nAsientos[i] = false;
        
    }
    
    public void esperar(){
       try{
           Thread.sleep(5000);
       }catch(InterruptedException ex){}
    }
    
    void atender(int nClientes, int nAsientos ){
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        StdOut.println("Hora y fecha de ejecución:      "+date);
        
        int tiempo = 0, clientes=0, CC=nClientes, resto=0;
        
        boolean [] numAsientos=new boolean[nAsientos];
        numAsientos=nAsientos(nAsientos);
        
        while(CC > 0 ){
            Date date1 = new Date();
            StdOut.printf("%n%-10s %1d","Entra el cliente",(clientes+1));    
            StdOut.printf("%n%-10s %n","Atiendo Cliente... Espere ");
            StdOut.printf("%-10s %1s %n","Tiempo de demora: ",hourFormat.format(date1));
            desocuparA(nAsientos, numAsientos);
            
            esperar();
            if(CC > nAsientos){
                resto = CC - nAsientos;// - 5;
                StdOut.println("Asientos llenos \t afuera "+resto);
                ocuparA(nAsientos, numAsientos);
            }else ocuparA(CC, numAsientos);
            
            tiempo += 5;
            clientes++;
            CC--;
            StdOut.println();
        }
        StdOut.printf("%n%-10s %1d %1s %n%1s","Tiempo Total : ",(tiempo),"seg.", hourFormat.format(date));
        
        }

}
