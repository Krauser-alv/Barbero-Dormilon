public class Barbería extends Thread
{
    int tiempo=0;
    int cliente=0;
    boolean asiento[] = {false, false, false, false, false};

    public void ocuparA(int cantCliente, boolean asiento[]){
        
        for(int i = 0; i < cantCliente; i++)
            asiento[i] = !asiento[i];
            
        StdOut.println("Asientos ocupados: ");
        
        for(int i = 0; i < cantCliente; i++)
            StdOut.print(i + " ");
            
        if(cantCliente < 5){
            StdOut.println("\nAsientos disponibles: ");
            StdOut.print(5-cantCliente);
        }else StdOut.println("\nSin más asientos asientos disponibles ");
        
    }
    public void desocuparA(int cliente, boolean asiento[]){
        
       asiento[cliente] = true;
        StdOut.println("Asiento desocupado : " + cliente);
        
    }
    public void atender(int cantCliente){
        int resto = 0;
        if(cantCliente > 5){
            resto = 5 - cantCliente;
            ocuparA(resto, asiento);
        }else ocuparA(cantCliente, asiento);
        /** TIEMPO DE INCIO (inicia con el sistema) **/
        
        try{
            do{
            StdOut.printf("%n%-10s %1d","Entra el cliente",cliente);    
            StdOut.printf("%n%-10s %n","Atiendo Cliente... Espere ");
            sleep(5000);
            tiempo += 5;
            StdOut.printf("%-10s %1d %1s %n","Tiempo de demora: ",tiempo,"seg.");
            desocuparA(cliente, asiento);
            sleep(5000);
            cliente++;
            }while(asiento[cliente]!=false);
            StdOut.printf("%n%-10s %1d %1s %n","Tiempo Total : ",tiempo,"seg.");
        }catch(Exception e){
            StdOut.println("Sin nada que hacer ");
        }
    }
    
    public static void main(String []args){
        
        StdOut.println("Bienvenido a la barbería");
        Barbería prueba = new Barbería();
        int clientes = 3;
        StdOut.println("Cantidad de clientes ["+clientes+"]");
        prueba.atender(clientes);
        
        }
}
