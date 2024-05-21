-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: focus
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `quote_of_the_day`
--

DROP TABLE IF EXISTS `quote_of_the_day`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quote_of_the_day` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quote` varchar(255) NOT NULL,
  `author` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quote_of_the_day`
--

LOCK TABLES `quote_of_the_day` WRITE;
/*!40000 ALTER TABLE `quote_of_the_day` DISABLE KEYS */;
INSERT INTO `quote_of_the_day` VALUES (1,'Habits are the building blocks of our lives.','Unknown'),(2,'We are what we repeatedly do. Excellence, then, is not an act, but a habit.','Aristotle'),(3,'Your net worth to the world is usually determined by what remains after your bad habits are subtracted from your good ones.','Benjamin Franklin'),(4,'The chains of habit are too weak to be felt until they are too strong to be broken.','Samuel Johnson'),(5,'Winning is a habit. Unfortunately, so is losing.','Vince Lombardi'),(6,'Motivation is what gets you started. Habit is what keeps you going.','Jim Ryun'),(7,'Habit is a cable; we weave a thread each day, and at last we cannot break it.','Horace Mann'),(8,'We first make our habits, and then our habits make us.','John Dryden'),(9,'Your beliefs become your thoughts, your thoughts become your words, your words become your actions, your actions become your habits, your habits become your values, your values become your destiny.','Mahatma Gandhi'),(10,'You will never change your life until you change something you do daily.','John C. Maxwell'),(11,'The difference between an amateur and a professional is in their habits. An amateur has amateur habits. A professional has professional habits. We can never free ourselves from habit. But we can replace bad habits with good ones.','Steven Pressfield'),(12,'Good habits are worth being fanatical about.','John Irving'),(13,'Habits change into character.','Ovid'),(14,'Habit is either the best of servants or the worst of masters.','Nathaniel Emmons'),(15,'The difference between successful people and unsuccessful people is that successful people do what unsuccessful people are not willing to do.','Unknown'),(16,'You can\'t make a habit of success without making a habit of hard work.','Unknown'),(17,'Discipline is the bridge between goals and accomplishment. Without discipline, there is no achievement.','Unknown'),(18,'The only way to do great work is to love what you do. If you haven\'t found it yet, keep looking. Don\'t settle.','Steve Jobs'),(19,'Your habits will determine your future, so choose them wisely.','Unknown'),(20,'Successful people are simply those with successful habits.','Brian Tracy'),(21,'It\'s not what we do once in a while that shapes our lives, but what we do consistently.','Tony Robbins'),(22,'Good habits formed at youth make all the difference.','Aristotle'),(23,'The secret of change is to focus all of your energy, not on fighting the old, but on building the new.','Socrates'),(24,'The best way to change your life is to change your habits.','Unknown'),(25,'Successful people are simply those with successful habits.','Unknown'),(26,'We are what we repeatedly do. Excellence, then, is not an act, but a habit.','Will Durant'),(27,'The chains of habit are generally too small to be felt until they are too strong to be broken.','Samuel Johnson'),(28,'You are what you do repeatedly. Therefore, excellence ought to be a habit, not an act.','Aristotle'),(29,'The best way to predict your future is to create it.','Abraham Lincoln'),(30,'Chains of habit are too light to be felt until they are too heavy to be broken.','Warren Buffett'),(31,'You\'ll never change your life until you change something you do daily. The secret of your success is found in your daily routine.','John C. Maxwell'),(32,'Successful people do what unsuccessful people are not willing to do. Don\'t wish it were easier; wish you were better.','Jim Rohn'),(33,'Excellence is not an act, but a habit. The things you do the most are the things you will do the best.','Marva Collins'),(34,'If you want to be successful, you must be willing to be uncomfortable.','Unknown'),(35,'The only way to do great work is to love what you do. If you haven\'t found it yet, keep looking. Don\'t settle.','Steve Jobs'),(36,'First we make our habits, then our habits make us.','Charles C. Noble'),(37,'Good habits are the key to all success. Bad habits are the unlocked door to failure.','Og Mandino'),(38,'Excellence is not a skill. It is an attitude.','Ralph Marston'),(39,'We are what we repeatedly do. Excellence, then, is not an act, but a habit.','Unknown'),(40,'Habit is a second nature which prevents us from knowing the first, of which it has neither the cruelties nor the enchantments.','Marcel Proust'),(41,'Addiction is a monster; it lives inside, and feeds on you every day. But you can learn to control it, and it won\'t have the power to destroy you anymore.','Unknown'),(42,'The first step towards getting somewhere is to decide that you are not going to stay where you are.','Unknown'),(43,'Addiction is not a choice. But recovery is.','Unknown'),(44,'The best way to break a bad habit is to drop it.','Leo Aikman'),(45,'You will never change your life until you change something you do daily.','Mike Murdock'),(46,'Addiction begins with the hope that something \"out there\" can instantly fill up the emptiness inside.','Jean Kilbourne'),(47,'Addiction is a family disease; one person may use, but the whole family suffers.','Unknown'),(48,'I hated every minute of training, but I said, \'Don\'t quit. Suffer now and live the rest of your life as a champion.\'','Muhammad Ali'),(49,'The biggest and most rewarding addiction in life is the addiction to improving yourself.','Unknown'),(50,'Addiction is a choice but a choice that is increasingly difficult to resist.','Unknown'),(51,'The only way to get rid of a temptation is to yield to it.','Oscar Wilde'),(52,'Addiction is a condition that can be treated, and the right treatment can lead to a full recovery.','Unknown'),(53,'Every addiction arises from an unconscious refusal to face and move through your own pain. Every addiction starts with pain and ends with pain.','Eckhart Tolle'),(54,'Your future is created by what you do today, not tomorrow.','Robert Kiyosaki'),(55,'Recovery is not about being perfect. It\'s about learning to accept and love yourself, flaws and all.','Unknown'),(56,'The only way to do great work is to love what you do. If you haven\'t found it yet, keep looking. Don\'t settle.','Steve Jobs'),(57,'Addiction is not a moral failing; it is a disease that can be treated.','Unknown'),(58,'A person who thinks all the time has nothing to think about except thoughts. So, he loses touch with reality, and lives in a world of illusions.','Alan Watts'),(59,'Addiction is a disease, not a moral failing. We need to treat it with compassion and understanding, not judgment and punishment.','Unknown'),(60,'Addiction is a prison. Recovery is a journey to freedom.','Unknown'),(61,'We are what we repeatedly do. Excellence, then, is not an act, but a habit.','Aristotle'),(62,'Addiction doesn\'t just affect the addict; it affects everyone around them.','Unknown'),(63,'You can\'t go back and change the beginning, but you can start where you are and change the ending.','C.S. Lewis'),(64,'Addiction is a chronic disease that requires ongoing management, but it is also a disease that can be overcome with the right help and support.','Unknown');
/*!40000 ALTER TABLE `quote_of_the_day` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-01  0:03:31
