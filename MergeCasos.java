public class MergeCasos extends Escrever {
    public static void mergeSortCasos(Dados lista[]) {
        long startTime = System.nanoTime();
        Dados w[] = new Dados[lista.length];

        mergeSort(lista, w, 0, lista.length-2);

        long totalTime = System.nanoTime() - startTime;
        System.out.println("\nMerge para ordem casos confirmados para o caso médio: " + (totalTime) + " milisegundos");
        double memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
        System.out.printf("Memória utlizada: %.2f Mb\n", memoriaUtilizada);
        System.out.printf("Memória utlizada: %.3f Gb\n", memoriaUtilizada/1024);
        String path = "mSort_ordena_casos_medio.csv";
        escreverCsv(lista, path);
        mergeSortCasosMelhor(lista);
    } 

    public static void mergeSort(Dados lista[], Dados w[], int inicio, int fim) {
        if(inicio < fim){
            int meio = (inicio + fim) / 2;
            mergeSort(lista, w, inicio, meio);
            mergeSort(lista, w, meio+1, fim);
            intercala(lista, w, inicio, meio, fim);
        }
    }
    public static void intercala(Dados lista[], Dados w[], int inicio, int meio, int fim) {
        for(int k = inicio; k <= fim; k++){
            w[k] = lista[k];
        }
        int i = inicio;
        int j = meio + 1;

        for(int k = inicio; k <= fim; k++){
            if(i > meio){
                lista[k] = w[j++];
            }
            else if(j > fim){
                lista[k] = w[i++];
            }
            else if(w[i].getConfirmados() < w[j].getConfirmados()){
                lista[k] = w[i++];
            }
            else{
                lista[k] = w[j++];
            }
        }
    }

    public static void mergeSortCasosMelhor(Dados lista[]) {
        long startTime = System.nanoTime();
        Dados w[] = new Dados[lista.length];

        mergeSortMelhor(lista, w, 0, lista.length-2);

        long totalTime = System.nanoTime() - startTime;
        System.out.println("\nMerge para ordem casos confirmados para o melhor caso: " + (totalTime) + " milisegundos");
        double memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
        System.out.printf("Memória utlizada: %.2f Mb\n", memoriaUtilizada);
        System.out.printf("Memória utlizada: %.3f Gb\n", memoriaUtilizada/1024);
        String path = "mSort_ordena_casos_melhor.csv";
        escreverCsv(lista, path);
        mergeSortCasosPior(lista);
    } 

    public static void mergeSortMelhor(Dados lista[], Dados w[], int inicio, int fim) {
        if(inicio < fim){
            int meio = (inicio + fim) / 2;
            mergeSortMelhor(lista, w, inicio, meio);
            mergeSortMelhor(lista, w, meio+1, fim);
            intercalaMelhor(lista, w, inicio, meio, fim);
        }
    }
    public static void intercalaMelhor(Dados lista[], Dados w[], int inicio, int meio, int fim) {
        for(int k = inicio; k <= fim; k++){
            w[k] = lista[k];
        }
        int i = inicio;
        int j = meio + 1;

        for(int k = inicio; k <= fim; k++){
            if(i > meio){
                lista[k] = w[j++];
            }
            else if(j > fim){
                lista[k] = w[i++];
            }
            else if(w[i].getConfirmados() < w[j].getConfirmados()){
                lista[k] = w[i++];
            }
            else{
                lista[k] = w[j++];
            }
        }
    }

    public static void mergeSortCasosPior(Dados lista[]) {
        long startTime = System.nanoTime();
        Dados w[] = new Dados[lista.length];

        mergeSortPior(lista, w, 0, lista.length-2);

        long totalTime = System.nanoTime() - startTime;
        System.out.println("\nMerge para ordem casos confirmados para o pior caso: " + (totalTime) + " milisegundos");
        double memoriaUtilizada = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
        System.out.printf("Memória utlizada: %.2f Mb\n", memoriaUtilizada);
        System.out.printf("Memória utlizada: %.3f Gb\n", memoriaUtilizada/1024);
        String path = "mSort_ordena_casos_pior.csv";
        escreverCsv(lista, path);
    } 

    public static void mergeSortPior(Dados lista[], Dados w[], int inicio, int fim) {
        if(inicio < fim){
            int meio = (inicio + fim) / 2;
            mergeSortPior(lista, w, inicio, meio);
            mergeSortPior(lista, w, meio+1, fim);
            intercalaPior(lista, w, inicio, meio, fim);
        }
    }
    public static void intercalaPior(Dados lista[], Dados w[], int inicio, int meio, int fim) {
        for(int k = inicio; k <= fim; k++){
            w[k] = lista[k];
        }
        int i = inicio;
        int j = meio + 1;

        for(int k = inicio; k <= fim; k++){
            if(i > meio){
                lista[k] = w[j++];
            }
            else if(j > fim){
                lista[k] = w[i++];
            }
            else if(w[i].getConfirmados() > w[j].getConfirmados()){
                lista[k] = w[i++];
            }
            else{
                lista[k] = w[j++];
            }
        }
    }

}