package com.issuetracker.repository.sql

const val FIND_ALL_LABEL: String = """
    
SELECT title, description, backgroundColor, textColor 
FROM `label`;
    
"""

const val FIND_ALL_LABEL_BY_ISSUE_ID: String = """
    
SELECT *
FROM issueLabel
         INNER JOIN label l on issueLabel.labelId = l.id
WHERE issueLabel.issueId = :issueId;
    
"""
