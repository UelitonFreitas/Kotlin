package weatherapp

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by ueliton.freitas on 03/12/16.
 */
class FilteringFunctionsTest{

    var list: List<Int> = emptyList()

    @Before
    fun setUp() {
        list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }

    @Test
    fun shouldReturnListOfElementsWithoutFirsFiveElements(){
        assertEquals(listOf( 6, 7, 8, 9, 10), list.drop(5))
    }

    @Test
    fun shouldReturnAListOfElementsWithValuesGraterThanFive(){
        assertEquals(listOf( 6, 7, 8, 9, 10), list.dropWhile { it <= 5 })
    }

    @Test
    fun shouldReturnAListOfElementsWithValuesSmallOrEqualToFour(){
        assertEquals(listOf(1, 2, 3, 4), list.dropLastWhile { it > 4 })

    }
}
