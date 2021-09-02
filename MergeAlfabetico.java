public class MergeAlfabetico extends Escrever {
    public static void mergeSortAlfabetico(Dados lista[]) {
        long startTime = System.nanoTime();
        Dados w[] = new Dados[lista.length];

        mergeSort(lista, w, 0, lista.length-2);

        long totalTime = System.nanoTime() - startTime;
        System.out.println("Merge para cidades para o caso médio: " + (totalTime) + " milisegundos");
        String path = "mSort_ordena_cidades_medio.csv";
        escreverCsv(lista, path);
        mergeSortAlfabeticoMelhor(lista);
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
            else if(deAccent(w[i].getCidade()).compareTo(deAccent(w[j].getCidade())) < 0){
                lista[k] = w[i++];
            }
            else{
                lista[k] = w[j++];
            }
        }
    }

    public static void mergeSortAlfabeticoMelhor(Dados lista[]) {
        long startTime = System.nanoTime();
        Dados w[] = new Dados[lista.length];

        mergeSortMelhor(lista, w, 0, lista.length-2);

        long totalTime = System.nanoTime() - startTime;
        System.out.println("Merge para cidades para o melhor caso: " + (totalTime) + " milisegundos");
        String path = "mSort_ordena_cidades_melhor.csv";
        escreverCsv(lista, path);
        mergeSortAlfabeticoPior(lista);
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
            else if(deAccent(w[i].getCidade()).compareTo(deAccent(w[j].getCidade())) < 0){
                lista[k] = w[i++];
            }
            else{
                lista[k] = w[j++];
            }
        }
    }

    public static void mergeSortAlfabeticoPior(Dados lista[]) {
        long startTime = System.nanoTime();
        Dados w[] = new Dados[lista.length];

        mergeSortPior(lista, w, 0, lista.length-2);

        long totalTime = System.nanoTime() - startTime;
        System.out.println("Merge para cidades para o pior caso: " + (totalTime) + " milisegundos");
        String path = "mSort_ordena_cidades_pior.csv";
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
            else if(deAccent(w[i].getCidade()).compareTo(deAccent(w[j].getCidade())) > 0){
                lista[k] = w[i++];
            }
            else{
                lista[k] = w[j++];
            }
        }
    }
}