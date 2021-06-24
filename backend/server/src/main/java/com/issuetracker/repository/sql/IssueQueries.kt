package com.issuetracker.repository.sql

const val FIND_ALL_ISSUE: String = """
SELECT id, title, content, writerId, statusId, milestoneId, createdDate 
FROM issue;
"""
