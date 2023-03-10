package ru.netology

fun main() {
   val post = Post(1,1,1,1,1,"cheking",1,1,1,"lya-lya",true,true,1)
   val post2 = Post(2,2,2,2,2,"cheking",2,2,2,"lya-lya",true,true,2)
   val post3 = Post(3,3,3,2,3,"cheking",3,3,3,"lya-lya",true,true,3)

   val liked = post.copy(likes = post.likes + 1)
   println(liked)
   val (id, owner_id,_,_,_,text) = post
   println("$id, $owner_id, $text")
   WallService.Add(post)
   WallService.Add(post2)
   WallService.update(post2)
   WallService.update(post3)
   WallService.printPosts()

}

data class Post(
   val id: Int,
   val owner_id: Int,
   val from_id: Int,
   val created_by: Int,
   val date: Int,
   val text: String,
   val reply_owner_id: Int,
   val reply_post_id: Int,
   val friends_only: Int,
   var comments: String,
   val marked_as_ads: Boolean,
   val is_favorite: Boolean,
   val likes: Int = 0
)


class Comments(
   val count: Int,
   val can_post: Boolean,
   val groups_can_post: Boolean)
   {
   }

object WallService{
   private var posts = emptyArray<Post>()

   fun Add(post: Post): Post {
      println("Post added")
      posts += post
      val postAdded = post.copy(id = (WallService.uniqueNumberId(post.id) ))
      return postAdded
   //   добавлять запись в массив, но при этом назначать посту уникальный среди всех постов идентификатор;
   //   возвращать пост с уже выставленным идентификатором.
   }

   fun findById(id: Int) : Boolean {
      var flagExist : Boolean = false
      for ((index,post) in posts.withIndex()){
         if (post.id == id) flagExist = true
      }
      return flagExist
   }

   fun uniqueNumberId(id: Int) : Int {
      var maxId : Int = -1
      for ((index,post) in posts.withIndex()){
         if (post.id > maxId) maxId = post.id
      }
      return maxId + 1
   }

   fun update(post: Post): Boolean {
      println("Post updated")
      if (findById(post.id)==true) {
         post.comments= "Updated"
         return true
      }
      else {
         return false
      }
   //находить среди всех постов запись с тем же id, что и у post и обновлять все свойства, кроме id владельца и даты создания;
   // если пост с таким id не найден, то ничего не происходит и возвращается false, в противном случае – возвращается true.
   }
   fun printPosts(){
      for (post in posts){
         println(post)
      }
      println()
   }
}