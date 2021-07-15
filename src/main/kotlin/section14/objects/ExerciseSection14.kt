package section14.objects

/*
    1. Create 5 Singletons
    2. Create 5 Companion Objects
    3. Create 5 Anonymous Objects
 */

fun main(){
    //1
    val song1 = E1Song("Feels Right", "Rock", "Biig Piig")
    val song2 = E1Song("Sofia", "Pop", "Clairo")

    E1AlbumCompilation.addSong(song1)
    E1AlbumCompilation.addSong(song2)
    E1AlbumCompilation.printSongList()
    E1AlbumCompilation.findRockMusic()

    val emp1 = E2Employee("Joko", "Manager")
    val emp2 = E2Employee("Diana", "Presiden Direktur")

    E2Company.addEmployee(emp1)
    E2Company.addEmployee(emp2)
    E2Company.printAllEmployee()

    val car1 = E3Car("Pajero","Mitsubishi","SUV")
    val car2 = E3Car("Ignis","Suzuki","City Car")
    val car3 = E3Car("Rubicon","Jeep","SUV")
    val car4 = E3Car("Explorer","Ford","SUV")

    E3CarManufacture.addCar(car1)
    E3CarManufacture.addCar(car2)
    E3CarManufacture.addCar(car3)
    E3CarManufacture.addCar(car4)
    E3CarManufacture.printCarList()
    E3CarManufacture.removeCar(car4)
    E3CarManufacture.cariTipe("SUV")

    val fruit1 = E4Fruit("Watermelon", "Green")
    val fruit2 = E4Fruit("Strawberry", "Green")

    E4FruitBook.addFruit(fruit1)
    E4FruitBook.addFruit(fruit2)
    E4FruitBook.removeFruit(fruit2)
    E4FruitBook.printFruitList()

    val student1 = E5Student("Dian", 5, 99)
    val student2 = E5Student("Tono", 6, 74)
    val student3 = E5Student("Januari", 5, 100)
    val student4 = E5Student("Febby", 4, 88)

    E5School.addStudent(student1)
    E5School.addStudent(student2)
    E5School.addStudent(student3)
    E5School.addStudent(student4)
    E5School.printGoodStudents()

    //2
    val book1 = E21Book.registerBook(54234, "Why?", "Ensiklopedia")
    val book2 = E21Book.registerBook(23454, "Edensor", "Fantasi")
    val book3 = E21Book.registerBook(86895, "Dragon and Apple", "Novel")

    E21Library.addBook(book1)
    E21Library.addBook(book2)
    E21Library.addBook(book3)
    E21Library.printBookList()

    val food1 = E22Food.addNewFood("Pizza", 54000)
    val food2 = E22Food.addNewFood("Pecel", 15000)
    val food3 = E22Food.addNewFood("Ayam Goreng", 25000)

    E22Menu.addEntree(food1)
    E22Menu.addEntree(food2)
    E22Menu.addEntree(food3)
    E22Menu.removeEntree(food2)
    E22Menu.printMenu()

    val doctor1 = E23Doctor.newDoctor("dr. Shanti", "THT")
    val doctor2 = E23Doctor.newDoctor("dr. Tomoko", "Penyakit Dalam")
    val doctor3 = E23Doctor.newDoctor("dr. Suci", "Kulit")

    E23Hospital.addDoctor(doctor1)
    E23Hospital.addDoctor(doctor2)
    E23Hospital.addDoctor(doctor3)
    E23Hospital.printDoctorList()

    val fish1 = E24Fish.discoverNewFish("Nemo", "Orange", "Small")
    val fish2 = E24Fish.discoverNewFish("Dory", "Blue", "Small")
    val fish3 = E24Fish.discoverNewFish("Dolphin", "Gray", "Medium")
    val fish4 = E24Fish.discoverNewFish("Whale", "Black", "Large")

    E24Sea.registerFish(fish1)
    E24Sea.registerFish(fish2)
    E24Sea.registerFish(fish3)
    E24Sea.registerFish(fish4)
    E24Sea.printFishList()
    E24Sea.removeFish(fish3)
    E24Sea.printFishList()

    val vegetable1 = E25Vegetable.addNewVegetable("Spinach", "Leaves", "Asia")
    val vegetable2 = E25Vegetable.addNewVegetable("Ginger", "Roots", "Southeast Asia")
    val vegetable3 = E25Vegetable.addNewVegetable("Carrot", "Roots", "Europe")

    E25VegetableBook.addVeggie(vegetable1)
    E25VegetableBook.addVeggie(vegetable2)
    E25VegetableBook.addVeggie(vegetable3)
    E25VegetableBook.printVeggieList()

    //3
    val howManyBook = object : HowMany {
        override fun howManyOnTheList(): Int {
            return E21Library.bookDescription.size
        }
    }
    println(howManyBook.howManyOnTheList())

    val howManyExpensiveFood = object : HowMany{
        override fun howManyOnTheList(): Int {
            val result = E22Menu.menuList.filter {
                it.price > 20000
            }
            return result.size
        }
    }
    println(howManyExpensiveFood.howManyOnTheList())

    val howManyDoctor = object : HowMany {
        override fun howManyOnTheList(): Int {
            return E23Hospital.doctorInformation.size
        }
    }
    println(howManyDoctor.howManyOnTheList())

    val smallFish = object : HowMany {
        override fun howManyOnTheList(): Int {
            val result = E24Sea.fishInformation.filter {
                it.size.lowercase().contains("small")
            }
            return result.size
        }
    }
    println(smallFish.howManyOnTheList())

    val isSpinachExist = object : Contains{
        override fun containsOf(): Boolean {
            val result = E25VegetableBook.veggieList.filter {
                it.name.lowercase().contains("spinach")
            }
            return result.isNotEmpty()
        }
    }
    println(isSpinachExist.containsOf())
}

interface HowMany {
    fun howManyOnTheList(): Int
}

interface Contains {
    fun containsOf(): Boolean
}