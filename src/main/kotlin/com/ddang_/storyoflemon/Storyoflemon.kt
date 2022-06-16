package com.ddang_.storyoflemon

import com.ddang_.storyoflemon.listeners.BasicListener
import com.ddang_.storyoflemon.managers.MemberManager
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler

class Storyoflemon : JavaPlugin() {
    companion object {
        fun String.info() = Bukkit.getLogger().info(this)
        fun String.warn() = Bukkit.getLogger().warning(this)
        fun String.broad() = Bukkit.broadcastMessage(this)


        fun Long.rt(delay: Long = 1, run: Runnable) = scheduler.runTaskTimer(instance, run, delay, this)
        fun Long.rtAsync(delay: Long = 1, run: Runnable) = scheduler
            .runTaskTimerAsynchronously(instance, run, delay, this)
        fun rAsync(run: Runnable) = scheduler.runTaskAsynchronously(instance, run)
        fun r(run: Runnable) = scheduler.runTask(instance, run)
        fun Long.rl(run: Runnable) = scheduler.runTaskLater(instance, run, this)
        fun Long.rlAsync(run: Runnable) = scheduler.runTaskLaterAsynchronously(instance, run, this)

        //인스턴스 필드
        lateinit var instance: Plugin
        lateinit var scheduler: BukkitScheduler
            private set
        lateinit var players: MutableCollection<out Player>
            private set
    }

    fun memberSet() {
        players.forEach {
            MemberManager.set(it)
        }
    }

    fun memberRemove() {
        players.forEach {
            MemberManager.remove(it)
        }
    }

    //이벤트 목록
    private val events = arrayOf(
        BasicListener()
    )

    override fun onEnable() {
        //인스턴스 잡아주기
        players = server.onlinePlayers
        instance = this
        scheduler = server.scheduler
        val w = Bukkit.getWorld("world")!!

        //이벤트 등록
        server.pluginManager.apply { events.forEach { registerEvents(it, this@Storyoflemon) } }

        //전체 멤버
        memberSet()
    }

    override fun onDisable() {
        memberRemove()
    }
}