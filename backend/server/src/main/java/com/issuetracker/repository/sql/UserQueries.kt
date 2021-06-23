package com.issuetracker.repository.sql

const val FIND_ALL_USER: String = """
    
SELECT id AS userId, name, profileImageUrl
FROM user;
    
"""

const val FIND_ALL_EMAILS: String = """
SELECT *
FROM email
WHERE userId = :userId;
"""

const val SAVE_USER: String = """
    
INSERT INTO `user` (`id`, `name`, `profileImageUrl`)
VALUES (:id, :name, :profileImageUrl)
ON DUPLICATE KEY UPDATE `name` = :name, 
                        `profileImageUrl` = :profileImageUrl;
    
"""
