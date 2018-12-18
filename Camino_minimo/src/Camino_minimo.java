
public class Camino_minimo {

   
    public static void main(String[] args) {
        long matrizA [][]={{0,6,999999,4, 999999},{999999,0, 999999, 999999,8},{999999,5,0, 999999, 999999},{999999, 999999, 999999,0,3},{1, 999999,2, 999999,0}};
        Caminos_minimos ruta = new Caminos_minimos();
        System.out.println(ruta.algoritmofloyd(matrizA));
    }
  
}
