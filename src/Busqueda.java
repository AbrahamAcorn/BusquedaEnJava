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
}
public class Busqueda {

	public static void main(String[] args) {
		Scanner ent=new Scanner(System.in);
		AlgoritmosBusqueda abu=new AlgoritmosBusqueda();
		int opc=0;
		int []vector=abu.llenaVector(100);
		do {
			System.out.println("INGRESA LA OPCION DESEADA:");
			System.out.println("1)Busqueda Secuencial \n2)Busqueda Binaria \n3)Busqueda por Funciones Hash \4)Salir");
			opc=ent.nextInt();
			switch(opc) {
			case 1:
				abu.BusquedaSecuencial(vector, 30);
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("Saliste ALV");
				break;
			}
		}while(opc!=4);

	}

}
