
public class Caminos_minimos {
    
    public String algoritmofloyd(long [][] mAdy){
        int vertices=mAdy.length;
        long matrizAdyacencia[][]=mAdy;
        String caminos[][]=new String [vertices][vertices];
        String caminosAuxiliares[][]=new String [vertices][vertices];
        String caminoRecorrido="", cadena = "", caminitos = "";
        int i, j , k;
        float temp1, temp2, temp3, temp4, minimo;
        
        for(i=0; i<vertices;i++){
            for(j=0; j<vertices;j++){
                caminos[i][j]="";
                caminosAuxiliares[i][j]="";
            }
        }
        for(k=0; k<vertices;k++){
            for(i=0; i<vertices;i++){
                for(j=0; j<vertices;j++){
                    temp1=matrizAdyacencia[i][j];
                    temp2=matrizAdyacencia[i][k];
                    temp3=matrizAdyacencia[k][j];
                    temp4=temp2+temp3;
                    //Se encuentra al minimo
                    minimo=Math.min(temp1, temp4);
                    if(temp1!=temp4){
                        if(minimo==temp4){
                            caminoRecorrido="";
                            caminosAuxiliares[i][j]=k+"";
                            caminos[i][j]=caminosR(i,k,caminosAuxiliares,caminoRecorrido) + (k+1);
                        }
                    }
                    matrizAdyacencia[i][j]=(long) minimo;
                }
            }
        }
        //Agregando los caminos a la cadena
        for(i=0; i<vertices;i++){
            for(j=0; j<vertices;j++){
                cadena=cadena+ "[" + matrizAdyacencia[i][j]+ "]";
            }
            cadena=cadena + "\n";
        }
        /////
        for(i=0; i<vertices;i++){
            for(j=0; j<vertices;j++){
                if(matrizAdyacencia[i][j]!=100000){
                    if(i!=j){
                        if(caminos[i][j].equals("")){
                            caminitos+="De ("+(i+1)+"------->"+(j+1)+") Irse por....("+(i+1)+", "+(j+1)+")\n";
                        }else{
                            caminitos+="De ("+(i+1)+"------->"+(j+1)+") Irse por....("+(i+1)+", "+caminos[i][j]+","+(j+1)+")\n";
                        }
                    }
                }
            }
        }
        return "La matiz de caminos mas cortos entre los diferentes vertices es:\n"+cadena+
                "\nLos diferentes caminos mas cortos entre vertices son:\n"+caminitos;
    }
    public String caminosR(int i, int k, String[][] caminosAuxiliares, String caminoRecorrido){
        if(caminosAuxiliares[i][k].equals("")){
            return "";
        }else{
            //recursividad al millon
            caminoRecorrido +=caminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()),caminosAuxiliares, caminoRecorrido)+(Integer.parseInt(caminosAuxiliares[i][k].toString())+1)+", ";
            return caminoRecorrido;
        }
    }
}
