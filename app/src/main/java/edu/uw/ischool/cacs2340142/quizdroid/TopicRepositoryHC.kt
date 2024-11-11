package edu.uw.ischool.cacs2340142.quizdroid

 class TopicRepositoryHC: TopicRepository {

    private val topics = listOf(
        Topic(
            topicTitle = "Math",
            topicDescription = "The study of numbers, quantities, shapes, structures, and their relationships through abstract and logical reasoning. " +
                    "It provides a universal language for describing patterns and solving problems in various fields, from science and engineering, to everyday life.",
            numberOfQuestions = 7,
            questions = listOf(
                Question("What is the value of 8+7?", listOf("13", "14", "15", "16"), "15"),
                Question("If x = 5, what is the value 3x + 2?", listOf("12", "15", "17", "20"), "17"),
                Question("What is the square root of 169?", listOf("13", "15", "11", "14"), "13"),
                Question("What is the area of a triangle with a base of 10 units and height of 6 units?",
                    listOf("15 square units", "30 square units", "60 square units", "90 square units"), "30 square units"),
                Question("What is the value of 13 + 1989 + 12?", listOf("2013", "2020", "2009", "2014"), "2014"),
                Question("What is the limit of the equation as x approaches zero, 1/x?", listOf("The limit does not exist", "zero", "one", "infinity"), "The limit does not exist"),
                Question("What is the value of 2 x 27?", listOf("64", "54", "56", "44"), "54")
            ),
            imageId = R.drawable.math
        ),
        Topic(
            topicTitle = "Physics",
            topicDescription = "The scientific study of matter, energy, and the fundamental forces that govern their interactions. It explores everything from the smallest particles, like atoms and quarks, to the vastness of galaxies and the universe.",
            numberOfQuestions = 5,
            questions = listOf(
                Question("What is the acceleration due to gravity on Earth (approximately)?", listOf("8.8 m/s²", "9.8 m/s²", "10.8 m/s²", "11.8 m/s²"), "9.8 m/s²"),
                Question("Which of the following is an example of a vector quantity?", listOf("Speed", "Distance", "Mass", "Velocity"), "Velocity"),
                Question("If a car has a constant speed of 20 m/s and travels for 4 seconds, how far does it go?", listOf("60 m", "80 m", "100 m", "120 m"), "80 m"),
                Question("Which theory states that time slows down as an object approaches the speed of light?", listOf("Quantum Mechanics", "General Relativity", "Special Relativity", "Newtonian Mechanics"), "Special Relativity"),
                Question("Which of the following is a unit of force?", listOf("Newton", "Joule", "Watt", "Volt"), "Newton")
            ),
            imageId = R.drawable.physics
        ),
        Topic(
            topicTitle = "Marvel Superheroes",
            topicDescription = "Marvel superheroes are a diverse group of fictional characters created by Marvel Comics, known for their unique powers, rich backstories, and the complex, interconnected universe they inhabit.",
            numberOfQuestions = 10,
            questions = listOf(
                Question("Which powerful book does Scarlet Witch acquire at the end of WandaVision?", listOf("The Book of Vishanti", "The Darkhold", "The Necronomicon", "The Infinity Codex"), "The Darkhold"),
                Question("Which of these characters is known as the 'Sorcerer Supreme'?", listOf("Doctor Strange", "Iron Fist", "Wong", "Loki"), "Doctor Strange"),
                Question("Who is known as the 'Merc with a Mouth'?", listOf("Deadpool", "Wolverine", "Hawkeye", "Venom"), "Deadpool"),
                Question("What does Tony Stark use to power his Iron Man suit?", listOf("A nuclear reactor", "A cosmic cube", "An arc reactor", "Vibranium core"), "An arc reactor"),
                Question("Which Marvel superhero is also the King of Wakanda?", listOf("Blade", "Black Panther", "Falcon", "War Machine"), "Black Panther"),
                Question("What is the name of Thor’s hammer?", listOf("Stormbreaker", "Gungnir", "Mjolnir", "Heimdall"), "Mjolnir"),
                Question("Which metal is Captain America’s shield made from?", listOf("Adamantium", "Vibranium", "Titanium", "Steel"), "Vibranium"),
                Question("What is Spider-Man's real name?", listOf("Peter Parker", "Tony Stark", "Steve Rogers", "Bruce Banner"), "Peter Parker"),
                Question("What is the name of Scarlet Witch and Vision's twin sons in the comics?", listOf("Tommy and Billy", "Peter and Paul", "Hank and Scott", "Bruce and Steve"), "Tommy and Billy"),
                Question("What is Yelena Belova’s relationship to Natasha Romanoff in the Marvel Cinematic Universe?", listOf("Sister", "Cousin", "Childhood friend", "Nemesis"), "Sister")
            ),
            imageId = R.drawable.marvel
        ),
        Topic(
            topicTitle = "Taylor Swift",
            topicDescription = "Taylor Swift is a singer-songwriter known for her storytelling prowess, versatile musical style, and profound impact on pop and country music. Her early albums, like Taylor Swift and Fearless, solidified her as a country star. Swift then transitioned into pop with Red and 1989.",
            numberOfQuestions = 13,
            questions = listOf(
                Question("What is Taylor Swift’s birth year?", listOf("1987", "1988", "1989", "1990"), "1989"),
                Question("In which city did Taylor Swift start her music career?", listOf("Los Angeles", "Nashville", "New York", "Chicago"), "Nashville"),
                // Additional questions follow here...
            ),
            imageId = R.drawable.taylorswift
        ),
        Topic(
            topicTitle = "Pokemon",
            topicDescription = "In the world of Pokémon, our everyday lives are filled with the companionship and wonder of incredible creatures known as Pokémon.",
            numberOfQuestions = 8,
            questions = listOf(
                Question("Who is the first Pokémon in the National Pokédex?", listOf("Charmander", "Pikachu", "Bulbasaur", "Snorlax"), "Bulbasaur"),
                // Additional questions follow here...
            ),
            imageId = R.drawable.pokemon
        )
    )

    override fun getTopics(): List<Topic> {
        return topics
    }

    override fun getTopic(title: String): Topic? {
        for (topic in topics) {
            if (topic.topicTitle == title) {
                return topic
            }
        }
        return null
    }

}