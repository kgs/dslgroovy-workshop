class Processor {
    def expenses = [:]

    def methodMissing(String name, args) {
        def v = expenses."$name" ? expenses."$name" : 0
        try {
            expenses."$name" = v + Double.valueOf(args[0])
        } catch (any) {
            println "$name ${args[0]} is invalid"
        }
    }

    def getWinner() {
        println "The winner is:"

        def winner = expenses.max { entry -> entry.value }
        println "$winner.key with score $winner.value"
    }

    static void process(dsl) {
        Processor processor = new Processor()

        def code = """
            processor.with {
                $dsl
            }
        """

        def binding = new Binding()
        binding.setProperty('processor', processor)
        new GroovyShell(binding).evaluate(code)

        processor.printResults()
    }

    void printResults() {
        println "Total expense is ${expenses.values().sum()}\$"
        println "Itemized expenses:"
        println "Item\t\tAmount"
        for (e in expenses.keySet()) {
            println "$e\t\t${expenses[e]}"
        }
    }
}




