import java.util.Arrays;
import java.util.Scanner;

class AlgoritmosBusqueda{
	public void muestraVector(int vector[]) {
		for(int i=0;i<vector.length;i++) {
			System.out.print("-["+vector[i]+"]-");
			if(i%20==0) {
				System.out.println();
			}
		}
	}
	public int[] copiaVector(int vector[]) {
		int[] newVect=vector.clone();
		return newVect;
	}
	public int[] llenaVector(int tam) {
		int vector[]=new int[tam];
		
		for (int i=0;i<tam;i++) {
			vector[i]=(int) (Math.random() * 100);
		}
		return vector;
	}
	public void BusquedaSecuencial(int []nums,int Nbuscar) {
		
		if(Arrays.toString(nums).contains(String.valueOf(Nbuscar))) {
			for(int i=0;i<nums.length;i++) {
				if(nums[i]==Nbuscar) {
					System.out.println("Se encontro el numero "+nums[i]+" en la posicion "+(i+1));
					break;
				}
			}
		}else {
			System.out.println("ALV el numero no existe");
		}
		
	}
	
	public int busquedaBinaria(int nums[],int busc) {
		int centro,primero,valorcentro,ultimo;
		primero=0;
		ultimo=nums.length-1;
		while(primero<=ultimo) {
			centro=(primero+ultimo)/2;
			valorcentro=nums[centro];
			if(busc==valorcentro) {
				return centro;
			}else if(busc<valorcentro) {
				ultimo=centro-1;
			}else {
				primero=centro+1;
			}
			
		}
		return -1;
	}
	
	public void busquedaHash() {
		
	}
	
}
class hashCero {
    //constructor
String [] arreglo;
int tamanio,contador;
public hashCero( int tam){
	tamanio=tam;
    arreglo=new String[tam];
    Arrays.fill(arreglo,"-1");
}
             /**
       *
       * @param cadenaArreglo
       * @param arreglo
       */
public void funcionhash(String[] cadenaArreglo,String[] arreglo){
	int i;
    for(i=0;i<cadenaArreglo.length;i++){
    	String elemento=cadenaArreglo[i];
        int indiceArreglo=Integer.parseInt(elemento)%7;
        System.out.println(" el indice es "+ indiceArreglo+"  para el elemnto "+ elemento);
                                // tratando las colisiones
        while( arreglo[indiceArreglo]!="-1"){
        	indiceArreglo++;
            System.out.println("  ocurrio una colision para el indice "+(indiceArreglo-1)+
            		" cambiar al indice "+ indiceArreglo);
            indiceArreglo%=tamanio;
              }
              arreglo[indiceArreglo]=elemento;
         }
}
                    // metodo para mostrar la tabla
public void mostar(){
    int incremento = 0,i,j;
   for(i=0; i < 1; i++){
           incremento +=8;
       System.out.println();
           for(j=incremento-8;j<incremento;j++){
                     System.out.format("| %3s"+"",j);
                       }
        System.out.println("|");
            System.out.println();
 for(j= incremento -8; j< incremento;j++){
                    if (arreglo[j].equals("-1")){
                            System.out.print(" |        ");
                                }else{
                             System.out.print(String.format("| %3s"+"", arreglo[j]));
                                 }
                         }
              System.out.println("|");
               System.out.println();
         }
 }
     // metodo para buscar clave
public String buscarclave(String elemento){
    int indiceArreglo=Integer.parseInt(elemento)%7;
    int contador=0;

           while(arreglo[indiceArreglo]!="-1"){
            if(arreglo [indiceArreglo] == elemento){
            	System.out.println("  el elemento "+ elemento
            			+" fue encontrado en la posicion "+indiceArreglo);
                return arreglo[indiceArreglo];
                 }
           indiceArreglo++;
         indiceArreglo%=tamanio;
contador++;
          if( contador>7){
                           break;
                       }
                }
    return null;
 }   
}

public class Busqueda {

	public static void main(String[] args) {
		Scanner ent=new Scanner(System.in);
		AlgoritmosBusqueda abu=new AlgoritmosBusqueda();
		int opc=0;
		int []vector=abu.llenaVector(100);
		do {
			System.out.println("INGRESA LA OPCION DESEADA:");
			System.out.println("1)Busqueda Secuencial \n2)Busqueda Binaria \n3)Busqueda por Funciones Hash \n4)Salir");
			opc=ent.nextInt();
			switch(opc) {
			case 1:
				abu.BusquedaSecuencial(vector, 30);
				break;
			case 2:
				Arrays.sort(vector);
				abu.busquedaBinaria(vector, 89);
				break;
			case 3:
				hashCero hash=new hashCero(8);
			    String[] elementos={ "20","33","21","10","12","14","56","100"};
			    hash.funcionhash(elementos, hash.arreglo);
			    hash.mostar();
			    String buscado=hash.buscarclave("33");
			    if( buscado==null){
			    	System.out.println(" el elemento 33 no se encuentra en la tabla" );
			        }
				break;
			default:
				System.out.println("Saliste ALV");
				break;
			}
		}while(opc!=4);

	}

}
