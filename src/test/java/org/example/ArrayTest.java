package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    //Constructors Tests

    @Test
    void newArray_Empty() {
        //Arrange
        Array array = new Array();
        //Act+Assert
        assertNotNull(array);
    }

    @Test
    void newArray_WithTwoArgument() {
        //Arrange
        int[] inicialArray = {1,2};
        Array array = new Array(inicialArray);
        //Act+Assert
        assertNotNull(array);
    }

    //__________________________________________________________

    @Test
    void getArray_ReturnsCorrectArray() { //Compring array inicial com array obtido
        // Arrange
        int[] initialArray = {1, 2, 3};
        Array array = new Array(initialArray);

        // Act
        int[] result = array.getArray();

        // Assert
        assertArrayEquals(initialArray, result);
    }


    //____________________________________________________

    @Test
    void setArray_Test() {
        //Arrange
        Array array = new Array();
        int[] newArray = {1, 8, 7, 6, 5};

        //Act
        array.setArray(newArray);
        int[] result = array.getArray();

        //Assert
        assertArrayEquals(result,newArray);

    }

    //_______________________________________________________________________________


    @Test
    void addElementToArray() {

        //Arrange
        Array array = new Array();

        int[] expectedValues = {1};
        Array expectedArray = new Array(expectedValues);
        //Act
        array.addElementToArray(1);
        //Assert
        assertEquals(array,expectedArray);
    }

    @Test
    void addElementsToArray() {

        //Arrange
        Array array = new Array();

        int[] expectedValues = {1, 2,5};
        Array expectedArray = new Array(expectedValues);

        //Act
        array.addElementToArray(1);
        array.addElementToArray(2);
        array.addElementToArray(5);


        //Assert
        assertEquals(array,expectedArray);
    }

    //__________________________________________________________________

    @Test
    void testEquals_False() {
        int[] expectedValue = {4,6};
        Array diferentArray = new Array(expectedValue);
        Array array = new Array();

        assertNotEquals(array,diferentArray);
    }

    @Test
    void testEquals_ComparisonBetweenDifClassArrays() {
        int[] expectedValue = {4,6};
        Array diferentArray = new Array(expectedValue);

        assertNotEquals(diferentArray,expectedValue);
    }

    @Test
    void testEquals() {
        Array array = new Array();

        assertEquals(array,array);
    }


    @Test
    void testEquals_DiferentArrayObjectsSameContent() {
        int[] expectedValue = {4,6};
        Array diferentArray = new Array(expectedValue);
        Array array = new Array(expectedValue);

        assertEquals(array,diferentArray);
    }

    //_____________________________________________________________________

    @Test
    void testHashCode() {
        int[] expectedValue = {4,6};
        Array diferentArray = new Array(expectedValue);
        Array array = new Array(expectedValue);

        assertEquals(array.hashCode(),diferentArray.hashCode());
    }

    @Test
    void testHashCode_NotEqual() {
        int[] expectedValue = {4,6};
        int[] expectedValue2 = {4,5};
        Array diferentArray = new Array(expectedValue);
        Array array = new Array(expectedValue2);

        assertNotEquals(array.hashCode(),diferentArray.hashCode());
    }

    //______________________________________________________________

    @Test
    void takeElementOfArray_EmptyArray() {

        //Arrange
        Array array = new Array();

        int[] expectedValue = {};
        Array expectedArray = new Array(expectedValue);

        //Act
        array.takeElementOfArray(1);

        //Assert
        assertEquals(array,expectedArray);


    }

    @Test
    void takeElementOfArray_ElementNotFoundInArray() {


        //Arrange
        Array array = new Array();
        array.addElementToArray(4);
        array.addElementToArray(6);

        int[] expectedValue = {4,6};
        Array expectedArray = new Array(expectedValue);

        //Act
        array.takeElementOfArray(1);

        //Assert
        assertEquals(array,expectedArray);

    }


    @Test
    void takeElementOfArray() {

        //Arrange
        Array array = new Array();
        array.addElementToArray(4);
        array.addElementToArray(6);

        int[] expectedValue = {6};
        Array expectedArray = new Array(expectedValue);

        //Act
        array.takeElementOfArray(4);

        //Assert
        assertEquals(array,expectedArray);

    }

    @Test
    void takeElementOfArray_WithRepeatedElements() {

        //Arrange
        Array array = new Array();
        array.addElementToArray(4);
        array.addElementToArray(6);
        array.addElementToArray(3);
        array.addElementToArray(6);
        array.addElementToArray(-9);

        int[] expectedValue = {4,3,6,-9};
        Array expectedArray = new Array(expectedValue);

        //Act
        array.takeElementOfArray(6);

        //Assert
        assertEquals(array,expectedArray);

    }

    //__________________________________________________________

    @Test
    void exceptionReturnElementGivenIndex_EmptyArray() {
        //Arrange
        Array array = new Array();
        String expectedMessage = "Invalid Index";

        //Act + Assert

        Exception exception = assertThrows(IllegalArgumentException.class, () -> array.returnElementGivenIndex(1));
        String actualMessage = exception.getMessage();
        //assertEquals(expectedMessage,actualMessage);

        //Or
        assertTrue(actualMessage.contains(expectedMessage));

    }


    @Test
    void exceptionReturnElementGivenIndex_NegativeIndex() {
        //Arrange
        int[] expectedValues = {1, 2,5};
        Array array = new Array(expectedValues);
        String expectedMessage = "Invalid Index";

        //Act + Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> array.returnElementGivenIndex(-3));
        String actualMessage = exception.getMessage();
        //assertEquals(expectedMessage,actualMessage);

        //Or
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void exceptionReturnElementGivenIndex_OutOfBoundsIndex() {
        //Arrange
        int[] expectedValues = {1, 2,5};
        Array array = new Array(expectedValues);
        String expectedMessage = "Invalid Index";

        //Act + Assert
        Exception exception = assertThrows(IllegalArgumentException.class, () -> array.returnElementGivenIndex(3));
        String actualMessage = exception.getMessage();
        //assertEquals(expectedMessage,actualMessage);

        //Or
        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void returnElementGivenIndex() {
        //Arrange
        int[] expectedValues = {1, 2,5};
        Array array = new Array(expectedValues);
        int expected = 1;

        //Act
        int result = array.returnElementGivenIndex(0);

        //Assert
        assertEquals(expected, result);

    }

    //_________________________________________________________

    @Test
    void getArrayLenght() {

        //Arrange
        int[] expectedValues = {1, 2,5};
        Array array = new Array(expectedValues);
        int expected = 3;

        //Act
        int result = array.getArrayLenght();

        //Assert

        assertEquals(expected, result);

    }

    @Test
    void getArrayLenght_EmptyArray() {

        //Arrange
        Array array = new Array();
        int expected = 0;

        //Act
        int result = array.getArrayLenght();

        //Assert

        assertEquals(expected, result);

    }

    //_____________________________________________

    @Test
    void getBiggestElement() {

        //Arrange
        int[] expectedValues = {1, 2,5};
        Array array = new Array(expectedValues);
        int expected = 5;

        //Act
        int result = array.getBiggestElement();

        //Assert
        assertEquals(expected, result);

    }

    @Test
    void exceptionGetBiggestElement_ArrayIsEmpty() {

        //Arrange
        Array array = new Array();
        String expected = "Empty array";

        //Assert + Act
        Exception exception = assertThrows(NoSuchElementException.class, array::getBiggestElement);
        String actualString = exception.getMessage();

        //Assert
        assertEquals(expected, actualString);

    }

    //_________________________________________________

    @Test
    void getSmallestElement_FirstElementIsSmallest() {

        //Arrange
        int[] expectedValues = {1, 2,5};
        Array array = new Array(expectedValues);
        int expected = 1;

        //Act
        int result = array.getSmallesttElement();

        //Assert
        assertEquals(expected, result);

    }

    @Test
    void getSmallestElement() {

        //Arrange
        int[] expectedValues = {1, 2,5,-7,88};
        Array array = new Array(expectedValues);
        int expected = -7;

        //Act
        int result = array.getSmallesttElement();

        //Assert
        assertEquals(expected, result);

    }

    @Test
    void exceptionGetSmallestElement_ArrayIsEmpty() {

        //Arrange
        Array array = new Array();
        String expected = "Empty array";

        //Assert + Act
        Exception exception = assertThrows(NoSuchElementException.class, array::getSmallesttElement);
        String actualString = exception.getMessage();

        //Assert
        assertEquals(expected, actualString);

    }

    //____________________________________________________________


    @Test
    void averageOfElementsOfAnArray() {

        //Arrange
        int[] newArray = {1, 6, 2, 3, 5};
        Array array = new Array(newArray);
        double expected = 3.4;

        //Act
        double result = array.averageOfElementsOfAnArray();

        //Assert
        assertEquals(expected, result, 0.01);
    }

    @Test
    void averageOfElementsOfAnArray_EmptyArray() {

        //Arrange
        Array array = new Array();
        double expected = 0;

        //Act
        double result = array.averageOfElementsOfAnArray();

        //Assert
        assertEquals(expected, result);
    }

    //_____________________________________________________________

    @Test
    void averageOfAllEvenElements() {

        //Arrange
        int[] newArray = {1, 6, 2, 3, 5};
        Array array = new Array(newArray);
        double expected = 4;

        //Act
        double result = array.averageOfAllEvenElements();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void averageOfAllEvenElements_EmptyArray() {

        //Arrange
        Array array = new Array();
        double expected = 0;

        //Act
        double result = array.averageOfAllEvenElements();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void averageOfAllEvenElements_NoEvenNumbersInAnArray() {

        //Arrange
        int[] newArray = {1,9};
        Array array = new Array(newArray);
        double expected = 0;

        //Act
        double result = array.averageOfAllEvenElements();

        //Assert
        assertEquals(expected, result);
    }

    //___________________________________________________________________________________

    @Test
    void averageOfAllOddElements() {

        //Arrange
        int[] newArray = {7,9};
        Array array = new Array(newArray);
        double expected = 8;

        //Act
        double result = array.averageOfAllOddElements();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void averageOfAllOddElements_EmptyArray() {

        //Arrange
        Array array = new Array();
        double expected = 0;

        //Act
        double result = array.averageOfAllOddElements();

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void averageOfAllOddElements_NoOddElements() {

        //Arrange
        int[] newArray = {2,4,6,8,10};
        Array array = new Array(newArray);
        double expected = 0;

        //Act
        double result = array.averageOfAllOddElements();

        //Assert
        assertEquals(expected, result);
    }

    //_________________________________________________

    @Test
    void mediaOfMultiplesOfOneNumber() {

        //Arrange
        int[] newArray = {1, 6, 2, 3, 5, -3, 7, 5};
        Array array = new Array(newArray);
        int multiple = 3;
        int expected = 2;

        //Act
        double result = array.mediaOfMultiplesOfOneNumber(multiple);

        //Assert
        assertEquals(expected, result);
    }


    @Test
    void mediaOfMultiplesOfOneNumber_EmptyArray() {


        //Arrange
        Array array = new Array();
        int multiple = 3;
        int expected = 0;

        //Act
        double result = array.mediaOfMultiplesOfOneNumber(multiple);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void mediaOfMultiplesOfOneNumber_multipleIsZero() {


        //Arrange
        int[] newArray = {1, 6, 2, 3, 5, -3, 7, 5};
        Array array = new Array(newArray);
        int multiple = 0;
        int expected = 0;

        //Act
        double result = array.mediaOfMultiplesOfOneNumber(multiple);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void mediaOfMultiplesOfOneNumber_noMultiplesInArray() {

        //Arrange
        int[] newArray = {1, 6, 2, 3, 5, -3, 7, 5};
        Array array = new Array(newArray);;
        int multiple = 9;
        int expected = 0;

        //Act
        double result = array.mediaOfMultiplesOfOneNumber(multiple);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void orderingInAscendingOrder() {

        //Arrange
        int[] newArray = {7, 3, -9, 11, 1, 7, -9, -9};
        Array array = new Array(newArray);

        int[] expectedValues = {-9, -9, -9, 1, 3, 7, 7, 11};
        Array expected = new Array(expectedValues);

        //Act
        array.orderingInAscendingOrder();

        //Assert
        assertEquals(array,expected);


    }

    @Test
    void orderingInAscendingOrder_EmptyArray() {

        //Arrange
        Array array = new Array();
        Array expected = new Array();

        //Act
        array.orderingInAscendingOrder();

        //Assert
        assertEquals(array,expected);


    }

    //________________________________________________________

    @Test
    void orderingInDescendingOrder() {

        //Arrange
        int[] newArray = {7, 3, -9, 11, 1, 7, -9, -9};
        Array array = new Array(newArray);

        int[] expectedValues = {11, 7, 7, 3, 1, -9, -9, -9};
        Array expected = new Array(expectedValues);

        //Act
        array.orderingInDescendingOrder();

        //Assert
        assertEquals(array,expected);


    }

    @Test
    void orderingInDescendingOrder_EmptyArray() {

        //Arrange
        Array array = new Array();
        int[] expected = {};

        //Act
        array.orderingInDescendingOrder();
        int[] result = array.getArray();

        //Assert
        assertArrayEquals(expected, result);


    }

    //_________________________________________________


    @Test
    void arrayIsEmpty() {
        //Arrange
        Array array = new Array();

        //Act
        boolean result = array.isArrayEmpty();

        //Assert
        assertTrue(result);
    }

    @Test
    void arrayIsNotEmpty() {
        //Arrange
        int[] newArray = {7, 3, -9, 11, 1, 7, -9, -9};
        Array array = new Array(newArray);

        //Act
        boolean result = array.isArrayEmpty();

        //Assert
        assertFalse(result);
    }

    //_______________________________________________________

    @Test
    void arrayHasOnlyOneElement() {

        //Arrange
        int[] newArray = {7};
        Array array = new Array(newArray);
        //Act
        boolean result = array.doesArrayHaveOnlyOneElement();

        //Assert
        assertTrue(result);
    }

    @Test
    void arrayHasOnlyOneElement_False() {

        //Arrange
        int[] newArray = {7, 3};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveOnlyOneElement();

        //Assert
        assertFalse(result);
    }

    //_________________________________________________________

    @Test
    void arrayHasOnlyEvenElements() {
        //Arrange
        int[] newArray = {2,4,6,8,10,0};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveOnlyEvenElement();

        //Assert
        assertTrue(result);
    }

    @Test
    void arrayHasOnlyEvenElements_False() {
        //Arrange
        int[] newArray = {2,6,1,6,90,100,0};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveOnlyEvenElement();

        //Assert
        assertFalse(result);
    }

    @Test
    void arrayHasNoEvenElements() {
        //Arrange
        int[] newArray = {7, 3, -9, 11, 1, 7, -9, -9};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveOnlyEvenElement();

        //Assert
        assertFalse(result);
    }

    @Test
    void arrayHasNoEvenElements_EmptyArray() {
        //Arrange
        int[] newArray = {};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveOnlyEvenElement();

        //Assert
        assertFalse(result);
    }

    //_________________________________________________________

    @Test
    void arrayHasOnlyOddElements() {
        //Arrange
        int[] newArray = {7, 3, -9, 11, 1, 7, -9, -9};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveOnlyOddElement();

        //Assert
        assertTrue(result);
    }

    @Test
    void arrayHasOnlyOddElements_False() {
        //Arrange
        int[] newArray = {7, 3, -9, 2, 1, 7, -9, -9};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveOnlyOddElement();

        //Assert
        assertFalse(result);
    }

    @Test
    void arrayHasNoOddElements() {
        //Arrange
        int[] newArray = {8,2,4};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveOnlyOddElement();

        //Assert
        assertFalse(result);
    }

    @Test
    void arrayHasNoOddElements_EmptyArray() {
        //Arrange
        int[] newArray = {};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveOnlyOddElement();

        //Assert
        assertFalse(result);
    }

    //____________________________________________________


    @Test
    void noRepeteadNumbersInArray() {

        //Arrange
        int[] newArray = {8,2,4};
        Array array = new Array(newArray);

        //Act
         boolean result = array.doesArrayHaveRepeteadNumbers();

         //Assert
        assertFalse(result);
    }

    @Test
    void arrayHasRepeteadNumbers() {

        //Arrange
        int[] newArray = {8,2,4,2,4};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveRepeteadNumbers();

        //Assert
        assertTrue(result);
    }

    @Test
    void arrayHasRepeteadNumbers_OneElementArray() {

        //Arrange
        int[] newArray = {1};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveRepeteadNumbers();

        //Assert
        assertFalse(result);
    }

    @Test
    void arrayHasRepeteadNumbers_TwoEqualElementArray() {

        //Arrange
        int[] newArray = {1,1};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveRepeteadNumbers();

        //Assert
        assertTrue(result);
    }

    @Test
    void arrayHasRepeteadNumbers_emptyArray() {

        //Arrange
        int[] newArray = {};
        Array array = new Array(newArray);

        //Act
        boolean result = array.doesArrayHaveRepeteadNumbers();

        //Assert
        assertFalse(result);
    }

    //____________________________________________________________


    @Test
    void oneElementBiggerThanAverage() {

        //Arrange
        int[] initialValues = {8,2,4,2};
        Array array = new Array(initialValues);

        int[] expectedValues = {8};
        Array expectedArray = new Array(expectedValues);

        //Act
        Array result = new Array(array.elementsBiggerThanAverage());

        //Assert
       assertEquals(result,expectedArray);
    }

    @Test
    void elementsBiggerThanAverage_EmptyArray() {

        //Arrange
        int[] initialValues = {};
        Array array = new Array(initialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        Array result = new Array(array.elementsBiggerThanAverage());

        //Assert
        assertEquals(result,expectedArray);
    }

    @Test
    void elementsBiggerThanAverage() {

        //Arrange
        int[] initialValues = {8,2,4,2,9,4,10};
        Array array = new Array(initialValues);

        int[] expectedValues = {8,9,10};
        Array expectedArray = new Array(expectedValues);

        //Act
        Array result = new Array(array.elementsBiggerThanAverage());

        //Assert
        assertEquals(result,expectedArray);
    }

    @Test
    void noElementsBiggerThanAverage() {

        //Arrange
        int[] initialValues = {0};
        Array array = new Array(initialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        Array result = new Array(array.elementsBiggerThanAverage());

        //Assert
        assertEquals(result,expectedArray);
    }

    //_____________________________________________________________

    @Test
    void numberOfElementsMultiplesOfSpecifiedDivisor_DivisorIsTwo() {

        //Arrange
        int[] inicialValues = {1,2,4,5,6,27,100};
        Array inicialArray = new Array(inicialValues);
        int expected = 4;

        //Act
        int result = inicialArray.numberOfElementsMultiplesOfSpecifiedDivisor(2);

        //Assert
        assertEquals(expected,result);

    }

    @Test
    void numberOfElementsMultiplesOfSpecifiedDivisor_EmptyArray() {

        //Arrange
        int[] inicialValues = {};
        Array inicialArray = new Array(inicialValues);
        int expected = -1;

        //Act
        int result = inicialArray.numberOfElementsMultiplesOfSpecifiedDivisor(2);

        //Assert
        assertEquals(expected,result);

    }

    @Test
    void numberOfElementsMultiplesOfSpecifiedDivisor_DivisorIsZero() {

        //Arrange
        int[] inicialValues = {1,2,4,5,6,27,100};
        Array inicialArray = new Array(inicialValues);
        int expected = -1;

        //Act
        int result = inicialArray.numberOfElementsMultiplesOfSpecifiedDivisor(0);

        //Assert
        assertEquals(expected,result);

    }


    //_____________________________________________________________

    @Test
    void evenElementsOfAnArray() {

        //Arrange
        int[] inicialValues = {1,2,4,5,6,27,100};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {2,4,6,100};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.evenElementsOfAnArray();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    @Test
    void evenElementsOfAnArray_ArrayHasNotOddNumbers() {

        //Arrange
        int[] inicialValues = {3,7,9};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.evenElementsOfAnArray();
        Array resultArray = new Array(resultValues);

        //Assert

        assertEquals(expectedArray,resultArray);
    }


    @Test
    void evenElementsOfAnArray_ArrayIsEmpty() {

        //Arrange
        int[] inicialValues = {};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.evenElementsOfAnArray();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }


    @Test
    void evenElementsOfAnArray_ArrayHasOnlyEvenNumbers() {

        //Arrange
        int[] inicialValues = {2,4,6,8,10,12};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {2,4,6,8,10,12};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.evenElementsOfAnArray();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    //__________________________________________________________

   @Test
    void crescentNumbersInAVector() {

        //Arrange
        int[] inicialValues = {123,3,456,95,89,10,1};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {123,456,89};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.crescentNumbersInAVector();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    @Test
    void crescentNumbersInAVector_NoCrescentNumbers() {

        //Arrange
        int[] inicialValues = {321,1,4,0,-9};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.crescentNumbersInAVector();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    @Test
    void crescentNumbersInAVector_EmptyVector() {

        //Arrange
        int[] inicialValues = {};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.crescentNumbersInAVector();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    //_________________________________________________


    @Test
    void capicuasInArray() {

        //Arrange
        int[] inicialValues = {1,2,34,121};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {1,2,121};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.capicuaElementsOfAnArray();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    @Test
    void  capicuasInArray_NoCapicuas() {

        //Arrange
        int[] inicialValues = {321,-13,78,12,-91};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.capicuaElementsOfAnArray();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    @Test
    void  capicuasInArray_EmptyVector() {

        //Arrange
        int[] inicialValues = {};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.capicuaElementsOfAnArray();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    //__________________________________________________________

    @Test
    void composedByTheSameAlgarismElements() {

        //Arrange
        int[] inicialValues = {1,-9,23,444,121,888};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {1,-9,444,888};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.composedByTheSameAlgarismElements();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    @Test
    void  composedByTheSameAlgarismElements_NoSameAlgarisms() {

        //Arrange
        int[] inicialValues = {321,-13,78,12,-91};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.composedByTheSameAlgarismElements();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    @Test
    void  composedByTheSameAlgarismElements_EmptyArray() {

        //Arrange
        int[] inicialValues = {};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.composedByTheSameAlgarismElements();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    //_____________________________________________

    @Test
    void elementsThatAreNotAmstrongNumbers() {

        //Arrange
        int[] inicialValues = {9,44,153,6,12,8};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {44,12};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.elementsThatAreNotAmstrongNumbers();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);

    }

    @Test
    void elementsThatAreNotAmstrongNumbers_NoAmstrongNumbers() {

        //Arrange
        int[] inicialValues = {44,66,12,23};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {44,66,12,23};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.elementsThatAreNotAmstrongNumbers();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);

    }

    @Test
    void elementsThatAreNotAmstrongNumbers_AllNumbersAreAmstrongNumbers() {

        //Arrange
        int[] inicialValues = {1,2,9,370,371,407};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.elementsThatAreNotAmstrongNumbers();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);

    }

    @Test
    void elementsThatAreNotAmstrongNumbers_EmptyArray() {

        //Arrange
        int[] inicialValues = {};
        Array inicialArray = new Array(inicialValues);

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.elementsThatAreNotAmstrongNumbers();
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);

    }

    //_________________________________________________

    @Test
    void crescentNSequenceOfAlgarisms_ThreeAsSequence() {
        //Arrange
        int[] inicialValues = {24,56,234,567,89,12345};
        Array inicialArray = new Array(inicialValues);
        int sequence = 3;

        int[] expectedValues = {234,567,12345};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.crescentNSequenceOfAlgarisms(sequence);
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    @Test
    void crescentNSequenceOfAlgarisms_NoValuesWithCertainSequence() {
        //Arrange
        int[] inicialValues = {1,4,5,6,8};
        Array inicialArray = new Array(inicialValues);
        int sequence = 2;

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.crescentNSequenceOfAlgarisms(sequence);
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    @Test
    void crescentNSequenceOfAlgarisms_EmptyArray() {
        //Arrange
        int[] inicialValues = {};
        Array inicialArray = new Array(inicialValues);
        int sequence = 2;

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.crescentNSequenceOfAlgarisms(sequence);
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    @Test
    void crescentNSequenceOfAlgarisms_InvalidSequence() {
        //Arrange
        int[] inicialValues = {45,66,78,1};
        Array inicialArray = new Array(inicialValues);
        int sequence = 1;

        int[] expectedValues = {};
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.crescentNSequenceOfAlgarisms(sequence);
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    @Test
    void crescentNSequenceOfAlgarisms_NegativeAndPositiveValues() { //NegativeValuesAreAlwaysExcluded
        //Arrange
        int[] inicialValues = {-10,-19};
        Array inicialArray = new Array(inicialValues);
        int sequence = 2;

        int[] expectedValues = {-10}; //Note that with negative values the logic is reverse! -1 is
        // smaller than 0, -3 is smaller than -2, so -32 is a crescent sequence
        Array expectedArray = new Array(expectedValues);

        //Act
        int[] resultValues = inicialArray.crescentNSequenceOfAlgarisms(sequence);
        Array resultArray = new Array(resultValues);

        //Assert
        assertEquals(expectedArray,resultArray);
    }

    //________________________________________________________________________

    @Test
    void ArrayAndPassedArrayAreTheSame() {

        //Arrange
        int[] inicialValues = {-10,-19};
        Array inicialArray = new Array(inicialValues);

        //Act

        boolean result = inicialArray.areArrayAndPassedArrayTheSame(inicialValues);
        //Assert
        assertTrue(result);


    }

    @Test
    void ArrayAndPassedArrayAreNotTheSame() {

        //Arrange
        int[] inicialValues = {-10,-19};
        Array inicialArray = new Array(inicialValues);
        int[] diferentValues = {-10,20};

        //Act

        boolean result = inicialArray.areArrayAndPassedArrayTheSame(diferentValues);
        //Assert
        assertFalse(result);


    }

    @Test
    void ArrayAndPassedArrayAreTheSame_EmptyArray() {

        //Arrange
        int[] inicialValues = {};
        Array inicialArray = new Array(inicialValues);

        //Act

        boolean result = inicialArray.areArrayAndPassedArrayTheSame(inicialValues);
        //Assert
        assertTrue(result);


    }


    //____________________________________________________________
}