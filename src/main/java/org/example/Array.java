package org.example;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Array {
    private int[] array;

    //Constructors

    public Array(){
        this.array = new int[0];
    }

    public Array(int[] array){
        this.array = array.clone();
    }

    //Hash + Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Array)) return false;
        Array array1 = (Array) o;
        return Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }


    //Getters And Setters


    public int[] getArray() {
        return this.array;
    }

    public void setArray(int[] array) {
        this.array = array.clone();
    }

    //Methods_____________________________________________

    public void addElementToArray(int elementToAdd){
        int[] tempArray = new int[this.array.length+1];
        for(int i = 0; i < this.array.length; i++){
            tempArray[i] = this.array[i];
        }
        tempArray[tempArray.length-1] = elementToAdd;
        this.array = tempArray;

    }

    //__________________________________________________________

    public void takeElementOfArray(int takenElement){
        if (this.isArrayEmpty()) {
            return;
        }

        int numberOfElements = CustomTools.howManyElementsInAnArray(this.array,takenElement);
        if (numberOfElements == 0){
            return;
        }

        int[] tempArray = new int[this.array.length-1];

        int counter = 0;
        int index = 0;
        for (int j : this.array) {
            if (j == takenElement && counter <= 0) {
                counter++;
                continue;
            }
            tempArray[index] = j;
            index++;
        }
        this.array = tempArray;
    }

    //_________________________________________________________________

    public int returnElementGivenIndex(int index) throws IllegalArgumentException{
        if (index < 0 || this.isArrayEmpty() || index >= this.array.length){
            throw(new IllegalArgumentException("Invalid Index"));
        }
        return this.array[index];
    }

    //_______________________________________________________________________


    public int getArrayLenght(){
        return this.array.length;
    }

    //_________________________________________________________

    public int getBiggestElement() { //Exceção não verificada logo não necessito de avisar o compilador no cabeçalho do método ou usar um try catch..
        //Devo no entanto capturá-la no método responsável por chamar este método
        if (this.isArrayEmpty()){
            throw(new NoSuchElementException("Empty array"));
        }

        int max = this.array[0];
        for (int j : this.array) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    //_______________________________________________________

    public int getSmallesttElement() { //Exceção não verificada logo não necessito de avisar o compilador no cabeçalho do método ou usar um try catch..
        //Devo no entanto capturá-la no método responsável por chamar este método
        if (this.isArrayEmpty()){
            throw(new NoSuchElementException("Empty array"));
        }

        int min = this.array[0];
        for(int i = 0; i < this.array.length; i++){
            if(this.array[i] < min){
                min = this.array[i];
            }
        }
        return min;
    }

    //_______________________________________________________

    public double averageOfElementsOfAnArray(){
        if(this.isArrayEmpty()){
            return 0;
        }
        int sum = 0;

        for (int j : this.array) {
            sum += j;
        }
        return (double) sum /this.array.length;

    }

    //__________________________________________________

    public double averageOfAllEvenElements(){
        if(this.isArrayEmpty()){
            return 0;
        }
        int sum = 0;
        int counter = 0;

        for (int j : this.array) {
            if(j%2 == 0){
                sum+=j;
                counter++;
            }
        }
        if(counter == 0){
            return 0;
        }
        return (double) sum /counter;

    }

    //____________________________________________________

    public double averageOfAllOddElements(){
        if(this.isArrayEmpty()){
            return 0;
        }
        int sum = 0;
        int counter = 0;

        for (int j : this.array) {
            if(j%2 != 0){
                sum+=j;
                counter++;
            }
        }
        if(counter == 0){
            return 0;
        }
        return (double) sum /counter;

    }

    //_______________________________________________________

    public double mediaOfMultiplesOfOneNumber(int multiple){
        if (multiple == 0 || this.isArrayEmpty()){
            return 0;
        }

        int sum = 0;
        int counter = 0;
        for (int j : this.array) {
            if(j%multiple == 0){
                sum+=j;
                counter++;
            }
        }
        if(counter == 0){
            return 0;
        }

        return (double) sum /counter;

    }

    //___________________________________________________________

    public void orderingInAscendingOrder(){
        if(this.isArrayEmpty()){
            return;
        }

        int index = 1;
        while(index < this.array.length){
            for(int i = 0; i < this.array.length; i++){
                if(this.array[i] > this.array[index] ){
                    int temp = this.array[i];
                    this.array[i] = this.array[index];
                    this.array[index] = temp;
                }
            }
            index++;
        }

    }

    //_____________________________________________________

    public void orderingInDescendingOrder(){
        if(this.isArrayEmpty()){
            return;
        }

        int index = 1;
        while(index < this.array.length){
            for(int i = 0; i < this.array.length; i++){
                if(this.array[i] < this.array[index] ){
                    int temp = this.array[i];
                    this.array[i] = this.array[index];
                    this.array[index] = temp;
                }
            }
            index++;
        }

    }

    //______________________________________________

    public boolean isArrayEmpty(){
        return this.array.length == 0;
    }

    //________________________________________________

    public boolean doesArrayHaveOnlyOneElement(){
        return this.array.length == 1;
    }

    //______________________________________________________

    public boolean doesArrayHaveOnlyEvenElement(){
        if(this.isArrayEmpty()) {
            return false;
        }
        else {
            boolean onlyEvenElements = true;

            for (int j : this.array) {
                if (j % 2 != 0) {
                    onlyEvenElements = false;
                    break;
                }
            }
            return onlyEvenElements;
        }
    }

    //____________________________________________________

    public boolean doesArrayHaveOnlyOddElement(){
        if(this.isArrayEmpty()) {
            return false;
        }
        else {
            boolean onlyOddElements = true;

            for (int j : this.array) {
                if (j % 2 == 0) {
                    onlyOddElements = false;
                    break;
                }
            }
            return onlyOddElements;
        }
    }

    //_____________________________________________________



    public boolean doesArrayHaveRepeteadNumbers(){
        if(this.isArrayEmpty()){
            return false;
        }

        for(int i = 0; i < this.array.length-1; i++){
            for (int j = i +1; j < this.array.length; j++){
                if(this.array[i] == this.array[j]){
                    return true;
                }
            }
        }
        return false;
    }

    //___________________________________________

    public int[] elementsBiggerThanAverage(){
        if(this.isArrayEmpty()){
            return new int[0];
        }
        double average = this.averageOfElementsOfAnArray();
        int counter = 0;

        for (int j : this.array) {
            if (j > average) {
                counter++;
            }
        }

        int[] finalArray = new int[counter];

        int index = 0;
        for (int j : this.array) {
            if (j > average) {
                finalArray[index] = j;
                index++;
            }
        }
        return finalArray;

    }


    //________________________________________________

    public int numberOfElementsMultiplesOfSpecifiedDivisor(int divisor) {
        if(this.isArrayEmpty() || divisor == 0){
           return -1;
        }

        int counter = 0;
        for (int j : this.array) {
            if (j % divisor == 0) {
                counter++;
            }
        }
        return counter;

    }

   public int[] evenElementsOfAnArray(){
        if(this.doesArrayHaveOnlyOddElement() || this.isArrayEmpty()){
            return new int[0];
        }

        if(this.doesArrayHaveOnlyEvenElement()){
                return this.array;
        }

        int numberOfEvenElements = this.numberOfElementsMultiplesOfSpecifiedDivisor(2);
        int[] tempArray = new int[numberOfEvenElements];
        int index = 0;

       for (int j : this.array) {
           if (j % 2 == 0) {
               tempArray[index] = j;
               index++;
           }
       }
        return tempArray;
   }

   //______________________________________________________________

    public int[] crescentNumbersInAVector(){
        if(this.isArrayEmpty()){
            return new int[0];
        }

        int counter = 0;
        int[] temp = new int[10];
        for(int i = 0; i < this.array.length; i++){
            if(CustomTools.isNumberACrescentSequence(array[i])){
                temp[counter] = array[i];
                counter++;
            }
        }

        int[] finalArray = new int[counter];

        for (int i = 0; i < counter; i++){
            finalArray[i] = temp[i];
        }

        return finalArray;
    }

    //______________________________________________

    public int[] capicuaElementsOfAnArray(){
        if(this.isArrayEmpty()){
            return new int[0];
        }

        int counter = 0;
        int[] temp = new int[10];
        for(int i = 0; i < this.array.length; i++){
            if(CustomTools.isCapucua(this.array[i])){
                temp[counter] = this.array[i];
                counter++;
            }
        }

        int[] finalArray = new int[counter];

        for (int i = 0; i < counter; i++){
            finalArray[i] = temp[i];
        }

        return finalArray;
    }

    //________________________________________________________

    public int[] composedByTheSameAlgarismElements(){
        if(this.isArrayEmpty()){
            return new int[0];
        }

        int counter = 0;
        int[] temp = new int[10];
        for(int i = 0; i < this.array.length; i++){
            if(CustomTools.areNumberAlgarismsEqual(this.array[i])){
                temp[counter] = this.array[i];
                counter++;
            }
        }

        int[] finalArray = new int[counter];

        for (int i = 0; i < counter; i++){
            finalArray[i] = temp[i];
        }

        return finalArray;
    }

    //____________________________________________

    public int[] elementsThatAreNotAmstrongNumbers(){
        if(this.isArrayEmpty()){
            return new int[0];
        }

        int counter = 0;
        int[] temp = new int[10];
        for(int i = 0; i < this.array.length; i++){
            if(!CustomTools.isAmstrongNumber(this.array[i])){
                temp[counter] = this.array[i];
                counter++;
            }
        }

        int[] finalArray = new int[counter];

        for (int i = 0; i < counter; i++){
            finalArray[i] = temp[i];
        }

        return finalArray;
    }

    //____________________________________________________

    public int[] crescentNSequenceOfAlgarisms(int sequence){
        if(sequence <= 1 || this.isArrayEmpty()){
            return new int[0];
        }

        int baseLineNumber = CustomTools.baseLineCalculator(sequence);

        int[] temp = new int[this.array.length];
        int counter = 0;

        for (int j : this.array) {
            if (Math.abs(j) >= (baseLineNumber) && CustomTools.isNumberACrescentSequence(j)) {
                //MathAbs para considerar valor absoluto em caso de valores negativos.
                temp[counter] = j;
                counter++;
            }
        }

        int[] finalArray = new int[counter];

        for(int i = 0; i < counter; i++){
            finalArray[i] = temp[i];
        }

        return finalArray;


    }

    //_______________________________________________________

    public boolean areArrayAndPassedArrayTheSame(int[] passedArray){
        return Arrays.equals(this.array,passedArray); //Neste caso teremos de recorrer ao método estático de compração da classe Arrays
        //que compara apenas o conteúdo dos arrays e não as suas referencias, dado que na nossa classe temos equals implemntado que retorna falso
        //se intancias de objetos diferentes estão a ser comparados. Partindo do presuppose que neste método temos de comprar objectos de classes diferentes
    }













}
