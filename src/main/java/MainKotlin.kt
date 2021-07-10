class MainKotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Main.functionJava("Hello from Kotlin!"))
        }

        @JvmStatic
        fun functionKotlin(param: String) = "KOTLIN[$param]"
    }
}
