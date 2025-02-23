package challenges.hackerrank.problem

import spock.lang.Specification

class EncryptionProblemTest extends Specification {


    def "should return correctly encrypted message"() {
        when:
        def result = EncryptionProblem.Result.encryption(input)

        then:
        result == expectedResult

        where:
        input              || expectedResult
        "haveaniceday"     || "hae and via ecy"
        "have a nice day"  || "hae and via ecy"
        "have a nice days" || "haes and via ecy"
        "feedthedog    "   || "fto ehg ee dd"
        "chillout"         || "clu hlt io"
    }

    def "should properly calculate rows"() {
        when:
        def result = EncryptionProblem.Result.calculateRows(input)

        then:
        result == expectedResult

        where:
        input || expectedResult
        1     || 1
        2     || 1
        3     || 2
        4     || 2
        5     || 2
        6     || 2
        7     || 3
        8     || 3
        9     || 3
        10    || 3
        11    || 3
        12    || 3
        13    || 4
        14    || 4
        15    || 4
        16    || 4
        17    || 4

        71    || 8
        72    || 8
        73    || 9
    }
}
