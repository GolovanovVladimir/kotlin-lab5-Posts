package ru.netology

import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun wallServiceAdd() {
        val post = Post(1,1,1,1,1,"cheking",1,1,1,"lya-lya",true,true,1)
        WallService.Add(post)
        val result: Double = post.id.toDouble()
        assertEquals(1.0, result, 0.0)
    }

    @Test
    fun wallServiceUpdateFalse() {
        val post = Post(1,1,1,1,1,"cheking",1,1,1,"lya-lya",true,true,1)
        val result = WallService.update(post)
        assertEquals(true, result)
    }

    @Test
    fun wallServiceUpdateTrue() {
        val post = Post(1,1,1,1,1,"cheking",1,1,1,"lya-lya",true,true,1)
        WallService.Add(post)
        val result = WallService.update(post)
        assertEquals(true, result)
    }

}