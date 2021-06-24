package com.issuetracker.repository.sql

const val FIND_ALL_MILESTONE: String = """
SELECT id, title,description,dueDate
FROM milestone;
"""
