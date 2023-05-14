Rohan Patel - Data Structures Used

DataCenter
- HashSet of Strings for the dictionary for extremely quick checks to see if a word is contained in the dictionary.

Post
- LinkedList of Integers for replies to hold keys that direct to spots in the postBag. This allows easy access to replies without having to duplicate and store posts within the post class
- TreeSet of Strings that contain usernames of users that have liked that post. Used to quickly see if a user's username is contained within it to maintain consistency with liking posts.

PostBag
- TreeMap that uses incrementing Integers as keys for posts. Used for quick retrieval and maintaining order with the structure of its keys.

User
- TreeSets of Strings that contain the followers and the following of a user. A set is used for the extremely quick lookup time to see if a user is contained within the set.

UserBag
- TreeMap that uses Strings as keys and User objects as the object. The strings are the username of the user which allows easy access, quick lookup, and simplicity.	