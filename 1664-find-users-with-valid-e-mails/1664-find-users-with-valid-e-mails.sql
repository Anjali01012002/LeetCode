SELECT user_id, name, mail
FROM users
WHERE mail LIKE BINARY '%@leetcode.com' 
AND mail REGEXP '^[a-zA-Z][a-zA-Z0-9._-]*@leetcode.com$';
