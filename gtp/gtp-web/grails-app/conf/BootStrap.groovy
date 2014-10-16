import com.logicify.demo.gtp.domain.Book

class BootStrap {

    def init = { servletContext ->
        if (!Book.count()) {
            new Book(title: 'Book 1', author: 'Author 1', description: 'some description')
        }
    }
    def destroy = {
    }
}
