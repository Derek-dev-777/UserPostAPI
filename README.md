# UserPostAPI
```mermaid
classDiagram
UserEntity "1" --> "" PostEntity : posts
UserEntity "1" --> "" CommentEntity : comments
PostEntity "1" --> "*" CommentEntity : comments
class UserEntity {
    +Long id
    +String name
    +String email
    +String password
    +LocalDateTime date
    +List~PostEntity~ posts
    +List~CommentEntity~ comments
}

class PostEntity {
    +Long id
    +String title
    +String content
    +LocalDateTime date
    +UserEntity userAuthor
    +List~CommentEntity~ comments
}

class CommentEntity {
    +Long id
    +String content
    +LocalDateTime date
    +UserEntity userAuthor
    +PostEntity post
}
