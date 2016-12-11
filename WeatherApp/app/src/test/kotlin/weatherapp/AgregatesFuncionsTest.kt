package weatherapp

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by ueliton.freitas on 03/12/16.
 */

class AgregatesFuncionsTest {

    var list: List<Int> = emptyList()

    @Before
    fun setUp() {
        list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }

    @Test
    fun shouldFindOnePairElement() {
        assertTrue(list.any { it % 2 == 0 })
    }

    @Test
    fun shouldFindOneElementGraterThan9() {
        assertTrue(list.any { it > 9 })
    }

    @Test
    fun shouldReturnThatAllElementsAreSmallerThan10() {
        assertTrue(list.any { it < 10 })
    }

    @Test
    fun shouldReturnThatNumberOfPairElementsIs5() {
        assertEquals(5, list.count { it % 2 == 0 })
    }

    @Test
    fun shouldSumAllElementsOfTheList() {
        assertEquals(55, list.fold(0) { total, next -> total + next })
    }

    @Test
    fun shouldSumAllListElementsFromRight() {
        assertEquals(55, list.foldRight(0) { total, next -> total + next })
    }

    @Test
    fun shouldSumAllListElementsWithForEach() {
        var sum: Int = 0

        list.forEach { sum += it }

        assertEquals(55, sum)
    }

    @Test
    fun shouldSumAllListElementsWithIndexForEach() {
        var sum: Int = 0

        list.forEachIndexed { index, value ->
            sum += list[index]
        }

        assertEquals(55, sum)
    }

    @Test
    fun shouldReturnMaxElementOfTheList() {

        assertEquals(10, list.max())
    }

    @Test
    fun shouldReturnMaxElementYield() {
        assertEquals(1, list.maxBy { -it })
    }

    @Test
    fun shouldReturnThatThereIsNotElementDivisibleBy11() {
        assertTrue(list.none { it % 11 == 0 })
    }

    @Test
    fun shouldSumAllElementsWithReduce(){
        assertEquals(55, list.reduce { total, next -> total + next })
    }

    @Test
    fun shouldReturnSumOfRestOfNumberMod2(){
        assertEquals(5, list.sumBy { it % 2 })
    }

}
