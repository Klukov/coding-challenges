package challenges.hackerrank.problem

import spock.lang.Specification

class DesignerPdfViewerTest extends Specification {


    def "should return proper area of highlight"() {
        when:
        def result = DesignerPdfViewer.Result.designerPdfViewer(inputHeight, word)

        then:
        result == expectedResult

        where:
        inputHeight                                                                    | word   || expectedResult
        [1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5] | "abc"  || 9
        [1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7] | "zaba" || 28
        [1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7] | "aceg" || 4
    }
}
