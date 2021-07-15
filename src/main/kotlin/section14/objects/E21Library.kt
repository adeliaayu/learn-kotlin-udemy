package section14.objects

object E21Library {

    val bookDescription = mutableListOf<E21Book>()

    fun addBook(book: E21Book){
        bookDescription.add(book)
    }

    fun removeBook(book: E21Book){
        bookDescription.remove(book)
    }

    fun printBookList(){
        bookDescription.forEach {
            println("${it.bookName} adalah buku ${it.bookType}")
        }
    }
}