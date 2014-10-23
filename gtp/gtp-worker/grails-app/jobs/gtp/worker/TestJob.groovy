package gtp.worker



class TestJob {
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        System.out.println('This is test job')
    }
}
