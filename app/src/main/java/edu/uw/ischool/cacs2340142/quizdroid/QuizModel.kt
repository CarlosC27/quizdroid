package edu.uw.ischool.cacs2340142.quizdroid

import androidx.lifecycle.*

data class  Question(
    val questionDes: String,
    val questionOptions: List<String>,
    val answer: String
)

data class Topic(
    val topicTitle: String,
    val topicDescription: String,
    val numberOfQuestions: Int,
    val questions: List<Question>,
    val imageId: Int
)

class QuizModel(val topicRepository: TopicRepositoryHC) : ViewModel() {
    val topics = listOf(
        Topic(
            topicTitle = "Math",
            topicDescription = "The study of numbers, quantities, shapes, structures, and their relationships through abstract and logical reasoning. " +
                    "It provides a universal language for describing patterns and solving problems in various fields, from science and engineering, and everyday life. ",
            numberOfQuestions = 7,
            questions = listOf(
                Question("What is the value of 8+7?", listOf("13", "14", "15", "16"), "15"),
                Question("If x =5, what is the value 3x+2?", listOf("12", "15", "17", "20"), "17"),
                Question("What is the square root of 169?", listOf("13", "15", "11", "14"), "13"),
                Question(
                    "What is the area of a triangle with a base of 10 units and height of 6 units?",
                    listOf(
                        "15 square units",
                        "30 square units",
                        "60 square units",
                        "90 square units"
                    ), "30 square units"
                ),
                Question(
                    "What is the value of 13 + 1989 + 12?",
                    listOf("2013", "2020", "2009", "2014"),
                    "2014"
                ),
                Question(
                    "What is the limit of the equation as x approaches zero, 1/x ?",
                    listOf("The limit does not exists", "zero", "one", "infinity"),
                    "The limit does not exists"
                ),
                Question("What is the value of 2 x 27?", listOf("64", "54", "56", "44"), "54")
            ),
            imageId = R.drawable.math
        ),
        Topic(
            topicTitle = "Physics",
            topicDescription = "The scientific study of matter, energy, and the fundamental forces that govern their interactions. It explores everything from the smallest particles, like atoms and quarks, to the vastness of galaxies and the universe.",
            numberOfQuestions = 5,
            questions = listOf(
                Question(
                    "What is the acceleration due to gravity on Earth (approximately)?",
                    listOf("8.8m/s^2", "9.8m/s^2", "10.8m/s^2", "11.8m/s^2"),
                    "9.8m/s^2"
                ),
                Question(
                    "Which of the following is an example of a vector quantity?",
                    listOf("Speed", "Distance", "Mass", "Velocity"),
                    "Velocity"
                ),
                Question(
                    "If a car has a constant speed of 20 m/s and travels for 4 seconds, how far does it go?",
                    listOf("60 m", "80 m", "100 m", "120 m"),
                    "80 m"
                ),
                Question(
                    "Which theory states that time slows down as an object approaches the speed of light?",
                    listOf(
                        "Quantum Mechanics",
                        "General Relativity",
                        "Special Relativity",
                        "Newtonian Mechanics"
                    ),
                    "Special Relativity"
                ),
                Question(
                    "Which of the following is a unit of force?",
                    listOf("Newton", "Joule", "Watt", "Volt"),
                    "Newton"
                )
            ),
            imageId = R.drawable.physics
        ),
        Topic(
            topicTitle = "Marvel Superheroes",
            topicDescription = "Marvel superheroes are a diverse group of fictional characters created by Marvel Comics, known for their unique powers, rich backstories, and the complex, interconnected universe they inhabit.",
            numberOfQuestions = 10,
            questions = listOf(
                Question(
                    "Which powerful book does Scarlet Witch acquire at the end of WandaVision?",
                    listOf(
                        "The Book of Vishanti",
                        "The Darkhold",
                        "The Necronomicon",
                        "The Infinity Codex"
                    ),
                    "The Darkhold"
                ),
                Question(
                    "Which of these characters is known as the 'Sorcerer Supreme'?",
                    listOf("Doctor Strange", "Iron Fist", "Wong", "Loki"),
                    "Doctor Strange"
                ),
                Question(
                    "Who is known as the 'Merc with a Mouth'?",
                    listOf("Deadpool", "Wolverine", "Hawkeye", "Venom"),
                    "Deadpool"
                ),
                Question(
                    "What does Tony Stark use to power his Iron Man suit?",
                    listOf(
                        "A nuclear reactor",
                        "A cosmic cube",
                        "An arc reactor",
                        "Vibranium core"
                    ),
                    "An arc reactor"
                ),
                Question(
                    "Which Marvel superhero is also the King of Wakanda?",
                    listOf("Blade", "Black Panther", "Falcon", "War Machine"),
                    "Black Panther"
                ),
                Question(
                    "What is the name of Thor’s hammer?",
                    listOf("Stormbreaker", "Gungnir", "Mjolnir", "Heimdall"),
                    "Mjolnir"
                ),
                Question(
                    "Which metal is Captain America’s shield made from?",
                    listOf("Adamantium", "Vibranium", "Titanium", "Steel"),
                    "Vibranium"
                ),
                Question(
                    "What is Spider-Man's real name?",
                    listOf("Peter Parker", "Tony Stark", "Steve Rogers", "Bruce Banner"),
                    "Peter Parker"
                ),
                Question(
                    "What is the name of Scarlet Witch and Vision's twin sons in the comics?",
                    listOf(
                        "Tommy and Billy",
                        "Peter and Paul",
                        "Hank and Scott",
                        "Bruce and Steve"
                    ),
                    "Tommy and Billy"
                ),
                Question(
                    "What is Yelena Belova’s relationship to Natasha Romanoff in the Marvel Cinematic Universe?",
                    listOf("Sister", "Cousin", "Childhood friend", "Nemesis"),
                    "Sister"
                )
            ),
            imageId = R.drawable.marvel
        ),
        Topic(
            topicTitle = "Taylor Swift",
            topicDescription = "Taylor Swift is a singer-songwriter known for her storytelling prowess, versatile musical style, and profound impact on pop and country music. Her early albums, like Taylor Swift and Fearless, solidified her " +
                    "as a country star. Swift then transitioned into pop with Red and 1989.",
            numberOfQuestions = 13,
            questions = listOf(
                Question(
                    "What is Taylor Swift’s birth year?",
                    listOf("1987", "1988", "1989", "1990"),
                    "1989"
                ),
                Question(
                    "In which city did Taylor Swift start her music career?",
                    listOf("Los Angeles", "Nashville", "New York", "Chicago"),
                    "Nashville"
                ),
                Question(
                    "Which album marked Taylor Swift’s transition from country to pop?",
                    listOf("Fearless", "Speak Now", "Red", "1989"),
                    "1989"
                ),
                Question(
                    "Which Taylor Swift song features the lyrics “You’re on the phone with your girlfriend, she’s upset”?",
                    listOf("Love Story", "You Belong with Me", "White Horse", "Fifteen"),
                    "You Belong with Me"
                ),
                Question(
                    "Which song won Taylor Swift her first Grammy for Album of the Year?",
                    listOf("Fearless", "Red", "1989", "Lover"),
                    "Fearless"
                ),
                Question(
                    "What is Taylor Swift’s fanbase called?",
                    listOf("Swifties", "T-Squad", "Taylorettes", "Swift Army"),
                    "Swifties"
                ),
                Question(
                    "What was the first re-recorded album Taylor Swift released?",
                    listOf(
                        "Speak Now (Taylor’s Version)",
                        "Fearless (Taylor’s Version)",
                        "Red (Taylor’s Version)",
                        "1989 (Taylor’s Version)"
                    ), "Fearless (Taylor’s Version)"
                ),
                Question(
                    "Taylor Swift’s “All Too Well (10 Minute Version)” was released on which album?",
                    listOf("Red (Taylor’s Version)", "1989", "Lover", "Folklore"),
                    "Red (Taylor’s Version)"
                ),
                Question(
                    "Who is Taylor Swift's collaborator on the song “Exile”?",
                    listOf(
                        "Ed Sheeran",
                        "Justin Vernon (Bon Iver)",
                        "Shawn Mendes",
                        "Jack Antonoff"
                    ),
                    "Justin Vernon (Bon Iver)"
                ),
                Question(
                    "Taylor Swift was the first female solo artist to win which award three times?",
                    listOf(
                        "Grammy for Best New Artist",
                        "Grammy for Record of the Year",
                        "Grammy for Album of the Year",
                        "Grammy for Song of the Year"
                    ),
                    "Grammy for Album of the Year"
                ),
                Question(
                    "Who directed the short film for “All Too Well (10 Minute Version)”?",
                    listOf("Taylor Swift", "Joseph Kahn", "Spike Jonze", "Sophie Muller"),
                    "Taylor Swift"
                ),
                Question(
                    "Which music video did Taylor Swift co-direct with actor Blake Lively?",
                    listOf(
                        "You Need to Calm Down",
                        "Cardigan",
                        "I Bet You Think About Me",
                        "The Man"
                    ),
                    "I Bet You Think About Me"
                ),
                Question(
                    "Taylor Swift broke which record with her album Midnights in 2022?", listOf(
                        "Most Grammy nominations in one year",
                        "Most songs in the Billboard Hot 100 at once",
                        "Longest time at No. 1 on the Billboard 200",
                        "Most weeks in the Billboard Top 10"
                    ), "Most songs in the Billboard Hot 100 at once"
                )
            ),
            imageId = R.drawable.taylorswift
        ),
        Topic(
            topicTitle = "Pokemon",
            topicDescription = "In the world of Pokémon, our everyday lives are filled with the companionship and wonder of incredible creatures known as Pokémon.",
            numberOfQuestions = 8,
            questions = listOf(
                Question(
                    "Who is the first Pokémon in the National Pokédex?",
                    listOf("Charmander", "Pikachu", "Bulbasaur", "Snorlax"),
                    "Bulbasaur"
                ),
                Question(
                    "Which Pokémon is known as the “Evolution Pokémon”?",
                    listOf("Pikachu", "Eevee", "Bulbasaur", "Charmander"), "Eevee"
                ),
                Question(
                    "Which of these Pokémon is a Water type?",
                    listOf("Charmander", "Bulbasaur", "Squirtle", "Pikachu"),
                    "Squirtle"
                ),
                Question(
                    "Which Legendary Pokémon represents Time?",
                    listOf("Palkia", "Dialga", "Celebi", "Jirachi"),
                    "Dialga"
                ),
                Question(
                    "What type is Togepi?",
                    listOf("Fairy", "Normal", "Fairy/Normal", "Psychic"),
                    "Fairy"
                ),
                Question(
                    "Which Legendary Pokémon is known for its ability to control the seas?",
                    listOf("Groudon", "Lugia", "Kyogre", "Suicune"),
                    "Kyogre"
                ),
                Question(
                    "Which Legendary Pokémon trio is known as the “Legendary Beasts”?",
                    listOf(
                        "Raikou, Entei, and Suicune",
                        "Articuno, Zapdos, and Moltres",
                        "Uxie, Mesprit, and Azelf",
                        "Regirock, Regice, and Registeel"
                    ), "Raikou, Entei, and Suicune"
                ),
                Question(
                    "What type combination does Garchomp have?",
                    listOf("Dragon/Ground", "Dragon/Flying", "Ground/Rock", "Dragon/Steel"),
                    "Dragon/Ground"
                )
            ),
            imageId = R.drawable.pokemon
        )
    )
    var currentTopic: TopicHC? = null
    var currentQuestionIndex: Int = 0
    var correctAnswers: Int = 0
    var myAnswer: String? = null

    fun setTopic(name: String) {
        currentTopic = topicRepository.getTopics().find { it.topicTitle == name }
        currentQuestionIndex = 0
        correctAnswers = 0
        myAnswer = null
    }

    fun getCurrentQuestion(): QuestionHC? {
        return currentTopic?.questions?.getOrNull(currentQuestionIndex)
    }

    val totalQuestions: Int
        get() = currentTopic?.questions?.size ?: 0

    fun isAnswerCorrect(): Boolean {
        val question = getCurrentQuestion()
        return question?.correctAnswer == myAnswer
    }

    fun submitAnswer(answer: String) {
        myAnswer = answer
        if (isAnswerCorrect()) {
            correctAnswers++
        }
    }

    fun moveToNextQuestion() {
        if (currentQuestionIndex < (currentTopic?.questions?.size ?: 0) - 1) {
            currentQuestionIndex++
        }
        myAnswer = null
    }

    fun isLastQuestion(): Boolean {
        return currentQuestionIndex == (currentTopic?.questions?.size ?: 0) - 1
    }

    fun getTopic(name: String): TopicHC? {
        return topicRepository.getTopics().find { it.topicTitle == name }
    }

    fun goBackQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex -= 1
            // Adjust correctAnswers if going back
            val currentQuestionObj = getCurrentQuestion()
            if (currentQuestionObj != null && myAnswer == currentQuestionObj.correctAnswer) {
                correctAnswers = maxOf(0, correctAnswers - 1)
            }
        }
        myAnswer = null
    }

    fun resetQuizProgress() {
        currentQuestionIndex = 0
        correctAnswers = 0
        myAnswer = null
    }

    fun isFirstQuestion(): Boolean {
        return currentQuestionIndex == 0
    }
}