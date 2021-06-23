package com.issuetracker.repository.sql

const val FIND_ALL_COMMENT_BY_ISSUE_ID: String = """
    
SELECT dateTime, comment.writerId, comment.content, name, email, profileImageUrl
FROM comment
         INNER JOIN user ON comment.writerId = user.id
         INNER JOIN email ON user.id = email.userId
         INNER JOIN issue ON comment.issueId = issue.id
WHERE 1=1
AND comment.issueId = :issueId
AND NOT email.email REGEXP 'users.noreply.github.com';
    
"""
