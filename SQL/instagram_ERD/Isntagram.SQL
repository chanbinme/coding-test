CREATE TABLE `users` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(50),
  `password` varchar(50),
  `gender` char
);

CREATE TABLE `posts` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `image` blob,
  `message` text,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `total_likes` INT DEFAULT 0,
  `total_comments` INT DEFAULT 0,
  `user_id` INT
);

CREATE TABLE `post_comments` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `comments` varchar(255),
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `user_id` INT,
  `post_id` INT
);

CREATE TABLE `post_likes` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `post_id` INT,
  `user_id` INT
);

CREATE TABLE `follow_follower` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `follower_id` INT,
  `user_id` INT
);

CREATE TABLE `posts_hashtags` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `hashtag_id` INT,
  `post_id` INT
);

CREATE TABLE `hashtags` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` CHAR(50)
);

CREATE TABLE `follow_following` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `following_id` INT,
  `user_id` INT
);

ALTER TABLE `posts` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `follow_follower` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `follow_follower` ADD FOREIGN KEY (`follower_id`) REFERENCES `users` (`id`);

ALTER TABLE `post_comments` ADD FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`);

ALTER TABLE `post_comments` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `post_likes` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `post_likes` ADD FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`);

ALTER TABLE `posts_hashtags` ADD FOREIGN KEY (`hashtag_id`) REFERENCES `hashtags` (`id`);

ALTER TABLE `posts_hashtags` ADD FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`);

ALTER TABLE `follow_following` ADD FOREIGN KEY (`following_id`) REFERENCES `users` (`id`);

ALTER TABLE `follow_following` ADD FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
