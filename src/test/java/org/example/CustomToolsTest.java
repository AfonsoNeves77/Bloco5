package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomToolsTest {

    @Test
    void howManyElementsInAnArray() {

        //Arrange
        int[] array = {1,2,3,5,6,2,2};
        int expected = 3;

        //Act
        int result = CustomTools.howManyElementsInAnArray(array,2);
        //Assert

        assertEquals(expected,result);
    }

    @Test
    void howManyElementsInAnArray_EmptyArray() {

        //Arrange
        int[] array = {};
        int expected = -999;

        //Act
        int result = CustomTools.howManyElementsInAnArray(array,2);
        //Assert

        assertEquals(expected,result);
    }

    @Test
    void howManyElementsInAnArray_NoElementsFound() {

        //Arrange
        int[] array = {1,2,3,5,6,2,2};
        int expected = 0;

        //Act
        int result = CustomTools.howManyElementsInAnArray(array,7);
        //Assert

        assertEquals(expected,result);
    }


    //___________________________________________

    @Test
    void isNumberACrescentSequence() {

        //Arrange
        int number = 123;

        //Act
        boolean result = CustomTools.isNumberACrescentSequence(number);

        //Assert
        assertTrue(result);
    }

    @Test
    void isNumberACrescentSequence_CrescentNegativeNumber() {

        //Arrange
        int number = -321; //Reversed -3 is smaller than -2 and so on...

        //Act
        boolean result = CustomTools.isNumberACrescentSequence(number);

        //Assert
        assertTrue(result);
    }

    @Test
    void isNumberACrescentSequence_DescendingNegativeNumber() {

        //Arrange
        int number = -123; //Reversed -3 is smaller than -2 and so on...

        //Act
        boolean result = CustomTools.isNumberACrescentSequence(number);

        //Assert
        assertFalse(result);
    }

    @Test
    void isNumberACrescentSequence_OneDigitNumberNegtiveNumber() {

        //Arrange
        int number = -9;

        //Act
        boolean result = CustomTools.isNumberACrescentSequence(number);

        //Assert
        assertFalse(result);
    }

    @Test
    void isNumberACrescentSequence_OneDigitNumberPositiveNumber() {

        //Arrange
        int number = 9;

        //Act
        boolean result = CustomTools.isNumberACrescentSequence(number);

        //Assert
        assertFalse(result);
    }

    //_________________________________________

    @Test
    void isCapucua() {
        boolean expected = CustomTools.isCapucua(121);
        assertTrue(expected);
    }

    @Test
    void isCapucua_NegativeNumber() {
        boolean expected = CustomTools.isCapucua(-121);
        assertTrue(expected);
    }

    @Test
    void isCapucuaZero() {
        boolean expected = CustomTools.isCapucua(0);
        assertTrue(expected);
    }

    @Test
    void isNotCapucua() {
        boolean expected = CustomTools.isCapucua(12);
        assertFalse(expected);
    }

    //________________________________________

    @Test
    void numberAlgarismsAreEqual() {

        //Arrange
        int number = 222;
        //Act
        boolean expected = CustomTools.areNumberAlgarismsEqual(number);

        //Assert
        assertTrue(expected);
    }

    @Test
    void numberAlgarismsAreEqual_NegativeSingleNumber() {

        //Arrange
        int number = -9;
        //Act
        boolean expected = CustomTools.areNumberAlgarismsEqual(number);

        //Assert
        assertTrue(expected);
    }

    @Test
    void numberAlgarismsAreEqual_PositiveSingleNumber() {

        //Arrange
        int number = 9;
        //Act
        boolean expected = CustomTools.areNumberAlgarismsEqual(number);

        //Assert
        assertTrue(expected);
    }

    @Test
    void numberAlgarismsAreNotEqual() {

        //Arrange
        int number = 232;
        //Act
        boolean expected = CustomTools.areNumberAlgarismsEqual(number);

        //Assert
        assertFalse(expected);
    }



    //________________________________________

    @Test
    void isAmstrongNumber() {

        //Arrange
        int number = 370;
        //Act
        boolean expected = CustomTools.isAmstrongNumber(number);

        //Assert
        assertTrue(expected);
    }

    @Test
    void isNotAmstrongNumber() {

        //Arrange
        int number = 375;
        //Act
        boolean expected = CustomTools.isAmstrongNumber(number);

        //Assert
        assertFalse(expected);
    }

    @Test
    void isNotAmstrongNumber_OffLimitsNumber() {

        //Arrange
        int number = 1000;
        //Act
        boolean expected = CustomTools.isAmstrongNumber(number);

        //Assert
        assertFalse(expected);
    }

    @Test
    void isAmstrongNumber_PositiveSingleNumber() {

        //Arrange
        int number = 1;
        //Act
        boolean expected = CustomTools.isAmstrongNumber(number);

        //Assert
        assertTrue(expected);
    }

    @Test
    void isNotAmstrongNumber_Zero() {

        //Arrange
        int number = 0;
        //Act
        boolean expected = CustomTools.isAmstrongNumber(number);

        //Assert
        assertFalse(expected);
    }

    @Test
    void isAmstrongNumber_Nine() {

        //Arrange
        int number = 9;
        //Act
        boolean expected = CustomTools.isAmstrongNumber(number);

        //Assert
        assertTrue(expected);
    }

    @Test
    void isAmstrongNumber_Ten() {

        //Arrange
        int number = 10;
        //Act
        boolean expected = CustomTools.isAmstrongNumber(number);

        //Assert
        assertFalse(expected);
    }

    //________________________________________

    @Test
    void baseLineCalculator() {
        //Arrange
        int sequence = 2;
        int expected = 10;
        //Act

        int result = CustomTools.baseLineCalculator(sequence);

        //Assert
        assertEquals(expected,result);


    }

    @Test
    void baseLineCalculator_SequenceIsOne() {
        //Arrange
        int sequence = 1;
        int expected = -999;
        //Act

        int result = CustomTools.baseLineCalculator(sequence);

        //Assert
        assertEquals(expected,result);


    }

    @Test
    void baseLineCalculator_SequenceIsZero() {
        //Arrange
        int sequence = 0;
        int expected = -999;
        //Act

        int result = CustomTools.baseLineCalculator(sequence);

        //Assert
        assertEquals(expected,result);


    }
}