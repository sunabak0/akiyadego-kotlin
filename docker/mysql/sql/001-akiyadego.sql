CREATE TABLE `users` (
  `uuid` CHAR(36) NOT NULL,
  `name` CHAR(64) NOT NULL,
  `email` CHAR(255) NOT NULL,
  `password` CHAR(255) NOT NULL,
  `registered_at` datetime(6) NOT NULL,
  `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)
);

CREATE TABLE `posts` (
  `uuid` CHAR(36) NOT NULL,
  `title` CHAR(255) NOT NULL,
  `category` CHAR(64) NOT NULL,
  `prefecture` CHAR(8) NOT NULL,
  `description` text NOT NULL,
  `user_uuid` CHAR(36) NOT NULL,
  `posted_at` datetime(6) NOT NULL,
  `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
  `updated_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6)
);

CREATE TABLE `sessions` (
  `uuid` CHAR(36) NOT NULL,
  `user_uuid` CHAR(36) NOT NULL,
  `created_at` datetime(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
);
