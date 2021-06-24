package com.issuetracker.repository.sql

const val FIND_ALL_LABEL: String = """
    
SELECT id, title, description, backgroundColor, textColor 
FROM `label`;
    
"""

const val FIND_ALL_LABEL_BY_ISSUE_ID: String = """
    
SELECT label.id, label.title, label.description, label.backgroundColor, label.textColor 
       FROM label
            INNER JOIN issueLabel ON issueLabel.labelId = label.id 
        WHERE issueLabel.issueId = :issueId; 
    
"""
