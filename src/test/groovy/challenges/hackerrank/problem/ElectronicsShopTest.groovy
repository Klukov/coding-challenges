package challenges.hackerrank.problem

import spock.lang.Specification

class ElectronicsShopTest extends Specification {

    def "should return -1 when there is no option"() {
        when:
        def result = ElectronicsShop.getMoneySpent([10, 15, 20] as int[], [2, 3, 5] as int[], budget)

        then:
        result == -1

        where:
        budget << [1, 9, 11]
    }

    def "should return only one option in simple case"() {
        when:
        def result = ElectronicsShop.getMoneySpent([10] as int[], [2] as int[], 15)

        then:
        result == 12
    }

    def "should return correct result in advanced example"() {
        when:
        def result = ElectronicsShop.getMoneySpent(keyboards as int[], drives as int[], budget)

        then:
        result == 34

        where:
        keyboards            | drives               | budget || expectedValue
        [30, 15, 20, 10, 50] | [8, 6, 2, 14]        | 35     || 34
        [8, 6, 2, 14]        | [30, 15, 20, 10, 50] | 35     || 34
    }
}
