//WIP 
/**
* Get the longest strings of a list of Strings 
* The catch is that the longest words must NO have repeated characters
* @input a list of not-null strings 
* @returns a list of longest words (after cleaning must be different among themselves)
*/


fun String.clean() : String {
    val setChars = mutableSetOf<Char>()
    this.map{ char ->
        setChars.add(char)
    }
    return setChars.toString()
}

fun getLongestString(input: List<String>) : List<String> {
	val map = mutableMapOf<Int, MutableList<String>>()
    input.forEach{ word -> 
        val cleaned = word.clean()
		map[cleaned.length]?.let{
            it.add(cleaned)
            map[cleaned.length] = it
        } ?: run {
            map[cleaned.length] = mutableListOf(cleaned)
        } 
//        map[word.length] = listOf(word)
    }
    println(map)
    val output = map.keys.maxOrNull()?.let{
        map[it]
    }
    
    println(output)
    return output ?: listOf()
//    output.add("abc")
  //  output.add("bcd")
    //return output
}
