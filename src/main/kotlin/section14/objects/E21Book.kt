package section14.objects

class E21Book private constructor(val ssn: Int, val bookName: String, val bookType: String) {

    companion object {

        fun registerBook(ssn: Int, bookName: String, bookType: String) : E21Book {
            return E21Book(ssn, bookName, bookType)
        }
    }
}