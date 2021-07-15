package section14.objects

object E1AlbumCompilation {

    val songList = mutableListOf<E1Song>()

    fun addSong(song: E1Song){
        songList.add(song)
    }

    fun removeSong(song: E1Song){
        songList.remove(song)
    }

    fun printSongList(){
        songList.forEach {
            println(it.songInformation)
        }
    }

    fun findRockMusic(){
        val result = songList.filter {
            it.genre.lowercase().contains("rock")
        }
        println("${result.first().title} by ${result.first().singer}")
    }
}