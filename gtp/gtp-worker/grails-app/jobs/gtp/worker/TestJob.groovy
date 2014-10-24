package gtp.worker


class TestJob {
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        println "This line was printed by background worker"
    }
}
